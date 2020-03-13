package com.prepared.service.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import lombok.Data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Data
public class TokenClaims {

    public static final Integer EXPIRE = 12 * 60 * 60; //12小时过期
    public static final String ORIGIN = "www.color.com";
    public static final String TYPE = "JWT";

    private String jti; //编号
    private String iss; //签发人
    private String aud; //受众 存放ClientCode
    private String sub; //主题 存放UserId
    private String typ; // Header,typ:令牌类型
    private Long iat; //生效时间
    private Long exp; //过期时间

    public TokenClaims(String userId, Date issuedAt){
        Long epoch = issuedAt.getTime()/1000L;

        this.jti= UUID.randomUUID().toString();
        this.sub = userId;
        this.iss = ORIGIN;
        this.typ = TYPE;
        this.iat = epoch;
        this.exp = epoch+EXPIRE;
    }

    public TokenClaims(Jws<Claims> jws){
        Claims body = jws.getBody();
        this.jti = body.getId();
        this.iss = body.getIssuer();
        this.aud = body.getAudience();
        this.sub = body.getSubject();
        this.typ = body.get("typ",String.class);
        this.iat = body.getIssuedAt().getTime()/1000L;
        this.exp = body.getExpiration().getTime()/1000L;
    }

    public Map<String,Object> toMap(){
        Map<String,Object> m = new HashMap<>();
        m.put("jti",jti);
        m.put("sub",sub);
        m.put("iss",iss);
        m.put("aud",aud);
        m.put("typ",typ);
        m.put("iat",iat);
        m.put("exp",exp);
        return m;
    }
}
