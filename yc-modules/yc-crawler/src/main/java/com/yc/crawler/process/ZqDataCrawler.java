package com.yc.crawler.process;

import cn.hutool.core.date.DateUtil;
import com.yc.common.core.base.vo.crawler.PollutantVO;
import com.yc.crawler.mapper.CrawlerMapper;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Hashtable;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description: 真气网-城市小时级数据抓取
 * @author: youcong
 * @time: 2021/5/26 20:42
 */
@Component
public class ZqDataCrawler {

    public static ZqDataCrawler zqDataCrawler;

    @Autowired
    private CrawlerMapper crawlerMapper;

    @PostConstruct
    public void init() {
        zqDataCrawler = this;
        zqDataCrawler.crawlerMapper = this.crawlerMapper;
    }

    public static void zqDataCaptureMethod(String city) {
        /**
         * 指定爬取URL(真气网-城市小时级别数据)
         */
        Connection connection = Jsoup.connect("https://www.zq12369.com/?city=" + city + "&tab=city");

        /**
         * 定义浏览器Agent
         */
        connection.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36");

        try {
            /**
             * 获取HTML文档
             */
            Document document = connection.timeout(100000).get();
            /**
             * 抓取指定元素节点(具体的ID/类选择器、标签等之类的)-此处加判断-应对真气网元素变动问题(反爬策略的一种)
             */
            Elements elements = document.getElementsByClass("aqibanner1");
            if (elements.size() == 0) {
                elements = document.getElementsByClass("aqibanner2");
            }
            //定义数据存储对象
            PollutantVO vo = new PollutantVO();
            /**
             * 根据拿到的节点，进行数据遍历
             */
            for (Element citys : elements) {
                Elements tdDatas = citys.getElementsByClass("container");
                for (Element data : tdDatas) {
                    System.out.println("city:" + data.getElementById("city").text());
                    vo.setCity(data.getElementById("city").text());
                    Elements dateDataSelector = data.getElementsByClass("statustip");
                    for (Element date : dateDataSelector) {
                        String currentDate = date.getElementsByClass("pdate").text();
                        System.out.println("pdate:" + currentDate);
                        String pdate = strHandle01(currentDate);
                        vo.setDay(pdate.substring(0, 8));
                        vo.setHour(pdate.substring(8, 10));
                    }
                    System.out.println("aqi:" + data.getElementsByClass("aqi").text());
                    vo.setAqi(data.getElementsByClass("aqi").text());
                    Elements dataPollutantSelector = data.getElementsByClass("aqidetail");
                    Map<String, String> pollutantMap = new Hashtable<>();
                    String pollutantKey = "";
                    String pollutantValue = "";
                    for (Element pollutant : dataPollutantSelector) {
                        pollutantKey = pollutant.getElementsByClass("item").text().replaceAll(" ", ",").trim();
                        pollutantValue = pollutant.getElementsByClass("value").text().replaceAll(" ", ",").trim();
                        System.out.println("key:" + pollutantKey);
                        System.out.println("value:" + pollutantValue);
                        pollutantMap.put(pollutantKey.split(",")[0], pollutantValue.split(",")[0]);
                        pollutantMap.put(pollutantKey.split(",")[1], pollutantValue.split(",")[1]);
                        pollutantMap.put(pollutantKey.split(",")[2], pollutantValue.split(",")[2]);
                        pollutantMap.put(pollutantKey.split(",")[3], pollutantValue.split(",")[3]);
                        pollutantMap.put(pollutantKey.split(",")[4], pollutantValue.split(",")[4]);
                        pollutantMap.put(pollutantKey.split(",")[5], pollutantValue.split(",")[5]);
                    }
                    vo.setPm2_5(pollutantMap.get("PM2.5"));
                    vo.setPm10(pollutantMap.get("PM10"));
                    vo.setSo2(pollutantMap.get("SO2"));
                    vo.setNo2(pollutantMap.get("NO2"));
                    vo.setCo(pollutantMap.get("CO"));
                    vo.setO3(pollutantMap.get("O3"));
                    vo.setCreateTime(DateUtil.date());

                    int count = zqDataCrawler.crawlerMapper.insert(vo);
                    if (count > 0) {
                        System.out.println("插入成功");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将字符串中的中文去除掉，仅保留数字
     *
     * @param targetStr
     * @return
     */
    public static String strHandle01(String targetStr) {
        String reg = "[\u4e00-\u9fa5]";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(targetStr);
        String newStr = matcher.replaceAll("");
        return newStr;
    }


}
