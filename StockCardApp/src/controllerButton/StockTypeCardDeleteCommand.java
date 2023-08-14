package controllerButton;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.HibernateUtil;
import model.StockModel;
import model.StockTypeModel;
import view.StockTypeCardFrame;


public class StockTypeCardDeleteCommand implements ICommand {
	
	private StockTypeCardFrame stocktypecardframe;
	private StockModel stockmodel = new StockModel();

	
	public StockTypeCardDeleteCommand(StockTypeCardFrame stokTipKart) {
		super();
		this.stocktypecardframe = stokTipKart;
	}




	@Override
	public void execute() {
		

		int b = Integer.parseInt(stocktypecardframe.getLbl_id().getText());
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		StockTypeModel stocktypemodel = session.get(StockTypeModel.class, b);
		
		session.delete(stocktypemodel);
		transaction.commit();
		session.close();

		JOptionPane.showMessageDialog(null, "Silindi");
		

		
	}

}
