package ams_system_package;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.junit.Assert.*;






/*to do tests
 * 
 * Student make a fee TEST
 * Student does not make a fee TEST
 * 
 * Student Attendance is incerased by teacher
 * Student Attendace is decreased by teacher
 * 
 * 
 * 
 */




/*
 * Super Class of testing
 */
public class Tests {
	/*
	 * Create addTeacherTest object to call its function.
	 */
	JunitTests jUnits = new JunitTests();

	public Tests() throws SQLException {

	}
	
	
	
	/*
	 * addingOfTeacher is a  Superclass' function to call addTeacher objects's test function.
	 * 
	 */
	public void addingOfTeacher() throws SQLException {
		jUnits.addTeacherandTest();
	}
	
	/*
	 * deletingOfTeacher is a  Superclass' function to call addTeacher objects's test function.
	 * 
	 */
	
	public void deletingOfTeacher() throws SQLException{
		jUnits.deleteTeacherandTest();
	}
	
	/*
	 * addingOfStudent is a  Superclass' function to call addTeacher objects's test function.
	 * 
	 */
	
	public void addingOfStudentSection1() throws SQLException{
		jUnits.addStudentandTestSection1();
	}
	public void addingOfStudentSection2() throws SQLException{
		jUnits.addStudentandTestSection2();
	}
	public void addingOfStudentSection3() throws SQLException{
		jUnits.addStudentandTestSection3();
	}
	
	/*
	 * deletingOfStudent is a  Superclass' function to call addTeacher objects's test function.
	 * 
	 */
	
	public void loginStudentTestSection1() throws SQLException{
		jUnits.loginStudentTestSection1();
	}
	public void loginStudentTestSection2() throws SQLException{
		jUnits.loginStudentTestSection2();
	}
	public void loginStudentTestSection3() throws SQLException{
		jUnits.loginStudentTestSection3();
	}
	
	
	
	public void deletingOfStudentSection1() throws SQLException{
		jUnits.deleteStudentandTestSection1();
	}
	
	
	public void deletingOfStudentSection2() throws SQLException{
		jUnits.deleteStudentandTestSection2();
	}
	
	public void deletingOfStudentSection3() throws SQLException{
		jUnits.deleteStudentandTestSection3();
	}
	
	public void loginTeacherTest() throws SQLException{
		jUnits.loginTeacherTest();
	}
	
	public void loginAdminTest() throws SQLException{
		jUnits.loginAdminTest();
	}
	
	
	public void cantLoginAdminTest() throws SQLException{
		jUnits.cantLoginAdminTest();
	}
	
	public void cantLoginTeacherTest() throws SQLException{
		jUnits.cantLoginAdminTest();
	}
	
	public void cantLoginStudentTest() throws SQLException{
		jUnits.cantLoginAdminTest();
	}
	
	public void databaseConnectionTest() {
		jUnits.databaseConnectionTest();
	}
	
	
	public void TeacherMessageTestSection1() {
		jUnits.TeacherMessageTestSection1();
		
	}
	public void TeacherMessageTestSection2() {
		jUnits.TeacherMessageTestSection2();
	}
	
	public void TeacherMessageTestSection3() {
		jUnits.TeacherMessageTestSection3();
	}
	
}



class JunitTests {
	
	
	
	public void databaseConnectionTest() {
		
		DatabaseHandler database = new DatabaseHandler();
		assertEquals(true, database.isConnected());
		
	}
	
