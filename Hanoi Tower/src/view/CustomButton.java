package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomButton extends JButton {

	private Color normalColor = new Color(115, 125, 230); 
	private Color borderColor = Color.BLUE; 

	public CustomButton(int x, int y, int w, int h) {
		this.setBounds(x, y, w, h);
		setBorderPainted(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
		setForeground(Color.BLACK);
		addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent e) {
				setBackground(normalColor);
			}

			public void mouseExited(MouseEvent e) {
				setBackground(null);
			}

			public void mousePressed(MouseEvent e) {
				setBackground(normalColor);
			}

			public void mouseReleased(MouseEvent e) {
				setBackground(null);
			}
		});
	}

	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(normalColor);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);

		g2.setColor(borderColor); 
		g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);

		g2.setColor(getForeground());
		FontMetrics fm = g2.getFontMetrics();
		int x = (getWidth() - fm.stringWidth(getText())) / 2;
		int y = (getHeight() + fm.getAscent() - fm.getDescent()) / 2;
		g2.drawString(getText(), x, y);

		g2.dispose();
	}
}