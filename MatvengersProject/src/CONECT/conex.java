package CONECT;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;



public class conex {
	
//	jf jf1 = null;
//	
//	jf1.getName();
	public static void main(String[] args) {
		Connection conn = null;
		boolean end = true;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(
					"jdbc:mysql://@222.119.100.81:3382/matvengers",
					"matvengers",
					"@codehows213"
					);
			// insert 구현
			Scanner sc = new Scanner(System.in);
			while(end) {
			sc.reset();
			System.out.println("1: 데이터 생성, 2: 데이터 확인, 3: 주소로 쿼리, 4: 별점, 5: 별점순 정렬, 6: 종류별 정렬1, 7: 종류별 정렬2");
			int a = sc.nextInt();
			sc.nextLine();
			switch(a) {
				case 1: {

					tst t1 = new tst();
					t1.result0();
			
					break;
					}
				case 2: {
					ArrayList<MList> mlList = new ArrayList<MList>();
					tst t1 = new tst();
					mlList = t1.result1();
					mlList.forEach(m -> {
					System.out.println(m.getName()+m.getAddr()+m.getTel());
				});
				System.out.println(mlList.get(0).getName());


				break;
				}
				case 3: {
					tst t1 = new tst();
					ArrayList<MList> mlList = new ArrayList<MList>();
					mlList = t1.result2("의창구");
					mlList.forEach(m -> {
						System.out.println(m.getName());
					});
					System.out.println(mlList.get(0).getName());
				
					
					break;
				}
				case 4: {
					tst t1 = new tst();
					t1.result3();
					break;
				}
				case 5:{
					tst t1 = new tst();
					ArrayList<ms> mss = new ArrayList<ms>();
					mss = t1.result4("의창구");
					mss.forEach(ms1 -> {
					System.out.println(ms1.getName());
				});
				System.out.println(mss.get(0).getName());
					break;
				}
				case 6: {
					tst t1 = new tst();
					ArrayList<ms> mss1 = new ArrayList<ms>();
					t1.result5("t");
					mss1.forEach(ms1 -> {
					System.out.println(ms1.getName());
				});
				System.out.println(mss1.get(0).getName());
					break;
				}
				case 7: {
					ArrayList<MList> mlList1 = new ArrayList<MList>();
					tst t1 = new tst();
					mlList1 = t1.result6("의창구");
					mlList1.forEach(m -> {
					System.out.println(m.getName());
				});
				System.out.println(mlList1.get(0).getName());
					break;
				}
					
				default: {
					end = false;
				}
					
			}

			}
			
			sc.close();
			conn.close();
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
	//전체 다 받기

}
