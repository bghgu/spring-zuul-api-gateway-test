package tk.bghgu.auth.dao;

import tk.bghgu.auth.domain.User;

import java.util.Optional;

/**
 * Created by ds on 2018-05-03.
 */
public interface UserDao {
    Optional<User> findByLoginId(final String loginId);
}
