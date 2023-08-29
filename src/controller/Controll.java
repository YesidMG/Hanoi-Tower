package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Logic;
import view.MyFrame;

public class Controll implements ActionListener {

	private MyFrame frame;
	private Logic logic;


	public Controll() {
		frame = new MyFrame(this);
		logic= new Logic();
	}

	public void actionPerformed(ActionEvent event) {

		String source = event.getActionCommand();

		try {
			switch (source) {
			case "confirm": {	
				logic.levelSelector(frame.levelSelector(this));
				
				break;
			}
			case "t1": {	
				frame.moveitems(logic.selector(1), this);
				break;
			}
			case "t2": {	
				frame.moveitems(logic.selector(2), this);
				break;
			}
			case "t3": {	
				frame.moveitems(logic.selector(3), this);
				break;
			}
			case "change": {	
				
				break;
			}
			}}catch (Exception e) {
			}

	}
	public static void main (String args[]) {
		new Controll();
	}

}
