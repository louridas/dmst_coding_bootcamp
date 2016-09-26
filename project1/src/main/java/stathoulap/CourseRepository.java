package stathoulap;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.ModelAttribute;

public interface CourseRepository extends CrudRepository<Course, Long> {

    List<Course> findBySemester(int semester); 
	

}