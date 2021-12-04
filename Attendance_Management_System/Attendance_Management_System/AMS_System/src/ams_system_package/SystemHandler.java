package ams_system_package;

import java.sql.SQLException;

public class SystemHandler {
	
	private static DatabaseHandler Database;
	
	public SystemHandler(){
		//SystemHandler class initializes the database operations and user interface, creates DatabaseHandler and UserInterface objects.
		setDatabase(new DatabaseHandler());
		new UserInterface();
	}
	
	public DatabaseHandler getDatabase(){
		return Database;
	}
	public void setDatabase(DatabaseHandler database){
		Database = database;
	}
	
	/*
	public static void DoLogin(int id) throws SQLException{
		
		Database.LoginOnDatabase(id, null, id);
		
		
	}*/

}
