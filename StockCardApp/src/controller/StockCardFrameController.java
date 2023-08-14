package controller;

import controllerButton.GeneralAction;
import controllerButton.StockCardDeleteCommand;
import controllerButton.StockCardViewsFirstCommand;
import controllerButton.StockCardViewsLastCommand;
import controllerButton.StockCardViewsNextCommand;
import controllerButton.StockCardViewsPreviousCommand;
import controllerButton.StockCardViewsSaveCommand;
import controllerButton.StockCardViewsUpdateCommand;
import view.MainFrame;
import view.StockCardFrame;



public class StockCardFrameController {
	
	private StockCardFrame stockcardframe;
	private MainFrame mainframe;
	
	public StockCardFrameController (MainFrame mainframe) {
		super();
		this.mainframe = mainframe;
	}
	
	public void execute() {
		stockcardframe = new StockCardFrame();
		setListeners();
		mainframe.add(stockcardframe);
		stockcardframe.setVisible(true);
	}
	
	public void setListeners() {

		stockcardframe.btn_Save.addActionListener(new GeneralAction(new StockCardViewsSaveCommand(stockcardframe)));
		stockcardframe.btn_Delete.addActionListener(new GeneralAction(new StockCardDeleteCommand(stockcardframe)));
		stockcardframe.btn_Update.addActionListener(new GeneralAction(new StockCardViewsUpdateCommand(stockcardframe)));
		stockcardframe.btn_Next.addActionListener(new GeneralAction(new StockCardViewsNextCommand(stockcardframe)));
		stockcardframe.btn_Previous.addActionListener(new GeneralAction(new StockCardViewsPreviousCommand(stockcardframe)));
		stockcardframe.btn_First.addActionListener(new GeneralAction(new StockCardViewsFirstCommand(stockcardframe)));
		stockcardframe.btn_Last.addActionListener(new GeneralAction(new StockCardViewsLastCommand(stockcardframe)));

}
	
}
