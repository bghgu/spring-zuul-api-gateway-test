package tk.bghgu.auth.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by ds on 2018-05-03.
 */

@Data
@Entity(name = "USER")
public class USER {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "UserName")
    private String name;

    @Column(name = "Password")
    private String pw;

    private String loginId;
}
