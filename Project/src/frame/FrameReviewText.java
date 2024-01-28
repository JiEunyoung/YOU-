package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FrameReviewText extends JFrame {
    public FrameReviewText(int index, String title) {
        setTitle("Review for: " + title);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea reviewText = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(reviewText);
        reviewText.setFont(new Font("맑은고딕", Font.BOLD, 20));
        add(scrollPane, BorderLayout.CENTER);

        // Read the review text (content) from the file and set it in the JTextArea
        try {
            BufferedReader reader = new BufferedReader(new FileReader("독후감.txt"));
            String line;
            StringBuilder reviewStringBuilder = new StringBuilder();
            boolean reviewFound = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("/");
                if (parts.length >= 4 && parts[0].equals(Integer.toString(index)) && parts[1].equals(title)) {
                    reviewStringBuilder.append(parts[3]).append("\n");
                    reviewFound = true;
                }
            }
            reader.close();
            
            if (reviewFound) {
                reviewText.setText(reviewStringBuilder.toString());
            } else {
                reviewText.setText("Review not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            reviewText.setText("Error reading review.");
        }

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the review frame
            }
        });

        add(closeButton, BorderLayout.SOUTH);

        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }
}