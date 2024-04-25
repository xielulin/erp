package com.erp.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author xielulin
 * @create 2024-04-25 21:11
 * @desc
 **/
@Data
public class SaveSkuParam {
    @NotNull
    private Integer userId;
    @NotBlank
    private String name;
    @NotBlank
    private String code;
    @NotBlank
    private String specification;
    private String remarks;
    @NotNull
    private BigDecimal price;
}
