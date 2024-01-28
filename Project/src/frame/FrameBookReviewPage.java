package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class FrameBookReviewPage extends JPanel {
	JLabel centertitle, titleLabel, authorLabel;
	JTextArea reviewArea;
	ImageIcon arrowIcon;

	public FrameBookReviewPage(Book b) {
		Color bgc = new Color(255, 241, 137);
		Color btc = new Color(184, 119, 249);
		
		setBackground(new Color(255, 241, 137));
		setLayout(null);
		setSize(600, 800);

		int width = 600; // initial panel width
		int height = 800; // initial panel height

		// Center Title Label
		RoundedLabel centertitle = new RoundedLabel("독후감");
		centertitle.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		centertitle.setOpaque(true);
		centertitle.setBackground(new Color(184, 119, 249));
		centertitle.setBounds(width / 5, 20, width * 3 / 5, 60);
		add(centertitle);

		//뒤로가기
		ImageIcon image2 = new ImageIcon("./src/back.png");
		Image img12 = image2.getImage();
		Image updateImg12 = img12.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon updateIcon12 = new ImageIcon(updateImg12);
		JButton btnBack = new JButton(image2);
		btnBack.setIcon(updateIcon12);
		btnBack.setBorderPainted(false);
		btnBack.setBackground(bgc);
		//btnBack.setBounds(10, 10, 50, 50);
		add(btnBack);

//		btnBack.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//
//				if (b.getBookName() == "무지개 물고기" || b.getBookName() == "흥부와 놀부" || b.getBookName() == "아기돼지 삼형제"
//						|| b.getBookName() == "누가 내 머리에 똥 쌌어?") {
//
//					FrameBase.getInstance(new FrameBookSelect1());
//				} else {
//					FrameBase.getInstance(new FrameBookSelect2());
//				}
//			}
//		});

		// Title Label
		titleLabel = new JLabel("제목: " + b.getBookName());
		titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		titleLabel.setBounds(60, 100, 300, 50);
		add(titleLabel);

		// Author Label
		authorLabel = new JLabel("저자: " + b.getBookPub());
		authorLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		authorLabel.setBounds(60, 135, 300, 50);
		add(authorLabel);

		// Review Area
		reviewArea = new JTextArea("책을 읽으면서 어떤 장면이 기억에 남는지, \r\n어떤 생각이 들었는지 써볼까요?");
		reviewArea.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		reviewArea.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (reviewArea.getText().equals("책을 읽으면서 어떤 장면이 기억에 남는지, \r\n어떤 생각이 들었는지 써볼까요?")) {
					reviewArea.setText("");
				}
			}
		});
		reviewArea.setBounds(width / 10, height * 3 / 13, width * 8 / 10, height / 2);
		add(reviewArea);

		// Save Button
		RoundedButton saveButton = new RoundedButton("저장");
		saveButton.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		saveButton.setBackground(new Color(184, 119, 249));
		saveButton.setBounds(320, 600, 200, 50);
		add(saveButton);

		// View Button
		RoundedButton viewButton = new RoundedButton("내가 쓴 독후감 보기");
		viewButton.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		viewButton.setBackground(new Color(184, 119, 249));
		viewButton.setBounds(80, 600, 200, 50);
		add(viewButton);

		viewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					FrameBase.getInstance(new FrameMyPage3(b));
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		// 저장 버튼
				saveButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// 현재 최대 인덱스 값을 가져와서 1을 더해 다음 인덱스 계산
						int currentIndex = getCurrentMaxIndex();
						int Index = currentIndex + 1;

						// 나머지 코드는 이전과 동일하게 작성
						String title = b.getBookName();
						String reviewText = reviewArea.getText();
						java.util.Date currentDate = new java.util.Date();
						java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("MM-dd");
						String dateAndTime = dateFormat.format(currentDate);

						try {
							BufferedWriter br = new BufferedWriter(new FileWriter("독후감.txt", true));
							br.write(Index + "/");
							br.write(title + "/");
							br.write(dateAndTime + "/");
							br.write(reviewText + "\n");
							br.close();

							JOptionPane.showMessageDialog(null, "독후감이 저장되었습니다.");
						} catch (IOException ex) {
							JOptionPane.showMessageDialog(null, "독후감을 저장하는 중에 오류가 발생했습니다.");
						}
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
						FrameBase.getInstance(new FrameBookInformation(b));
						
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

			private int getCurrentMaxIndex() {
				int maxIndex = 0;

				try {
					BufferedReader reader = new BufferedReader(new FileReader("독후감.txt"));
					String line;
					while ((line = reader.readLine()) != null) {
						String[] parts = line.split("/");
						if (parts.length >= 1) {
							try {
								int index = Integer.parseInt(parts[0]);
								maxIndex = Math.max(maxIndex, index);
							} catch (NumberFormatException e) {
								// 숫자로 변환할 수 없는 경우 무시
							}
						}
					}
					reader.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}

				return maxIndex;
			}
}
