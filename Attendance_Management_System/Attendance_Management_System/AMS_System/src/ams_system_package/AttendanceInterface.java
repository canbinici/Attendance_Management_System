package ams_system_package;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AttendanceInterface extends JFrame{
	
	//Attendance Interface class shows attendance console to teacher to take atteandance of students as positive or negative.
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2624433892188746457L;

	public AttendanceInterface(int id) throws SQLException{
		
		JFrame frame = new JFrame("Take Attendance of "+DatabaseHandler.GetNameFromID(id,"Student",SectionSelectionStudent.sectionNum));
		
		JButton attendancePozitiveBtn;
		JButton attendanceNegativeBtn;

		  
		  ImageIcon icon1 = new ImageIcon("tick.png");
	      ImageIcon icon2 = new ImageIcon("cross.png");

	      attendancePozitiveBtn = new JButton("",icon1);
	      attendanceNegativeBtn= new JButton("",icon2);
		  
	      JPanel panel = new JPanel();
	      
	     
	      panel.setLayout(new GridLayout(1,2));        
	      panel.add(attendancePozitiveBtn);
	      panel.add(attendanceNegativeBtn); 
	      //panel.add(adminBtn); 

	      attendancePozitiveBtn.addActionListener(new ActionListener(){
	   				public void actionPerformed(ActionEvent e) 
	   				{
	   					try {
							DatabaseHandler.SetAttendance_P(id,SectionSelectionStudent.sectionNum);
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	   					JOptionPane.showMessageDialog(panel,"Attendance have been setting");
	   					frame.dispose();
	   				}
	   			});
	      attendanceNegativeBtn.addActionListener(new ActionListener(){

	   				public void actionPerformed(ActionEvent e) 
	   				{
	   					try {
							DatabaseHandler.SetAttendance_N(id,SectionSelectionStudent.sectionNum);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	   					JOptionPane.showMessageDialog(panel,"Attendance have been setting");
	   					frame.dispose();
	   				}
	   			});
	    
		
		frame.setSize(400, 200);      
	    frame.setLocationRelativeTo(null);  
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setResizable(false);
	    frame.getContentPane().add(panel, BorderLayout.CENTER);   
	}

}
