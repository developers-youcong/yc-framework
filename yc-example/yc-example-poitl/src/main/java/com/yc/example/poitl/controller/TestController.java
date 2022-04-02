package com.yc.example.poitl.controller;

import com.deepoove.poi.XWPFTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.util.HashMap;

/**
 * @description:
 * @author: youcong
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        try {
            XWPFTemplate template = XWPFTemplate.compile("template.docx").render(
                    new HashMap<String, Object>() {{
                        put("title", "Hi, poi-tl Word模板引擎");
                    }});
            template.writeAndClose(new FileOutputStream("output.docx"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "poi-tl test";
    }


}
