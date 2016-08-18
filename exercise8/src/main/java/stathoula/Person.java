package stathoula;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.Email;
import javax.persistence.Transient;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Size(min = 2, max = 30)
    private String name;

    @Size(min = 2, max = 30)
    private String address;

    @Size(min = 2, max = 30)
    private String sur;

    @Email
    private String email;

    @NotNull
    @Min(18)
    private Integer age;

	@Transient
	@Size(min=8, max=30)
	private String plaintextPassword;

	@Transient
	@Size(min=8, max=30)
	private String plaintextPasswordConf;

    private String password;

    protected Person() {
    }

    public Person(String name, String sur, int age, String email, String adress) {
	this.name = name;
	this.sur = sur;
	this.age = age;
	this.email = email;
	this.address = adress;
    }

    public String getName() {
	return this.name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getSur() {
	return this.sur;
    }

    public void setSur(String sur) {
	this.sur = sur;
    }

    public String getEmail() {
	return this.email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getAddress() {
	return this.address;
    }

    public void setAddress(String adress) {
	this.address = adress;
    }

    public Integer getAge() {
	return age;
    }

    public void setAge(Integer age) {
	this.age = age;
    }

     public String getPlaintextPassword() {
		return plaintextPassword;
	}

	public void setPlaintextPassword(String plaintextPassword) {
		this.plaintextPassword = plaintextPassword;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPlaintextPasswordConf() {
		return plaintextPasswordConf;
	}

	public void setPlaintextPasswordConf(String plaintextPasswordConf) {
		this.plaintextPasswordConf = plaintextPasswordConf;
    }

    public String toString() {
	return "Person " + this.id + ":\n" + "Name: " + this.name + "\n" + "surname: " + this.sur + "\n" + "Age: "
		+ this.age + "\n" + "email: " + this.email + "\n" + "Adress: " + this.address + "\n" + "Age: "
		+ this.age;
    }

}
