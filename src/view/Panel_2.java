package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Panel_2 extends JPanel {

	private Panel_3 panel;
	private Stack<JButton> tower1 ;
	private Stack<JButton> tower2 ;
	private Stack<JButton> tower3 ;

	public Panel_2( int x,int y,int width,int heigth, ActionListener listener) {
		tower1 = new Stack<>();
		tower2 = new Stack<>();
		tower3 = new Stack<>();
		this.setBackground(Color.LIGHT_GRAY);
		this.setLayout(null);
		this.setBounds(x,y, width, heigth);
		this.initComponents(listener);

	}

	public void initComponents(ActionListener listener) {
		panel = new Panel_3((int)(this.getWidth()*0.1), (int)(this.getHeight()*0.1), (int)(this.getWidth()*0.8), (int)(this.getHeight()*0.8), listener);
		this.add(panel);
	} 









	public void putPanel(int num,ActionListener listener) {
		panel.removeAll();

		JButton b1= new JButton();
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		b1.setBounds((int)((panel.getWidth()/12)-(panel.getWidth()*0.07)),0, (int)((panel.getWidth()/6)+(panel.getWidth()*0.14)), (int)(panel.getHeight()));
		b1.setActionCommand("t1");
		b1.addActionListener(listener);
		panel.add(b1);

		JButton b2= new JButton();
		b2.setOpaque(false);
		b2.setContentAreaFilled(false);
		b2.setBounds((int)(((panel.getWidth()/12)*5)-(panel.getWidth()*0.07)),0, (int)((panel.getWidth()/6)+(panel.getWidth()*0.14)), (int)(panel.getHeight()));
		b2.setActionCommand("t2");
		b2.addActionListener(listener);
		panel.add(b2);

		JButton b3= new JButton();
		b3.setOpaque(false);
		b3.setContentAreaFilled(false);
		b3.setBounds((int)(((panel.getWidth()/12)*9)-(panel.getWidth()*0.07)),0, (int)((panel.getWidth()/6)+(panel.getWidth()*0.14)), (int)(panel.getHeight()));
		b3.setActionCommand("t3");
		b3.addActionListener(listener);
		panel.add(b3);

		for (int i = 0 ,  j=num-1; i < num ; i++ , j--) {
			JButton b= new JButton(""+(num-i));
			b.setFont(new Font(b.getFont().getName(), Font.PLAIN, 6));
			b.setBounds((int)((panel.getWidth()/12)-(panel.getWidth()*0.07)+(((((panel.getWidth()/6)+(panel.getWidth()*0.14))/num)*(i+1/2))/2)),(int)((panel.getHeight()/num)*j),(int) (((panel.getWidth()/6)+(panel.getWidth()*0.14))-(((((panel.getWidth()/6)+(panel.getWidth()*0.14))/num)*(i)))), (int)(panel.getHeight()/num));
			tower1.push(b);
			panel.add(tower1.peek());

		}
		panel.revalidate();
		panel.repaint();

	}

	public void moveItem(int [] data, ActionListener listener) {
		JButton hacer = new JButton();
		hacer.setActionCommand("change");
		hacer.addActionListener(listener);
		if (data==null) {
			
		}
		else {
			if(data[2]==1 && data[3]==2) {

				panel.remove(tower1.peek());

				JButton b= tower1.peek();
				tower1.peek().setBounds((int)(((((panel.getWidth()/12)*5))-(panel.getWidth()*0.07))+(((((panel.getWidth()/6)+(panel.getWidth()*0.14))/data[1])*(data[0]+1/2))/2)), (int)((panel.getHeight()/data[1])*(data[1]-(tower2.size()+1))), (int) b.getBounds().getWidth(), (int) b.getBounds().getHeight());
				panel.add(tower2.push(tower1.pop()));


			}else if(data[2]==2 && data[3]==1) {
				panel.remove(tower2.peek());

				JButton b= tower2.peek();
				tower2.peek().setBounds((int)(((((panel.getWidth()/12)))-(panel.getWidth()*0.07))+(((((panel.getWidth()/6)+(panel.getWidth()*0.14))/data[1])*(data[0]+1/2))/2)), (int)((panel.getHeight()/data[1])*(data[1]-(tower1.size()+1))), (int) b.getBounds().getWidth(), (int) b.getBounds().getHeight());
				panel.add(tower1.push(tower2.pop()));

			}else if(data[2]==1 && data[3]==3) {
				panel.remove(tower1.peek());

				JButton b= tower1.peek();
				tower1.peek().setBounds((int)(((((panel.getWidth()/12)*9))-(panel.getWidth()*0.07))+(((((panel.getWidth()/6)+(panel.getWidth()*0.14))/data[1])*(data[0]+1/2))/2)), (int)((panel.getHeight()/data[1])*(data[1]-(tower3.size()+1))), (int) b.getBounds().getWidth(), (int) b.getBounds().getHeight());
				panel.add(tower3.push(tower1.pop()));

			}else if(data[2]==3 && data[3]==1) {
				panel.remove(tower3.peek());

				JButton b= tower3.peek();
				tower3.peek().setBounds((int)(((((panel.getWidth()/12)))-(panel.getWidth()*0.07))+(((((panel.getWidth()/6)+(panel.getWidth()*0.14))/data[1])*(data[0]+1/2))/2)), (int)((panel.getHeight()/data[1])*(data[1]-(tower1.size()+1))), (int) b.getBounds().getWidth(), (int) b.getBounds().getHeight());
				panel.add(tower1.push(tower3.pop()));

			}else if(data[2]==2 && data[3]==3) {
				panel.remove(tower2.peek());

				JButton b= tower2.peek();
				tower2.peek().setBounds((int)(((((panel.getWidth()/12)*9))-(panel.getWidth()*0.07))+(((((panel.getWidth()/6)+(panel.getWidth()*0.14))/data[1])*(data[0]+1/2))/2)), (int)((panel.getHeight()/data[1])*(data[1]-(tower3.size()+1))), (int) b.getBounds().getWidth(), (int) b.getBounds().getHeight());
				panel.add(tower3.push(tower2.pop()));

			}else if(data[2]==3 && data[3]==2){
				panel.remove(tower3.peek());

				JButton b= tower3.peek();
				tower3.peek().setBounds((int)(((((panel.getWidth()/12)*5))-(panel.getWidth()*0.07))+(((((panel.getWidth()/6)+(panel.getWidth()*0.14))/data[1])*(data[0]+1/2))/2)), (int)((panel.getHeight()/data[1])*(data[1]-(tower2.size()+1))), (int) b.getBounds().getWidth(), (int) b.getBounds().getHeight());
				panel.add(tower2.push(tower3.pop()));
			}
			hacer.doClick();
			panel.revalidate();
			panel.repaint();
		}
	}




































	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2= (Graphics2D)g;
		g2.setStroke(new BasicStroke(6));
		g2.drawLine(panel.getX(), (int)(this.getHeight()*0.9)+3, (int)(this.getWidth()*0.9), (int)(this.getHeight()*0.9)+3);
	}


}
