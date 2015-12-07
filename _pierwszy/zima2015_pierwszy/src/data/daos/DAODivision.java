package data.daos;

import java.sql.SQLException;
import java.util.List;

import model.Division;

public interface DAODivision {

	public Division getDivisionByID(int id) throws SQLException;
	public List<Division> getDivisions() throws SQLException;
	public boolean updateDivision(Division p);
	public boolean insertDivision(Division p);
	
}
