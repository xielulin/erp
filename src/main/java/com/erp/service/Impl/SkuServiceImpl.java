package com.erp.service.Impl;

import com.erp.bean.Sku;
import com.erp.bean.User;
import com.erp.dao.SkuMapper;
import com.erp.exception.BaseException;
import com.erp.exception.EmBussinessError;
import com.erp.param.EditSkuParam;
import com.erp.param.GetSkuListParam;
import com.erp.param.SaveSkuParam;
import com.erp.service.SkuService;
import com.erp.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xielulin
 * @create 2024-04-25 20:53
 * @desc 商品
 **/
@Service
public class SkuServiceImpl implements SkuService {
    @Resource
    private SkuMapper skuMapper;
    @Resource
   private UserService userService;
    @Override
    public PageInfo<Sku> getSkuList(GetSkuListParam param) {
        User user = userService.getUserById(param.getUserId());
        if(user == null){
            return null;
        }
        PageHelper.startPage(param.getPageNum(), param.getPageSize());
        List<Sku> customers = skuMapper.selectByComIdAndKeyword(user.getComId(),param.getKeyword());
        PageInfo<Sku> pageInfo = new PageInfo<>(customers);
        return pageInfo;
    }

    @Override
    public Sku getSkuById(Integer id) throws BaseException {
        Sku sku = skuMapper.selectByPrimaryKey(id);
        if(sku ==null || sku.getIsDel()){
            throw new BaseException(EmBussinessError.SKU_NOT_EXIST);
        }
        return sku;
    }

    @Override
    public int editSku(EditSkuParam param) {
        Sku sku = new Sku();
        BeanUtils.copyProperties(param,sku);
        return skuMapper.updateByPrimaryKeySelective(sku);
    }

    @Override
    public int addSku(SaveSkuParam param) throws BaseException {
        Sku sku = new Sku();
        BeanUtils.copyProperties(param,sku);
        User user = userService.getUserById(param.getUserId());
        if(user == null){
            throw new BaseException(EmBussinessError.USER_NOT_EXIT);
        }
        sku.setComId(user.getComId());
        return skuMapper.insertSelective(sku);
    }

    @Override
    public int delSku(int id) throws BaseException {
        Sku sku = getSkuById(id);
        sku.setIsDel(true);
        return skuMapper.updateByPrimaryKeySelective(sku);
    }
}
