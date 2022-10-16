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

## 四、博客文章
[开源项目之word模板引擎](https://mp.weixin.qq.com/s?__biz=MzUxODk0ODQ3Ng==&mid=2247487099&idx=1&sn=3d5882f20d864bfc822a2117627d7483&chksm=f9805d68cef7d47e80a8a85f6d8de123b55ddb472c751a1fb13abcea93ba486251f8564a1077&token=730841189&lang=zh_CN#rd)