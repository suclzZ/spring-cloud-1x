配置：
    spring.application.name是必须的

服务消费：
    所有服务即作为生产者也作为消费者。
    Spring cloud有两种服务调用方式，一种是ribbon+restTemplate，另一种是feign。在这一篇文章首先讲解下基于ribbon+rest
    ribbon是一个负载均衡客户端，可以很好的控制htt和tcp的一些行为。Feign默认集成了ribbon。
    
    ribbon 已经默认实现了这些配置bean：
        IClientConfig ribbonClientConfig: DefaultClientConfigImpl
    
        IRule ribbonRule: ZoneAvoidanceRule
        
        IPing ribbonPing: NoOpPing
        
        ServerList ribbonServerList: ConfigurationBasedServerList
        
        ServerListFilter ribbonServerListFilter: ZonePreferenceServerListFilter
        
        ILoadBalancer ribbonLoadBalancer: ZoneAwareLoadBalancer
        
断路器：
    在微服务架构中，根据业务来拆分成一个个的服务，服务与服务之间可以相互调用（RPC），在Spring Cloud可以用RestTemplate+Ribbon
    和Feign来调用。为了保证其高可用，单个服务通常会集群部署。由于网络原因或者自身的原因，服务并不能保证100%可用，如果单个服务出现
    问题，调用这个服务就会出现线程阻塞，此时若有大量的请求涌入，Servlet容器的线程资源会被消耗完毕，导致服务瘫痪。服务与服务之间的
    依赖性，故障会传播，会对整个微服务系统造成灾难性的严重后果，这就是服务故障的“雪崩”效应


服务消费：
    调用服务主要通过RestTemplate完成，具体调用什么服务，看具体配置
    配置服务的时候主要是根据spring.application.name名称
    robbin已经实现负载均衡，我们在通过http://localhost:8764/hello?name=tom调用其他服务的时候，可以看到可以调用到多个应用的服务
    
配置方式：（先确保为注册为eureka client）
    1、引入RestTemplate(需要加上@LoadBalanced)
    2、定义接口并实现，实现方式调用其他服务的方式为：restTemplate.getForObject("http://${spring.application.name}/interface?name="+name,String.class)
    3、实现自己的controller，并调用自身的接口，实现远程服务调用
    
断路器：
    1、引入相关jar
    2、添加@EnableHystrix
    3、在服务接口方法上添加@HystrixCommand(fallbackMethod = "hiError")
    4、定义对应的处理逻辑
    
问题：
   断路器监控 Unable to connect to Command Metric Stream.?