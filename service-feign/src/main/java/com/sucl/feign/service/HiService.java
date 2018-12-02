package com.sucl.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 定义的是对应的注册的服务名（spring.application.name）
 * @author sucl
 * @since 2018/12/1
 */
@FeignClient("service-hi")
public interface HiService {

    /**
     * 与注册的服务提供接口名对应
     * @RequestParam 中的名称要指定
     * @param name
     * @return
     */
    @GetMapping("/hi")
    String sayHiFromClient1(@RequestParam("name") String name);
}
