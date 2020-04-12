package security.oauth.repos;

import org.springframework.data.repository.CrudRepository;
import security.oauth.entities.Customer;

import java.awt.print.Pageable;
import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer,Long> {

    Customer findByEmail(String email);

    List<Customer> findAll();
    List<Customer> findAll(Pageable pageable);
}
