package data.daos.implementations;

import java.util.List;

import model.Division;
import data.DAO;
import data.daos.DAODivision;

public class DAODivisionImpl implements DAODivision {

	private DAO dao;
	public DAODivisionImpl(DAO dao) {
		this.dao = dao;
	}

	@Override
	public Division getDivisionByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Division> getDivisions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateDivision(Division p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertDivision(Division p) {
		// TODO Auto-generated method stub
		return false;
	}

}
