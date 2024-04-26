package com.erp.dao;

import com.erp.bean.OrderForm;
import com.erp.bean.OrderFormExample;
import java.util.List;

public interface OrderFormMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_form
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_form
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    int insert(OrderForm record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_form
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    int insertSelective(OrderForm record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_form
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    List<OrderForm> selectByExample(OrderFormExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_form
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    OrderForm selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_form
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    int updateByPrimaryKeySelective(OrderForm record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_form
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    int updateByPrimaryKey(OrderForm record);
}