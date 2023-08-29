package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;


public class MyFrame extends JFrame {
	public Panel_1 panel1;
	public Panel_2 panel2;
	
	
	public MyFrame(ActionListener listener) {
		super("Matriz");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700, 600);
		this.setVisible(true);
		this.setLayout(null);
		this.initComponets(listener);
		this.revalidate();
		
		this.repaint();
	}
	
	public void initComponets (ActionListener listener) {
		panel1 = new Panel_1(0, 0, (int) (this.getWidth()), (int)(this.getHeight()*0.3), listener);
		panel2 = new Panel_2(0, (int)(this.getHeight()*0.3), (int) (this.getWidth()), (int)(this.getHeight()*0.635), listener);
		this.add(panel1);
		this.add(panel2);
	}
	
	
	
	public int levelSelector(ActionListener listener) {
		panel2.putPanel(Integer.parseInt(panel1.getDifficulty().getText()),listener);
		panel2.revalidate();
		panel2.repaint();
		return Integer.parseInt(panel1.getDifficulty().getText());
	}
	
	public void moveitems(int [] data, ActionListener listener) {
		panel2.moveItem(data, listener);
	}
	
	
}
