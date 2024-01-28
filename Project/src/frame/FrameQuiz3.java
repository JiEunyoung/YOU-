package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameQuiz3 extends JPanel {
	
	//public static int rightNum3 = FrameQuiz2.rightNum2;
	public int rightNum3;
    public FrameQuiz3(Book b, int rightNum2) {
    	//String text = "<html><br>앨리스가 이상한 나라에서 크기를 <br>조절할 수 있는 물건은 초콜릿입니다.</html>";
    	Font font2 = new Font("맑은고딕", Font.BOLD, 30);
    	Color bgc = new Color(255, 241, 137);
		Color btc = new Color(184, 119, 249);
    	setBackground(new Color(255, 241, 137));
        setLayout(null); 
        setSize(600, 800);

        // RoundedPanel 생성
        RoundedPanel panel = new RoundedPanel(new Color(255, 255, 255), b.getQuestion3(), 18);
        panel.setSize(400, 100); 
        panel.setLocation(100, 150); 
        System.out.println(b.getQuestion3());
        add(panel);
        
        RoundedLabel title = new RoundedLabel("퀴즈 3");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(font2);
		title.setBounds(200, 30, 200, 70);
		title.setBackground(btc);
		add(title);
        
     // X, O 버튼
        ImageIcon wrong = new ImageIcon("./src/X.png");
        Image wrongImg = wrong.getImage();
        Image updatewrongImg = wrongImg.getScaledInstance(100,  113, Image.SCALE_SMOOTH);
        ImageIcon updateWrong = new ImageIcon(updatewrongImg);
        JButton btnWrong = new JButton(wrong);
        btnWrong.setIcon(updateWrong);
        btnWrong.setBorderPainted(false);
        btnWrong.setBackground(new Color(255, 241, 137));
        btnWrong.setBounds(330, 300, 100, 113);
        add(btnWrong);
        
		ImageIcon right = new ImageIcon("./src/O.png");
		Image rightImg = right.getImage();
		Image updaterightImg = rightImg.getScaledInstance(100,  113, Image.SCALE_SMOOTH);
		ImageIcon updateRight = new ImageIcon(updaterightImg);
        JButton btnRight = new JButton(right);
        btnRight.setIcon(updateRight);
        btnRight.setBorderPainted(false);
        btnRight.setBackground(new Color(255, 241, 137));
        btnRight.setBounds(150, 300, 100, 113);
        add(btnRight);
        
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
				FrameBase.getInstance(new FrameBookInformation(b));
				
			}
		});

        //정답
        JLabel answer = new JLabel("정답:  " + b.getAnswer3());
        answer.setSize(100, 50);
        answer.setLocation(250, 500);
		answer.setFont(new Font("맑은고딕", Font.BOLD, 20));
		add(answer);
		answer.setVisible(false);
		
		RoundedButton quizEnd = new RoundedButton("퀴즈 끝내기");
		quizEnd.setSize(300, 50);
		quizEnd.setLocation((int)getSize().getWidth()/2 - 160, 600);
		quizEnd.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 22));
		add(quizEnd);
		
		rightNum3 = rightNum2;
		btnWrong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//answer.setVisible(true);
				
				int Quiz = 3; //문제 개수
				//int rightNum = 0; //정답 개수 체크 
				String userAnswer = "X";
				if(userAnswer.equals(b.getAnswer3())) {
					rightNum3++;
				}
				System.out.println(rightNum3);
				
			}
		});
		
		btnRight.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//answer.setVisible(true);
				
				int Quiz = 3; //문제 개수
				//int rightNum = 0; //정답 개수 체크 
				String userAnswer = "O";
				if(userAnswer.equals(b.getAnswer3())) {
					rightNum3++;
				}
				System.out.println(rightNum3);
			}
		});
		
		quizEnd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getInstance(new FrameStamp(b, rightNum3));
				
			}
		});
		
		ActionListener commonActionListener = null;
	      
	      commonActionListener = new ActionListener() {
	         
	         @Override
	         public void actionPerformed(ActionEvent e) {
	            btnWrong.setEnabled(false);
	            btnRight.setEnabled(false);
	            
	         }
	      };
	      
	      btnWrong.addActionListener(commonActionListener);
	      btnRight.addActionListener(commonActionListener);

        
    }
}