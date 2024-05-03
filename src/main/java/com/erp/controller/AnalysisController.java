package com.erp.controller;

import com.erp.dto.CustomerCityDto;
import com.erp.dto.CustomerProvinceDto;
import com.erp.exception.BaseException;
import com.erp.response.Result;
import com.erp.service.AnalysisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xielulin
 * @create 2024-05-01 18:40
 * @desc 数据分析
 **/
@RestController
@RequestMapping("/analysis")
public class AnalysisController {
    @Resource
    AnalysisService analysisService;

    /**
     * @description 根据用户id获取当前企业各城市客户分布情况
     * @author xielulin
     * @date 2024/5/1
     * @param id
     * @return com.erp.response.Result<java.util.List < com.erp.dto.CustomerCityDto>>
     */
    @GetMapping("/customer/city")
    public Result<List<CustomerCityDto>> getCustomerCityData(@RequestParam Integer id,@RequestParam(required = false) String date) throws BaseException {
        return Result.ok(analysisService.getCustomerCityData(id,date));
    }


    @GetMapping("/customer/province")
    public Result<List<CustomerProvinceDto>> getCustomerProvinceData(@RequestParam Integer id,@RequestParam(required = false)String date) throws BaseException {
        return Result.ok(analysisService.getCustomerProvinceData(id,date));
    }
}
