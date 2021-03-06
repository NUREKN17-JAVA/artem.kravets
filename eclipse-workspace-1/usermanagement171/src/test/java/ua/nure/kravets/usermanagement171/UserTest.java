package ua.nure.kravets.usermanagement171;

import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;


public class UserTest extends TestCase {
	
	  private static final int CURRENT_YEAR = 2019;
	  private static final int ETALONE_AGE1 = 19;
	  private static final int DAY_OF_BIRTH = 17;
	  private static final int MONTH_OF_BIRTH = 3;
	  private static final int YEAR_OF_BIRTH = 2000;
		
		/**Test case #2 DATE OF BIRTH is today*/
		private static final int DAY_OF_BIRTH2 = 2;
		private static final int MONTH_OF_BIRTH2 = 11;
		
		
		/**Test case #3 DATE OF BIRTH is tomorrow*/
		private static final int DAY_OF_BIRTH3 = 3;
		private static final int MONTH_OF_BIRTH3 = 11;
		
		
		/**Test case #4 DATE OF BIRTH is yesterday*/
		private static final int DAY_OF_BIRTH4 = 4;
		private static final int MONTH_OF_BIRTH4 = 11;
		private static final int ETALONE_AGE4 = CURRENT_YEAR - YEAR_OF_BIRTH;
		
		/**Test case #5 DATE OF BIRTH is in future*/
		private static final int DAY_OF_BIRTH5 = 31;
		private static final int MONTH_OF_BIRTH5 = 12;
		private static final int ETALONE_AGE5 = CURRENT_YEAR - YEAR_OF_BIRTH - 1;
		
	  private User user;
	  private Date dateOfBirth;

	protected void setUp() throws Exception {
		super.setUp();
		user = new User();
	}
	
	
	public void testGetFullName() {
		 user.setFirstName("John");
		 user.setLastName("Doe");
		 assertEquals("Doe, John", user.getFullName());
	}
	 public void testGetAge1() {
		 Calendar calendar = Calendar.getInstance();
		 calendar.set(YEAR_OF_BIRTH, MONTH_OF_BIRTH, DAY_OF_BIRTH);
		 user.setDateOfBirth(calendar.getTime());
		 assertEquals(ETALONE_AGE1, user.getAge());
		  }
	 public void testGetAge2() { //BD is today
	    	Calendar calendar =  Calendar.getInstance();
	    	calendar.set(YEAR_OF_BIRTH, MONTH_OF_BIRTH2, DAY_OF_BIRTH2);
	      	user.setDateOfBirth(calendar.getTime());
	      	assertEquals(ETALONE_AGE1, user.getAge());
	    }
	 public void testGetAge3() { //BD is tomorrow
	    	Calendar calendar =  Calendar.getInstance();
	    	calendar.set(YEAR_OF_BIRTH, MONTH_OF_BIRTH3, DAY_OF_BIRTH3);
	      	user.setDateOfBirth(calendar.getTime());
	      	assertEquals(ETALONE_AGE1, user.getAge());
	    }
	 public void testGetAge4() { //BD is yesterday
	    	Calendar calendar =  Calendar.getInstance();
	    	calendar.set(YEAR_OF_BIRTH, MONTH_OF_BIRTH4, DAY_OF_BIRTH4);
	      	user.setDateOfBirth(calendar.getTime());
	      	assertEquals(ETALONE_AGE4, user.getAge());
	    }
	 public void testGetAge5() { //BD is in future
	    	Calendar calendar =  Calendar.getInstance();
	    	calendar.set(YEAR_OF_BIRTH, MONTH_OF_BIRTH5, DAY_OF_BIRTH5);
	      	user.setDateOfBirth(calendar.getTime());
	      	assertEquals(ETALONE_AGE5, user.getAge());
	    }
	 protected void tearDown() throws Exception {
		    super.tearDown();	
		  }
	 public Date getDateOfBirth() {
			return dateOfBirth;
		}
	public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
}
