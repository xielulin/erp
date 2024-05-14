package com.erp.dto;

import com.erp.bean.OrderForm;
import com.erp.bean.OrderItems;
import lombok.Data;

import java.util.List;

/**
 * @author xielulin
 * @create 2024-04-28 15:00
 * @desc 订单详情
 **/
@Data
public class OrderDto extends OrderForm {
    private List<OrderItems> orderItemsList;
    private String createUserName;
}
