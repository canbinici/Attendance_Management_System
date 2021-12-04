package ams_system_package;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class AdminConsole {

	
	public AdminConsole() throws SQLException{
		
		
		
		
		ArrayList<String> teacherNames = new ArrayList<>();
		teacherNames = DatabaseHandler.getAllTeacherNames();
		
		
		
		 JFrame frame = new JFrame();
		 JTextField textField;
		 JTextField textField_1;
		 JPasswordField passwordField;
		 JPasswordField passwordField_1;
		 JPasswordField passwordField_2;
		 JPasswordField passwordField_3;
		 JPasswordField passwordField_4;
		 JPasswordField passwordField_5;
		 JPasswordField passwordField_6;
		 JPasswordField passwordField_7;
		 JPasswordField passwordField_8;
		 JPasswordField passwordField_9;
		 JPasswordField passwordField_10;
		 JPasswordField passwordField_11;
		 JPasswordField passwordField_12;
		
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(44, 80, 552, 73);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		textField = new JTextField(teacherNames.get(0));
		textField.setBounds(0, 13, 116, 47);
		panel.add(textField);
		textField.setColumns(10);
		
		
		
		
		
		
		
		
		
		
		JButton btnNewButton = new JButton("Section 1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					new TeacherConsole(1);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBounds(124, 24, 97, 25);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Section 2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new TeacherConsole(2);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(225, 24, 97, 25);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Section 3");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					new TeacherConsole(3);
					
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
			}
		});
		btnNewButton_2.setBounds(328, 24, 97, 25);
		panel.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(44, 154, 552, 73);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		
		
		
		
		
		
		textField_1 = new JTextField(teacherNames.get(1));
		textField_1.setBounds(0, 13, 116, 47);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Section 1");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					new TeacherConsole(1);
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton_3.setBounds(124, 24, 97, 25);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Section 2");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new TeacherConsole(2);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_4.setBounds(226, 24, 97, 25);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Section 3");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					new TeacherConsole(3);
				
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				
			}
		});
		btnNewButton_5.setBounds(328, 24, 97, 25);
		panel_1.add(btnNewButton_5);
		
		JLabel lblNewLabel = new JLabel("Admin Console");
		lblNewLabel.setBounds(216, 13, 101, 50);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBounds(44, 228, 800, 100);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnAddNewStudent = new JButton("Add new Student");
		btnAddNewStudent.setBounds(657, 30, 131, 42);
		panel_2.add(btnAddNewStudent);
	
		
		
		
		
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(23, 50, 57, 22);
		panel_2.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(24, 21, 56, 16);
		panel_2.add(lblNewLabel_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(92, 50, 57, 22);
		panel_2.add(passwordField_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds(92, 21, 57, 16);
		panel_2.add(lblNewLabel_2);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(161, 50, 57, 22);
		panel_2.add(passwordField_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setBounds(161, 21, 56, 16);
		panel_2.add(lblNewLabel_3);
		
		passwordField_3 = new JPasswordField();
		passwordField_3.setBounds(230, 50, 57, 22);
		panel_2.add(passwordField_3);
		
		JLabel lblNewLabel_4 = new JLabel("E-mail");
		lblNewLabel_4.setBounds(229, 21, 56, 16);
		panel_2.add(lblNewLabel_4);
		
		passwordField_4 = new JPasswordField();
		passwordField_4.setBounds(302, 50, 57, 22);
		panel_2.add(passwordField_4);
		
		JLabel lblNewLabel_5 = new JLabel("Section Number");
		lblNewLabel_5.setBounds(303, 21, 56, 16);
		panel_2.add(lblNewLabel_5);
		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.setBounds(44, 330, 800, 100);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton_6 = new JButton("Add new Teacher");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_6.setBounds(655, 27, 133, 44);
		panel_3.add(btnNewButton_6);
		
		passwordField_9 = new JPasswordField();
		passwordField_9.setBounds(24, 48, 57, 22);
		panel_3.add(passwordField_9);
		
		JLabel lblNewLabel_9 = new JLabel("ID");
		lblNewLabel_9.setBounds(24, 13, 56, 16);
		panel_3.add(lblNewLabel_9);
		
		passwordField_10 = new JPasswordField();
		passwordField_10.setBounds(119, 49, 57, 22);
		panel_3.add(passwordField_10);
		
		JLabel lblNewLabel_10 = new JLabel("Name");
		lblNewLabel_10.setBounds(120, 13, 56, 16);
		panel_3.add(lblNewLabel_10);
		
		passwordField_11 = new JPasswordField();
		passwordField_11.setBounds(218, 48, 57, 22);
		panel_3.add(passwordField_11);
		
		JLabel lblNewLabel_11 = new JLabel("Surname");
		lblNewLabel_11.setBounds(219, 13, 56, 16);
		panel_3.add(lblNewLabel_11);
		
		passwordField_12 = new JPasswordField();
		passwordField_12.setBounds(312, 49, 57, 22);
		panel_3.add(passwordField_12);
		
		JLabel lblNewLabel_12 = new JLabel("Password");
		lblNewLabel_12.setBounds(313, 13, 56, 16);
		panel_3.add(lblNewLabel_12);
		
		
		
		

		btnAddNewStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	
            	try {
					DatabaseHandler.AddStudent(Integer.parseInt(new String(passwordField.getPassword())),
							new String(passwordField_1.getPassword()),
							
							Integer.parseInt(new String(passwordField_2.getPassword())), 
							
							new String(passwordField_3.getPassword()),
							
							Integer.parseInt(new String( passwordField_4.getPassword() )));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
            	
            }
        });
		
		
		btnNewButton_6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
            	try { //(id, name, surname, passWord)
					DatabaseHandler.AddTeacher(Integer.parseInt(new String(passwordField_9.getPassword())),
							new String(passwordField_10.getPassword()),
							
							new String(passwordField_11.getPassword()), 
							
							Integer.parseInt(new String(passwordField_12.getPassword())));

			
					
					
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
            	
				
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		      
		    frame.setLocationRelativeTo(null);  
		    frame.setVisible(true);
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setResizable(false);
		    
		    frame.getContentPane().add(panel, BorderLayout.CENTER);
	}
	
	
	
}
