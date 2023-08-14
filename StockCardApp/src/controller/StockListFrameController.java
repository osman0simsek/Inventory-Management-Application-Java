package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import controllerButton.GeneralAction;
import controllerButton.StockListMenuExcelCommand;
import controllerButton.StockListMenuMailCommand;
import controllerButton.StockListMenuPdfCommand;
import controllerButton.StockListMenuShowCommand;
import view.MainFrame;
import view.StockListFrame;

public class StockListFrameController {

	private StockListFrame stocklistframe;
	private MainFrame mainframe;
	
	public StockListFrameController(MainFrame mainframe) {
		super();
		this.mainframe = mainframe;
	}
	
	public void execute() {
		
		stocklistframe = new StockListFrame();
		mainframe.add(stocklistframe);
		stocklistframe.setVisible(true);
		stocklistframe.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent e) {
		        if (e.isPopupTrigger()) {
		            stocklistframe.popup.show(e.getComponent(), e.getX(), e.getY());
		        }
		    }
		});
		
		stocklistframe.table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(e.isPopupTrigger()) {
					
					stocklistframe.popup.show(e.getComponent(), e.getX(),e.getY());
					
				}
			}
		});

		setListeners();
		
	}
	
	private void setListeners() {
		
		stocklistframe.s1.addActionListener(new GeneralAction(new StockListMenuExcelCommand(stocklistframe)));
		stocklistframe.s2.addActionListener(new GeneralAction(new StockListMenuPdfCommand(stocklistframe)));
		stocklistframe.s3.addActionListener(new GeneralAction(new StockListMenuMailCommand(stocklistframe)));
		stocklistframe.s4.addActionListener(new GeneralAction(new StockListMenuShowCommand(stocklistframe, mainframe)));

	
	}
}
