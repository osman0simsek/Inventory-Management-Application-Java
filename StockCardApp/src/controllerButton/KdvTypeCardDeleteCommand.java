package controllerButton;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.HibernateUtil;
import model.KdvTypeModel;
import view.KdvTypeCardFrame;



public class KdvTypeCardDeleteCommand implements ICommand {
private KdvTypeCardFrame kdvtypecardframe;
	
	
	
	public KdvTypeCardDeleteCommand(KdvTypeCardFrame kdvtypecardframe) {
		super();
		this.kdvtypecardframe = kdvtypecardframe;
	}



	@Override
	public void execute() {
		
		int b =Integer.parseInt(kdvtypecardframe.getLbl_id().getText());  
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		KdvTypeModel kdvtypemodel = session.get(KdvTypeModel.class,b);
		session.delete(kdvtypemodel);
		
		transaction.commit();
		session.close();
		
		
		//JOptionPane.showMessageDialog(null, "Silindi");

		
		
		
	}
}
