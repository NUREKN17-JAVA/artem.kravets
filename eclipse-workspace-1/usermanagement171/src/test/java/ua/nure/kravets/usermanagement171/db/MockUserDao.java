package ua.nure.kravets.usermanagement171.db;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ua.nure.kravets.usermanagement171.User;

public class MockUserDao implements UserDao<User> {
	
	private long id = 0;
	private Map<Long, User> users = new HashMap<> ();
	
	public User create(User user) throws DatabaseException {
        Long id = new Long(users.size() + 1);
        users.put(id, user);
        user.setId(id);

        return user;
    }

    public void update(User user) throws DatabaseException {
        users.put(new Long(user.getId()), user);
    }

    public void delete(User user) throws DatabaseException {
        users.remove(new Long(user.getId()));
    }

    public User find(Long id) throws DatabaseException {
        return users.get(id);
    }

    public Collection<User> findAll() throws DatabaseException {
        return users.values();
    }

    public void setConnectionFactory(ConnectionFactory connectionFactory) {
    }

	@Override
	public Collection<User> find(String firstName, String lastName) throws DatabaseException {
		throw new UnsupportedOperationException();
	}

}
