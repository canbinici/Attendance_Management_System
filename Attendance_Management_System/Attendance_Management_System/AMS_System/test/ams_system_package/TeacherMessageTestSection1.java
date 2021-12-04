package ams_system_package;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class TeacherMessageTestSection1 {

	@Test
	public void test() throws SQLException {
		
		DatabaseHandler database = new DatabaseHandler();
		Tests test = new Tests();
		
		test.TeacherMessageTestSection1();
		
	}

}
