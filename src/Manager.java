	import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Manager extends Person {
	DbConn conn = new DbConn();
	public Manager(int id, String name, String password , String userType) {
		super(id, name, password,userType);

		
		
	}
	
	public Manager(){}
	

	public boolean setProduct(String code , String name , String properties , int price , String qualtyInfo , String newCode)  {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String updateSQL = "update product set productcode = ? , productname = ? , properties = ? , price = ? , qualityinfo = ?  where productcode = ?";

		try {
			dbConnection = conn.getDBConnection();
			preparedStatement = dbConnection.prepareStatement(updateSQL);
			preparedStatement.setString(1, newCode);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, properties);
			preparedStatement.setInt(4, price);
			preparedStatement.setString(5, qualtyInfo);
			preparedStatement.setString(6, code);
			
			preparedStatement.executeUpdate();

			return true;

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			return false;

		} finally {

			try {
				dbConnection.close();
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
	}
	
		public boolean setUsers(String id , String name , String password , String userType , String newID  )  {

			Connection dbConnection = null;
			PreparedStatement preparedStatement = null;

			String updateSQL = "update users set name = ? , id = ? , type = ? , password = ?  where id = ?";

			try {
				dbConnection = conn.getDBConnection();
				preparedStatement = dbConnection.prepareStatement(updateSQL);
				preparedStatement.setString(1, name);
				preparedStatement.setString(2, newID);
				preparedStatement.setString(3, userType);
				preparedStatement.setString(4, password);
				preparedStatement.setString(5, id);
				
				preparedStatement.executeUpdate();

				return true;

			} catch (SQLException e) {

				System.out.println(e.getMessage());
				return false;

			} finally {

				try {
					dbConnection.close();
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
			}
		
			

	}
		
		public boolean addUser(String id,String name , String password, String userType) 
		{
			PreparedStatement preparedStatement = null;
			Connection dbConnection = null;
			String SQL = "INSERT INTO users" + "(name,id,password,type) VALUES" + "(?,?,?,?)";
			try{
				
				dbConnection = conn.getDBConnection();
				preparedStatement = dbConnection.prepareStatement(SQL);
				preparedStatement.setString(2, id);
				preparedStatement.setString(1, name);
				preparedStatement.setString(3, password);
				preparedStatement.setString(4, userType);
				preparedStatement.executeUpdate();
			
				return true;

			} catch (SQLException e) {

				System.out.println(e.getMessage());
				return false;

			} finally {
				try {
					dbConnection.close();
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		}
		
		public boolean deleteUser(String id)  {

			Connection dbConnection = null;
			PreparedStatement preparedStatement = null;

			String deleteSQL = "DELETE FROM USERS WHERE id = ?";

			try {
				dbConnection = conn.getDBConnection();
				preparedStatement = dbConnection.prepareStatement(deleteSQL);
				preparedStatement.setString(1, id);
				preparedStatement.executeUpdate();
				return true;

			} catch (SQLException e) {

				System.out.println(e.getMessage());
				return false;

			} finally {

				try {
					dbConnection.close();
					preparedStatement.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		
			}

		}
}
