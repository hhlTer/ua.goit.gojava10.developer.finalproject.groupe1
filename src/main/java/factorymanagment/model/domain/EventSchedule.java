package factorymanagment.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "event_schedule")
public class EventSchedule {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long timetableId;

    @OneToOne(cascade = CascadeType.ALL)
    private DateTable date;

    @OneToOne(cascade = CascadeType.ALL)
    private Event event;

    @OneToOne(cascade = CascadeType.ALL)
    private WorkHours workHours;

    @JoinColumn(name = "employee_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Employee employee;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "event_employee",
//                joinColumns = @JoinColumn(name = "event_schedule_id"),
//                inverseJoinColumns = @JoinColumn(name = "employee_id"))

//    @JsonIgnore
//    @OneToMany (mappedBy = "event_schedule", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private Set<Employee> employeeSet;

    public long getTimetableId() {
        return timetableId;
    }

    public void setTimetableId(long timetableId) {
        this.timetableId = timetableId;
    }

    public DateTable getDate() {
        return date;
    }

    public void setDate(DateTable date) {
        this.date = date;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public WorkHours getWorkHours() {
        return workHours;
    }

    public void setWorkHours(WorkHours workHours) {
        this.workHours = workHours;
    }

//    public Set<Employee> getEmployeeSet() {
//        return employeeSet;
//    }

//    public void setEmployeeSet(Set<Employee> employeeSet) {
//        this.employeeSet = employeeSet;
//    }

    @Override
    public String toString() {
        return "EventSchedule{" +
                "timetableId=" + timetableId +
                ", date=" + date +
                ", event=" + event +
                ", workHours=" + workHours +
//                ", employeeSet=" + employeeSet +
                '}';
    }
}
