package stathoulap;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Size(min = 2, max = 30)
    private String name;

    @Size(min = 2, max = 30)
    private String address;

    @Size(min = 2, max = 30)
    private String surname;

    @Email
    private String email;

    @NotNull
    @Min(18)
    private Integer age;

    @Size(min=8, max=30)
    private String username;

    @Transient
    @Size(min=8, max=30)
    private String plaintextPassword;

    @Transient
    @Size(min=8, max=30)
    private String plaintextPasswordConf;

    private String password;

    @ManyToMany
    @JoinTable(name="user_roles",
    joinColumns=@JoinColumn(name="user_id", referencedColumnName="id"),
    inverseJoinColumns=@JoinColumn(name="role_id",
    referencedColumnName="id"))
    private List<Role> roles;

    @OneToMany(mappedBy="userId")
    private List<Grade> grades;

    protected User() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public String toString() {
        StringBuffer strBuffer =
                new StringBuffer("User(username: " + this.username 
                        + ", Age: " + this.age);
        List<Grade> grades = getGrades();
        for (Grade grade : grades) {
            strBuffer.append(grade.toString());
        }
        strBuffer.append(")");
        return strBuffer.toString();
    }

}
