package sit.int202.classic_models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = "Product.FIND_ALL", query = "SELECT p FROM Product p"),
        @NamedQuery(name = "Product.COUNT", query = "SELECT count(p) as count FROM Product p")
})
@Table(name = "products", indexes = {
        @Index(name = "productLine", columnList = "productLine")
})
@Entity
public class Product {
    @Id
    private String productCode;
    private String productName;
    private String productLine;
    private String productScale;
    private String productVendor;
    private String productDescription;
    private Integer quantityInStock;
    private Double buyPrice; //cost
    @Column(name = "MSRP")
    private Double price; // MSRP Manufacturer Suggestion Retail Price
}
