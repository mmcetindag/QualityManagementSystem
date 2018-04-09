import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Employee extends Person{
	
	
	DbConn conn=new DbConn();
	PreparedStatement preparedStatement = null;

	public Employee(int id, String name, String password , String userType) {
		super(id, name, password , userType);
	}
	
	public Employee (){}
	public boolean addProduct(String productName , String productCode , String properties , int price , String qualityInfo) throws SQLException
	{
	
		String SQL = "INSERT INTO public.product"
				+ "(productCode, productName, properties, price , qualityinfo) VALUES"
				+ "(?,?,?,?,?)";
		try{
			
			Connection dbConnection = null;
			dbConnection = conn.getDBConnection();
			
			preparedStatement = dbConnection.prepareStatement(SQL);

			preparedStatement.setString(1, productCode);
			preparedStatement.setString(2, productName);
			preparedStatement.setString(3, properties);
			preparedStatement.setInt(4, price );
			preparedStatement.setString(5, qualityInfo );

			
			preparedStatement.executeUpdate();

			return true;

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			return false;

		} finally {

				preparedStatement.close();
			}
		}
public  ArrayList<Employee> getUsers(){
        
        ArrayList<Employee> users = new ArrayList<Employee>();
        
        Connection con = conn.getDBConnection();
        Statement st=null;
        ResultSet rs=null;
        Employee u;
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM users WHERE type='Employee'");
            while(rs.next()){
                u = new Employee(
                		rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getString("type")
                );
                users.add(u);
            }
             
        } catch (SQLException ex) {}
        finally{
        	try {
				st.close();
				con.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        
        }
        return users;
    }
	
	
	
	}
