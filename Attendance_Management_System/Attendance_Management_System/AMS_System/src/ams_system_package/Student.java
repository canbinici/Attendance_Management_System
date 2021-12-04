package ams_system_package;

public class Student {
	
	private int id;
    private String name;
    private String password;
    private String email;
    private int attendance_P;
    private int attendance_N;
    private boolean isLogged;
    private int first_midterm_grade;
    private int second_midterm_grade;
    private int final_grade;
    private boolean fee_status;
	
    
    
    
    
    
    
    
    
	public Student(int id){
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
	
	public int getAttendance_P() {
		return attendance_P;
	}

	public void setAttendance_P(int attendance_P) {
		this.attendance_P = attendance_P;
	}

	public int getAttendance_N() {
		return attendance_N;
	}

	public void setAttendance_N(int attendance_N) {
		this.attendance_N = attendance_N;
	}

	public boolean isLogged() {
		return isLogged;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}

	public int getFirst_midterm_grade() {
		return first_midterm_grade;
	}

	public void setFirst_midterm_grade(int first_midterm_grade) {
		this.first_midterm_grade = first_midterm_grade;
	}

	public int getSecond_midterm_grade() {
		return second_midterm_grade;
	}

	public void setSecond_midterm_grade(int second_midterm_grade) {
		this.second_midterm_grade = second_midterm_grade;
	}

	public int getFinal_grade() {
		return final_grade;
	}

	public void setFinal_grade(int final_grade) {
		this.final_grade = final_grade;
	}

	public boolean getFee_status() {
		return fee_status;
	}

	public void setFee_status(boolean fee_status) {
		this.fee_status = fee_status;
	}
	
	public float getAttendance_Level(int attendance){
		float attendance_level = 0;
		attendance_level = (float)attendance / (float)42 * 100;
		return attendance_level;
	}

	

}
