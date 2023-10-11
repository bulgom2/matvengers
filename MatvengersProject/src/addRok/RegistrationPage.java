package addRok;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import ADD_UI.AddDb;

public class RegistrationPage extends JFrame {

	private JFrame frame;
	private JTextField name;
	private JTextField addr;
	private JTextField tel;
	private JTextField url;
	private JTextField menu;
	private JTextField star;
	private JButton m_imgButton;
	private JButton v_imgButton;
	private JButton okButton;
	private JButton cancelButton;
	private JTextField price;
	private String id;
	private String subj;
	private JTextField m_img;
	private JTextField v_img;
	File m_file;
	File v_file;
	ImageIcon icon;
	ImageIcon icon2;
	ImageIcon title;

   /**
    * Launch the application.
    */
   public static void start(String id) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               RegistrationPage window = new RegistrationPage(id);
               window.frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the application.
    */
   public RegistrationPage(String id) {
	   this.id = id;
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
	      frame = new JFrame();
	      title = new ImageIcon(".\\images\\captain2.png");
	      frame.setTitle("MATVENGERS");
	      frame.setIconImage(title.getImage());
	      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	      frame.setBounds((screenSize.width - 750), (screenSize.height - 1035) / 2, 750, 1035);
	      frame.getContentPane().setLayout(new BorderLayout(0, 0));
	      
	      JPanel panel_1 = new JPanel();
	      frame.getContentPane().add(panel_1, BorderLayout.NORTH);
	      
	      JLabel lblNewLabel_8 = new JLabel("맛집 등록");
	      lblNewLabel_8.setFont(new Font("Gaegu", Font.PLAIN, 23));
	      panel_1.add(lblNewLabel_8);
	      
	      JScrollPane scrollPane = new JScrollPane();
	      frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
	      
	      
	      JPanel panel_2 = new JPanel();
	      scrollPane.setViewportView(panel_2);
	      panel_2.setLayout(new GridLayout(0, 1, 20, 20));

	      
	      JPanel panel_3 = new JPanel();
	      panel_2.add(panel_3);
	      panel_3.setLayout(new GridLayout(0, 2, 0, 0));
	      
	      JLabel lblNewLabel_1 = new JLabel("상호명");
	      lblNewLabel_1.setFont(new Font("Gaegu", Font.PLAIN, 20));
	      lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	      panel_3.add(lblNewLabel_1);
	      
	      name = new JTextField();
	      name.setHorizontalAlignment(SwingConstants.LEFT);
	      name.setColumns(10);
	      panel_3.add(name);
	      
	      JPanel panel_4 = new JPanel();
	      panel_2.add(panel_4);
	      panel_4.setLayout(new GridLayout(0, 2, 0, 0));
	      
	      JLabel lblNewLabel_2 = new JLabel("주소");
	      lblNewLabel_2.setFont(new Font("Gaegu", Font.PLAIN, 20));
	      lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
	      panel_4.add(lblNewLabel_2);
	      
	      addr = new JTextField();
	      addr.setHorizontalAlignment(SwingConstants.LEFT);
	      addr.setColumns(10);
	      panel_4.add(addr);
	      
	      JPanel panel_5 = new JPanel();
	      panel_2.add(panel_5);
	      panel_5.setLayout(new GridLayout(0, 2, 0, 0));
	      
	      JLabel lblNewLabel_4 = new JLabel("전화번호");
	      lblNewLabel_4.setFont(new Font("Gaegu", Font.PLAIN, 20));
	      lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
	      panel_5.add(lblNewLabel_4);
	      
	      tel = new JTextField();
	      tel.setHorizontalAlignment(SwingConstants.LEFT);
	      tel.setColumns(10);
	      panel_5.add(tel);
	      
	      JPanel panel_7 = new JPanel();
	      panel_2.add(panel_7);
	      panel_7.setLayout(null);
	      
	      JLabel lblNewLabel_3 = new JLabel("메뉴 사진 등록");            // 사진 등록
	      lblNewLabel_3.setBounds(0, 0, 358, 79);
	      lblNewLabel_3.setFont(new Font("Gaegu", Font.PLAIN, 20));
	      lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
	      panel_7.add(lblNewLabel_3);
	      
	      JButton btnNewButton_2 = new JButton("사진 등록");
	      Image img2  = new ImageIcon(RegistrationPage.class.getResource("/image/Pic.png")).getImage();
	      ImageIcon icon2 = new ImageIcon(img2.getScaledInstance(100, 50, Image.SCALE_SMOOTH));
	      m_imgButton = new JButton(icon2);
	      m_imgButton.setBounds(606, 0, 124, 79);
	      m_imgButton.setBorderPainted(false);
	      m_imgButton.setContentAreaFilled(false);
	      m_imgButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            JFileChooser jFileChooser = new JFileChooser();
	            jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter(
	                  "그림파일(*.jpg, *.gif, *.bmp)", "jpg", "gif", "bmp"));
	            jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter(
	                  "텍스트 파일(*.txt)", "txt"));
	            int option = jFileChooser.showOpenDialog(RegistrationPage.this);
	            // 어떤 버튼을 클릭했는지 확인하기
	            if(option == JFileChooser.APPROVE_OPTION) {
	               m_file = jFileChooser.getSelectedFile();
	               //System.out.println("열어볼 파일: " + file.getName());
	            } else if (option == JFileChooser.CANCEL_OPTION) {
	               System.out.println("취소");
	            }
	            if(m_file!=null) {
	               m_img.setText(m_file.getPath());}
	         }
	      });
	      panel_7.add(m_imgButton);
	      
	      m_img = new JTextField();
	      m_img.setBounds(366, 0, 245, 79);
	      
	      panel_7.add(m_img);
	      m_img.setColumns(10);
	      
	      JPanel panel_8 = new JPanel();
	      panel_2.add(panel_8);
	      panel_8.setLayout(null);
	      
	      JLabel lblNewLabel = new JLabel("식당 사진 등록");               // 사진 등록
	      lblNewLabel.setBounds(0, 0, 367, 77);
	      
	      lblNewLabel.setFont(new Font("Gaegu", Font.PLAIN, 20));
	      
	      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	      panel_8.add(lblNewLabel);
	      
	      JButton btnNewButton_3 = new JButton("사진 등록");
	      Image img3  = new ImageIcon(RegistrationPage.class.getResource("/image/Pic.png")).getImage();
	      ImageIcon icon3 = new ImageIcon(img3.getScaledInstance(100, 50, Image.SCALE_SMOOTH));
	      v_imgButton = new JButton(icon3);
	      v_imgButton.setBounds(606, 0, 124, 79);
	      v_imgButton.setBorderPainted(false);
	      v_imgButton.setContentAreaFilled(false);
	      v_imgButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            JFileChooser jFileChooser = new JFileChooser();
	            jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter(
	                  "그림파일(*.jpg, *.gif, *.bmp)", "jpg", "gif", "bmp"));
	            jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter(
	                  "텍스트 파일(*.txt)", "txt"));
	            int option = jFileChooser.showOpenDialog(RegistrationPage.this);
	            // 어떤 버튼을 클릭했는지 확인하기
	            if(option == JFileChooser.APPROVE_OPTION) {
	               v_file = jFileChooser.getSelectedFile();
	               //System.out.println("열어볼 파일: " + file.getName());                  
	            } else if (option == JFileChooser.CANCEL_OPTION) {
	               System.out.println("취소");
	            }
	            if(v_file!=null) {
	               v_img.setText(v_file.getPath());}
	         }
	      });
	      
	      

	      panel_8.add(v_imgButton);
	      
	      v_img = new JTextField();
	      v_img.setBounds(366, 0, 243, 77);
	      
	      panel_8.add(v_img);
	      v_img.setColumns(10);
	      
	      JPanel panel_9 = new JPanel();
	      panel_2.add(panel_9);
	      panel_9.setLayout(new GridLayout(0, 2, 0, 0));
	      
	      JLabel lblNewLabel_7_1 = new JLabel("네이버 지도 URL");
	      lblNewLabel_7_1.setFont(new Font("Gaegu", Font.PLAIN, 20));
	      lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.CENTER);
	      panel_9.add(lblNewLabel_7_1);
	      
	      url = new JTextField();
	      url.setHorizontalAlignment(SwingConstants.LEFT);
	      url.setColumns(10);
	      panel_9.add(url);
	      
	      JPanel panel_6 = new JPanel();
	      panel_2.add(panel_6);
	      panel_6.setLayout(new GridLayout(0, 2, 0, 0));
	      
	      JLabel lblNewLabel_5 = new JLabel("가격");
	      lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
	      lblNewLabel_5.setFont(new Font("Gaegu", Font.PLAIN, 20));
	      panel_6.add(lblNewLabel_5);
	      
	      price = new JTextField();
	      panel_6.add(price);
	      price.setColumns(10);
	      
	      JPanel panel_10 = new JPanel();
	      panel_2.add(panel_10);
	      panel_10.setLayout(new GridLayout(0, 2, 0, 0));
	      
	      JLabel lblNewLabel_6 = new JLabel("대표 메뉴");
	      lblNewLabel_6.setFont(new Font("Gaegu", Font.PLAIN, 20));
	      lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
	      panel_10.add(lblNewLabel_6);
	      
	      
	      
	      menu = new JTextField();
	      menu.setHorizontalAlignment(SwingConstants.LEFT);
	      menu.setColumns(10);
	      panel_10.add(menu);
	      
	      JPanel panel = new JPanel();
	      panel_2.add(panel);
	      panel.setLayout(new GridLayout(0, 2, 0, 0));
	      
	      JLabel lblNewLabel_7 = new JLabel("종류");
	      lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
	      lblNewLabel_7.setFont(new Font("Gaegu", Font.PLAIN, 20));
	      panel.add(lblNewLabel_7);
	      
	      JPanel panel_11 = new JPanel();
	      panel.add(panel_11);
	      
	      JRadioButton kor = new JRadioButton("한식");
	      kor.setBounds(18, 28, 57, 31);
	      kor.setFont(new Font("Gaegu", Font.PLAIN, 16));
	      panel_11.setFont(new Font("Gaegu", Font.PLAIN, 15));
	      panel_11.setLayout(null);
	      kor.setHorizontalAlignment(SwingConstants.CENTER);
	      panel_11.add(kor);
	      
	      JRadioButton cha = new JRadioButton("중식");
	      cha.setBounds(79, 28, 57, 31);
	      cha.setFont(new Font("Gaegu", Font.PLAIN, 16));
	      cha.setHorizontalAlignment(SwingConstants.CENTER);
	      panel_11.add(cha);
	      
	      JRadioButton jpn = new JRadioButton("일식");
	      jpn.setBounds(140, 28, 57, 31);
	      jpn.setFont(new Font("Gaegu", Font.PLAIN, 16));
	      jpn.setHorizontalAlignment(SwingConstants.CENTER);
	      panel_11.add(jpn);
	      
	      JRadioButton eng = new JRadioButton("양식");
	      eng.setBounds(201, 28, 57, 31);
	      eng.setFont(new Font("Gaegu", Font.PLAIN, 16));
	      eng.setHorizontalAlignment(SwingConstants.CENTER);
	      panel_11.add(eng);
	      
	      JRadioButton dij = new JRadioButton("디저트");
	      dij.setBounds(262, 28, 71, 31);
	      dij.setFont(new Font("Gaegu", Font.PLAIN, 16));
	      dij.setHorizontalAlignment(SwingConstants.CENTER);
	      panel_11.add(dij);
	      
	      ButtonGroup group = new ButtonGroup();
	      group.add(kor);
	      group.add(cha);
	      group.add(jpn);
	      group.add(eng);
	      group.add(dij);
	      
	      kor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					subj = "한식";
				}
			});
	      cha.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {
	    		  subj = "중식";
	    	  }
	      });
	      jpn.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {
	    		  subj = "일식";
	    	  }
	      });
	      eng.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {
	    		  subj = "양식";
	    	  }
	      });
	      dij.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {
	    		  subj = "디저트";
	    	  }
	      });
	      JPanel panel_13 = new JPanel();
	         panel_2.add(panel_13);
	         panel_13.setLayout(null);
	         
	         JLabel lblNewLabel_9 = new JLabel("별점(0~5점)");
	         lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
	         lblNewLabel_9.setFont(new Font("Gaegu", Font.PLAIN, 20));
	         lblNewLabel_9.setBounds(0, 0, 358, 69);
	         panel_13.add(lblNewLabel_9);
	         
	         star = new JTextField("5");
	         star.setBounds(358, 0, 359, 69);
	         panel_13.add(star);
	         star.setColumns(10);
	         JPanel panel_12 = new JPanel();
	         panel_2.add(panel_12);
	         
	         JButton btnNewButton = new JButton("확인");
	         btnNewButton.setFont(new Font("Gaegu", Font.PLAIN, 20));
	         Image img  = new ImageIcon(RegistrationPage.class.getResource("/image/ok.png")).getImage();
	         ImageIcon icon = new ImageIcon(img.getScaledInstance(70, 50, Image.SCALE_SMOOTH));
	         okButton = new JButton(icon);
	         okButton.setBorderPainted(false);
	         okButton.setContentAreaFilled(false);
