package controllerButton;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.HibernateUtil;
import model.KdvTypeModel;
import view.KdvTypeCardFrame;



public class KdvTypeCardSaveCommand implements ICommand {
	private KdvTypeCardFrame kdvtypecard;
	private KdvTypeModel kdvtypemodel = new KdvTypeModel();
	
	
	public KdvTypeCardSaveCommand(KdvTypeCardFrame kdvtypecardframe) {
		super();
		this.kdvtypecard = kdvtypecardframe;
	}


	@Override
	public void execute() {
		KdvTypeModel kdvtypemodel = new KdvTypeModel();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		kdvtypemodel.setKdvCode(kdvtypecard. getTxt_kdv_code().getText());
		kdvtypemodel.setKdvName(kdvtypecard.getTxt_kdv_name().getText());
		kdvtypemodel.setKdvRate(kdvtypecard.getTxt_kdv_rate().getText());
		session.save(kdvtypemodel);
		transaction.commit();
		session.close();
		JOptionPane.showInternalMessageDialog(null, "Başarılı");
		
	}
	
		
}
