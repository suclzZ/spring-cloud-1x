说明：
    Feign是一个声明式的伪Http客户端，它使得写Http客户端变得更简单。使用Feign，只需要创建一个接口并注解。
    它具有可插拔的注解特性，可使用Feign 注解和JAX-RS注解。Feign支持可插拔的编码器和解码器。
    Feign默认集成了Ribbon，并和Eureka结合，默认实现了负载均衡的效果。

    和ribbon相比，由于feign已经集成了ribbon，所有依旧支持负载均衡

配置方式：（先确保为注册为eureka client）
    1、启动类加上@EnableFeignClients
    2、定义接口，接口并加上@FeignClient("${spring.application.name}"),接口加上spring注解@RequestMapping,与远程服务对应，包括参数，方法类型等
    3、实现自己的controller，并调用自身的接口，实现远程服务调用
    
断路器：
    1、引入相关jar
    2、添加@EnableHystrix @EnableCircuitBreaker
    3、配置文件加上feign.hystrix.enabled=true
    3、在服务接口上添加@FeignClient(value = "service-hi",fallback = ServiceImpl.class)
    4、实现本地服务接口，并重写对应方法，添加到spring容器，在正常情况走的是远程服务，出现故障则走本地实现
    
断路器监控：
    1、引入相关jar
    2、添加@EnableHystrixDashboard
    3、访问http://localhost:port/hystrix