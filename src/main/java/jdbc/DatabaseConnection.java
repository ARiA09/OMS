package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private Connection conn;

	public Connection getMySQLConnection() throws SQLException, ClassNotFoundException {
		String hostName = "localhost";

		String dbName = "oms";
		String userName = "root";
		String password = "navyseal";

		return getMySQLConnection(hostName, dbName, userName, password);
	}

	private Connection getMySQLConnection(String hostName, String dbName, String userName, String password)
			throws SQLException, ClassNotFoundException {
		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName + "?autoReconnect=true&useSSL=false";

		conn = DriverManager.getConnection(connectionURL, userName, password);
		return conn;
	}

	public void close(){
		if(conn != null){
	        try {
	            conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
}
