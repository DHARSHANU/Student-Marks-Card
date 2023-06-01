package dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import lombok.Data;

@Entity(name="student")
@Data
public class Student {

	
	@Id
	@GeneratedValue(generator="reg")
	@SequenceGenerator(initialValue=121001,allocationSize=1,name="reg",sequenceName="reg")
	
	int regno;
	String name;
	@Column(nullable=false,unique=true)
	String email;
	@Column(nullable=false,unique=true)
	long mobile;
	String password;
	int standard;
	@Lob
	byte[] picture;
	
	@OneToMany(cascade=CascadeType.ALL)
	List<MarksCard> cards;	

	
}
