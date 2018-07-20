package library;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

public class Main1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main1 window = new Main1();
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
	public Main1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 332);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("ADD");
		Image img=new ImageIcon(this.getClass().getResource("/add.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddBooks.main(new String[]{});
				frame.dispose();
				
			}
		});
		btnNewButton.setBounds(155, 11, 121, 35);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View");
		Image img1=new ImageIcon(this.getClass().getResource("/view.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img1));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				View1.main(new String[]{});
				frame.dispose();
				
			}
		});
		btnNewButton_1.setBounds(155, 66, 121, 35);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Issue");
		Image img2=new ImageIcon(this.getClass().getResource("/issue.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon(img2));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Issue.main(new String[]{});
				frame.dispose();
			}
		});
		btnNewButton_2.setBounds(155, 121, 121, 35);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View issue");
		Image img3=new ImageIcon(this.getClass().getResource("/viewissue.png")).getImage();
		btnNewButton_3.setIcon(new ImageIcon(img3));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewIssue.main(new String[]{});
				frame.dispose();
			}
		});
		btnNewButton_3.setBounds(155, 171, 121, 35);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Return");
		Image img4=new ImageIcon(this.getClass().getResource("/return.png")).getImage();
		btnNewButton_4.setIcon(new ImageIcon(img4));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Return.main(new String[]{});
				frame.dispose();
			}
		});
		btnNewButton_4.setBounds(155, 226, 121, 35);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("LOGOUT");
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBackground(Color.RED);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LogIn.main(new String[] {});
				frame.dispose();
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_5.setBounds(313, 226, 111, 35);
		frame.getContentPane().add(btnNewButton_5);
	}
}
