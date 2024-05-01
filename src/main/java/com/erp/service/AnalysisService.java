package com.erp.service;

import com.erp.dto.CustomerCityDto;
import com.erp.dto.CustomerProvinceDto;
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
     * @return java.util.List<com.erp.dto.CustomerCityDto>
     */
    List<CustomerCityDto> getCustomerCityData(Integer userId) throws BaseException;

    List<CustomerProvinceDto> getCustomerProvinceData(Integer id) throws BaseException;
}
