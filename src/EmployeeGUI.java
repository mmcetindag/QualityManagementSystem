import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EmployeeGUI extends JFrame {

	private JPanel contentPane;
	private JTextField productCode;
	private JTextField productName;
	private JTextField price;
	
	Employee emp = new Employee(1 , "" , "", "");
	private JTable table;
	private JTextField searchField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeGUI frame = new EmployeeGUI();
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
	public EmployeeGUI() {
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
		
		Product p =new Product();
		
		DefaultTableModel productModel = new DefaultTableModel();
		Object[] columsName = new Object[5];
	        
	        columsName[0]="Code";
	         columsName[1]="Product Name";
	          columsName[2]="Price";
	           columsName[3]="Properties";
	            columsName[4]="Quality Info";
		        
	        productModel.setColumnIdentifiers(columsName);
	        Object[] rowData = new Object[5];
	        
	        for(int i = 0; i < p.getProduct().size(); i++){
	            
	            rowData[0] =  p.getProduct().get(i).getProductCode();
	             rowData[1] =  p.getProduct().get(i).getProductName();
	             	rowData[2] =  p.getProduct().get(i).getPrice();
	             		rowData[3] =  p.getProduct().get(i).getProperties();
	             			rowData[4] =  p.getProduct().get(i).getQualityInfo();
	             productModel.addRow(rowData);
	            
	        }		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 54, 689, 371);
		
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(productModel);
		table.setEnabled(false);
		TableColumnModel columnModel=table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(30);
        columnModel.getColumn(2).setPreferredWidth(35);
        columnModel.getColumn(3).setPreferredWidth(200);
        columnModel.getColumn(4).setPreferredWidth(250);
        table.setRowHeight(100);
        table.getColumnModel().getColumn(4).setCellRenderer(new WordWrapCellRenderer());
        table.getColumnModel().getColumn(3).setCellRenderer(new WordWrapCellRenderer());
		
		JLabel lblNewLabel_3 = new JLabel("Welcome Employee Panel");
		lblNewLabel_3.setForeground(Color.DARK_GRAY);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(166, 87, 374, 47);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblQualityManagementSystem = new JLabel("Product Quality Management System");
		lblQualityManagementSystem.setForeground(Color.DARK_GRAY);
		lblQualityManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblQualityManagementSystem.setBounds(101, 29, 509, 47);
		panel_2.add(lblQualityManagementSystem);
		
		JLabel lblNewLabel_4 = new JLabel("-You can add product on Add Product tab menu");
		lblNewLabel_4.setFont(new Font("SansSerif", Font.ITALIC, 17));
		lblNewLabel_4.setBounds(60, 179, 522, 29);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblyouCanSend = new JLabel("-You can list and search product on List/Search Product Menu");
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
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Add Product", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Product Code");
		lblNewLabel.setBounds(10, 11, 89, 14);
		panel_1.add(lblNewLabel);
		
		productCode = new JTextField();
		productCode.setBounds(10, 37, 86, 20);
		panel_1.add(productCode);
		productCode.setColumns(10);
		
		productName = new JTextField();
		productName.setColumns(10);
		productName.setBounds(121, 37, 99, 20);
		panel_1.add(productName);
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setBounds(121, 11, 89, 14);
		panel_1.add(lblProductName);
		
		JLabel lblProperties = new JLabel("Properties");
		lblProperties.setBounds(10, 68, 210, 14);
		panel_1.add(lblProperties);
		
		JTextPane properties = new JTextPane();
		properties.setBounds(10, 96, 210, 157);
		panel_1.add(properties);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(249, 11, 89, 14);
		panel_1.add(lblPrice);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(249, 37, 99, 20);
		panel_1.add(price);
		
		JLabel lblQualityInfo = new JLabel("Quality \u0130nfo");
		lblQualityInfo.setBounds(249, 68, 210, 14);
		panel_1.add(lblQualityInfo);
		
		JTextPane qualityInfo = new JTextPane();
		qualityInfo.setBounds(249, 96, 210, 157);
		panel_1.add(qualityInfo);
		
		JButton addProduct = new JButton("Add Product");
		addProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					if(productName.getText().length()==0 || productCode.getText().length()==0 || properties.getText().length()==0 || price.getText().length()==0 || qualityInfo.getText().length()==0)
					{	
						JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
						
					}
					else
					{
						try {boolean control = emp.addProduct(productName.getText(), productCode.getText(), properties.getText(), Integer.parseInt(price.getText()), qualityInfo.getText());
						if(control)
						{	
							JOptionPane.showMessageDialog(null, "Completing add product !");
							String t=null;
							productName.setText(t);
							productCode.setText(t);
							properties.setText(t);
							price.setText(null);
							qualityInfo.setText(t);
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
							table.setModel(productModel);
							
						}
						else
							JOptionPane.showMessageDialog(null, "You don't add product !");
					} catch (NumberFormatException | SQLException e1) {
						
						e1.printStackTrace();
					}
					}
					
				
			}
		});
		addProduct.setBounds(132, 330, 187, 42);
		panel_1.add(addProduct);
		
		
		JPanel panel_3 = new JPanel();
	
		tabbedPane.addTab("List/Search Product", null, panel_3, null);
		panel_3.setLayout(null);
		panel_3.add(scrollPane);
		
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
		searchField.setBounds(165, 23, 111, 20);
		panel_3.add(searchField);
		searchField.setColumns(10);
		panel_3.add(scrollPane);
		JLabel lblSearchProduct = new JLabel("Search Product");
		lblSearchProduct.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSearchProduct.setBounds(10, 26, 140, 14);
		panel_3.add(lblSearchProduct);
		
		
	}
}
class WordWrapCellRenderer extends JTextArea implements TableCellRenderer {
	  
	private static final long serialVersionUID = 1L;

	WordWrapCellRenderer() {
        setLineWrap(true);
        setWrapStyleWord(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value.toString());
        setSize(table.getColumnModel().getColumn(column).getWidth(), getPreferredSize().height);
        if (table.getRowHeight(row) != getPreferredSize().height) {
            table.setRowHeight(row, getPreferredSize().height);
        }
        return this;
    }
}