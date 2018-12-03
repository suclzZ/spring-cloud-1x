http请求地址和资源文件映射如下:

/{application}/{profile}[/{label}]
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties

配置：
    在git对应仓库配置相关文件，本示例可以通过访问http://localhost:8888/config-client/dev得到配置文件