package com.erp.controller;

import com.erp.dto.*;
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


    /**
     * @description 根据用户id获取当前企业各省客户分布情况
     * @author xielulin
     * @date 2024/5/4
     * @param id
     * @param date
     * @return com.erp.response.Result<java.util.List < com.erp.dto.CustomerProvinceDto>>
     */
    @GetMapping("/customer/province")
    public Result<List<CustomerProvinceDto>> getCustomerProvinceData(@RequestParam Integer id,@RequestParam(required = false)String date) throws BaseException {
        return Result.ok(analysisService.getCustomerProvinceData(id,date));
    }

    /**
     * @description 根据用户id获取当前企业各产品销售额数据
     * @author xielulin
     * @date 2024/5/4
     * @param id
     * @param date
     * @return com.erp.response.Result<java.util.List < com.erp.param.SkuSalesRevenueDto>>
     */
    @GetMapping("/sku/salesRevenue")
    public Result<List<SkuSalesRevenueDto>> skuSalesRevenue(@RequestParam Integer id, @RequestParam(required = false)String date) throws BaseException {
        return Result.ok(analysisService.skuSalesRevenue(id,date));
    }

    /**
     * @description 根据用户id获取当前企业各产品销售数数据
     * @author xielulin
     * @date 2024/5/4
     * @param id
     * @param date
     * @return com.erp.response.Result<java.util.List < com.erp.dto.SkuSalesNumDto>>
     */
    @GetMapping("/sku/salesNum")
    public Result<List<SkuSalesNumDto>> skuSalesNum(@RequestParam Integer id, @RequestParam(required = false)String date) throws BaseException {
        return Result.ok(analysisService.skuSalesNum(id,date));
    }

    /**
     * @description 根据用户id和产品id获取近12个月产品的销售数
     * @author xielulin
     * @date 2024/5/4
     * @param id
     * @param skuId
     * @return com.erp.response.Result<java.util.List < com.erp.dto.SkuSalesDataDto>>
     */
    @GetMapping("/sku/salesMonthData")
    public Result<List<SkuSalesDataDto>> salesMonthData(@RequestParam Integer id, @RequestParam(required = false) Integer skuId) throws BaseException {
        return Result.ok(analysisService.salesMonthData(id,skuId));
    }

    /**
     * @description 根据用户id和产品id获取近30天产品的销售数
     * @author xielulin
     * @date 2024/5/4
     * @param id
     * @param skuId
     * @return com.erp.response.Result<java.util.List < com.erp.dto.SkuSalesDataDto>>
     */
    @GetMapping("/sku/salesDayData")
    public Result<List<SkuSalesDataDto>> salesDayData(@RequestParam Integer id, @RequestParam(required = false) Integer skuId) throws BaseException {
        return Result.ok(analysisService.salesDayData(id,skuId));
    }
}
