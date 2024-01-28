package frame;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FrameBookInformation extends JPanel {

   public FrameBookInformation(Book b) {

      Color bgc = new Color(255, 241, 137);
      Color btc = new Color(184, 119, 249);

      setBackground(bgc);
      setLayout(null);
      setSize(600, 800);

      int width = 600; // initial panel width
      int height = 800; // initial panel height

      Font font1 = new Font("맑은고딕", Font.BOLD, 20);
      Font font2 = new Font("맑은고딕", Font.BOLD, 30);

      // 뒤로가기 버튼
//      ImageIcon image2 = new ImageIcon("./src/back.png");
//      Image img2 = image2.getImage();
//      Image updateImg2 = img2.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
//      ImageIcon updateIcon1 = new ImageIcon(updateImg2);
//      JButton btnBack = new JButton(image2);
//      btnBack.setIcon(updateIcon1);
//      btnBack.setBorderPainted(false);
//      btnBack.setBackground(bgc);
//      btnBack.setBounds(10, 7, 50, 50);
//      add(btnBack);
//
//      btnBack.addActionListener(new ActionListener() {
//
//         @Override
//         public void actionPerformed(ActionEvent e) {
//
//            if (b.getBookName() == "무지개 물고기" || b.getBookName() == "흥부와 놀부" || b.getBookName() == "아기돼지 삼형제"
//                  || b.getBookName() == "누가 내 머리에 똥 쌌어?") {
//
//               FrameBase.getInstance(new FrameBookSelect1());
//            } else {
//               FrameBase.getInstance(new FrameBookSelect2());
//            }
//         }
//      });
//
//      ImageIcon imageh = new ImageIcon("./src/home.png");
//      Image imgh = imageh.getImage();
//      Image updateImgh = imgh.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
//      ImageIcon updateIconh = new ImageIcon(updateImgh);
//      JButton home = new JButton(imageh);
//      home.setIcon(updateIconh);
//      home.setBorderPainted(false);
//      home.setContentAreaFilled(false);
//      // home.setBackground(btc);
//      home.setBounds(270, 700, 50, 50);
//      add(home);
//
//      home.addActionListener(new ActionListener() {
//
//         @Override
//         public void actionPerformed(ActionEvent e) {
//            FrameBase.getInstance(new FrameSelectAge());
//
//         }
//      });

      // 구매 url
      String[] buyurl = { "https://www.yes24.com/Product/Goods/133470", "https://www.yes24.com/Product/Goods/2720320",
            "https://www.yes24.com/Product/Goods/1315", "https://www.yes24.com/Product/Goods/110141962",
            "https://www.yes24.com/Product/Goods/22431294", "https://www.yes24.com/Product/Goods/232775",
            "https://www.yes24.com/Product/Goods/122753472", "https://www.yes24.com/Product/Goods/197687" };

      // 포스터 부분
      final int bookNum = 8;
      int bookflag = 0;
      String[] bookurl = { "./src/fish.png", "./src/brother.png", "./src/head.png", "./src/pig.png",
            "./src/prince.png", "./src/fox.png", "./src/alice.png", "./src/tree.png" };

      ImageIcon[] bookImg = new ImageIcon[bookNum];

      for (int i = 0; i < bookNum; i++) {
         bookImg[i] = new ImageIcon(bookurl[i]);
         if (b.getBookName().equals("무지개 물고기")) {
            bookflag = 0;
         } else if (b.getBookName().equals("흥부와 놀부")) {
            bookflag = 1;
         } else if (b.getBookName().equals("누가 내 머리에 똥 쌌어?")) {
            bookflag = 2;
         } else if (b.getBookName().equals("아기돼지 삼형제")) {
            bookflag = 3;
         } else if (b.getBookName().equals("어린왕자")) {
            bookflag = 4;
         } else if (b.getBookName().equals("책 먹는 여우")) {
            bookflag = 5;
         } else if (b.getBookName().equals("이상한 나라의 앨리스")) {
            bookflag = 6;
         } else if (b.getBookName().equals("아낌없이 주는 나무")) {
            bookflag = 7;
         }
      }

      ImageIcon icon = new ImageIcon(bookImg[bookflag].getImage().getScaledInstance(140, 220, Image.SCALE_SMOOTH));
      JLabel jl = new JLabel(icon);
      jl.setBounds(20, 70, 140, 220);
      add(jl);

      // 책 제목
      RoundedButton bName = new RoundedButton(b.getBookName());
      bName.setHorizontalAlignment(JLabel.CENTER);
      bName.setBounds(170, 70, 380, 80);
      bName.setFont(font2);
      add(bName);

      // 저자
      JLabel cName = new JLabel("저자 : " + b.getBookPub());
      cName.setHorizontalAlignment(JLabel.CENTER);
      cName.setBounds(160, 140, 400, 90);
      cName.setFont(font1);
      add(cName);

      // 출판사
      JLabel bDate = new JLabel("출판사 : " + b.getBookCop());
      bDate.setHorizontalAlignment(JLabel.CENTER);
      bDate.setBounds(160, 180, 400, 90);
      bDate.setFont(font1);
      add(bDate);

      //구매하기
      ImageIcon buy = new ImageIcon("./src/buy.png");
      Image buyImg = buy.getImage();
      Image updatebuyImg = buyImg.getScaledInstance(100, 113, Image.SCALE_SMOOTH);
      ImageIcon updateBuy = new ImageIcon(updatebuyImg);
      JButton btnBuy = new JButton(buy);
      btnBuy.setIcon(updateBuy);
      btnBuy.setBorderPainted(false);
      btnBuy.setBackground(new Color(255, 241, 137));
      btnBuy.setLocation(40, 300);
      btnBuy.setSize(100, 80);
      add(btnBuy);

      
      btnBuy.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            int bookIndex = 0; // Set the default index here
            if (b.getBookName().equals("무지개 물고기")) {
               bookIndex = 0;
            } else if (b.getBookName().equals("흥부와 놀부")) {
               bookIndex = 1;
            } else if (b.getBookName().equals("누가 내 머리에 똥 쌌어?")) {
               bookIndex = 2;
            } else if (b.getBookName().equals("아기돼지 삼형제")) {
               bookIndex = 3;
            } else if (b.getBookName().equals("어린왕자")) {
               bookIndex = 4;
            } else if (b.getBookName().equals("책 먹는 여우")) {
               bookIndex = 5;
            } else if (b.getBookName().equals("이상한 나라의 앨리스")) {
               bookIndex = 6;
            } else if (b.getBookName().equals("아낌없이 주는 나무")) {
               bookIndex = 7;
            }

            try {
               Desktop.getDesktop().browse(new URI(buyurl[bookIndex]));
            } catch (IOException | URISyntaxException ex) {

               ex.printStackTrace();
            }
         }
      });

      // 책 소개
