package security.oauth.entities;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer extends User {

private String contact;
@OneToMany(mappedBy = "reviewer",cascade = CascadeType.ALL)
private List<ProductReview> reviews;
public Customer(){
    this.addRole(new Role(3,"ROLE_CUSTOMER"));
}

    public Customer(String email, String firstName, String middleName, String lastName, String contact) {
        super(email, firstName, middleName, lastName);
        this.contact = contact;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<ProductReview> getReviews() {
        return reviews;
    }

    public void setReviews(List<ProductReview> reviews) {
        this.reviews = reviews;
    }

    public void addReview(ProductReview review){
        if(review != null){
            if(reviews == null)
                reviews = new ArrayList<>();

            reviews.add(review);

            review.setAuthor(this);
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "contact='" + contact + '\'' +
                ", reviews=" + reviews +
                '}';
    }
}

