package ams_system_package;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class LoginTeacherTest {

	@Test
	public void test() throws SQLException {
		
		Tests test = new Tests();
		test.loginTeacherTest();
		
		
	}

}
