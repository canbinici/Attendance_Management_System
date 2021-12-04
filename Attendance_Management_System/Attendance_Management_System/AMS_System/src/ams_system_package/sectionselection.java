package ams_system_package;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;




//SECTÝON SELECTÝON FOR TEACHER 

public class sectionselection  {
	
	
	static Teacher _teacher;
	
	public sectionselection (Teacher teacher){
		
		_teacher = teacher;
		
		
		JFrame frame = new JFrame();
		
		frame.setBounds(100, 100, 600, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(56, 75, 455, 165);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Section 1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//new TeacherCosole(new Teacher(id))
				try {
					new TeacherConsole(_teacher,1);
					frame.dispose();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBounds(12, 48, 125, 67);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Section 2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					new TeacherConsole(_teacher,2);
					frame.dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(159, 48, 125, 67);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Section 3");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					new TeacherConsole(_teacher,3);
					frame.dispose();
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				
			}
		});
		btnNewButton_2.setBounds(304, 48, 127, 67);
		panel.add(btnNewButton_2);
		
		JLabel lblSelectSection = new JLabel("Select Section");
		lblSelectSection.setBounds(241, 27, 113, 35);
		frame.getContentPane().add(lblSelectSection);
		
		      
		    frame.setLocationRelativeTo(null);  
		    frame.setVisible(true);
		    
		    
		    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    frame.setResizable(false);
		    
		    frame.getContentPane().add(panel, BorderLayout.CENTER);
	}
	
	

}