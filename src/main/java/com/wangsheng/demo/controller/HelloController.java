package com.wangsheng.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    /**
     * @Author: WangSheng
     * @Description:
     * @Date: 11:17 2017/12/19
     */
    @RequestMapping("/hello")
    public String say(){
        return "Hello SpringBoot!";
    }
}
