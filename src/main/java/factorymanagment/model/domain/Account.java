package factorymanagment.model.domain;

import javax.persistence.*;

@Entity(name = "account")
public class Account {

    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long account_id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @JoinColumn(name = "id_role")
    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;
}
