package factorymanagment.model.domain;

import javax.persistence.*;
import java.util.Set;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "account_role",
        joinColumns = @JoinColumn(name = "account_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roleSet;

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

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }
}
