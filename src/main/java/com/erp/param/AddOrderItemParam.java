package com.erp.param;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author xielulin
 * @create 2024-04-26 15:51
 * @desc添加商品订单明细
 **/
@Data
public class AddOrderItemParam {
    @NotNull(message = "skuId不能为空")
    private Integer skuId;
    @NotNull(message = "产品名称不能为空")
    private String skuName;
    @NotNull(message = "产品规格不能为空")
    private String skuSpecification;
    @NotNull(message = "产品型号不能为空")
    private String code;
    @NotNull(message = "商品数量不能为空")
    @Min(value = 1,message = "商品数量不能小于1")
    private Integer skuNum;

    @NotNull(message = "商品单价不能为空")
    @Min(value = 0,message = "商品单价不能小于0")
    private BigDecimal price;

    @NotNull(message = "商品总价不能为空")
    @Min(value = 1,message = "商品总价不能小于0")
    private BigDecimal totalPrice;
    private double discount;
    private String remarks;

}
