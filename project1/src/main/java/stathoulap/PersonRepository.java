package stathoulap;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.ModelAttribute;

public interface PersonRepository extends CrudRepository<Person, Integer> {

    @ModelAttribute("persons")
    List<Person> findBysur(String sur);
}
