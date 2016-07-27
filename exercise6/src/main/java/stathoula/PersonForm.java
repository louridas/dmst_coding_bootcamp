package stathoula;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.Email;

@Entity
public class PersonForm {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
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

		protected PersonForm() {}

		public PersonForm(String name, String sur , int age , String email , String adress) {
			this.name = name;
			this.sur = sur;
			this.age = age;
			this.email = email;
			this.adress = adress;
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
           return "Person " + this.id +":\n"+
           "Name: " + this.name +"\n"+
			"surname: " +this.sur +"\n"+
			"Age: " + this.age +"\n"+
			"email: " +this.email +"\n"+
			"Adress: " + this.adress +"\n"+
			"Age: " + this.age ;
    }

}

