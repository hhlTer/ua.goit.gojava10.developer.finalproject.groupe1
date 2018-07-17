package factorymanagment.model.domain;

import factorymanagment.controller.DateService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "company_calendar")
public class CompanyCalendar {

    @Autowired
    private DateService dateService;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String dateId;

    @Column(name = "date_format")
    private Date date;

    public String getDateId() {
        return dateId;
    }

    public void setDateId(String dateId) {
        this.dateId = dateId;
        this.date = dateService.formatStringToDate(dateId);
    }

    public Date getDate() {
        return date;
    }

}
