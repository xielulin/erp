package com.erp.param;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author xielulin
 * @create 2024-04-23 11:51
 * @desc 获取客户信息
 **/
@Data
public class GetCustomerListParam extends PageParam{
    @NotNull(message = "用户id不能为空")
    private Integer userId;
    private String name;
}
