package com.erp.service;

import com.erp.dto.OrderDto;
import com.erp.param.AddOrderParam;
import com.erp.param.GetOrderFormListParam;
import com.erp.param.SaveOrderParam;

import com.erp.bean.OrderForm;
import com.github.pagehelper.PageInfo;


/**
 * service接口
 * 默认提供的查询/更新/删除方法均针对主键，请根据业务需求自行添加相关方法，条件筛选使用Example，参考select方法（利用DAOMapper.***ByExample）
 * @author tools.49db.cn
 * @version 1.0
 * @date 2024-04-26
 */
public interface OrderFormService {

	
	/**
	 * 根据主键查询
	 * @return
	 * @throws Exception
	 */
    OrderDto selectByPrimaryKey(Integer key);
	
	

	/**
	 * 列表查询
	 * @param param
	 * @return
	 * @throws Exception
	 */
	PageInfo<OrderForm> select(GetOrderFormListParam param);


	/**
	 * 添加新纪录
	 * @param param
	 * @return
	 * @throws Exception
	 */
	int add(AddOrderParam param) ;

	/**
	 * 更新记录
	 * @param orderFormRq
	 * @return
	 * @throws Exception
	 */
	int updateByPrimaryKey(SaveOrderParam orderFormRq) throws Exception;

	/**
	 * 删除记录-根据主键
	 * @param key
	 * @return
	 * @throws Exception
	 */
	int delByPrimaryKey(Integer key);
	

}
