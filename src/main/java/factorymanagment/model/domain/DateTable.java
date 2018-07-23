package factorymanagment.model.domain;

import sun.java2d.pipe.SpanShapeRenderer;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "date_table")
public class DateTable {

    @Id
    @Column(name = "date_string_id")
    private String dateId;

    @Column(name = "date")
    private Date date;

    public String getDateId() {
        return dateId;
    }

    public void setDateId(String dateId) {
        this.dateId = dateId;
    }

    public Date getDate() {
        if (null == date){
            setDate(dateId);
        }
        return date;
    }

    public void setDate(String dateId) {
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        Date date = null;
        try {
            date = format.parse(dateId);
        } catch (ParseException e) {
            System.out.println("Wrong date format. Set \"dd/mm/yyyy\"");
            e.printStackTrace();
        }
        this.date = date;
    }
}
