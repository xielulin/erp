package com.erp.service.Impl;

import com.erp.bean.User;
import com.erp.constants.Constant;
import com.erp.dao.CustomerMapper;
import com.erp.dao.OrderItemsMapper;
import com.erp.dto.*;
import com.erp.exception.BaseException;
import com.erp.service.AnalysisService;
import com.erp.service.UserService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xielulin
 * @create 2024-05-01 18:52
 * @desc 数据分析
 **/
@Service
public class AnalysisServiceImpl implements AnalysisService {

    @Resource
    private CustomerMapper customerMapper;
    @Resource
    private OrderItemsMapper orderItemsMapper;
    @Resource
    private UserService userService;
    @Override
    public List<CustomerCityDto> getCustomerCityData(Integer userId, String date) throws BaseException {
        User user = userService.getUserById(userId);
        Integer comId = null;
        Integer id = null;
        if(user.getLevel() == Constant.UserLevelConstant.MAIN){
            comId = user.getComId();
        }else {
            id = user.getId();
        }
        return customerMapper.getCustomerCityData(comId,id,date);
    }

    @Override
    public List<CustomerProvinceDto> getCustomerProvinceData(Integer id, String date) throws BaseException {
        User user = userService.getUserById(id);
        Integer comId = null;
        Integer userId = null;
        if(user.getLevel() == Constant.UserLevelConstant.MAIN){
            comId = user.getComId();
        }else {
            userId = user.getId();
        }
        return customerMapper.getCustomerProvinceData(comId,userId,date);
    }

    @Override
    public List<SkuSalesRevenueDto> skuSalesRevenue(Integer id, String date) throws BaseException {
        User user = userService.getUserById(id);
        Integer comId = null;
        Integer userId = null;
        if(user.getLevel() == Constant.UserLevelConstant.MAIN){
            comId = user.getComId();
        }else {
            userId = user.getId();
        }
        return orderItemsMapper.getSkuSalesRevenue(comId,userId,date);
    }

    @Override
    public List<SkuSalesNumDto> skuSalesNum(Integer id, String date) throws BaseException {
        User user = userService.getUserById(id);
        Integer comId = null;
        Integer userId = null;
        if(user.getLevel() == Constant.UserLevelConstant.MAIN){
            comId = user.getComId();
        }else {
            userId = user.getId();
        }
        return orderItemsMapper.getSkuSalesNum(comId,userId,date);
    }

    @Override
    public List<SkuSalesDataDto> salesMonthData(Integer id, Integer skuId) throws BaseException {
        User user = userService.getUserById(id);
        Integer comId = null;
        Integer userId = null;
        if(user.getLevel() == Constant.UserLevelConstant.MAIN){
            comId = user.getComId();
        }else {
            userId = user.getId();
        }
        List<SkuSalesDataDto> salesMonthData = orderItemsMapper.getSalesMonthData(comId,userId, skuId);
        return handleMonthData(salesMonthData);
    }

    private List<SkuSalesDataDto> handleMonthData(List<SkuSalesDataDto> salesMonthData) {
        List<SkuSalesDataDto> result = new ArrayList<>();
        Date date = null;
        Map<String, SkuSalesDataDto> salesDateMap = salesMonthData.stream().collect(Collectors.toMap(SkuSalesDataDto::getDate, v->v));
        SkuSalesDataDto skuSalesDataDto = null;
        for (int i = 12; i >= 0; i--) {
            date = DateUtils.addMonths(new Date(), -i);
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            int year = instance.get(Calendar.YEAR);
            int month = instance.get(Calendar.MONTH)+1;
            String monthStr = "";
            if (month<10){
                monthStr = "0"+month;
            }else {
                monthStr = ""+month;
            }
            String dateStr = year+"-"+monthStr ;
            if(salesDateMap.keySet().contains(dateStr)){
                result.add(salesDateMap.get(dateStr));
            }else {
                skuSalesDataDto = new SkuSalesDataDto();
                skuSalesDataDto.setDate(dateStr);
                skuSalesDataDto.setNum(0);
                result.add(skuSalesDataDto);
            }
        }
        return result;
    }

    @Override
    public List<SkuSalesDataDto> salesDayData(Integer id, Integer skuId) throws BaseException {
        User user = userService.getUserById(id);
        Integer comId = null;
        Integer userId = null;
        if(user.getLevel() == Constant.UserLevelConstant.MAIN){
            comId = user.getComId();
        }else {
            userId = user.getId();
        }
        List<SkuSalesDataDto> salesDayData = orderItemsMapper.getSalesDayData(comId,userId, skuId);

        return  handleDayData(salesDayData);
    }

    private List<SkuSalesDataDto> handleDayData(List<SkuSalesDataDto> salesDayData) {
        List<SkuSalesDataDto> result = new ArrayList<>();
        Date date = null;
        Map<String, SkuSalesDataDto> salesDateMap = salesDayData.stream().collect(Collectors.toMap(SkuSalesDataDto::getDate, v->v));
        SkuSalesDataDto skuSalesDataDto = null;
        for (int i = 30; i >= 0; i--) {
            date = DateUtils.addDays(new Date(), -i);
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            int year = instance.get(Calendar.YEAR);
            int month = instance.get(Calendar.MONTH)+1;
            String monthStr = "";
            String dayStr = "";
            int day = instance.get(Calendar.DAY_OF_MONTH);
            if (month<10){
                monthStr = "0"+month;
            }else {
                monthStr = ""+month;
            }
            if (day<10){
                dayStr = "0"+day;
            }else {
                dayStr = ""+day;
            }
            String dateStr = year+"-"+monthStr + "-" +dayStr ;
            if(salesDateMap.keySet().contains(dateStr)){
                result.add(salesDateMap.get(dateStr));
            }else {
                skuSalesDataDto = new SkuSalesDataDto();
                skuSalesDataDto.setDate(dateStr);
                skuSalesDataDto.setNum(0);
                result.add(skuSalesDataDto);
            }
        }
        return result;
    }
}
