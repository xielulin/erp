package com.erp.controller;

import com.erp.bean.Sku;
import com.erp.bean.User;
import com.erp.exception.BaseException;
import com.erp.param.EditSkuParam;
import com.erp.param.GetSkuListParam;
import com.erp.param.SaveSkuParam;
import com.erp.response.Result;
import com.erp.service.SkuService;
import com.github.pagehelper.PageInfo;
import org.springframework.http.HttpRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author xielulin
 * @create 2024-04-25 20:47
 * @desc 商品
 **/
@RestController
@RequestMapping("/sku")
public class SkuController {
    @Resource
    private SkuService skuService;
    @PostMapping("/getSkuList")
    public Result<PageInfo<Sku>> getSkuList(@RequestBody @Validated GetSkuListParam param) throws BaseException {
        return Result.ok(skuService.getSkuList(param));
    }
    @GetMapping("/getList")
    public Result<List<Sku>> getList(@RequestParam Integer userId) throws BaseException {
        return Result.ok(skuService.getSkuListByUserId(userId));
    }

    @GetMapping("/getSku")
    public Result<Sku> getSku(@RequestParam Integer id) throws BaseException {
        return Result.ok(skuService.getSkuById(id));
    }

    @PostMapping("/editSku")
    public Result<Integer> editSku(@RequestBody@Validated EditSkuParam param, HttpServletRequest request) throws BaseException {
        User user = (User) request.getAttribute("user");
        int updateNum = skuService.editSku(param,user.getId());
        if(updateNum != 1){
            return Result.warn("修改失败");
        }
        return Result.ok();
    }
    @PostMapping("/addSku")
    public Result<Integer> addSku(@RequestBody@Validated SaveSkuParam param) throws BaseException {
        int addNum = skuService.addSku(param);
        if(addNum != 1){
            return Result.warn("新增失败");
        }
        return Result.ok();
    }
    @DeleteMapping("/delSku")
    public Result<Sku> delSku(@RequestParam int id, HttpServletRequest request) throws BaseException {
        User user = (User) request.getAttribute("user");
        int delNum = skuService.delSku(id,user.getId());
        if(delNum != 1){
            return Result.warn("删除失败");
        }
        return Result.ok();
    }
}
