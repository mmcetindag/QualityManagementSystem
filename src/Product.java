
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Product {
	public String productName;
	public String productCode;
	public String properties;
	public int price;
	public String qualityInfo;
	DbConn conn = new DbConn();
	public Product(){}
	public Product(String productName, String productCode, String properties, int price, String qualityInfo) {
		super();
		this.productName = productName;
		this.productCode = productCode;
		this.properties = properties;
		this.price = price;
		this.qualityInfo=qualityInfo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProperties() {
		return properties;
	}

	public void setProperties(String properties) {
		this.properties = properties;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getQualityInfo() {
		return qualityInfo;
	}

	public void setQualityInfo(String qualityInfo) {
		this.qualityInfo = qualityInfo;
	}
	
	 public  ArrayList<Product> getProduct(){
	        
	        ArrayList<Product> product = new ArrayList<Product>();   
	        Connection con = conn.getDBConnection(); 
	        Statement st=null; 
	        ResultSet rs=null;
	        Product p;
	        
	        try {
	            st = con.createStatement();
	            rs = st.executeQuery("SELECT * FROM product");
	            
	            while(rs.next()){
	                p = new Product(
	                        rs.getString("productname"),
	                        rs.getString("productcode"),
	                        rs.getString("properties"),
	                        rs.getInt("price"),
	                        rs.getString("qualityinfo")
	                );
	                product.add(p);
	            }
	             
	        } catch (SQLException ex) {
	            
	        }
	        finally{
	            try {
					con.close();
					st.close();
		        	rs.close();
		        
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	
	        }
	        return product;
	    }
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
	
}
