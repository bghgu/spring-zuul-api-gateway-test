package tk.bghgu.auth.service.impl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.bghgu.auth.utils.SHA512EncryptUtils;

import static org.junit.Assert.*;

/**
 * Created by ds on 2018-05-06.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtServiceImplTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${JWT.SALT}")
    private String SALT;

    @Test
    public void createToken() {
        String jwt = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("regDate", System.currentTimeMillis())
                .setSubject("subject")
                .setId("key")
                .claim("key", "data")
                .signWith(SignatureAlgorithm.HS512, SHA512EncryptUtils.encrypt(SALT))
                .compact();
        logger.info("jwt : " + jwt);
    }
}