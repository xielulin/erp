package com.erp.service.Impl;

import com.erp.bean.User;
import com.erp.dao.CustomerMapper;
import com.erp.dto.CustomerCityDto;
import com.erp.dto.CustomerProvinceDto;
import com.erp.exception.BaseException;
import com.erp.service.AnalysisService;
import com.erp.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    private UserService userService;
    @Override
    public List<CustomerCityDto> getCustomerCityData(Integer userId, String date) throws BaseException {
        User user = userService.getUserById(userId);
        return customerMapper.getCustomerCityData(user.getComId(),date);
    }

    @Override
    public List<CustomerProvinceDto> getCustomerProvinceData(Integer id, String date) throws BaseException {
        User user = userService.getUserById(id);
        return customerMapper.getCustomerProvinceData(user.getComId(),date);
    }
}
