
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JEditorPane;
import javax.swing.JSlider;
import javax.swing.JTextPane;

public class Login extends JFrame {
	DbConn conn=new DbConn();
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField pass;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 552);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKullancAd = new JLabel("Name");
		lblKullancAd.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblKullancAd.setForeground(Color.BLACK);
		lblKullancAd.setBounds(149, 188, 113, 29);
		contentPane.add(lblKullancAd);
		
		JLabel password = new JLabel("Password");
		password.setForeground(Color.BLACK);
		password.setFont(new Font("Tahoma", Font.PLAIN, 20));
		password.setBounds(149, 242, 113, 29);
		contentPane.add(password);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(253, 188, 215, 39);
		contentPane.add(username);
		
		pass = new JPasswordField();
		pass.setBounds(253, 241, 215, 39);
		contentPane.add(pass);
		
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(username.getText().length()==0 && pass.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
				}
					
				else {
				
				try {
					Connection con = conn.getDBConnection();
					Statement  stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery( "SELECT * FROM users;" );
					int key=0;
				
				
			
		         while ( rs.next() ) {
		        		
		        	 if(username.getText().equals(rs.getString("name")) && pass.getText().equals(rs.getString("password")) )
		             {
		            	
		            	 key=1;
		            	 if(rs.getString("type").equals("Employee")){
			            	 EmployeeGUI emp = new EmployeeGUI();
			            	 emp.setVisible(true);
			            	 dispose();
			            	}
		            	 else if(rs.getString("type").equals("Manager"))
		            	 {
		            		 ManagerGUI emp = new ManagerGUI();
			            	 emp.setVisible(true);
			            	 dispose();
		            	 }
		            	 else
		            	 { TesterGUI emp = new TesterGUI();
		            	 emp.setVisible(true);
		            	 dispose();}
		            	 
		             } 
		        	
		         }
		         if(key!=1)
		         {JOptionPane.showMessageDialog(null, "Error! No such user found! Try Again");}
				}
				catch (SQLException e1) {
					// TODO: handle exception
				}
			} 
			}
		});
		btnNewButton.setBounds(253, 303, 215, 90);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Product Quality Management System");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(98, 48, 519, 76);
		contentPane.add(lblNewLabel);
	
	
		
		
	}
}
