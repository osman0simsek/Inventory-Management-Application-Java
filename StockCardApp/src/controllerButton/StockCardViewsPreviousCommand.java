package controllerButton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import model.HibernateUtil;
import view.StockCardFrame;

public class StockCardViewsPreviousCommand implements ICommand {
	private StockCardFrame stockcardframe;
	private ResultSet resultSet;
	private PreparedStatement stm;
	
	//"select * from stockcard1 where id = (select min(id) from stockcard1 where id < '"+id+"')"; first
	
	
	
	public StockCardViewsPreviousCommand(StockCardFrame stockcardframe) {
		super();
		this.stockcardframe = stockcardframe;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		String id = stockcardframe.getLbl_id().getText();
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "select * from stockcard1 where id = (select max(id) from stockcard1 where id < '"+id+"')";
		Query query = session.createNativeQuery(hql);
		List<Object[]> resultSet = query.getResultList();
		
		
		for(Object[] row : resultSet) {
			stockcardframe.getLbl_id().setText( row[0].toString());
			stockcardframe.txt_Stock_Code.setText((String) row[1]);
			stockcardframe.txt_Stock_Name.setText((String) row[2]);
			stockcardframe.cbox_StockType.setSelectedItem(row[3]);
			stockcardframe.cbox_Unit.setSelectedItem(row[4]);
			stockcardframe.txt_Barcode.setText((String) row[5]);
			stockcardframe.cbox_KDV.setSelectedItem(row[6]);
			stockcardframe.txt_Explanation.setText((String) row[7]);
			stockcardframe.FtxtF_Create_Date.setText( row[8].toString());
		}
		
	}

}
