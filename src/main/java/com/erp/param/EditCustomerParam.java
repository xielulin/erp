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
public class EditCustomerParam {
    @NotNull
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private String tel;
    @NotBlank
    private String addr;
    @NotBlank
    private String logisticsName;
}