//	         btnNewButton.setFocusPainted(false);
//	         btnNewButton.setContentAreaFilled(false);
	         okButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            // 객체 생성하고 확인 되면 정보 입력에대해 적용
	             String Name = name.getText();
	             String Addr = addr.getText();
	             String Tel  = tel.getText();
	             String Url = url.getText();
	             String M_img = m_img.getText();
	             String V_img = v_img.getText();
	             String Subj = subj;
	             String Style = null;
	             String Menu = menu.getText();
	             int Price = Integer.parseInt(price.getText());
	             String Userid = id;
	             String Cmt = "";
	             int Star = 5;
	             Star = Integer.parseInt(star.getText());
	             if(Star >= 0 && Star <= 5) {
	            	 new AddDb(Name, Addr, Tel, Url, M_img, V_img, Subj, Style, Menu, Price, Userid);
	            	 new starsDb(Name, Userid, Star, Cmt);
	             }
	             else {
	            	 JOptionPane.showMessageDialog(null, "별점은 0 ~5 사이의 정수로 입력해주세요");
	             }
	               frame.dispose();
	               JOptionPane.showMessageDialog(null, "등록성공");
	            }         
	         });
	         panel_12.add(okButton);
	         
	         JButton btnNewButton_1 = new JButton("취소");
	         btnNewButton_1.setFont(new Font("Gaegu", Font.PLAIN, 20));
	         Image img1  = new ImageIcon(RegistrationPage.class.getResource("/image/backback.png")).getImage();
	         ImageIcon icon1 = new ImageIcon(img1.getScaledInstance(70, 50, Image.SCALE_SMOOTH));
	         cancelButton = new JButton(icon1);
	         cancelButton.setBorderPainted(false);
	         cancelButton.setContentAreaFilled(false);
	         cancelButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	               // 전 페이지로 이동 객체 생성
	               frame.dispose();;
	            }
	         });
	         panel_12.add(cancelButton);
	      }
	   }