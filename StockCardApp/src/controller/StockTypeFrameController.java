package controller;

import view.MainFrame;
import view.StockTypeCardFrame;
import controllerButton.GeneralAction;
import controllerButton.StockTypeCardDeleteCommand;
import controllerButton.StockTypeCardFirstCommand;
import controllerButton.StockTypeCardLastCommand;
import controllerButton.StockTypeCardNextCommand;
import controllerButton.StockTypeCardPreviousCommand;
import controllerButton.StockTypeCardSaveCommand;
import controllerButton.StockTypeCardUpdateCommand;

public class StockTypeFrameController {
	MainFrame mainframe;
	StockTypeCardFrame stocktypeframe;
	
	
	
	public StockTypeFrameController(MainFrame mainframe) {
		super();
		this.mainframe = mainframe;
		
		
	}
	
	public void execute() {
		stocktypeframe = new StockTypeCardFrame();
		setListeners();
		mainframe.add(stocktypeframe);
		stocktypeframe.setVisible(true);
	}
	
	private void setListeners() {
		
		stocktypeframe.btn_Stock_Type_Save.addActionListener(new GeneralAction(new StockTypeCardSaveCommand(stocktypeframe)));
		stocktypeframe.btn_Stock_Type_Delete.addActionListener(new GeneralAction(new StockTypeCardDeleteCommand(stocktypeframe)));
		stocktypeframe.btn_Stock_Type_Update.addActionListener(new GeneralAction(new StockTypeCardUpdateCommand(stocktypeframe)));
		stocktypeframe.btn_First.addActionListener(new GeneralAction(new StockTypeCardFirstCommand(stocktypeframe)));
		stocktypeframe.btn_Next.addActionListener(new GeneralAction(new StockTypeCardNextCommand(stocktypeframe)));
		stocktypeframe.btn_Previous.addActionListener(new GeneralAction(new StockTypeCardPreviousCommand(stocktypeframe)));
		stocktypeframe.btn_Last.addActionListener(new GeneralAction(new StockTypeCardLastCommand(stocktypeframe)));

	}
	
}
