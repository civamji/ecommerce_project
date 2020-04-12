package security.oauth.repos;

import org.springframework.data.repository.CrudRepository;
import security.oauth.entities.Role;
public interface RoleRepository extends CrudRepository<Role,Long> {
}
