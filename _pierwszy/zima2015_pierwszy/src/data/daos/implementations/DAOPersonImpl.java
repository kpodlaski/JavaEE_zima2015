package data.daos.implementations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.DAO;
import data.daos.DAOPerson;
import model.Division;
import model.Person;

public class DAOPersonImpl implements DAOPerson {

	public DAOPersonImpl(DAO dao){
		this.dao = dao;
	}
	
	private DAO dao;
	
	private Person createPersonFromResultSet(ResultSet rs) throws SQLException{
		Person p = new Person();
		p.setId(rs.getInt("id"));
		p.setName(rs.getString("Imie"));
		p.setSurname(rs.getString("Nazwisko"));
		p.setPhoto(rs.getString("Fotka"));
		p.setRole(dao.getRoleByID(rs.getInt("Stanowisko")));
		//dao.daoRole.getRoleByID(rs.getInt("Stanowisko"));
		return p;
	}
	/* (non-Javadoc)
	 * @see data.daos.DAOPerson#getPersonByID(int)
	 */
	@Override
	public Person getPersonByID(int id) throws SQLException{
		Connection con  = DAOImpl.getConnection();
		PreparedStatement pst = con.prepareStatement(
				"Select * FROM Osoba where id=?");
		pst.setInt(1, id);
		Person p = null;
		ResultSet rs = null;
		if (pst.execute() && (rs=pst.getResultSet()).next()){			
			p = createPersonFromResultSet(rs);
		}		
		//con.close();
		return p;
	}
	/* (non-Javadoc)
	 * @see data.daos.DAOPerson#getPersons()
	 */
	@Override
	public List<Person> getPersons() throws SQLException{
		Connection con  = DAOImpl.getConnection();
		PreparedStatement pst = con.prepareStatement(
				"Select * FROM Osoba");
		List<Person> persons = new ArrayList<>();
		ResultSet rs = null;
		if (pst.execute()){ 
			rs=pst.getResultSet();
			while(rs.next()){			
				Person	p = createPersonFromResultSet(rs);
				persons.add(p);
			}		
		}
		//con.close();
		return persons;
	}
	/* (non-Javadoc)
	 * @see data.daos.DAOPerson#updatePerson(model.Person)
	 */
	@Override
	public boolean updatePerson(Person p){
		return false;
	}
	/* (non-Javadoc)
	 * @see data.daos.DAOPerson#insertPerson(model.Person)
	 */
	@Override
	public boolean insertPerson(Person p){
		return false;
	}
	
	@Override
	public List<Person> getPersonsInDivison(Division d) throws SQLException {
		// TODO Auto-generated method stub
		Connection con  = DAOImpl.getConnection();
		PreparedStatement pst = con.prepareStatement(
				"Select * FROM Osoba, OS_JEDN_LNK Where id=id_osoba AND id_jedn = ?");
		
		pst.setInt(1, d.getId());
		List<Person> persons = new ArrayList<>();
		ResultSet rs = null;
		if (pst.execute()){ 
			rs=pst.getResultSet();
			while(rs.next()){						
				Person	p = createPersonFromResultSet(rs);
				persons.add(p);
			}		
		}
		//con.close();
		return persons;
	}
	
	public static void main(String ... s) throws SQLException{
		DAO dao = new DAOImpl();
		Person p = dao.getPersonByID(5);
		System.out.println(p);
		System.out.println("===================");
		System.out.println(dao.getPersons());
		Division d = new Division();
		d.setId(2);
		System.out.println("===================");
		System.out.println(dao.getPersonsInDivision(d));
		
	}
}
