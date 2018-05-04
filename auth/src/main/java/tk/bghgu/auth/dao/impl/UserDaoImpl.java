package tk.bghgu.auth.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.bghgu.auth.dao.UserDao;
import tk.bghgu.auth.domain.USER;
import tk.bghgu.auth.repository.UserRepository;

import java.util.Optional;

/**
 * Created by ds on 2018-05-03.
 */

@Service
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<USER> findByLoginId(String loginId) {
        return userRepository.findByLoginId(loginId);
    }
}
