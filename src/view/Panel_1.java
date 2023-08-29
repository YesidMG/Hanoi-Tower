package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Panel_1 extends JPanel {

	public JLabel tittleGame;
	public JLabel difficultyText;
	public JTextField difficulty;
	public JLabel instructionsTittle;
	public JTextArea instructions;
	public JButton confirm;


	public Panel_1( int x,int y,int width,int heigth, ActionListener listener) {
		this.setBackground(Color.pink);
		this.setLayout(null);
		this.setBounds(x,y, width, heigth);
		this.initComponents(listener);

	}

	public void initComponents(ActionListener listener) {
		
		tittleGame= new JLabel("******HANOI TOWER*****");
		tittleGame.setFont(new Font(tittleGame.getFont().getName(), Font.BOLD, 20));
		tittleGame.setBounds((int)(this.getWidth()*0.3), (int)(this.getHeight()*0.1), (int)(this.getWidth()*0.8), (int)(this.getHeight()*0.1));
		this.add(tittleGame);
		
		instructionsTittle= new JLabel("Instructions:");
		instructionsTittle.setFont(new Font(instructionsTittle.getFont().getName(), Font.BOLD, 14));
		instructionsTittle.setBounds((int)(this.getWidth()*0.05), (int)(this.getHeight()*0.24), (int)(this.getWidth()*0.9), (int)(this.getHeight()*0.1));
		this.add(instructionsTittle);

		instructions= new JTextArea();
		instructions.setText("1)You can choose a difficulty from 1 -10, the difficulty varies the number of blocks"
				+ "\n2)The objective is to take the blocks from tower 1 to tower 3 in the order they initially appear"
				+ "\n3)You can't put a bigger block on top of another");
		instructions.setFont(new Font(instructions.getFont().getName(), Font.PLAIN, 13));
		instructions.setBackground(null);
		instructions.setEditable(false);
		instructions.setBounds((int)(this.getWidth()*0.05), (int)(this.getHeight()*0.36), (int)(this.getWidth()*0.9), (int)(this.getHeight()*0.3));
		this.add(instructions);

		difficultyText= new JLabel("Difficulty:");
		difficultyText.setFont(new Font(difficultyText.getFont().getName(), Font.BOLD, 14));
		difficultyText.setBounds((int)(this.getWidth()*0.05), (int)(this.getHeight()*0.75), (int)(this.getWidth()*0.15), (int)(this.getHeight()*0.1));
		this.add(difficultyText);

		difficulty= new JTextField();
		difficulty.setBounds((int)(this.getWidth()*0.15), (int)(this.getHeight()*0.73), (int)(this.getWidth()*0.05), (int)(this.getHeight()*0.15));
		this.add(difficulty);

		confirm= new JButton("Confirmar");
		confirm.setBounds((int)(this.getWidth()*0.3), (int)(this.getHeight()*0.74), (int)(this.getWidth()*0.2), (int)(this.getHeight()*0.12));
		confirm.setActionCommand("confirm");
		confirm.addActionListener(listener);
		this.add(confirm);

	}

	public JTextField getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(JTextField difficulty) {
		this.difficulty = difficulty;
	}
	


}
