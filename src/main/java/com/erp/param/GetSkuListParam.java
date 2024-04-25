package com.erp.param;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author xielulin
 * @create 2024-04-25 20:51
 * @desc
 **/
@Data
public class GetSkuListParam extends PageParam{
    @NotNull(message = "用户id不能为空")
    private Integer userId;
    private String name;
}
