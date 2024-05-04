package com.erp.service;

import com.erp.dto.*;
import com.erp.exception.BaseException;

import java.util.List;

/**
 * @author xielulin
 * @create 2024-05-01 18:41
 * @desc
 **/
public interface AnalysisService {
    /**
     * @description 根据用户id获取当前企业各个城市客户分布情况
     * @author xielulin
     * @date 2024/5/1
     * @param userId
     * @param date
     * @return java.util.List<com.erp.dto.CustomerCityDto>
     */
    List<CustomerCityDto> getCustomerCityData(Integer userId, String date) throws BaseException;

    /**
     * @description 根据用户id获取当前企业各省客户分布情况
     * @author xielulin
     * @date 2024/5/4
     * @param id
     * @param date
     * @return java.util.List<com.erp.dto.CustomerProvinceDto>
     */
    List<CustomerProvinceDto> getCustomerProvinceData(Integer id, String date) throws BaseException;

    /**
     * @description 根据用户id获取当前企业各产品销售额数据
     * @author xielulin
     * @date 2024/5/4
     * @param id
     * @param date
     * @return java.util.List<com.erp.dto.SkuSalesRevenueDto>
     */
    List<SkuSalesRevenueDto> skuSalesRevenue(Integer id, String date) throws BaseException;

    /**
     * @description 根据用户id获取当前企业各产品销售数数据
     * @author xielulin
     * @date 2024/5/4
     * @param id
     * @param date
     * @return java.util.List<com.erp.dto.SkuSalesNumDto>
     */
    List<SkuSalesNumDto> skuSalesNum(Integer id, String date) throws BaseException;

    /**
     * @description 根据用户id和产品id获取近12个月产品的销售数
     * @author xielulin
     * @date 2024/5/4
     * @param id
     * @param skuId
     * @return java.util.List<com.erp.dto.SkuSalesDataDto>
     */
    List<SkuSalesDataDto> salesMonthData(Integer id, Integer skuId) throws BaseException;

    /**
     * @description 根据用户id和产品id获取近30天产品的销售数
     * @author xielulin
     * @date 2024/5/4
     * @param id
     * @param skuId
     * @return java.util.List<com.erp.dto.SkuSalesDataDto>
     */
    List<SkuSalesDataDto> salesDayData(Integer id, Integer skuId) throws BaseException;
}
