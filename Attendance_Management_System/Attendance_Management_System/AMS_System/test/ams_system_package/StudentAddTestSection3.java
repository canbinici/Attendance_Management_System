package ams_system_package;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class StudentAddTestSection3 {

	@Test
	public void test() throws SQLException {
		/*
		 * Create Database instance for access the stored database, and make required connections before testing.
		 */
		
		DatabaseHandler database = new DatabaseHandler();
		
		/*
		 * Create test object, it will have all tests inside, and they will call from here.
		 */
		
		Tests test = new Tests();
		
		/*
		 *  it calculates the current teacher count and increment it one ,
		 *  and add the new teacher object
		 *  and calculate new current
		 * if they are equal, the test is passed.
		 */
		test.addingOfStudentSection3();
	}

}
