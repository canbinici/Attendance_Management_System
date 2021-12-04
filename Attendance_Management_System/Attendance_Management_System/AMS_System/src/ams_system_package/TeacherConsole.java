package ams_system_package;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TeacherConsole extends JFrame{
	
	//Teacher console enables teacher to take attendance of the students, display the all students
	//, NA students and students that have not paid fees.
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9041177211001945480L;


	//teacher console for teacher
	public TeacherConsole(Teacher teacher, int sectionNum) throws SQLException{
		
		
		JFrame frame = new JFrame("Teacher Console "+ DatabaseHandler.GetNameFromID(teacher.getId(),"Teacher",0));
		
		JPanel base = new JPanel(); 	
		base.setLayout(new GridLayout(3,1));
	    
	      JPanel panel = new JPanel();  
	      JLabel  label= new JLabel("All students: ", JLabel.CENTER);
	      
	      ArrayList<String> x = DatabaseHandler.GetAllStudentsNames(sectionNum);
	      
	      String names[] = new String[x.size()];
	      for (int i = 0; i < x.size(); i++) { 
	            names[i] = x.get(i); 
	      } 
	     
	      JList<String> listBox = new JList<>(names);
	      listBox.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	      listBox.setVisibleRowCount(-1); // to keep all values visible
	      listBox.setSelectedIndex(3);
	      listBox.addListSelectionListener(new ListSelectionListener() {
	    	 
	         public void valueChanged(ListSelectionEvent e) {
	        	if (e.getValueIsAdjusting()) {
	        	JList list = (JList)e.getSource();
	            String name = String.valueOf(list.getSelectedValue());
	            System.out.println(String.valueOf(list.getSelectedValue()));
	            int id = 0;
						try {
							id = DatabaseHandler.GetIDFromName(name,sectionNum);
							System.out.println(id);
							new AttendanceInterface(id);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	        	 }
	         }
	         
	      });
	      
	      
	      JPanel panel2 = new JPanel(); 
	      JLabel  label2= new JLabel("All NA students: ", JLabel.CENTER);
	      
	      ArrayList<String> x2 = DatabaseHandler.GetAllNAStudentsNames(sectionNum);
	      String names2[] = new String[x2.size()];
	      for (int j = 0; j < x2.size(); j++) { 
	            names2[j] = x2.get(j); 
	      } 
	     
	      JList<String> listBox2 = new JList<>(names2);
	      listBox2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	      listBox2.setVisibleRowCount(-1); // to keep all values visible
	      listBox2.setSelectedIndex(3);
	      listBox2.addListSelectionListener(new ListSelectionListener() {		
	         public void valueChanged(ListSelectionEvent e) {
	        	if (e.getValueIsAdjusting()) {
	            JList list2 = (JList)e.getSource();      
	            System.out.println(String.valueOf(list2.getSelectedValue()));
	        	}    
	         }
	      });
	      
	      JPanel panel3 = new JPanel();
	      JLabel label3= new JLabel("All students that have not paid the fees: ", JLabel.CENTER);
	      
	      ArrayList<String> x3 = DatabaseHandler.GetAllStudentsNOTPaidFees(sectionNum);
	      String names3[] = new String[x3.size()];
	      for (int k = 0; k < x3.size(); k++) { 
	            names3[k] = x3.get(k); 
	      } 
	     
	      JList<String> listBox3 = new JList<>(names3);
	      listBox3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	      listBox3.setVisibleRowCount(-1); // to keep all values visible
	      listBox3.setSelectedIndex(3);
	      listBox3.addListSelectionListener(new ListSelectionListener() {		
	         public void valueChanged(ListSelectionEvent e) {
	        	if (e.getValueIsAdjusting()) {
	            JList list3 = (JList)e.getSource();      
	            String name3 = String.valueOf(list3.getSelectedValue());
	            System.out.println(String.valueOf(list3.getSelectedValue()));
	            int id3 = 0;
						try {
							id3 = DatabaseHandler.GetIDFromName(name3,sectionNum);
							System.out.println(id3);
							new DetainInterface(id3);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}   
	        	}
	         }
	      });
		  
	      
	      
	      JButton backButton;
		     backButton = new JButton("Back");
		     
		     backButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					new LoginConsole();
					
					
					
					try {
						DatabaseHandler.ClearLoggedIn();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
				}   
			});
		     
	      
	      
	      
	      panel.add(label);
	      panel2.add(label2);
	      panel3.add(label3);
	      
	      panel.add(listBox);
	      panel.add(backButton);
	      
	      panel2.add(listBox2);
	      panel3.add(listBox3);
	      base.add(panel,BorderLayout.EAST);
	      base.add(panel2,BorderLayout.WEST);
	      base.add(panel3,BorderLayout.CENTER);
	      
			
	      
	      JPanel panel5 = new JPanel();
          JLabel label5 = new JLabel("TEACHER MESSAGE: ", JLabel.CENTER);
          JTextField textField = new JTextField();
          textField.setColumns(10);

          JButton btnNewButton = new JButton("Send Message");
            btnNewButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                	try {
                		
                		String message = "";
                		message = textField.getText();
                		
						
                		
                		DatabaseHandler.setMessage(message, sectionNum, 22);
						
                		ArrayList<String> students = DatabaseHandler.GetAllStudentsNames(sectionNum);
						
						for(int i = 0 ; i < students.size(); i++) {
							
							int id ;
							id = DatabaseHandler.GetIDFromName(students.get(i),sectionNum);				
							DatabaseHandler.setMessage(message, sectionNum, id);
							
						}
						
						JOptionPane.showMessageDialog(panel,"Message is sended to students");
						
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
            });

             panel5.add(label5);
             panel5.add(textField);

            panel5.add(btnNewButton);
            
            base.add(panel5,BorderLayout.CENTER);
            
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
		frame.setSize(800, 500);      
	    frame.setLocationRelativeTo(null);  
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setResizable(false);
	    frame.getContentPane().add(base, BorderLayout.CENTER );
	}

	
	
	
	
	//teacher console for admin
	public TeacherConsole(int sectionNum) throws SQLException{
		
		
		JFrame frame = new JFrame("ADMIN Console");
		
		JPanel base = new JPanel(); 	
		base.setLayout(new GridLayout(3,1));
	    
	      JPanel panel = new JPanel();  
	      JLabel  label= new JLabel("All students: ", JLabel.CENTER);
	      
	      ArrayList<String> x = DatabaseHandler.GetAllStudentsNames(sectionNum);
	      
	      String names[] = new String[x.size()];
	      for (int i = 0; i < x.size(); i++) { 
	            names[i] = x.get(i); 
	      } 
	     
	      JList<String> listBox = new JList<>(names);
	      listBox.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	      listBox.setVisibleRowCount(-1); // to keep all values visible
	      listBox.setSelectedIndex(3);
	      listBox.addListSelectionListener(new ListSelectionListener() {
	    	 
	         public void valueChanged(ListSelectionEvent e) {
	        	if (e.getValueIsAdjusting()) {
	        	JList list = (JList)e.getSource();
	            String name = String.valueOf(list.getSelectedValue());
	            System.out.println(String.valueOf(list.getSelectedValue()));
	            int id = 0;
						try {
							id = DatabaseHandler.GetIDFromName(name,sectionNum);
							System.out.println(id);
							new StudentConsole(id,sectionNum);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	        	 }
	         }
	         
	      });
	      
	      
	      JPanel panel2 = new JPanel(); 
	      JLabel  label2= new JLabel("All NA students: ", JLabel.CENTER);
	      
	      ArrayList<String> x2 = DatabaseHandler.GetAllNAStudentsNames(sectionNum);
	      String names2[] = new String[x2.size()];
	      for (int j = 0; j < x2.size(); j++) { 
	            names2[j] = x2.get(j); 
	      } 
	     
	      JList<String> listBox2 = new JList<>(names2);
	      listBox2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	      listBox2.setVisibleRowCount(-1); // to keep all values visible
	      listBox2.setSelectedIndex(3);
	      listBox2.addListSelectionListener(new ListSelectionListener() {		
	         public void valueChanged(ListSelectionEvent e) {
	        	if (e.getValueIsAdjusting()) {
	            JList list2 = (JList)e.getSource();      
	            System.out.println(String.valueOf(list2.getSelectedValue()));
	        	}    
	         }
	      });
	      
	      JPanel panel3 = new JPanel();
	      JLabel label3= new JLabel("All students that have not paid the fees: ", JLabel.CENTER);
	      
	      ArrayList<String> x3 = DatabaseHandler.GetAllStudentsNOTPaidFees(sectionNum);
	      String names3[] = new String[x3.size()];
	      for (int k = 0; k < x3.size(); k++) { 
	            names3[k] = x3.get(k); 
	      } 
	     
	      JList<String> listBox3 = new JList<>(names3);
	      listBox3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	      listBox3.setVisibleRowCount(-1); // to keep all values visible
	      listBox3.setSelectedIndex(3);
	      listBox3.addListSelectionListener(new ListSelectionListener() {		
	         public void valueChanged(ListSelectionEvent e) {
	        	if (e.getValueIsAdjusting()) {
	            JList list3 = (JList)e.getSource();      
	            String name3 = String.valueOf(list3.getSelectedValue());
	            System.out.println(String.valueOf(list3.getSelectedValue()));
	            int id3 = 0;

	        	}
	         }
	      });
		  
	      
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
			});
		     */
	      
	      

	      
	      
	      
	      
	      
	      panel.add(label);
	      panel2.add(label2);
	      panel3.add(label3);
	      
	      panel.add(listBox);
	      //panel.add(backButton);
	      
	      panel2.add(listBox2);
	      panel3.add(listBox3);
	      base.add(panel,BorderLayout.EAST);
	      base.add(panel2,BorderLayout.WEST);
	      base.add(panel3,BorderLayout.CENTER);


	      
	      
			
		frame.setSize(800, 500);      
	    frame.setLocationRelativeTo(null);  
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setResizable(false);
	    frame.getContentPane().add(base, BorderLayout.CENTER );
	}
	
	
	
}
