package data;

import java.util.List;

import data.daos.DAODivision;
import data.daos.DAOPerson;
import data.daos.DAORole;
import model.*;

public class  DAO {
		public static String conString = "jdbc:oracle:thin:@oradb.pi.uni.lodz.pl:1521:orcl";
		public static String userName = 	"javastudent";
		public static String passwd = "p@ssw0rd";
	
		DAOPerson daoPerson = null;
		DAODivision daoDivision = null;
		DAORole daoRole = null;	
		
		public Person getPersonByID(int id) {
			return daoPerson.getPersonByID(id);
		}
		public List<Person> getPersons() {
			return daoPerson.getPersons();
		}
		public boolean updatePerson(Person p) {
			return daoPerson.updatePerson(p);
		}
		public boolean insertPerson(Person p) {
			return daoPerson.insertPerson(p);
		}
		public Division getDivisionByID(int id) {
			return daoDivision.getDivisionByID(id);
		}
		public List<Division> getDivisions() {
			return daoDivision.getDivisions();
		}
		public boolean updateDivision(Division p) {
			return daoDivision.updateDivision(p);
		}
		public boolean insertDivision(Division p) {
			return daoDivision.insertDivision(p);
		}
		public Role getRoleByID(int id) {
			return daoRole.getRoleByID(id);
		}
		public List<Role> getRoles() {
			return daoRole.getRoles();
		}
		public boolean updateRole(Role p) {
			return daoRole.updateRole(p);
		}
		public boolean insertRole(Role p) {
			return daoRole.insertRole(p);
		}
		
}
