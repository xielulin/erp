package com.erp.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author xielulin
 * @create 2022-10-04 15:08
 * @desc
 **/
@Data
public class TestParam {

    @NotBlank(message = "电话号码不能为空")
    private String tel;
    @NotBlank(message = "密码不能为空")
    private String password;
}
