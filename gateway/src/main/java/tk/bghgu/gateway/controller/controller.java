package tk.bghgu.gateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ds on 2018-05-01.
 */

@RestController
public class controller {

    @GetMapping("/")
    public ResponseEntity welcome() {
        return new ResponseEntity("Welcome. GATEWAY SERVER.", HttpStatus.OK);
    }
}
