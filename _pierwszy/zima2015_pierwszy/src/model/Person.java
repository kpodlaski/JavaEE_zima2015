package model;

public class Person {
	static private int lastId =1;
	private String name;
	private String surname;
	private String photo;
	private int id;
	private Role role;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Person(String name, String surname, String photo,  Role role) {
		super();
		this.name = name;
		this.surname = surname;
		this.photo = photo;
		this.id = lastId++;
		this.role = role;
	}
	
	
}
