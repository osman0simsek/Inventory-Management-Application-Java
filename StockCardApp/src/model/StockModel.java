package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;



public class StockModel {

	private String userName = "root";

	private String password = "";

	private String url = "jdbc:mysql://localhost:3306/stok1?characterEncoding=utf8";

	
	static {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private ResultSet resultSet;
	private Connection connection;
	private Statement statement;

	public Connection getConnection() {

		Connection connection = null;

		try {
			connection = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {

			e.printStackTrace();
			
		}
		return connection;
	}
	

	

	public List<StockCard> getAll() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<StockCard> fullList = session.createNativeQuery(
            		"SELECT"
            		  +" sc1.id, "
            		  +" sc1.stokKodu, "
            		  +" sc1.stokAdi, "
            		  +" sc1.stokTipi, "
            		  +" sc1.birimi, "
            		  +" sc1.barkodu, "
            		  +" sc1.KdvTipi, "
            		  +" sc1.aciklama, "
            		  +" sc1.olusturmaTarihi, "
            		  +" kd.kdvkodu, "
            		  +" kd.kdvadi, "
            		  +" kd.kdvorani, "
            		  +" sc.tipkodu, "
            		  +" sc.tipadi, "
            		  +" sc.tipaciklama "
            		 +"FROM"
            		  +" stockcard1 AS sc1 "
            		 +"LEFT JOIN"
            		  +" kdvtype AS kd ON kd.kdvkodu = sc1.id " 
            		 +"LEFT JOIN"
            		  +" stocktype AS sc ON sc.tipkodu = sc1.id "            		  
            		, StockCard.class).getResultList();
            System.out.println("Full list: " + fullList);
            return fullList;
        }catch (Exception e){
        	e.printStackTrace();
        	return null;
        }finally {
            session.close();
        }
		
		

	}

public List<StockTypeModel> stocktype() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<StockTypeModel> stokTipList = session.createNativeQuery("Select * from stocktype", StockTypeModel.class).getResultList();
            return stokTipList;
        }catch (Exception e){
            return null;
        }finally {
            session.close();
        }
	
	}

	public List<KdvTypeModel> kdvtype() {


		Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<KdvTypeModel> kdvList = session.createNativeQuery("Select * from kdvtype", KdvTypeModel.class).getResultList();
            return kdvList;
        }catch (Exception e){
            return null;
        }finally {
            session.close();
        }
		
	}
	
	public List<StockTypeModel> getList3() {

		List<StockTypeModel> dataStokKart = new ArrayList<StockTypeModel>();
		
		
		StockTypeModel stoktypemodel;

		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from stocktype ");
			while (resultSet.next()) {
				
				stoktypemodel = new StockTypeModel();
				
				stoktypemodel.setStockTypeCode(resultSet.getString("tipkodu"));
				stoktypemodel.setStockTypeName(resultSet.getString("tipadi"));
				stoktypemodel.setStockTypeExplanation(resultSet.getString("tipaciklama"));
				
				
				
				
				dataStokKart.add(stoktypemodel);
			}
			statement.close();
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block ,
			e.printStackTrace();
		}

		return dataStokKart;
	}
	
	public List<KdvTypeModel> getList2() {

		List<KdvTypeModel> dataStokKart = new ArrayList<KdvTypeModel>();
		
		
		KdvTypeModel kdvtypemodel;

		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from kdvtip ");
			while (resultSet.next()) {
				
				
				kdvtypemodel = new KdvTypeModel();
				

				
				kdvtypemodel.setKdvCode(resultSet.getString("kdvKodu"));
				kdvtypemodel.setKdvName(resultSet.getString("kdvdAdi"));
				kdvtypemodel.setKdvRate(resultSet.getString("kdvOrani"));
				
				
				
				dataStokKart.add(kdvtypemodel);
			}
			statement.close();
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block ,
			e.printStackTrace();
		}

		return dataStokKart;
	}
	

	public List<StockCard> getList() {

		List<StockCard> dataStokKart = new ArrayList<StockCard>();
		
		StockCard stockcard;
		StockTypeModel stokTip;
		KdvTypeModel kdvTip;

		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from stockcard1 ");
			while (resultSet.next()) {
				
				stockcard = new StockCard();
				kdvTip = new KdvTypeModel();
				stokTip = new StockTypeModel();

				stockcard.setId(resultSet.getInt("id"));
				stockcard.setStokKodu(resultSet.getString("stokKodu"));
				stockcard.setStokAdi(resultSet.getString("stokAdi"));
				stockcard.setStokTipiId(resultSet.getInt("stokTipi"));
				stockcard.setBirimi(resultSet.getString("birimi"));
				stockcard.setBarkodu(resultSet.getString("barkodu"));
				stockcard.setKdvTipiId(resultSet.getInt("kdvTipi"));
				stockcard.setAciklama(resultSet.getString("aciklama"));
				//stockcard.setStokTip(stokTip);
				
				dataStokKart.add(stockcard);
			}
			statement.close();
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block ,
			e.printStackTrace();
		}

		return dataStokKart;

	}

	public void copy(StockCard entity) {
		Connection connection = getConnection();

		try {
			Statement statement = connection.createStatement();

			statement.executeUpdate(
					"INSERT stockcard1(stokKodu ,stokAdi ,stokTipi,birimi ,barkodu,kdvTipi,aciklama,olusturmaTarihi)"
							+ " VALUES('" + entity.getStokKodu() + "' , '" + entity.getStokAdi() + "' , "
							+ entity.getStokTipiId() + ", '" + entity.getBirimi() + "', '" + entity.getBarkodu() + "',"
							+ entity.getKdvTipiId() + ",'" + entity.getAciklama() + "','" + entity.getOlusturmaTarihi()
							+ "')");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public ResultSet getResultSet() {
		return resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}

