package stathoulap;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.ModelAttribute;

public interface SubjectRepository extends CrudRepository<Subject, Long> {

    @ModelAttribute("subjects")
    List<Subject> findBymath(int math); 
	

}