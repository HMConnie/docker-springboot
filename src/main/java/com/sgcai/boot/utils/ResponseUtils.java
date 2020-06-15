package com.sgcai.boot.utils;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtils {
    private ResponseUtils(){

    }

    public  static String toSuccess(Object data){
        Map<String,Object> result = new HashMap<>();
        result.put("data",data);
        return JSON.toJSONString(result);
    }
}
