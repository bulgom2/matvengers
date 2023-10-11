package LOGIN_UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JoinScreen extends JFrame {
	
	ImageIcon icon;
	ImageIcon icon2;
	ImageIcon title;

	static JTextField id = new JTextField(10);
	static JPasswordField pwd = new JPasswordField(10);
	static JPasswordField pwConfirm = new JPasswordField(10);
	static JTextField region = new JTextField(10);
	static boolean checkConfirm = false;
	
	public JoinScreen() {
		
		
		title = new ImageIcon(".\\images\\captain2.png");
	    setTitle("MATVENGERS");
	    setIconImage(title.getImage());
		
		// 1. 컴포넌트들을 만들어 보자.
		JLabel title = 
			new JLabel("회원가입", JLabel.CENTER);
		
		title.setForeground(new Color(5, 0, 153));
		title.setFont(new Font("Gaegu", Font.BOLD, 30));
//		login.setFont(new Font("Gaegu", Font.BOLD, 25));

		
		JButton btnJoin = new JButton("회원가입");
		Image joinImg  = new ImageIcon(LoginScreen.class.getResource("/image/join.png")).getImage();
	    ImageIcon joinIcon = new ImageIcon(joinImg.getScaledInstance(70, 35, Image.SCALE_SMOOTH));
	    btnJoin = new JButton(joinIcon);
	    btnJoin.setBorderPainted(false);
	    btnJoin.setContentAreaFilled(false);
		
		JButton btnCancel = new JButton("취소");
		Image cancelImg  = new ImageIcon(LoginScreen.class.getResource("/image/backback.png")).getImage();
	    ImageIcon cancelIcon = new ImageIcon(cancelImg.getScaledInstance(70, 35, Image.SCALE_SMOOTH));
	    btnCancel = new JButton(cancelIcon);
	    btnCancel.setBorderPainted(false);
	    btnCancel.setContentAreaFilled(false);
		
		JButton btnIdConfirm = new JButton("중복확인");
		Image confirmImg  = new ImageIcon(LoginScreen.class.getResource("/image/okok.png")).getImage();
	    ImageIcon confirmIcon = new ImageIcon(confirmImg.getScaledInstance(65, 25, Image.SCALE_SMOOTH));
	    btnIdConfirm = new JButton(confirmIcon);
	    btnIdConfirm.setBorderPainted(false);
	    btnIdConfirm.setContentAreaFilled(false);
		

//		ButtonGroup bg = new ButtonGroup();
		
		btnIdConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IdConfirm idConfirm = new IdConfirm(JoinScreen.this, id.getText());
				checkConfirm = idConfirm.check;
				idConfirm.setVisible(true);
			}
		});
		
		// form panel
		JPanel idPanel = new JPanel();
		idPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel idLabel = new JLabel("아이디　　　　: ");
		idLabel.setFont(new Font("Gaegu", Font.BOLD, 17));
		idPanel.add(idLabel);
		idPanel.add(id);
		idPanel.add(btnIdConfirm);
		
		JPanel pwdPanel = new JPanel();
		pwdPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel pwdLabel = new JLabel("비밀번호　　　: ");
		pwdLabel.setFont(new Font("Gaegu", Font.BOLD, 17));
		pwdPanel.add(pwdLabel);
		pwdPanel.add(pwd);
		
		JPanel pwConfirmPanel = new JPanel();
		pwConfirmPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel pwConLabel = new JLabel("비밀번호 확인  : ");
		pwConLabel.setFont(new Font("Gaegu", Font.BOLD, 17));
		pwConfirmPanel.add(pwConLabel);
		pwConfirmPanel.add(pwConfirm);
		
		JPanel regionPanel = new JPanel();
		regionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel regionLabel = new JLabel("지역           : ");
		regionLabel.setFont(new Font("Gaegu", Font.BOLD, 17));
		regionPanel.add(regionLabel);
		regionPanel.add(region);
		
		JPanel formPanel = new JPanel();
		formPanel.setLayout(new GridLayout(4, 1));
		formPanel.add(idPanel);
		formPanel.add(pwdPanel);
		formPanel.add(pwConfirmPanel);
		formPanel.add(regionPanel);
		
		// form panel
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new FlowLayout());
		contentPanel.add(formPanel);
		
		// button panel
		JPanel panel = new JPanel();
		panel.add(btnJoin);
		panel.add(btnCancel);
		
		//2560, 1440
		add(title, BorderLayout.NORTH);
		add(contentPanel, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - 350) / 2, (screenSize.height - 300) / 2, 350, 300);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		
		// 이벤트 처리
		btnJoin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String pwdStr = new String(pwd.getPassword());
				String pwConfirmStr = new String(pwConfirm.getPassword());
				
				if(pwdStr.equals(pwConfirmStr) && checkConfirm && !pwdStr.isEmpty()) {
					String myId = id.getText();
					String myPwd = new String(pwd.getPassword());
					String myRegion = region.getText();
					
					JOptionPane.showMessageDialog
						(null, "아이디 : " + myId + ", 비밀번호 : " + myPwd + ", 이 름 : " + myRegion);
					
					new JoinDb(myId, myPwd, myRegion);
				}
				else if(!checkConfirm) {
					JOptionPane.showMessageDialog(null, "아이디 중복확인해주세요");
				}
				else if(pwdStr.isEmpty()) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요");
				}
				else {
					JOptionPane.showMessageDialog(null, "비밀번호를 확인해주세요");
				}
			}
		});
		
		// 취소 버튼을 클릭했을 때 이벤트 처리
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new LoginScreen();
				dispose();
			}
		});
	}
}