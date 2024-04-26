package com.erp.param;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 带分页查询请求封装类-建议正式使用前先进行字段调整，删除不必要的字段
 * @author tools.49db.cn
 * @version 1.0
 * @date 2024-04-26
 */
@Data
public class GetOrderFormListParam extends PageParam {
	@NotNull(message = "userId不能为空")
	private Integer userId;

	private String customerName;
}
