package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
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

public class FrameFindInfo extends JPanel {
	static String filename = "회원명단.txt";
	private boolean findIdMode = true; // 초기 모드는 ID 찾기
	
	public FrameFindInfo() {

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
		JButton FindId = new JButton("ID 찾기");
		JButton FindPw = new JButton("PW 찾기");
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
		lID.setEnabled(false);

		lPW.setSize(300, 50);
		lPW.setLocation(getWidth() / 6, 290);
		lPW.setFont(new Font("맑은고딕", Font.BOLD, 20));
		lPW.setEnabled(false);
		
		lnickName.setSize(300, 50);
		lnickName.setLocation(getWidth() / 7, 360);
		lnickName.setFont(new Font("맑은고딕", Font.BOLD, 20));
		lnickName.setEnabled(false);
		
		lPhoneNum.setSize(300, 50);
		lPhoneNum.setLocation(getWidth() / 8, 430);
		lPhoneNum.setFont(new Font("맑은고딕", Font.BOLD, 20));
		lPhoneNum.setEnabled(false);
		
		// 아이디 입력 칸
		tfID.setSize(300, 50);
		tfID.setLocation(getWidth() / 6 + 70, 220);
		tfID.setFont(new Font("맑은고딕", Font.BOLD, 20));
		tfID.setEnabled(false);
		
		// 비번 입력 칸
		tfPW.setSize(300, 50);
		tfPW.setLocation(getWidth() / 6 + 70, 290);
		tfPW.setFont(new Font("맑은고딕", Font.BOLD, 20));
		tfPW.setEchoChar('*');
		tfPW.setEnabled(false);
		
		// 닉네임 입력 칸
		tfnickName.setSize(300, 50);
		tfnickName.setLocation(getWidth() / 6 + 70, 360);
		tfnickName.setFont(new Font("맑은고딕", Font.BOLD, 20));
		tfnickName.setEnabled(false);
		
//		전화번호 입력 칸
		tfPhoneNum.setSize(300, 50);
		tfPhoneNum.setLocation(getWidth() / 6 + 70, 430);
		tfPhoneNum.setFont(new Font("맑은고딕", Font.BOLD, 20));
		tfPhoneNum.setEnabled(false);
		// Id 찾기
		FindId.setBounds(getWidth() / 2 - 171, getHeight() / 10, 170, 70);
		FindId.setFont(new Font("맑은고딕", Font.BOLD, 20));

		// pw 찾기
		FindPw.setBounds(getWidth() / 2, getHeight() / 10, 170, 70);
		FindPw.setFont(new Font("맑은고딕", Font.BOLD, 20));

		Color OrgColor = FindId.getBackground();
		
		add(lnickName);
		add(lID);
		add(lPW);
		add(tfnickName);
		add(tfID);
		add(tfPW);
		add(lPhoneNum);
		add(tfPhoneNum);
		add(FindId);
		add(FindPw);

		RoundedButton btnFind = new RoundedButton("찾기");
        btnFind.setSize(300, 40);
        btnFind.setLocation(getWidth() / 4 - 5, 520);
        btnFind.setFont(new Font("맑은고딕", Font.BOLD, 22));
        btnFind.setEnabled(false);
        add(btnFind);
		
//ID 찾기 클릭시
		FindId.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				findIdMode = true;
				tfID.setEnabled(false);
				tfPW.setEnabled(false);
				tfnickName.setEnabled(false);
				tfPhoneNum.setEnabled(true);
				lID.setEnabled(false);
				lPW.setEnabled(false);
				lnickName.setEnabled(false);
				lPhoneNum.setEnabled(true);
				btnFind.setEnabled(true);
				tfID.setText("");
				tfPhoneNum.setText("");
				FindId.setBackground(btc);
				FindPw.setBackground(OrgColor);

			}
		});
//pw 찾기 클릭시
		FindPw.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	findIdMode = false;
				tfID.setEnabled(true);
				tfPW.setEnabled(false);
				tfnickName.setEnabled(false);
				tfPhoneNum.setEnabled(true);
				lID.setEnabled(true);
				lPW.setEnabled(false);
				lnickName.setEnabled(false);
				lPhoneNum.setEnabled(true);
				btnFind.setEnabled(true);
				tfID.setText("");
				tfPhoneNum.setText("");
				FindPw.setBackground(btc);
				FindId.setBackground(OrgColor);
		    }
		});
		
        btnFind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // tfPhoneNum에서 입력한 전화번호를 가져옵니다.
                String phoneNumber = tfPhoneNum.getText();

                if (findIdMode) { // ID 찾기 모드
                    // 회원 명단 파일을 읽어서 전화번호가 일치하는 회원의 ID를 찾습니다.
                    String idFound = findIdByPhoneNumber(phoneNumber);

                    if (idFound != null) {
                        showMessage("회원의 ID는:  " + idFound + " 입니다");
                    } else {
                        showMessage("일치하는 회원님을 찾을 수 없습니다.");
                    }
                } else { // 비밀번호 찾기 모드
                    // ID와 전화번호를 가져옵니다.
                    String id = tfID.getText();
                    String pwFound = findPasswordByPhoneNumber(id, phoneNumber);

                    if (pwFound != null) {
                        showMessage("회원님의 비밀번호는:  " + pwFound + " 입니다");
                    } else {
                        showMessage("일치하는 회원정보가 없습니다.");
                    }
                }

                // 입력 필드와 버튼을 초기화합니다.
                tfID.setText("");
                tfPhoneNum.setText("");
            }
        });
    }

    // 전화번호로 회원 ID를 찾는 메서드
    private String findIdByPhoneNumber(String phoneNumber) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("/");
                if (parts.length >= 4) {
                    String id = parts[0];
                    String phone = parts[3];
                    if (phone.equals(phoneNumber)) {
                        return id;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // 일치하는 회원을 찾지 못한 경우 null 반환
    }

    // ID와 전화번호로 회원 비밀번호를 찾는 메서드
    private String findPasswordByPhoneNumber(String id, String phoneNumber) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("/");
                if (parts.length >= 4) {
                    String foundId = parts[0];
                    String foundPhone = parts[3];
                    if (foundId.equals(id) && foundPhone.equals(phoneNumber)) {
                        return parts[1]; // 비밀번호 반환
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // 일치하는 회원을 찾지 못한 경우 null 반환
    }
    
    private void showMessage(String message) {
        JLabel messageLabel = new JLabel(message);
        messageLabel.setFont(new Font("맑은고딕", Font.BOLD, 20));
        JOptionPane.showMessageDialog(null, messageLabel);
    }
}


