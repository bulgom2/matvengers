package LOGIN_UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginScreen extends JFrame {
	
	ImageIcon icon;
	ImageIcon icon2;
	ImageIcon title;
	
	private JTextField idInput;
	private JPasswordField pwdInput;

	public LoginScreen() {
		
//		JPanel bg = new JPanel();
		
		title = new ImageIcon(".\\images\\captain2.png");
		setIconImage(title.getImage());
		
		
		setTitle("MATVENGERS");
		JPanel title = new JPanel();
		title.add(new JPanel());
		
		JLabel login = new JLabel();
		login.setForeground(new Color(5, 0, 153));
		login.setFont(new Font("Gaegu", Font.BOLD, 25));
		title.add(login);
		
		JPanel jp1 = new JPanel();
		jp1.setLayout(new GridLayout(3, 2));
		jp1.repaint();
		
		JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel jlb1 = new JLabel("아이디 : ", JLabel.CENTER);
		jlb1.setFont(new Font("Gaegu", Font.BOLD, 20));
		idPanel.add(jlb1);
		
		JPanel idPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		idInput = new JTextField(10);
			
		idPanel2.add(idInput);
		
		jp1.add(idPanel);
		jp1.add(idPanel2);
		
		
		JPanel pwdPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel jlb2 = new JLabel("비밀번호 : ", JLabel.CENTER);
		jlb2.setFont(new Font("Gaegu", Font.BOLD, 20));
		
		JPanel pwdPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pwdInput = new JPasswordField(10);
		
		pwdPanel.add(jlb2);
		pwdPanel2.add(pwdInput);
		
		jp1.add(pwdPanel);
		jp1.add(pwdPanel2);
		
		JPanel loginPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton jLogin = new JButton("로그인");
		Image loginImg  = new ImageIcon(LoginScreen.class.getResource("/image/login.png")).getImage();
	    ImageIcon loginIcon = new ImageIcon(loginImg.getScaledInstance(70, 35, Image.SCALE_SMOOTH));
	    jLogin = new JButton(loginIcon);
	    jLogin.setBorderPainted(false);
	    jLogin.setContentAreaFilled(false);
		
		JPanel joinPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton join = new JButton("회원가입");
		Image joinImg  = new ImageIcon(LoginScreen.class.getResource("/image/join.png")).getImage();
	    ImageIcon joinIcon = new ImageIcon(joinImg.getScaledInstance(70, 35, Image.SCALE_SMOOTH));
	    join = new JButton(joinIcon);
	    join.setBorderPainted(false);
	    join.setContentAreaFilled(false);
		
		loginPanel.add(jLogin);
		joinPanel.add(join);
		
		jp1.add(loginPanel);
		jp1.add(joinPanel);
		
		JPanel jp2 = new JPanel();
		jp2.setLayout(new FlowLayout());
		jp2.add(jp1);
		
		setLayout(new BorderLayout());
		
		this.getContentPane().add(title, BorderLayout.SOUTH);
		
		add(title, BorderLayout.CENTER);
		this.getContentPane().add(new myLabel(), BorderLayout.CENTER);
		add(jp2, BorderLayout.SOUTH);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - 300) / 2, (screenSize.height - 600) / 2, 300, 600);
		
		setResizable(false);  		// 화면 크기 고정하는 작업
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		
		
		jLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String id = idInput.getText();
				String pw = new String(pwdInput.getPassword());
				if(id.isEmpty() && pw.isEmpty()) {
					JOptionPane.showMessageDialog(null, "아이디 혹은 비밀번호를 입력해주세요");
				}
				else if(checkIdPwd()) {	// 아이디 비밀번호가 일치할 경우 메인페이지 접속
					new MainScreen(id);
					dispose();
				}
				else {				// 아이디 혹은 비밀번호가 틀릴 경우 메세지창 띄우기
					JOptionPane.showMessageDialog(null, "아이디 혹은 비밀번호를 확인해주세요");
				}
				
			}
		});
		
		join.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new JoinScreen();	// 회원가입 페이지 접속
				dispose();  		// 현재의 frame을 종료
			}
		});
	}
	
	public class myLabel extends JPanel {
		public myLabel() {
			setLayout(null);
			
		}
		@Override
		public void paintComponent(Graphics g) {
			ImageIcon icon = new ImageIcon(this.getClass().getResource("mainLogo.png"));
			g.drawImage(icon.getImage(), -5, 0, this);
		}
	}
	
	public boolean checkIdPwd() {
		Connection conn = null;
		boolean check = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(
					"jdbc:mysql://@222.119.100.81:3382/matvengers",
					"matvengers",
					"@codehows213"
					);
			
			String sql = ""+ "select userid, password from users "
					+ "where userid = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);

			String id = idInput.getText();
			String pwd = new String(pwdInput.getPassword());
			
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			check = id.equals(rs.getString("userid")) && pwd.equals(rs.getString("password"));
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
		return check;
	}
	
}