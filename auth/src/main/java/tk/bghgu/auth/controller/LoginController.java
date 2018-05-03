package tk.bghgu.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.bghgu.auth.model.req.LoginReq;
import tk.bghgu.auth.model.res.DefaultRes;
import tk.bghgu.auth.service.LoginService;

/**
 * Created by ds on 2018-05-03.
 */

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("")
    public ResponseEntity<DefaultRes> hello() {
        DefaultRes res = new DefaultRes();
        res.setHttpStatus(HttpStatus.OK);
        res.setMsg("Welcome AUTH Server");
        return new ResponseEntity<DefaultRes>(res, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<DefaultRes> login(LoginReq loginReq) {
        return new ResponseEntity<DefaultRes>(loginService.login(loginReq), HttpStatus.OK);
    }
}
