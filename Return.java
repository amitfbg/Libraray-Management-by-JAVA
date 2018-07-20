package library;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Return {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Return window = new Return();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public Return() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBookid = new JLabel("Bookid");
		lblBookid.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBookid.setBounds(52, 56, 63, 14);
		frame.getContentPane().add(lblBookid);
		
		JLabel lblStudentId = new JLabel("Student Id");
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStudentId.setBounds(52, 116, 76, 14);
		frame.getContentPane().add(lblStudentId);
		
		textField = new JTextField();
		textField.setBounds(154, 53, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(154, 113, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setBackground(Color.GREEN);
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String bookid=textField.getText();
				int studentid=Integer.parseInt(textField_1.getText());
				try
				{
				
					int x=0;
				Class.forName("oracle.jdbc.driver.OracleDriver");	
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
				PreparedStatement ps=con.prepareStatement("DELETE from issue WHERE bookid='"+bookid+"' AND studentid='"+studentid+"'");
				
				
				ResultSet rs=ps.executeQuery();
				x++;
				if(x>0){
					JOptionPane.showMessageDialog(btnSubmit,"Books returned successfully!");
					
					Main1.main(new String[]{});
					frame.dispose();
					
				}else{
					JOptionPane.showMessageDialog(btnSubmit,"error!");
				}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
			}
		});
		btnSubmit.setBounds(88, 182, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main1.main(new String[] {});
				frame.dispose();
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.setBackground(Color.RED);
		btnBack.setBounds(266, 182, 89, 23);
		frame.getContentPane().add(btnBack);
		
		JLabel lblNewLabel = new JLabel("NOTE : Please Check Book Carefully");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(88, 227, 292, 25);
		frame.getContentPane().add(lblNewLabel);
	}


}
