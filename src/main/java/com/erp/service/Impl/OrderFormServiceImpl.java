package com.erp.service.Impl;

import com.erp.bean.*;
import com.erp.dao.CompanyMapper;
import com.erp.dao.OrderFormMapper;
import com.erp.dao.OrderItemsMapper;
import com.erp.dto.OrderDto;
import com.erp.exception.BaseException;
import com.erp.param.AddOrderItemParam;
import com.erp.param.AddOrderParam;
import com.erp.param.GetOrderFormListParam;
import com.erp.param.SaveOrderParam;
import com.erp.service.UserService;

import com.erp.service.OrderFormService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * service实现
 * @author tools.49db.cn
 * @version 1.0
 * @date 2024-04-26
 */
@Service
public class OrderFormServiceImpl implements OrderFormService {
	@Resource
	private OrderFormMapper orderFormMapper;
	@Resource
	private OrderItemsMapper orderItemsMapper;
	@Resource
	private CompanyMapper companyMapper;
	@Resource
	private UserService userService;

	@Override
	public OrderDto selectByPrimaryKey(Integer key) {
		OrderForm orderForm = orderFormMapper.selectByPrimaryKey(key);
		OrderItemsExample example = new OrderItemsExample();
		example.createCriteria().andOrderIdEqualTo(key);
		List<OrderItems> orderItemsList = orderItemsMapper.selectByExample(example);
		OrderDto orderDto = new OrderDto();
		BeanUtils.copyProperties(orderForm,orderDto);
		orderDto.setOrderItemsList(orderItemsList);
		return orderDto;
	}
	

	//注意，若不提供分页参数，可能导致查询出大量数据！
	@Override
	public PageInfo<OrderForm> select(GetOrderFormListParam param) throws BaseException {
		User user = userService.getUserById(param.getUserId());
		OrderFormExample example = new OrderFormExample();
		OrderFormExample.Criteria criteria = example.createCriteria();
		criteria.andComIdEqualTo(user.getComId());
		criteria.andIsDelEqualTo(false);
		if(StringUtils.isNotBlank(param.getCustomerName())){
			criteria.andCustomerNameLike("%"+param.getCustomerName()+"%");
		}
		example.setOrderByClause("id desc");
		PageHelper.startPage(param.getPageNum(),param.getPageSize());
		List<OrderForm> orderFormList = orderFormMapper.selectByExample(example);
		PageInfo<OrderForm> pageInfo = new PageInfo<>(orderFormList);
		return pageInfo;
	}


	@Override
	@Transactional
	public int add(AddOrderParam param) throws BaseException {
		User user = userService.getUserById(param.getUserId());
		OrderForm orderForm = new OrderForm();
		BeanUtils.copyProperties(param,orderForm);
		orderForm.setComId(user.getComId());
		orderForm.setComTel(user.getOrderTel());
		orderForm.setCreateTime(new Date());
		orderForm.setUpdateTime(new Date());
		Company company = companyMapper.selectByPrimaryKey(user.getComId());
		orderForm.setComName(company.getComName());
		int count = orderFormMapper.insertSelective(orderForm);

		param.getOrderItemsList().stream().forEach(v->{
			OrderItems orderItems =  new OrderItems();
			BeanUtils.copyProperties(v,orderItems);
			orderItems.setOrderId(orderForm.getId());
			orderItems.setCreateTime(new Date());
			orderItemsMapper.insertSelective(orderItems);
		});

		return count;
	}
	
	@Override
	public int updateByPrimaryKey(SaveOrderParam param) throws BaseException {
		User user = userService.getUserById(param.getUserId());
		OrderForm orderForm = new OrderForm();
		BeanUtils.copyProperties(param,orderForm);
		orderForm.setComId(user.getComId());
		orderForm.setUpdateTime(new Date());
		int count = orderFormMapper.updateByPrimaryKeySelective(orderForm);
		orderItemsMapper.deleteByOrderId(orderForm.getId());
		List<AddOrderItemParam> orderItemParamList = param.getOrderItemsList();
		orderItemParamList.stream().forEach(v->{
			OrderItems orderItems =  new OrderItems();
			BeanUtils.copyProperties(v,orderItems);
			orderItems.setOrderId(orderForm.getId());
			orderItems.setCreateTime(new Date());
			orderItemsMapper.insertSelective(orderItems);
		});
		return count;
	}

	@Override
	public int delByPrimaryKey(Integer key){
		OrderForm orderForm = selectByPrimaryKey(key);
		orderForm.setIsDel(true);
		int upateNum = orderFormMapper.updateByPrimaryKeySelective(orderForm);
		return upateNum;
	}
	
}
