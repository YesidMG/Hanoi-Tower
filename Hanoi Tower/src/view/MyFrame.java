package view;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
	public Panel_1 panel1;
	public Panel_2 panel2;

	public MyFrame(Vector<String >levels,ActionListener listener) {
		super("Matriz");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700, 700);
		this.setVisible(true);
		this.setLayout(null);
		this.setResizable(false);
		this.initComponets(levels,listener);
		this.revalidate();
		this.repaint();
	}

	public void initComponets (Vector<String >levels, ActionListener listener) {
		panel1 = new Panel_1(0, 0, (int) (this.getWidth()), (int)(this.getHeight()*0.35), levels,listener);
		panel2 = new Panel_2(0, (int)(this.getHeight()*0.35), (int) (this.getWidth()), (int)(this.getHeight()*0.530), listener);
		this.add(panel1);
		this.add(panel2);
	}

	public void indicator(String tower, boolean operator) {
		if (operator) {
			if(tower.equals("t1")) {
				panel2.getLabelA().setBackground(Color.green);
			}else if(tower.equals("t2")) {
				panel2.getLabelB().setBackground(Color.green);
			}else {
				panel2.getLabelC().setBackground(Color.green);
			}
		}else {
			panel2.getLabelA().setBackground(null);
			panel2.getLabelB().setBackground(null);
			panel2.getLabelC().setBackground(null);
		}
	}

	public int levelSelector( int level,ActionListener listener) {
		panel2.putPanel(level,listener);
		panel2.revalidate();
		panel2.repaint();
		return level;
	}

	public void moveitems(int [] data, ActionListener listener) {
		panel2.moveItem(data, listener);
	}

	public void winner(boolean win) {
		if (win) {
			panel2.win();}
	}
	public String dificulty() {
		return panel1.getDifficultySelector().getSelectedItem().toString();
	}


}
