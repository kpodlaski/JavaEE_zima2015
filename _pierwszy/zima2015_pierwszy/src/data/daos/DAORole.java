package data.daos;

import java.util.List;

import model.Role;

public interface DAORole {

	public Role getRoleByID(int id);
	public List<Role> getRoles();
	public boolean updateRole(Role p);
	public boolean insertRole(Role p);
}
