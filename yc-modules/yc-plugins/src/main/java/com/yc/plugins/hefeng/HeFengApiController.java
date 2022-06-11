package com.yc.plugins.hefeng;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import com.yc.common.core.base.result.RespBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: youcong
 */
@RestController
@RequestMapping("/hefeng")
@Api(tags = {"第三方API-和风天气"}, description = "第三方API-和风天气")
public class HeFengApiController {

    @Value("${hefeng_key}")
    private String HEFENG_KEY;

    @GetMapping("/getRealTimeAQ")
    @ApiOperation("实时空气质量")
    public RespBody getRealTimeAQ(@RequestParam String location) {

        String url = "https://devapi.qweather.com/v7/air/now";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("location", location);
        paramMap.put("key", HEFENG_KEY);
        String result = HttpUtil.get(url, paramMap);
        return RespBody.success(new JSONObject(result));
    }

    @GetMapping("/getRealTimeWeather")
    @ApiOperation("实时天气")
    public RespBody getRealTimeWeather(@RequestParam String location) {
        String url = "https://devapi.qweather.com/v7/weather/now";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("location", location);
        paramMap.put("key", HEFENG_KEY);
        String result = HttpUtil.get(url, paramMap);
        return RespBody.success(new JSONObject(result));
    }

    @GetMapping("/getCityInfo")
    @ApiOperation("城市信息查询")
    public RespBody getCityInfo(@RequestParam String location) {
        String url = "https://geoapi.qweather.com/v2/city/lookup";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("location", location);
        paramMap.put("key", HEFENG_KEY);
        String result = HttpUtil.get(url, paramMap);
        return RespBody.success(new JSONObject(result));
    }

    @GetMapping("/getWeatherWarnCity")
    @ApiOperation("天气预警城市")
    public RespBody getWeatherWarnCity(@RequestParam String range) {
        String url = "https://devapi.qweather.com/v7/warning/list";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("range", range);
        paramMap.put("key", HEFENG_KEY);
        String result = HttpUtil.get(url, paramMap);
        return RespBody.success(new JSONObject(result));
    }

    @GetMapping("/getWeatherDisastersWarn")
    @ApiOperation("天气灾害预警")
    public RespBody getWeatherDisastersWarn(@RequestParam String location) {
        String url = "https://devapi.qweather.com/v7/warning/now";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("location", location);
        paramMap.put("key", HEFENG_KEY);
        String result = HttpUtil.get(url, paramMap);
        return RespBody.success(new JSONObject(result));
    }

    @GetMapping("/getWeatherLifeIndex")
    @ApiOperation("天气生活指数")
    public RespBody getWeatherLifeIndex(@RequestParam String type,@RequestParam String location) {
        String url = "https://devapi.qweather.com/v7/indices/1d";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("type",type);
        paramMap.put("location", location);
        paramMap.put("key", HEFENG_KEY);
        String result = HttpUtil.get(url, paramMap);
        return RespBody.success(new JSONObject(result));
    }


}
