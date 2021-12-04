package ams_system_package;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/*
 * Creates a suite and make all test suits in one place.
 * 
 * All written tests will be written @suiteclasses parameter.
 * 
 * Run this code for testing.
 */


@RunWith(Suite.class)
@SuiteClasses({
	
	 TeacherDeleteTest.class, TeacherAddTest.class ,
	
	 StudentAddTestSection1.class, StudentDeleteTestSection1.class, LoginStudentTestSection1.class ,
	 
	 
	 StudentAddTestSection2.class,StudentDeleteTestSection2.class, LoginStudentTestSection2.class ,
	 
	 
	 StudentAddTestSection3.class,StudentDeleteTestSection3.class, LoginStudentTestSection3.class ,
	 
	 TeacherMessageTestSection1.class, TeacherMessageTestSection2.class, TeacherMessageTestSection3.class,
	 
	 
	 
	 
	 
	 LoginTeacherTest.class , LoginAdminTest.class,
	 
	 cantLoginAdminTest.class , cantLoginStudentTest.class , cantLoginTeacherTest.class,
	 
	 DatabaseConnectionTest.class
	 
	 
	 
	 
	
	

})
public class AllTests {

}
