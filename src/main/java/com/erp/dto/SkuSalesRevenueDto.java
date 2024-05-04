package com.erp.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author xielulin
 * @create 2024-05-04 11:14
 * @desc
 **/
@Data
public class SkuSalesRevenueDto {
    private String code;
    private BigDecimal price;
}
