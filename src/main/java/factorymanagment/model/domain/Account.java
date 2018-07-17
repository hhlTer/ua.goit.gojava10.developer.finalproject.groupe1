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

    public long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(long account_id) {
        this.account_id = account_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
