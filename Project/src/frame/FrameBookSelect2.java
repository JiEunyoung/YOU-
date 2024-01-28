package frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameBookSelect2 extends JPanel {

	public FrameBookSelect2() {

		Font font2 = new Font("맑은고딕", Font.BOLD, 30);
		Color bgc = new Color(255, 241, 137);
		Color btc = new Color(184, 119, 249);

		setBackground(bgc);
		setLayout(null);
		setSize(600, 800);

		// 책목록 타이틀 패널
		JPanel bst = new JPanel();
		bst.setLayout(null);
		bst.setBounds(0, 0, 600, 100);
		bst.setBackground(bgc);
		add(bst);

		RoundedLabel Bs = new RoundedLabel("책 목록");
		Bs.setHorizontalAlignment(JLabel.CENTER);
		Bs.setFont(font2);
		Bs.setForeground(Color.white);
		Bs.setBounds(200, 30, 200, 70);
		Bs.setBackground(btc);
		bst.add(Bs);

		// 뒤로가기 버튼
//		ImageIcon image2 = new ImageIcon("./src/back.png");
//		Image img12 = image2.getImage();
//		Image updateImg12 = img12.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
//		ImageIcon updateIcon12 = new ImageIcon(updateImg12);
//		JButton btnBack = new JButton(image2);
//		btnBack.setIcon(updateIcon12);
//		btnBack.setBorderPainted(false);
//		btnBack.setBackground(bgc);
//		btnBack.setBounds(10, 7, 50, 50);
//		add(btnBack);
//
//		btnBack.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//
//				FrameBase.getInstance(new FrameSelectAge());
//			}
//		});
//		
//		ImageIcon imageh = new ImageIcon("./src/home.png");
//		Image imgh = imageh.getImage();
//		Image updateImgh = imgh.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
//		ImageIcon updateIconh = new ImageIcon(updateImgh);
//		JButton home = new JButton(imageh);
//		home.setIcon(updateIconh);
//		home.setBorderPainted(false);
//		home.setContentAreaFilled(false);
//		//home.setBackground(btc);
//		home.setBounds(270, 700, 50, 50);
//		add(home);
//		
//		home.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				FrameBase.getInstance(new FrameSelectAge());
//				
//			}
//		});

		// 선반 패널
		JPanel tjsqks = new JPanel();
		tjsqks.setBounds(20, 130, 545, 540);
		tjsqks.setLayout(null);
		tjsqks.setBackground(Color.white);
		add(tjsqks);

		// 책장 사진틀
		ImageIcon bw;
		bw = new ImageIcon("./src/bs.jpg");
		Image img = bw.getImage();
		Image updateImg = img.getScaledInstance(545, 540, Image.SCALE_SMOOTH);
		ImageIcon updateIcon = new ImageIcon(updateImg);
		JLabel bt = new JLabel(bw);
		bt.setIcon(updateIcon);
		bt.setBounds(0, 0, 545, 540);
		tjsqks.add(bt);

		// 책1 패널--------------- 절댓값 X 25 시작 312끝
		JPanel cor1 = new JPanel();
		cor1.setBounds(0, 10, 272, 250);
		cor1.setLayout(new BoxLayout(cor1, BoxLayout.Y_AXIS));
		cor1.setBackground(Color.white);
		tjsqks.add(cor1);

		// 책1 명패
		cor1.add(Box.createVerticalStrut(15));
		JLabel b1N = new JLabel("어린왕자");
		b1N.setAlignmentX(Component.CENTER_ALIGNMENT);
		b1N.setBounds(20, 20, 252, 50);
		b1N.setBackground(Color.white);
		b1N.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		cor1.add(b1N);

		// 책1 사진
		ImageIcon b1;
		b1 = new ImageIcon("./src/prince.png");
		Image img1 = b1.getImage();
		Image updateImg1 = img1.getScaledInstance(140, 180, Image.SCALE_SMOOTH);
		ImageIcon updateIcon1 = new ImageIcon(updateImg1);
		JButton bk1 = new JButton(b1);
		bk1.setBorderPainted(false);
		bk1.setFocusPainted(false);
		bk1.setContentAreaFilled(false);
		bk1.setAlignmentX(Component.CENTER_ALIGNMENT);
		bk1.setIcon(updateIcon1);
		bk1.setBounds(20, 70, 140, 180);
		// cor1.add(Box.createVerticalStrut(20));
		cor1.add(bk1);

		bk1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Book book5 = new BookDAO().searchBook2("어린왕자");
				FrameBase.getInstance(new FrameBookInformation(book5));
			}
		});

		// 책2 패널--------------- 절댓값 X 282 시작 545끝
		JPanel cor2 = new JPanel();
		cor2.setBounds(277, 10, 272, 250);
		cor2.setLayout(new BoxLayout(cor2, BoxLayout.Y_AXIS));
		cor2.setBackground(Color.white);
		tjsqks.add(cor2);

		// 책2 명패
		cor2.add(Box.createVerticalStrut(15));
		JLabel b2N = new JLabel("책 먹는 여우");
		b2N.setAlignmentX(Component.CENTER_ALIGNMENT);
		b2N.setBounds(20, 20, 252, 50);
		b2N.setBackground(Color.white);
		b2N.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		cor2.add(b2N);

		// 책2 사진
		ImageIcon b2;
		b2 = new ImageIcon("./src/fox.png");
		Image img2 = b2.getImage();
		Image updateImg2 = img2.getScaledInstance(140, 180, Image.SCALE_SMOOTH);
		ImageIcon updateIcon2 = new ImageIcon(updateImg2);
		JButton bk2 = new JButton(b2);
		bk2.setBorderPainted(false);
		bk2.setFocusPainted(false);
		bk2.setContentAreaFilled(false);
		bk2.setAlignmentX(Component.CENTER_ALIGNMENT);
		bk2.setIcon(updateIcon2);
		bk2.setBounds(20, 70, 140, 180);
		cor2.add(bk2);

		bk2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Book book6 = new BookDAO().searchBook2("책 먹는 여우");
				FrameBase.getInstance(new FrameBookInformation(book6));
			}
		});

		// 책3 패널--------------- 절댓값 X 25 시작 312끝
		JPanel cor3 = new JPanel();
		cor3.setBounds(0, 270, 272, 270);
		cor3.setLayout(new BoxLayout(cor3, BoxLayout.Y_AXIS));
		cor3.setBackground(Color.white);
		tjsqks.add(cor3);

		// 책3 명패
		cor3.add(Box.createVerticalStrut(15));
		JLabel b3N = new JLabel("이상한 나라의 앨리스");
		b3N.setAlignmentX(Component.CENTER_ALIGNMENT);
		b3N.setBounds(20, 20, 252, 50);
		b3N.setBackground(Color.white);
		b3N.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		cor3.add(b3N);

		// 책3 사진
		ImageIcon b3;
		b3 = new ImageIcon("./src/alice.png");
		Image img3 = b3.getImage();
		Image updateImg3 = img3.getScaledInstance(140, 180, Image.SCALE_SMOOTH);
		ImageIcon updateIcon3 = new ImageIcon(updateImg3);
		JButton bk3 = new JButton(b3);
		bk3.setBorderPainted(false);
		bk3.setFocusPainted(false);
		bk3.setContentAreaFilled(false);
		bk3.setAlignmentX(Component.CENTER_ALIGNMENT);
		bk3.setIcon(updateIcon3);
		bk3.setBounds(20, 70, 140, 180);
		cor3.add(bk3);

		bk3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Book book7 = new BookDAO().searchBook2("이상한 나라의 앨리스");
				FrameBase.getInstance(new FrameBookInformation(book7));
			}
		});

		// 책4 패널--------------- 절댓값 X 282 시작 545끝
		JPanel cor4 = new JPanel();
		cor4.setBounds(277, 270, 272, 270);
		cor4.setLayout(new BoxLayout(cor4, BoxLayout.Y_AXIS));
		cor4.setBackground(Color.white);
		tjsqks.add(cor4);

		// 책3 명패
		cor4.add(Box.createVerticalStrut(15));
		JLabel b4N = new JLabel("아낌없이 주는 나무");
		b4N.setAlignmentX(Component.CENTER_ALIGNMENT);
		b4N.setBounds(20, 20, 252, 50);
		b4N.setBackground(Color.white);
		b4N.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		cor4.add(b4N);

		// 책4 사진
		ImageIcon b4;
		b4 = new ImageIcon("./src/tree.png");
		Image img4 = b4.getImage();
		Image updateImg4 = img4.getScaledInstance(140, 180, Image.SCALE_SMOOTH);
		ImageIcon updateIcon4 = new ImageIcon(updateImg4);
		JButton bk4 = new JButton(b4);
		bk4.setBorderPainted(false);
		bk4.setFocusPainted(false);
		bk4.setContentAreaFilled(false);
		bk4.setAlignmentX(Component.CENTER_ALIGNMENT);
		bk4.setIcon(updateIcon4);
		bk3.setBounds(20, 70, 140, 180);
		cor4.add(bk4);

		bk4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Book book8 = new BookDAO().searchBook2("아낌없이 주는 나무");
				FrameBase.getInstance(new FrameBookInformation(book8));
			}
		});

		setVisible(true);
		
		//하단 고정 버튼
				JPanel fixed = new JPanel();
				fixed.setSize(600, 130);
				fixed.setLocation(0, 700);
				fixed.setBackground(new Color(184, 119, 249));
				fixed.setLayout(null);
				add(fixed);
				
				
				ImageIcon back = new ImageIcon("./src/btnback.png");
				Image backImg = back.getImage();
				Image updatebackImg = backImg.getScaledInstance(85, 85, Image.SCALE_SMOOTH);
				ImageIcon updateWrong = new ImageIcon(updatebackImg);
				JButton btnback = new JButton(back);
				btnback.setIcon(updateWrong);
				btnback.setBorderPainted(false);
				//btnback.setBackground(new Color(255, 241, 137));
				btnback.setSize(93, 94);
				btnback.setLocation(60, -20);
				btnback.setBackground(new Color(184, 119, 249));
				//btnback.setBounds(330, 300, 100, 113);
				fixed.add(btnback);
				
				ImageIcon home = new ImageIcon("./src/btnhome.png");
				Image homeImg = home.getImage();
				Image updatehomeImg = homeImg.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
				ImageIcon updateHome = new ImageIcon(updatehomeImg);
				JButton btnhome = new JButton(home);
				btnhome.setIcon(updateHome);
				btnhome.setBorderPainted(false);
				//btnback.setBackground(new Color(255, 241, 137));
				btnhome.setSize(85, 85);
				btnhome.setLocation(250, -10);
				btnhome.setBackground(new Color(184, 119, 249));
				//btnback.setBounds(330, 300, 100, 113);
				fixed.add(btnhome);
				
				ImageIcon my = new ImageIcon("./src/btnmy.png");
				Image myImg = my.getImage();
				Image updatemyImg =myImg.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
				ImageIcon updateMy = new ImageIcon(updatemyImg);
				JButton btnmy = new JButton(my);
				btnmy.setIcon(updateMy);
				btnmy.setBorderPainted(false);
				//btnback.setBackground(new Color(255, 241, 137));
				btnmy.setSize(85, 85);
				btnmy.setLocation(440, -15);
				btnmy.setBackground(new Color(184, 119, 249));
				//btnback.setBounds(330, 300, 100, 113);
				fixed.add(btnmy);
				
				btnback.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						FrameBase.getInstance(new FrameSelectAge());
						
					}
				});
				
				btnhome.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						FrameBase.getInstance(new FrameSelectAge());
						
					}
				});
				
				btnmy.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
					}
				});

	}

}