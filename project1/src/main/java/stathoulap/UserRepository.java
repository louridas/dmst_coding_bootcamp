package stathoulap;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.ModelAttribute;

public interface UserRepository extends CrudRepository<User, Integer> {

    @ModelAttribute("users")
    List<User> findBysur(String sur);
    
    List<User> findByUsername(String username);
 
}
