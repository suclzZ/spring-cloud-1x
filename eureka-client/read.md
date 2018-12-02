配置：
    spring.application.name是必须的
    将服务名为service-hi的服务注册到eureka server服务器中，可以通过管理界面查看，对应的服务名则是上面配置的名称

服务生产：
    将服务注册后，即可以被其他服务调用，但是调用注册的服务需要借助其他
    
目前仅写了一个客户端，启动后可以在Edit Configurations-> Single instance only取消选中，修改配置文件中的service.port再次启动，即可实现多个服务的注册 


