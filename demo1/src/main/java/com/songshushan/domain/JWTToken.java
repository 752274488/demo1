package com.songshushan.domain;

import lombok.Data;
import org.apache.shiro.authc.AuthenticationToken;
@Data
public class JWTToken implements AuthenticationToken {
    private  String token;
    public JWTToken(String token)
    {
        this.token= token;
    }

    @Override
    public Object getPrincipal() {
        return getPrincipal();
    }

    @Override
    public Object getCredentials() {
        return getPrincipal();
    }
}
