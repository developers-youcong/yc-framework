# Excel数据导入/导出

## 一、Excel数据导入
### 1.导入类模板
```
@Data
public class PostExcelImportVo implements Serializable {

    @Excel(name = "文章URL")
    private String url;
    ......
}
```

### 2.核心导入代码
```
ExcelUtil<PostExcelImportVo>util=new ExcelUtil<PostExcelImportVo>(PostExcelImportVo.class);
List<PostExcelImportVo> excelDataList = util.importExcel(file.getInputStream(), 0);

```
## 二、Excel数据导出
### 1.导出类模板
```
@Data
public class PostExcelExportVo implements Serializable {
    @Excel(name = "文章ID")
    private String ID;
    @Excel(name = "文章名称")
    private String postTitle;
    ......
}

```

### 2.核心导出代码
```
   List<PostExcelExportVo> list = tService.selectList(reqDTO);
    ExcelUtil<PostExcelExportVo> util = new ExcelUtil<PostExcelExportVo>(PostExcelExportVo.class);
    util.exportExcel(response, list, "文章");
```

源代码示例:
https://github.com/developers-youcong/yc-framework/tree/main/yc-example/yc-example-poi
