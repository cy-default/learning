package com.rm13.cloud.feign;

import com.rm13.cloud.mdc.MdcUtil;
import com.rm13.cloud.model.po.User;
import feign.Logger;
import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019/12/12
 */
@FeignClient(name = "feignProxy",
		url = "http://localhost:8888",
		configuration = FeignProxy.FeignProxyConfig.class
)
public interface FeignProxy extends FeignParentProxy {


	/**
	 * post请求中， form表单/json等， 参数都是@requestBody， 请求头可以通过@requestHeader设置
	 *
	 * @param user
	 * @return
	 */
	@PostMapping(value = "/feign/after1", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces =
			MediaType.APPLICATION_JSON_UTF8_VALUE)
	String after1(@RequestBody User user, @RequestHeader("ab") String ab);


	/**
	 * // @RequestParam参数形式的值都是以get请求的方式拼接到url后面，不管请求方式是post/get
	 *
	 * @param a
	 * @param b
	 * @param ab
	 * @return
	 */
	@GetMapping(value = "/feign/after2", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces =
			MediaType.APPLICATION_JSON_UTF8_VALUE)
	String after2(@RequestParam("a") String a, @RequestParam("b") String b, @RequestHeader("ab") String ab);


	@GetMapping(value = "/feign/after3", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces =
			MediaType.APPLICATION_JSON_UTF8_VALUE)
	String after3(@SpringQueryMap Map<String, String> param, @RequestHeader("ab") String ab);


	/**
	 * 使用map调用post请求， 类型定义必须是Map<String, ?>, ?是Object也不行。
	 *
	 * @param user
	 * @param ab
	 * @return
	 */
	@PostMapping(value = "/feign/after4", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces =
			MediaType.APPLICATION_JSON_UTF8_VALUE)
	String after4(@RequestBody Map<String, ?> user, @RequestHeader("ab") String ab);


	@PostMapping(value = "/feign/mapTestAfter")
	String mapTest(@RequestBody Map<String, Object> user);

	@GetMapping(value = "/feign/process/array")
	String arrayProcessTest(@RequestParam String username,@RequestParam String[] ids);

	/**
	 * bad
	 * @param name
	 * @param user
	 * @return
	 */
	@PostMapping(value = "/feign/multiJSONFeign")
	String multiJSON(@RequestParam String name,@RequestBody User user);



	class FeignProxyConfig {

		@Value("${default.feign.config.connect.timeout:10}")
		public int connectTimeOutMillis;
		@Value("${default.feign.config.read.timeout:50}")
		public int readTimeOutMillis;
		@Value("${default.feign.config.retryer.period:100}")
		public int retryerPeriod;
		@Value("${default.feign.config.retryer.period.max:1000}")
		public int retryerMaxPeriod;
		@Value("${default.feign.config.retryer.attempts.max:3}")
		public int retryerMaxAttempts;

		@Autowired
		private ObjectFactory<HttpMessageConverters> messageConverters;

		@Value("${hello:}")
		private String hello;

		/**
		 * 超时
		 *
		 * @return
		 */
		@Bean
		public Request.Options options() {
			return new Request.Options(connectTimeOutMillis, TimeUnit.SECONDS, readTimeOutMillis, TimeUnit.SECONDS, true);
		}



		/**
		 * 参数编码
		 *
		 * @return
		 */
		@Bean
		public Encoder feignFormEncoder() {
			return new SpringFormEncoder(new SpringEncoder(messageConverters));
		}

		/**
		 * 日志级别
		 *
		 * @return
		 */
		@Bean
		public Logger.Level feignLoggerLevel() {
			return Logger.Level.FULL;
		}

		/**
		 * 请求拦截器，可以在这个地方给请求头添加参数(增加traceid)
		 *
		 * @return
		 */
		@Bean
		public RequestInterceptor traceInterceptor() {
			return new RequestInterceptor() {
				@Override
				public void apply(RequestTemplate template) {
					String traceId = MDC.get(MdcUtil.TRACE_ID);
					if (StringUtils.isNotBlank(traceId)) {
						template.header(MdcUtil.TRACE_ID, new String[]{traceId});
					} else {
						template.header(MdcUtil.TRACE_ID, new String[]{MdcUtil.generateTraceId()});
					}
				}
			};
		}
	}
}
