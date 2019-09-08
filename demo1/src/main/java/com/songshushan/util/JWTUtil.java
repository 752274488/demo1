package com.songshushan.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;

public class JWTUtil {
    //过期时间
    private static final long EXPIRE_TIME=60*24*60*1000;
    //密钥
    private static final String SECRTE="JWT";
    //创建token
    public static String createToken(String username){
        try {
            Date date = new Date(System.currentTimeMillis()+EXPIRE_TIME);
            Algorithm algorithm=Algorithm.HMAC256(SECRTE);
            return JWT.create()
                    .withClaim("username",username)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    /***
     * 验证token
     * @param token
     * @param username
     * @return
     */
    public static boolean verife(String token,String username){
        try {
            Algorithm algorithm =Algorithm.HMAC256(SECRTE);//验证时要传入一个算法实例  私钥肯定要一致
            ////在token中附带了username信息
            JWTVerifier verifier=JWT.require(algorithm)
                    .withClaim("username",username) //要求令牌具有特定的Claim值
                    .build();
            //验证token
            verifier.verify(token);
            return true;
        } catch (UnsupportedEncodingException e) {
            return false;
        }
    }

    /***
     * 获得token中的信息，无需secret解密也能获得
     * 获得用户名
     * @param token
     * @return
     */
    public static  String getUsername(String token)
    {
        try {
            DecodedJWT jwt=JWT.decode(token);//解密
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }
}
