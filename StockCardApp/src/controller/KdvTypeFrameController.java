package controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import controllerButton.GeneralAction;
import controllerButton.KdvTypeCardDeleteCommand;
import controllerButton.KdvTypeCardFirstCommand;
import controllerButton.KdvTypeCardLastCommand;
import controllerButton.KdvTypeCardNextCommand;
import controllerButton.KdvTypeCardPreviousCommand;
import controllerButton.KdvTypeCardSaveCommand;
import controllerButton.KdvTypeCardUpdateCommand;
import model.KdvTypeModel;
import view.KdvTypeCardFrame;
import view.MainFrame;

public class KdvTypeFrameController {
	

	private KdvTypeCardFrame kdvtypeframe;
	private MainFrame mainframe;


	
	public KdvTypeFrameController(MainFrame mainFrame) {
		super();
		this.mainframe = mainFrame;
	}

	public void execute() {
		
		kdvtypeframe = new KdvTypeCardFrame();
		setListeners();
		//desktop.add(kdvTipKart);
		kdvtypeframe.setVisible(true);
		mainframe.add(kdvtypeframe);
		
		
	}
	
	public void setListeners() {
		
		kdvtypeframe.getBtn_kdv_save().addActionListener(new GeneralAction(new KdvTypeCardSaveCommand(kdvtypeframe)));
		kdvtypeframe.getBtn_kdv_delete().addActionListener(new GeneralAction(new KdvTypeCardDeleteCommand(kdvtypeframe)));		
		kdvtypeframe.getBtn_kdv_update().addActionListener(new GeneralAction(new KdvTypeCardUpdateCommand(kdvtypeframe)));
		kdvtypeframe.btn_First.addActionListener(new GeneralAction(new KdvTypeCardFirstCommand(kdvtypeframe)));
		kdvtypeframe.btn_Last.addActionListener(new GeneralAction(new KdvTypeCardLastCommand(kdvtypeframe)));
		kdvtypeframe.btn_Next.addActionListener(new GeneralAction(new KdvTypeCardNextCommand(kdvtypeframe)));
		kdvtypeframe.btn_Previous.addActionListener(new GeneralAction(new KdvTypeCardPreviousCommand(kdvtypeframe)));

	}
	

}
