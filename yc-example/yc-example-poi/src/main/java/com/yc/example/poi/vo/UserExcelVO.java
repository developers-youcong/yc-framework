package com.yc.example.poi.vo;


import com.yc.common.core.base.annotation.Excel;
import lombok.Data;

/**
 * @description:
 * @author: youcong
 */
@Data
public class UserExcelVO {

    @Excel(name = "姓名")
    private String userName;

    @Excel(name = "年龄")
    private Integer age;

}
