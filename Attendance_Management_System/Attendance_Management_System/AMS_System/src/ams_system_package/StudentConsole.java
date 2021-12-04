package ams_system_package;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StudentConsole extends JFrame{
	
	//Student console shows attendance, attendance level, result marks, and fee status of the student.
	
	/**
	 * 
	 */
	

	
	private static final long serialVersionUID = 8518408821654259620L;

	
	//CONSOLE FOR THE STUDENT
	
	public StudentConsole(Student student,int sectionNum) throws HeadlessException, SQLException{
		JFrame frame = new JFrame("Student Console " + DatabaseHandler.GetNameFromID(student.getId(),"Student",sectionNum));
		
		
		System.out.println("Student console");
		  
	      JPanel base = new JPanel(); 
	      base.setLayout(new GridLayout(4,1));
	    
	      JPanel panel = new JPanel();   
	      JLabel  label = new JLabel("ATTENDANCE: ", JLabel.CENTER);
	      int attendance = DatabaseHandler.GetAttendanceN(student.getId(),sectionNum);
	      JLabel  labelname = new JLabel(String.valueOf(attendance), JLabel.CENTER);
	      
	      
	      JPanel panel2 = new JPanel();
	      JLabel label2 = new JLabel("ATTENDANCE LEVEL: ", JLabel.CENTER);
	      float attendance_level = student.getAttendance_Level(attendance);
	      JLabel  labelname2 = new JLabel(String.valueOf(attendance_level).concat("%"), JLabel.CENTER);
	      
	      
	      JPanel panel3 = new JPanel();
	      JLabel label3 = new JLabel("Result Marks: ", JLabel.CENTER);
	      
	      JButton fm_grade = new JButton(String.valueOf(DatabaseHandler.GetFirstMidtermGradeFromID(student.getId(),sectionNum)));
		  JButton sm_grade = new JButton(String.valueOf(DatabaseHandler.GetSecondMidtermGradeFromID(student.getId(),sectionNum)));
		  JButton final_grade = new JButton(String.valueOf(DatabaseHandler.GetFinalGradeFromID(student.getId(),sectionNum)));
		   
		  /*
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
			});*/
		     
	      
		  
		  
	
	      JPanel panel4 = new JPanel();
	      JLabel label4 = new JLabel("Fee status: ", JLabel.CENTER);
	      panel4.add(label4);
	      boolean fee_status = DatabaseHandler.GetFeeStatus(student.getId(),sectionNum);
	      if(fee_status == false){
	    	  JLabel  labelname3 = new JLabel("Fee has not been paid", JLabel.CENTER);
	    	  panel4.add(labelname3);
	    	  
	      }
	      else{
	    	  JLabel  labelname4 = new JLabel("Fee has been paid", JLabel.CENTER);
	    	  panel4.add(labelname4);
	      }
	      
		  
		 // panel4.add(backButton);
		  
	      panel.add(label);
	      panel.add(labelname);
	      panel2.add(label2);
	      panel2.add(labelname2);
	      panel3.add(label3);
	      panel3.setLayout(new FlowLayout());        
	      panel3.add(fm_grade);
	      panel3.add(sm_grade); 
	      panel3.add(final_grade);
	      
	      

	      base.add(panel,BorderLayout.EAST);
	      base.add(panel2,BorderLayout.WEST);
	      base.add(panel3,BorderLayout.CENTER);
	      base.add(panel4,BorderLayout.WEST);
	      
	      
	      JPanel panel5 = new JPanel();
          JLabel label5 = new JLabel("TEACHER MESSAGE: ", JLabel.CENTER);
          
          String message = "";
          message = DatabaseHandler.getMessage(student.getId(), sectionNum);
          
          
          
          JTextField textField = new JTextField(message);
          
          
          textField.setColumns(10);
          

          panel5.add(label5);
          panel5.add(textField);

          base.add(panel5,BorderLayout.CENTER);
	      
	      
	      
		
		frame.setSize(800, 500);      
	    frame.setLocationRelativeTo(null);  
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setResizable(false);
	    frame.getContentPane().add(base, BorderLayout.CENTER );
	}
	
	public float getAttendance_Level(int attendance){
		float attendance_level = 0;
		attendance_level = (float)attendance / (float)42 * 100;
		return attendance_level;
	}
	
	
	
	
	//Student console for admins
	
	public StudentConsole(int id,int sectionNum) throws HeadlessException, SQLException{
		JFrame frame = new JFrame("Student Console " + DatabaseHandler.GetNameFromID(id,"Student",sectionNum));
		
		  
		System.out.println("ADMÝN console");
		
		
	      JPanel base = new JPanel(); 
	      base.setLayout(new GridLayout(4,1));
	    
	      JPanel panel = new JPanel();   
	      JLabel  label = new JLabel("ATTENDANCE: ", JLabel.CENTER);
	      int attendance = DatabaseHandler.GetAttendanceN(id,sectionNum);
	      JLabel  labelname = new JLabel(String.valueOf(attendance), JLabel.CENTER);
	      
	      
	      JPanel panel2 = new JPanel();
	      JLabel label2 = new JLabel("ATTENDANCE LEVEL: ", JLabel.CENTER);
	      float attendance_level = getAttendance_Level(attendance);
	      JLabel  labelname2 = new JLabel(String.valueOf(attendance_level).concat("%"), JLabel.CENTER);
	      
	      
	      JPanel panel3 = new JPanel();
	      JLabel label3 = new JLabel("Result Marks: ", JLabel.CENTER);
	      
	      JButton fm_grade = new JButton(String.valueOf(DatabaseHandler.GetFirstMidtermGradeFromID(id,sectionNum)));
		  JButton sm_grade = new JButton(String.valueOf(DatabaseHandler.GetSecondMidtermGradeFromID(id,sectionNum)));
		  JButton final_grade = new JButton(String.valueOf(DatabaseHandler.GetFinalGradeFromID(id,sectionNum)));
		   
		/*
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
			});*/
		     
	      
		  
		  
		  
	      
	      
	      	JPanel panel_2 = new JPanel();
			panel_2.setBounds(44, 255, 475, 198);
			frame.getContentPane().add(panel_2);
			panel_2.setLayout(new GridLayout(1,2)); 
			
			ImageIcon icon1 = new ImageIcon("tick.png");
		    	ImageIcon icon2 = new ImageIcon("cross.png");

		      JButton attendancePozitiveBtn = new JButton("",icon1);
		      JButton attendanceNegativeBtn = new JButton("",icon2);
			  
		      JLabel headerLabel1;
		      headerLabel1 = new JLabel("Take attendance of student" + DatabaseHandler.GetNameFromID(id,"Student",sectionNum), JLabel.CENTER); 
		      panel_2.add(headerLabel1);
		      panel_2.add(attendancePozitiveBtn);
		      panel_2.add(attendanceNegativeBtn); 
		      

		      attendancePozitiveBtn.addActionListener(new ActionListener(){
		   				public void actionPerformed(ActionEvent e) 
		   				{
		   					try {
								DatabaseHandler.SetAttendance_P(id,sectionNum);
								
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
		   					JOptionPane.showMessageDialog(panel_2,"Attendance have been setting");
		   					frame.dispose();
		   				}
		   			});
		      	attendanceNegativeBtn.addActionListener(new ActionListener(){

		   				public void actionPerformed(ActionEvent e) 
		   				{
		   					try {
								DatabaseHandler.SetAttendance_N(id,sectionNum);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
		   					JOptionPane.showMessageDialog(panel_2,"Attendance have been setting");
		   					frame.dispose();
		   				}
		   			});
		    
			
				JPanel panel_3 = new JPanel();
				panel_3.setBounds(587, 255, 213, 198);
				frame.getContentPane().add(panel_3);
				panel_3.setLayout(new FlowLayout());
			
				JButton detainBtn;
			  
			  ImageIcon icon3 = new ImageIcon("block.png");
		     
		      detainBtn = new JButton("",icon3);
		      
		      JLabel headerLabel2;
		      headerLabel2 = new JLabel("Detain of student " + DatabaseHandler.GetNameFromID(id,"Student",sectionNum), JLabel.CENTER); 
			  
		           
		       
		      panel_3.add(headerLabel2);
		      panel_3.add(detainBtn);
		 
		      
		     
		      detainBtn.addActionListener(new ActionListener(){
		    	  		
		   				public void actionPerformed(ActionEvent e) 
		   				{
		   					try {
								DatabaseHandler.DeleteStudent(id,sectionNum);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
		   					JOptionPane.showMessageDialog(panel_3,"Student has ben detained.");
		   					frame.dispose();
		   				}
		   			});  
		
	      
	      
	      
	      
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
	
	      JPanel panel4 = new JPanel();
	      JLabel label4 = new JLabel("Fee status: ", JLabel.CENTER);
	      panel4.add(label4);
	      boolean fee_status = DatabaseHandler.GetFeeStatus(id,sectionNum);
	      if(fee_status == false){
	    	  JLabel  labelname3 = new JLabel("Fee has not been paid", JLabel.CENTER);
	    	  panel4.add(labelname3);
	    	  
	      }
	      else{
	    	  JLabel  labelname4 = new JLabel("Fee has been paid", JLabel.CENTER);
	    	  panel4.add(labelname4);
	      }
	      
		  
	      //panel4.add(backButton);
		 
	      panel.add(label);
	      panel.add(labelname);
	      panel2.add(label2);
	      panel2.add(labelname2);
	      panel3.add(label3);
	      panel3.setLayout(new FlowLayout());        
	      panel3.add(fm_grade);
	      panel3.add(sm_grade); 
	      panel3.add(final_grade);
	      
	      

	      base.add(panel,BorderLayout.EAST);
	      base.add(panel2,BorderLayout.WEST);
	      base.add(panel3,BorderLayout.CENTER);
	      base.add(panel4,BorderLayout.WEST);
	      
	      base.add(panel_2,BorderLayout.SOUTH);
	      base.add(panel_3,BorderLayout.SOUTH);

		frame.setSize(800, 500);      
	    frame.setLocationRelativeTo(null);  
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setResizable(false);
	    frame.getContentPane().add(base, BorderLayout.CENTER );
	}

	
	
	
	
	
	
	
	
	
	

}
