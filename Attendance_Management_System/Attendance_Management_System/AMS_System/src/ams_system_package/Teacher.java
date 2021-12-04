package ams_system_package;

public class Teacher {
	
	private int id;
    private String name;
    private String password;
    
    public Teacher(int id){
    	this.id = id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
