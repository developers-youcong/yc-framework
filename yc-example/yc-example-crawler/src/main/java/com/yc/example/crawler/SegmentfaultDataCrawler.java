package com.yc.example.crawler;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import javax.annotation.PostConstruct;

/**
 * @description:
 * @author: youcong
 */
public class SegmentfaultDataCrawler implements PageProcessor {


    private Site site = Site.me()
            .setDomain("https://segmentfault.com/")
            .setSleepTime(1000)
            .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");

    @Override
    public void process(Page page) {
        Selectable obj = page.getHtml().xpath("//div[@class='article-content']");
        Selectable title = obj.xpath("//h1[@class='h2 mb-3']//a");
        Selectable content = obj.xpath("//article[@class='article fmt article-content ']");
        System.out.println("title:" + title.replace("<[^>]*>", ""));
        System.out.println("content:" + content);
    }


    @Override
    public Site getSite() {
        return site;
    }


    /**
     * 导入单篇思否文章数据
     *
     * @param url
     */
    public static void importSingleSegmentFaultPost(String url) {
        Spider.create(new SegmentfaultDataCrawler())
                .addUrl(url)
                .addPipeline(new ConsolePipeline())
                .run();
    }

    public static void main(String[] args) {
        SegmentfaultDataCrawler.importSingleSegmentFaultPost("https://segmentfault.com/a/1190000041648339");
    }
}
