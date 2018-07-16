package factorymanagment.model.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "employee")
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name = "tid")
    private long tid;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "telephone", length = 13)
    private String telephone;

    /**
     * Date format example:
     *
     * SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
     * String dateInString = "07/06/2013";
     *
     * Date date = formatter.parse(dateInString);
     *
     * System.out.println(date):
     * > Fri Jun 07 00:00:00 MYT 2013
     *
     * System.out.println(formatter.format(date)):
     * > 07/06/2013
     *
     */
    @Column(name = "born_date")
    private String bornDate;

    @Column(name = "sex")
    private boolean sex;

    @OneToOne(cascade = CascadeType.ALL)
    private Account account;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTid() {
        return tid;
    }

    public void setTid(long tid) {
        this.tid = tid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getBornDate() {
        return bornDate;
    }

    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    //    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "employer_role",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Set<Role> roles = new HashSet<>();








}
