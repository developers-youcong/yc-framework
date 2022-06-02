package com.yc.plugins.robot;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import com.yc.common.core.base.dto.plugins.robot.RobotChatReqDTO;
import com.yc.common.core.base.result.RespBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: youcong
 */
@RestController
@RequestMapping("/robot")
@Api(tags = {"图灵机器人"}, description = "图灵机器人")
public class RobotController {

    private static final String API_URL="http://openapi.turingapi.com/openapi/api/v2";
    @PostMapping("/chat")
    @ApiOperation("聊天")
    public RespBody chat(@RequestBody RobotChatReqDTO reqDTO){
        JSONObject reqJSONData = new JSONObject(reqDTO);
        String result = HttpUtil.createPost(API_URL)
                .header("Accept-Charset","utf-8")
                .body(reqJSONData.toString())
                .execute().body();
        return RespBody.success(new JSONObject(result));
    }
}
