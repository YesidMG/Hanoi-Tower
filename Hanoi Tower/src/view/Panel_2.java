package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Panel_2 extends JPanel {

	private Panel_3 panel;
	private JLabel labelA;
	private JLabel labelB;
	private JLabel labelC;
	private Stack<JButton> tower1 ;
	private Stack<JButton> tower2 ;
	private Stack<JButton> tower3 ;
	private Hashtable <String,Stack<JButton>>  coleccion;

	public Panel_2( int x,int y,int width,int heigth, ActionListener listener) {
		coleccion = new Hashtable<>();
		coleccion.put("tower1", tower1 = new Stack<>());
		coleccion.put("tower2", tower2 = new Stack<>());
		coleccion.put("tower3", tower3 = new Stack<>());
		this.setLayout(null);
		this.setBounds(x,y, width, heigth);
		this.initComponents(listener);
	}

	public void initComponents(ActionListener listener) {
		panel = new Panel_3((int)(this.getWidth()*0.1), (int)(this.getHeight()*0.1), (int)(this.getWidth()*0.8), (int)(this.getHeight()*0.8), listener);
		this.add(panel);

		labelA = new JLabel("A"); 
		labelA.setHorizontalAlignment(SwingConstants.CENTER);
		labelA.setOpaque(true);
		labelA.setFont(new Font("Arial", Font.BOLD, 14));
		labelA.setBounds((int) (panel.getWidth() * 0.235) , (int) (this.getHeight() * 0.95),(int) (panel.getWidth() * 0.1), (int) (this.getHeight() * 0.03));
		this.add(labelA);

		labelB = new JLabel("B");
		labelB.setHorizontalAlignment(SwingConstants.CENTER);
		labelB.setOpaque(true);
		labelB.setFont(new Font("Arial", Font.BOLD, 14));
		labelB.setBounds((int) (panel.getWidth() * 0.57) , (int) (this.getHeight() * 0.95),(int) (panel.getWidth() * 0.1), (int) (this.getHeight() * 0.03));
		this.add(labelB);

		labelC = new JLabel("C");
		labelC.setHorizontalAlignment(SwingConstants.CENTER);
		labelC.setOpaque(true);
		labelC.setFont(new Font("Arial", Font.BOLD, 14));
		labelC.setBounds((int) (panel.getWidth() * 0.9) , (int) (this.getHeight() * 0.95),(int) (panel.getWidth() * 0.1), (int) (this.getHeight() * 0.03));
		this.add(labelC);
	}

	public void putPanel(int num,ActionListener listener) {
		panel.removeAll();

		tower1.clear();
		tower2.clear();
		tower3.clear();

		TowerButton b1= new TowerButton((int)((panel.getWidth()/12)-(panel.getWidth()*0.07)),0, (int)((panel.getWidth()/6)+(panel.getWidth()*0.14)), (int)(panel.getHeight()),"t1",listener);
		TowerButton b3= new TowerButton((int)(((panel.getWidth()/12)*9)-(panel.getWidth()*0.07)),0, (int)((panel.getWidth()/6)+(panel.getWidth()*0.14)), (int)(panel.getHeight()),"t3",listener);
		TowerButton b2= new TowerButton((int)(((panel.getWidth()/12)*5)-(panel.getWidth()*0.07)),0, (int)((panel.getWidth()/6)+(panel.getWidth()*0.14)), (int)(panel.getHeight()),"t2",listener);
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);

		for (int i = 0 ,  j=num-1; i < num ; i++ , j--) {
			CustomButton b= new CustomButton((int)((panel.getWidth()/12)-(panel.getWidth()*0.07)+(((((panel.getWidth()/6)+(panel.getWidth()*0.14))/num)*(i+1/2))/2)),(int)((panel.getHeight()/num)*j),(int) (((panel.getWidth()/6)+(panel.getWidth()*0.14))-(((((panel.getWidth()/6)+(panel.getWidth()*0.14))/num)*(i)))), (int)(panel.getHeight()/num));
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
		if (data==null) {}
		else {
			panel.remove(coleccion.get("tower"+data[2]).peek());
			JButton button= coleccion.get("tower"+data[2]).peek();
			if(data[3]==1) {
				coleccion.get("tower"+data[2]).peek().setBounds((int)(((((panel.getWidth()/12)))-(panel.getWidth()*0.07))+(((((panel.getWidth()/6)+(panel.getWidth()*0.14))/data[1])*(data[0]+1/2))/2)), (int)((panel.getHeight()/data[1])*(data[1]-(coleccion.get("tower"+data[3]).size()+1))), (int) button.getBounds().getWidth(), (int) button.getBounds().getHeight());
			}else if(data[3]==2) {
				coleccion.get("tower"+data[2]).peek().setBounds((int)(((((panel.getWidth()/12)*5))-(panel.getWidth()*0.07))+(((((panel.getWidth()/6)+(panel.getWidth()*0.14))/data[1])*(data[0]+1/2))/2)), (int)((panel.getHeight()/data[1])*(data[1]-(coleccion.get("tower"+data[3]).size()+1))), (int) button.getBounds().getWidth(), (int) button.getBounds().getHeight());
			}else if(data[3]==3) {
				coleccion.get("tower"+data[2]).peek().setBounds((int)(((((panel.getWidth()/12)*9))-(panel.getWidth()*0.07))+(((((panel.getWidth()/6)+(panel.getWidth()*0.14))/data[1])*(data[0]+1/2))/2)), (int)((panel.getHeight()/data[1])*(data[1]-(coleccion.get("tower"+data[3]).size()+1))), (int) button.getBounds().getWidth(), (int) button.getBounds().getHeight());
			}
			panel.add(coleccion.get("tower"+data[3]).push(coleccion.get("tower"+data[2]).pop()));
			hacer.doClick();
			panel.revalidate();
			panel.repaint();
		}
	}
	public void win () {
		panel.removeAll();
		JTextField winner = new JTextField("You Win");
		winner.setEditable(false);
		winner.setBackground(Color.green);
		winner.setFont(new Font("Arial", Font.BOLD, 30));
		winner.setHorizontalAlignment(SwingConstants.CENTER);
		winner.setBounds((int)(this.getWidth()*0.05), (int)(this.getHeight()*0.35), (int)(this.getWidth()*0.6),(int)(this.getHeight()*0.3));
		panel.add(winner);
		panel.revalidate();
		panel.repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2= (Graphics2D)g;
		g2.setStroke(new BasicStroke(6));
		g2.drawLine(panel.getX(), (int)(this.getHeight()*0.9)+3, (int)(this.getWidth()*0.9), (int)(this.getHeight()*0.9)+3);
	}

	public JLabel getLabelA() {
		return labelA;
	}

	public void setLabelA(JLabel labelA) {
		this.labelA = labelA;
	}

	public JLabel getLabelB() {
		return labelB;
	}

	public void setLabelB(JLabel labelB) {
		this.labelB = labelB;
	}

	public JLabel getLabelC() {
		return labelC;
	}

	public void setLabelC(JLabel labelC) {
		this.labelC = labelC;
	}


}