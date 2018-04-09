import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QualityReport {

	public String productCode,productName,reports;
	DbConn conn = new DbConn();
	
	public QualityReport() {
		
	}


	public QualityReport(String productCode, String productName, String reports) {
		
		this.productCode = productCode;
		this.productName = productName;
		this.reports = reports;
	}


	public String getProductCode() {
		return productCode;
	}


	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getReports() {
		return reports;
	}


	public void setReports(String reports) {
		this.reports = reports;
	}
	
	 public  ArrayList<QualityReport> getReport(){
	        
	        ArrayList<QualityReport> report = new ArrayList<QualityReport>();   
	        Connection con = conn.getDBConnection(); 
	        Statement st=null; 
	        ResultSet rs=null;
	        QualityReport p;
	        
	        try {
	            st = con.createStatement();
	            rs = st.executeQuery("SELECT * FROM test");
	            
	            while(rs.next()){
	                p = new QualityReport(
	                        rs.getString("code"),
	                        rs.getString("name"),
	                        rs.getString("report")
	                       
	                );
	                report.add(p);
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
	        return report;
	    }
	
}
