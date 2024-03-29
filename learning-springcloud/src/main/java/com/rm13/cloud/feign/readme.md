## 说明
- hystrix参考 `resource/static/hystrix`文档



```yaml
feign:
  okhttp:
    enabled: false
  httpclient:
    enabled: false
  # 开启熔断
  hystrix:
    enabled: true
hystrix:
  command:
    default:
      fallback:
        # fallback 隔离，采用信号量模式，最大并发执行数1000
        isolation:
          semaphore:
            maxConcurrentRequests: 1000
      circuitBreaker:
        # 开启熔断
        enabled: true
        # 熔断窗口起5秒， 5秒后 open-> half-open -> close
        sleepWindowInMilliseconds: 5000
        # 错误比例 50%
        errorThresholdPercentage: 50

      execution:
        timeout:
          # 请求超时是否开启
          enabled: true
        isolation:
          # 请求采用线程池隔离模式， 超过5秒中，请求超时， 执行fallback
          thread:
            timeoutInMilliseconds: 5000
```