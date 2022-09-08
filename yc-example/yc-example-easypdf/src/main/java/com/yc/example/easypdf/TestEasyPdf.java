package com.yc.example.easypdf;

import wiki.xsx.core.pdf.component.text.XEasyPdfText;
import wiki.xsx.core.pdf.doc.XEasyPdfDocument;
import wiki.xsx.core.pdf.doc.XEasyPdfPage;
import wiki.xsx.core.pdf.handler.XEasyPdfHandler;

import java.io.IOException;

/**
 * @description:
 * @author: youcong
 */
public class TestEasyPdf {
    // 根据自身情况选择对应保存路径
    private static final String OUTPUT_PATH = "D:\\test\\x-easypdf.pdf";

    public static void main(String[] args) throws IOException {
        // 创建文档
        XEasyPdfDocument document = XEasyPdfHandler.Document.build();
        // 创建页面
        XEasyPdfPage page = XEasyPdfHandler.Page.build();
        // 创建文本组件
        XEasyPdfText text = XEasyPdfHandler.Text.build("It is a test");
        // 将组件添加到页面
        page.addComponent(text);
        // 将页面添加到文档
        document.addPage(page);
        // 保存文档并关闭
        document.save(OUTPUT_PATH).close();
    }
}
