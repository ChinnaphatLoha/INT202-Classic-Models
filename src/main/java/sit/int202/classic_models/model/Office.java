package sit.int202.classic_models.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Offices")
@NamedQueries(
        {
                @NamedQuery(name = "OFFICE.FIND_ALL", query = "SELECT o FROM Office o"),
                @NamedQuery(name = "OFFICE.FIND_BY_COUNTRY", query = "SELECT o FROM Office o " +
                        "WHERE o.country LIKE :countryParam"),
                @NamedQuery(name = "OFFICE.DELETE", query = "DELETE FROM Office o WHERE o.officeCode = :office_code"),
                @NamedQuery(name = "OFFICE.FIND_BY_CITY_OR_COUNTRY", query = "select o from Office o where lower(o.city) like :city or lower(o.country) like :country"),
                @NamedQuery(name = "OFFICE.GET_NUMBER_OF_EMPLOYEES_IN_OFFICE", query = "select count(e.employeeNumber) from Employee e where e.office.officeCode = :officeCode")
        }
)
public class Office {
    @Id
    private String officeCode;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private String phone;
    private String territory;
    @OneToMany(mappedBy = "office")
    private List<Employee> employeeList;

    public Office(String officeCode, String addressLine1, String addressLine2, String city, String state, String country, String postalCode, String phone, String territory) {
        this.officeCode = officeCode;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
        this.phone = phone;
        this.territory = territory;
    }

    public Office() {

    }
}