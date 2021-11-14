package com.yc.common.core.base.utils.file;

import cn.hutool.core.lang.Console;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: youcong
 * @time: 2021/9/28 20:23
 */
public class FileUtil {


    /**
     * 上传文件
     *
     * @param url 域名或ip
     * @param uploadFilePath 上传服务器路径
     * @param accessServerDir 映射访问路径
     * @param file 文件
     * @return
     */
    public static Map<String, Object> uploadFile(String url, String uploadFilePath, String accessServerDir, MultipartFile file) {
        Map<String, Object> returnMap = new HashMap<>();
        //获取文件扩展名
        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //原文件名
        String originalFileName = file.getOriginalFilename();
        //重新定义文件名
        String newfileName = System.currentTimeMillis() + extName;
        String filePath = uploadFilePath;
        File temp = new File(filePath);
        if (!temp.exists()) {
            temp.mkdirs();
        }
        File localFile = new File(filePath + newfileName);
        String fileUrl = url + accessServerDir + newfileName;
        try {
            file.transferTo(localFile); //把上传的文件保存至本地
            Console.log(file.getOriginalFilename() + " 上传成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        returnMap.put("filename", originalFileName);
        returnMap.put("fileurl", fileUrl);
        return returnMap;
    }

}
