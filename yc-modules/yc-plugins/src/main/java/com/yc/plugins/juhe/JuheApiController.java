package com.yc.plugins.juhe;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.yc.common.core.base.result.RespBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: youcong
 */

@RestController
@RequestMapping("/juhe")
@Api(tags = {"第三方API-聚合"}, description = "第三方API-聚合")
public class JuheApiController {


    @Value("${phone_appkey}")
    public String PHONE_APPKEY;

    @Value("${ip_appkey}")
    public String IP_APPKEY;

    @Value("${news_top_appkey}")
    public String NEWS_TOP_APPKEY;

    @Value("${weather_appkey}")
    public String Weather_APPKEY;

    @Value("${er_appkey}")
    public String EXCHANGE_RATE_APPKEY;

    @Value("${hit_appkey}")
    public String HISTORY_IN_TODAY_APPKEY;

    @Value("${cons_appkey}")
    public String CONSTELLATION_APPKEY;

    @Value("${cale_appkey}")
    public String CALENDAR_APPKEY;

    @Value("${qq_appkey}")
    public String QQ_TEST_LOCK_APPKEY;

    @Value("${book_appkey}")
    public String BOOK_APPKEY;

    @Value("${dream_appkey}")
    public String DREAM_APPKEY;

    @Value("${joke_appkey}")
    public String JOKE_APPKEY;


    /**
     * 查询手机归属
     *
     * @param phone
     * @param dtype
     * @return
     */
    @GetMapping("/getPhoneInfo")
    @ApiOperation("查询手机归属")
    public RespBody getPhoneInfo(String phone, String dtype) {
        String url = "http://apis.juhe.cn/mobile/get";//请求接口地址
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("phone", phone);
        paramMap.put("key", PHONE_APPKEY);
        paramMap.put("dtype", dtype);
        String result = HttpUtil.get(url, paramMap);
        return RespBody.success(new JSONObject(result));
    }

    /**
     * IP地址
     *
     * @param ip
     * @return
     */
    @GetMapping("/getIpInfo")
    @ApiOperation("IP地址")
    public RespBody getIpInfo(String ip) {
        String url = "http://apis.juhe.cn/ip/ipNew";//请求接口地址
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("ip", ip);
        paramMap.put("key", IP_APPKEY);
        String result = HttpUtil.get(url, paramMap);
        return RespBody.success(new JSONObject(result));

    }


    /**
     * 获取新闻头条
     *
     * @param type(类型,,top(头条，默认),shehui(社会),guonei(国内),guoji(国际),yule(娱乐),tiyu(体育)junshi(军事),keji(科技),caijing(财经),shishang(时尚))
     * @return
     */
    @GetMapping("/getNewsTop")
    @ApiOperation("获取新闻头条")
    public RespBody getNewsTop(String type) {

        String url = "http://v.juhe.cn/toutiao/index";//请求接口地址
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("type", type);
        paramMap.put("key", NEWS_TOP_APPKEY);
        String result = HttpUtil.get(url, paramMap);
        return RespBody.success(new JSONArray(result));
    }


    /**
     * 天气预报(根据城市获取对应的天气)
     *
     * @param city
     * @return
     */
    @GetMapping("/getWeatherforecast")
    @ApiOperation("天气预报(根据城市获取对应的天气)")
    public RespBody getWeatherforecast(String city) {
        String url = "http://apis.juhe.cn/simpleWeather/query";//请求接口地址
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("city", city);
        paramMap.put("key", Weather_APPKEY);
        String result = HttpUtil.get(url, paramMap);
        return RespBody.success(result);
    }

    /**
     * 天气预报(天气种类)
     *
     * @return
     */
    @GetMapping("/getWeatherforecastCategory")
    @ApiOperation("天气预报(天气种类)")
    public RespBody getWeatherforecastCategory() {
        String url = "http://apis.juhe.cn/simpleWeather/wids";//请求接口地址
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("key", Weather_APPKEY);
        String result = HttpUtil.get(url, paramMap);
        return RespBody.success(new JSONArray(result));
    }

    /**
     * 天气预报(支持城市列表)
     *
     * @return
     */
    @GetMapping("/getWeatherforecastSupportCity")
    @ApiOperation("天气预报(支持城市列表)")
    public RespBody getWeatherforecastSupportCity() {
        String url = "http://apis.juhe.cn/simpleWeather/cityList";//请求接口地址
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("key", Weather_APPKEY);
        String result = HttpUtil.get(url, paramMap);
        return RespBody.success(new JSONArray(result));
    }

