package ams_system_package;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginConsole extends JFrame{
    
	//Login Console checks the user id and its password correct by checking in the database,
	//if they are correct, user will log in to the system. if they are false, the system will shows the error message.
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3099600334286666740L;
	

	
	public LoginConsole(int sectionNum) {
		
		System.out.println("Login console sectionNum" + sectionNum);
		
	    JFrame frame = new JFrame("Login Console");
	    
	    
	     JTextField userText;
         JPasswordField passwordText;
	     JButton loginButton;
	    
	     JLabel  idlabel= new JLabel("User ID: ", JLabel.RIGHT);
	     JLabel  passwordLabel = new JLabel("Password: ", JLabel.CENTER);
	     
	     
	     
	     JButton backButton;
	     backButton = new JButton("Back");
	     
	     backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new UserInterface();
				
				try {
					DatabaseHandler.ClearLoggedIn();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
	     
	     
	     
	     
	     
	     
	     
	     userText = new JTextField(6);
	     passwordText = new JPasswordField(6);    
	     loginButton = new JButton("Login");
		
		 JPanel panel = new JPanel();
		
		 panel.add(idlabel);
	     panel.add(userText);
	     panel.add(passwordLabel);       
	     panel.add(passwordText);
	     panel.add(loginButton);
	     
	     
	     panel.add(backButton);
	    
	    
	    loginButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{
					String x = userText.getText();
					int id = Integer.parseInt(x);
					
					String password = new String(passwordText.getPassword());
					DatabaseHandler.LoginRespondStatus Respond;
					
					//if(UserInterface.userType == DatabaseHandler.getUserTypeFromID(id){
					try {
						Respond = DatabaseHandler.TryLogin(id, password , UserInterface.userType,  sectionNum);

						if(Respond.toString().equals("SUCCESS")){
							
							
							//SystemHandler.DoLogin(id);
							switch(UserInterface.userType){
							case "Student":
								new StudentConsole(new Student(id) , sectionNum);
								frame.dispose();
							break;
						    case "Teacher":
						    	new sectionselection(new Teacher(id));
						    	frame.dispose();
							break;
						    case "Admin":	
								new AdminConsole();
								break;
						   }
						}
						else{
							JOptionPane.showMessageDialog(frame, Respond);
						}
					} catch (SQLException e) {
				    	e.printStackTrace();
				    }
					//else{
					//JOptionPane.showMessageDialog("User Type is not matched", Respond);
					//}
				}		      
		 });
	     
	    frame.setSize(800,500);      
	    frame.setLocationRelativeTo(null);  
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setResizable(false);
	    
	    frame.getContentPane().add(panel, BorderLayout.CENTER);
	 
		
		
	}
	
	
	public LoginConsole() {
		 
		
	    JFrame frame = new JFrame("Login Console");
	    
	    
	     JTextField userText;
         JPasswordField passwordText;
	     JButton loginButton;
	    
	     JLabel  idlabel= new JLabel("User ID: ", JLabel.RIGHT);
	     JLabel  passwordLabel = new JLabel("Password: ", JLabel.CENTER);
	     
	     
	     
	     JButton backButton;
	     backButton = new JButton("Back");
	     
	     backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new UserInterface();
				
				try {
					DatabaseHandler.ClearLoggedIn();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
	     
	     
	     
	     
	     
	     
	     userText = new JTextField(6);
	     passwordText = new JPasswordField(6);    
	     loginButton = new JButton("Login");
		
		 JPanel panel = new JPanel();
		
		 panel.add(idlabel);
	     panel.add(userText);
	     panel.add(passwordLabel);       
	     panel.add(passwordText);
	     panel.add(loginButton);
	     
	     
	     panel.add(backButton);
	    
	    
	    loginButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{
					String x = userText.getText();
					int id = Integer.parseInt(x);
					
					String password = new String(passwordText.getPassword());
					DatabaseHandler.LoginRespondStatus Respond;
					
					//if(UserInterface.userType == DatabaseHandler.getUserTypeFromID(id){
					try {
						
						Respond = DatabaseHandler.TryLogin(id, password , UserInterface.userType);

						if(Respond.toString().equals("SUCCESS")){
							
							
							//SystemHandler.DoLogin(id);
							switch(UserInterface.userType){
							/*case "Student":
								new StudentConsole(new Student(id),sectionNum);
								frame.dispose();
							break;*/
						    case "Teacher":
						    	new sectionselection(new Teacher(id));
						    	frame.dispose();
							break;
						    case "Admin":	
								new AdminConsole();
								frame.dispose();
								break;
						   }
						}
						else{
							JOptionPane.showMessageDialog(frame, Respond);
						}
					} catch (SQLException e) {
				    	e.printStackTrace();
				    }
					//else{
					//JOptionPane.showMessageDialog("User Type is not matched", Respond);
					//}
				}		      
		 });
	     
	    frame.setSize(800,500);      
	    frame.setLocationRelativeTo(null);  
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setResizable(false);
	    
	    frame.getContentPane().add(panel, BorderLayout.CENTER);
	 
	  }
}