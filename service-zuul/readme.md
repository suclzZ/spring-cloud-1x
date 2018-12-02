#说明：

    在Spring Cloud微服务系统中，一种常见的负载均衡方式是，客户端的请求首先经过负载均衡（zuul、Ngnix），再到达服务网关
    （zuul集群），然后再到具体的服。，服务统一注册到高可用的服务注册中心集群，服务的所有的配置文件由配置服务管理，配置服
    务的配置文件放在git仓库，方便开发人员随时改配置。

#功能：

    Authentication
    Insights
    Stress Testing
    Canary Testing
    Dynamic Routing
    Service Migration
    Load Shedding
    Security
    Static Response handling
    Active/Active traffic management

#配置：

    添加相关服务映射： /{api}/** -> {ribbon|feign}，由zuul定义的接口 到服务调用的实例名（spring.application.name）
    
