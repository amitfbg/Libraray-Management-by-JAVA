package library;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class View1 {

	private JFrame frame;
	private JTable table;
	private JButton btnBack;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View1 window = new View1();
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
	public View1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 739, 504);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 703, 398);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		btnBack = new JButton(" Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(Color.RED);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main1.main(new String[] {});
				frame.dispose();
			}
		});
		btnBack.setBounds(604, 431, 89, 23);
		frame.getContentPane().add(btnBack);
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");	
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			String query="select * from addbooks";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			textField = new JTextField();
			textField.setBounds(79, 432, 86, 20);
			frame.getContentPane().add(textField);
			textField.setColumns(10);
			
			JButton btnDelete = new JButton("Delete");
			btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String bookid=textField.getText();
					try
					{
					
						int x=0;
					Class.forName("oracle.jdbc.driver.OracleDriver");	
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
					PreparedStatement ps=con.prepareStatement("DELETE from addbooks WHERE bookid='"+bookid+"' ");
					
					
					ResultSet rs=ps.executeQuery();
					x++;
					if(x>0){
						JOptionPane.showMessageDialog(btnDelete,"Books deleted successfully!");
						
						Main1.main(new String[]{});
						frame.dispose();
						
					}else{
						JOptionPane.showMessageDialog(btnDelete,"error!");
					}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			});
			btnDelete.setBounds(191, 431, 89, 23);
			frame.getContentPane().add(btnDelete);
			
			JLabel lblBookId = new JLabel("Book ID");
			lblBookId.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblBookId.setBounds(10, 435, 75, 14);
			frame.getContentPane().add(lblBookId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
