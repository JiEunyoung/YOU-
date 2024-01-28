package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameQuizResult extends JPanel{

	//public static int totalNum = FrameQuiz3.rightNum3;
	public int totalNum;
	public FrameQuizResult(Book b, int rightNum3) {
    	setBackground(new Color(255, 241, 137));
        setLayout(null); 
        setSize(600, 800); 
        
        
        // RoundedPanel 생성
        RoundedPanel panel1 = new RoundedPanel(new Color(255, 255, 255), b.getQuestion1(), 18);
        panel1.setSize(400, 100); 
        panel1.setLocation(100, 90); 

        add(panel1);
        
        JLabel answer1 = new JLabel("정답:  " + b.getAnswer1());
        answer1.setSize(100, 50);
        answer1.setLocation(260, 190);
		answer1.setFont(new Font("맑은고딕", Font.BOLD, 20));
		add(answer1);
		
		
        // RoundedPanel 생성
        RoundedPanel panel2 = new RoundedPanel(new Color(255, 255, 255), b.getQuestion2(), 18);
        panel2.setSize(400, 100); 
        panel2.setLocation(100, 280); 

        add(panel2);
        
        JLabel answer2 = new JLabel("정답:  " + b.getAnswer2());
        answer2.setSize(100, 50);
        answer2.setLocation(260, 380);
		answer2.setFont(new Font("맑은고딕", Font.BOLD, 20));
		add(answer2);
		
		
        // RoundedPanel 생성
        RoundedPanel panel3 = new RoundedPanel(new Color(255, 255, 255), b.getQuestion3(), 18);
        panel3.setSize(400, 100); 
        panel3.setLocation(100, 470); 

        add(panel3);
        
        JLabel answer3 = new JLabel("정답:  " + b.getAnswer3());
        answer3.setSize(100, 50);
        answer3.setLocation(260, 565);
		answer3.setFont(new Font("맑은고딕", Font.BOLD, 20));
		add(answer3);
		
//		totalNum = rightNum3;
//		JLabel result = new JLabel("맞은 개수:  " + totalNum + "/" + "3");
//		result.setSize(200, 50);
//		result.setLocation(400, 605);
//		result.setFont(new Font("맑은고딕", Font.BOLD, 20));
//		add(result);
		
		RoundedButton back = new RoundedButton("책으로 돌아가기");
		back.setSize(300, 50);
		back.setLocation((int)getSize().getWidth()/2 - 160, 675);
		back.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 22));
		add(back);
		
		back.addActionListener(new ActionListener() {
			
		
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getInstance(new FrameBookInformation(b));
				
			}
		});
	}
}
