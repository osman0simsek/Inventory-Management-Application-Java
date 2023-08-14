package controllerButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneralAction implements ActionListener {
	ICommand command;
	
	public GeneralAction (ICommand command) {
		this.command = command;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		command.execute();
	}
	
	
}
