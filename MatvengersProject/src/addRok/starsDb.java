package addRok;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class starsDb {
	
	public starsDb(String Name, String Userid, int Star, String Cmt) {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(
					"jdbc:mysql://@222.119.100.81:3382/matvengers",
					"matvengers",
					"@codehows213"
					);
			
			String sql = ""+ "INSERT INTO stars (name, userid, star, cmt) "
					+ "VALUES(?, ?, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);

			
			pstmt.setString(1, Name);
			pstmt.setString(2, Userid);
			pstmt.setInt(3, Star);
			pstmt.setString(4, Cmt);

			pstmt.executeUpdate();
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(conn != null) {
				try {
					conn.close();
					
				}
				catch (SQLException e) {}
			}
		}
	}
	public String getresult() {
		String s="";
		
		return s;
	}
}
