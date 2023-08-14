package controllerButton;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.HibernateUtil;
import model.KdvTypeModel;
import model.StockCard;
import model.StockTypeModel;
import view.StockCardFrame;



public class StockCardViewsSaveCommand implements ICommand {

	private StockCardFrame stockcardframe;
	
	
	
	
	public StockCardViewsSaveCommand(StockCardFrame stockcardframe) {
		super();
		this.stockcardframe = stockcardframe;
	}




	@Override
	public void execute() {
		StockCard stockCard = new StockCard();

		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		stockCard.setStokKodu(stockcardframe.txt_Stock_Code.getText());
		
		stockCard.setStokAdi(stockcardframe.txt_Stock_Name.getText());
		
		stockCard.setStokTip((StockTypeModel) stockcardframe.cbox_StockType.getSelectedItem());
		
		stockCard.setBirimi((String)stockcardframe.cbox_Unit.getSelectedItem());
		
		stockCard.setBarkodu(stockcardframe.txt_Barcode.getText());
		
		stockCard.setKdvTypeModel((KdvTypeModel) stockcardframe.cbox_KDV.getSelectedItem());
		
		stockCard.setAciklama(stockcardframe.txt_Explanation.getText());
		
		stockCard.setOlusturmaTarihi(stockcardframe.FtxtF_Create_Date.getText());
		
		session.save(stockCard);
		transaction.commit();
		session.close();
		//JOptionPane.showMessageDialog(null, stockCard.getStokAdi()+ " " + stockCard.getStokKodu() +"Eklendi");
		
		
		
	}

}
