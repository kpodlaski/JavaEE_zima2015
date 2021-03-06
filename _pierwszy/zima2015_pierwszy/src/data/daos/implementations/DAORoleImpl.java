package data.daos.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Person;
import model.Role;
import data.DAO;
import data.daos.DAORole;

public class DAORoleImpl implements DAORole {

	private DAO dao;
	public DAORoleImpl(DAO dao) {
		this.dao=dao;
	}

	private Role createRoleFromResultSet(ResultSet rs) throws SQLException{
		Role r = new Role();
		r.setId(rs.getInt("id"));
		r.setName(rs.getString("Nazwa"));
		return r;
	}
	@Override
	public Role getRoleByID(int id) throws SQLException {
		Connection con  = DAOImpl.getConnection();
		PreparedStatement pst = con.prepareStatement(
				"Select * FROM STANOWISKO where id=?");
		pst.setInt(1, id);
		Role r = null;
		ResultSet rs = null;
		if (pst.execute() && (rs=pst.getResultSet()).next()){
			r = createRoleFromResultSet(rs);
		}	
		//con.close();
		return r;
	}

	@Override
	public List<Role> getRoles() throws SQLException {
		Connection con  = DAOImpl.getConnection();
		PreparedStatement pst = con.prepareStatement(
				"Select * FROM STANOWISKO");
		List<Role> roles = new ArrayList<Role>();
		ResultSet rs = null;
		if (pst.execute()){
			rs = pst.getResultSet();
			while (rs.next()){		
				Role r = createRoleFromResultSet(rs);
				roles.add(r);
			}		
		}
		//con.close();
		return roles;
	}

	@Override
	public boolean updateRole(Role p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertRole(Role p) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static void main(String ... s) throws SQLException{
		DAO dao = new DAOImpl();
		Role r = dao.getRoleByID(2);
		System.out.println(r.getId()+ " "+r.getName());
		System.out.println("====================");
		System.out.println(dao.getRoles());
	}
	

}
