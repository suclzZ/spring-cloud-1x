package com.sucl.feign.web;

import com.sucl.feign.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sucl
 * @since 2018/12/1
 */
@RestController
@RequestMapping("/hi")
public class HiController {
    @Autowired
    private HiService hiService;

    @GetMapping
    public String hi(@RequestParam String name){
        return hiService.sayHiFromClient1(name);
    }
}
