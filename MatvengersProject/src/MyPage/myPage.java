package MyPage;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import CONECT.MList;
import CONECT.stars;
import CONECT.tst;
import LOGIN_UI.MainScreen;
import addRok.RegistrationPage;

public class myPage {
//   private JTable jTable;
//   private JTextField txtName, txtAge;
   private JFrame frame;
   private JButton deleteButton2;
   private JButton insertButton2;
   private JButton listButton;
   private JButton okButton;
   private String id;
   private String name;
   ImageIcon icon;
   ImageIcon icon2;
   ImageIcon title;
   tst t1 = new tst();
   
   ArrayList<MList> ml = new ArrayList<MList>();
   ArrayList<stars> st = new ArrayList<stars>();
   String addr = "";
   
   /**
    * Launch the application.
    */
   public static void start(String id) {
		 EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               myPage window = new myPage(id);
               window.frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the application.
    * @throws Exception 
    */
   public myPage(String id) throws Exception {
	   this.id = id;
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    * @throws Exception 
    */
   private void initialize() throws Exception {
      frame = new JFrame();
      title = new ImageIcon(".\\images\\captain2.png");
      frame.setTitle("MATVENGERS");
      frame.setIconImage(title.getImage());
  	  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	  frame.setBounds((screenSize.width - 1200) / 2, (screenSize.height - 1035) / 2, 1200, 1035);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);
      
      JPanel BottomPanel = new JPanel();
      BottomPanel.setBounds(0, 868, 1186, 130);
      frame.getContentPane().add(BottomPanel);
      
      JButton btnNewButton = new JButton("확인");
      Image img4  = new ImageIcon(RegistrationPage.class.getResource("/image/ok.png")).getImage();
      ImageIcon icon4 = new ImageIcon(img4.getScaledInstance(100, 50, Image.SCALE_SMOOTH));
      okButton = new JButton(icon4);
      okButton.setBorderPainted(false);
      okButton.setContentAreaFilled(false);
      okButton.setBounds(460, 41, 115, 48);
      okButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 new MainScreen(id);
        	 frame.dispose();
         }
      });
      BottomPanel.setLayout(null);
      okButton.setFont(new Font("Gaegu", Font.PLAIN, 20));
      BottomPanel.add(okButton);
      
      JButton btnNewButton_1 = new JButton("목록");
      Image img5  = new ImageIcon(RegistrationPage.class.getResource("/image/list.png")).getImage();
      ImageIcon icon5 = new ImageIcon(img5.getScaledInstance(100, 50, Image.SCALE_SMOOTH));
      listButton = new JButton(icon5);
      listButton.setBorderPainted(false);
      listButton.setContentAreaFilled(false);
      listButton.setBounds(609, 41, 115, 48);
      listButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 new MainScreen(id);
        	 frame.dispose();
         }
      });
      listButton.setFont(new Font("Gaegu", Font.PLAIN, 20));
      BottomPanel.add(listButton);
      
      JPanel TopPanel = new JPanel();
      TopPanel.setBounds(0, 10, 1186, 100);
      frame.getContentPane().add(TopPanel);
      TopPanel.setLayout(null);
      
      JPanel panel_3 = new JPanel();
      panel_3.setBounds(401, 10, 389, 90);
      TopPanel.add(panel_3);
      panel_3.setLayout(null);
      
      JLabel lblNewLabel = new JLabel("마이페이지");
      lblNewLabel.setBounds(0, 0, 389, 90);
      panel_3.add(lblNewLabel);
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel.setFont(new Font("Gaegu", Font.PLAIN, 50));
      
      JPanel panel_4 = new JPanel();
      panel_4.setBounds(12, 10, 192, 29);
      TopPanel.add(panel_4);
      panel_4.setLayout(null);
      
      JLabel lblNewLabel_1 = new JLabel(id);
      lblNewLabel_1.setBounds(5, 5, 46, 19);
      lblNewLabel_1.setFont(new Font("Gaegu", Font.PLAIN, 15));
      panel_4.add(lblNewLabel_1);
      
      JPanel CenterPanel = new JPanel();
      CenterPanel.setBounds(0, 109, 1186, 760);
      frame.getContentPane().add(CenterPanel);
      CenterPanel.setLayout(new GridLayout(0, 1, 0, 0));
      
      JPanel panel_2 = new JPanel();
      CenterPanel.add(panel_2);
      panel_2.setLayout(null);
      
      JLabel lblNewLabel_2 = new JLabel("<등록한 맛집>");
      lblNewLabel_2.setBounds(0, 0, 1188, 66);
      lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_2.setFont(new Font("Gaegu", Font.BOLD, 30));
      
      panel_2.add(lblNewLabel_2);
      ml = t1.mypage1(id,addr);
      st = t1.mypage2(id);
      JPanel panel_7 = new JPanel();
      //JCheckBox[] arr = new JCheckBox[ml.size()];
      ButtonGroup group = new ButtonGroup();
      ml.forEach(m->{
    	  if(id.equals(m.getUserid())) {
	         JRadioButton jrb = new JRadioButton("<"+ m.getName()+ ">　주소: "+m.getAddr());
	         jrb.setFont(new Font("Gaegu", Font.BOLD, 18));
	         group.add(jrb);
	         panel_7.add(jrb);
	         jrb.addActionListener(new ActionListener() {
		       public void actionPerformed(ActionEvent e) {
	 				name = m.getName();
	 			}
	 		});
    	  }
      });
      
      panel_7.setBounds(0, 112, 1188, 497);
      panel_2.add(panel_7);
      panel_7.setLayout(new GridLayout(0, 2, 0, 0));
      
      JPanel panel = new JPanel();
      panel.setBounds(0, 609, 1188, 151);
      panel_2.add(panel);
      panel.setLayout(null);
      
      JButton btnNewButton_5 = new JButton("삭제");
      Image img10  = new ImageIcon(RegistrationPage.class.getResource("/image/delete.png")).getImage();
      ImageIcon icon10 = new ImageIcon(img10.getScaledInstance(110, 60, Image.SCALE_SMOOTH));
      deleteButton2 = new JButton(icon10);
      deleteButton2.setBorderPainted(false);
      deleteButton2.setContentAreaFilled(false);
      deleteButton2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 try {
				new deleteDb(name);
			    JOptionPane.showMessageDialog(null, "삭제완료");
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
         }
      });
      deleteButton2.setFont(new Font("Gaegu", Font.PLAIN, 20));
      deleteButton2.setBounds(782, 41, 146, 57);
      panel.add(deleteButton2);
      
      JButton btnNewButton_2 = new JButton("수정");
      Image img11  = new ImageIcon(RegistrationPage.class.getResource("/image/insert.png")).getImage();
      ImageIcon icon11 = new ImageIcon(img11.getScaledInstance(110, 60, Image.SCALE_SMOOTH));
      insertButton2 = new JButton(icon11);
      insertButton2.setBorderPainted(false);
      insertButton2.setContentAreaFilled(false);
      insertButton2.setFont(new Font("Gaegu", Font.PLAIN, 20));
      insertButton2.setBounds(282, 41, 146, 57);
      insertButton2.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    		  new editScreen(id, name).start(id, name);
    		  
    	  }
      });
      panel.add(insertButton2);
      
      JButton btnNewButton_7 = new JButton("추가");
      Image img12  = new ImageIcon(RegistrationPage.class.getResource("/image/add.png")).getImage();
      ImageIcon icon12 = new ImageIcon(img12.getScaledInstance(110, 60, Image.SCALE_SMOOTH));
      
      JPanel panel_6 = new JPanel();
      panel_6.setBounds(0, 76, 1188, 37);
      panel_2.add(panel_6);
      
      String handover = ml.get(0).getName();
      
   }
}