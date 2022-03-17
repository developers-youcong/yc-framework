package com.yc.example.easypoi.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: youcong
 */
@Data
@ExcelTarget("bankVO")
public class BankVO {
    @Excel(name = "序号", orderNum = "1", height = 10, width = 20)
    private Integer num;
    @Excel(name = "姓名", orderNum = "2", height = 10, width = 20)
    private String name;
    @ExcelCollection(name = "CB", orderNum = "3")
    private List<ChinaBankVO> chinaBankVOList;
    @ExcelCollection(name = "ICBC", orderNum = "4")
    private List<ICBCVO> icbcvoList;

    public List<ChinaBankVO> getcIndexVO() {
        return chinaBankVOList;
    }

    public List<ICBCVO> getSo2VO() {
        return icbcvoList;
    }
}
