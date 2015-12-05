package data.daos;

import java.sql.SQLException;
import java.util.List;

import model.Division;
import model.Person;

public interface DAOPerson {

	public Person getPersonByID(int id) throws SQLException;

	public List<Person> getPersons() throws SQLException;
	
	public List<Person> getPersonsInDivison(Division d) throws SQLException;

	public boolean updatePerson(Person p);

	public boolean insertPerson(Person p);

}