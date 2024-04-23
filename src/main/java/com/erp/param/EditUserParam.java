package com.erp.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author xielulin
 * @create 2024-04-22 10:45
 * @desc
 **/
@Data
public class EditUserParam {
    @NotNull(message = "id不能为空")
    private Integer id;
    @NotBlank(message = "姓名不能为空")
    private String name;
    @NotBlank(message = "企业名称不能为空")
    private String comName;
    @NotBlank(message = "电话号码不能为空")
    private String tel;
    @NotBlank(message = "票据联系方式不能为空")
    private String orderTel;
}
