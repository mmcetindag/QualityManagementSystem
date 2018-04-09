import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) throws SQLException {
		Product p=new Product();
		System.out.println(p.getProduct().get(1).getPrice());
		

	}

}
