package com.erp.param;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author xielulin
 * @create 2024-04-26 15:41
 * @desc 编辑保存订单请求参数
 **/
@Data
public class SaveOrderParam extends AddOrderParam{
    @NotNull(message = "id不能为空")
    private Integer id;
}
