package tk.bghgu.gateway.model;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * Created by ds on 2018-05-03.
 */

@Data
public class DefaultRes<T> {
    private String msg;
    private T data;
    private HttpStatus httpStatus;
}
