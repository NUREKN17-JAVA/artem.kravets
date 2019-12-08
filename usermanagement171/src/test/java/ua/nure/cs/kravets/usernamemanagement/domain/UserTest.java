package ua.nure.cs.kravets.usernamemanagement.domain;

import java.util.Calendar;

import junit.framework.TestCase;

public class UserTest extends TestCase {

  private static final int ETALONE_AGE_1 = 19;
  private static final int DAY_OF_BIRTH = 17;
  private static final int MONTH_OF_BIRTH = 3;
  private static final int YEAR_OF_BIRTH = 2000;
  private User user;

  public void testGetFullName() {
    user.setFirstName("John");
    user.setLastName("Doe");
    assertEquals("Doe, John", user.getFullName());
  }
  
  public void testGetAge1() {
    Calendar calendar = Calendar.getInstance();
    calendar.set(YEAR_OF_BIRTH, MONTH_OF_BIRTH, DAY_OF_BIRTH);
    user.setDateOfBirth(calendar.getTime());
    assertEquals(ETALONE_AGE_1, user.getAge());
  }
  
  protected void setUp() throws Exception {
    super.setUp();
    user = new User();
  }

  protected void tearDown() throws Exception {
    super.tearDown();
  }

}