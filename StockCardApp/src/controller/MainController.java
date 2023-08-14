package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.KdvTypeModel;
import model.StockModel;
import view.KdvTypeCardFrame;
import view.MainFrame;
import view.StockCardFrame;
import view.StockListFrame;
import view.StockTypeCardFrame;


public class MainController {

	public MainFrame mainframe;
	public StockCardFrame stockcardframe;
	public StockCardFrameController stockcardframecontroller;
	public StockListFrame stocklistframe;
	public StockListFrameController stocklistframecontroller;
	public StockTypeCardFrame stocktypeframe;
	public KdvTypeCardFrame kdvtypeframe;
	public StockTypeFrameController stocktypeframecontroller;
	public KdvTypeFrameController kdvtypeframecontroller;
	public KdvTypeModel kdvtypemodel;
	public StockModel stockmodel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//System.setProperty( "apple.laf.useScreenMenuBar", "true" );	
		//System.setProperty( "apple.awt.application.appearance", "system" );
		System.setProperty( "apple.awt.application.name", "Case Study 2" );
		new MainController();

 	}

	public MainController() {
	 mainframe = new MainFrame();
	 
	 mainframe.m1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StockCardFrameController stockcardframecontroller = new StockCardFrameController(mainframe);
				stockcardframecontroller.execute();
			}
		});
	 
	 mainframe.m2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StockListFrameController stocklistframecontroller = new StockListFrameController(mainframe);
				stocklistframecontroller.execute();
			}
		});
	 
	 
	 mainframe.m3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StockTypeFrameController stocktypeframecontroller = new StockTypeFrameController(mainframe);
				stocktypeframecontroller.execute();
			}
		});
			
	 mainframe.m4.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					KdvTypeFrameController kdvtypeframecontroller = new KdvTypeFrameController(mainframe);
					kdvtypeframecontroller.execute();
				}
	 	});
	 
	 mainframe.setVisible(true);
		 
	}
}