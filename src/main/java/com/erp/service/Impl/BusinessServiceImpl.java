package com.erp.service.Impl;

import com.erp.bean.Business;
import com.erp.bean.BusinessExample;
import com.erp.bean.Company;
import com.erp.bean.User;
import com.erp.constants.Constant;
import com.erp.dao.BusinessMapper;
import com.erp.dao.CompanyMapper;
import com.erp.exception.BaseException;
import com.erp.param.GetBusiness;
import com.erp.service.BusinessService;
import com.erp.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.erp.exception.EmBussinessError.AUTHORITY_ERROR;

/**
 * @author xielulin
 * @create 2024-04-25 14:01
 * @desc 外部导入商户数据
 **/
@Service
public class BusinessServiceImpl implements BusinessService {
    @Resource
    private BusinessMapper businessMapper;
    @Override
    public PageInfo<Business> getBusinessList(GetBusiness param) {
        PageHelper.startPage(param.getPageNum(),param.getPageSize());
        BusinessExample example = new BusinessExample();
        BusinessExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(param.getName())){
            criteria.andNameLike("%"+param.getName()+"%");
        }
        if(StringUtils.isNotBlank(param.getCity())){
            criteria.andCityLike("%"+param.getCity()+"%");
        }
        if(StringUtils.isNotBlank(param.getProvince())){
            criteria.andProvinceLike("%"+param.getProvince()+"%");
        }
        List<Business> businessList = businessMapper.selectByExample(example);
        PageInfo<Business> pageInfo = PageInfo.of(businessList);

        return pageInfo;
    }
}
