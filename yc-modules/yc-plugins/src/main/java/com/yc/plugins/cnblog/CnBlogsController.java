package com.yc.plugins.cnblog;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.yc.common.core.base.result.RespBody;
import com.yc.common.redis.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: youcong
 */
@RestController
@Api(tags = {"博客园API"}, description = "博客园API")
public class CnBlogsController {

    @Value("${cnblogs_clientId}")
    private String ClientId;
    @Value("${cnblogs_clientSecret}")
    private String ClientSecret;
    private static final String CNBLOGS_KEY = "cnblogs";
    private static final String CLIENT_ID = "client_id";
    private static final String CLIENT_SECRET = "client_secret";
    private static final String GRANT_TYPE = "grant_type";
    private static final String CLIENT_CREDENTIALS = "client_credentials";
    private static final String BEARER = "Bearer";
    private static final String ACCESS_TOKEN = "access_token";
    private static final String AUTHORIZATION = "Authorization";
    private static final int TIMEOUT = 20000;
    @Autowired
    private RedisService redisService;

    /**
     * 获取博客园Token
     *
     * @return
     */
    @PostMapping("/cnblogs/getToken")
    @ApiOperation("获取博客园Token")
    public RespBody getToken() {
        String url = "https://api.cnblogs.com/token";//请求接口地址
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put(CLIENT_ID, ClientId);
        paramMap.put(CLIENT_SECRET, ClientSecret);
        paramMap.put(GRANT_TYPE, CLIENT_CREDENTIALS);
        String result = HttpUtil.post(url, paramMap);
        JSONObject jsonObject = new JSONObject(result);
        String accessToken = BEARER + " " + jsonObject.get(ACCESS_TOKEN).toString();
        if (!StrUtil.isEmpty(accessToken)) {
            redisService.setCacheObject(CNBLOGS_KEY, accessToken, 180, TimeUnit.MINUTES);
            return RespBody.success(jsonObject);
        } else {
            return RespBody.fail();
        }
    }

    /**
     * 获取个人博客信息
     *
     * @return
     */
    @PostMapping("/cnblogs/getPersonalBlogInfo")
    @ApiOperation("获取个人博客信息")
    public RespBody getPersonalBlogInfo(@RequestParam String username) {
        String value = redisService.getCacheObject(CNBLOGS_KEY);
        if (!StrUtil.isEmpty(value)) {
            String url = "https://api.cnblogs.com/api/blogs/" + username;//请求接口地址
            String result = HttpRequest.get(url)
                    .header(AUTHORIZATION, value)
                    .timeout(TIMEOUT)//超时，毫秒
                    .execute().body();
            JSONObject jsonObject = new JSONObject(result);
            return RespBody.success(jsonObject);
        } else {
            return RespBody.fail();
        }
    }

    /**
     * 获取个人随笔列表
     *
     * @param pageIndex
     * @return
     */
    @PostMapping("/cnblogs/getPersonalBlogPostList")
    @ApiOperation("获取个人随笔列表")
    public RespBody getPersonalBlogPostList(@RequestParam String userName, @RequestParam Integer pageIndex) {
        String value = redisService.getCacheObject(CNBLOGS_KEY);
        if (!StrUtil.isEmpty(value)) {
            String url = "https://api.cnblogs.com/api/blogs/" + userName + "/posts?pageIndex=" + pageIndex;//请求接口地址
            String result = HttpRequest.get(url)
                    .header(AUTHORIZATION, value)
                    .timeout(TIMEOUT)//超时，毫秒
                    .execute().body();
            return RespBody.success(new JSONArray(result));
        } else {
            return RespBody.fail();
        }
    }


    /**
     * 获取单篇文章详细内容
     *
     * @param id
     * @return
     */
    @PostMapping("/cnblogs/getPostById")
    @ApiOperation("获取单篇文章详细内容")
    public RespBody getPostById(@RequestParam Integer id) {
        String value = redisService.getCacheObject(CNBLOGS_KEY);
        if (!StrUtil.isEmpty(value)) {
            String url = "https://api.cnblogs.com/api/blogposts/" + id + "/body";//请求接口地址
            String result = HttpRequest.get(url)
                    .header(AUTHORIZATION, value)
                    .timeout(TIMEOUT)//超时，毫秒
                    .execute().body();
            return RespBody.success(JSONUtil.toJsonStr(result));
        } else {
            return RespBody.fail();
        }
    }


