package com.example.demo.security;

import com.example.demo.bean.User;
import com.example.demo.dao.UserDao;
import com.example.demo.dto.WechatAuthCodeResponse;
import com.example.demo.dto.WechatAuthenticationResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
public class WechatService {

    /**
     * 服务器第三方session有效时间，单位秒, 默认1天
     */

    private static final Long EXPIRES = 86400L;

    private static final Logger LOGGER = LoggerFactory.getLogger(WechatService.class);

    private RestTemplate wxAuthRestTemplate = new RestTemplate();
    @Autowired
    private UserDao userDao;

    @Autowired
    private WechatAuthProperties wechatAuthProperties;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public WechatAuthenticationResponse wechatLogin(String code){
        WechatAuthCodeResponse response = getWxSession(code);

        String wxOpenId = response.getOpenid();
        String wxSessionKey = response.getSessionKey();
        //Consumer
//        Consumer consumer = new Consumer();
//        consumer.setWechatOpenid(wxOpenId);
//        loginOrRegisterConsumer(consumer);
        User user = new User();
        user.setWx_openid(wxOpenId);
        loginOrRegisterConsumer(user);

        Long expires = response.getExpiresIn();
        String thirdSession = create3rdSession (wxOpenId, wxSessionKey, expires);
            return new WechatAuthenticationResponse(thirdSession);

    }

    public WechatAuthCodeResponse getWxSession(String code){
        String urlString = "?appid={appid}&secret={srcret}&js_code={code}&grant_type={grantType}";
        String response = wxAuthRestTemplate.getForObject(
                wechatAuthProperties.getSessionHost() + urlString, String.class,wechatAuthProperties.getAppId(),wechatAuthProperties.getSecret(),code,wechatAuthProperties.getGrantType());
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectReader reader = objectMapper.readerFor(WechatAuthCodeResponse.class);
        WechatAuthCodeResponse res;
        try{
            res = reader.readValue(response);
        }catch (IOException e){
            res = null;
            LOGGER.error("反序列化失败",e);
        }
        LOGGER.info(response);
        if (null == res){
            throw new RuntimeException("调用微信接口失败");
        }
        if(res.getErrcode() != null){
            throw new RuntimeException(res.getErrmsg());
        }
        res.setExpiresIn(res.getExpiresIn() != null ? res.getExpiresIn() : EXPIRES);
        return res;

    }

    public String create3rdSession(String wxOpenId, String wxSessionKey, Long expires){
        String thirdSessionKey = RandomStringUtils.randomAlphabetic(64);
        StringBuffer sb = new StringBuffer();
        sb.append(wxSessionKey).append("#").append(wxOpenId);

        stringRedisTemplate.opsForValue().set(thirdSessionKey, sb.toString(), expires, TimeUnit.SECONDS);
        return thirdSessionKey;
    }

    private void loginOrRegisterConsumer(User user){
        User user1 = userDao.findUserByOpenid(user.getWx_openid());
        if(null == user1){
            userDao.save(user);
        }
//        User user1 =
//        private void loginOrRegisterConsumer(Consumer consumer) {
//            Consumer consumer1 = consumerMapper.findConsumerByWechatOpenid(consumer.getWechatOpenid());
//            if (null == consumer1) {
//                consumerMapper.insertConsumer(consumer);
//            }
//        }
//        public void updateConsumerInfo(Consumer consumer) {
//            Consumer consumerExist = consumerMapper.findConsumerByWechatOpenid(AppContext.getCurrentUserWechatOpenId());
//            consumerExist.setUpdatedBy(1L);
//            consumerExist.setUpdatedAt(System.currentTimeMillis());
//            consumerExist.setGender(consumer.getGender());
//            consumerExist.setAvatarUrl(consumer.getAvatarUrl());
//            consumerExist.setWechatOpenid(consumer.getWechatOpenid());
//            consumerExist.setEmail(consumer.getEmail());
//            consumerExist.setNickname(consumer.getNickname());
//            consumerExist.setPhone(consumer.getPhone());
//            consumerExist.setUsername(consumer.getUsername());
//            consumerMapper.updateConsumer(consumerExist);
//        }
    }
//
//    public void updateUserInfo(User user){
//        User userExist = userDao.findUserByOpenid(AppContext.getCurrentUserWechatOpenId());
//        userExist.setId_card_num(user.getId_card_num());
//
//    }
}
