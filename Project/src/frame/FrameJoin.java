package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.PublicKey;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FrameJoin extends JPanel {
	static String filename = "회원명단.txt";
	
	public FrameJoin() {
		
		Font font2 = new Font("맑은고딕", Font.BOLD, 30);
		Color bgc = new Color(255, 241, 137);
		Color btc = new Color(184, 119, 249);
		setBackground(new Color(255, 241, 137));
		setLayout(null);
		setSize(600, 800);

		// 아이디, 비번 닉네임, 전화번호 입력창
		JLabel lID = new JLabel("ID");
		JLabel lPW = new JLabel("PW");
		JLabel lnickName = new JLabel("닉네임");
		JLabel lPhoneNum = new JLabel("전화번호");
		JTextField tfnickName = new JTextField(10);
		JTextField tfID = new JTextField(10);
		JPasswordField tfPW = new JPasswordField(10);
		JTextField tfPhoneNum = new JTextField(10);
		
		ImageIcon image2 = new ImageIcon("./src/back.png");
		Image img12 = image2.getImage();
		Image updateImg12 = img12.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon updateIcon12 = new ImageIcon(updateImg12);
		JButton btnBack = new JButton(image2);
		btnBack.setIcon(updateIcon12);
		btnBack.setBorderPainted(false);
		btnBack.setBackground(bgc);
		btnBack.setBounds(10, 10, 50, 50);
		add(btnBack);
		
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getInstance(new FrameLogin());
				
			}
		});
		
		lID.setSize(300, 50);
		lID.setLocation(getWidth() / 6, 220);
		lID.setFont(new Font("맑은고딕", Font.BOLD, 20));

		lPW.setSize(300, 50);
		lPW.setLocation(getWidth() / 6, 290);
		lPW.setFont(new Font("맑은고딕", Font.BOLD, 20));

		lnickName.setSize(300, 50);
		lnickName.setLocation(getWidth() / 7, 360);
		lnickName.setFont(new Font("맑은고딕", Font.BOLD, 20));
		
		lPhoneNum.setSize(300, 50);
		lPhoneNum.setLocation(getWidth() / 8, 430);
		lPhoneNum.setFont(new Font("맑은고딕", Font.BOLD, 20));
		
		//아이디 입력 칸
		tfID.setSize(300, 50);
		tfID.setLocation(getWidth() / 6 + 70, 220);
		tfID.setFont(new Font("맑은고딕", Font.BOLD, 20));

		//비번 입력 칸
		tfPW.setSize(300, 50);
		tfPW.setLocation(getWidth() / 6 + 70, 290);
		tfPW.setFont(new Font("맑은고딕", Font.BOLD, 20));
		tfPW.setEchoChar('*');

		//닉네임 입력 칸
		tfnickName.setSize(300, 50);
		tfnickName.setLocation(getWidth() / 6 + 70, 360);
		tfnickName.setFont(new Font("맑은고딕", Font.BOLD, 20));
		
		//전화번호 입력 칸
		tfPhoneNum.setSize(300, 50);
		tfPhoneNum.setLocation(getWidth() / 6 + 70, 430);
		tfPhoneNum.setFont(new Font("맑은고딕", Font.BOLD, 20));

		add(lnickName);
		add(lID);
		add(lPW);
		add(tfnickName);
		add(tfID);
		add(tfPW);
		add(lPhoneNum);
		add(tfPhoneNum);
		
		RoundedButton btnJoin = new RoundedButton("가입하기");
		
		btnJoin.setSize(300, 40);
		btnJoin.setLocation(getWidth() / 4 - 5, 520);

		btnJoin.setFont(new Font("맑은고딕", Font.BOLD, 22));

		add(btnJoin);
		
		//가입하기 버튼
		btnJoin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String inputID = tfID.getText();
				String inputPW = new String(tfPW.getPassword());
				String inputNickName = tfnickName.getText();
				String inputPhoneNum = tfPhoneNum.getText();
				
				
				if(!inputID.isEmpty() && !inputPW.isEmpty() && !inputNickName.isEmpty()) {
					
					MemberController cm = new MemberController();
					ArrayList<Member> memberArr = cm.readFile(filename);
					MemberList memberList = new MemberList();
					
					for(int i=0; i<memberArr.size(); i++) {
						memberList.addMember(memberArr.get(i));
					}
					
					String idCheck = memberList.joinMember(inputID);
					
					if(!idCheck.isEmpty()) {
						JOptionPane.showMessageDialog(null, idCheck);
						return;
					}
					
					try (BufferedWriter br = new BufferedWriter(new FileWriter("회원명단.txt", true))){
						br.write(inputID + "/");
						br.write(inputPW + "/");
						br.write(inputNickName + "/");
						br.write(inputPhoneNum + "\n");
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "회원가입에 실패했습니다.");
					}
					
					JOptionPane.showMessageDialog(null, "회원 가입에 성공했습니다!");
					FrameLogin frameLogin = new FrameLogin();
			        
			        JFrame frame = (JFrame) FrameJoin.this.getTopLevelAncestor();
			        frame.getContentPane().removeAll();
			        
			        frame.getContentPane().add(frameLogin);
			        
			        frame.revalidate();
			        frame.repaint();
					
				}else {
					JOptionPane.showMessageDialog(null, "회원가입에 실패했습니다.");
				}
				
			}
		});
		
	}

	
}

