package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.BorderFactory;

public class Panel_1 extends JPanel {

	public JLabel titleLabel;
	public JLabel difficultyLabel;
	public JComboBox<String> difficultySelector;
	public JLabel instructionsLabel;
	public JTextArea instructionsArea;
	public JButton confirmButton;

	public Panel_1(int x, int y, int width, int height, Vector<String >levels,ActionListener listener) {
		this.setBackground(new Color(255, 223, 186)); // Custom pastel color
		this.setLayout(null);
		this.setBounds(x, y, width, height);
		this.initComponents(levels,listener);
	}

	public void initComponents(Vector<String >levels,ActionListener listener) {

		titleLabel = new JLabel("HANOI TOWER");
		titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
		titleLabel.setBounds((int)(this.getWidth()*0.07), (int)(this.getHeight()*0.08), (int)(this.getWidth()*0.25), (int)(this.getHeight()*0.08));
		this.add(titleLabel);

		instructionsLabel = new JLabel("Instructions:");
		instructionsLabel.setFont(new Font("Arial", Font.BOLD, 16));
		instructionsLabel.setBounds((int)(this.getWidth()*0.07), (int)(this.getHeight()*0.23), (int)(this.getWidth()*0.14), (int)(this.getHeight()*0.05));
		this.add(instructionsLabel);

		instructionsArea = new JTextArea(
				"1) Choose a difficulty level.\n" +
						"2) The objective is to move blocks from tower A to tower C.\n" +
				"3) You cannot place a larger block on top of a smaller one.");
		instructionsArea.setFont(new Font("Arial", Font.PLAIN, 14));
		instructionsArea.setBackground(null);
		instructionsArea.setEditable(false);
		instructionsArea.setBounds((int)(this.getWidth()*0.07), (int)(this.getHeight()*0.33), (int)(this.getWidth()*0.85), (int)(this.getHeight()*0.32));
		instructionsArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		this.add(instructionsArea);

		difficultyLabel = new JLabel("Difficulty:");
		difficultyLabel.setFont(new Font("Arial", Font.BOLD, 16));
		difficultyLabel.setBounds((int)(this.getWidth()*0.07), (int)(this.getHeight()*0.69), (int)(this.getWidth()*0.12), (int)(this.getHeight()*0.07));
		this.add(difficultyLabel);

		difficultySelector = new JComboBox<String>();
		difficultySelector.setBounds((int)(this.getWidth()*0.21), (int)(this.getHeight()*0.68), (int)(this.getWidth()*0.25),(int)(this.getHeight()*0.11));		
		for(String namelevel: levels) {
			difficultySelector.addItem(namelevel);	
		} 
		this.add(difficultySelector);

		confirmButton = new JButton("Confirm");
		confirmButton.setBounds((int)(this.getWidth()*0.21), (int)(this.getHeight()*0.8), (int)(this.getWidth()*0.15),(int)(this.getHeight()*0.12));
		confirmButton.setActionCommand("confirm");
		confirmButton.addActionListener(listener);
		this.add(confirmButton);

	}

	public JComboBox<String> getDifficultySelector() {
		return difficultySelector;
	}

	public void setDifficultySelector(JComboBox<String> difficultySelector) {
		this.difficultySelector = difficultySelector;
	}



}
