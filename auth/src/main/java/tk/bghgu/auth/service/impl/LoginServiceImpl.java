package tk.bghgu.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tk.bghgu.auth.dao.UserDao;
import tk.bghgu.auth.domain.USER;
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
        Optional<USER> user = userDao.findByLoginId((loginReq.getId()));
        DefaultRes res = new DefaultRes();
        if(!user.isPresent()) {
            res.setMsg("No USER");
            res.setHttpStatus(HttpStatus.UNAUTHORIZED);
            return res;
        }
        if(!user.get().getPw().equals(loginReq.getPw())) {
            res.setMsg("NOT MATCH PW");
            res.setHttpStatus(HttpStatus.UNAUTHORIZED);
            return res;
        }

        return null;
    }
}
