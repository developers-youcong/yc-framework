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
 * @time: 2021/9/28 20:43
 */
public class CnBlogDataCrawler implements PageProcessor {

    private Site site = Site.me()
            .setDomain("https://www.cnblogs.com/")
            .setSleepTime(1000)
            .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");


    @Override
    public void process(Page page) {
        Selectable obj = page.getHtml().xpath("//div[@class='post']");
        Selectable title = obj.xpath("//h1[@class='postTitle']//a");
        Selectable content = obj.xpath("//div[@class='blogpost-body']");
        System.out.println("title:" + title.replace("<[^>]*>", ""));
        System.out.println("content:" + content);
    }


    @Override
    public Site getSite() {
        return site;
    }


    /**
     * 导入单篇博客园文章数据
     *
     * @param url
     */
    public static void importSinglePost(String url) {
        Spider.create(new CnBlogDataCrawler())
                .addUrl(url)
                .addPipeline(new ConsolePipeline())
                .thread(10)
                .run();
    }

    public static void main(String[] args) {
        CnBlogDataCrawler.importSinglePost("https://www.cnblogs.com/afei654138148/p/15348696.html");
    }
}
