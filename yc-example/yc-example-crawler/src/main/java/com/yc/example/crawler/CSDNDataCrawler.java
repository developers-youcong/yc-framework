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
public class CSDNDataCrawler implements PageProcessor {

    private Site site = Site.me()
            .setDomain("https://blog.csdn.net/")
            .setSleepTime(1000)
            .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");

    @Override
    public void process(Page page) {
        Selectable obj = page.getHtml().xpath("//div[@id='mainBox']");
        Selectable title = obj.xpath("//h1[@class='title-article']");
        Selectable content = obj.xpath("//div[@id='content_views']");
        System.out.println("title:" + title.replace("<[^>]*>", ""));
        System.out.println("content:" + content);
    }


    @Override
    public Site getSite() {
        return site;
    }


    /**
     * 导入单篇CSDN文章数据
     *
     * @param url
     */
    public static void importSingleCSDNPost(String url) {
        Spider.create(new CSDNDataCrawler())
                .addUrl(url)
                .addPipeline(new ConsolePipeline())
                .thread(8)
                .run();

    }

    public static void main(String[] args) {
        importSingleCSDNPost("https://blog.csdn.net/weixin_44318830/article/details/116402369?utm_medium=distribute.pc_feed.none-task-blog-whitelist_blog-7.nonecase&depth_1-utm_source=distribute.pc_feed.none-task-blog-whitelist_blog-7.nonecase");
    }
}
