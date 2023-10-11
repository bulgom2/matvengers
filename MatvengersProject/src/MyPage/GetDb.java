package MyPage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetDb {
	
	private String id;
	private String name;
	
	public GetDb(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String[] getInfo() {
		Connection conn = null;
		
		String[] info = new String[11];
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(
					"jdbc:mysql://@222.119.100.81:3382/matvengers",
					"matvengers",
					"@codehows213"
					);
			
			String sql = ""+ "SELECT * FROM mlist "
					+ "WHERE userid = ? and name = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);

			
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				info[0] = rs.getString("name");
				info[1] = rs.getString("addr");
				info[2] = rs.getString("tel");
				info[3] = rs.getString("url");
//				info[4] = rs.getString("m_img");
//				info[5] = rs.getString("v_img");
				info[6] = rs.getString("subj");
				info[7] = rs.getString("style");
				info[8] = rs.getString("menu");
				info[9] = rs.getString("price");
				info[10] = rs.getString("userid");
			}
			for(String m : info) {
				System.out.println(m);
			}
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
		return info;
	}
	public String getresult() {
		String s="";
		
		return s;
	}
}