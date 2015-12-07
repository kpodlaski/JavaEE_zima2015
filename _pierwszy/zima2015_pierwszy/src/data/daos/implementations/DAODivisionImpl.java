package data.daos.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Division;
import model.Role;
import data.DAO;
import data.daos.DAODivision;

public class DAODivisionImpl implements DAODivision {

	private DAO dao;
	public DAODivisionImpl(DAO dao) {
		this.dao = dao;
	}

	private Division createDivisionFromResultSet(ResultSet rs) throws SQLException{
		Division d = new Division();
		d.setId(rs.getInt("id"));
		d.setName(rs.getString("Nazwa"));
		d.setMembers(dao.getPersonsInDivision(d));
		return d;
	}
	@Override
	public Division getDivisionByID(int id) throws SQLException {
		Connection con  = DAO.getConnection();
		PreparedStatement pst = con.prepareStatement(
				"Select * FROM Jednostka where id=?");
		pst.setInt(1, id);
		Division d = null;
		ResultSet rs = null;
		if (pst.execute() && (rs=pst.getResultSet()).next()){
			d = createDivisionFromResultSet(rs);
		}		
		return d;
	}

	@Override
	public List<Division> getDivisions() throws SQLException {
		Connection con  = DAO.getConnection();
		PreparedStatement pst = con.prepareStatement(
				"Select * FROM Jednostka");
		List<Division> divs = new ArrayList<Division>();
		ResultSet rs = null;
		if (pst.execute()){
			rs = pst.getResultSet();
			while (rs.next()){		
				Division d = createDivisionFromResultSet(rs);
				divs.add(d);
			}		
		}
		return divs;
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
