package util;

import java.sql.*;
import java.util.*;


public class DataBaseUtils {
	Connection connection;

	public void openConnection() {
		ReadProperties readProperties = new ReadProperties("config");
		Properties props = new Properties();
		props.setProperty("user", readProperties.getProperty("userName"));
		props.setProperty("password", readProperties.getProperty("password"));
		props.setProperty("encrypt", "true");
		props.setProperty("trustServerCertificate", "true");
		props.setProperty("databaseName", "Automation");
		String connectionUrl = "jdbc:sqlserver://EPINHYDW0C74\\SQLEXPRESS\\:1433";
		try {
			connection = DriverManager.getConnection(connectionUrl, props);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public String getValueFromColumn(String query, String columnName) throws SQLException {
		if (connection == null) {
			openConnection();
		}
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		Statement statement = connection.createStatement();
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		return resultSet.getString(columnName);
	}

	public List<String> getValuesFromColumn(String query, String columnName) throws SQLException {
		if (connection == null) {
			openConnection();
		}
		List<String> listOfValues = new ArrayList<>();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			listOfValues.add(resultSet.getString(columnName));
		}
		return listOfValues;
	}

	public void updateTableData(String query) throws SQLException {
		if (connection == null) {
			openConnection();
		}
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.executeUpdate();
	}
}
