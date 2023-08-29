package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Logic;
import pesrsistence.MyFile;
import view.MyFrame;

public class Controll implements ActionListener {

	private MyFile file;
	private MyFrame frame;
	private Logic logic;

	public Controll() {
		file = new MyFile();
		frame = new MyFrame(file.obtainLevels(),this);
		logic= new Logic();
	}

	public void actionPerformed(ActionEvent event) {
		String source = event.getActionCommand();
		try {
			switch (source) {
			case "confirm": {	
				logic.levelSelector(frame.levelSelector(file.readLevel(frame.dificulty()),this));
				break;
			}
			case "t1": {	
				frame.moveitems(logic.selector(1), this);
				frame.indicator("t1", logic.indicator());
				frame.winner(logic.winn());
				break;
			}
			case "t2": {	
				frame.moveitems(logic.selector(2), this);
				frame.indicator("t2", logic.indicator());
				frame.winner(logic.winn());
				break;
			}
			case "t3": {	
				frame.moveitems(logic.selector(3), this);
				frame.indicator("t3", logic.indicator());
				frame.winner(logic.winn());
				break;
			}
			}}catch (Exception e) {
			}
	}
	public static void main (String args[]) {
		new Controll();
	}

}
