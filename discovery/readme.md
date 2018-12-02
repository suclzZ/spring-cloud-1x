yml配置：
    register-with-eureka: false
    fetch-registry: false
    eureka-server默认是是一个客户端，所以必须配置表明该是服务端;
服务：
    http://localhost:8761/ 为控制界面
    http://localhost:8761/eureka/ 则是注册中心的地址