package data;

import java.sql.SQLException;
import java.util.List;

import model.Division;
import model.Person;
import model.Role;

public interface DAO {

	public abstract Person getPersonByID(int id) throws SQLException;

	public abstract List<Person> getPersons() throws SQLException;

	public abstract List<Person> getPersonsInDivision(Division d)
			throws SQLException;

	public abstract boolean updatePerson(Person p);

	public abstract boolean insertPerson(Person p);

	public abstract Division getDivisionByID(int id) throws SQLException;

	public abstract List<Division> getDivisions() throws SQLException;

	public abstract boolean updateDivision(Division p);

	public abstract boolean insertDivision(Division p);

	public abstract Role getRoleByID(int id) throws SQLException;

	public abstract List<Role> getRoles() throws SQLException;

	public abstract boolean updateRole(Role p);

	public abstract boolean insertRole(Role p);

	public abstract List<Person> getPersonsInDivison(Division d)
			throws SQLException;

}