package tk.bghgu.auth.service;

import java.util.Map;

/**
 * Created by ds on 2018-05-05.
 */
public interface JwtService {
    <T> String createToken(final String key, final T data);
    Map<String, Object> getToken(final String key);
    String getAuthId(final String key);
    boolean isValuedToken(final String jwt);
}
