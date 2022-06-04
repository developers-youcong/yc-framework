package com.yc.crawler.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.yc.api.CnBlogsApi;
import com.yc.common.core.base.dto.crawler.PostCrawlerReqDTO;
import com.yc.common.core.base.dto.crawler.UserCrawlerReqDTO;
import com.yc.common.core.base.enums.RespCode;
import com.yc.common.core.base.result.RespBody;
import com.yc.common.core.base.utils.JbcryptUtil;
import com.yc.common.core.base.utils.thread.ThreadPoolUtil;
import com.yc.crawler.mapper.PostCrawlerMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * @description:
 * @author: youcong
 */
@RestController
@RequestMapping("/dataCrawler")
@Api(tags = {"数据爬虫API"}, description = "数据爬虫API")
@Slf4j
public class CrawlerController {
    @Autowired
    private CnBlogsApi cnBlogsApi;

    @Autowired
    private PostCrawlerMapper postCrawlerMapper;


    /**
     * 基于博客园用户相关的文章抓取
     */
    @PostMapping("/cnblog_user")
    @LcnTransaction
    @Transactional
    @ApiOperation("基于博客园用户相关的文章抓取")
    public RespBody cnblog_user() {
        try {
            ExecutorService executorService = ThreadPoolUtil.getThreadPool();

            executorService.execute(() -> {
                //获取token
                cnBlogsApi.getToken();
                List<String> dataList = postCrawlerMapper.selectAllUserName(8L);
                for (String str : dataList) {
                    RespBody resultBody01 = cnBlogsApi.getPersonalBlogInfo(str);
                    if (RespCode.SELECT_SUCCESS.getCode().equals(resultBody01.getCode())) {
                        JSONObject jsonObject = new JSONObject(resultBody01.getData());
                        int totalCount = Integer.parseInt(jsonObject.get("postCount").toString());
                        int pageSize = 10;
                        int computer = totalCount / pageSize;
                        for (int i = 0; i < computer; i++) {
                            RespBody resultBody02 = cnBlogsApi.getPersonalBlogPostList(str, i);
                            JSONArray jsonArray = new JSONArray(resultBody02.getData());
                            List<PostCrawlerReqDTO> postCrawlerReqDTOList = handleDataDetail(jsonArray);
                            if (!postCrawlerReqDTOList.isEmpty()) {
                                postCrawlerMapper.insertPostCrawlerList(postCrawlerReqDTOList);
                            }
                        }
                    }
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

        return RespBody.success();
    }

    /**
     * 博客园首页文章抓取
     */
    @PostMapping("/cnblogs_home")
    @LcnTransaction
    @Transactional
    @ApiOperation("博客园首页文章抓取")
    public RespBody cnblogs_home() {
        ExecutorService executorService = ThreadPoolUtil.getThreadPool();
        executorService.execute(() -> {
            int totalCount = 200;
            //获取token
            cnBlogsApi.getToken();
            //具体数据抓取
            for (int i = 1; i < totalCount; i++) {
                RespBody resultBody = cnBlogsApi.getSiteHomePostList(String.valueOf(i), String.valueOf("10"));
                Console.log("数据入库");
                JSONArray jsonArray = new JSONArray(resultBody.getData());
                List<PostCrawlerReqDTO> postCrawlerReqDTOList = handleDataDetail(jsonArray);
                if (!postCrawlerReqDTOList.isEmpty()) {
                    postCrawlerMapper.insertPostCrawlerList(postCrawlerReqDTOList);
                }
            }
        });

        return RespBody.success();
    }


    /**
     * 博客园精品文章抓取
     */
    @PostMapping("/cnblog_es")
    @LcnTransaction
    @Transactional
    @ApiOperation("博客园精品文章抓取")
    public RespBody cnblog_es() {
        ExecutorService executorService = ThreadPoolUtil.getThreadPool();
        executorService.execute(() -> {
            int totalCount = 160;
            //获取token
            cnBlogsApi.getToken();
            //具体数据抓取
            for (int i = 1; i < totalCount; i++) {
                RespBody resultBody = cnBlogsApi.getEssenceAreaPostList(String.valueOf(i), String.valueOf("10"));
                Console.log("数据入库");
                JSONArray jsonArray = new JSONArray(resultBody.getData());
                List<PostCrawlerReqDTO> postCrawlerReqDTOList = handleDataDetail(jsonArray);
                if (!postCrawlerReqDTOList.isEmpty()) {
                    postCrawlerMapper.insertPostCrawlerList(postCrawlerReqDTOList);
                }
            }
        });
        return RespBody.success();
    }

    /**
     * 数据获取与数据组装
     *
     * @param jsonArray
     * @return
     */
    private List<PostCrawlerReqDTO> handleDataDetail(JSONArray jsonArray) {
        List<PostCrawlerReqDTO> dataList = new ArrayList<>();

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = new JSONObject(jsonArray.get(i));
            String title = jsonObject.get("Title").toString();
            String blogApp = jsonObject.get("BlogApp").toString();
            String description = jsonObject.get("Description").toString();
            String content = getUrlDetailContent(jsonObject.get("Url").toString());
            String originUrl = jsonObject.get("Url").toString();
            Long companyId = 8L;
            String author = getUserId(blogApp, companyId);
            int count = postCrawlerMapper.selectAuthorPost(author, title);
            if (author != null && count == 0) {
                PostCrawlerReqDTO dto = new PostCrawlerReqDTO();
                dto.setCompanyId(companyId);
                dto.setPostTitle(title);
                dto.setDescription(description);
                dto.setPostContent(content);
                dto.setPostAuthor(author);
                dto.setOriginUrl(originUrl);
                dto.setId(IdUtil.simpleUUID());
                dto.setCreateTime(DateUtil.date());
                dto.setUpdateTime(DateUtil.date());
                dataList.add(dto);
            }
        }
        return dataList;
    }

    /**
     * 获取用户ID
     *
     * @param blogApp
     * @return
     */
    private String getUserId(String blogApp, Long companyId) {
        //根据用户名和公司ID获取用户ID
        String result = postCrawlerMapper.selectUserName(blogApp, companyId);
        if (StrUtil.isEmpty(result)) {
            String uuId = IdUtil.simpleUUID();
            UserCrawlerReqDTO user = new UserCrawlerReqDTO();
            user.setCompanyId(companyId);
            user.setUserName(blogApp);
            user.setNickName(blogApp);
            user.setPassword(JbcryptUtil.bcryptPwd(blogApp));
            user.setCreateTime(DateUtil.date());
            user.setUpdateTime(DateUtil.date());
            user.setId(uuId);
            int count = postCrawlerMapper.insertUser(user);
            if (count > 0) {
                result = user.getId();
            }
            return result;
        }
        return result;
    }

    /**
     * 根据URL获取文章具体详细内容
     *
     * @param url
     * @return
     */
    private String getUrlDetailContent(String url) {

        String content = "";
        /**
         * 指定爬取URL(真气网-城市小时级别数据)
         */
        Connection connection = Jsoup.connect(url);
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
            Elements elements = document.getElementsByClass("blogpost-body");
            if (elements.size() > 0) {
                content = elements.get(0).html();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }

}
