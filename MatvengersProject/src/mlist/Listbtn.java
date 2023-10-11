package mlist;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Listbtn {
	static int idx;
	static String na1 = "";
	static String na2 = "";
	static String na3 = "";
	public void gb1(String a, int nx, JPanel c, JButton jb1, JButton jb2, JButton jb3, ArrayList<ms> m) throws Exception {

		
		int i = (int)m.size();
		i = i - nx;
		
		if (i >= 3){
			jb1.setText("<html><body><center style='text-align: left'>상호명: " + 
												m.get(0+nx).getName() + "<br><br>별점: "+m.get(0+nx).getStar() +
												"<br><br>주소: "+ m.get(0+nx).getAddr()+"<br><br>전화번호: "+
												m.get(0+nx).getTel() + "</center></body></html>");
			jb1.setFont(new Font("Gaegu", Font.PLAIN, 23));
			jb1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					idx = 1;
					na1 = m.get(0+nx).getName();
					DetailApp3 D;
					try {
						D = new DetailApp3();
						D.setVisible(true);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			jb1.setHorizontalAlignment(SwingConstants.LEFT);
			jb1.setBounds(10, 740, 389, 250);
			jb1.setFocusPainted(false);			
			c.add(jb1);
			
			jb2.setText("<html><body><center style='text-align: left'>상호명: " + 
												m.get(1+nx).getName() + "<br><br>별점: "+m.get(1+nx).getStar() +
												"<br><br>주소: "+ m.get(1+nx).getAddr()+"<br><br>전화번호: "+
												m.get(1+nx).getTel() + "</center></body></html>");
			jb2.setFont(new Font("Gaegu", Font.PLAIN, 23));
			jb2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					idx = 2;
					na2 = m.get(1+nx).getName();
					DetailApp3 D;
					try {
						D = new DetailApp3();
						D.setVisible(true);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				
					
				}
			});
			jb2.setHorizontalAlignment(SwingConstants.LEFT);
			jb2.setBounds(399, 740, 389, 250);
			jb2.setFocusPainted(false);
			c.add(jb2);
			
			jb3.setText("<html><body><center style='text-align: left'>상호명: " + 
												m.get(2+nx).getName() + "<br><br>별점: "+m.get(2+nx).getStar() +
												"<br><br>주소: "+ m.get(2+nx).getAddr()+"<br><br>전화번호: "+
												m.get(2+nx).getTel() + "</center></body></html>");
			jb3.setFont(new Font("Gaegu", Font.PLAIN, 23));
			jb3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					idx = 3;
					na3 = m.get(2+nx).getName();
					DetailApp3 D;
					try {
						D = new DetailApp3();
						D.setVisible(true);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					
					
				}
			});
			jb3.setHorizontalAlignment(SwingConstants.LEFT);
			jb3.setBounds(788, 740, 389, 250);
			jb3.setFocusPainted(false);
			c.add(jb3);

			
			
	}
	else if (i == 2){		
			jb1.setText("<html><body><center style='text-align: left'>상호명: " + 
					m.get(0+nx).getName() + "<br><br>별점: "+m.get(0+nx).getStar() +
					"<br><br>주소: "+ m.get(0+nx).getAddr()+"<br><br>전화번호: "+
					m.get(0+nx).getTel() + "</center></body></html>");
					jb1.setFont(new Font("Gaegu", Font.PLAIN, 23));
					jb1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							idx = 1;
							na1 = m.get(0+nx).getName();
							DetailApp3 D;
							try {
								D = new DetailApp3();
								D.setVisible(true);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						});
					jb1.setHorizontalAlignment(SwingConstants.LEFT);
					jb1.setBounds(10, 740, 393, 250);
					jb1.setFocusPainted(false);
					c.add(jb1);
				
					jb2.setText("<html><body><center style='text-align: left'>상호명: " + 
							m.get(1+nx).getName() + "<br><br>별점: "+m.get(1+nx).getStar() +
							"<br><br>주소: "+ m.get(1+nx).getAddr()+"<br><br>전화번호: "+
							m.get(1+nx).getTel() + "</center></body></html>");
					jb2.setFont(new Font("Gaegu", Font.PLAIN, 23));
					jb2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							idx = 2;
							na2 = m.get(1+nx).getName();
							DetailApp3 D;
							try {
								D = new DetailApp3();
								D.setVisible(true);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							
						}
					});
					jb2.setHorizontalAlignment(SwingConstants.LEFT);
					jb2.setBounds(403, 740, 393, 250);
					jb2.setFocusPainted(false);
					c.add(jb2);

		}
	else if(i == 1){
		jb1.setText("<html><body><center style='text-align: left'>상호명: " + 
				m.get(0+nx).getName() + "<br><br>별점: "+m.get(0+nx).getStar() +
				"<br><br>주소: "+ m.get(0+nx).getAddr()+"<br><br>전화번호: "+
				m.get(0+nx).getTel() + "</center></body></html>");
				jb1.setFont(new Font("Gaegu", Font.PLAIN, 23));
				jb1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						idx = 1;
						na1 = m.get(0+nx).getName();
						DetailApp3 D;
						try {
							D = new DetailApp3();
							D.setVisible(true);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				jb1.setHorizontalAlignment(SwingConstants.LEFT);
				jb1.setBounds(10, 740, 393, 250);
				jb1.setFocusPainted(false);
				c.add(jb1);

							
		}

	}
	public void sb1(String a, int nx, JButton jb1, JButton jb2, JButton jb3, ArrayList<ms> m) throws Exception {

	int i = (int)m.size();
	i = i - nx;
	if (i < 1) {

	}
	else if (i >= 3){
		jb1.setText("<html><body><center style='text-align: left'>상호명: " + 
				m.get(0+nx).getName() + "<br><br>별점: "+m.get(0+nx).getStar() +
				"<br><br>주소: "+ m.get(0+nx).getAddr()+"<br><br>전화번호: "+
				m.get(0+nx).getTel() + "</center></body></html>");
	    for (ActionListener al : jb1.getActionListeners()) {
	        jb1.removeActionListener(al);
	      }
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idx = 1;
				na1 = m.get(0+nx).getName();
				DetailApp3 D;
				try {
					D = new DetailApp3();
					D.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});

		jb2.setText("<html><body><center style='text-align: left'>상호명: " + 
				m.get(1+nx).getName() + "<br><br>별점: "+m.get(1+nx).getStar() +
				"<br><br>주소: "+ m.get(1+nx).getAddr()+"<br><br>전화번호: "+
				m.get(1+nx).getTel() + "</center></body></html>");
		   for (ActionListener al : jb2.getActionListeners()) {
		        jb2.removeActionListener(al);
		      }
			jb2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					idx = 2;
					na2 = m.get(1+nx).getName();
					DetailApp3 D;
					try {
						D = new DetailApp3();
						D.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
				}
			});

		jb3.setText("<html><body><center style='text-align: left'>상호명: " + 
											m.get(2+nx).getName() + "<br><br>별점: "+m.get(2+nx).getStar() +
											"<br><br>주소: "+ m.get(2+nx).getAddr()+"<br><br>전화번호: "+
											m.get(2+nx).getTel() + "</center></body></html>");
		   for (ActionListener al : jb3.getActionListeners()) {
		        jb3.removeActionListener(al);
		      }
			jb3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					idx = 3;
					na3 = m.get(2+nx).getName();
					DetailApp3 D;
					try {
						D = new DetailApp3();
						D.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
				}
			});


	}
	else if (i == 2){		
		jb1.setText("<html><body><center style='text-align: left'>상호명: " + 
				m.get(0+nx).getName() + "<br><br>별점: "+m.get(0+nx).getStar() +
				"<br><br>주소: "+ m.get(0+nx).getAddr()+"<br><br>전화번호: "+
				m.get(0+nx).getTel() + "</center></body></html>");
		   for (ActionListener al : jb1.getActionListeners()) {
		        jb1.removeActionListener(al);
		      }
			jb1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					idx = 1;
					na1 = m.get(0+nx).getName();
					DetailApp3 D;
					try {
						D = new DetailApp3();
						D.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
				}
			});

		jb2.setText("<html><body><center style='text-align: left'>상호명: " + 
				m.get(1+nx).getName() + "<br><br>별점: "+m.get(1+nx).getStar() +
				"<br><br>주소: "+ m.get(1+nx).getAddr()+"<br><br>전화번호: "+
				m.get(1+nx).getTel() + "</center></body></html>");
		   for (ActionListener al : jb2.getActionListeners()) {
		        jb2.removeActionListener(al);
		      }
			jb2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					idx = 2;
					na2 = m.get(1+nx).getName();
					DetailApp3 D;
					try {
						D = new DetailApp3();
						D.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
				}
			});
		jb3.setText("검색 결과 없음");

		}
	else if(i == 1){

							
		jb1.setText("<html><body><center style='text-align: left'>상호명: " + 
				m.get(0+nx).getName() + "<br><br>별점: "+m.get(0+nx).getStar() +
				"<br><br>주소: "+ m.get(0+nx).getAddr()+"<br><br>전화번호: "+
				m.get(0+nx).getTel() + "</center></body></html>");
		   for (ActionListener al : jb1.getActionListeners()) {
		        jb1.removeActionListener(al);
		      }
			jb1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					idx = 1;
					na1 = m.get(0+nx).getName();
					DetailApp3 D;
					try {
						D = new DetailApp3();
						D.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
				}
			});
		jb2.setText("검색 결과 없음");
		jb3.setText("검색 결과 없음");
		}
	}
}
