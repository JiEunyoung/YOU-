package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FrameLogin extends JPanel {

   static String filename = "회원명단.txt";
   
   public FrameLogin() {
      //this.frameLoginPanel = homePanel;

      // JPanel 구조
      Color bgc = new Color(255, 241, 137);
      Color btc = new Color(184, 119, 249);
      setBackground(new Color(255, 241, 137));
      setLayout(null);
      setSize(600, 800);

      // 아이디, 비번 입력창
      JLabel labelID = new JLabel("ID");
      JLabel labelPW = new JLabel("PW");
      JTextField tfID = new JTextField(10);
      JPasswordField tfPW = new JPasswordField(10);

      labelID.setSize(300, 50);
      labelID.setLocation(getWidth() / 5, 310);
      labelID.setFont(new Font("맑은고딕", Font.BOLD, 20));

      labelPW.setSize(300, 50);
      labelPW.setLocation(getWidth() / 5, 380);
      labelPW.setFont(new Font("맑은고딕", Font.BOLD, 20));

      tfID.setSize(300, 50);
      tfID.setLocation(getWidth() / 6 + 70, 310);
      tfID.setFont(new Font("맑은고딕", Font.BOLD, 20));

      tfPW.setSize(300, 50);
      tfPW.setLocation(getWidth() / 6 + 70, 380);
      tfPW.setFont(new Font("맑은고딕", Font.BOLD, 20));
      tfPW.setEchoChar('*');

      add(labelID);
      add(labelPW);
      add(tfID);
      add(tfPW);
      
      RoundedButton btnLogin = new RoundedButton("로그인");
      RoundedButton btnJoin = new RoundedButton("회원가입");
      RoundedButton btnFind = new RoundedButton("회원 정보 찾기");


      
      ImageIcon image2 = new ImageIcon("./src/panda.png");
      Image img2 = image2.getImage();
       Image updateImg2 = img2.getScaledInstance(230, 270, Image.SCALE_SMOOTH);
        ImageIcon updateIcon1 = new ImageIcon(updateImg2);
      JLabel logo = new JLabel(image2);
      logo.setIcon(updateIcon1);
      logo.setBackground(bgc);
      logo.setBounds(200, 30, 200, 270);
      add(logo);
      
      
      

      btnLogin.setSize(300, 40);
      btnLogin.setLocation(getWidth() / 4 - 5, 470);
      btnLogin.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 22));

      btnJoin.setSize(300, 40);
      btnJoin.setLocation((int) btnLogin.getLocation().getX(), (int) btnLogin.getLocation().getY() + 70);
      btnJoin.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 22));
      
      btnFind.setSize(300, 40);
      btnFind.setLocation((int) btnLogin.getLocation().getX(), (int) btnLogin.getLocation().getY() + 140);
      btnFind.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 22));


      add(btnLogin);
      add(btnJoin);
      add(btnFind);


      
      
      btnJoin.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            FrameJoin frameJoin = new FrameJoin();
              
              JFrame frame = (JFrame) FrameLogin.this.getTopLevelAncestor();
              frame.getContentPane().removeAll();
              
              frame.getContentPane().add(frameJoin);
              
              frame.revalidate();
              frame.repaint();
         }
      });
      
      btnLogin.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            
            MemberController cm = new MemberController();
            ArrayList<Member> memberArr = cm.readFile(filename);
            MemberList memberList = new MemberList();
            
            for(int i=0; i<memberArr.size(); i++) {
               memberList.addMember(memberArr.get(i));
            }
            
            String id = tfID.getText();
            String idCheck = memberList.loginMember(id);
            
            if(idCheck.isEmpty()) {
               JOptionPane.showMessageDialog(null, "아이디를 확인해주세요.");
            } else {
               if(idCheck.equals(new String(tfPW.getPassword()))) {
                  MemberToken.tokenID = id;
                  JOptionPane.showMessageDialog(null, id + "님, 환영합니다!");
                  FrameSelectAge frameSelectAge = new FrameSelectAge();
                    
                    JFrame frame = (JFrame) FrameLogin.this.getTopLevelAncestor();
                    frame.getContentPane().removeAll();
                    
                    frame.getContentPane().add(frameSelectAge);
                    
                    frame.revalidate();
                    frame.repaint();
               } else {
                  JOptionPane.showMessageDialog(null, "비밀번호를 확인해주세요.");
               }
            }
            
         }
      });

      btnFind.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	        // 회원 정보 찾기 버튼을 클릭했을 때 FrameFindInfo를 열도록 코드 추가
    	        FrameFindInfo frameFindInfo = new FrameFindInfo();

    	        JFrame frame = (JFrame) FrameLogin.this.getTopLevelAncestor();
    	        frame.getContentPane().removeAll();

    	        frame.getContentPane().add(frameFindInfo);

    	        frame.revalidate();
    	        frame.repaint();
    	    }
    	});
      
   }// 생성자
   
}