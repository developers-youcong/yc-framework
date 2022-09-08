package com.yc.example.image_combiner;

import com.freewayso.image.combiner.ImageCombiner;
import com.freewayso.image.combiner.element.TextElement;
import com.freewayso.image.combiner.enums.OutputFormat;

import java.awt.*;

/**
 * @description:
 * @author: youcong
 */
public class TestImageCombiner {

    public static void dynamicWidthDemoTest() throws Exception {
        String bg = "https://framework.youcongtech.com/_media/%E6%8A%80%E6%9C%AF%E6%9E%B6%E6%9E%84%E5%9B%BE-V1.0.jpg";
        ImageCombiner combiner = new ImageCombiner(bg, OutputFormat.JPG);

        String str1 = "Hello";
        String str2 = "小伙伴们 你们好";
        String str3 = "，这是我编写的";
        String str4 = "分布式微服务解决方案";
        int fontSize = 20;
        int xxxFontSize = 40;

        int offsetX = 20;   //通过计算前一个元素的实际宽度，并累加这个偏移量，得到后一个元素正确的x坐标值
        int y = 200;

        //第一段
        TextElement element1 = combiner.addTextElement(str1, fontSize, offsetX, y);
        offsetX += element1.getWidth();     //计算宽度，并累加偏移量

        //第二段（内容不定，宽度也不定）
        TextElement element2 = combiner.addTextElement(str2, xxxFontSize, offsetX, y)
                .setColor(Color.red);
        offsetX += element2.getWidth();

        //第三段
        TextElement element3 = combiner.addTextElement(str3, fontSize, offsetX, y);
        offsetX += element3.getWidth();

        //第四段（内容不定，宽度也不定）
        TextElement element4 = combiner.addTextElement(str4, xxxFontSize, offsetX, y)
                .setColor(Color.YELLOW);
        offsetX += element4.getWidth();

        combiner.combine();
        combiner.save("d://test//demo.jpg");
    }

    public static void main(String[] args) throws Exception {
        dynamicWidthDemoTest();
    }
}
