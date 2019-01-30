package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.filter.OncePerRequestFilter;
import org.thymeleaf.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ThirdSessionAuthFilter extends OncePerRequestFilter {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Value("${jwt.tokenHeader}")
    private String tokenHead;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        //获取请求头部分的Authorization
        String authHeader = httpServletRequest.getHeader(this.tokenHeader);
        //如果请求路径为微信通知后台支付结果则不需要token（之后会在具体的controller中，对双方签名进行验证防钓鱼）
        String url = httpServletRequest.getRequestURI().substring(httpServletRequest.getContextPath().length());

        if (url.equals("/auth") || url.equals("/test")) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }

        if (null == authHeader || !authHeader.startsWith("Bearer")) {
            throw new RuntimeException("非法访问用户");
        }

        //The part after Bearer
        final String thirdSession = authHeader.substring(tokenHead.length());
        String wxSessionObj = stringRedisTemplate.opsForValue().get(thirdSession);
        if (StringUtils.isEmpty(wxSessionObj)) {
            throw new RuntimeException("用户身份已过期");
        }

//        设置当前登陆用户
        try (
                AppContext appContext = new AppContext(wxSessionObj.substring(wxSessionObj.indexOf("#") + 1));
        ) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }
    }
}
