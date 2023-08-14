package controllerButton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.HibernateUtil;
import view.KdvTypeCardFrame;
import view.StockCardFrame;
//"select * from stockcard1 where id = (select min(id) from stockcard1 where id > '"+id+"')";


public class KdvTypeCardNextCommand implements ICommand {
	private KdvTypeCardFrame kdvtypecardframe;
	private ResultSet resultSet;
	private PreparedStatement stm;
	
	//"select * from stockcard1 where id = (select min(id) from stockcard1 where id < '"+id+"')"; first
	
	//"select * from stockcard1 where id = (select max(id) from stockcard1 where id > '"+id+"')"; last
	
	public KdvTypeCardNextCommand(KdvTypeCardFrame kdvtypecardframe) {
		super();
		this.kdvtypecardframe = kdvtypecardframe;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		String id = kdvtypecardframe.getLbl_id().getText();
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql ="select * from kdvtype where id = (select min(id) from kdvtype where id > '"+id+"')";
		Query query = session.createNativeQuery(hql);
		List<Object[]> resultSet = query.getResultList();
		
		
		for(Object[] row : resultSet) {
			kdvtypecardframe.getLbl_id().setText( row[0].toString());
			kdvtypecardframe.getTxt_kdv_code().setText((String) row[1]);
			kdvtypecardframe.getTxt_kdv_name().setText((String) row[2]);
			kdvtypecardframe.getTxt_kdv_rate().setText((String) row[3]);
			
		}
		
	}

}
