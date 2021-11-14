package com.yc.common.core.base.entity.file;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: youcong
 * @time: 2021/9/20 20:36
 */
@Data
@TableName("yc_file")
public class FileEntity {

    @TableId
    private String id;

    @TableField("file_name")
    private String fileName;

    @TableField("file_url")
    private String fileUrl;

    @TableField("file_size")
    private String fileSize;

    @TableField("file_type")
    private Integer fileType;

    @TableField("file_status")
    private Integer fileStatus;

    @TableField("upload_id")
    private String uploadId;

    @TableField("company_id")
    private Long companyId;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;

    @TableField("file_password")
    private String filePassword;
}
