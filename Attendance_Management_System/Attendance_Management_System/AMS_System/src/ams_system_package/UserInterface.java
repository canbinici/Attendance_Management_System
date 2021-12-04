package ams_system_package;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UserInterface extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5348027348692440713L;
	static String userType = null;

	public UserInterface(){
		
	     JFrame frame = new JFrame("Attendance Management System");
	     
	      JButton studentBtn;
		  JButton teacherBtn;
		  JButton adminBtn;
		  
		  ImageIcon icon1 = new ImageIcon("student.png");
	      ImageIcon icon2 = new ImageIcon("teacher.png");
	      ImageIcon icon3 = new ImageIcon("admin.png");

		  studentBtn = new JButton("Student",icon1);
		  teacherBtn= new JButton("Teacher",icon2);
		  adminBtn   = new JButton("Admin",icon3);
		  
	      JPanel panel = new JPanel();
	     
	      panel.setLayout(new FlowLayout());        
	      panel.add(studentBtn);
	      panel.add(teacherBtn); 
	      panel.add(adminBtn); 
	     
	      //when user click each of the User Type buttons, the Login Console will be shown. 
	      
	      studentBtn.addActionListener(new ActionListener(){
 				public void actionPerformed(ActionEvent e) {
 					userType = "Student";
 					new SectionSelectionStudent();
 					frame.dispose();

 				}
 			});
	      teacherBtn.addActionListener(new ActionListener(){
 				public void actionPerformed(ActionEvent e) {
 					userType = "Teacher";
 					new LoginConsole();
 					frame.dispose();
	
 				}
 			});
	      
	      
	      
	      adminBtn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					userType = "Admin";
					new LoginConsole();
					frame.dispose();
				}
			}); 	  
	      
	      
	      
	      
	      
	      
	      
	     
	    frame.setSize(800, 500);      
	    frame.setLocationRelativeTo(null);  
	    frame.setVisible(true);
	    frame.setResizable(false);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().add(panel, BorderLayout.CENTER);  
	}
	
}



	
	
	
	
