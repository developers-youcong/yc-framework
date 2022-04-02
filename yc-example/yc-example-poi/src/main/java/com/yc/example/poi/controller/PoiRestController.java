package com.yc.example.poi.controller;

import com.yc.common.core.base.utils.poi.ExcelUtil;
import com.yc.example.poi.vo.UserExcelVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: youcong
 */
@RestController
public class PoiRestController {

    @PostMapping("/importData")
    public void importData(MultipartFile file) {
        try {
            //读取Excel数据
            ExcelUtil<UserExcelVO> util = new ExcelUtil<UserExcelVO>(UserExcelVO.class);
            List<UserExcelVO> excelDataList = util.importExcel(file.getInputStream(), 4);
            if (!excelDataList.isEmpty()) {
                for (UserExcelVO vo : excelDataList) {
                    System.out.println("vo:" + vo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/exportData")
    public void exportData(HttpServletResponse response) throws Exception {
        List<UserExcelVO> list = new ArrayList<>();
        UserExcelVO vo = new UserExcelVO();
        vo.setUserName("It is a test");
        vo.setAge(20);
        list.add(vo);
        ExcelUtil<UserExcelVO> util = new ExcelUtil<UserExcelVO>(UserExcelVO.class);
        util.exportExcel(response, list, "用户信息");
    }
}
