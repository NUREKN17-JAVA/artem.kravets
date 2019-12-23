package ua.nure.kravets.usermanagement171;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;



public class User implements Serializable {
	private static final long serialVersionUID = -3760492779402022862L;	
	private Long id;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;

 public User() {
    }
	
public User(Long id, String firstName, String lastName, Date dateOfBirth) {
		this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }
public User(String firstName, String lastName, Date date) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.dateOfBirth = date;

}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public Date getDateOfBirth() {
	return dateOfBirth;
}
public void setDateOfBirth(Date dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}
public String getFullName() {
	  return getLastName() + ", " + getFirstName();
}
public int getAge() {
	int age = 0;
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date());
    int currentYear = calendar.get(Calendar.YEAR);
    int currentMonth = calendar.get(Calendar.MONTH);
    int currentDay= calendar.get(Calendar.DAY_OF_MONTH);
    calendar.setTime(getDateOfBirth());
    int birthYear = calendar.get(Calendar.YEAR);
    int birthMonth = calendar.get(Calendar.MONTH);
    int birthDay= calendar.get(Calendar.DAY_OF_MONTH);
    if(birthMonth>currentMonth) {
		age = currentYear - birthYear - 1;
	}
	if (birthMonth<currentMonth) {
		age = currentYear - birthYear; 
	}
	if (birthMonth==currentMonth) {
		if(birthDay<currentDay) {
			age = currentYear - birthYear;
		}
		if(birthDay==currentDay) {
			age = currentYear - birthYear;
		}
		if (birthDay>currentDay) {
			age = currentYear - birthYear - 1; 
		}
	}	
	return age;
  }
public boolean equals(User obj) {
	if(obj == null) {
		return false;
	}
	if(this == obj) {
		return true;
	}
	if(this.getId()==null&&((User) obj).getId()==null) {
		return true;
	}
	return this.getId().equals(obj.getId());
}
public int hashCode() {
	if(this.getId()==null) {
		return 0;
	}
	return this.getId().hashCode();
}
}
