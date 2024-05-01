package com.erp.dto;

import lombok.Data;

/**
 * @author xielulin
 * @create 2024-05-01 21:41
 * @desc
 **/
@Data
public class CustomerProvinceDto {
    /**
     * 省份
     */
    private String provinceName;

    /**
     * 客户数量
     */
    private Integer customerNum;
}
