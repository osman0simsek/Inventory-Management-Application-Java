package controllerButton;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.HibernateUtil;
import model.KdvTypeModel;
import view.KdvTypeCardFrame;

public class KdvTypeCardUpdateCommand implements ICommand {

private KdvTypeCardFrame kdvtypeframe;
	
	
	
	
	public KdvTypeCardUpdateCommand(KdvTypeCardFrame kdvTipKart) {
		super();
		this.kdvtypeframe = kdvTipKart;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		int a =Integer.parseInt(kdvtypeframe.getLbl_id().getText());  
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		
		KdvTypeModel kdvTip = session.get(KdvTypeModel.class, a);
		
		kdvTip.setKdvCode(kdvtypeframe.getTxt_kdv_code().getText());
		
		kdvTip.setKdvName(kdvtypeframe.getTxt_kdv_name().getText());
		
		kdvTip.setKdvRate(kdvtypeframe.getTxt_kdv_rate().getText());
		
		session.update(kdvTip);
		
		transaction.commit();
		session.close();
		JOptionPane.showMessageDialog(null, "Güncellendi");
		
	}
	
	

}
