package stathoulap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Entity
@Table(name="subjects")
public class Subject {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idsubject;
	
	@Min(0) @Max(10)
	private int math,java,oikonomia,posotikes,logistiki;

	public long getsubjectId() {
		return idsubject;
	}

	public void setsubjectId(long idsubject) {
		this.idsubject = idsubject;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public int getOikonomia() {
		return oikonomia;
	}

	public void setOikonomia(int oikonomia) {
		this.oikonomia = oikonomia;
	}

	public int getPosotikes() {
		return posotikes;
	}

	public void setPosotikes(int posotikes) {
		this.posotikes = posotikes;
	}

	public int getLogistiki() {
		return logistiki;
	}

	public void setLogistiki(int logistiki) {
		this.logistiki = logistiki;
	}
	
	public float getMesoOro(){
		
		return (math+java+oikonomia+posotikes+logistiki)/(float)5;
	}
	
	@Override
	public String toString() {
		return "Subject [subjectId=" + idsubject + ", math=" + math + ", java=" + java + ", oikonomia=" + oikonomia + ", posotikes="
				+ posotikes + ", logistiki=" + logistiki + "]";
	}


	
	
	

}

