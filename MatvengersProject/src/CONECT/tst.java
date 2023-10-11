package CONECT;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;


public class tst {
	Connection conn = null;
	
	public tst() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(
					"jdbc:mysql://@222.119.100.81:3382/matvengers",
					"matvengers",
					"@codehows213"
					);
		}catch(Exception e) {}
	}
	
	public void result0() throws Exception{
		Scanner sc = new Scanner(System.in);
		String sql = ""+ "INSERT INTO mlist (name, addr, tel, url, m_img,"
				+ "v_img, subj, style, menu, price, userid) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);

		
		System.out.print("상호명: ");
		pstmt.setString(1, sc.nextLine());
		System.out.print("주소: ");
		pstmt.setString(2, sc.nextLine());
		System.out.print("전화번호: ");
		pstmt.setString(3, sc.nextLine());
		System.out.print("URL: ");
		pstmt.setString(4, sc.nextLine());
		System.out.print("메뉴 사진: ");
		pstmt.setBlob(5, new FileInputStream(sc.nextLine()));
		System.out.print("뷰 사진: ");
		pstmt.setBlob(6, new FileInputStream(sc.nextLine()));
		System.out.print("종류: ");
		pstmt.setString(7, sc.nextLine());
		System.out.print("스타일: ");
		pstmt.setString(8, sc.nextLine());
		System.out.print("대표 메뉴: ");
		pstmt.setString(9, sc.nextLine());
		System.out.print("가격: ");
		pstmt.setInt(10, sc.nextInt());
		sc.nextLine();
		System.out.print("유저 아이디: ");
		pstmt.setString(11, sc.nextLine());

		pstmt.executeUpdate();
	}
	// 전부 다 출력
	ArrayList<MList> mlList0 = new ArrayList<MList>();
	public ArrayList<MList> result1() throws Exception{

		String sql = ""+
					"SELECT name, addr, tel, url, m_img, v_img, subj, style, menu, price, userid "+
					"FROM mlist";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			MList ml = new MList();

			ml.setName(rs.getString("name"));
			ml.setAddr(rs.getString("addr"));
			ml.setTel(rs.getString("tel"));
			ml.setUrl(rs.getString("url"));
			ml.setM_img(rs.getBlob("m_img"));
			ml.setV_img(rs.getBlob("v_img"));
			ml.setSubj(rs.getString("subj"));
			ml.setStyle(rs.getString("style"));
			ml.setMenu(rs.getString("menu"));
			ml.setPrice(rs.getInt("price"));
			ml.setUserid(rs.getString("userid"));
			
			mlList0.add(ml);
		}
		return mlList0;
	}
	
	ArrayList<MList> mlList = new ArrayList<MList>();
	// 상호명 주소 전화번호 평균평점 대표메뉴 종류 스타일
	public ArrayList<MList> result2(String a) throws Exception{
		String sql = ""+
				"SELECT name, addr, tel, menu, price, subj, style "+
				"FROM mlist WHERE addr like ?";
	
		PreparedStatement pstmt = conn.prepareStatement(sql);
	
		pstmt.setString(1, "%"+a+"%");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			MList ml = new MList();
		
			ml.setName(rs.getString("name"));
			ml.setAddr(rs.getString("addr"));
			ml.setTel(rs.getString("tel"));
			
			ml.setMenu(rs.getString("menu"));
			ml.setPrice(rs.getInt("price"));
			ml.setSubj(rs.getString("subj"));
			ml.setStyle(rs.getString("style"));
			
			mlList.add(ml);
		}
		return mlList;
	}
	
	// 별점순으로 정렬 체크 (b에 받아옴)

		
	//별점 주기
	public void result3() throws Exception{
		Scanner sc = new Scanner(System.in);
		String sql = ""+
				"INSERT INTO stars values(?, ?, ?, ?)";
	
		PreparedStatement pstmt = conn.prepareStatement(sql);
		System.out.print("평가할 식당: ");
		pstmt.setString(1, sc.nextLine());
		System.out.print("userid: ");
		pstmt.setString(2, sc.nextLine());
		System.out.println("평점(5점 만점): ");
		pstmt.setInt(3, sc.nextInt());
		sc.nextLine();
		System.out.println("한줄평: ");
		pstmt.setString(4, sc.nextLine());

		pstmt.executeUpdate();
		System.out.println();
		

	}
	ArrayList<ms> mss = new ArrayList<ms>();
	public  ArrayList<ms> result4(String a) throws Exception{
		String sql = ""+
				"select stars.name, avg(stars.star) from stars "+
				" inner join mlist"+
				" on stars.name = mlist.name"+
				" where mlist.addr like ?"+
				" group by mlist.name"+
				" order by avg(stars.star) desc";
	
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1,"%"+a+"%" );
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			ms ms = new ms();
			ms.setName(rs.getString("name"));
			ms.setStar(rs.getInt("avg(stars.star)"));

			mss.add(ms);
		}
		return mss;
	}
	//해당 종류만 별점순 정렬
	ArrayList<ms> mss1 = new ArrayList<ms>();
	public void result5(String a) throws Exception{

		String sql = ""+
				"select stars.name, avg(stars.star) from stars "+
				" inner join mlist"+
				" on stars.name = mlist.name"+
				" where mlist.subj = ?"+
				" group by mlist.name"+
				" order by avg(stars.star) desc";
	
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, a);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			ms ms = new ms();
			ms.setName(rs.getString("name"));
			ms.setStar(rs.getInt("avg(stars.star)"));
			mss1.add(ms);
		}
		
	}
	//해당 지역의 종류별로 정렬
	ArrayList<MList> ml1 = new ArrayList<MList>();
	public ArrayList<MList> result6(String a) throws Exception{
		String sql = ""+
				"select  name, addr, tel, menu, price, subj, style " + 
				" FROM mlist WHERE addr like ? order by style";
	
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, "%"+a+"%");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			MList ml = new MList();
		
			ml.setName(rs.getString("name"));
			ml.setAddr(rs.getString("addr"));
			ml.setTel(rs.getString("tel"));
	//		ml.setM_img(rs.getBlob("m_img"));
	//		ml.setV_img(rs.getBlob("v_img"));
			
			ml.setMenu(rs.getString("menu"));
			ml.setPrice(rs.getInt("price"));
			ml.setSubj(rs.getString("subj"));
			ml.setStyle(rs.getString("style"));
			ml1.add(ml);
			
		}
		return ml1;
	}
	   
    ArrayList<MList> mylist = new ArrayList<MList>();
    public ArrayList<MList> mypage1(String a, String b) throws Exception{
       String sql = ""+
             "select  name, addr, tel, menu, price, subj, style, userid " + 
             " FROM mlist WHERE userid = ? and addr like ? order by name";
    
       PreparedStatement pstmt = conn.prepareStatement(sql);
       mylist.clear();
       pstmt.setString(1, a);
       pstmt.setString(2, "%"+b+"%");
       ResultSet rs = pstmt.executeQuery();
       while(rs.next()) {
          MList ml = new MList();
       
          ml.setName(rs.getString("name"));
          ml.setAddr(rs.getString("addr"));
          ml.setTel(rs.getString("tel"));
          ml.setMenu(rs.getString("menu"));
          ml.setPrice(rs.getInt("price"));
          ml.setSubj(rs.getString("subj"));
          ml.setStyle(rs.getString("style"));
          ml.setUserid(rs.getString("userid"));
          mylist.add(ml);
          
       }
       return mylist;
    }
    
    ArrayList<stars> star = new ArrayList<stars>();
    public ArrayList<stars> mypage2(String userid) throws Exception{
       String sql = ""+
             "select  name, star " + 
             " FROM stars WHERE userid = ? order by name";
       star.clear();
       PreparedStatement pstmt = conn.prepareStatement(sql);
       
       pstmt.setString(1, userid);
       ResultSet rs = pstmt.executeQuery();
       while(rs.next()) {
          stars st = new stars();
       
          st.setName(rs.getString("name"));
          st.setStar(rs.getDouble("star"));
          star.add(st);
          
       }
       return star;
    }
}

























