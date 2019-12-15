package ua.nure.kravets.usermanagement171;

import java.util.Calendar;
import java.util.Date;

public class User {
private Long id;
private String firstName;
private String lastName;
private Date dateOfBirth;
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
}