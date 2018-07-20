package library;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;

public class Issue {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Issue window = new Issue();
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
	public Issue() {
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
		
		JLabel lblBookId = new JLabel("Book Id");
		lblBookId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBookId.setBounds(29, 42, 86, 14);
		frame.getContentPane().add(lblBookId);
		
		JLabel lblStudentId = new JLabel("Student Id");
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStudentId.setBounds(29, 81, 86, 14);
		frame.getContentPane().add(lblStudentId);
		
		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStudentName.setBounds(29, 127, 111, 17);
		frame.getContentPane().add(lblStudentName);
		
		JLabel lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblContactNumber.setBounds(29, 172, 111, 17);
		frame.getContentPane().add(lblContactNumber);
		
		textField = new JTextField();
		textField.setBounds(181, 40, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(181, 79, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(181, 124, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(181, 169, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setBackground(Color.GREEN);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String bookid=textField.getText();
				int studentid=Integer.parseInt(textField_1.getText());
				String studentname=textField_2.getText();
				String studentcontact=textField_3.getText();
				try
				{
				
					int x=0;
				Class.forName("oracle.jdbc.driver.OracleDriver");	
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
				PreparedStatement ps=con.prepareStatement("insert into issue values(?,?,?,?)");
				ps.setString(1,bookid);
				ps.setInt(2,studentid);
				ps.setString(3,studentname);
				ps.setString(4,studentcontact);
				ResultSet rs=ps.executeQuery();
				x++;
				if(x>0){
					JOptionPane.showMessageDialog(btnSubmit,Issue.this,"Books issued successfully!", x);
					Main1.main(new String[]{});
					frame.dispose();
					
				}else{
					JOptionPane.showMessageDialog(btnSubmit, Issue.this,"Sorry, unable to issue!", x);
				}
			}catch(Exception e){System.out.println(e);}
				
			}
		});
		btnSubmit.setBounds(118, 215, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main1.main(new String[] {});
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(290, 215, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblBookName = new JLabel("Book Name");
		lblBookName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBookName.setBounds(28, 11, 87, 14);
		frame.getContentPane().add(lblBookName);
		
		textField_4 = new JTextField();
		textField_4.setBounds(181, 9, 86, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String search=textField_4.getText();
				//A ob =new A();
				//ob.main();
				
				try
				{
				
					
				Class.forName("oracle.jdbc.driver.OracleDriver");	
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
				PreparedStatement ps=con.prepareStatement("SELECT * FROM addbooks WHERE bookname = ?");
				ps.setString(1,search);
				
				ResultSet rs=ps.executeQuery();
				
				if(rs.next()){
					do
					{
					JOptionPane.showMessageDialog(btnSearch,"book id is: "+ rs.getString("bookid")+" "+"Author Name :"+" "+ rs.getString("author")+" "+"publication :"+ rs.getString("publisher"));
					}
					while(rs.next());
					
				}
				else
				{
					System.out.println("not found");
				}
			}catch(Exception e){e.printStackTrace();;}
				
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSearch.setBounds(290, 8, 89, 23);
		frame.getContentPane().add(btnSearch);
	}
}