    /**
     * 分页获取精华区博文列表
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @PostMapping("/cnblogs/getEssenceAreaPostList")
    @ApiOperation("分页获取精华区博文列表")
    public RespBody getEssenceAreaPostList(@RequestParam String pageIndex, @RequestParam String pageSize) {
        String value = redisService.getCacheObject(CNBLOGS_KEY);
        if (!StrUtil.isEmpty(value)) {
            String url = "https://api.cnblogs.com/api/blogposts/@picked?pageIndex=" + pageIndex + "&pageSize=" + pageSize;//请求接口地址
            String result = HttpRequest.get(url)
                    .header(AUTHORIZATION, value)
                    .timeout(TIMEOUT)//超时，毫秒
                    .execute().body();
            return RespBody.success(new JSONArray(result));
        } else {
            return RespBody.fail();
        }
    }


    /**
     * 分页获取网站首页博文列表
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @PostMapping("/cnblogs/getSiteHomePostList")
    @ApiOperation("分页获取网站首页博文列表")
    public RespBody getSiteHomePostList(String pageIndex, String pageSize) {
        String value = redisService.getCacheObject(CNBLOGS_KEY);
        if (!StrUtil.isEmpty(value)) {
            String url = "https://api.cnblogs.com/api/blogposts/@sitehome?pageIndex=" + pageIndex + "&pageSize=" + pageSize;//请求接口地址
            String result = HttpRequest.get(url)
                    .header(AUTHORIZATION, value)
                    .timeout(TIMEOUT)//超时，毫秒
                    .execute().body();
            return RespBody.success(new JSONArray(result));
        } else {
            return RespBody.fail();
        }
    }

    /**
     * 分页获取新闻列表
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @PostMapping("/cnblogs/getNewsList/{pageIndex}/{pageSize}")
    @ApiOperation("分页获取新闻列表")
    public RespBody getNewsList(@PathVariable("pageIndex") Integer pageIndex, @PathVariable("pageSize") Integer pageSize) {
        String value = redisService.getCacheObject(CNBLOGS_KEY);
        if (!StrUtil.isEmpty(value)) {
            String url = "https://api.cnblogs.com/api/NewsItems?pageIndex=" + pageIndex + "&pageSize=" + pageSize;//请求接口地址
            String result = HttpRequest.get(url)
                    .header(AUTHORIZATION, value)
                    .timeout(TIMEOUT)//超时，毫秒
                    .execute().body();
            return RespBody.success(new JSONArray(result));
        } else {
            return RespBody.fail();
        }
    }

    /**
     * 获取新闻具体内容
     *
     * @param id
     * @return
     */
    @PostMapping("/cnblogs/getNewsById/{id}")
    @ApiOperation("获取新闻具体内容")
    public RespBody getNewsById(@PathVariable("id") Integer id) {
        String value = redisService.getCacheObject(CNBLOGS_KEY);
        if (!StrUtil.isEmpty(value)) {
            String url = "https://api.cnblogs.com/api/newsitems/" + id + "/body";//请求接口地址
            String result = HttpRequest.get(url)
                    .header(AUTHORIZATION, value)
                    .timeout(TIMEOUT)//超时，毫秒
                    .execute().body();
            return RespBody.success(new JSONObject(result));
        } else {
            return RespBody.fail();
        }
    }

    /**
     * 分页获取热门新闻
     *
     * @param startDate
     * @param endDate
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @PostMapping("/cnblogs/getHotNewsList/{startDate}/{endDate}/{pageIndex}/{pageSize}")
    @ApiOperation("分页获取热门新闻")
    public RespBody getHotNewsList(@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate, @PathVariable("pageIndex") Integer pageIndex, @PathVariable("pageSize") Integer pageSize) {
        String value = redisService.getCacheObject(CNBLOGS_KEY);
        if (!StrUtil.isEmpty(value)) {
            String url = "https://api.cnblogs.com/api/newsitems/@hot?startDate=" + startDate + "&endDate=" + endDate + "&pageIndex=" + pageIndex + "&pageSize=" + pageSize;//请求接口地址
            String result = HttpRequest.get(url)
                    .header(AUTHORIZATION, value)
                    .timeout(TIMEOUT)//超时，毫秒
                    .execute().body();
            return RespBody.success(new JSONArray(result));
        } else {
            return RespBody.fail();
        }
    }

    /**
     * 分页获取推荐新闻
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @PostMapping("/cnblogs/getRecommendNewsList/{pageIndex}/{pageSize}")
    @ApiOperation("分页获取推荐新闻")
    public RespBody getRecommendNewsList(@PathVariable("pageIndex") Integer pageIndex, @PathVariable("pageSize") Integer pageSize) {
        String value = redisService.getCacheObject(CNBLOGS_KEY);
        if (!StrUtil.isEmpty(value)) {
            String url = "https://api.cnblogs.com/api/newsitems/@recommended?pageIndex=" + pageIndex + "&pageSize=" + pageSize;//请求接口地址
            String result = HttpRequest.get(url)
                    .header(AUTHORIZATION, value)
                    .timeout(TIMEOUT)//超时，毫秒
                    .execute().body();
            return RespBody.success(new JSONArray(result));

        } else {
            return RespBody.fail();
        }
    }

    /**
     * 根据新闻Id分页获取新闻评论
     *
     * @param newsId
     * @return
     */
    @PostMapping("/cnblogs/getNewsByIdCommentList/{newsId}")
    @ApiOperation("根据新闻Id分页获取新闻评论")
    public RespBody getNewsByIdCommentList(@PathVariable("newsId") Integer newsId) {
        String value = redisService.getCacheObject(CNBLOGS_KEY);
        if (!StrUtil.isEmpty(value)) {
            String url = "https://api.cnblogs.com/api/news/" + newsId + "/comments";//请求接口地址
            String result = HttpRequest.get(url)
                    .header(AUTHORIZATION, value)
                    .timeout(TIMEOUT)//超时，毫秒
                    .execute().body();
            return RespBody.success(new JSONArray(result));
        } else {
            return RespBody.fail();
        }
    }
}
