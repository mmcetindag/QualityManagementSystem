import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Properties;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import javax.swing.JComboBox;

public class ManagerGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField productCode;
	private JTextField productName;
	private JTextField price;
	Manager m = new Manager(1 ,"" , "" ,"");
	private JTable employeeList;
	private JTextField id;
	private JTextField userName;
	private JTextField password;
	private JTextField typeOfuser;
	private JTable table_1;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerGUI frame = new ManagerGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManagerGUI() {
		Employee e = new Employee();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 714, 464);
		contentPane.add(tabbedPane);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Home", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Welcome Manager Panel");
		lblNewLabel_3.setForeground(Color.DARK_GRAY);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(191, 87, 338, 47);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblQualityManagementSystem = new JLabel("Product Quality Management System");
		lblQualityManagementSystem.setForeground(Color.DARK_GRAY);
		lblQualityManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblQualityManagementSystem.setBounds(101, 29, 509, 47);
		panel_2.add(lblQualityManagementSystem);
		
		JLabel lblNewLabel_4 = new JLabel("-You can update and list product on Update/List Product tab menu");
		lblNewLabel_4.setFont(new Font("SansSerif", Font.ITALIC, 17));
		lblNewLabel_4.setBounds(60, 179, 522, 29);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblyouCanSend = new JLabel("-You can update,delete and add Employee on Update Employee tab menu");
		lblyouCanSend.setFont(new Font("SansSerif", Font.ITALIC, 17));
		lblyouCanSend.setBounds(60, 207, 573, 29);
		panel_2.add(lblyouCanSend);
		
		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login log = new Login();
				log.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(230, 294, 219, 55);
		panel_2.add(btnNewButton_2);	
		
		JLabel lblyouCanView = new JLabel("-You can view quality reports of products on List Quality Reports tab menu");
		lblyouCanView.setFont(new Font("SansSerif", Font.ITALIC, 17));
		lblyouCanView.setBounds(60, 234, 573, 29);
		panel_2.add(lblyouCanView);
		
			
		JPanel panel = new JPanel();
		tabbedPane.addTab("Update/List Product", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
	
		scrollPane.setBounds(10, 220, 689, 205);
		panel.add(scrollPane);
		
		
		Product p =new Product();
		
		DefaultTableModel productModel = new DefaultTableModel();
		 Object[] columsName = new Object[5];
	        
	        columsName[0]="Code";
	         columsName[1]="Product Name";
	          columsName[2]="Price";
	           columsName[3]="Properties";
	            columsName[4]="Quality Info";
		        
	        productModel.setColumnIdentifiers(columsName);
	        Object[] rowData = new Object[6];
	        
	        for(int i = 0; i < p.getProduct().size(); i++){
	            
	            rowData[0] =  p.getProduct().get(i).getProductCode();
	             rowData[1] =  p.getProduct().get(i).getProductName();
	             	rowData[2] =  p.getProduct().get(i).getPrice();
	             		rowData[3] =  p.getProduct().get(i).getProperties();
	             			rowData[4] =  p.getProduct().get(i).getQualityInfo();
	             productModel.addRow(rowData);
	            
	        }		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(productModel);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		TableColumnModel columnModel=table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(30);
        columnModel.getColumn(2).setPreferredWidth(35);
        columnModel.getColumn(3).setPreferredWidth(200);
        columnModel.getColumn(4).setPreferredWidth(250);
        table.setRowHeight(100);
        table.getColumnModel().getColumn(4).setCellRenderer(new WordWrapCellRenderer());
        table.getColumnModel().getColumn(3).setCellRenderer(new WordWrapCellRenderer());

		productCode = new JTextField();
		productCode.setBounds(10, 29, 86, 20);
		panel.add(productCode);
		productCode.setColumns(10);
		
		JLabel lblProductCode = new JLabel("Product Code");
		lblProductCode.setBounds(10, 10, 86, 14);
		panel.add(lblProductCode);
		
		productName = new JTextField();
		productName.setColumns(10);
		productName.setBounds(117, 29, 86, 20);
		panel.add(productName);
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setBounds(117, 10, 86, 14);
		panel.add(lblProductName);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(226, 10, 70, 14);
		panel.add(lblPrice);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(226, 29, 86, 20);
		panel.add(price);
			
		JTextPane propertiess = new JTextPane();
		propertiess.setBounds(10, 87, 186, 105);
		panel.add(propertiess);
		
		
		JTextPane qualityInfo = new JTextPane();
		qualityInfo.setBounds(226, 87, 186, 105);
		panel.add(qualityInfo);
		
		JLabel lblProperties = new JLabel("Properties");
		lblProperties.setBounds(10, 60, 86, 14);
		panel.add(lblProperties);
		
		JLabel lblQualityInfo = new JLabel("Quality Info");
		lblQualityInfo.setBounds(226, 62, 70, 14);
		panel.add(lblQualityInfo);
		
		JButton btnNewButton = new JButton("Update Product");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(productCode.getText().length()==0 || productName.getText().length()==0 || propertiess.getText().length()==0 || price.getText().length()==0 || qualityInfo.getText().length()==0)
				{	
					JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
				}
				else
				{
					String data =productModel.getValueAt(table.getSelectedRow(), 0).toString();
					boolean control = m.setProduct(data, productName.getText(), propertiess.getText(), Integer.parseInt(price.getText()), qualityInfo.getText() , productCode.getText());
					if(control)
					{
						JOptionPane.showMessageDialog(null, "Completing update product !");
						DefaultTableModel clearModel = (DefaultTableModel) table.getModel();
						clearModel.setRowCount(0);
						productCode.setText("");
						productName.setText("");
						propertiess.setText("");
						price.setText("");
						qualityInfo.setText("");
						 for(int i = 0; i < p.getProduct().size(); i++){
						        
						        rowData[0] =  p.getProduct().get(i).getProductCode();
						         rowData[1] =  p.getProduct().get(i).getProductName();
						         	rowData[2] =  p.getProduct().get(i).getPrice();
						         		rowData[3] =  p.getProduct().get(i).getProperties();
						         			rowData[4] =  p.getProduct().get(i).getQualityInfo();
						         				productModel.addRow(rowData);
						        
						    }
						 table.setModel(productModel);
						 
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Do not update product !");
					}
				}
				
					
			}
		});
		btnNewButton.setBounds(481, 118, 149, 41);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Update Emloyee", null, panel_1, null);
		panel_1.setLayout(null);
		 String[] typeUser = { "Employee" , "Manager" , "Tester" };
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(193, 0, 516, 436);
		panel_1.add(scrollPane_1);
		
		employeeList = new JTable();
	

		
		
		DefaultTableModel employeeModel = new DefaultTableModel();
		 Object[] columsNames = new Object[4];
	        
	        columsNames[0]="ID";
	         columsNames[1]="Name";
	          	columsNames[2]="Password";
	          	columsNames[3]="User Type";
	          
	           
		        
	            employeeModel.setColumnIdentifiers(columsNames);
	        Object[] updateData = new Object[4];
	        
	        for(int i = 0; i < e.getUsers().size(); i++){
	            
	        	updateData[0] =  e.getUsers().get(i).getId();
	        	updateData[1] = e.getUsers().get(i).getName();
	        	updateData[2] =  e.getUsers().get(i).getPassword();
	        	updateData[3] = e.getUsers().get(i).getUserType();
	             			
	             			employeeModel.addRow(updateData);
	            
	        }		
		
	        employeeList.setModel(employeeModel);
	        scrollPane_1.setViewportView(employeeList);
	        
	        id = new JTextField();
	        id.setBounds(29, 40, 143, 32);
	        panel_1.add(id);
	        id.setColumns(10);
	        
	        userName = new JTextField();
	        userName.setColumns(10);
	        userName.setBounds(29, 107, 143, 32);
	        panel_1.add(userName);
	        
	        password = new JTextField();
	        password.setColumns(10);
	        password.setBounds(30, 171, 143, 32);
	        panel_1.add(password);
	        
	        JLabel id_text = new JLabel("ID");
	        id_text.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        id_text.setBounds(29, 11, 46, 21);
	        panel_1.add(id_text);
	        
	        JLabel lblUserName = new JLabel("User Name");
	        lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblUserName.setBounds(29, 83, 123, 21);
	        panel_1.add(lblUserName);
	        
	        JLabel lblPassword = new JLabel("Password");
	        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblPassword.setBounds(28, 147, 123, 21);
	        panel_1.add(lblPassword);
	        
	        JButton btnNewButton_1 = new JButton("Add Users");
	        btnNewButton_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent es) {
	        		if(id.getText().length()==0 || userName.getText().length()==0 || password.getText().length()==0 || typeOfuser.getText().length()==0)
	        		{
	        			JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
	        		}
	        		else
	        		{
						
						
	        			boolean control = m.addUser(id.getText(), userName.getText(), password.getText(),typeOfuser.getText());
		        		if(control)
		        		{	
		        			JOptionPane.showMessageDialog(null, "Completing add users !");
		        			DefaultTableModel clearModel = (DefaultTableModel) employeeList.getModel();
							clearModel.setRowCount(0);
							 userName.setText("");
					            password.setText("");
					            typeOfuser.setText("");
					            id.setText("");
							for(int i = 0; i < e.getUsers().size(); i++){
								
					        	updateData[0] =  e.getUsers().get(i).getId();
					        	updateData[1] = e.getUsers().get(i).getName();
					        	updateData[2] =  e.getUsers().get(i).getPassword();
					        	updateData[3] = e.getUsers().get(i).getUserType();
					             			
					             			employeeModel.addRow(updateData);
					            
					        }		
						
						
					        employeeList.setModel(employeeModel);
							
		        			
		        		}
		        		else
		        		{
		        			JOptionPane.showMessageDialog(null, "Do not add users !");
		        		}
	        			
	        		}
	        	
	        	}
	        });
	        btnNewButton_1.setBounds(29, 278, 143, 41);
	        panel_1.add(btnNewButton_1);
	        
	        JButton btnDeleteUsers = new JButton("Delete Users");
	        btnDeleteUsers.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent es) {
	        		if(id.getText().length()==0 || userName.getText().length()==0 || password.getText().length()==0 || typeOfuser.getText().length()==0)
	        		{
	        			JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
	        		}else{
	        		boolean isTrue = m.deleteUser(id.getText());
	        		if(isTrue)
	        		{
	        			JOptionPane.showMessageDialog(null, "Delete users !");
	        			DefaultTableModel clearModel = (DefaultTableModel) employeeList.getModel();
						clearModel.setRowCount(0);
						for(int i = 0; i < e.getUsers().size(); i++){
							 userName.setText("");
					            password.setText("");
					            typeOfuser.setText("");
					            id.setText("");
				        	updateData[0] =  e.getUsers().get(i).getId();
				        	updateData[1] = e.getUsers().get(i).getName();
				        	updateData[2] =  e.getUsers().get(i).getPassword();
				        	updateData[3] = e.getUsers().get(i).getUserType();
				             			
				             			employeeModel.addRow(updateData);
				            
				        }		
					   employeeList.setModel(employeeModel);
	        		}
	        		else
	        		{
	        			JOptionPane.showMessageDialog(null, "Do not delete users !");
	        			
						
	        		}
	        		}
	        	}
	        });
	        btnDeleteUsers.setBounds(29, 330, 143, 41);
	        panel_1.add(btnDeleteUsers);
	        
	        JButton btnUpdateUsers = new JButton("Update Users");
	        btnUpdateUsers.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent es) {
	        		if(id.getText().length()==0 || userName.getText().length()==0 || password.getText().length()==0 || typeOfuser.getText().length()==0)
	        		{
	        			JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
	        		}
	        		else
	        		{
	        		String data =employeeModel.getValueAt(employeeList.getSelectedRow(), 0).toString();
	        		boolean isTrue = m.setUsers(data, userName.getText(), password.getText(), typeOfuser.getText(), id.getText());
	        		if(isTrue)
	        		{
	        			JOptionPane.showMessageDialog(null, "Update users !");
	        			DefaultTableModel clearModel = (DefaultTableModel) employeeList.getModel();
						clearModel.setRowCount(0);
						for(int i = 0; i < e.getUsers().size(); i++){
				            userName.setText("");
				            password.setText("");
				            typeOfuser.setText("");
				            id.setText("");
				        	updateData[0] =  e.getUsers().get(i).getId();
				        	updateData[1] = e.getUsers().get(i).getName();
				        	updateData[2] =  e.getUsers().get(i).getPassword();
				        	updateData[3] = e.getUsers().get(i).getUserType();
				             			
				             			employeeModel.addRow(updateData);
				            
				        }		
					   employeeList.setModel(employeeModel);
	        		}
	        		else
	        		{
	        			JOptionPane.showMessageDialog(null, "Do not Update users !");
	        		}
	        		}
	        	}
	        });
	        btnUpdateUsers.setBounds(29, 384, 143, 41);
	        panel_1.add(btnUpdateUsers);
	        
	        JLabel userType = new JLabel("User Type");
	        userType.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        userType.setBounds(29, 211, 123, 21);
	        panel_1.add(userType);
	        
	        typeOfuser = new JTextField();
	        typeOfuser.setBounds(29, 234, 143, 33);
	        panel_1.add(typeOfuser);
	        typeOfuser.setColumns(10);
	        
	        JPanel panel_3 = new JPanel();
	        tabbedPane.addTab("List Quality Reports", null, panel_3, null);
	        panel_3.setLayout(null);
	        
	        JScrollPane scrollPane_2 = new JScrollPane();
	        scrollPane_2.setBounds(0, 0, 709, 436);
	        panel_3.add(scrollPane_2);
	        
	       
	        

			QualityReport q =new QualityReport();
			
			DefaultTableModel reportModel = new DefaultTableModel();
			 Object[] columName = new Object[3];
		        
		        columName[0]="Code";
		         columName[1]="Product Name";
		          columName[2]="Reports";
		          
			        
		          reportModel.setColumnIdentifiers(columName);
		        Object[] reportData = new Object[3];
		        
		        for(int i = 0; i < q.getReport().size(); i++){
		            
		        	reportData[0] =  q.getReport().get(i).getProductCode();
		        	reportData[1] =  q.getReport().get(i).getProductName();
		        	reportData[2] =  q.getReport().get(i).getReports();
		        	
		        	reportModel.addRow(reportData);
		            
		        }		
		        table_1 = new JTable();
		        scrollPane_2.setViewportView(table_1);
		        table_1.setModel(reportModel);
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			TableColumnModel reportMod=table_1.getColumnModel();
			reportMod.getColumn(0).setPreferredWidth(30);
			reportMod.getColumn(1).setPreferredWidth(35);
			reportMod.getColumn(2).setPreferredWidth(200);
		
	        table_1.setRowHeight(100);
	        table_1.getColumnModel().getColumn(2).setCellRenderer(new WordWrapCellRenderer());
	        
	        
	       
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				TableModel model=table.getModel();
				
				productCode.setText(model.getValueAt(i, 0).toString());
				productName.setText(model.getValueAt(i, 1).toString());
				price.setText(model.getValueAt(i, 2).toString());
				propertiess.setText(model.getValueAt(i, 3).toString());
				qualityInfo.setText(model.getValueAt(i, 4).toString());
			}
		});
		
		employeeList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = employeeList.getSelectedRow();
				TableModel model=employeeList.getModel();
				
				id.setText(model.getValueAt(i, 0).toString());
				userName.setText(model.getValueAt(i, 1).toString());
				password.setText(model.getValueAt(i, 2).toString());
				typeOfuser.setText(model.getValueAt(i, 3).toString());
			}
		});
	}
}
