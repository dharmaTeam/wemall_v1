package com.example.demo.controller;

import com.example.demo.kuaidi.Query;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kuaidi")
public class KuaidiController {

    @GetMapping("/info")
    public JSONObject getInfo(@RequestParam("com") String com, @RequestParam("num") String num){
        return Query.kuaidichaxun(com,num);
    }
}
