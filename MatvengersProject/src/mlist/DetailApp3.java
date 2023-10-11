package mlist;


import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.sql.Blob;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class DetailApp3 extends JFrame{
	
	private ArrayList<ms> m = new ArrayList<ms>();
	tst t1 = new tst();

	
	private JPanel panelSouth;
//	private JButton btnOk;
	private JButton btnCancel;
	private String name;
	private double star;
	private String starString;
	private Blob v_img;
	private Blob m_img;
	private String tel;
	private String addr;
	private String menu;
	private String subj;
	private String cmt;
	private String url;
	private String userid;
	private JFrame frame;
	private String filename;
	ImageIcon title;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetailApp3 window = new DetailApp3();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DetailApp3() throws Exception {
		
		if(Listbtn.idx == 1) {
			m = t1.result7(Listbtn.na1);
			name = m.get(0).getName();
			star = m.get(0).getStar();
			starString = ""+ star;
			v_img = m.get(0).getV_img();
			m_img = m.get(0).getM_img();
			tel = m.get(0).getTel();
			addr = m.get(0).getAddr();
			menu = m.get(0).getMenu();
			subj = m.get(0).getSubj();
			cmt = m.get(0).getCmt();
			url = m.get(0).getUrl();
			userid = m.get(0).getUserid();
			filename = m.get(0).getStyle();
		}
		else if (Listbtn.idx == 2) {
			m = t1.result7(Listbtn.na2);
			name = m.get(0).getName();
			star = m.get(0).getStar();
			starString = ""+ star;
			v_img = m.get(0).getV_img();
			m_img = m.get(0).getM_img();
			tel = m.get(0).getTel();
			addr = m.get(0).getAddr();
			menu = m.get(0).getMenu();
			subj = m.get(0).getSubj();
			cmt = m.get(0).getCmt();
			url = m.get(0).getUrl();
			userid = m.get(0).getUserid();
			filename = m.get(0).getStyle();
		}
		else if (Listbtn.idx == 3) {
			m = t1.result7(Listbtn.na3);
			name = m.get(0).getName();
			star = m.get(0).getStar();
			starString = ""+ star;
			v_img = m.get(0).getV_img();
			m_img = m.get(0).getM_img();
			tel = m.get(0).getTel();
			addr = m.get(0).getAddr();
			menu = m.get(0).getMenu();
			subj = m.get(0).getSubj();
			cmt = m.get(0).getCmt();
			url = m.get(0).getUrl();
			userid = m.get(0).getUserid();
			filename = m.get(0).getStyle();
		}
		
		if(m_img != null) {
			InputStream is = m_img.getBinaryStream();
			OutputStream os = new FileOutputStream("C:/Temp/"+ filename);
			is.transferTo(os);
			os.flush();
			os.close();
			is.close();
		}
		

		
		initialize();

	}
	
	private void initialize() {
		frame = this;
		title = new ImageIcon(".\\images\\captain2.png");
		frame.setIconImage(title.getImage());
		
		// 중앙 패널
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("등록인: " + userid);
		lblNewLabel_5.setFont(new Font("Gaegu", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(10, 10, 147, 25);
		panel_1.add(lblNewLabel_5);

		
		JLabel lblNewLabel = new JLabel(name);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Gaegu", Font.PLAIN, 45));
		lblNewLabel.setBounds(10, 26, 261, 58);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel2 = new JLabel(starString);
		lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel2.setFont(new Font("Gaegu", Font.PLAIN, 30));
		lblNewLabel2.setBounds(281, 26, 95, 58);
		panel_1.add(lblNewLabel2);
		
		// 사진
		JLabel lblNewLabel_1 = new JLabel();
		Image img6  = new ImageIcon("C:\\Temp\\" + filename).getImage();
      	ImageIcon icon6 = new ImageIcon(img6.getScaledInstance(366, 213, Image.SCALE_SMOOTH));
      	lblNewLabel_1 = new JLabel(icon6);
      	lblNewLabel_1.setBounds(10, 94, 366, 213);
      	panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tel: " + tel);
		lblNewLabel_2.setFont(new Font("Gaegu", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(10, 317, 366, 41);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("주소: " + addr);
		lblNewLabel_3.setFont(new Font("Gaegu", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(10, 368, 366, 41);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("종류: " + subj);
		lblNewLabel_4.setFont(new Font("Gaegu", Font.PLAIN, 25));
		lblNewLabel_4.setBounds(10, 419, 346, 41);
		panel_1.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("지도 보기");
		Image img5  = new ImageIcon(test.class.getResource("/image/Viewmap.png")).getImage();
      	ImageIcon icon5 = new ImageIcon(img5.getScaledInstance(280, 80, Image.SCALE_SMOOTH));
      	btnNewButton = new JButton(icon5);
      	btnNewButton.setBorderPainted(false);
      	btnNewButton.setContentAreaFilled(false);
      	btnNewButton.setFocusPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ) {
				Desktop desk = Desktop.getDesktop();
				try {
					desk.browse(new URI(url));
				}
				catch(Exception err) {
					//System.out.println(err);
				}
			}
		});
		
		frame.setVisible(true);
		btnNewButton.setBounds(54, 470, 280, 80);
		panel_1.add(btnNewButton);
		
		
		frame.setBounds(100, 100, 400, 600);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.getContentPane().setLayout(null);
		frame.setTitle("상세 페이지");
		frame.setSize(400, 600);

	}
}