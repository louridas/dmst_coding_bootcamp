package stathoulap;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class WebController extends WebMvcConfigurerAdapter {

    private static final Logger log = LoggerFactory.getLogger(Exercise8Application.class);

    @Autowired
    private PersonRepository repository;
    
    @Autowired
    private SubjectRepository repository2;


    @RequestMapping(value={"/", "/home"}, method=RequestMethod.GET)
    public String showHome() {
	return "home";
    }
    
    
    @RequestMapping(value={"/katataksi"}, method=RequestMethod.GET)
    public String showkatataksi() {
	return "katataksi";
    }
    
    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public String showlogin() {
	return "login";
    }
    
    @RequestMapping(value = "/form.html", method = RequestMethod.GET)
    public String showForm(Person personForm) {
	return "form";
    }
    

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
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
    
    @RequestMapping(value={"/kataxorisi.html"}, method=RequestMethod.GET)
    public String showkataxorisi(Subject subjectForm) {
	return "kataxorisi";
    }
    
    @RequestMapping(value = "/submit2", method = RequestMethod.POST)
    public String checkSubjectsInfo(@Valid Subject subject, BindingResult bindingResult) {

	if (bindingResult.hasErrors()) {
	    return "kataxorisi";
	}

	repository2.save(subject);
	log.info("Subjects found with findAll():");
	log.info("-------------------------------");
	for (Subject subject1 : repository2.findAll()) {
	    log.info(subject1.toString());
	}

	return "redirect:/results2";
    }
    
    @RequestMapping(value = "/results2", method = RequestMethod.GET)
    public String showResults2(Model model) {
	Iterable<Subject> subjects = repository2.findAll();
	model.addAttribute("subjects", subjects);
	return "results2";
    }

}
