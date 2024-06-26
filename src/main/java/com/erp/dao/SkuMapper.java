package com.erp.dao;

import com.erp.bean.Sku;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SkuMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sku
     *
     * @mbg.generated Tue May 14 21:03:10 CST 2024
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sku
     *
     * @mbg.generated Tue May 14 21:03:10 CST 2024
     */
    int insert(Sku record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sku
     *
     * @mbg.generated Tue May 14 21:03:10 CST 2024
     */
    int insertSelective(Sku record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sku
     *
     * @mbg.generated Tue May 14 21:03:10 CST 2024
     */
    Sku selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sku
     *
     * @mbg.generated Tue May 14 21:03:10 CST 2024
     */
    int updateByPrimaryKeySelective(Sku record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sku
     *
     * @mbg.generated Tue May 14 21:03:10 CST 2024
     */
    int updateByPrimaryKey(Sku record);

    List<Sku> selectByComIdAndKeyword(@Param("comId") Integer comId, @Param("keyword") String keyword);
}