package com.remotes.design.template.demo3;

import lombok.extern.slf4j.Slf4j;

/**
 * 同步esb数据job
 *
 * @author wang.pengfei
 * @date 2020/4/29 15:14
 */
@Slf4j
public abstract class SyncEsbBaseJob {
/*
    private String url;

    private RestTemplate restTemplate;

    private Map<String, Object> queryParam;

    public SyncEsbBaseJob(String url, RestTemplate restTemplate, Map<String, Object> queryParam) {
        this.url = url;
        this.restTemplate = restTemplate;
        this.queryParam = queryParam == null ? new HashMap<>() : queryParam;
    }

     // 执行同步, 连续调用三次失败则中止任务 每次同步500条
    public void execute() {
        log.info("开始同步主数据信息......");
        int pageNo = 1;
        int tryTime = 1;
        while (true) {
            int res = sync(pageNo, CommonConstants.SYNC_PAGE_SIZE);
            if (res == 1) {
                pageNo++;
                tryTime = 1;
            } else if (res == 2) {
                log.info("同步数据正常结束......");
                return;
            } else if (res == 3) {
                if (tryTime == 3) {
                    log.info("同步数据异常超过连续最大重试次数结束......");
                    return;
                }
                tryTime++;
                log.info("本次同步异常, 重试次数+1, 重试中......");
            }
        }
    }

    private int sync(int pageNo, int pageSize) {
        Map<String, String> params = new LinkedHashMap<>();
        queryParam.put("isPage", 1);
        queryParam.put("pageNumber", pageNo);
        queryParam.put("pageSize", pageSize);
        params.put("queryParam", JsonUtil.toJson(queryParam));

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        HttpEntity entity = new HttpEntity(headers);

        ParameterizedTypeReference<EsbResult> responseType = new ParameterizedTypeReference<EsbResult>() {
        };
        try {
            log.info("开始调用接口, url:{}, params:{}", url, JsonUtil.toJson(params));
            ResponseEntity<EsbResult> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, responseType, params);
            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                EsbResult esbResult = responseEntity.getBody();
                if ("1001".equals(esbResult.getResCode())) {
                    List dataList = esbResult.getDataList();
                    log.info("拉取数据成功, 本次获取数量:{}", dataList == null ? 0 : dataList.size());
                    if (CollectionUtils.isNotEmpty(dataList)) {
                        handle(dataList);
                        return 1;
                    } else {
                        return 2;
                    }
                } else {
                    log.error("同步主数据返回业务异常状态码, url:{}, params:{}, response:{}", url, JsonUtil.toJson(params), JsonUtil.toJson(responseEntity));
                }
            } else {
                log.error("同步主数据返回网络异常状态码, url:{}, params:{}, response:{}", url, JsonUtil.toJson(params), JsonUtil.toJson(responseEntity));
            }
        } catch (Exception e) {
            log.error("同步主数据异常, url:{}, params:{}", url, JsonUtil.toJson(params), e);
        }
        return 3;
    }

    public abstract void handle(List dataList);

    */
}
