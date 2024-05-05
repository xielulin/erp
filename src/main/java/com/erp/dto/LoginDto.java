package com.erp.dto;

import lombok.Data;

/**
 * @author xielulin
 * @create 2024-04-17 18:59
 * @desc 登录dto
 **/
@Data
public class LoginDto {
    private String token;
    private int userId;
    private String userName;
}
