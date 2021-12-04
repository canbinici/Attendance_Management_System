package ams_system_package;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
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

public class DetainInterface extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7099613861328859490L;

	public DetainInterface(int id) throws HeadlessException, SQLException{
	
		JFrame frame = new JFrame("Detain");
		
		  JPanel panel = new JPanel();
		
		  JButton detainBtn;
			  
		  ImageIcon icon1 = new ImageIcon("block.png");
	     
	      detainBtn = new JButton("",icon1);
	      
	      JLabel headerLabel;
	      headerLabel = new JLabel("Detain of student " + DatabaseHandler.GetNameFromID(id,"Student",SectionSelectionStudent.sectionNum), JLabel.CENTER); 
		  
	           
	      panel.setLayout(new FlowLayout()); 
	      panel.add(headerLabel);
	      panel.add(detainBtn);
	 
	      
	     
	      detainBtn.addActionListener(new ActionListener(){
	    	  		
	   				public void actionPerformed(ActionEvent e) 
	   				{
	   					try {
							DatabaseHandler.DeleteStudent(id,SectionSelectionStudent.sectionNum);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	   					JOptionPane.showMessageDialog(panel,"Student has ben detained.");
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
