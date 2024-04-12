package com.erp.test;

import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xielulin
 * @create 2024-03-27 19:52
 * @desc 测试类
 **/
@RestController
@RequestMapping("/test")
@Log
public class TestController {

//    @Resource
//    private ProducerDemo sender;
    @PostMapping("/test")
    public String test(){
        log.info("test");
        return "test success";
//        sender.sendConfirm(param.getMessage());
    }

}
