package model;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



public class HibernateUtil {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();
	 
	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure()
					.addAnnotatedClass(StockTypeModel.class)
					.addAnnotatedClass(KdvTypeModel.class)
					.addAnnotatedClass(StockModel.class)
					.addAnnotatedClass(StockCard.class)
					.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("SessionFactory oluşturulamadı." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
 
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
 
	public static void shutdown() {
		getSessionFactory().close();
	}

}
