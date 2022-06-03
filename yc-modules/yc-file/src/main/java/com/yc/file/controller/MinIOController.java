package com.yc.file.controller;

import com.yc.common.core.base.result.RespBody;
import com.yc.file.util.MinioUtil;
import io.minio.messages.Bucket;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @description:
 * @author: youcong
 */
@RestController
@Api(tags = {"基于MinIO对象存储"}, description = "基于MinIO对象存储")
public class MinIOController {
    @Autowired
    private MinioUtil minioUtil;

    @GetMapping("/bucketExists")
    @ApiOperation(value = "查看存储bucket是否存在")
    public RespBody bucketExists(String bucketName) {
        return RespBody.success(minioUtil.bucketExists(bucketName));
    }


    @GetMapping("/makeBucket")
    @ApiOperation(value = "创建存储bucket")
    public RespBody makeBucket(String bucketName) {
        minioUtil.makeBucket(bucketName);
        return RespBody.success();
    }


    @GetMapping("/removeBucket")
    @ApiOperation(value = "删除存储bucket")
    public RespBody removeBucket(String bucketName) {
        minioUtil.removeBucket(bucketName);
        return RespBody.success();
    }


    @GetMapping("/getAllBuckets")
    @ApiOperation(value = "获取全部bucket")
    public RespBody<List<Bucket>> getAllBuckets() {
        List<Bucket> allBuckets = minioUtil.getAllBuckets();
        return RespBody.success(allBuckets);
    }


    @PostMapping("/upload")
    @ApiOperation(value = "文件上传返回url")
    public RespBody<String> upload(@RequestParam(value = "file") MultipartFile file) {
        String objectName = minioUtil.upload(file);
        if (null != objectName) {
            String endPoint = "http://127.0.0.1:9000";
            return RespBody.success(endPoint + "/" + objectName);
        }
        return RespBody.fail();
    }


    @GetMapping("/preview")
    @ApiOperation(value = "图片/视频预览")
    public RespBody preview(@RequestParam("fileName") String fileName) {
        return RespBody.success(minioUtil.preview(fileName));
    }


    @GetMapping("/download")
    @ApiOperation(value = "文件下载")
    public RespBody download(@RequestParam("fileName") String fileName, HttpServletResponse res) {
        minioUtil.download(fileName, res);
        return RespBody.success();
    }


    @PostMapping("/delete")
    @ApiOperation(value = "删除文件", notes = "根据url地址删除文件")
    public RespBody remove(String url) {
        String objName = url.substring(url.lastIndexOf("test" + "/") + "test".length() + 1);
        minioUtil.remove(objName);
        return RespBody.success();
    }

}
