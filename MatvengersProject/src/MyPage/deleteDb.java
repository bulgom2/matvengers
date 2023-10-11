package MyPage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class deleteDb {
	public deleteDb(String name) throws Exception {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(
					"jdbc:mysql://@222.119.100.81:3382/matvengers",
					"matvengers",
					"@codehows213"
					);
			
			String sql1 =  new StringBuilder()
					.append("DELETE FROM mlist ")
					.append("WHERE name = ?")
					.toString();


		    PreparedStatement pstmt = conn.prepareStatement(sql1);
		    
		    pstmt.setString(1, name);
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