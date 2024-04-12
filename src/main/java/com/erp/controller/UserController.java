package com.erp.controller;

import com.erp.bean.User;
import com.erp.exception.BaseException;
import com.erp.param.TestParam;
import com.erp.response.Result;
import com.erp.service.UserService;
import lombok.extern.java.Log;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author xielulin
 * @create 2024-03-27 22:04
 * @desc
 **/
@RestController
@RequestMapping("/user")
@Log
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/getUser")
    public Result<User> getByTelAndPwd(@RequestBody @Validated TestParam param) throws BaseException {
//        sender.sendConfirm(param.getMessage());
        return Result.ok(userService.getUserByTelAndPwd(param.getTel(),param.getPassword()));

    }

}