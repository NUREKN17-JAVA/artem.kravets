package ua.nure.kravets.usermanagement171.db;

import java.util.Collection;

import ua.nure.kravets.usermanagement171.User;

public interface UserDao {
User create (User user) throws DatabaseException;

void update (User user) throws DatabaseException;

void delete (User user) throws DatabaseException;

User find (Long id) throws DatabaseException;

Collection findAll() throws DatabaseException;

void setConnectionFactory(ConnectionFactory connectionFactory);
}
