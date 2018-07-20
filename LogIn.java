package library;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;

public class LogIn {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblNewLabel_2;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn window = new LogIn();
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
	public LogIn() {
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
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(186, 44, 80, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(186, 104, 73, 33);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(290, 50, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("  LOGIN");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		Image img1=new ImageIcon(this.getClass().getResource("/Ok-icon.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img1));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name=textField.getText();
				String pass=String.valueOf(passwordField.getText());
				if(name.equals("admin") && pass.equals("admin"))
				{
					Main1.main(new String[]{});
					frame.dispose();
					
				
				}
				else
				{
					JOptionPane.showMessageDialog(btnNewButton, "Login Error!");
					textField.setText("");
					passwordField.setText("");
				}
			}
		});
		btnNewButton.setBounds(186, 179, 116, 33);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel_2 = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/login1.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img));
		lblNewLabel_2.setBounds(29, 31, 132, 149);
		frame.getContentPane().add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(290, 111, 86, 20);
		frame.getContentPane().add(passwordField);
					
		
		
	}
}
