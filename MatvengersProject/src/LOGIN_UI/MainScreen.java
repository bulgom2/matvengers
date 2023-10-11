package LOGIN_UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import MyPage.myPage;
import mlist.test;

public class MainScreen extends JFrame {
	
	private JPanel panel;
	private JButton myPage, findMat;
	String id;
	ImageIcon icon;
	ImageIcon icon2;
	ImageIcon title;
	
	public MainScreen(String id) {
		
		title = new ImageIcon(".\\images\\captain2.png");
		setIconImage(title.getImage());
		this.id = id;
		
		setTitle("MATVENGERS");
		this.getContentPane().add(getPanel(), BorderLayout.CENTER);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds((screenSize.width - 1200) / 2, (screenSize.height - 1035) / 2, 1200, 1035);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public JPanel getPanel() {
		if(panel == null) {
			panel = new myPanel();
			panel.setLayout(null);
			panel.add(getMyPageBtn());
			panel.add(getFindMatBtn());
		}
		return panel;
	}
	
//	public void paintComponent(Graphics g) {
//		ImageIcon icon = new ImageIcon(this.getClass().getResource("mainLogo2.png"));
//		g.drawImage(icon.getImage(), -5, 0, this);
//	}

	public JButton getMyPageBtn() {
		
		myPage = new JButton();
		Image myPageImg  = new ImageIcon(MainScreen.class.getResource("/image/mypage.png")).getImage();
	    ImageIcon myPageIcon = new ImageIcon(myPageImg.getScaledInstance(250, 125, Image.SCALE_SMOOTH));
	    myPage = new JButton(myPageIcon);
	    myPage.setBorderPainted(false);
	    myPage.setFocusPainted(false);
	    myPage.setBackground(new Color(0xf0f0f0));
		
		myPage.setBounds(100, 800, 250, 125);
		myPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					myPage mp = new myPage(id);
					mp.start(id);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	// 회원가입 페이지 접속
				
				dispose();  		// 현재의 frame을 종료
			}
		});
		return myPage;
	}
	
	public JButton getFindMatBtn() {
		findMat = new JButton();
		Image findMatImg  = new ImageIcon(MainScreen.class.getResource("/image/Tambang.png")).getImage();
	    ImageIcon findMatIcon = new ImageIcon(findMatImg.getScaledInstance(250, 125, Image.SCALE_SMOOTH));
	    findMat = new JButton(findMatIcon);
	    findMat.setBorderPainted(false);
	    findMat.setFocusPainted(false);
	    findMat.setBackground(new Color(0xf0f0f0));

		findMat.setBounds(850, 800, 250, 125);
		findMat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					test t = new test(id);
					t.start(id);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	// 회원가입 페이지 접속
				dispose();  		// 현재의 frame을 종료
			}
		});
		return findMat;
	}

}
class myPanel extends JPanel {
	public myPanel() {
		setLayout(null);
		
	}
	@Override
	public void paintComponent(Graphics g) {
		ImageIcon icon = new ImageIcon(this.getClass().getResource("mainLogo2.png"));
		g.drawImage(icon.getImage(), 30, 0, this);
	}
}
