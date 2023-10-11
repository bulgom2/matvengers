package LOGIN_UI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

// 아이디 중복확인

public class IdConfirm extends JDialog {
	
	private JButton btnClose;
	private String id;
	private JLabel confirmAlarm;
	public static boolean check = false;
	
	public IdConfirm(JFrame owner, String id) {
		super(owner);
		this.id = id;
		this.setTitle("중복 확인");
		this.setSize(100, 100);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setResizable(false);				// 다이알로그 크기 변경 안되게 설정
		this.setModal(true);					// 모달 방식
		this.setLocation(						// 다이알로그가 부모창 중앙에 배치
				owner.getLocationOnScreen().x + (owner.getWidth() - this.getWidth()) / 2,
				owner.getLocationOnScreen().y + (owner.getHeight() - this.getHeight()) / 2
		);
		
		if(id.isEmpty()) {		// 빈칸이 입력되었을 경우
			this.getContentPane().add(new JLabel("값을 입력해 주세요"), BorderLayout.CENTER);
		}
		else {					// 값이 입력되었을 경우
			this.getContentPane().add(getConfirmAlarm(), BorderLayout.CENTER);
		}
			this.getContentPane().add(getBtnClose(), BorderLayout.SOUTH);
	}
	
	// 입력한 값이 데이터 베이스에 이미 존재하는지 확인하는 함수
	public JLabel getConfirmAlarm() {
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(
					"jdbc:mysql://@222.119.100.81:3382/matvengers",
					"matvengers",
					"@codehows213"
					);
			
			String sql = ""+ "select userid from users "
					+ "where userid = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if(!rs.next()) {		// 데이터베이스에 값이 존재하지 않을 경우
				confirmAlarm = new JLabel("사용 가능");
				check = true;
			}
			else {					// 데이터베이스에 값이 존재할 경우
				confirmAlarm = new JLabel("사용 불가");
				check = false;
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
		return confirmAlarm;		// 결과값 리턴
	}
	
	public JButton getBtnClose() {
		if(btnClose == null) {
			btnClose = new JButton();
			btnClose.setText("닫기");
			btnClose.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					IdConfirm.this.dispose();
				}
			});
		}
		return btnClose;
	}
}