package com.erp.param;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author xielulin
 * @create 2024-04-26 16:00
 * @desc 编辑订单商品明细
 **/
@Data
public class SaveOrderItemParam extends AddOrderItemParam{
    @NotNull(message = "id不能为空")
    private Integer id;
}
