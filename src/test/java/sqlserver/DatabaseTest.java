package sqlserver;

import java.sql.*;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;


public class DatabaseTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String connectionUrl =
				"jdbc:sqlserver://EPINHYDW0C74\\SQLEXPRESS\\:1433;user=sa;password=Varsha@143;" +
						"databaseName=Automation;" +
						"encrypt=true;trustServerCertificate=true";
		Connection con = DriverManager.getConnection(connectionUrl);
		String query = "select * from Course";
		Statement statement = con.createStatement();
	ResultSet resultSet =statement.executeQuery(query);

		while (resultSet.next()) {
			System.out.println(

					"Name: " + resultSet.getString("course_name"));

			System.out.println(

					"Age:" + resultSet.getString("course_fees"));
		}
	}
}
