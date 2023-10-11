package MyPage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class editDb {
	
	public editDb(String name, String addr, String tel, String url, int price, String menu, String subj, int star) throws Exception {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(
					"jdbc:mysql://@222.119.100.81:3382/matvengers",
					"matvengers",
					"@codehows213"
					);
			
			String sql1 =  new StringBuilder()
					.append("UPDATE mlist SET ")
					.append("addr = ?, ")
					.append("tel = ?, ")
					.append("url = ?, ")
					.append("price = ?, ")
					.append("menu = ?, ")
					.append("subj = ? ")
					.append("WHERE name = ? ")
					.toString();


		    PreparedStatement pstmt = conn.prepareStatement(sql1);
		    
		    pstmt.setString(1, addr);
		    pstmt.setString(2, tel);
		    pstmt.setString(3, url);
		    pstmt.setInt(4, price);
		    pstmt.setString(5, menu);
		    pstmt.setString(6, subj);
		    pstmt.setString(7, name);
		    
		    String sql2 =  new StringBuilder()
					.append("UPDATE stars SET ")
					.append("star = ? ")
					.append("WHERE name = ? ")
					.toString();
		    
		    PreparedStatement pstmt2 = conn.prepareStatement(sql2);
		    
		    pstmt2.setInt(1, star);
		    pstmt2.setString(2, name);
		    
		    pstmt.executeUpdate();
		    pstmt2.executeUpdate();
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