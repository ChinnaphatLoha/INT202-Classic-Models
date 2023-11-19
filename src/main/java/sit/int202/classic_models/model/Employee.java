package sit.int202.classic_models.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Employees")
@NamedQueries(
        {
                @NamedQuery(name = "EMPLOYEE.FIND_ALL", query = "SELECT e FROM Employee e"),
                @NamedQuery(name = "EMPLOYEE.FIND_BY_NAME", query = "SELECT e FROM Employee e WHERE e.firstName " +
                        "LIKE :first_name OR e.lastName LIKE :last_name")
        }
)
public class Employee {
    @Id
    private Integer employeeNumber;
    private String firstName;
    private String lastName;
    private String extension;
    private String email;
    private Integer reportsTo;
    private String jobTitle;
    @ManyToOne
    @JoinColumn(name = "officeCode", insertable = false, updatable = false)
    private Office office;
}