    /**
     * 汇率-常用汇率查询
     *
     * @return
     */
    @GetMapping("/commonExchangeRateQuery")
    @ApiOperation("汇率-常用汇率查询")
    public RespBody commonExchangeRateQuery() {
        String url = "http://op.juhe.cn/onebox/exchange/query";//请求接口地址
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("key", EXCHANGE_RATE_APPKEY);
        String result = HttpUtil.get(url, paramMap);
        return RespBody.success(new JSONArray(result));
    }

    /**
     * 汇率-货币列表
     *
     * @return
     */
    @GetMapping("/currencyList")
    @ApiOperation("汇率-货币列表")
    public RespBody currencyList() {
        String url = "http://op.juhe.cn/onebox/exchange/list";//请求接口地址
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("key", EXCHANGE_RATE_APPKEY);
        String result = HttpUtil.get(url, paramMap);
        return RespBody.success(new JSONArray(result));
    }


    /**
     * 汇率-实时汇率查询换算
     *
     * @return
     */
    @GetMapping("/exchangeRate")
    @ApiOperation("汇率-实时汇率查询换算")
    public RespBody exchangeRate(String from, String to) {
        String url = "http://op.juhe.cn/onebox/exchange/currency";//请求接口地址
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("from", from);
        paramMap.put("to", to);
        paramMap.put("key", EXCHANGE_RATE_APPKEY);
        return RespBody.success(new JSONObject(HttpUtil.get(url, paramMap)));
    }

    /**
     * 历史上的今天-事件列表
     *
     * @return
     */
    @GetMapping("/queryEvent")
    @ApiOperation("历史上的今天-事件列表")
    public RespBody queryEvent(String date) {
        String url = "http://v.juhe.cn/todayOnhistory/queryEvent.php";//请求接口地址
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("date", date);
        paramMap.put("key", HISTORY_IN_TODAY_APPKEY);
        String result = HttpUtil.get(url, paramMap);
        return RespBody.success(new JSONArray(result));
    }

    /**
     * 历史上的今天-事件详情
     *
     * @return
     */
    @GetMapping("/queryEventDetail")
    @ApiOperation("历史上的今天-事件详情")
    public RespBody queryEventDetail(String e_id) {
        String url = "http://v.juhe.cn/todayOnhistory/queryDetail.php";//请求接口地址
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("e_id", e_id);
        paramMap.put("key", HISTORY_IN_TODAY_APPKEY);
        String result = HttpUtil.get(url, paramMap);
        return RespBody.success(new JSONObject(result));
    }


    /**
     * 星座运势
     *
     * @param consName
     * @param type
     * @return
     */
    @GetMapping("/constellationGetAll")
    @ApiOperation("星座运势")
    public RespBody constellationGetAll(String consName, String type) {
        String url = "http://web.juhe.cn:8080/constellation/getAll";//请求接口地址
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("consName", consName);
        paramMap.put("type", type);
        paramMap.put("key", CONSTELLATION_APPKEY);
        String result = HttpUtil.get(url, paramMap);
        return RespBody.success(new JSONObject(result));
    }

    /**
     * 万年历-获取当天详细信息
     *
     * @param date
     * @return
     */
    @GetMapping("/calendarDay")
    @ApiOperation("万年历-获取当天详细信息")
    public RespBody calendarDay(String date) {
        String url = "http://v.juhe.cn/calendar/day";//请求接口地址
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("date", date);
        paramMap.put("key", CALENDAR_APPKEY);
        String result = HttpUtil.get(url, paramMap);
        return RespBody.success(new JSONObject(result));
    }

    /**
     * 万年历-获取最近假期
     *
     * @param date
     * @return
     */
    @GetMapping("/getRecentHoliday")
    @ApiOperation("万年历-获取最近假期")
    public RespBody getRecentHoliday(String date) {
        String url = "http://v.juhe.cn/calendar/month";//请求接口地址
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("year-month", date);
        paramMap.put("key", CALENDAR_APPKEY);
        String result = HttpUtil.get(url, paramMap);
        return RespBody.success(new JSONObject(result));
    }

    /**
     * 万年历-获取当年的假期列表
     *
     * @param year
     * @return
     */
    @GetMapping("/getCurrentYearHolidayList")
    @ApiOperation("万年历-获取当年的假期列表")
    public RespBody getCurrentYearHolidayList(String year) {
        String url = "http://v.juhe.cn/calendar/year";//请求接口地址
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("year", year);
        paramMap.put("key", CALENDAR_APPKEY);
        String result = HttpUtil.get(url, paramMap);
        return RespBody.success(new JSONArray(result));
    }

