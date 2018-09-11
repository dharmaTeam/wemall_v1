package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class WechatAuthenticationResponse implements Serializable {
    private static final long serialVersionUID = 1250166508152483573L;

    @JsonProperty
    private final String accessToken;

    public WechatAuthenticationResponse(String accessToken){
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return this.accessToken;
    }
}
