package com.erp.param;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author xielulin
 * @create 2024-04-23 11:49
 * @desc 分页
 **/
@Data
public class PageParam {
    @NotNull
    @Min(value = 1,message = "pageNum不能小于1")
    private Integer pageNum;
    @NotNull
    @Min(value = 1,message = "pageSize不能小于1")
    private Integer pageSize;
}
