package data;

import java.util.HashMap;
import java.util.Map;

import model.Division;
import model.Person;
import model.Role;

public class CompanyData {

	private Division mainDivision;
	private Map<Integer,Division> divisions = new HashMap<>();
	private Map<Integer,Person> members= new HashMap<>();
	
	
	public CompanyData(){
		genarateCompany();
	}
	
	public void genarateCompany(){
		Role r = new Role("President");
		Person boss = new Person("Jane","Kowalski","",r);
		members.put(boss.getId(),boss);
		Division root = new Division("My Big Company", boss);
		Role r2 = new Role("Manager");
		Person p = new Person("Tomasz","Drzazga","",r2);
		Division d = new Division("Marketing", p);
		Role r3 = new Role("Graphic Designer");
		members.put(p.getId(),p);
		p = new Person("Tamara","Kie³basa","",r3 );
		members.put(p.getId(),p);
		root.addMember(p);
		p = new Person("Olaf","Marchewka","",r3 );
		members.put(p.getId(),p);
		root.addMember(p);
		root.addChildDivision(d);
		mainDivision = root;
		divisions.put(root.getId(), root);
		divisions.put(d.getId(), d);
	}

	public Division getMainDivision() {
		return mainDivision;
	}

	public void setMainDivision(Division mainDivision) {
		this.mainDivision = mainDivision;
	}

	public Map<Integer, Division> getDivisions() {
		return divisions;
	}

	public Map<Integer, Person> getMembers() {
		return members;
	}
	
}
