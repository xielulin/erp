package com.erp.controller;

import com.erp.dto.OrderDto;
import com.erp.param.AddOrderParam;
import com.erp.param.GetOrderFormListParam;
import com.erp.param.SaveOrderParam;
import com.erp.response.Result;
import com.erp.service.OrderFormService;

import com.erp.bean.OrderForm;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * controller
 * @author tools.49db.cn
 * @version 1.0
 * @date 2024-04-26
 */
@RestController
@RequestMapping("/order")//todo 使用前请设置路径
public class OrderFormController {
	@Autowired
	private OrderFormService orderFormService;

	
	/**
	 * 根据主键查询
	 */
	@GetMapping("/getOrder")
	public Result<OrderDto> selectByPrimaryKey(@RequestParam Integer id) {
		return Result.ok(orderFormService.selectByPrimaryKey(id));
	}
	
	

	@PostMapping("/getOrderList")
	public Result<PageInfo<OrderForm>> list(@RequestBody @Validated GetOrderFormListParam param)  {
		return Result.ok(orderFormService.select(param));
	}

	@PostMapping("/addOrder")
	public Result add(@RequestBody @Validated AddOrderParam param) {
		int addNum = orderFormService.add(param);
		if(addNum != 1){
			return Result.warn("新增失败");
		}
		return Result.ok();
	}

	@PostMapping("/editOrder")
	public Result updateByPrimaryKey(@RequestBody @Validated SaveOrderParam param) throws Exception {
		int updateNum = orderFormService.updateByPrimaryKey(param);
		if(updateNum != 1){
			return Result.warn("保存失败");
		}
		return Result.ok();
	}

	@DeleteMapping("/delOrder")
	public Result del(@RequestParam Integer id){
		int delNum = orderFormService.delByPrimaryKey(id);
		if(delNum != 1){
			return Result.warn("删除失败");
		}
		return Result.ok();
	}
	

}
