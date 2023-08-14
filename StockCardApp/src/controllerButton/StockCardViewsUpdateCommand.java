package controllerButton;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.HibernateUtil;
import model.KdvTypeModel;
import model.StockCard;
import model.StockTypeModel;
import view.StockCardFrame;



public class StockCardViewsUpdateCommand implements ICommand {
	
	private StockCardFrame stockcardframe;
	
	
	
	public StockCardViewsUpdateCommand(StockCardFrame stockcardframe) {
		super();
		this.stockcardframe = stockcardframe;
	}


	@Override
	public void execute() {
		int a =Integer.parseInt(stockcardframe.getLbl_id().getText());  

		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		StockCard stockCard = session.get(StockCard.class, a);
		
		stockCard.setStokKodu(stockcardframe.txt_Stock_Code.getText());
		
		stockCard.setStokAdi(stockcardframe.txt_Stock_Name.getText());
		
		stockCard.setKdvTypeModel((KdvTypeModel) stockcardframe.cbox_KDV.getSelectedItem());
		
		stockCard.setStokTip((StockTypeModel) stockcardframe.cbox_StockType.getSelectedItem());
		
		stockCard.setBirimi((String)stockcardframe.cbox_Unit.getSelectedItem());
		
		stockCard.setBarkodu(stockcardframe.txt_Barcode.getText());
		
		stockCard.setAciklama(stockcardframe.txt_Explanation.getText());
		
		stockCard.setOlusturmaTarihi(stockcardframe.FtxtF_Create_Date.getText());
		
		
		session.update(stockCard);
		transaction.commit();
		session.close();
		JOptionPane.showMessageDialog(null, "Güncellendi");
		
		
	}

}
