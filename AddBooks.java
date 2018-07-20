package library;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class AddBooks {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBooks window = new AddBooks();
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
	public AddBooks() {
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
		
		JLabel lblRowNo = new JLabel("Row No");
		lblRowNo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRowNo.setBounds(22, 33, 70, 14);
		frame.getContentPane().add(lblRowNo);
		
		JLabel lblColumnNo = new JLabel("column no");
		lblColumnNo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblColumnNo.setBounds(22, 58, 70, 14);
		frame.getContentPane().add(lblColumnNo);
		
		JLabel lblBookName = new JLabel("Book name");
		lblBookName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBookName.setBounds(22, 87, 70, 14);
		frame.getContentPane().add(lblBookName);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAuthor.setBounds(22, 117, 70, 14);
		frame.getContentPane().add(lblAuthor);
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPublisher.setBounds(22, 147, 70, 14);
		frame.getContentPane().add(lblPublisher);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblQuantity.setBounds(22, 172, 70, 14);
		frame.getContentPane().add(lblQuantity);
		
		textField = new JTextField();
		textField.setBounds(161, 30, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(161, 55, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(161, 84, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(161, 114, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(161, 144, 86, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(161, 169, 86, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(Color.GREEN);
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String rowno=textField.getText();
				String columnno=textField_1.getText();
				String bookname=textField_2.getText();
				String author=textField_3.getText();
				String publisher=textField_4.getText();
				
				String bookid=textField_6.getText();
				int quantity=Integer.parseInt(textField_5.getText());
				try
				{
				
					int x=0;
				Class.forName("oracle.jdbc.driver.OracleDriver");	
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
				PreparedStatement ps=con.prepareStatement("insert into addbooks values(?,?,?,?,?,?,?)");
				ps.setString(1,rowno);
				ps.setString(2,columnno);
				ps.setString(3,bookname);
				ps.setString(4,author);
				ps.setString(5,publisher);
				ps.setInt(6,quantity);
				ps.setString(7,bookid);
				ResultSet rs=ps.executeQuery();
				x++;
				if(x>0){
					JOptionPane.showMessageDialog(btnSubmit,AddBooks.this,"Books added successfully!", x);
					Main1.main(new String[]{});
					frame.dispose();
					
				}else{
					JOptionPane.showMessageDialog(btnSubmit, AddBooks.this,"Sorry, unable to save!", x);
				}
			}catch(Exception e){System.out.println(e);}
				
			}
		});
		btnSubmit.setBounds(127, 215, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(Color.RED);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main1.main(new String[]{});
				frame.dispose();
			}
		});
		btnBack.setBounds(278, 215, 89, 23);
		frame.getContentPane().add(btnBack);
		
		JLabel lblBookId = new JLabel("Book Id");
		lblBookId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBookId.setBounds(22, 8, 70, 14);
		frame.getContentPane().add(lblBookId);
		
		textField_6 = new JTextField();
		textField_6.setBounds(161, 5, 86, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
	}
}
