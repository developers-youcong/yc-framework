package com.yc.example.easypoi.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.hutool.core.util.RandomUtil;

import com.yc.example.easypoi.vo.BankVO;
import com.yc.example.easypoi.vo.ChinaBankVO;
import com.yc.example.easypoi.vo.ICBCVO;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: youcong
 */

@RestController
public class TestController {

    @GetMapping("/exportExcelTest")
    public void exportExcelTest(HttpServletResponse response) {
        Workbook workbook = null;
        try {
            List<BankVO> dataList1 = new ArrayList<>();
            List<BankVO> dataList2 = new ArrayList<>();
            for (int i = 1; i <= 100; i++) {
                BankVO bankVO = new BankVO();
                bankVO.setNum(i);
                bankVO.setName("姓名" + i);
                List<ChinaBankVO> chinaBankVOList = new ArrayList<>();
                List<ICBCVO> icbcvoList = new ArrayList<>();
                ChinaBankVO cVo = new ChinaBankVO();
                cVo.setAccount(Long.valueOf(RandomUtil.randomNumbers(4)));
                cVo.setTotal(new BigDecimal(RandomUtil.randomNumbers(5)));
                ICBCVO icbcVo = new ICBCVO();
                icbcVo.setAccount(Long.valueOf(RandomUtil.randomNumbers(4)));
                icbcVo.setTotal(new BigDecimal(RandomUtil.randomNumbers(5)));
                chinaBankVOList.add(cVo);
                icbcvoList.add(icbcVo);
                bankVO.setChinaBankVOList(chinaBankVOList);
                bankVO.setIcbcvoList(icbcvoList);
                dataList1.add(bankVO);
                dataList2.add(bankVO);
            }

            List<Map<String, Object>> sheetsList = new ArrayList<>();
            ExportParams siteDayExportParams = new ExportParams();
            siteDayExportParams.setSheetName("中国银行");
            // siteDayExportParams.setStyle(ExcelExportStyler.class);
            ExportParams siteMonthExportParams = new ExportParams();
            siteMonthExportParams.setSheetName("工商银行");
            //siteMonthExportParams.setStyle(ExcelExportStyler.class);
            // 创建sheet1使用得map
            Map<String, Object> siteDayExportMap = new HashMap<>();
            // title的参数为ExportParams类型，目前仅仅在ExportParams中设置了sheetName
            siteDayExportMap.put("title", siteDayExportParams);
            // 模版导出对应得实体类型
            siteDayExportMap.put("entity", BankVO.class);
            // sheet中要填充得数据
            siteDayExportMap.put("data", dataList1);
            // 创建sheet2使用得map
            Map<String, Object> siteMonthExportMap = new HashMap<>();
            siteMonthExportMap.put("title", siteMonthExportParams);
            siteMonthExportMap.put("entity", BankVO.class);
            siteMonthExportMap.put("data", dataList2);

            sheetsList.add(siteDayExportMap);
            sheetsList.add(siteMonthExportMap);

            // Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), ExcelTemplateVO.class, dataList);
            workbook = ExcelExportUtil.exportExcel(sheetsList, ExcelType.HSSF);
            // 指定下载的文件名--设置响应头
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("银行账号信息.xls", "UTF-8"));
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            // 写出数据输出流到页面
            OutputStream output = response.getOutputStream();
            BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
            workbook.write(bufferedOutPut);
            bufferedOutPut.flush();
            bufferedOutPut.close();
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
