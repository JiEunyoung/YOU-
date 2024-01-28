package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameStamp extends JPanel{
	public int totalNum;
	public FrameStamp(Book b, int rightNum3) {
		
		setBackground(new Color(255, 241, 137));
        setLayout(null); 
        setSize(600, 800); 
        
        JLabel labelName = new JLabel(b.getBookName());
        if(b.getBookName().equals("누가 내 머리에 똥 쌌어?")) {
        	labelName.setSize(300, 50);
        	labelName.setLocation(180, 80);
        }else if(b.getBookName().equals("아기돼지 삼형제")) {
        	labelName.setSize(200, 50);
        	labelName.setLocation(210, 80);
        }else if(b.getBookName().equals("어린왕자")) {
        	labelName.setSize(200, 50);
        	labelName.setLocation(240, 80);
        }else if(b.getBookName().equals("이상한 나라의 앨리스")) {
        	labelName.setSize(300, 50);
        	labelName.setLocation(180, 80);
        }else if(b.getBookName().equals("아낌없이 주는 나무")) {
        	labelName.setSize(360, 50);
        	labelName.setLocation(200, 80);
        }else if(b.getBookName().equals("책 먹는 여우")) {
        	labelName.setSize(200, 50);
        	labelName.setLocation(230, 80);
        }else if(b.getBookName().equals("흥부와 놀부")) {
        	labelName.setSize(200, 50);
        	labelName.setLocation(230, 80);
        }
        else {
        	labelName.setSize(200, 50);
        	labelName.setLocation(200, 80);
        }
        labelName.setFont(new Font("맑은고딕", Font.BOLD, 20));
		add(labelName);
		
		totalNum = rightNum3;
		JLabel result = new JLabel("맞은 개수:  " + totalNum + "/" + "3");
		result.setSize(200, 50);
		result.setLocation(220, 130);
		result.setFont(new Font("맑은고딕", Font.BOLD, 20));
		add(result);
		
		if(totalNum >= 2) {
			ImageIcon imggood = new ImageIcon("./src/good.png");
			JLabel jlablegood = new JLabel(imggood);
			jlablegood.setSize(250, 250);
			jlablegood.setLocation(170, 170);
			add(jlablegood);
		}else {
			ImageIcon imgretry = new ImageIcon("./src/retry.png");
			JLabel jlableretry = new JLabel(imgretry);
			jlableretry.setSize(250, 250);
			jlableretry.setLocation(170, 190);
			add(jlableretry);
		}
		
		RoundedButton btnre = new RoundedButton("다시 풀어보기");
		RoundedButton btnanswer = new RoundedButton("답 보러가기");
		
		btnre.setSize(300, 40);
		btnre.setLocation(getWidth() / 4 - 5, 470);
		btnre.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 22));

		btnanswer.setSize(300, 40);
		btnanswer.setLocation((int) btnre.getLocation().getX(), (int) btnre.getLocation().getY() + 70);

		btnanswer.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 22));

	     add(btnre);
	     add(btnanswer);
	     
	     btnre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FrameBase.getInstance(new FrameQuiz1(b));
			}
		});
	     
	     btnanswer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getInstance(new FrameQuizResult(b, rightNum3));
				
			}
		});
	}
}
