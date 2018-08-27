package com.example.demo.kuaidi;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

import java.util.HashMap;

@Slf4j
public  class Query {
    public static JSONObject kuaidichaxun(String com, String num) {

        String param = "{\"com\":\"" + com + "\",\"num\":\"" + num + "\"}";
        log.info("s={}",param);
        String customer = "6A559F94707AEE0B0CA25ECF53F4EC02";
        String key = "VxjdQuuB9585";
        String sign = MD5.encode(param + key + customer);
        HashMap params = new HashMap();
        params.put("param", param);
        params.put("sign", sign);
        params.put("customer", customer);
        String resp = null;
        try {
            resp =HttpRequest.postData("http://poll.kuaidi100.com/poll/query.do", params, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject json = JSONObject.fromObject(resp);//将java对象转换为json对象

        return json;
    }
}
