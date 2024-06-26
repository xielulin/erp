package com.erp.service.Impl;

import com.erp.bean.Customer;
import com.erp.bean.User;
import com.erp.constants.Constant;
import com.erp.dao.CustomerMapper;
import com.erp.exception.BaseException;
import com.erp.exception.EmBussinessError;
import com.erp.param.EditCustomerParam;
import com.erp.param.GetCustomerListParam;
import com.erp.param.SaveCustomerParam;
import com.erp.service.CustomerService;
import com.erp.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
 * @author xielulin
 * @create 2024-04-22 15:26
 * @desc 客户
 **/
@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerMapper customerMapper;
    @Resource
    private UserService userService;
    @Override
    public PageInfo<Customer> getCustomerListByComIdAndName(GetCustomerListParam param) throws BaseException {
        User user = userService.getUserById(param.getUserId());
        Integer comId = null;
        Integer userId = null;
        if(user.getLevel() == Constant.UserLevelConstant.MAIN){
            comId = user.getComId();
        }else {
            userId = user.getId();
        }
        PageHelper.startPage(param.getPageNum(), param.getPageSize());
        List<Customer> customers = customerMapper.selectByComIdAndUserName(comId,userId,param.getName());
        PageInfo<Customer> pageInfo = new PageInfo<>(customers);
        return pageInfo;
    }

    @Override
    public Customer getCustomerById(Integer id) {
        Customer customer = customerMapper.selectByPrimaryKey(id);
        return customer;
    }

    @Override
    public int editCustomer(EditCustomerParam param) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(param,customer);
        return customerMapper.updateByPrimaryKeySelective(customer);
    }

    @Override
    public int addCustomer(SaveCustomerParam param) throws BaseException {
        Customer customer = new Customer();
        BeanUtils.copyProperties(param,customer);
        customer.setIsDel(false);
        customer.setCreateTime(new Date());
        User user = userService.getUserById(param.getUserId());
        if(user == null){
            throw new BaseException(EmBussinessError.USER_NOT_EXIT);
        }
        customer.setComId(user.getComId());
        return customerMapper.insert(customer);
    }

    @Override
    public int delCustomer(int id) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setIsDel(true);
        return customerMapper.updateByPrimaryKeySelective(customer);
    }

    @Override
    public List<Customer> getCustomerListByUserId(Integer userId) throws BaseException {
        User user = userService.getUserById(userId);
        Integer comId = null;
        if(user.getLevel() == Constant.UserLevelConstant.MAIN){
            comId = user.getComId();
            userId =null;
        }else {
            userId = user.getId();
        }
        List<Customer> customerList = customerMapper.selectByComIdAndUserName(comId, userId, null);
        return customerList;
    }
}
