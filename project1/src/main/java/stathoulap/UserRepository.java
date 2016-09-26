package stathoulap;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findBySurname(String surname);
    
    List<User> findByUsername(String username);
 
}
