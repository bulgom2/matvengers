package ADD_UI;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class AddDb {
	
	public AddDb(String Name, String Addr, String Tel, String Url, String M_img, String V_img, String Subj, String Style, String Menu, int Price, String Userid) {
	
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(
					"jdbc:mysql://@222.119.100.81:3382/matvengers",
					"matvengers",
					"@codehows213"
					);
			
			String sql = ""+ "INSERT INTO mlist (name, addr, tel, url, m_img,"
					+ "v_img, subj, style, menu, price, userid) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);

			
			pstmt.setString(1, Name);
			pstmt.setString(2, Addr);
			pstmt.setString(3, Tel);
			pstmt.setString(4, Url);
			pstmt.setString(5, M_img);
			pstmt.setString(6, V_img);
			pstmt.setString(7, Subj);
			pstmt.setString(8, Style);
			pstmt.setString(9, Menu);
			pstmt.setInt(10, Price);
			pstmt.setString(11, Userid);

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
