package stathoula;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.Email;

public class PersonForm {

    @Size(min=2, max=30)
    private String name;


    @Size(min=2, max=30)
    private String adress;

    @Size(min=2, max=30)
    private String sur;

    @Email
    private String email;

    @NotNull
    @Min(18)
    private Integer age;

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



     public String getemail() {
		return this.email;
	}

	public void setemail(String email) {
		this.email = email;
    }

     public String getadress() {
			return this.adress;
		}

		public void setadress(String adress) {
			this.adress = adress;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }




    public String toString() {
        return "Person(Name: " + this.name + ",surname: " +this.sur + ", Age: " + this.age + ",email: " +this.email + ", Adress: " + this.adress + ", Age: " + this.age + ")";
    }
}
