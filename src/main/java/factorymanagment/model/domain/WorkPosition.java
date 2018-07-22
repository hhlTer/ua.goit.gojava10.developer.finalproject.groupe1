package factorymanagment.model.domain;

import org.hibernate.annotations.Columns;

import javax.persistence.*;

@Entity
@Table(name="work_position")
public class WorkPosition {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "position_name")
    private String positionName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    @Override
    public String toString() {
        return "WorkPosition{" +
                "id=" + id +
                ", positionName='" + positionName + '\'' +
                '}';
    }
}
