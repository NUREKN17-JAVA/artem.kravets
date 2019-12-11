package ua.nure.kravets.usermanagement171.db;

import java.util.Date;
import java.util.Collection;

import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.XmlDataSet;
import ua.nure.kravets.usermanagement171.User;

public class HsqldbUserDaoTest extends DatabaseTestCase {
	private static final Date DATE_OF_BIRTH_UPDATE = new Date(2000-04-11);
	private static final String UPDATED_MY_LAST_NAME = "Artem";
	private static final long ID = 1L;
	private static final String MY_LAST_NAME = "Doe";
	private static final String MY_FIRST_NAME = "John";
	private HsqldbUserDao dao;
	private ConnectionFactory connectionFactory;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		dao = new HsqldbUserDao(connectionFactory);
		
	}

	public void testCreate() {
		try {
			User user = new User ();
			user.setFirstName(MY_FIRST_NAME);
			user.setLastName(MY_LAST_NAME);
			user.setDateOfBirth(new Date());
			assertNull (user.getId());
			user = dao.create(user);
			assertNotNull(user);
			assertNotNull(user.getId());
		} catch (DatabaseException e) {
			e.printStackTrace();
			fail(e.toString());
		}
	
	}
	
	public void testFindAll() {
		try {
			Collection collection =	dao.findAll();
			assertNotNull ("Collection is null", collection);
			assertEquals ("Collection size.", 2, collection.size());
		} catch (DatabaseException e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}
	public void testFind() throws DatabaseException {
	       try{
	           User user = dao.find(ID);
	           assertNotNull(user);
	       } catch (DatabaseException e){
	           e.printStackTrace();
	           fail(e.toString());
	       }

	    }
	
	public void testUpdate() throws DatabaseException {
        User testUpdateUserLN = new User(ID, MY_FIRST_NAME, MY_LAST_NAME, new Date());
        dao.create(testUpdateUserLN);
        testUpdateUserLN.setLastName(UPDATED_MY_LAST_NAME);
        dao.update(testUpdateUserLN);
        User updatedUser = dao.find(testUpdateUserLN.getId());
        assertNotNull(updatedUser);
        assertEquals(testUpdateUserLN.getFirstName(), updatedUser.getFirstName());
        assertEquals(testUpdateUserLN.getLastName(), updatedUser.getLastName());
    }
	public void testDelete() throws DatabaseException{
		User user = new User();
		user.setFirstName(MY_FIRST_NAME);
		user.setLastName(MY_LAST_NAME);
		user.setDateOfBirth(DATE_OF_BIRTH_UPDATE);
		User userToChek = dao.create(user);
		assertNotNull(userToChek.getId());
		dao.delete(userToChek);
		User user2 = dao.find(userToChek.getId());
		assertNull(user2);
		assertNull(user2.getId());
	}


	@Override
	protected IDatabaseConnection getConnection() throws Exception {
		connectionFactory = new ConnectionFactoryImpl("org.hsqldb.jdbcDriver", 
				"jdbc:hsqldb:file:db/usermanegement171",
				"sa", "");
		return new DatabaseConnection(connectionFactory.createConnection());
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		IDataSet dataSet = new XmlDataSet (getClass().getClassLoader()
				.getResourceAsStream("usersDataSet.xml"));
		return dataSet;
	}

}
