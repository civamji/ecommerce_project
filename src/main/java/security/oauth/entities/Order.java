package security.oauth.entities;

        import javax.persistence.Entity;
        import javax.persistence.JoinColumn;
        import javax.persistence.ManyToOne;
        import java.util.Date;

@Entity
public class Order {
    private Long id;
    @ManyToOne
    @JoinColumn(name = "customer_user_id")
    private Customer customer;
//    private Double amountPaid;
//    private Date dateCreated;
//    private String paymentMethod;
//    private String CustomerAddressCity;
//    private String CustomerAddressState;
//    private String CustomerAddressCountry;
//    private String CustomerAddressAddressLine;
//    private String customerAddressZipCode;
//    private String CustomerAddressLabel;

}
