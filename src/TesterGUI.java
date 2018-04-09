import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.RowFilter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.Color;

public class TesterGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField code;
	private JTextField name;
	private JTextField searchField;
	private JTable table_1;
	private JTextField pcode;
	private JTextField pname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesterGUI frame = new TesterGUI();
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
	public TesterGUI() {
		Tester t = new Tester();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 714, 464);
		contentPane.add(tabbedPane);
		
		
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
		
			
			JPanel panel_2 = new JPanel();
			tabbedPane.addTab("Home", null, panel_2, null);
			panel_2.setLayout(null);
			
			JLabel lblNewLabel_3 = new JLabel("Welcome Tester Panel");
			lblNewLabel_3.setForeground(Color.DARK_GRAY);
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lblNewLabel_3.setBounds(202, 87, 311, 47);
			panel_2.add(lblNewLabel_3);
			
			JLabel lblQualityManagementSystem = new JLabel("Product Quality Management System");
			lblQualityManagementSystem.setForeground(Color.DARK_GRAY);
			lblQualityManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lblQualityManagementSystem.setBounds(101, 29, 509, 47);
			panel_2.add(lblQualityManagementSystem);
			
			JLabel lblNewLabel_4 = new JLabel("-You can testing product on Test Product tab menu");
			lblNewLabel_4.setFont(new Font("SansSerif", Font.ITALIC, 17));
			lblNewLabel_4.setBounds(60, 179, 407, 29);
			panel_2.add(lblNewLabel_4);
			
			JLabel lblyouCanSend = new JLabel("-You can send back low-quality product on Send Back Product tab menu");
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
	        
   
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Test Product", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 132, 709, 304);
		panel.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(productModel);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		TableColumnModel columnModel=table.getColumnModel();
		table.setRowHeight(100);
	     columnModel.getColumn(0).setPreferredWidth(30);
	        columnModel.getColumn(2).setPreferredWidth(35);
	        columnModel.getColumn(3).setPreferredWidth(200);
	        columnModel.getColumn(4).setPreferredWidth(250);
		
		JLabel lblNewLabel = new JLabel("Product Code");
		lblNewLabel.setBounds(47, 11, 98, 14);
		panel.add(lblNewLabel);
		
		code = new JTextField();
		code.setBounds(47, 25, 111, 30);
		panel.add(code);
		code.setColumns(10);
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setBounds(182, 11, 98, 14);
		panel.add(lblProductName);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(182, 25, 126, 30);
		panel.add(name);
		
		JLabel lblNewLabel_1 = new JLabel("Test Report");
		lblNewLabel_1.setBounds(354, 11, 345, 14);
		panel.add(lblNewLabel_1);
		
		JTextPane report = new JTextPane();
		report.setBounds(354, 25, 345, 85);
		panel.add(report);
		
		JButton btnNewButton = new JButton("Add Test Report");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(code.getText().length()==0 || name.getText().length()==0 || report.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
				}
				else
				{
					boolean isTrue = t.addTest(code.getText(), name.getText(), report.getText());
					if(isTrue)
					{				
						JOptionPane.showMessageDialog(null, "Added to reports !");
						code.setText("");
						name.setText("");
						report.setText("");
					}
					
					else
					{
						JOptionPane.showMessageDialog(null, "Do not added to reports !");
					}
				}
				
			}
				
		});
		btnNewButton.setBounds(182, 82, 126, 30);
		panel.add(btnNewButton);
		
		searchField = new JTextField();
		searchField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				DefaultTableModel search=(DefaultTableModel) table.getModel();
				String searchKey = searchField.getText().toLowerCase();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(search);
				table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(searchKey));
			}
		});
		searchField.setColumns(10);
		searchField.setBounds(47, 82, 111, 30);
		panel.add(searchField);
		
		JLabel lblSearch = new JLabel("Search Products");
		lblSearch.setBounds(47, 62, 112, 14);
		panel.add(lblSearch);
		table.getColumnModel().getColumn(4).setCellRenderer(new WordWrapCellRenderer());
		table.getColumnModel().getColumn(3).setCellRenderer(new WordWrapCellRenderer());
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Send Back Product", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 67, 709, 369);
		

		
		
	        
	        
	     		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(productModel);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		TableColumnModel columnsModel=table_1.getColumnModel();
        columnsModel.getColumn(0).setPreferredWidth(30);
        columnsModel.getColumn(2).setPreferredWidth(35);
        columnsModel.getColumn(3).setPreferredWidth(200);
        columnsModel.getColumn(4).setPreferredWidth(250);
        table_1.setRowHeight(100);
        table_1.getColumnModel().getColumn(4).setCellRenderer(new WordWrapCellRenderer());
        table_1.getColumnModel().getColumn(3).setCellRenderer(new WordWrapCellRenderer());
    	scrollPane_1.setViewportView(table_1);
		panel_1.add(scrollPane_1);
		
		JLabel lblNewLabel_2 = new JLabel("Product Code");
		lblNewLabel_2.setBounds(10, 11, 117, 14);
		panel_1.add(lblNewLabel_2);
		
		pcode = new JTextField();
		pcode.setBounds(10, 36, 86, 20);
		panel_1.add(pcode);
		pcode.setColumns(10);
		
		pname = new JTextField();
		pname.setColumns(10);
		pname.setBounds(137, 36, 104, 20);
		panel_1.add(pname);
		
		JLabel lblProductName_1 = new JLabel("Product Name");
		lblProductName_1.setBounds(137, 11, 104, 14);
		panel_1.add(lblProductName_1);
		
		JButton btnNewButton_1 = new JButton("Send Back Product");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pcode.getText().length()==0 || pname.getText().length()==0)
				{	
					JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
					
				}
				else
				{
					boolean isTrue = t.deleteProduct(pcode.getText());
					if(isTrue)
					{
						JOptionPane.showMessageDialog(null, "Send back low-quality products !");
						DefaultTableModel clearModel = (DefaultTableModel) table.getModel();
						clearModel.setRowCount(0);
						 for(int i = 0; i < p.getProduct().size(); i++){
						        
						        rowData[0] =  p.getProduct().get(i).getProductCode();
						         rowData[1] =  p.getProduct().get(i).getProductName();
						         	rowData[2] =  p.getProduct().get(i).getPrice();
						         		rowData[3] =  p.getProduct().get(i).getProperties();
						         			rowData[4] =  p.getProduct().get(i).getQualityInfo();
						         				productModel.addRow(rowData);
						        
						    }
						 pcode.setText("");
						 pname.setText("");
						 table_1.setModel(productModel);
						 table.setModel(productModel);
						 
					
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Don't send back low-quality products !");
					}
				}
				
			}
		});
		btnNewButton_1.setBounds(251, 35, 152, 23);
		panel_1.add(btnNewButton_1);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table_1.getSelectedRow();
				TableModel model=table_1.getModel();
				
				pcode.setText(model.getValueAt(i, 0).toString());
				pname.setText(model.getValueAt(i, 1).toString());
				
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				TableModel model=table.getModel();
				
				code.setText(model.getValueAt(i, 0).toString());
				name.setText(model.getValueAt(i, 1).toString());
				
			}
		});
	}
}
