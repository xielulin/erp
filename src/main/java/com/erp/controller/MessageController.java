package com.erp.controller;

import com.erp.exception.BaseException;
import com.erp.response.Result;
import com.erp.service.SendMessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xielulin
 * @create 2024-04-24 22:51
 * @desc 短信
 **/
@RestController
@RequestMapping("/message")
public class MessageController {
    @Resource
    private SendMessageService sendMessageService;
    @GetMapping("/sendVerificationCode")
    public Result sendVerificationCode(@RequestParam String tel) throws BaseException {
        return sendMessageService.sendVerificationCode(tel);
    }
    @GetMapping("/checkVerificationCode")
    public Result checkVerificationCode(@RequestParam String tel,@RequestParam String verificationCode) {
        return sendMessageService.checkVerificationCode(tel,verificationCode);
    }
}
