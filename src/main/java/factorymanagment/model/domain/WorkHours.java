package factorymanagment.model.domain;

import javax.persistence.*;

@Entity
@Table(name = "work_hours")
public class WorkHours {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int workHoursId;

    @Column(name = "start_time")
    private int startTime;

    @Column(name = "finish_time")
    private int finishTime;

    @Column(name = "hours")
    private int date;

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getWorkHoursId() {
        return workHoursId;
    }

    public void setWorkHoursId(int workHoursId) {
        this.workHoursId = workHoursId;
    }

    public int getStartTime() {
        return startTime;
    }

    @Override
    public String toString() {
        return "WorkHours{" +
                "workHoursId=" + workHoursId +
                ", startTime=" + startTime +
                ", finishTime=" + finishTime +
                ", date=" + date +
                '}';
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

}
