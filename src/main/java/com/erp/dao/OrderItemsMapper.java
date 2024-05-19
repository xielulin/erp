package com.erp.dao;

import com.erp.bean.OrderItems;
import com.erp.bean.OrderItemsExample;
import com.erp.dto.SkuSalesDataDto;
import com.erp.dto.SkuSalesNumDto;
import com.erp.dto.SkuSalesRevenueDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderItemsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_items
     *
     * @mbg.generated Fri May 17 12:06:54 CST 2024
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_items
     *
     * @mbg.generated Fri May 17 12:06:54 CST 2024
     */
    int insert(OrderItems record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_items
     *
     * @mbg.generated Fri May 17 12:06:54 CST 2024
     */
    int insertSelective(OrderItems record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_items
     *
     * @mbg.generated Fri May 17 12:06:54 CST 2024
     */
    List<OrderItems> selectByExample(OrderItemsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_items
     *
     * @mbg.generated Fri May 17 12:06:54 CST 2024
     */
    OrderItems selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_items
     *
     * @mbg.generated Fri May 17 12:06:54 CST 2024
     */
    int updateByPrimaryKeySelective(OrderItems record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_items
     *
     * @mbg.generated Fri May 17 12:06:54 CST 2024
     */
    int updateByPrimaryKey(OrderItems record);

    /**
     * @description 根据订单id删除订单商品明细
     * @author xielulin
     * @date 2024/4/26
     * @param orderId
     * @return int
     */
    int deleteByOrderId(Integer orderId);

    /**
     * @description 根据企业id和日期获取各产品的销售额数据
     * @author xielulin
     * @date 2024/5/4
     * @param comId
     * @param date
     * @param userId
     * @return java.util.List<com.erp.param.SkuSalesRevenueDto>
     */
    List<SkuSalesRevenueDto> getSkuSalesRevenue(@Param("comId") Integer comId, @Param("userId") Integer userId, @Param("date") String date);

    /**
     * @description 根据企业id和日期获取各产品的销售数数据
     * @author xielulin
     * @date 2024/5/4
     * @param comId
     * @param date
     * @param userId
     * @return java.util.List<com.erp.dto.SkuSalesNumDto>
     */
    List<SkuSalesNumDto> getSkuSalesNum(@Param("comId") Integer comId, @Param("userId") Integer userId, @Param("date") String date);

    /**
     * @description 根据企业id和产品id获取近12个月产品的销售数
     * @author xielulin
     * @date 2024/5/4
     * @param comId
     * @param skuId
     * @param comId
     * @return java.util.List<com.erp.dto.SkuSalesDataDto>
     */
    List<SkuSalesDataDto> getSalesMonthData(@Param("comId") Integer comId,@Param("userId") Integer userId, @Param("skuId") Integer skuId);

    /**
     * @description 根据企业id和产品id获取近30天产品的销售数
     * @author xielulin
     * @date 2024/5/4
     * @param comId
     * @param skuId
     * @return java.util.List<com.erp.dto.SkuSalesDataDto>
     */
    List<SkuSalesDataDto> getSalesDayData(@Param("comId") Integer comId, @Param("userId") Integer userId, @Param("skuId")Integer skuId);


}