package security.oauth.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Seller extends User{
    private String GST;
    private String companyName;
    private String companyContact;

    @OneToMany(mappedBy = "seller",cascade = CascadeType.ALL)
    private Set<Product> products;

    public Seller()
    {
    this.addRole(new Role(2,"ROLE SELLER"));
    }

    public Seller(String email, String firstName, String middleName, String lastName, String GST, String companyContact, String companyName) {
        super(email, firstName, middleName, lastName);
        this.GST = GST.toUpperCase();
        this.companyContact= companyContact;
        this.companyName = companyName;
        this.addRole(new Role(2,"ROLE SELLER"));
    }

    public String getGST() {
        return GST;
    }

    public void setGST(String GST) {
        this.GST = GST;
    }

    public String getCompnayContact() {
        return companyContact;
    }

    public void setCompnayContact(String compnayContact) {
        this.companyContact = compnayContact;
    }

    public String getComapnyName() {
        return companyName;
    }

    public void setComapnyName(String comapnyName) {
        this.companyName = comapnyName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }


    @Override
    public String toString() {
        return "Seller{" +
                super.toString() +
                "GST='" + GST + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyContact='" + companyContact + '\'' +
                '}';
    }

    public void addProduct(Product product){
        if(product != null){
            if(products == null)
                products = new HashSet<Product>();

            products.add(product);
            product.setSeller(this);
        }
    }
}
