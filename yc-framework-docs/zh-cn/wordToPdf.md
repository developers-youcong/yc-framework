# Word转Pdf

## 一、导入依赖
```
<dependency>
    <groupId>org.docx4j</groupId>
    <artifactId>docx4j</artifactId>
    <version>6.0.1</version>
    <exclusions>
        <exclusion>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
        </exclusion>
        <exclusion>
            <artifactId>slf4j-log4j12</artifactId>
            <groupId>org.slf4j</groupId>
        </exclusion>
    </exclusions>
</dependency>

<!-- 转出pdf需要 -->
<dependency>
    <groupId>org.docx4j</groupId>
    <artifactId>docx4j-export-fo</artifactId>
    <version>6.1.0</version>
    <exclusions>
        <exclusion>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
        </exclusion>
        <exclusion>
            <artifactId>slf4j-log4j12</artifactId>
            <groupId>org.slf4j</groupId>
        </exclusion>
    </exclusions>
</dependency>

```

## 二、核心代码
```
public class PdfUtil {
    /*
     * inPath word路径   outPath pdf路径
     */
    public static void doc3pdf(String inPath, String outPath) {
        try {
            WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(new File(inPath));
            Mapper fontMapper = new IdentityPlusMapper();
            fontMapper.put("隶书", PhysicalFonts.get("LiSu"));
            fontMapper.put("宋体", PhysicalFonts.get("SimSun"));
            fontMapper.put("微软雅黑", PhysicalFonts.get("Microsoft Yahei"));
            fontMapper.put("黑体", PhysicalFonts.get("SimHei"));
            fontMapper.put("楷体", PhysicalFonts.get("KaiTi"));
            fontMapper.put("新宋体", PhysicalFonts.get("NSimSun"));
            fontMapper.put("华文行楷", PhysicalFonts.get("STXingkai"));
            fontMapper.put("华文仿宋", PhysicalFonts.get("STFangsong"));
            fontMapper.put("仿宋", PhysicalFonts.get("FangSong"));
            fontMapper.put("幼圆", PhysicalFonts.get("YouYuan"));
            fontMapper.put("华文宋体", PhysicalFonts.get("STSong"));
            fontMapper.put("华文中宋", PhysicalFonts.get("STZhongsong"));
            fontMapper.put("等线", PhysicalFonts.get("SimSun"));
            fontMapper.put("等线 Light", PhysicalFonts.get("SimSun"));
            fontMapper.put("华文琥珀", PhysicalFonts.get("STHupo"));
            fontMapper.put("华文隶书", PhysicalFonts.get("STLiti"));
            fontMapper.put("华文新魏", PhysicalFonts.get("STXinwei"));
            fontMapper.put("华文彩云", PhysicalFonts.get("STCaiyun"));
            fontMapper.put("方正姚体", PhysicalFonts.get("FZYaoti"));
            fontMapper.put("方正舒体", PhysicalFonts.get("FZShuTi"));
            fontMapper.put("华文细黑", PhysicalFonts.get("STXihei"));
            fontMapper.put("宋体扩展", PhysicalFonts.get("simsun-extB"));
            fontMapper.put("仿宋_GB2312", PhysicalFonts.get("FangSong_GB2312"));
            fontMapper.put("新細明體", PhysicalFonts.get("SimSun"));
            //解决宋体（正文）和宋体（标题）的乱码问题
            PhysicalFonts.put("PMingLiU", PhysicalFonts.get("SimSun"));
            PhysicalFonts.put("新細明體", PhysicalFonts.get("SimSun"));
            wordMLPackage.setFontMapper(fontMapper);
            FOSettings foSettings = Docx4J.createFOSettings();
            foSettings.setWmlPackage(wordMLPackage);
            wordMLPackage.setFontMapper(fontMapper);
            OutputStream os = new java.io.FileOutputStream(outPath);
            Docx4J.toFO(foSettings, os, Docx4J.FLAG_EXPORT_PREFER_XSL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

```