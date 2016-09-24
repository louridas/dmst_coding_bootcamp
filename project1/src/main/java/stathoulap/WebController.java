package stathoulap;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class WebController extends WebMvcConfigurerAdapter {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private SubjectRepository subjectRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private UserDetailsService userDetailsService;


    @RequestMapping(value={"/", "/login"}, method=RequestMethod.GET)
    public String showLogin() {
	return "login";
    }
    
    @RequestMapping(value = "/home.html", method = RequestMethod.GET)
    public String showlogin() {
	return "home";
    }
    
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String showForm(User user) {
	return "form";
    }
    

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String checkPersonInfo(@Valid User user, BindingResult bindingResult) {
    	
    if (!user.getPlaintextPassword().equals(
          user.getPlaintextPasswordConf())) {
          FieldError fe = new FieldError("user", 
                     "plaintextPasswordConf", 
                     "passwords do not match");
          bindingResult.addError(fe);
         }

	if (bindingResult.hasErrors()) {
	    return "form";
	}
	
	String plaintextPassword = user.getPlaintextPassword();
    List<Role> roles = roleRepository.findByName("user");
    user.setRoles(roles);
    user.setPassword(passwordEncoder.encode((plaintextPassword)));
   
    log.info("About to save user...");
    userRepository.save(user);
    log.info("Saved user.");
    UserDetails userDetails = 
            userDetailsService.loadUserByUsername(user.getUsername());
    UsernamePasswordAuthenticationToken auth = 
    	new UsernamePasswordAuthenticationToken(userDetails, 
    		userDetails.getPassword(), userDetails.getAuthorities());
    
    SecurityContextHolder.getContext().setAuthentication(auth);
    return "home";
}

    @RequestMapping(value = "/katataksi.html", method = RequestMethod.GET)
    public String showResults(Model model) {
	Iterable<User> users = userRepository.findAll();
	model.addAttribute("users", users);
	return "katataksi";
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

	subjectRepository.save(subject);
	log.info("Subjects found with findAll():");
	log.info("-------------------------------");
	for (Subject subject1 : subjectRepository.findAll()) {
	    log.info(subject1.toString());
	}

	return "redirect:/results2";
    }
    
    @RequestMapping(value = "/results2", method = RequestMethod.GET)
    public String showResults2(Model model) {
	Iterable<Subject> subjects = subjectRepository.findAll();
	model.addAttribute("subjects", subjects);
	return "results2";
    }

}
