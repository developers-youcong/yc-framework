package com.yc.xjar.controller;

import cn.hutool.core.util.IdUtil;
import com.yc.common.core.base.result.RespBody;
import io.xjar.XCryptos;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.math.BigDecimal;

/**
 * @description:
 * @author: youcong
 */
@RestController
public class XjarController {

    private String fileStorePath="D://test/jar_backup//";

    private String outEncrypPath="D://test//jar_encryp//";

    @PostMapping("/xjar_handle")
    public RespBody xjar_hanlde(@RequestParam("file") MultipartFile[] files) {
        try {
            if (files.length > 0) {
                for (int i = 0; i < files.length; i++) {
                    saveFile(fileStorePath, files[i]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RespBody.success();
    }

    private void saveFile(String filePath, MultipartFile file) {
        try {
            //原文件名
            String originalFileName = file.getOriginalFilename();
            //获取文件扩展名
            String extName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            //重新定义文件名
            String fileName = originalFileName + extName;
            // 显示文件容量
            String fileSize = String.valueOf(new BigDecimal(file.getSize()).divide(new BigDecimal("1024"), 0, BigDecimal.ROUND_HALF_UP));
            File temp = new File(filePath);
            if (!temp.exists()) {
                temp.mkdirs();
            }
            if (fileSize.length() > 0) {
                File localFile = new File(filePath + fileName);
                //把上传的文件保存至本地
                file.transferTo(localFile);
                //本地加密
                XCryptos.encryption()
                        .from(localFile)
                        .use("io.xjar")
                        .include("/io/xjar/**/*.class")
                        .include("/mapper/**/*Mapper.xml")
                        .include("/*.yml")
                        .exclude("/static/**/*")
                        .exclude("/conf/*")
                        .to(outEncrypPath+"encrypt_"+originalFileName+".jar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
