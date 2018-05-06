package tk.bghgu.auth.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tk.bghgu.auth.dao.UserDao;
import tk.bghgu.auth.domain.USER;
import tk.bghgu.auth.model.req.LoginReq;
import tk.bghgu.auth.model.res.DefaultRes;
import tk.bghgu.auth.service.JwtService;
import tk.bghgu.auth.service.LoginService;

import java.util.Optional;

/**
 * Created by ds on 2018-05-03.
 */


@Service
public class LoginServiceImpl implements LoginService {

    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private JwtService jwtService;

    @Override
    public DefaultRes<String> login(LoginReq loginReq) {
        logger.info("테스트 : loginService");
        Optional<USER> user = userDao.findByLoginId((loginReq.getId()));
        DefaultRes<String> res = new DefaultRes<>();
        if(!user.isPresent()) {
            logger.info("테스트 : No USER");
            res.setMsg("No USER");
            res.setHttpStatus(HttpStatus.UNAUTHORIZED);
            return res;
        }
        if(!user.get().getPassWord().equals(loginReq.getPw())) {
            logger.info("테스트 : NOT MATCH PW");
            res.setMsg("NOT MATCH PW");
            res.setHttpStatus(HttpStatus.UNAUTHORIZED);
            return res;
        }
        logger.info("테스트 : LOGIN SUCCESS");
        res.setMsg("LOGIN SUCCESS");
        res.setHttpStatus(HttpStatus.OK);
        res.setData(jwt(user.get()));
        return null;
    }

    private String jwt(final USER user) {
        return jwtService.createToken(user.getLoginId(), user);
    }
}
