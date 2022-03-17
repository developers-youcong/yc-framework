package com.yc.example.easypoi.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @description:
 * @author: youcong
 */
@Data
public class ChinaBankVO {
    @Excel(name = "账号", orderNum = "1", height = 10, width = 20)
    private Long account;
    @Excel(name = "余额", orderNum = "2", height = 10, width = 20)
    private BigDecimal total;
}
