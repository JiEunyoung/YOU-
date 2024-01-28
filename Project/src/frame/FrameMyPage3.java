package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class FrameMyPage3 extends JPanel {
   static String filename1 = "독후감.txt";
   static String filename = "회원명단.txt";
   
   private String id;

   public FrameMyPage3(Book b) throws UnsupportedEncodingException {
      Color bgc = new Color(255, 241, 137);
      setBackground(new Color(255, 241, 137));
      setLayout(null);
      setSize(600, 800);

      int width = 600; // initial panel width
      int height = 800; // initial panel height
      
      
      MemberController cm = new MemberController();
      ArrayList<Member> memberArr = cm.readFile(filename);
      MemberList memberList = new MemberList();
      
      for(int i=0; i< memberArr.size(); i++) {
    	  memberList.addMember(memberArr.get(i));
      }
      this.id = MemberToken.getTokenID();
      String name = memberList.infoName(id);
      
      

      // Center Title Label
      RoundedLabel CenterTitle = new RoundedLabel("내 독후감");
      CenterTitle.setFont(new Font("맑은 고딕", Font.BOLD, 30));
      CenterTitle.setOpaque(true);
      CenterTitle.setBackground(new Color(184, 119, 249));
      CenterTitle.setHorizontalAlignment(SwingConstants.CENTER);
      CenterTitle.setBounds(width / 5, 20, width * 3 / 5, 60);
      add(CenterTitle);
      
      
		/*
		 * RoundedLabel nickName = new RoundedLabel(name + "님의 페이지");
		 * nickName.setFont(new Font("맑은 고딕", Font.BOLD, 30)); nickName.setOpaque(true);
		 * nickName.setBackground(new Color(184, 119, 249));
		 * nickName.setHorizontalAlignment(SwingConstants.CENTER);
		 * nickName.setBounds(width / 5, 150, width * 3 / 5, 60); add(nickName);
		 */


      // Title Label
      /*
       * RoundedLabel titleLabel = new RoundedLabel("칭호: 설인의 추억");
       * titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
       * titleLabel.setOpaque(true); titleLabel.setBackground(new Color(184, 119,
       * 249)); titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
       * titleLabel.setBounds(width * 1 / 10, height * 3 / 20, width * 8 / 10, height
       * / 20); add(titleLabel);
       */   

      // Create a DefaultListModel to hold the book titles
      DefaultListModel<ReviewEntry> titleListModel = new DefaultListModel<>();

      try {
         // Read titles from the "독후감.txt" file and add them to the list model
         BufferedReader reader = new BufferedReader(new FileReader(filename1));
         String line;
         int currentIndex = 1; // 초기 인덱스 값
         while ((line = reader.readLine()) != null) {
            // Assuming each line in the file contains index/title/date/content separated by
            // "/"
            String[] parts = line.split("/");
            if (parts.length >= 4) {
               String title = parts[1];
               String date = parts[2];
               String content = parts[3];
               titleListModel.addElement(new ReviewEntry(currentIndex, title, date, content));
               currentIndex++; // 다음 인덱스 계산
            }
         }
         reader.close();
      } catch (IOException e) {
         e.printStackTrace();
      }

      // Create a JList with the titleListModel
      JList<ReviewEntry> titleList = new JList<>(titleListModel);
      titleList.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
      JScrollPane scrollPane = new JScrollPane(titleList);
      scrollPane.setBounds(width / 10, height * 2 / 10, width * 8 / 10, 500);
      add(scrollPane);

      // 더블클릭
      titleList.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
               int selectedIndex = titleList.getSelectedIndex();
               if (selectedIndex >= 0) {
                  ReviewEntry selectedEntry = titleListModel.getElementAt(selectedIndex);
                  int selectedEntryIndex = selectedEntry.getIndex();
                  String selectedTitle = selectedEntry.getTitle();
                  new FrameReviewText(selectedEntryIndex, selectedTitle);
               }
            }
         }
      });

//      // 뒤로가기
//      ImageIcon image2 = new ImageIcon("./src/back.png");
//      Image img12 = image2.getImage();
//      Image updateImg12 = img12.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
//      ImageIcon updateIcon12 = new ImageIcon(updateImg12);
//      JButton btnBack = new JButton(image2);
//      btnBack.setIcon(updateIcon12);
//      btnBack.setBorderPainted(false);
//      btnBack.setBackground(bgc);
//      btnBack.setBounds(10, 10, 50, 50);
//      add(btnBack);
//
//      btnBack.addActionListener(new ActionListener() {
//         @Override
//         public void actionPerformed(ActionEvent e) {
//            FrameBase.getInstance(new FrameBookReviewPage(b));
//            
//         }
//      });
//      
//      ImageIcon imageh = new ImageIcon("./src/home.png");
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
    				FrameBase.getInstance(new FrameBookReviewPage(b));
    				
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

class ReviewEntry {
   private int index;
   private String title;
   private String date;
   private String content;

   public ReviewEntry(int index, String title, String date, String content) {
      this.index = index;
      this.title = title;
      this.date = date;
      this.content = content;
   }

   public int getIndex() {
      return index;
   }

   public String getTitle() {
      return title;
   }

   public String getDate() {
      return date;
   }

   public String getContent() {
      return content;
   }

   @Override
   public String toString() {
      return index + ": " + title;
   }
}