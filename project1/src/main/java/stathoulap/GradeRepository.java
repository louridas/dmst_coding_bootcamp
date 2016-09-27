package stathoulap;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface GradeRepository extends CrudRepository<Grade, Long> {
    
    List<Grade> findByUserId(long userId);
    
}
