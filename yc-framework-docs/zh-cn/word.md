# Word模板引擎

## 一、导入Maven依赖
```
<dependency>
  <groupId>com.deepoove</groupId>
  <artifactId>poi-tl</artifactId>
  <version>1.11.0</version>
</dependency>

```

## 二、阅读官方文档
官方文档地址为:
http://deepoove.com/poi-tl/

源代码地址为:
https://github.com/Sayi/poi-tl

## 三、核心代码
```
XWPFTemplate template = XWPFTemplate.compile(templatePath)
        .render(mapResult);


```