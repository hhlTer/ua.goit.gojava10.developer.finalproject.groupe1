package factorymanagment.model.domain;


import javax.persistence.*;

@Entity
@Table(name = "passportData")
public class PassportData {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "tax_id")
    private long taxId;

    @Column(name = "passport_number", length = 8)
    private String passportNumber;
}
