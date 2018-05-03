package tk.bghgu.auth.service;

import tk.bghgu.auth.model.req.LoginReq;
import tk.bghgu.auth.model.res.DefaultRes;

/**
 * Created by ds on 2018-05-03.
 */

public interface LoginService {
    DefaultRes login(final LoginReq loginReq);
}