    /**
     * 测试QQ吉凶
     *
     * @param qq
     * @return
     */
    @GetMapping("/testQQJiXiong")
    @ApiOperation("测试QQ吉凶")
    public RespBody testQQJiXiong(String qq) {
        String url = "http://japi.juhe.cn/qqevaluate/qq";//请求接口地址
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("qq", qq);
        paramMap.put("key", QQ_TEST_LOCK_APPKEY);
        String result = HttpUtil.get(url, paramMap);
        return RespBody.success(new JSONObject(result));
    }

    /**
     * 按更新时间查询笑话
     *
     * @param page
     * @param pageSize
     * @param sort
     * @param time
     * @return
     */
    @GetMapping("/jokeContentList")
    @ApiOperation("按更新时间查询笑话")
    public RespBody jokeContentList(Integer page, Integer pageSize, String sort, String time) {
        String url = "http://v.juhe.cn/joke/content/list.php";//请求接口地址
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("page", page);
        paramMap.put("pageSize", pageSize);
        paramMap.put("sort", sort);
        paramMap.put("time", time);
        paramMap.put("key", JOKE_APPKEY);
        String result = HttpUtil.get(url, paramMap);
        return RespBody.success(new JSONArray(result));
    }


    /**
     * 最新笑话
     *
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/latestJokeContent")
    @ApiOperation("最新笑话")
    public RespBody latestJokeContent(Integer page, Integer pageSize) {
        String url = "http://v.juhe.cn/joke/content/text.php";//请求接口地址
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("page", page);
        paramMap.put("pageSize", pageSize);
        paramMap.put("key", JOKE_APPKEY);
        String result = HttpUtil.get(url, paramMap);
        return RespBody.success(new JSONArray(result));
    }

    /**
     * 随机笑话
     *
     * @return
     */
    @GetMapping("/randJoke")
    @ApiOperation("随机笑话")
    public RespBody randJoke() {
        String url = "http://v.juhe.cn/joke/randJoke.php";//请求接口地址
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("key", JOKE_APPKEY);
        String result = HttpUtil.get(url, paramMap);
        return RespBody.success(new JSONObject(result));
    }

    /**
     * 图书分类目录
     *
     * @param type
     * @return
     */
    @GetMapping("/goodBookCategoryLog")
    @ApiOperation("图书分类目录")
    public RespBody goodBookCategoryLog(String type) {
        String url = "http://apis.juhe.cn/goodbook/catalog";//请求接口地址
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("type", type);
        paramMap.put("key", BOOK_APPKEY);
        String result = HttpUtil.get(url, paramMap);
        return RespBody.success(new JSONArray(result));
    }


    /**
     * 图书内容
     *
     * @param catalog_id
     * @param pn
     * @param rn
     * @return
     */
    @GetMapping("/goodBookQuery")
    @ApiOperation("图书内容")
    public RespBody goodBookQuery(Integer catalog_id, Integer pn, Integer rn) {
        String url = "http://apis.juhe.cn/goodbook/query";//请求接口地址
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("catalog_id", catalog_id);
        paramMap.put("pn", pn);
        paramMap.put("rn", rn);
        paramMap.put("dtype", "json");
        paramMap.put("key", BOOK_APPKEY);
        String result = HttpUtil.get(url, paramMap);
        return RespBody.success(new JSONArray(result));
    }

    /**
     * 周公解梦-类型
     *
     * @param fid
     * @return
     */
    @GetMapping("/dreamCategory")
    @ApiOperation("周公解密-类型")
    public RespBody dreamCategory(String fid) {
        String url = "http://v.juhe.cn/dream/category";//请求接口地址
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("fid", fid);
        paramMap.put("key", DREAM_APPKEY);
        String result = HttpUtil.get(url, paramMap);
        return RespBody.success(new JSONArray(result));
    }


    /**
     * 周公解梦-解梦查询
     *
     * @param q
     * @param cid
     * @param full
     * @return
     */
    @GetMapping("/dreamQuery")
    @ApiOperation("周公解梦-解梦查询")
    public RespBody dreamQuery(String q, String cid, String full) {
        String url = "http://v.juhe.cn/dream/query";//请求接口地址
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("q", q);
        paramMap.put("cid", cid);
        paramMap.put("full", full);
        paramMap.put("key", DREAM_APPKEY);
        String result = HttpUtil.get(url, paramMap);
        return RespBody.success(new JSONObject(result));
    }

    /**
     * 周公解梦-根据ID查询解梦信息
     *
     * @param id
     * @return
     */
    @GetMapping("/dreamQueryId")
    @ApiOperation("周公解梦-根据ID查询解梦信息")
    public RespBody dreamQueryId(String id) {
        String url = "http://v.juhe.cn/dream/queryid";//请求接口地址
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        paramMap.put("key", DREAM_APPKEY);
        String result = HttpUtil.get(url, paramMap);
        return RespBody.success(new JSONObject(result));
    }
}
