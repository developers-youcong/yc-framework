package com.yc.common.core.base.utils;

import javax.script.*;
import java.io.File;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: youcong
 */
public class JSUtil {

    /**
     * 单例的JavaScript解析引擎
     */
    private static ScriptEngine javaScriptEngine;

    static {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine scriptEngine = manager.getEngineByName("JavaScript");
        if (scriptEngine == null) {
            throw new RuntimeException("获取JavaScript解析引擎失败");
        }
        javaScriptEngine = scriptEngine;
    }

    /**
     * 执行一段JavaScript代码
     *
     * @param script JavaScript的代码
     * @return JavaScript代码运行结果的值
     * @throws ScriptException JavaScript代码运行异常
     */
    public static Object execute(String script) throws ScriptException {
        return javaScriptEngine.eval(script);
    }

    /**
     * 执行单个JS函数
     *
     * @param targetParam
     */
    public static void getSingleFun(String targetParam, StringBuffer script) {
        try {
            script.append("var obj = new Object();");
            script.append("obj.singleFun = function(targetParam){print('single function execute result is：'+targetParam);}");
            //执行这段script脚本
            javaScriptEngine.eval(script.toString());
            // javax.script.Invocable 是一个可选的接口
            // 检查你的script engine 接口是否已实现!
            // 注意：JavaScript engine实现了Invocable接口
            Invocable inv = (Invocable) javaScriptEngine;
            // 获取我们想调用那个方法所属的js对象
            Object obj = javaScriptEngine.get("obj");
            // 执行obj对象的名为singleFun的方法
            inv.invokeMethod(obj, "singleFun", targetParam);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取当前语句运行后第一个有值变量的值
     *
     * @param script 代码段
     * @return 第一个有值变量的值
     * @throws ScriptException JavaScript代码运行异常
     */
    public static Object executeForFirstAttribute(String script) throws ScriptException {

        //这里重新获取一个JavaScript解析引擎是为了避免代码中有其他调用工具类的地方的变量干扰
        //重新获取后,这个JavaScript解析引擎只执行了这次传入的代码,不会保存其他地方的变量
        //全局的解析器中会保存最大200个变量,JavaScript解析引擎本身最大保存100个变量
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine scriptEngine = manager.getEngineByName("js");
        if (scriptEngine == null) {
            throw new RuntimeException("获取JavaScript解析引擎失败");
        }

        scriptEngine.eval(script);
        ScriptContext context = scriptEngine.getContext();
        if (context == null) {
            return null;
        }
        Bindings bindings = context.getBindings(ScriptContext.ENGINE_SCOPE);
        if (bindings == null) {
            return null;
        }
        Set<Map.Entry<String, Object>> entrySet = bindings.entrySet();
        if (entrySet == null || entrySet.isEmpty()) {
            return null;
        }
        for (Map.Entry<String, Object> entry : entrySet) {
            if (entry.getValue() != null) {
                return entry.getValue();
            }
        }
        return null;
    }


    /**
     * 运行一个JavaScript代码段,并获取指定变量名的值
     *
     * @param script        代码段
     * @param attributeName 已知的变量名
     * @return 指定变量名对应的值
     * @throws ScriptException JavaScript代码运行异常
     */
    public static Object executeForAttribute(String script, String attributeName) throws ScriptException {
        javaScriptEngine.eval(script);
        return javaScriptEngine.getContext().getAttribute(attributeName);
    }

    /**
     * 调用指定路径对应的JS文件中的function
     *
     * @param jsFilePath
     * @param fun
     * @param param
     */
    public static void getSpecifiedJSFile(String jsFilePath, String fun, String param) {
        try {
            javaScriptEngine.eval(new java.io.FileReader(new File(jsFilePath)));
            Invocable inv = (Invocable) javaScriptEngine;
            Object obj = javaScriptEngine.get("obj");
            inv.invokeMethod(obj, fun, param);
            System.out.println("obj:" + obj.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        //JSUtil.execute("var a = 1");
        JSUtil.getSpecifiedJSFile("D://test/fun.js", "singleFun", "function");
    }
}
