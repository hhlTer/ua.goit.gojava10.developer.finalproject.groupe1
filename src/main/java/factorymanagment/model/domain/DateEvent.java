package factorymanagment.model.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "date_event")
public class DateEvent {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long dateEventId;

    @OneToOne(cascade = CascadeType.ALL)
    private CompanyCalendar companyCalendar;

    @OneToOne(cascade = CascadeType.ALL)
    private Event event;

    @OneToMany(mappedBy = "date_event", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Employee> employees;


    public long getDateEventId() {
        return dateEventId;
    }

    public void setDateEventId(long dateEventId) {
        this.dateEventId = dateEventId;
    }

    public CompanyCalendar getCompanyCalendar() {
        return companyCalendar;
    }

    public void setCompanyCalendar(CompanyCalendar companyCalendar) {
        this.companyCalendar = companyCalendar;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "DateEvent{" +
                "dateEventId=" + dateEventId +
                ", companyCalendar=" + companyCalendar +
                ", event=" + event +
                ", employees=" + employees +
                '}';
    }
}
