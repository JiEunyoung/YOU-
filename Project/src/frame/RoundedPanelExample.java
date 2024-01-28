package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.security.PublicKey;

class RoundedPanel extends JPanel {
    private Color bgColor;
    private String labelText;
    private int fontSize;
    private JLabel label; // JLabel 멤버 변수 추가

    public RoundedPanel(Color bgColor, String labelText, int fontSize) {
        this.bgColor = bgColor;
        this.labelText = labelText;
        this.fontSize = fontSize;
        setOpaque(false);

        // FlowLayout 설정은 필요 없습니다.

        // JLabel 초기화 및 설정
        label = new JLabel(labelText);
        label.setForeground(Color.black);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(new Font(label.getFont().getName(), label.getFont().getStyle(), fontSize));
        add(label); // 한 번만 추가
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int arcWidth = 40; // 가로 방향의 둥근 정도
        int arcHeight = 40; // 세로 방향의 둥근 정도
        int width = getWidth();
        int height = getHeight();

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(bgColor);
        g2d.fill(new RoundRectangle2D.Double(0, 0, width - 1, height - 1, arcWidth, arcHeight));
    }
}

//public class RoundedPanelExample {
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            JFrame frame = new JFrame("둥근 사각형 JPanel 예제");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.setSize(600, 800);
//            frame.setLayout(null);
//
//            RoundedPanel panel = new RoundedPanel(new Color(255, 255, 255), "<html><br>앨리스가 이상한 나라에서 크기를 <br>조절할 수 있는 물건은 초콜릿입니다.</html>", 18);
//            panel.setSize(new Dimension(400, 100)); // 패널 크기를 설정
//            panel.setLocation(100, 0);
//
//            frame.add(panel);
//            frame.setVisible(true);
//        });
//    }
//}