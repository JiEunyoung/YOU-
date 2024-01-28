package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameSelectAge extends JPanel{
	public FrameSelectAge() {
		
		setBackground(new Color(255, 241, 137));
		setLayout(null);
		setSize(800, 1000);
		
		ImageIcon chLower = new ImageIcon("./src/lower1.png");
		ImageIcon chHigher = new ImageIcon("./src/higher1.png");
		JLabel jlableCh1 = new JLabel(chLower);
		JLabel jlableCh2 = new JLabel(chHigher);
		jlableCh1.setSize(200, 220);
		jlableCh2.setSize(200, 220);
		jlableCh1.setLocation(75, 270);
		jlableCh2.setLocation(310, 240);
		add(jlableCh1);
		add(jlableCh2);
		
		RoundedButton btnLower = new RoundedButton("8~10세");
		RoundedButton btnHigher = new RoundedButton("11~13세");
		
		btnLower.setBackground(new Color(184, 119, 249));
		btnHigher.setBackground(new Color(184, 119, 249));
		
		btnLower.setSize(150, 75);
		btnLower.setLocation(
				100, 
				(int) getLocation().getY() / 2 + 450);
		btnLower.setFont(new Font("굴림", Font.BOLD, 20));
		add(btnLower);
		
		btnHigher.setSize(150, 75);
		btnHigher.setLocation(
				330, 
				(int) getLocation().getY() / 2 + 450);
		btnHigher.setFont(new Font("굴림", Font.BOLD, 20));
		add(btnHigher);
		
		
		btnLower.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Member m1 = new Member();
				m1.setAge(1);
				FrameBase.getInstance(new FrameBookSelect1());
				
			}
		});
		
		btnHigher.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Member m2 = new Member();
				m2.setAge(2);
				FrameBase.getInstance(new FrameBookSelect2());
				
			}
		});
		
	}
}
