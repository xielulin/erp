package com.erp.dto;

import lombok.Data;

/**
 * @author xielulin
 * @create 2024-05-01 18:45
 * @desc 客户城市分布
 **/
@Data
public class CustomerCityDto {
    /**
     * 城市
     */
    private String cityName;

    /**
     * 客户数量
     */
    private Integer customerNum;
}
