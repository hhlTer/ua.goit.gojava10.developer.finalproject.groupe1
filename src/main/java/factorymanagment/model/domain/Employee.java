package factorymanagment.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Entity(name = "employee")
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "telephone", length = 13)
    private String telephone;

    @Column(name = "photoUri")
    private String photoUri;

    @OneToOne(fetch = FetchType.EAGER)
    private PassportData passportData;

    @OneToOne(fetch = FetchType.EAGER)
    private WorkPosition workPosition;


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
    private Date bornDate;

    @Column(name = "sex")
    private boolean sex;

    @Column(name = "salary_per_hour")
    private BigDecimal salaryPerHour;

    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    @JsonIgnore
    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<StatusSchedule> statusScheduleSet;

    @JsonIgnore
    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<EventSchedule> eventScheduleSet;



    public Set<StatusSchedule> getStatusScheduleSet() {
        return statusScheduleSet;
    }

    public void setStatusScheduleSet(Set<StatusSchedule> statusScheduleSet) {
        this.statusScheduleSet = statusScheduleSet;
    }
    //    public EventSchedule getEventSchedule() {
//        return eventSchedule;
//    }

//    public void setEventSchedule(EventSchedule eventSchedule) {
//        this.eventSchedule = eventSchedule;
//    }

//    @JoinColumn(name = "event_schedule_id")
//    @ManyToOne(fetch = FetchType.EAGER)
//    private EventSchedule eventSchedule;


//    @JoinColumn(name = "timetable_id")
//    @ManyToOne(fetch = FetchType.EAGER)
//    private EventSchedule timetable;

//    @JoinColumn(name = "date_event_id")
//    @OneToMany(fetch = FetchType.EAGER)
//    private Set<EventSchedule> timetables;


    public WorkPosition getWorkPosition() {
        return workPosition;
    }

    public void setWorkPosition(WorkPosition workPosition) {
        this.workPosition = workPosition;
    }

    public BigDecimal getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(BigDecimal salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
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

    public String getPhotoUri() {
        return photoUri;
    }

    public void setPhotoUri(String photoUri) {
        this.photoUri = photoUri;
    }

//    public EventSchedule getTimetable() {
//        return timetable;
//    }
//
//    public void setTimetable(EventSchedule timetable) {
//        this.timetable = timetable;
//    }

    public PassportData getPassportData() {
        return passportData;
    }

    public void setPassportData(PassportData passportData) {
        this.passportData = passportData;
    }

    public String getFormatBornDate(){
        SimpleDateFormat dateFormat = null;
        dateFormat = new SimpleDateFormat("dd.MM.yyyy ");
        return dateFormat.format(getBornDate());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", photoUri='" + photoUri + '\'' +
                ", passportData=" + passportData +
                ", workPosition=" + workPosition +
                ", bornDate=" + bornDate +
                ", sex=" + sex +
                ", salaryPerHour=" + salaryPerHour +
                ", account=" + account +
//                ", eventSchedule=" + eventSchedule +
                ", statusScheduleSet=" + statusScheduleSet +
                '}';
    }
}
