package factorymanagment.model.domain;

import javax.persistence.*;

@Entity(name = "employee")
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;
}
