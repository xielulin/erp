package com.erp.service;

import com.erp.bean.Sku;
import com.erp.exception.BaseException;
import com.erp.param.EditSkuParam;
import com.erp.param.GetSkuListParam;
import com.erp.param.SaveSkuParam;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author xielulin
 * @create 2024-04-25 20:50
 * @desc
 **/
public interface SkuService {
    /**
     * @description 查询sku列表
     * @author xielulin
     * @date 2024/4/25
     * @param param
     * @return com.github.pagehelper.PageInfo<com.erp.bean.Sku>
     */
    PageInfo<Sku> getSkuList(GetSkuListParam param) throws BaseException;

    /**
     * @description 根据id获取sku
     * @author xielulin
     * @date 2024/4/25
     * @param id
     * @return com.erp.bean.Sku
     */
    Sku getSkuById(Integer id) throws BaseException;

    /**
     * @description 修改sku
     * @author xielulin
     * @date 2024/4/25
     * @param param
     * @param userId
     * @return int
     */
    int editSku(EditSkuParam param, Integer userId) throws BaseException;

    /**
     * @description 新增sku
     * @author xielulin
     * @date 2024/4/25
     * @param param
     * @return int
     */
    int addSku(SaveSkuParam param) throws BaseException;

    /**
     * @description 删除sku
     * @author xielulin
     * @date 2024/4/25
     * @param id
     * @param userId
     * @return int
     */
    int delSku(int id, Integer userId) throws BaseException;

    List<Sku> getSkuListByUserId(Integer userId) throws BaseException;
}
