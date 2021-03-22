package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SightingDAO {

	public List<String> readShapes(){
		
		try {
		
		Connection conn= DBConncet.getConnection();
		
		
		String query = "SELECT distinct shape FROM sighting WHERE shape<>'' ORDER BY shape ASC";
		
		PreparedStatement st = conn.prepareStatement(query);
		ResultSet res = st.executeQuery(query);

		
		List<String> formeUFO = new ArrayList<>();
		while(res.next()) {
			String forma = res.getString("shape");
			formeUFO.add(forma);
			}
		
		res.close();
		conn.close();
		
		 return formeUFO;
		 
		}catch(SQLException e) {
			throw new RuntimeException(e);	
		}
	}
	
	public int countByShape(String shape) {
		
		try {
			Connection conn= DriverManager.getConnection( "jdbc:mysql://localhost/ufo_sightings?user=root&password=root");

			String  sql2 = "SELECT COUNT (*) AS cnt FROM sighting WHERE shape= ? ";
			
			PreparedStatement st2 = conn.prepareStatement(sql2);
			st2.setString(1, shape);
			ResultSet res2 = st2.executeQuery();
			res2.first();
			int count = res2.getInt("cnt");
			
			st2.close();
			conn.close();
			
			return count;
			
		}catch (SQLException e) {
			throw new RuntimeException("Errore DB in countByShape",e);
		}
		
	}
	
}
