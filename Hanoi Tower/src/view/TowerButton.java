package view;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class TowerButton extends JButton {

	private static final Color HOVER_BORDER_COLOR = new Color(0, 0, 255, 100); // Azul transparente
	private static final List<TowerButton> activeButtons = new ArrayList<>();

	public TowerButton(int x, int y, int w, int h, String command, ActionListener listener) {
		this.setBounds(x, y, w, h);
		this.setActionCommand(command);
		this.addActionListener(listener);
		this.setOpaque(false);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setBorderPainted(true); // Muestra el borde al estar sobre el botón
				setBorder(new javax.swing.border.LineBorder(HOVER_BORDER_COLOR, 2));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!activeButtons.contains(TowerButton.this)) {
					setBorderPainted(false); // Oculta el borde si no es el botón activo
					setBorder(null);
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				setActive();
			}
		});
	}

	private void setActive() {
		for (TowerButton button : activeButtons) {
			button.setBorderPainted(false); // Oculta el borde en los botones activos previos
			button.setBorder(null);
		}
		activeButtons.clear();
		activeButtons.add(this);
		setBorderPainted(true); // Muestra el borde en el botón activo
		setBorder(new javax.swing.border.LineBorder(HOVER_BORDER_COLOR, 2));
	}
}
