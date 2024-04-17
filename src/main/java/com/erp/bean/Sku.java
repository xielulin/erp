package com.erp.bean;

public class Sku {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sku.id
     *
     * @mbg.generated Wed Apr 17 19:56:18 CST 2024
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sku.name
     *
     * @mbg.generated Wed Apr 17 19:56:18 CST 2024
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sku.code
     *
     * @mbg.generated Wed Apr 17 19:56:18 CST 2024
     */
    private String code;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sku.specification
     *
     * @mbg.generated Wed Apr 17 19:56:18 CST 2024
     */
    private String specification;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sku.remarks
     *
     * @mbg.generated Wed Apr 17 19:56:18 CST 2024
     */
    private String remarks;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sku.price
     *
     * @mbg.generated Wed Apr 17 19:56:18 CST 2024
     */
    private Long price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sku.is_del
     *
     * @mbg.generated Wed Apr 17 19:56:18 CST 2024
     */
    private Boolean isDel;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sku.id
     *
     * @return the value of sku.id
     *
     * @mbg.generated Wed Apr 17 19:56:18 CST 2024
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sku.id
     *
     * @param id the value for sku.id
     *
     * @mbg.generated Wed Apr 17 19:56:18 CST 2024
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sku.name
     *
     * @return the value of sku.name
     *
     * @mbg.generated Wed Apr 17 19:56:18 CST 2024
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sku.name
     *
     * @param name the value for sku.name
     *
     * @mbg.generated Wed Apr 17 19:56:18 CST 2024
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sku.code
     *
     * @return the value of sku.code
     *
     * @mbg.generated Wed Apr 17 19:56:18 CST 2024
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sku.code
     *
     * @param code the value for sku.code
     *
     * @mbg.generated Wed Apr 17 19:56:18 CST 2024
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sku.specification
     *
     * @return the value of sku.specification
     *
     * @mbg.generated Wed Apr 17 19:56:18 CST 2024
     */
    public String getSpecification() {
        return specification;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sku.specification
     *
     * @param specification the value for sku.specification
     *
     * @mbg.generated Wed Apr 17 19:56:18 CST 2024
     */
    public void setSpecification(String specification) {
        this.specification = specification == null ? null : specification.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sku.remarks
     *
     * @return the value of sku.remarks
     *
     * @mbg.generated Wed Apr 17 19:56:18 CST 2024
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sku.remarks
     *
     * @param remarks the value for sku.remarks
     *
     * @mbg.generated Wed Apr 17 19:56:18 CST 2024
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sku.price
     *
     * @return the value of sku.price
     *
     * @mbg.generated Wed Apr 17 19:56:18 CST 2024
     */
    public Long getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sku.price
     *
     * @param price the value for sku.price
     *
     * @mbg.generated Wed Apr 17 19:56:18 CST 2024
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sku.is_del
     *
     * @return the value of sku.is_del
     *
     * @mbg.generated Wed Apr 17 19:56:18 CST 2024
     */
    public Boolean getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sku.is_del
     *
     * @param isDel the value for sku.is_del
     *
     * @mbg.generated Wed Apr 17 19:56:18 CST 2024
     */
    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }
}