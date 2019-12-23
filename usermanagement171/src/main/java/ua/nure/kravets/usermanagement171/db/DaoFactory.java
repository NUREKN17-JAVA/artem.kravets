package ua.nure.kravets.usermanagement171.db;

import java.io.IOException;
import java.util.Properties;

import ua.nure.kravets.usermanagement171.User;

public abstract  class DaoFactory {

	protected static final String USER_DAO = "dao.knure.ctde.usermanagement171.db.UserDao";
	private static final String DAO_FACTORY ="dao.factory";
protected static Properties properties;
	
	private static DaoFactory instance;
	
	static {
		properties = new Properties();
		try {
			properties.load(DaoFactory.class.getClassLoader()
					.getResourceAsStream("settings.properties"));
		} catch (IOException e) {
			throw new RuntimeException("incorrect or missing settings");
		}
	}
	
	
	protected DaoFactory() {
		
	}
	
	public static synchronized DaoFactory getInstance() {
		if (instance == null) {
			Class<?> factoryClass;
			try {
				factoryClass = Class.forName(properties.getProperty(DAO_FACTORY));
				instance = (DaoFactory) factoryClass.newInstance();
			} catch (Exception e) {
				throw new RuntimeException();
			}
		}
		return instance;
	}
	
	public static void init (Properties p) {
		properties =  p;
		instance = null;
	}
	
	protected ConnectionFactory getConnectionFactory() {
		return new ConnectionFactoryImpl(properties);
	}
	
	public abstract UserDao<User> getUserDao();
}
