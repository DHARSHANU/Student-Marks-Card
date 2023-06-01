package dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity(name="teacher")
@Data
public class Teacher {
	
	@Id
	@GeneratedValue(generator="employeid")
	@SequenceGenerator(initialValue=456001,allocationSize=1,name="employeid",sequenceName="employeid")

	int  employeid;
	String name;
	@Column(nullable=false,unique=true)
	String  email;
	@Column(nullable=false,unique=true)

	String  subject;
	String  password;
	@Column(nullable=false,unique=true)
	long mobile;
	

}
