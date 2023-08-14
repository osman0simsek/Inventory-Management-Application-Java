package controllerButton;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.HibernateUtil;
import model.StockModel;
import model.StockTypeModel;
import view.StockTypeCardFrame;


public class StockTypeCardUpdateCommand implements ICommand {
	private StockTypeCardFrame stocktypecardframe;
	private StockTypeModel stocktypemodel = new StockTypeModel();
	
	public StockTypeCardUpdateCommand(StockTypeCardFrame stokTipKart) {
		super();
		this.stocktypecardframe = stokTipKart;
	}


	@Override
	public void execute() {
		
		int b = Integer.parseInt(stocktypecardframe.getLbl_id().getText()); 
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		
		
		stocktypemodel.setStockTypeCode(stocktypecardframe.txt_New_Stock_Type.getText());
		stocktypemodel.setStockTypeName(stocktypecardframe.txt_New_Stock_Name.getText());
		stocktypemodel.setStockTypeExplanation(stocktypecardframe.txt_Stock_Explanation.getText());
		session.update(stocktypemodel);
		transaction.commit();
		session.close();
		
	}

}
