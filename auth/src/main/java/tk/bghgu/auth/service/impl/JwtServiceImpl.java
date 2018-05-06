package tk.bghgu.auth.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import tk.bghgu.auth.service.JwtService;
import tk.bghgu.auth.utils.SHA512EncryptUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by ds on 2018-05-05.
 */

@Service
public class JwtServiceImpl implements JwtService {

    @Value("${JWT.SALT}")
    private String SALT;

    @Override
    public <T> String createToken(final String key, final T data) {
        String jwt = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("regDate", System.currentTimeMillis())
                .setExpiration(getTime())
                .setId(key)
                //.setSubject(subject)
                //.claim(key, data)
                .signWith(SignatureAlgorithm.HS512, SHA512EncryptUtils.encrypt(SALT))
                .compact();
        return jwt;
    }

    @Override
    public Map<String, Object> getToken(final String key) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String jwt = request.getHeader("Authorization");
        Jws<Claims> claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(SALT.getBytes("UTF-8"))
                    .parseClaimsJws(jwt);
        } catch (Exception e) {
            /*if(log.isInfoEnabled()){
                e.printStackTrace();
            }else{
                log.error(e.getMessage());
            }
            throw new UnauthorizedException();

			*//*개발환경
			Map<String,Object> testMap = new HashMap<>();
			testMap.put("memberId", 2);
			return testMap;*/
        }
        @SuppressWarnings("unchecked")
        Map<String, Object> value = (LinkedHashMap<String, Object>)claims.getBody().get(key);
        return value;
    }

    @Override
    public String getAuthId(final String key) {
        return this.getToken(key).get("id").toString();
    }

    @Override
    public boolean isValuedToken(final String jwt) {
        try{
            Jws<Claims> claims = Jwts.parser()
                    .setSigningKey(SHA512EncryptUtils.encrypt(SALT))
                    .parseClaimsJws(jwt);
            return true;
        }catch (Exception e) {
            /*if(log.isInfoEnabled()){
                e.printStackTrace();
            }else{
                log.error(e.getMessage());
            }
            throw new UnauthorizedException();*/
            return false;
        }
    }

    private Date getTime() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.HOUR, 1);
        return cal.getTime();
    }
}
