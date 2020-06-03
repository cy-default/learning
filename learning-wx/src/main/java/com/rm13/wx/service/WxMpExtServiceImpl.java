package com.rm13.wx.service;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.WxType;
import me.chanjar.weixin.common.error.WxError;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.util.DataUtils;
import me.chanjar.weixin.common.util.http.RequestExecutor;
import me.chanjar.weixin.mp.api.impl.WxMpServiceHttpClientImpl;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;

import java.io.IOException;

import static me.chanjar.weixin.mp.enums.WxMpApiUrl.Other.GET_ACCESS_TOKEN_URL;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/2
 */
@Slf4j
public class WxMpExtServiceImpl extends WxMpServiceHttpClientImpl {

    @Override
    public String getAccessToken(boolean forceRefresh) throws WxErrorException {

        WxMpConfigStorage config = this.getWxMpConfigStorage();
        if (!config.isAccessTokenExpired() && !forceRefresh) {
            return config.getAccessToken();
        }
        String result = refreshAccessToken(config);
        return result;
    }

    /**
     * 采用redis 实现分布式锁
     *
     * @param config
     * @return
     * @throws WxErrorException
     */
    private String refreshAccessToken(WxMpConfigStorage config) throws WxErrorException {
        // TODO 待完善 加锁 begin
        String url = String.format(GET_ACCESS_TOKEN_URL.getUrl(config), config.getAppId(), config.getSecret());
        try {
            HttpGet httpGet = new HttpGet(url);
            if (this.getRequestHttpProxy() != null) {
                RequestConfig requestConfig = RequestConfig.custom().setProxy(this.getRequestHttpProxy()).build();
                httpGet.setConfig(requestConfig);
            }
            try (CloseableHttpResponse response = getRequestHttpClient().execute(httpGet)) {
                return this.extractAccessToken(new BasicResponseHandler().handleResponse(response));
            } finally {
                httpGet.releaseConnection();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // TODO end
    }

    /**
     * 采用redis 实现分布式锁
     *
     * @param executor
     * @param uri
     * @param data
     * @param <T>
     * @param <E>
     * @return
     * @throws WxErrorException
     */
    @Override
    protected <T, E> T executeInternal(RequestExecutor<T, E> executor, String uri, E data) throws WxErrorException {

        E dataForLog = DataUtils.handleDataWithSecret(data);
        if (uri.contains("access_token=")) {
            throw new IllegalArgumentException("uri参数中不允许有access_token: " + uri);
        }

        String accessToken = getAccessToken(false);
        String uriWithAccessToken = uri + (uri.contains("?") ? "&" : "?") + "access_token=" + accessToken;

        try {
            T result = executor.execute(uriWithAccessToken, data, WxType.MP);
            log.debug("\n【请求地址】: {}\n【请求参数】：{}\n【响应数据】：{}", uriWithAccessToken, dataForLog, result);
            return result;
        } catch (WxErrorException e) {
            WxError error = e.getError();

            if (error.getErrorCode() == 42001 || error.getErrorCode() == 40001 || error.getErrorCode() == 40014) {
                // 强制设置wxMpConfigStorage它的access token过期了，这样在下一次请求里就会刷新access token
                // TODO 分布式锁 redis begin
                // TODO 可以抽象一个钩子方法， 采用模版方法的模式，让子类自定义锁的形式
                if (StringUtils.equals(this.getWxMpConfigStorage().getAccessToken(), accessToken)) {
                    this.getWxMpConfigStorage().expireAccessToken();
                }
                // TODO end

                if (this.getWxMpConfigStorage().autoRefreshToken()) {
                    return this.execute(executor, uri, data);
                }
            }

            if (error.getErrorCode() != 0) {
                log.error("\n【请求地址】: {}\n【请求参数】：{}\n【错误信息】：{}", uriWithAccessToken, dataForLog, error);
                throw new WxErrorException(error, e);
            }
            return null;
        } catch (IOException e) {
            log.error("\n【请求地址】: {}\n【请求参数】：{}\n【异常信息】：{}", uriWithAccessToken, dataForLog, e.getMessage());
            throw new WxErrorException(WxError.builder().errorMsg(e.getMessage()).build(), e);
        }

    }
}
