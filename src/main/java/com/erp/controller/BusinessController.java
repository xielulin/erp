package com.erp.controller;

import com.erp.bean.Business;
import com.erp.exception.BaseException;
import com.erp.param.GetBusiness;
import com.erp.response.Result;
import com.erp.service.BusinessService;
import com.github.pagehelper.PageInfo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xielulin
 * @create 2024-04-25 13:53
 * @desc 外部导入的商家数据
 **/
@RestController
@RequestMapping("/business")
public class BusinessController {
    @Resource
    private BusinessService businessService;
    @PostMapping("/getBusiness")
    public Result<PageInfo<Business>> getBusinessList(@RequestBody @Validated GetBusiness param) throws BaseException {
        return Result.ok(businessService.getBusinessList(param));
    }
}
