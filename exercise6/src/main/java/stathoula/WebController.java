package stathoula;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class WebController extends WebMvcConfigurerAdapter {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private PersonRepository repository;

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//	registry.addViewController("/results").setViewName("results");
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showForm(Person personForm) {
	return "form";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String checkPersonInfo(@Valid Person person, BindingResult bindingResult) {

	if (bindingResult.hasErrors()) {
	    return "form";
	}

	repository.save(person);
	log.info("People found with findAll():");
	log.info("-------------------------------");
	for (Person person1 : repository.findAll()) {
	    log.info(person1.toString());
	}

	return "redirect:/results";
    }
    
    @RequestMapping(value = "/results", method = RequestMethod.GET)
    public String showResults(Model model) {
	Iterable<Person> persons = repository.findAll();
	model.addAttribute("persons", persons);
	return "results";
    }

}
