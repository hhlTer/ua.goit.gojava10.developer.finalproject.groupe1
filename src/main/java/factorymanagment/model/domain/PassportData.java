package factorymanagment.model.domain;


import javax.persistence.*;

@Entity
@Table(name = "passportData")
public class PassportData {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTaxId() {
        return taxId;
    }

    public void setTaxId(long taxId) {
        this.taxId = taxId;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "tax_id")
    private long taxId;

    @Column(name = "passport_number", length = 8)
    private String passportNumber;
}
