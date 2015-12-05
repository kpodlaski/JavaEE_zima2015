package model;



public class Role {
	static private int lastId =1;
	private int id=-1;
	private String name;
	
	
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
	public Role(String name) {
		super();
		this.id = lastId++;
		this.name = name;
	}
	public Role() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return String.format("%s %s", id, name);
	}

	
}