	public void TeacherMessageTestSection1() {
		/*
		 * test if the message sended by teacher to the corresponding first Sections teacher.
		 */
		
		int sectionNum = 1;
		String message = "test";
		
		DatabaseHandler database = new DatabaseHandler();
		
    	try {
    			
    		DatabaseHandler.setMessage(message, sectionNum, 22);	
    		ArrayList<String> students = DatabaseHandler.GetAllStudentsNames(sectionNum);

    		
			for(int i = 0 ; i < students.size(); i++) {
				
				int id ;
				id = DatabaseHandler.GetIDFromName(students.get(i),sectionNum);				
				DatabaseHandler.setMessage(message, sectionNum, id);
				
			}
			
			System.out.println("Message sended to section : " + sectionNum);
			assertEquals(message, DatabaseHandler.getMessage(22, sectionNum));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public void TeacherMessageTestSection2() {
		
		/*
		 * test if the message sended by teacher to the corresponding first Sections teacher.
		 */
		
		int sectionNum = 2;
		String message = "test";
		
		DatabaseHandler database = new DatabaseHandler();
		
    	try {
    			
    		DatabaseHandler.setMessage(message, sectionNum, 27);	
    		ArrayList<String> students = DatabaseHandler.GetAllStudentsNames(sectionNum);

    		
			for(int i = 0 ; i < students.size(); i++) {
				
				int id ;
				id = DatabaseHandler.GetIDFromName(students.get(i),sectionNum);				
				DatabaseHandler.setMessage(message, sectionNum, id);
				
			}
			
			System.out.println("Message sended to section : " + sectionNum);
			assertEquals(message, DatabaseHandler.getMessage(27, sectionNum));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public void TeacherMessageTestSection3() {
	
		/*
		 * test if the message sended by teacher to the corresponding first Sections teacher.
		 */
		
		int sectionNum = 3;
		String message = "test";
		
		DatabaseHandler database = new DatabaseHandler();
		
    	try {
    			
    		DatabaseHandler.setMessage(message, sectionNum, 32);	
    		ArrayList<String> students = DatabaseHandler.GetAllStudentsNames(sectionNum);

    		
			for(int i = 0 ; i < students.size(); i++) {
				
				int id ;
				id = DatabaseHandler.GetIDFromName(students.get(i),sectionNum);				
				DatabaseHandler.setMessage(message, sectionNum, id);
				
			}
			
			System.out.println("Message sended to section : " + sectionNum);
			assertEquals(message, DatabaseHandler.getMessage(32, sectionNum));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	

	public void cantLoginStudentTest() throws SQLException{
		
		/*
		 * INVALID ID SHOULD BE CAUSING ERROR.
		 */
		
		int userID = 55523235;
		String password = "123dfdfds4";
		
		
		/*
		 * Create enumaretor to get the login status as a String.
		 */
		DatabaseHandler.LoginRespondStatus Respond;
		
		/*
		 * Assign the returned value of TryLogin method to the LoginRespondStatus object.
		 */
		Respond = DatabaseHandler.TryLogin(userID, password , "Student");
		
		/*
		 * if its success, the user is logged in.
		 */
		assertNotEquals("SUCCESS", Respond.toString());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public void cantLoginTeacherTest() throws SQLException{
		
		/*
		 * INVALID ID SHOULD BE CAUSING ERROR.
		 */
		
		int userID = 55523235;
		String password = "123dfdfds4";
		
		
		/*
		 * Create enumaretor to get the login status as a String.
		 */
		DatabaseHandler.LoginRespondStatus Respond;
		
		/*
		 * Assign the returned value of TryLogin method to the LoginRespondStatus object.
		 */
		Respond = DatabaseHandler.TryLogin(userID, password , "Teacher");
		
		/*
		 * if its success, the user is logged in.
		 */
		assertNotEquals("SUCCESS", Respond.toString());
	}
	
	
	
	
	
	
	
	
	
	
	

	public void cantLoginAdminTest() throws SQLException{
		
		/*
		 * INVALID ID SHOULD BE CAUSING ERROR.
		 */
		
		int userID = 55523235;
		String password = "123dfdfds4";
		
		
		/*
		 * Create enumaretor to get the login status as a String.
		 */
		DatabaseHandler.LoginRespondStatus Respond;
		
		/*
		 * Assign the returned value of TryLogin method to the LoginRespondStatus object.
		 */
		Respond = DatabaseHandler.TryLogin(userID, password , "Admin");
		
		/*
		 * if its success, the user is logged in.
		 */
		assertNotEquals("SUCCESS", Respond.toString());
	}
	
	
	

	public void loginAdminTest() throws SQLException{
		int userID = 1;
		String password = "1234";
		
		
		/*
		 * Create enumaretor to get the login status as a String.
		 */
		DatabaseHandler.LoginRespondStatus Respond;
		
		/*
		 * Assign the returned value of TryLogin method to the LoginRespondStatus object.
		 */
		Respond = DatabaseHandler.TryLogin(userID, password , "Admin");
		
		/*
		 * if its success, the user is logged in.
		 */
		assertEquals("SUCCESS", Respond.toString());
	}
	
	
	
	
	
	
	
	

	public void loginTeacherTest() throws SQLException{
		int userID = 1;
		String password = "1234";
		
		
		/*
		 * Create enumaretor to get the login status as a String.
		 */
		DatabaseHandler.LoginRespondStatus Respond;
		
		/*
		 * Assign the returned value of TryLogin method to the LoginRespondStatus object.
		 */
		Respond = DatabaseHandler.TryLogin(userID, password , "Teacher");
		
		/*
		 * if its success, the user is logged in.
		 */
		assertEquals("SUCCESS", Respond.toString());
	}
	
	

	
	
	
	
/*
 * Test for checking the 
 * DatabaseHandler.AddTacher(id,name,surname,password)
 * working or not.
 * 
 * It calculates current, and then add it , stores two of them, and notify if the second current minus first is 1.
 */
	public void addTeacherandTest() throws SQLException {
		int currentCountOfTeachers = DatabaseHandler.getAllTeacherNames().size();
		DatabaseHandler.AddTeacher(3, "test", "test", 1234);
		int afterAdding = DatabaseHandler.getAllTeacherNames().size();
		assertEquals(currentCountOfTeachers+1 , afterAdding);
	}
	
	
	/*
	 * Test for checking the 
	 * DatabaseHandler.DeleteTeacher(index)
	 * working or not.
	 * 
	 */
	
	public void deleteTeacherandTest() throws SQLException {
		int currentCountOfTeachers = DatabaseHandler.getAllTeacherNames().size();
		DatabaseHandler.DeleteTeacher(3);
		
		int afterDeleting = DatabaseHandler.getAllTeacherNames().size();
		assertEquals(currentCountOfTeachers-1 , afterDeleting);
	}
	
	
	
	
	
	
	

	public void loginStudentTestSection1() throws SQLException{
		int userID = 22;
		String password = "1234";

		int sectionNum = 1;
		
		/*
		 * Create enumaretor to get the login status as a String.
		 */
		DatabaseHandler.LoginRespondStatus Respond;
		
		/*
		 * Assign the returned value of TryLogin method to the LoginRespondStatus object.
		 */
		Respond = DatabaseHandler.TryLogin(userID, password , "Student",sectionNum);
		
		/*
		 * if its success, the user is logged in.
		 */
		assertEquals("SUCCESS", Respond.toString());
	}
	
	
	

	public void loginStudentTestSection2() throws SQLException{
		int userID = 27;
		String password = "1234";

		int sectionNum = 2;
		
		/*
		 * Create enumaretor to get the login status as a String.
		 */
		DatabaseHandler.LoginRespondStatus Respond;
		
		/*
		 * Assign the returned value of TryLogin method to the LoginRespondStatus object.
		 */
		Respond = DatabaseHandler.TryLogin(userID, password , "Student",sectionNum);
		
		/*
		 * if its success, the user is logged in.
		 */
		assertEquals("SUCCESS", Respond.toString());
	}
	
	
	

	public void loginStudentTestSection3() throws SQLException{
		int userID = 32;
		String password = "1234";

		int sectionNum = 3;
		
		/*
		 * Create enumaretor to get the login status as a String.
		 */
		DatabaseHandler.LoginRespondStatus Respond;
		
		/*
		 * Assign the returned value of TryLogin method to the LoginRespondStatus object.
		 */
		Respond = DatabaseHandler.TryLogin(userID, password , "Student",sectionNum);
		
		/*
		 * if its success, the user is logged in.
		 */
		assertEquals("SUCCESS", Respond.toString());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * Test for checking the 
	 * DatabaseHandler.AddStudent(index, "name", password , "email ");
	 * working or not.
	 * 
	 */
	
	
	
	
	
	/*
	 * write test for each section
	 */
	
	public void addStudentandTestSection1() throws SQLException{
		
		int sectionNum = 1;
		int current = DatabaseHandler.GetAllStudentsNames(sectionNum).size();
		DatabaseHandler.AddStudent(112, "test", 1234, "test",sectionNum);
		int afterAdd = DatabaseHandler.GetAllStudentsNames(sectionNum).size();
		assertEquals(current+1, afterAdd);
		
		
	}

	public void addStudentandTestSection2() throws SQLException{
		
		int sectionNum = 2;
		int current = DatabaseHandler.GetAllStudentsNames(sectionNum).size();
		DatabaseHandler.AddStudent(112, "test", 1234, "test",sectionNum);
		int afterAdd = DatabaseHandler.GetAllStudentsNames(sectionNum).size();
		assertEquals(current+1, afterAdd);
	
	}
	
	
	public void addStudentandTestSection3() throws SQLException{
		
		int sectionNum = 3;
		int current = DatabaseHandler.GetAllStudentsNames(sectionNum).size();
		DatabaseHandler.AddStudent(112, "test", 1234, "test",sectionNum);
		int afterAdd = DatabaseHandler.GetAllStudentsNames(sectionNum).size();
		assertEquals(current+1, afterAdd);
		
		
	}
	
	
	
	/*
	 * Test for checking the 
	 * DatabaseHandler.DeleteStudent(id);
	 * working or not.
	 * 
	 */
	
	
	public void deleteStudentandTestSection1() throws SQLException {
		int sectionNum = 1 ;
		
		
		int currentCountOfStudents = DatabaseHandler.GetAllStudentsNames(sectionNum).size();
		DatabaseHandler.DeleteStudent(112,sectionNum);
		
		int afterDeleting = DatabaseHandler.GetAllStudentsNames(sectionNum).size();
		assertEquals(currentCountOfStudents-1 , afterDeleting);
	}
	
	
	public void deleteStudentandTestSection2() throws SQLException {
		int sectionNum = 2 ;
		
		
		int currentCountOfStudents = DatabaseHandler.GetAllStudentsNames(sectionNum).size();
		
		System.out.println("deleteStudentandTestSection2 current student number " + currentCountOfStudents);
		
		
		DatabaseHandler.DeleteStudent(112,sectionNum);
		
		
		
		int afterDeleting = DatabaseHandler.GetAllStudentsNames(sectionNum).size();

		System.out.println("deleteStudentandTestSection2 after delete student number " + afterDeleting);
		assertEquals(currentCountOfStudents-1 , afterDeleting);
		
		
		
	}
	
	
	public void deleteStudentandTestSection3() throws SQLException {
		
		
		int sectionNum = 3 ;
		int currentCountOfStudents = DatabaseHandler.GetAllStudentsNames(sectionNum).size();
		DatabaseHandler.DeleteStudent(112,sectionNum);
		int afterDeleting = DatabaseHandler.GetAllStudentsNames(sectionNum).size();
		assertEquals(currentCountOfStudents-1 , afterDeleting);
		
		
	}
	
	
	
	/*
	 * Add deleteStudent test for each
	 */
	
	
	
	
	
	
	
}

