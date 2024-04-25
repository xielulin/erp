package com.erp.service;

import com.erp.bean.Business;
import com.erp.exception.BaseException;
import com.erp.param.GetBusiness;
import com.github.pagehelper.PageInfo;

/**
 * @author xielulin
 * @create 2024-04-25 13:57
 * @desc
 **/
public interface BusinessService {
    /**
     * @description 获取商户数据列表
     * @author xielulin
     * @date 2024/4/25
     * @param param
     * @return com.github.pagehelper.Page<com.erp.bean.Business>
     */
    PageInfo<Business> getBusinessList(GetBusiness param) throws BaseException;
}
