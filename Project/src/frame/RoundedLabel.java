package frame;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class RoundedLabel extends JLabel {
	public RoundedLabel() {
		super();
		decorate();
	}

	public RoundedLabel(String text) {
		super(text);
		decorate();
	}

	public RoundedLabel(Action action) {
		decorate();
	}

	public RoundedLabel(Icon icon) {
		super(icon);
		decorate();
	}

	public RoundedLabel(String text, Icon icon) {
		decorate();
	}

	protected void decorate() {;
		setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Color c = new Color(184, 119, 249); // 배경색 결정
		Color o = new Color(255, 255, 255); // 글자색 결정
		int width = getWidth();
		int height = getHeight();
		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphics.setColor(c);
		graphics.fillRoundRect(0, 0, width, height, 30, 30);
		FontMetrics fontMetrics = graphics.getFontMetrics();
		Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();
		int textX = (width - stringBounds.width) / 2;
		int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();
		graphics.setColor(o);
		graphics.setFont(getFont());
		graphics.drawString(getText(), textX, textY);
		graphics.dispose();
		super.paintComponent(g);
	}
}