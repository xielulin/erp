package com.erp.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class OrderForm {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_form.id
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_form.com_id
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    private Integer comId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_form.com_name
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    private String comName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_form.user_id
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_form.sku_num
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    private Integer skuNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_form.price
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    private BigDecimal price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_form.customer_id
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    private Integer customerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_form.logistics_name
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    private String logisticsName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_form.customer_name
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    private String customerName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_form.customer_addr
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    private String customerAddr;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_form.customer_tel
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    private String customerTel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_form.com_tel
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    private String comTel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_form.is_del
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    private Boolean isDel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_form.create_time
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_form.id
     *
     * @return the value of order_form.id
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_form.id
     *
     * @param id the value for order_form.id
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_form.com_id
     *
     * @return the value of order_form.com_id
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    public Integer getComId() {
        return comId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_form.com_id
     *
     * @param comId the value for order_form.com_id
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    public void setComId(Integer comId) {
        this.comId = comId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_form.com_name
     *
     * @return the value of order_form.com_name
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    public String getComName() {
        return comName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_form.com_name
     *
     * @param comName the value for order_form.com_name
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    public void setComName(String comName) {
        this.comName = comName == null ? null : comName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_form.user_id
     *
     * @return the value of order_form.user_id
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_form.user_id
     *
     * @param userId the value for order_form.user_id
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_form.sku_num
     *
     * @return the value of order_form.sku_num
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    public Integer getSkuNum() {
        return skuNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_form.sku_num
     *
     * @param skuNum the value for order_form.sku_num
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    public void setSkuNum(Integer skuNum) {
        this.skuNum = skuNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_form.price
     *
     * @return the value of order_form.price
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_form.price
     *
     * @param price the value for order_form.price
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_form.customer_id
     *
     * @return the value of order_form.customer_id
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_form.customer_id
     *
     * @param customerId the value for order_form.customer_id
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_form.logistics_name
     *
     * @return the value of order_form.logistics_name
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    public String getLogisticsName() {
        return logisticsName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_form.logistics_name
     *
     * @param logisticsName the value for order_form.logistics_name
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    public void setLogisticsName(String logisticsName) {
        this.logisticsName = logisticsName == null ? null : logisticsName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_form.customer_name
     *
     * @return the value of order_form.customer_name
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_form.customer_name
     *
     * @param customerName the value for order_form.customer_name
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_form.customer_addr
     *
     * @return the value of order_form.customer_addr
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    public String getCustomerAddr() {
        return customerAddr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_form.customer_addr
     *
     * @param customerAddr the value for order_form.customer_addr
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    public void setCustomerAddr(String customerAddr) {
        this.customerAddr = customerAddr == null ? null : customerAddr.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_form.customer_tel
     *
     * @return the value of order_form.customer_tel
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    public String getCustomerTel() {
        return customerTel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_form.customer_tel
     *
     * @param customerTel the value for order_form.customer_tel
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    public void setCustomerTel(String customerTel) {
        this.customerTel = customerTel == null ? null : customerTel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_form.com_tel
     *
     * @return the value of order_form.com_tel
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    public String getComTel() {
        return comTel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_form.com_tel
     *
     * @param comTel the value for order_form.com_tel
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    public void setComTel(String comTel) {
        this.comTel = comTel == null ? null : comTel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_form.is_del
     *
     * @return the value of order_form.is_del
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    public Boolean getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_form.is_del
     *
     * @param isDel the value for order_form.is_del
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_form.create_time
     *
     * @return the value of order_form.create_time
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    public Timestamp getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_form.create_time
     *
     * @param createTime the value for order_form.create_time
     *
     * @mbg.generated Fri Apr 26 21:31:23 CST 2024
     */
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}