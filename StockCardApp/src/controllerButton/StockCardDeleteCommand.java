package controllerButton;

import javax.swing.JOptionPane;


import org.hibernate.Session;
import org.hibernate.Transaction;

import model.HibernateUtil;
import model.StockModel;
import view.StockCardFrame;



public class StockCardDeleteCommand implements ICommand{
	
	private StockCardFrame stockcardframe;
	private StockModel stockmodel;
	
	
	
	public StockCardDeleteCommand(StockCardFrame stockcardframe) {
		super();
		this.stockcardframe = stockcardframe;
	}


	

	@Override
	public void execute() {
		
		int a =Integer.parseInt(stockcardframe.getLbl_id().getText());  
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		stockmodel = session.get(StockModel.class, a);
		session.delete(stockmodel);
		
		transaction.commit();
		session.close();
		JOptionPane.showMessageDialog(null, "Silindi");
		

	}

}
