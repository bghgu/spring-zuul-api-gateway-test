package tk.bghgu.auth.model.req;

import lombok.Data;

/**
 * Created by ds on 2018-05-03.
 */

@Data
public class LoginReq {
    private String id;
    private String pw;
}
