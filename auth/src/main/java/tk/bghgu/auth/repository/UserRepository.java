package tk.bghgu.auth.repository;

import org.springframework.data.repository.CrudRepository;
import tk.bghgu.auth.domain.USER;

import java.util.Optional;

/**
 * Created by ds on 2018-05-03.
 */

public interface UserRepository extends CrudRepository<USER, Integer> {
    //Optional<USER> findByLoginId(final String loginId);
}
