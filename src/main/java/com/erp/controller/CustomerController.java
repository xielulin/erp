package com.erp.controller;

import com.erp.bean.Customer;
import com.erp.exception.BaseException;
import com.erp.param.EditCustomerParam;
import com.erp.param.GetCustomerListParam;
import com.erp.param.SaveCustomerParam;
import com.erp.response.Result;
import com.erp.service.CustomerService;
import com.github.pagehelper.PageInfo;
import lombok.extern.java.Log;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xielulin
 * @create 2024-04-22 15:23
 * @desc 客户
 **/
@RestController
@RequestMapping("/customer")
@Log
public class CustomerController {
    @Resource
    private CustomerService customerService;


    @PostMapping("/getCustomerList")
    public Result<PageInfo<Customer>> getCustomerList(@RequestBody@Validated GetCustomerListParam param) throws BaseException {
        return Result.ok(customerService.getCustomerListByComIdAndName(param));
    }

    @GetMapping("/getList")
    public Result<List<Customer>> getList(@RequestParam Integer userId)  {
        return Result.ok(customerService.getCustomerListByUserId(userId));
    }

    @GetMapping("/getCustomer")
    public Result<Customer> getCustomer(@RequestParam Integer id) {
        return Result.ok(customerService.getCustomerById(id));
    }

    @PostMapping("/editCustomer")
    public Result<Integer> editCustomer(@RequestBody@Validated EditCustomerParam param) {
        int updateNum = customerService.editCustomer(param);
        if(updateNum != 1){
            return Result.warn("修改失败");
        }
        return Result.ok();
    }
    @PostMapping("/addCustomer")
    public Result<Integer> addCustomer(@RequestBody@Validated SaveCustomerParam param) throws BaseException {
        int addNum = customerService.addCustomer(param);
        if(addNum != 1){
            return Result.warn("新增失败");
        }
        return Result.ok();
    }
    @DeleteMapping("/delCustomer")
    public Result<Customer> delCustomer(@RequestParam int id) {
        int delNum = customerService.delCustomer(id);
        if(delNum != 1){
            return Result.warn("删除失败");
        }
        return Result.ok();
    }
}
