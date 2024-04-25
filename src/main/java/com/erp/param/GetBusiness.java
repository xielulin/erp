package com.erp.param;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author xielulin
 * @create 2024-04-25 13:57
 * @desc
 **/
@Data
public class GetBusiness extends PageParam{
    @NotNull(message = "userId不能为空")
    private Integer userId;
    private String name;
    private String province;
    private String city;
}
