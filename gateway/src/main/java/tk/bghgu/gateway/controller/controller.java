package tk.bghgu.gateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.bghgu.gateway.model.DefaultRes;

/**
 * Created by ds on 2018-05-01.
 */

@RestController
public class controller {

    @GetMapping("/")
    public ResponseEntity<DefaultRes<String>> welcome() {
        DefaultRes<String> res = new DefaultRes<>();
        res.setMsg("Welcome. GATEWAY SERVER.");
        res.setHttpStatus(HttpStatus.OK);
        return new ResponseEntity<DefaultRes<String>>(res, HttpStatus.OK);
    }
}
