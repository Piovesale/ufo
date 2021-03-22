package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConncet {
	
	public static Connection getConnection() throws SQLException
		{
		return DriverManager.getConnection("jdbc:mysql://localhost/ufo_sightings?user=root&password=root");
		}
}
