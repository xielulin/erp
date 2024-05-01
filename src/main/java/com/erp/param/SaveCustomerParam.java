package com.erp.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author xielulin
 * @create 2024-04-23 15:53
 * @desc
 **/
@Data
public class SaveCustomerParam {
    @NotNull(message = "userId不能为空")
    private Integer userId;
    @NotBlank(message = "姓名不能为空")
    private String name;
    @NotBlank(message = "电话不能为空")
    private String tel;
    @NotBlank(message = "地址不能为空")
    private String addr;
    @NotBlank(message = "物流不能为空")
    private String logisticsName;
    @NotBlank(message = "客户所属省份不能为空")
    private String province;
    @NotBlank(message = "客户所属城市不能为空")
    private String city;

}
