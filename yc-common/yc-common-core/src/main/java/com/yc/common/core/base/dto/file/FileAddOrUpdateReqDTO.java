package com.yc.common.core.base.dto.file;

import lombok.Data;

/**
 * @description:
 * @author: youcong
 * @time: 2021/9/28 20:58
 */
@Data
public class FileAddOrUpdateReqDTO {
    private String id;

    private String fileName;

    private String fileUrl;

    private String fileSize;

    private Integer fileType;

    private Integer fileStatus;

    private String uploadId;

    private Long companyId;

    private String filePassword;
}
