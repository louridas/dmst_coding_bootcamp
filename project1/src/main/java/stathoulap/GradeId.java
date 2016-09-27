package stathoulap;

import java.io.Serializable;

public class GradeId implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private long userId;
    
    private long courseId;
    
    public int hashCode() {
        return (int)(courseId + userId);
      }

    public boolean equals(Object object) {
        if (object instanceof GradeId) {
          GradeId otherId = (GradeId) object;
          return (otherId.userId == this.userId) 
                  && (otherId.courseId == this.courseId);
        }
        return false;
      }
}
