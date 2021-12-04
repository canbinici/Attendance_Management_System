package ams_system_package;
import java.awt.Cursor;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class DatabaseHandler {
	
	Boolean isConnected = false;
	
	//DatabaseHandler class starts the communication between system and database.
	
	static Connection con;
	public DatabaseHandler(){
		try{
			
			
			
			//WÝLL BE CHANGED FOR DATABASE 
			
			con = DriverManager.getConnection("jdbc:sqlite:C:/sqlite/AMS.db");
			
			
			
			System.out.println("Connection is successful !");
			isConnected = true;
			
			
			ClearLoggedIn();   //Every beginning of the system, it converts isLogged to 0 in the database.
			
		}catch(SQLException e){
			
			e.printStackTrace();
			
		}
	}
	
	
	
	//POLYMORFÝC METHOD FOR CALLÝNG FROM NON-STUDENTS WÝTHOUT SECTÝON NUMBER.
	
	public static LoginRespondStatus TryLogin(int id, String password,String userType) throws SQLException{
		LoginRespondStatus status = null;
			
		Statement st = con.createStatement();
		int rowCount = 0;
			
		//DATABASEDE ARATMA YAPMAK ÝÇÝN
		String tmpUserType = null;
		
		
		switch(userType) {
		case "Teacher":
			tmpUserType = "teachers";
			break;
		
		case "Admin":
			tmpUserType = "admins";
			break;
		
		
		}
		
		
		String Query = "SELECT * FROM " + tmpUserType +  " WHERE `id` = '" + id + "'";
		
		ResultSet ResultQuerySet = st.executeQuery(Query);
			
		// out variables
		String userFromDB = null;
		String passFromDB = null;
			
		// set is logged or not
		boolean isLogged = false;
			
		while(ResultQuerySet.next()){
			
	        userFromDB = ResultQuerySet.getString("name");
	        passFromDB = ResultQuerySet.getString("password");
	        isLogged = ResultQuerySet.getBoolean("isLogged");
	        ++rowCount;
		
		}
		if(rowCount >= 1){
			
			if(isLogged == true) return LoginRespondStatus.USER_ALREADY_LOGGED;
		    if(passFromDB.equals(password)) return LoginRespondStatus.SUCCESS;
			if(!passFromDB.equals(password)) return LoginRespondStatus.INVALID_PASSWORD;
		
		}
		else {
			return LoginRespondStatus.INVALID_USERNAME;
		}
		ResultQuerySet.close();
		st.close();
		return status;
	}	
	
	
	
	public static LoginRespondStatus TryLogin(int id, String password,String userType,int sectionNum) throws SQLException{
		LoginRespondStatus status = null;
			
		Statement st = con.createStatement();
		int rowCount = 0;
			
		//DATABASEDE ARATMA YAPMAK ÝÇÝN
		String tmpUserType = null;
		
		
		switch(userType) {
		case "Student":

			switch(sectionNum) {
			case 1:
				tmpUserType = "users";
				break;
			case 2:
				tmpUserType = "users1";
				break;
				
			case 3:
				tmpUserType = "users3";
				break;
			}
			break;
			

			
			
		case "Teacher":
			tmpUserType = "teachers";
			break;
		
		case "Admin":
			tmpUserType = "admins";
			break;
		
		
		}
		
		
		String Query = "SELECT * FROM " + tmpUserType +  " WHERE `id` = '" + id + "'";
		
		ResultSet ResultQuerySet = st.executeQuery(Query);
			
		// out variables
		String userFromDB = null;
		String passFromDB = null;
			
		// set is logged or not
		boolean isLogged = false;
			
		while(ResultQuerySet.next()){
			
	        userFromDB = ResultQuerySet.getString("name");
	        passFromDB = ResultQuerySet.getString("password");
	        isLogged = ResultQuerySet.getBoolean("isLogged");
	        ++rowCount;
		
		}
		if(rowCount >= 1){
			
			if(isLogged == true) return LoginRespondStatus.USER_ALREADY_LOGGED;
		    if(passFromDB.equals(password)) return LoginRespondStatus.SUCCESS;
			if(!passFromDB.equals(password)) return LoginRespondStatus.INVALID_PASSWORD;
		
		}
		else {
			return LoginRespondStatus.INVALID_USERNAME;
		}
		ResultQuerySet.close();
		st.close();
		return status;
	}	
	
	//when login is success, sets the isLogged to 1.
	public void LoginOnDatabase(int id,String userType,int sectionNum) throws SQLException{
		Statement stmt = con.createStatement();
		
		String tmpUserType = null;
		
		
		switch(userType) {
		
		case "Student":
			switch(sectionNum) {
			
			case 1:
				tmpUserType = "users";
				break;
			case 2:
				tmpUserType = "users1";
				break;
				
			case 3:
				tmpUserType = "users3";
				break;
			}
			break;

		case "Teacher":
			tmpUserType = "teachers";
			break;
		
		case "Admin":
			tmpUserType = "admins";
			break;
		
		
		}
		
		
		
		
		
		
		
		
        String LoginQuery = "UPDATE `"+tmpUserType+"` SET `isLogged` = '1' WHERE `id` ='" + id + "'";
        stmt.executeUpdate(LoginQuery);
	}
	
	
	
	public static void ClearLoggedIn() throws SQLException{
		Statement stmt = con.createStatement();
        String ClearQuery = "UPDATE `users` SET `isLogged` = '0'";
        stmt.executeUpdate(ClearQuery);
        
        
	}
	
	
	
	
	public static boolean IsUserIdExists(int id,String userType,int sectionNum) throws SQLException{
		// New statement for query
		Statement st = con.createStatement();
		
		// Query that selects the passed "Id" from method
		
		String tmpUserType = null;
		switch(userType) {
		
		
		case "Student":
			

			switch(sectionNum) {
			
			case 1:
				tmpUserType = "users";
				break;
			case 2:
				tmpUserType = "users1";
				break;
				
			case 3:
				tmpUserType = "users3";
				break;
			}
			break;
			
			
		case "Teacher":
			tmpUserType = "teachers";
			break;
		
		default:
			System.out.println("enter valid user type error.");
			
		}
		
		
		String DesiredQuery = "SELECT id FROM "+  tmpUserType  +" WHERE `id` = '" + id + "'";
		ResultSet QuerySet = st.executeQuery(DesiredQuery);
		
		while(QuerySet.next()){
			
            String Id = QuerySet.getString("id");
            System.out.println("ID " + Id + " found in database.");
            return true;
		
		}
		return false;
	}
	
	
	public static String GetUserTypeFromID(int id) throws SQLException{
		Statement st = con.createStatement();
		String UserType = null;
		String Query = "SELECT userType FROM `users` WHERE `id` = '" + id + "'";
		ResultSet ResultQuerySet = st.executeQuery(Query);
		
		while(ResultQuerySet.next()){
			
	        UserType = ResultQuerySet.getString("userType");
		
		}
        return UserType;
	}
	
	public static String GetNameFromID(int id, String userType,int sectionNum) throws SQLException{

		Statement st = con.createStatement();
		String Name = null;
		
		String tempType = null;
		
		switch(userType) {
		case "Teacher":
			tempType = "teachers";
			break;
		case "Student":

			switch(sectionNum) {
			
			case 1:
				tempType = "users";
				break;
			case 2:
				tempType = "users1";
				break;
				
			case 3:
				tempType = "users3";
				break;
			}
			break;
			
		case "Admin":
			tempType = "admins";
			break;
		
		}
		
		
		
		String Query = "SELECT name FROM "+ tempType +" WHERE `id` = '" + id + "'";
		ResultSet ResultQuerySet = st.executeQuery(Query);
		
		while(ResultQuerySet.next()){
			
	        Name = ResultQuerySet.getString("name");
		
		}
        return Name;
	}
	
	
	
	public static int GetIDFromName(String name,int sectionNum) throws SQLException{
		
		
		
		String tempType = "";
		switch(sectionNum) {
		
		case 1:
			tempType = "users";
			break;
		case 2:
			tempType = "users1";
			break;
			
		case 3:
			tempType = "users3";
			break;
		
		}
		
		Statement st = con.createStatement();
		int ID = 0;
		String Query = "SELECT id FROM `"+tempType+"` WHERE `name` = '" + name + "'";
		ResultSet ResultQuerySet = st.executeQuery(Query);
		
		while(ResultQuerySet.next()){
			
	        ID = ResultQuerySet.getInt("id");
		
		}
        return ID;
	}
	
	public static String GetPasswordFromID(int id) throws SQLException{
		Statement st = con.createStatement();
		String Password = null;
		String Query = "SELECT password FROM `users` WHERE `id` = '" + id + "'";
		ResultSet ResultQuerySet = st.executeQuery(Query);
		
		while(ResultQuerySet.next())
		{
	        Password = ResultQuerySet.getString("password");
		}
        return Password;
	}
	
	//returns positive attendance number of students.
	public static int GetAttendanceP(int id,int sectionNum) throws SQLException{
		
		
		
		String tempType = "";
		switch(sectionNum) {
		
		case 1:
			tempType = "users";
			break;
		case 2:
			tempType = "users1";
			break;
			
		case 3:
			tempType = "users3";
			break;
		}
		
		
		
		
		
		Statement st = con.createStatement();
		int Attendance = 0;
		String Query = "SELECT attendance_P FROM `"+tempType+"` WHERE `id` = '" + id + "'";
		ResultSet ResultQuerySet = st.executeQuery(Query);
		
		while(ResultQuerySet.next())
		{
	        Attendance = ResultQuerySet.getInt("attendance_P");
		}
        return Attendance;
	}
	
	//returns negative attendance number of students.
	public static int GetAttendanceN(int id,int sectionNum) throws SQLException{
		
		
		String tempType = "";
		switch(sectionNum) {
		
		case 1:
			tempType = "users";
			break;
		case 2:
			tempType = "users1";
			break;
			
		case 3:
			tempType = "users3";
			break;
		}
		
		
		
		Statement st = con.createStatement();
		int Attendance = 0;
		String Query = "SELECT attendance_N FROM `"+tempType+"` WHERE `id` = '" + id + "'";
		ResultSet ResultQuerySet = st.executeQuery(Query);
		
		while(ResultQuerySet.next())
		{
	        Attendance = ResultQuerySet.getInt("attendance_N");
		}
        return Attendance;
	}
	
	//sets positive attendance number plus 1 (+1).
	public static void SetAttendance_P(int id,int sectionNum) throws SQLException{
		
		String tempType = "";
		switch(sectionNum) {
		
		case 1:
			tempType = "users";
			break;
		case 2:
			tempType = "users1";
			break;
			
		case 3:
			tempType = "users3";
			break;
		}
		
		
		
		Statement stmt = con.createStatement();
        String SetQueryP= "UPDATE `users` SET `attendance_P` = '"+ (GetAttendanceP(id,sectionNum)+1) +"' WHERE `id` = '" + id + "'";
        stmt.executeUpdate(SetQueryP);
	}
	
	//sets negative attendance number minus 1 (-1).
	public static void SetAttendance_N(int id,int sectionNum) throws SQLException{
		
		String tempType = "";
		switch(sectionNum) {
		
		case 1:
			tempType = "users";
			break;
		case 2:
			tempType = "users1";
			break;
			
		case 3:
			tempType = "users3";
			break;
		}
		
		
		
		Statement stmt = con.createStatement();
        String SetQueryN= "UPDATE `users` SET `attendance_N` = '"+ (GetAttendanceN(id,sectionNum)+1) +"' WHERE `id` = '" + id + "'";
        stmt.executeUpdate(SetQueryN);
	}
	
	public static boolean GetFeeStatus(int id,int sectionNum) throws SQLException{
		
		
		
		String tempType = "";
		switch(sectionNum) {
		
		case 1:
			tempType = "users";
			break;
		case 2:
			tempType = "users1";
			break;
			
		case 3:
			tempType = "users3";
			break;
		
		}
		
		
		
		
		
		Statement st = con.createStatement();
		boolean fee_status=false;
		String Query = "SELECT fee FROM `"+tempType+"` WHERE `id` = '" + id + "'";
		ResultSet ResultQuerySet = st.executeQuery(Query);
		
		while(ResultQuerySet.next())
		{
	        fee_status = ResultQuerySet.getBoolean("fee");
		}
        return fee_status;
	}
	
	public static void SetFeeStatus(int id,int sectionNum) throws SQLException{
		
		
		String tempType = "";
		switch(sectionNum) {
		
		case 1:
			tempType = "users";
			break;
		case 2:
			tempType = "users1";
			break;
			
		case 3:
			tempType = "users3";
			break;
		}
		
		
		
		Statement stmt = con.createStatement();
        String SetQueryP= "UPDATE `"+tempType+"` SET `fee` = '1' WHERE `id` = '" + id + "'";
        stmt.executeUpdate(SetQueryP);
	}
	
	public static int GetFirstMidtermGradeFromID(int id,int sectionNum) throws SQLException{
		
		
		String tempType = "";
		switch(sectionNum) {
		
		case 1:
			tempType = "users";
			break;
		case 2:
			tempType = "users1";
			break;
			
		case 3:
			tempType = "users3";
			break;
		}
		
		
		
		Statement st = con.createStatement();
		int F_GRADE = 0;
		String Query = "SELECT fm_grade FROM `"+tempType+"` WHERE `id` = '" + id + "'";
		ResultSet ResultQuerySet = st.executeQuery(Query);
		
		while(ResultQuerySet.next()){
			
	        F_GRADE = ResultQuerySet.getInt("fm_grade");
		
		}
        return F_GRADE;
	}
	
	
	public static int GetSecondMidtermGradeFromID(int id,int sectionNum) throws SQLException{
		
		
		
		String tempType = "";
		switch(sectionNum) {
		
		case 1:
			tempType = "users";
			break;
		case 2:
			tempType = "users1";
			break;
			
		case 3:
			tempType = "users3";
			break;
		}
		
		
		
		Statement st = con.createStatement();
		int S_GRADE = 0;
		String Query = "SELECT sm_grade FROM `"+tempType+"` WHERE `id` = '" + id + "'";
		ResultSet ResultQuerySet = st.executeQuery(Query);
		
		while(ResultQuerySet.next()){
			
	        S_GRADE = ResultQuerySet.getInt("sm_grade");
		
		}
        return S_GRADE;
	}	
	
	public static int GetFinalGradeFromID(int id, int sectionNum) throws SQLException{
		
		
		String tempType = "";
		switch(sectionNum) {
		
		case 1:
			tempType = "users";
			break;
		case 2:
			tempType = "users1";
			break;
			
		case 3:
			tempType = "users3";
			break;
		}
		
		
		
		
		
		
		
		Statement st = con.createStatement();
		int FÝNAL_GRADE = 0;
		String Query = "SELECT final_grade FROM `"+tempType+"` WHERE `id` = '" + id + "'";
		ResultSet ResultQuerySet = st.executeQuery(Query);
		
		while(ResultQuerySet.next()){
			
	        FÝNAL_GRADE = ResultQuerySet.getInt("final_grade");
		
		}
        return FÝNAL_GRADE;
	}
	
	// Enum to handle respond of logining status.
	public enum LoginRespondStatus{
		SUCCESS,
		INVALID_PASSWORD,
		USER_ALREADY_LOGGED,
		INVALID_USERNAME
	}
	// Tries to login on system.
	
	
	public static ArrayList<String> GetAllStudentsNames(int sectionNum) throws SQLException
	
	{
		
		String section = "";
		switch(sectionNum) {
		
		
		case 1:
			section = "users";
			break;
		case 2:
			section = "users1";
			break;
			
		case 3:
			section = "users3";
			break;

		}
		
		
		
		
		Statement st = con.createStatement();
		ArrayList<String> students_names = new ArrayList<>();
		String student_name = null;
		String Query = "SELECT name FROM '" + section + "'" ;
		ResultSet ResultQuerySet = st.executeQuery(Query);
		
		
		
		
		while(ResultQuerySet.next())
		{
	        student_name = ResultQuerySet.getString("name");
	        students_names.add(student_name);
		}
        return students_names;
	}
	
	
	
	public static ArrayList<String> GetAllNAStudentsNames(int sectionNum) throws SQLException{
		
		
		String section = "";
		switch(sectionNum) {
		
		
		case 1:
			section = "users";
			break;
		case 2:
			section = "users1";
			break;
			
		case 3:
			section = "users3";
			break;

		}
		
		
		Statement st = con.createStatement();
		ArrayList<String> students_names = new ArrayList<>();
		String student_name = null;
		int NA_border = 14;
		String Query = "SELECT name FROM '"+ section + "'  WHERE `attendance_N` > '" + NA_border + "'";
		ResultSet ResultQuerySet = st.executeQuery(Query);
		
		while(ResultQuerySet.next())
		{
	        student_name = ResultQuerySet.getString("name");
	        students_names.add(student_name);
		}
        return students_names;
	}
	public static ArrayList<String> GetAllStudentsNOTPaidFees(int sectionNum) throws SQLException{
		
		String section = "";
		switch(sectionNum) {
		
		
		case 1:
			section = "users";
			break;
		case 2:
			section = "users1";
			break;
			
		case 3:
			section = "users3";
			break;

		}
		
		Statement st = con.createStatement();
		ArrayList<String> students_names = new ArrayList<>();
		String student_name = null;
		String Query = "SELECT name FROM `"+ section + "` WHERE `fee` ='0'";
		ResultSet ResultQuerySet = st.executeQuery(Query);
		
		while(ResultQuerySet.next())
		{
	        student_name = ResultQuerySet.getString("name");
	        students_names.add(student_name);
		}
        return students_names;
	}
	
	public static void DeleteStudent(int id, int sectionNum) throws SQLException{
		
		String section = "";
		switch(sectionNum) {
		
		
		case 1:
			section = "users";
			break;
		case 2:
			section = "users1";
			break;
			
		case 3:
			section = "users3";
			break;

		}
		
		
		Statement stmt = con.createStatement();
        String ClearQuery = "DELETE FROM `"+section+"` WHERE `id` ='" + id + "'";
        stmt.executeUpdate(ClearQuery);
        
        
	}
	
	
	
	public static ArrayList<String> getAllTeacherNames() throws SQLException{
		
		Statement st = con.createStatement();
		ArrayList<String> teacher_names = new ArrayList<>();
		String teacherName = null;
		String Query = "SELECT name FROM `teachers`";
		ResultSet ResultQuerySet = st.executeQuery(Query);
		
		while(ResultQuerySet.next())
		{
	        teacherName = ResultQuerySet.getString("name");
	        teacher_names.add(teacherName);
		}
        return teacher_names;
		
	
	}
	
	
	/*
	 * AddStudent
	 * 
	 * gets required values from AdminPanel userInterface and adds the student to the database.
	 * 
	 * returns the number updated of updated columns.
	 * 
	 * */
	
	
	public static int AddStudent(int id , String name, int password , String email,int sectionNum) throws SQLException {
		
		String section = "";
		switch(sectionNum) {
		
		
		case 1:
			section = "users";
			break;
		case 2:
			section = "users1";
			break;
			
		case 3:
			section = "users3";
			break;

		}
		
		
		
		int attandance_p = 0 ;
		int attandance_n = 0 ;
		int islogged = 0;
		int fee = 0;
		int fm_grade = 0;
		int sm_grade = 0;
		int final_grade = 0;
		
		

		 int numRowsInserted = 0;
		
		if(DatabaseHandler.IsUserIdExists(id, "Student",sectionNum)) {
			System.out.println("Student Id already exists on database, please enter new one.");
			
			return numRowsInserted;
		}else {
			
			String query = "INSERT INTO `"+section+"` (id,name,password,email,attendance_P,attendance_N,isLogged,fee,fm_grade,sm_grade,final_grade) VALUES "
					+ "(?,?,?,?,?,?,?,?,?,?,?)";
			
			
			 
		        PreparedStatement ps = null;
		        try {
		            ps = con.prepareStatement(query);
		            
		            ps.setInt(1, id);
		            ps.setString(2, name);
		            ps.setInt(3, password);
		            ps.setString(4, email);
		            ps.setInt(5, attandance_p);
		            ps.setInt(6, attandance_n);
		            ps.setInt(7, islogged);
		            ps.setInt(8, fee);
		            ps.setInt(9, fm_grade);
		            ps.setInt(10, sm_grade);
		            ps.setInt(11, final_grade);

		            numRowsInserted = ps.executeUpdate();

		            
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }

				System.out.println("user eklendi ! ");
				
		        return numRowsInserted;
			
			
		}
		
		
		
		
		
		
		
	}

	
	public static int AddTeacher(int id , String name , String surname, int passWord) throws SQLException {
		int isLogged = 0;
		

		String query = "INSERT INTO `teachers` (id,name,surname,password,isLogged) VALUES "
				+ "(?,?,?,?,?)";
		
		 int numRowsInserted = 0;
		 	
		 
		 if(DatabaseHandler.IsUserIdExists(id, "Teacher",0)) {
			 
			 System.out.println("Teacher id already exists, please enter new!");
			 return numRowsInserted;
			 
		 }else {
			 

		        PreparedStatement ps = null;
		        try {
		            ps = con.prepareStatement(query);
		            
		            ps.setInt(1, id);
		            ps.setString(2, name);
		            ps.setString(3, surname);
		            ps.setInt(4, passWord);
		            ps.setInt(5, isLogged);
		            

		            numRowsInserted = ps.executeUpdate();

		            
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }

				System.out.println("Teacher eklendi ! ");
				
				//if userid exist throw error.
				
		        return numRowsInserted;
		        
		 }
		 
		 
		 
	
	}
	
	
	public static void DeleteTeacher(int id) throws SQLException{

		
		Statement stmt = con.createStatement();
        String ClearQuery = "DELETE FROM `teachers` WHERE `id` ='" + id + "'";
        stmt.executeUpdate(ClearQuery);
	}
	
	
	
	
	
	
	
	public static String getMessage(int id,int sectionNum) throws SQLException {
		
		String tempType = "";
		switch(sectionNum) {
		
		case 1:
			tempType = "users";
			break;
		case 2:
			tempType = "users1";
			break;
			
		case 3:
			tempType = "users3";
			break;
		}

		Statement st = con.createStatement();
		String message = "";
		String Query = "SELECT message FROM `"+tempType+"` WHERE `id` = '" + id + "'";
		ResultSet ResultQuerySet = st.executeQuery(Query);
		
		while(ResultQuerySet.next()){
			
	        message = ResultQuerySet.getString("message");
		
		}
        return message;
	}
	
	
	public static void setMessage(String message,int sectionNum, int id) throws SQLException {

		String tempType = "";
		switch(sectionNum) {
		
		case 1:
			tempType = "users";
			break;
		case 2:
			tempType = "users1";
			break;
			
		case 3:
			tempType = "users3";
			break;
		}
		
		
		
		Statement stmt = con.createStatement();
        String SetQueryP= "UPDATE `"+tempType+"` SET `message` = '"+message+"' WHERE `id` = '"+id+"'";
        stmt.executeUpdate(SetQueryP);
        

		
	}



	public Boolean isConnected() {
		// TODO Auto-generated method stub
		return isConnected;
	}
	
	
	
	
	
	
	
	
	
}
