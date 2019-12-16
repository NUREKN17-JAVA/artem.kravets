package ua.nure.kravets.usermanagement171.db;

import com.mockobjects.dynamic.Mock;

import ua.nure.kravets.usermanagement171.User;

public class MockDaoFactory extends DaoFactory {

	private Mock mockUserDao;
	
	public MockDaoFactory() {
		mockUserDao = new Mock(UserDao.class);
	}

	public Mock getMockUserDao() {
	       return mockUserDao;
	}
	    
	public UserDao<User> getUserDao() {
	       return (UserDao<User>) mockUserDao.proxy();
	}

}