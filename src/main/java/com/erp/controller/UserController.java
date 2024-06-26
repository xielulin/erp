package com.erp.controller;

import com.erp.bean.User;
import com.erp.dto.LoginDto;
import com.erp.dto.UserDto;
import com.erp.exception.BaseException;
import com.erp.param.EditUserParam;
import com.erp.param.GetUserParam;
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

@CrossOrigin
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/getUser")
    public Result<User> getByTelAndPwd(@RequestBody @Validated GetUserParam param) throws BaseException {
        return Result.ok(userService.getUserByTelAndPwd(param.getTel(),param.getPassword()));
    }
    @PostMapping("/login")
    public Result<LoginDto> login(@RequestBody @Validated GetUserParam param) throws BaseException {
        LoginDto userToken = userService.login(param.getTel(), param.getPassword());
        return Result.ok(userToken);
    }
    @GetMapping("/getUserById")
    public Result<UserDto> getUserById(@RequestParam int id) throws BaseException {
        return Result.ok(userService.getUserDetailById(id));
    }
    @PostMapping("/editUserDetail")
    public Result<UserDto> editUserDetail(@RequestBody @Validated EditUserParam param) throws BaseException {
        return Result.ok(userService.editUserDetail(param));
    }

}
