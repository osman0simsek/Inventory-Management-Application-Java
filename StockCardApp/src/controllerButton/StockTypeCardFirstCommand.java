package controllerButton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import model.HibernateUtil;
import view.KdvTypeCardFrame;
import view.StockCardFrame;
import view.StockTypeCardFrame;

public class StockTypeCardFirstCommand implements ICommand {
	private StockTypeCardFrame stocktypecardframe;
	private ResultSet resultSet;
	private PreparedStatement stm;
	
	//"select * from stockcard1 where id = (select min(id) from stockcard1 where id < '"+id+"')"; first
	
	//"select * from stockcard1 where id = (select max(id) from stockcard1 where id > '"+id+"')"; last
	
	public StockTypeCardFirstCommand(StockTypeCardFrame kdvtypecardframe) {
		super();
		this.stocktypecardframe = kdvtypecardframe;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		String id = stocktypecardframe.getLbl_id().getText();
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "select * from stocktype where id = (select min(id) from stocktype where id < '"+id+"')";
		Query query = session.createNativeQuery(hql);
		List<Object[]> resultSet = query.getResultList();
		
		
		for(Object[] row : resultSet) {
			stocktypecardframe.getLbl_id().setText( row[0].toString());
			stocktypecardframe.txt_New_Stock_Name.setText((String) row[1]);
			stocktypecardframe.txt_New_Stock_Type.setText((String) row[2]);
			stocktypecardframe.txt_Stock_Explanation.setText((String) row[3]);
			
		}
		
	}

}
