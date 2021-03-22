package db;

import java.util.List;

public class TestDB {
	
	public static void main(String[] args) {
		
		SightingDAO dao = new SightingDAO();
		
		List<String> forem = dao.readShapes();
		
		for(String f : forem)
			{
			int count = dao.countByShape(f);
			System.out.println("Ufo "+ f + " : "+ count );
			}
	}
}
