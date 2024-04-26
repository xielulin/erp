package com.erp.param;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author xielulin
 * @create 2024-04-26 15:35
 * @desc 添加订单
 **/
@Data
public class AddOrderParam{

    @NotNull(message = "userId不能为空")
    private Integer userId;
    @NotNull(message = "customerId不能为空")
    private Integer customerId;
    @NotNull(message = "商品数量不能为空")
    @Min(value = 1,message = "商品数量不能小于1")
    private Integer skuNum;
    @NotNull(message = "金额不能为空")
    @Min(value = 0,message = "金额不能小于0")
    private BigDecimal price;
    @NotBlank(message = "物流名称不能为空")
    private String logisticsName;
    @NotBlank(message = "客户名字不能为空")
    private String customerName;
    @NotBlank(message = "客户地址不能为空")
    private String customerAddr;
    @NotBlank(message = "客户联系方式不能为空")
    private String customerTel;
    @NotBlank(message = "联系方式不能为空")
    private String comTel;
    @NotEmpty(message = "商品明细不能为空")
    private List<AddOrderItemParam> orderItemParamList;
}
