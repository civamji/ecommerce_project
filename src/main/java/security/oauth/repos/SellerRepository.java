package security.oauth.repos;

import org.springframework.data.repository.CrudRepository;
import security.oauth.entities.Seller;

public interface SellerRepository extends CrudRepository<Seller,Long> {
}
