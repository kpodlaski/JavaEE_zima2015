package data.daos;

import java.sql.SQLException;
import java.util.List;

import model.Role;

public interface DAORole {

	public Role getRoleByID(int id) throws SQLException;
	public List<Role> getRoles() throws SQLException;
	public boolean updateRole(Role p);
	public boolean insertRole(Role p);
}
