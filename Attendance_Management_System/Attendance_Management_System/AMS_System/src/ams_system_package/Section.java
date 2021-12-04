package ams_system_package;
import java.util.ArrayList;
import java.util.Calendar;

public class Section {

	
	protected ArrayList<Student> _studentList; //List of the students that take the section.
	protected String _sectionName; // name of the section
	protected int _sectionID; //id of the section
	protected int _teacherID; // the teacher of the course.
	protected int _courseID; //the id of the course that the sections belongs to
	
	//Section hours are based on the this code output.
	// Calendar.getInstance().get(Calendar.HOUR) + Calendar.getInstance().get(Calendar.MINUTE) 
	protected int _sectionHour;
	
	//Section day depends of the day number in a week. it starts from 1(Sunday)  to 7(Saturday)
	// It can be gathered by this code 
	// Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
	protected int _sectionDay;
	
	
	public Section(String name ,int courseID, int sectionNum , int teacherID, int sectionHour , int sectionDay) {
		_sectionName = name;
		_sectionID = sectionNum;
		_teacherID = teacherID;
		_courseID = courseID;
		
		_sectionHour = sectionHour;
		_sectionDay = sectionDay;
		
		_studentList = new ArrayList<Student>();
	}
	
	public void addStudent(Student student) {
		_studentList.add(student);
	}
	
	
	public int getStudentCount() {
		return _studentList.size();
	}
	
	public ArrayList<Student> getStudents(){
		return _studentList;
	}
	
	
}
