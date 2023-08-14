package controllerButton;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.HibernateUtil;
import model.StockModel;
import model.StockTypeModel;
import view.StockTypeCardFrame;

public class StockTypeCardSaveCommand implements ICommand {

	private StockTypeCardFrame stocktypecardframe;
	private StockTypeModel stocktypemodel = new StockTypeModel();
	

	public StockTypeCardSaveCommand(StockTypeCardFrame stokTipKart) {
		super();
		this.stocktypecardframe = stokTipKart;
		}

	@Override
	public void execute() {
		
		stocktypemodel = new StockTypeModel();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		stocktypemodel.setStockTypeCode(stocktypecardframe.txt_New_Stock_Type.getText());
		stocktypemodel.setStockTypeName(stocktypecardframe.txt_New_Stock_Name.getText());
		stocktypemodel.setStockTypeExplanation(stocktypecardframe.txt_Stock_Explanation.getText());
		session.save(stocktypemodel);
		transaction.commit();
		session.close();
		JOptionPane.showInternalMessageDialog(null, "Başarılı");
		
		
	}

}
