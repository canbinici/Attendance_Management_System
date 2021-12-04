package ams_system_package;
import java.sql.*;
import java.util.Calendar;
import java.io.*;

public class AMSSystem {

	
	

	public static void main(String [] args) throws SQLException, IOException{
		
		
		
		

		//  Course(String name, int id)
		//create a course.
		Course systemProgramming = new Course("System Programming", 1);
		
		
		//Section(String name, int courseID, int sectionNum, int teacherID, int sectionHour , int sectionDay)
		//create a section of the SP course.
		//assign its teacher, and time
		Section SPsection1 = new Section("SP Section 1", 1, 1, 0,9,2);
		Section SPsection2 = new Section("SP Section 2", 1, 2, 0,14,2);

		Section SPsection3 = new Section("SP Section 3", 1, 3, 5,9,3);
		Section SPsection4 = new Section("SP Section 4", 1, 4, 5,13,3);
		
		
		SPsection1.getStudentCount();
		
		
		Course SoftwareVerificationandValidation = new Course("Software Verification and Validation", 2);
		
		Section SVVsection1 = new Section("SVV Section 1", 2, 1, 4,9,4);
		Section SVVsection2 = new Section("SVV Section 2", 2, 2, 4,14,4);

		Section SVVsection3 = new Section("SVV Section 3", 2, 3, 1,9,5);
		Section SVVsection4 = new Section("SVV Section 4", 2, 4, 1,13,5);
		
		
		
		
		
		
		
		
		
		
		
		//AMSSystem Class initializes the Attendance Management System, creates a SystemHandler object to start the system.


		System.out.println(Calendar.getInstance().get(Calendar.HOUR_OF_DAY) +""+ Calendar.getInstance().get(Calendar.MINUTE));
		
		
		//System.out.println(Calendar.getInstance().get(Calendar.DAY_OF_WEEK));
		
		systemProgramming.addSection(SPsection1);
		systemProgramming.addSection(SPsection2);
		systemProgramming.addSection(SPsection3);
		systemProgramming.addSection(SPsection4);
		
		
		SoftwareVerificationandValidation.addSection(SVVsection1);
		SoftwareVerificationandValidation.addSection(SVVsection2);
		SoftwareVerificationandValidation.addSection(SVVsection3);
		SoftwareVerificationandValidation.addSection(SVVsection4);
		
		
		
		
		SystemHandler systemhandler = new SystemHandler();
	}


	
	
}
