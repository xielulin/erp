package com.erp.service;

import com.erp.bean.Customer;
import com.erp.exception.BaseException;
import com.erp.param.EditCustomerParam;
import com.erp.param.GetCustomerListParam;
import com.erp.param.SaveCustomerParam;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author xielulin
 * @create 2024-04-22 15:24
 * @desc
 **/
public interface CustomerService {
    /**
     * @description 根据用户id和客户名称获取当前用户的所有客户
     * @author xielulin
     * @date 2024/4/22
     * @param param
     * @return java.util.List<com.erp.bean.Customer>
     */
    PageInfo<Customer> getCustomerListByComIdAndName(GetCustomerListParam param);

    /**
     * @description 根据id获取客户信息
     * @author xielulin
     * @date 2024/4/23
     * @param id
     * @return com.erp.response.Result<com.erp.bean.Customer>
     */
    Customer getCustomerById(Integer id);

    /**
     * @description 修改客户数据
     * @author xielulin
     * @date 2024/4/23
     * @param param
     * @return com.erp.bean.Customer
     */
    int editCustomer(EditCustomerParam param);

    /**
     * @description 添加客户信息
     * @author xielulin
     * @date 2024/4/23
     * @param param
     * @return com.erp.bean.Customer
     */
    int addCustomer(SaveCustomerParam param) throws BaseException;

    /**
     * @description 删除客户数据
     * @author xielulin
     * @date 2024/4/23
     * @param id
     * @return int
     */
    int delCustomer(int id);

    /**
     * @description 根据userId获取所有客户
     * @author xielulin
     * @date 2024/4/26
     * @param userId
     * @return java.util.List<com.erp.bean.Customer>
     */
    List<Customer> getCustomerListByUserId(Integer userId);
}
