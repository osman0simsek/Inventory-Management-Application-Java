package controllerButton;

import javax.swing.table.DefaultTableModel;

import view.MainFrame;
import view.StockCardFrame;
import view.StockListFrame;

public class StockListMenuShowCommand implements ICommand {

	private StockListFrame  stoklistframe;
	private StockCardFrame stockcardframe;
	private MainFrame mainFrame;
	
	
	
	public StockListMenuShowCommand(StockListFrame stokList , MainFrame mainFrame) {
		super();
		this.stoklistframe = stokList;
		this.mainFrame = mainFrame;
	}




	@Override
	public void execute() {
		
		
		
		stockcardframe = new StockCardFrame();
		stockcardframe.setVisible(true);
		mainFrame.getContentPane().add(stockcardframe);
		stoklistframe.setVisible(false);
		
		DefaultTableModel model = (DefaultTableModel)stoklistframe.table.getModel();

		int selectRow = stoklistframe.table.getSelectedRow();
		stockcardframe.txt_Stock_Code.setText(model.getValueAt(selectRow, 1).toString());
		stockcardframe.txt_Stock_Name.setText(model.getValueAt(selectRow, 2).toString());
		stockcardframe.cbox_StockType.setSelectedItem(model.getValueAt(selectRow, 12).toString());
		stockcardframe.cbox_Unit.setSelectedItem(model.getValueAt(selectRow, 4).toString());
		stockcardframe.txt_Barcode.setText(model.getValueAt(selectRow, 5).toString());
		stockcardframe.cbox_KDV.setSelectedItem(model.getValueAt(selectRow, 10).toString());
		stockcardframe.txt_Explanation.setText(model.getValueAt(selectRow, 7).toString());
		
		stockcardframe.btn_Save.addActionListener(new GeneralAction(new StockCardViewsSaveCommand(stockcardframe)));
		stockcardframe.btn_Delete.addActionListener(new GeneralAction(new StockCardDeleteCommand(stockcardframe)));
		stockcardframe.btn_Update.addActionListener(new GeneralAction(new StockCardViewsUpdateCommand(stockcardframe)));
		stockcardframe.btn_Next.addActionListener(new GeneralAction(new StockCardViewsNextCommand(stockcardframe)));

		
	}

}
