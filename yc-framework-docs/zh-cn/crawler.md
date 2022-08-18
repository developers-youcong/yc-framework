# 爬虫

### 一、引入Maven依赖
```
<dependency>
    <groupId>com.yc.framework</groupId>
    <artifactId>yc-common-crawler</artifactId>
</dependency>


```
主要采用的是webmagic爬虫框架，如果你需要在你的项目中大量使用，建议你阅读官方文档，进行全面的了解。

官方文档:
http://webmagic.io/docs/zh/

源代码:
https://git.oschina.net/flashsword20/webmagic


## 二、代码示例

### 1.抓取博客园文章数据
```
@Component
public class CnBlogDataCrawler implements PageProcessor {
    public static CnBlogDataCrawler cnBlogDataCrawler;

    @PostConstruct
    public void init() {
        cnBlogDataCrawler = this;
    }

    private Site site = Site.me()
            .setDomain("https://www.cnblogs.com/")
            .setSleepTime(1000)
            .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");


    @Override
    @Transactional
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

```

### 2.抓取CSDN文章数据
```
@Component
public class CSDNDataCrawler implements PageProcessor {

    public static CSDNDataCrawler csdnDataCrawler;

    @PostConstruct
    public void init() {
        csdnDataCrawler = this;
    }

    private Site site = Site.me()
            .setDomain("https://blog.csdn.net/")
            .setSleepTime(1000)
            .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");

    @Override
    @Transactional
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

```

源代码示例:
https://github.com/developers-youcong/yc-framework/tree/main/yc-example/yc-example-crawler