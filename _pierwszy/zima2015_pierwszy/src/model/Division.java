package model;

import java.util.ArrayList;
import java.util.List;

public class Division {
	
	static private int lastId =1;
	
	private int id;
	private String name;
	private Person head;
	private List<Person> members;
	private List<Division> childDivisons;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Person getHead() {
		return head;
	}
	public void setHead(Person head) {
		this.head = head;
	}
	public List<Person> getMembers() {
		return members;
	}
	public void setMembers(List<Person> members) {
		this.members = members;
	}
	public List<Division> getChildDivisons() {
		return childDivisons;
	}
	public void setChildDivisons(List<Division> childDivisons) {
		this.childDivisons = childDivisons;
	}
	
	
	public boolean addMember(Person arg0) {
		return members.add(arg0);
	}
	public boolean addChildDivision(Division arg0) {
		return childDivisons.add(arg0);
	}

	
	public Division(String name, Person head) {
		super();
		this.id = lastId++;
		this.name = name;
		this.head = head;
		this.members = new ArrayList<Person>();
		this.childDivisons = new ArrayList<Division>();
	}
	
	
	public Division(){}
	
	/*public copyData(Division source){
		
	}
	*/	
	
	
}
