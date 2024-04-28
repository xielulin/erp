package com.erp.bean;

import java.math.BigDecimal;

public class OrderItems {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_items.id
     *
     * @mbg.generated Sun Apr 28 16:19:05 CST 2024
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_items.order_id
     *
     * @mbg.generated Sun Apr 28 16:19:05 CST 2024
     */
    private Integer orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_items.sku_id
     *
     * @mbg.generated Sun Apr 28 16:19:05 CST 2024
     */
    private Integer skuId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_items.sku_name
     *
     * @mbg.generated Sun Apr 28 16:19:05 CST 2024
     */
    private String skuName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_items.sku_specification
     *
     * @mbg.generated Sun Apr 28 16:19:05 CST 2024
     */
    private String skuSpecification;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_items.sku_num
     *
     * @mbg.generated Sun Apr 28 16:19:05 CST 2024
     */
    private Integer skuNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_items.code
     *
     * @mbg.generated Sun Apr 28 16:19:05 CST 2024
     */
    private String code;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_items.price
     *
     * @mbg.generated Sun Apr 28 16:19:05 CST 2024
     */
    private BigDecimal price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_items.total_price
     *
     * @mbg.generated Sun Apr 28 16:19:05 CST 2024
     */
    private BigDecimal totalPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_items.remarks
     *
     * @mbg.generated Sun Apr 28 16:19:05 CST 2024
     */
    private String remarks;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_items.id
     *
     * @return the value of order_items.id
     *
     * @mbg.generated Sun Apr 28 16:19:05 CST 2024
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_items.id
     *
     * @param id the value for order_items.id
     *
     * @mbg.generated Sun Apr 28 16:19:05 CST 2024
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_items.order_id
     *
     * @return the value of order_items.order_id
     *
     * @mbg.generated Sun Apr 28 16:19:05 CST 2024
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_items.order_id
     *
     * @param orderId the value for order_items.order_id
     *
     * @mbg.generated Sun Apr 28 16:19:05 CST 2024
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_items.sku_id
     *
     * @return the value of order_items.sku_id
     *
     * @mbg.generated Sun Apr 28 16:19:05 CST 2024
     */
    public Integer getSkuId() {
        return skuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_items.sku_id
     *
     * @param skuId the value for order_items.sku_id
     *
     * @mbg.generated Sun Apr 28 16:19:05 CST 2024
     */
    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_items.sku_name
     *
     * @return the value of order_items.sku_name
     *
     * @mbg.generated Sun Apr 28 16:19:05 CST 2024
     */
    public String getSkuName() {
        return skuName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_items.sku_name
     *
     * @param skuName the value for order_items.sku_name
     *
     * @mbg.generated Sun Apr 28 16:19:05 CST 2024
     */
    public void setSkuName(String skuName) {
        this.skuName = skuName == null ? null : skuName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_items.sku_specification
     *
     * @return the value of order_items.sku_specification
     *
     * @mbg.generated Sun Apr 28 16:19:05 CST 2024
     */
    public String getSkuSpecification() {
        return skuSpecification;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_items.sku_specification
     *
     * @param skuSpecification the value for order_items.sku_specification
     *
     * @mbg.generated Sun Apr 28 16:19:05 CST 2024
     */
    public void setSkuSpecification(String skuSpecification) {
        this.skuSpecification = skuSpecification == null ? null : skuSpecification.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_items.sku_num
     *
     * @return the value of order_items.sku_num
     *
     * @mbg.generated Sun Apr 28 16:19:05 CST 2024
     */
    public Integer getSkuNum() {
        return skuNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_items.sku_num
     *
     * @param skuNum the value for order_items.sku_num
     *
     * @mbg.generated Sun Apr 28 16:19:05 CST 2024
     */
    public void setSkuNum(Integer skuNum) {
        this.skuNum = skuNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_items.code
     *
     * @return the value of order_items.code
     *
     * @mbg.generated Sun Apr 28 16:19:05 CST 2024
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_items.code
     *
     * @param code the value for order_items.code
     *
     * @mbg.generated Sun Apr 28 16:19:05 CST 2024
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_items.price
     *
     * @return the value of order_items.price
     *
     * @mbg.generated Sun Apr 28 16:19:05 CST 2024
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_items.price
     *
     * @param price the value for order_items.price
     *
     * @mbg.generated Sun Apr 28 16:19:05 CST 2024
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_items.total_price
     *
     * @return the value of order_items.total_price
     *
     * @mbg.generated Sun Apr 28 16:19:05 CST 2024
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_items.total_price
     *
     * @param totalPrice the value for order_items.total_price
     *
     * @mbg.generated Sun Apr 28 16:19:05 CST 2024
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_items.remarks
     *
     * @return the value of order_items.remarks
     *
     * @mbg.generated Sun Apr 28 16:19:05 CST 2024
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_items.remarks
     *
     * @param remarks the value for order_items.remarks
     *
     * @mbg.generated Sun Apr 28 16:19:05 CST 2024
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}