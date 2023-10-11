package LOGIN_UI;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class JoinDb {
	
	public JoinDb(String userId, String userPassword, String region) {
	
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(
					"jdbc:mysql://@222.119.100.81:3382/matvengers",
					"matvengers",
					"@codehows213"
					);
			
			String sql = ""+ "INSERT INTO users (userid, password, region) "
					+ "VALUES(?, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);

			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPassword);
			pstmt.setString(3, region);
			
			pstmt.executeUpdate();
			System.out.println("확인");
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
