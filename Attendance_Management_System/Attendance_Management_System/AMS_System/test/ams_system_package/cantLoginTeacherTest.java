package ams_system_package;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class cantLoginTeacherTest {

	@Test
	public void test() throws SQLException {
		Tests test = new Tests();
		test.cantLoginTeacherTest();
	}

}
