package tk.bghgu.auth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.bghgu.auth.config.JwtInterceptor;
import tk.bghgu.auth.model.req.LoginReq;
import tk.bghgu.auth.model.res.DefaultRes;
import tk.bghgu.auth.service.LoginService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ds on 2018-05-03.
 */

@RestController
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @GetMapping("/main")
    public ResponseEntity<DefaultRes> hello() {
        logger.info("테스트 : hello");
        DefaultRes res = new DefaultRes();
        res.setHttpStatus(HttpStatus.OK);
        res.setMsg("Welcome AUTH Server");
        return new ResponseEntity<DefaultRes>(res, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<DefaultRes> login(LoginReq loginReq, HttpServletRequest request) {
        logger.info("테스트 : " + loginReq.toString());
        System.out.println(request.getHeader("Authorization"));
        return new ResponseEntity<DefaultRes>(loginService.login(loginReq), HttpStatus.OK);
    }

    @GetMapping("/home")
    public ResponseEntity<DefaultRes> home() {
        DefaultRes res = new DefaultRes();
        res.setHttpStatus(HttpStatus.OK);
        res.setMsg("Welcome AUTH Server Home");
        return new ResponseEntity<DefaultRes>(res, HttpStatus.OK);
    }
}
