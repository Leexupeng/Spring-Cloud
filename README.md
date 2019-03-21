# Spring-Cloud
Spring Cloud 微服务实战笔记

### eureka服务端
* eureka.client.register-with-eureka:是否想erueka注册中心注册 默认为true
* eureka.server.enable-self-preservation:false 是否关闭eureka服务端自我保护机制，若关闭，则服务提供端只要不可用，便被剔除，失去容错机制

### 服务提供端
* eureka.instance.lease-renewal-interval-in-seconds:30 服务提供端想eureka服务端续约的间隔时长30s
* eureka.instance.lease-expiration-duration-in-seconds:90 服务失效的时间，eureka服务端在启动时会创建一个定时任务，每隔（默认60s）一段时间，将当前清单中超过此设置值没有续约的服务剔除。

### 服务消费端
* eureka.client.fetch-registry:从eureka服务端获取注册其上的服务提供者清单 默认为true
* eureka.client.registry-fetch-interval-seconds:30 从erueka服务端获取的清单的更新时间30s
