package tk.bghgu.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.bghgu.auth.dao.UserDao;
import tk.bghgu.auth.domain.User;
import tk.bghgu.auth.model.req.LoginReq;
import tk.bghgu.auth.model.res.DefaultRes;
import tk.bghgu.auth.service.LoginService;

import java.util.Optional;

/**
 * Created by ds on 2018-05-03.
 */


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserDao userDao;

    @Override
    public DefaultRes login(LoginReq loginReq) {
        Optional<User> user = userDao.findByLoginId((loginReq.getId()));
        return null;
    }
}
