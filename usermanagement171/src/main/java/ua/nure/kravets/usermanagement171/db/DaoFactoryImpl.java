package ua.nure.kravets.usermanagement171.db;

import ua.nure.kravets.usermanagement171.User;

public class DaoFactoryImpl extends DaoFactory {

		public UserDao<User> getUserDao() {
			UserDao<User> result;
			try {
				Class<?> clazz = Class.forName(properties.getProperty(USER_DAO));
				result = (UserDao<User>) clazz.newInstance();
				result.setConnectionFactory(getConnectionFactory());
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			return result;
		}

}
