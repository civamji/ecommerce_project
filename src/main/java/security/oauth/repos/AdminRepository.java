package security.oauth.repos;

import org.springframework.data.repository.CrudRepository;
import security.oauth.entities.Admin;

public interface AdminRepository extends CrudRepository<Admin,Long> {
}