//      JLabel bin = new JLabel("책 소개");
//      bin.setHorizontalAlignment(JLabel.CENTER);
//      bin.setBounds(width * 1 / 3, 295, width * 1 / 3, 50);
//      bin.setFont(font1);
//      add(bin);

      // 책 소개글s
      JTextArea bi = new JTextArea(b.getBookInt());

      JScrollPane sP = new JScrollPane(bi, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      bi.setLineWrap(true);
      bi.setFont(new Font("맑은고딕", Font.BOLD, 16));
      bi.setEditable(false);
      sP.setBounds(170, 260, 400, 120);
      setVisible(true);
      add(sP);

      // 퀴즈버튼
      RoundedButton btnQ = new RoundedButton("퀴즈 풀러가기");
      btnQ.setBorderPainted(false);
      btnQ.setFocusPainted(false);
      btnQ.setBounds(20, 420, 540, 80);
      btnQ.setBackground(new Color(184, 119, 249));
      btnQ.setFont(new Font("맑은고딕", Font.BOLD, 25));
      add(btnQ);

      // 독후감 버튼
      RoundedButton btnD = new RoundedButton("독후감 쓰러가기");
      btnD.setBorderPainted(false);
      btnD.setFocusPainted(false);
      btnD.setBounds(20, 520, 540, 80);
      btnD.setBackground(new Color(184, 119, 249));
      btnD.setFont(new Font("맑은고딕", Font.BOLD, 25));
      add(btnD);

//      btnBack.addActionListener(new ActionListener() {
//
//         @Override
//         public void actionPerformed(ActionEvent e) {
//
//         }
//      });

      btnQ.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            FrameBase.getInstance(new FrameQuiz1(b));

         }
      });

      btnD.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            FrameBase.getInstance(new FrameBookReviewPage(b));

         }
      });
      
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
    				if (b.getBookName() == "무지개 물고기" || b.getBookName() == "흥부와 놀부" || b.getBookName() == "아기돼지 삼형제"
   	                  || b.getBookName() == "누가 내 머리에 똥 쌌어?") {
    	
    	               FrameBase.getInstance(new FrameBookSelect1());
    	            } else {
    	               FrameBase.getInstance(new FrameBookSelect2());
    	            }
    				
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