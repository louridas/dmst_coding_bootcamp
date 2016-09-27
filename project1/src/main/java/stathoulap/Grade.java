package stathoulap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="grades")
@IdClass(GradeId.class)
public class Grade {

    @Id
    @Column(name="user_id")
    private long userId;
    
    @Id
    @Column(name="course_id")
    private long courseId;
        
    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName="id", 
        updatable=false, insertable=false)
    private User user;
    
    @ManyToOne
    @JoinColumn(name="course_id", referencedColumnName="id",
        updatable=false, insertable=false)
    private Course course;
    
    protected Grade() { }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }    
}
