package mlist;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import LOGIN_UI.MainScreen;
import addRok.RegistrationPage;

public class test {
	ImageIcon icon;
	ImageIcon icon2;
	ImageIcon title;
	private JFrame frame;
	int nx = 0;
	String id;
	
	private ArrayList<ms> m = new ArrayList<ms>();
	String addr = "";
	int i;
	/**
	 * Launch the application.
	 */
	public static void start(String id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test(id);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	public ArrayList<ms> getM() {
		return m;
	}


	public void setM(ArrayList<ms> m) {
		this.m = m;
	}
	
	
	
	
	
	
	/**
	 * Create the application.
	 */
	public test(String id) throws Exception {
		this.id = id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() throws Exception {

		frame = new JFrame("MATVENGERS");
		title = new ImageIcon(".\\images\\captain2.png");
		frame.setIconImage(title.getImage());
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((screenSize.width - 1200) / 2, (screenSize.height - 1035) / 2, 1200, 1035);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		icon2 = new ImageIcon(".\\images\\matvengers3-1.png");
		icon = new ImageIcon(".\\images\\changwon.png");
		JButton btnNewButton_9 = new JButton();
		JButton btnNewButton_10 = new JButton();
		JButton btnNewButton_11 = new JButton();
		Listbtn l = new Listbtn();

		tst t = new tst();
		m = t.result4(addr);
		i = m.size();
		JPanel panel_1 = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
                // Approach 1: Display image at at full size
                //g.drawImage(icon.getImage(), 0, 0, null);
                // Approach 2: Scale image to size of component
                Dimension d = getSize();
                g.drawImage(icon2.getImage(), (int)d.getWidth()/2-500, (int)d.getHeight()/2-380, 1000, 400, null);
                g.drawImage(icon.getImage(), (int)d.getWidth()/2-400, 0, 800, 600, null);
                
//              g.drawImage(icon.getImage(), 0, 0, 800, 600, null);
                // Approach 3: Fix the image position in the scroll pane
                // Point p = scrollPane.getViewport().getViewPosition();
                // g.drawImage(icon.getImage(), p.x, p.y, null);
                setOpaque(false); //그림을 표시하게 설정,투명하게 조절
                super.paintComponent(g);
            }
		};
		
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton();
		btnNewButton.setBounds(598, 78, 124, 197);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				icon = new ImageIcon(".\\images\\uichang.png");
				panel_1.repaint();
				// 의창 리스트
				addr = "의창";
				nx = 0;
				try {
					m.clear();
					m = t.result4(addr);
					i = m.size();
					l.sb1(addr,nx,btnNewButton_9,btnNewButton_10,btnNewButton_11,m);
				} catch (Exception e2) {

					e2.printStackTrace();
				}

			}
		});
		panel_1.setLayout(null);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFocusPainted(false);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton();
		btnNewButton_1.setBounds(608, 326, 175, 47);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				icon = new ImageIcon(".\\images\\sungsan.png");
				panel_1.repaint();
				// 성산 리스트
				addr = "성산";
				nx = 0;
				try {
					m.clear();
					m = t.result4(addr);
					i = m.size();
					l.sb1(addr,nx,btnNewButton_9,btnNewButton_10,btnNewButton_11,m);
				} catch (Exception e2) {

					e2.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setFocusPainted(false);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton();
		btnNewButton_2.setBounds(721, 412, 130, 75);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				icon = new ImageIcon(".\\images\\jinhae.png");
				panel_1.repaint();
				// 진해 리스트
				addr = "진해";
				nx = 0;
				try {
					m.clear();
					m = t.result4(addr);
					i = m.size();
					l.sb1(addr,nx,btnNewButton_9,btnNewButton_10,btnNewButton_11,m);
				} catch (Exception e2) {

					e2.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setFocusPainted(false);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton();
		btnNewButton_3.setBounds(446, 246, 142, 82);
		btnNewButton_3.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				icon = new ImageIcon(".\\images\\hoewon.png");
				panel_1.repaint();
				// 회원 리스트
				addr = "회원";
				nx = 0;
				try {
					m.clear();
					m = t.result4(addr);
					i = m.size();
					l.sb1(addr,nx,btnNewButton_9,btnNewButton_10,btnNewButton_11,m);
				} catch (Exception e2) {

					e2.printStackTrace();
				}
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setFocusPainted(false);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton();
		btnNewButton_4.setBounds(365, 396, 175, 75);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				icon = new ImageIcon(".\\images\\happo.png");
				panel_1.repaint();
				// 합포 리스트
				addr = "합포";
				nx = 0;
				try {
					m.clear();
					m = t.result4(addr);
					i = m.size();
					l.sb1(addr,nx,btnNewButton_9,btnNewButton_10,btnNewButton_11,m);
				} catch (Exception e2) {

					e2.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setContentAreaFilled(false);
		btnNewButton_4.setFocusPainted(false);
		panel_1.add(btnNewButton_4);
		
		// 맛집 추가 창
		JButton btnNewButton_5 = new JButton("맛집 추가");
		Image img  = new ImageIcon(test.class.getResource("/image/matjipAdd.png")).getImage();
      	ImageIcon icon = new ImageIcon(img.getScaledInstance(100, 50, Image.SCALE_SMOOTH));
      	btnNewButton_5 = new JButton(icon);
      	btnNewButton_5.setBorderPainted(false);
      	btnNewButton_5.setContentAreaFilled(false);
      	btnNewButton_5.setBounds(539, 685, 100, 50);
      	btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrationPage mj = new RegistrationPage(id);
				mj.start(id);
//				mj.setVisible(true);
//				dispose();
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		panel_1.add(btnNewButton_5);


		l.gb1(addr,nx,panel_1,btnNewButton_9,btnNewButton_10,btnNewButton_11,m);
		
		

		JButton btnNewButton_7 = new JButton("이전");
		Image img2  = new ImageIcon(test.class.getResource("/image/back.png")).getImage();
      	ImageIcon icon2 = new ImageIcon(img2.getScaledInstance(100, 50, Image.SCALE_SMOOTH));
      	btnNewButton_7 = new JButton(icon2);
      	btnNewButton_7.setBorderPainted(false);
      	btnNewButton_7.setContentAreaFilled(false);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(nx <= 0) {
						nx = 0;
					}
					else {
						nx -= 3;			
					}
					
				l.sb1(addr,nx,btnNewButton_9,btnNewButton_10,btnNewButton_11,m);
				}
				catch(Exception d) {}
			}
		});
		btnNewButton_7.setBounds(10, 685, 100, 50);
		panel_1.add(btnNewButton_7);
		
		
		JButton btnNewButton_6 = new JButton("다음");
		Image img3  = new ImageIcon(test.class.getResource("/image/next.png")).getImage();
      	ImageIcon icon3 = new ImageIcon(img3.getScaledInstance(100, 50, Image.SCALE_SMOOTH));
      	btnNewButton_6 = new JButton(icon3);
      	btnNewButton_6.setBorderPainted(false);
      	btnNewButton_6.setContentAreaFilled(false);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(i - nx >3 ) {
						nx += 3;
					}
					else {
						
					}
					
				l.sb1(addr,nx,btnNewButton_9,btnNewButton_10,btnNewButton_11,m);
				System.out.println(m.get(0).getName());
				}
				catch(Exception d) {}
			}
		});
		btnNewButton_6.setBounds(1080, 685, 100, 50);
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton_8 = new JButton("<<<");
		Image img4  = new ImageIcon(test.class.getResource("/image/left.png")).getImage();
      	ImageIcon icon4 = new ImageIcon(img4.getScaledInstance(100, 50, Image.SCALE_SMOOTH));
      	btnNewButton_8 = new JButton(icon4);
      	btnNewButton_8.setBorderPainted(false);
      	btnNewButton_8.setContentAreaFilled(false);
		btnNewButton_8.setBounds(10, 10, 100, 50);
		panel_1.add(btnNewButton_8);
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainScreen(id);
				frame.dispose();
			}
		});

//		for (int i = 0; i < m.size(); i++){
//		JLabel lblNewLabel = new JLabel("상호명: "+m.get(i).getName()+"\"
//				);
//		panel.add(lblNewLabel);
//		}
		


		
//		창원 전체 리스트 표출
//		scrollPane = new JScrollPane();
//		frame.getContentPane().add(scrollPane, BorderLayout.SOUTH);
		
		
	}
}
