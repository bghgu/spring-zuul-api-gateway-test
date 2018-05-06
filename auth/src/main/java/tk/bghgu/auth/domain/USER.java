package tk.bghgu.auth.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ds on 2018-05-06.
 */

@Data
@Entity
@Table(name = "user")
public class USER implements Serializable {

    private static final long serialVersionUID = 512939796779635692L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String loginId;

    private String password;

    private String name;
}
