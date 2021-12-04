package ams_system_package;
import java.util.ArrayList;

public class Course {

	protected int _courseID;
	protected String _courseName;
	
	
	protected ArrayList<Section> _sections;
	
	
	
	public Course(String name, int id) {
		
		_courseName = name;
		_courseID = id;
		
		_sections = new ArrayList<Section>();
		
	}
	
	public void addSection(Section section) {
		System.out.println(section.getStudentCount());
		_sections.add(section);
	}
	
	public ArrayList<Section> getSections(){
		return _sections;
	}
	
	
}
