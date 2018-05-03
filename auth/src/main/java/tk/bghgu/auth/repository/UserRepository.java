package tk.bghgu.auth.repository;

import org.springframework.data.repository.CrudRepository;
import tk.bghgu.auth.domain.User;

import java.util.Optional;

/**
 * Created by ds on 2018-05-03.
 */

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByLoginId(final String loginId);
}
