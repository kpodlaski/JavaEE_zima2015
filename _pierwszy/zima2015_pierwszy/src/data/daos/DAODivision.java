package data.daos;

import java.util.List;

import model.Division;

public interface DAODivision {

	public Division getDivisionByID(int id);
	public List<Division> getDivisions();
	public boolean updateDivision(Division p);
	public boolean insertDivision(Division p);
	
}
