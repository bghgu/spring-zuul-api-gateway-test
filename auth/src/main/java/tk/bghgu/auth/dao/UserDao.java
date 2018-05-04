package tk.bghgu.auth.dao;

import tk.bghgu.auth.domain.USER;

import java.util.Optional;

/**
 * Created by ds on 2018-05-03.
 */
public interface UserDao {
    Optional<USER> findByLoginId(final String loginId);
}
