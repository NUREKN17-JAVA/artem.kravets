package ua.nure.kravets.usermanagement171.db;

import junit.framework.TestCase;
import ua.nure.kravets.usermanagement171.User;

public class DaoFactoryTest extends TestCase {

	public void testGetUserDao() {
	    try {
			DaoFactory daoFactory = DaoFactory.getInstance();
			assertNotNull("DaoFactory instance is null", daoFactory);
			UserDao<User> userDao = daoFactory.getUserDao();
			assertNotNull("UserDao instance is null", userDao);
		} catch (RuntimeException e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

}
