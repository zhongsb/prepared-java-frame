package com.prepared.service.common.utils;

import com.prepared.service.common.utils.TokenClaims;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * jwt工具类
 *
 * @author z
 */
@ConfigurationProperties(prefix = "color.jwt")
@Component
public class JwtUtils {
    private Logger logger = LoggerFactory.getLogger(getClass());

    public static final String signKey="tbprUgkQ8OGI5RWIuVEAUbNZn3syKLjw";
    private String secret;
    private long expire;
    private String header;
    private Date expireDate;

    /**
     * 生成jwt token
     */
    public String generateToken(TokenClaims claims) {
        Date nowDate = new Date();
        //过期时间
        expireDate = new Date(nowDate.getTime() + expire * 1000);
        String jwt = Jwts.builder()
                .setHeader(generateJwtHeader(claims))
                .setClaims(claims.toMap())
                .setExpiration(expireDate)
                .signWith(getHs256SecretKeyFromJwk(signKey), SignatureAlgorithm.HS256)
                .compact();
        return jwt;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public Claims getClaimByToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(getHs256SecretKeyFromJwk(signKey))
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            logger.debug("validate is token error ", e);
            return null;
        }
    }

    private Map<String, Object> generateJwtHeader(TokenClaims claims) {
        Map<String,Object> headers =  new HashMap<>();
        headers.put("alg","RS256");
        headers.put("typ",claims.getTyp());
        return headers;
    }

    private static Key getHs256SecretKeyFromJwk(String key){
        return new SecretKeySpec(key.getBytes(),SignatureAlgorithm.HS256.getJcaName());
    }

    /**
     * token是否过期
     * @return  true：过期
     */
    public boolean isTokenExpired(Date expiration) {
        return expiration.before(new Date());
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public long getExpire() {
        return expire;
    }

    public void setExpire(long expire) {
        this.expire = expire;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}
