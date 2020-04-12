package security.oauth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import security.oauth.entities.User;
import security.oauth.repos.UserRepository;

@Service
public class UserDao {

    @Autowired
    UserRepository userRepository;

    AppUser loadUserByUsername(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return new AppUser(user);
        } else {
            throw new UsernameNotFoundException("user  " + user.getEmail() + " was not found");
        }
    }

}