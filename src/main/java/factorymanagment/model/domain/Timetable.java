package factorymanagment.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "timetable")
public class Timetable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long timetableId;

    @Column(name = "date")
    private Date date;

    @OneToOne(cascade = CascadeType.ALL)
    private Event event;

    @OneToOne(cascade = CascadeType.ALL)
    private Status status;

    @OneToOne(cascade = CascadeType.ALL)
    private WorkHours workHours;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "timetable_employee",
                joinColumns = @JoinColumn(name = "timetable_id"),
                inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private Set<Employee> employeeSet;

    public long getTimetableId() {
        return timetableId;
    }

    public void setTimetableId(long timetableId) {
        this.timetableId = timetableId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public WorkHours getWorkHours() {
        return workHours;
    }

    public void setWorkHours(WorkHours workHours) {
        this.workHours = workHours;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }

    @Override
    public String toString() {
        return "Timetable{" +
                "date=" + date +
                ", event=" + event +
                ", status=" + status +
                ", workHours=" + workHours +
                ", employeeSet=" + employeeSet +
                '}';
    }
}
