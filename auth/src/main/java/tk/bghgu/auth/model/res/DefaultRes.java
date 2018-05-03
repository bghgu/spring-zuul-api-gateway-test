package tk.bghgu.auth.model.res;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * Created by ds on 2018-05-03.
 */

@Data
public class DefaultRes {
    private Object data;
    private String msg;
    private HttpStatus httpStatus;
}
