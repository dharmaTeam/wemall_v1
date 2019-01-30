package com.example.demo.security;

import com.example.demo.dto.WechatAuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthEndpotin {

    @Value("${jwt.header}")
    private String tokenHeander;

    @Value("${jwt.tokenHeader}")
    private String tokenHead;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private WechatService wechatService;

    @GetMapping("/test")
    public String test(){
        return "test_success";
    }

    @GetMapping("/testAuth")
    public String testAuth(){
        return "testAuth_success";
    }

    @PostMapping("/auth")
    public ResponseEntity<WechatAuthenticationResponse> createAuthenticationToken(@RequestParam String code) throws AuthenticationException {
        WechatAuthenticationResponse jwtResponse = wechatService.wechatLogin(code);
        return ResponseEntity.ok(jwtResponse);
    }


}
