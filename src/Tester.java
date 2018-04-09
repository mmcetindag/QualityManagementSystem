import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Tester extends Person {
	DbConn conn = new DbConn();
	public Tester(int id, String name, String password , String userType) {
		super(id, name, password,userType);
		
		
		
	}
	public Tester(){}
	
	public boolean addTest(String id,String name , String report) 
	{
		PreparedStatement preparedStatement = null;
		Connection dbConnection = null;
		String SQL = "INSERT INTO test" + "(code,name,report) VALUES" + "(?,?,?)";
		try{
			
			dbConnection = conn.getDBConnection();
			preparedStatement = dbConnection.prepareStatement(SQL);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, report);
			
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
	
	public boolean deleteProduct(String id)  {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String deleteSQL = "DELETE FROM product WHERE productcode = ?";

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
