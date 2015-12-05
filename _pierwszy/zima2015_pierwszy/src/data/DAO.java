package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import data.daos.DAODivision;
import data.daos.DAOPerson;
import data.daos.DAORole;
import data.daos.implementations.DAODivisionImpl;
import data.daos.implementations.DAOPersonImpl;
import data.daos.implementations.DAORoleImpl;
import model.*;

public class  DAO {
		public static String conString = "jdbc:oracle:thin:@oradb.pi.uni.lodz.pl:1521:orcl";
		public static String userName = "javastudent";
		public static String passwd = "p@ssw0rd";
	
		//Static Constructor 
		{
			try {
	            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
	        }
	        catch (Exception ex) {   
	        	ex.printStackTrace();
	        	System.exit(1);
	        }
		}
		
		private static Connection con = null;
		public static Connection getConnection() throws SQLException{
			if (con == null) {
				con = DriverManager
			.getConnection("jdbc:oracle:thin:@oradb.pi.uni.lodz.pl:1521:orcl", "javastudent", "p@ssw0rd");
			}
			return con;
		}
		
		DAOPerson daoPerson = null;
		DAODivision daoDivision = null;
		DAORole daoRole = null;	
		
		public DAO(){
			daoPerson = new DAOPersonImpl(this);
			daoRole = new DAORoleImpl(this);
			daoDivision  = new DAODivisionImpl(this);
		}
		
		public Person getPersonByID(int id) throws SQLException {
				return daoPerson.getPersonByID(id);
		}
		public List<Person> getPersons() throws SQLException {
			return daoPerson.getPersons();
		}
		public List<Person> getPersonsInDivision(Division d) throws SQLException {
			return daoPerson.getPersonsInDivison(d);
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
		public Role getRoleByID(int id) throws SQLException {
			return daoRole.getRoleByID(id);
		}
		public List<Role> getRoles() throws SQLException {
			return daoRole.getRoles();
		}
		public boolean updateRole(Role p) {
			return daoRole.updateRole(p);
		}
		public boolean insertRole(Role p) {
			return daoRole.insertRole(p);
		}
		
}
