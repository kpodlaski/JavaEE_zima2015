package data.daos.implementations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import data.DAO;
import data.daos.DAODivision;
import data.daos.DAOPerson;
import data.daos.DAORole;
import model.*;

public class  DAOImpl implements DAO {
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
		public DAORole daoRole = null;	
		
		public DAOImpl(){
			daoPerson = new DAOPersonImpl(this);
			daoRole = new DAORoleImpl(this);
			daoDivision  = new DAODivisionImpl(this);
		}
		
		/* (non-Javadoc)
		 * @see data.DAO#getPersonByID(int)
		 */
		@Override
		public Person getPersonByID(int id) throws SQLException {
				return daoPerson.getPersonByID(id);
		}
		/* (non-Javadoc)
		 * @see data.DAO#getPersons()
		 */
		@Override
		public List<Person> getPersons() throws SQLException {
			return daoPerson.getPersons();
		}
		/* (non-Javadoc)
		 * @see data.DAO#getPersonsInDivision(model.Division)
		 */
		@Override
		public List<Person> getPersonsInDivision(Division d) throws SQLException {
			return daoPerson.getPersonsInDivison(d);
		}
		
		/* (non-Javadoc)
		 * @see data.DAO#updatePerson(model.Person)
		 */
		@Override
		public boolean updatePerson(Person p) {
			return daoPerson.updatePerson(p);
		}
		/* (non-Javadoc)
		 * @see data.DAO#insertPerson(model.Person)
		 */
		@Override
		public boolean insertPerson(Person p) {
			return daoPerson.insertPerson(p);
		}
		/* (non-Javadoc)
		 * @see data.DAO#getDivisionByID(int)
		 */
		@Override
		public Division getDivisionByID(int id) throws SQLException {
			return daoDivision.getDivisionByID(id);
		}
		/* (non-Javadoc)
		 * @see data.DAO#getDivisions()
		 */
		@Override
		public List<Division> getDivisions() throws SQLException {
			return daoDivision.getDivisions();
		}
		/* (non-Javadoc)
		 * @see data.DAO#updateDivision(model.Division)
		 */
		@Override
		public boolean updateDivision(Division p) {
			return daoDivision.updateDivision(p);
		}
		/* (non-Javadoc)
		 * @see data.DAO#insertDivision(model.Division)
		 */
		@Override
		public boolean insertDivision(Division p) {
			return daoDivision.insertDivision(p);
		}
		/* (non-Javadoc)
		 * @see data.DAO#getRoleByID(int)
		 */
		@Override
		public Role getRoleByID(int id) throws SQLException {
			return daoRole.getRoleByID(id);
		}
		/* (non-Javadoc)
		 * @see data.DAO#getRoles()
		 */
		@Override
		public List<Role> getRoles() throws SQLException {
			return daoRole.getRoles();
		}
		/* (non-Javadoc)
		 * @see data.DAO#updateRole(model.Role)
		 */
		@Override
		public boolean updateRole(Role p) {
			return daoRole.updateRole(p);
		}
		/* (non-Javadoc)
		 * @see data.DAO#insertRole(model.Role)
		 */
		@Override
		public boolean insertRole(Role p) {
			return daoRole.insertRole(p);
		}

		/* (non-Javadoc)
		 * @see data.DAO#getPersonsInDivison(model.Division)
		 */
		@Override
		public List<Person> getPersonsInDivison(Division d) throws SQLException {
			return daoPerson.getPersonsInDivison(d);
		}
		
}
