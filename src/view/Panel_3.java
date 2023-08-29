package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Panel_3 extends JPanel {

	

	public Panel_3( int x,int y,int width,int heigth, ActionListener listener) {
		
		this.setBackground(null);
		this.setLayout(null);
		this.setBounds(x,y, width, heigth);
		this.initComponents(listener);

	}

	public void initComponents(ActionListener listener) {

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2= (Graphics2D)g;
		g2.setStroke(new BasicStroke(6));
		
		g2.drawLine((int)(this.getWidth()/6)-3, 0, (int)((this.getWidth()/6))-3, (int)(this.getHeight()));
		
		g2.drawLine((int)((this.getWidth()*0.5)-3), 0, (int)((this.getWidth()*0.5)-3), (int)(this.getHeight()));
		
		g2.drawLine((int)((this.getWidth()/6)*5)-3, 0, (int)((this.getWidth()/6)*5)-3, (int)(this.getHeight()));
		
		//g2.fillRect((int)((this.getWidth()/12)-(this.getWidth()*0.07)), (int)(this.getHeight()*0.6), (int) (((this.getWidth()/6))+(this.getWidth()*0.14)), (int)(this.getHeight()*0.11));
	}

	
	
	


}
