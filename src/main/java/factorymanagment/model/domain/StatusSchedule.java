package factorymanagment.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "status_schedule")
public class StatusSchedule {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    private DateTable date;

    @OneToOne(cascade = CascadeType.ALL)
    private Status status;

    @JoinColumn(name = "employee_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DateTable getDate() {
        return date;
    }

    public void setDate(DateTable date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StatusSchedule{" +
                "id=" + id +
                ", date=" + date +
                ", status=" + status +
                '}';
    }
}
