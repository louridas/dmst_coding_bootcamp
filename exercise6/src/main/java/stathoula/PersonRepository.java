package stathoula;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<PersonForm, Long> {

    List<PersonForm> findBysur(String sur);
}
