package controllerButton;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.StockModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
import view.StockListFrame;


public class StockListMenuPdfCommand implements ICommand{
	
	private StockListFrame stocklistframe;
	
	
	
	public StockListMenuPdfCommand(StockListFrame stockList) {
		super();
		this.stocklistframe = stockList;
	}



	@Override
	public void execute() {
		
		InputStream stringPath = getClass().getResourceAsStream("/jasper/report2.jasper");
		try {

			Collection<Map<String, ?>> parameters = new ArrayList<>();
			Map<String, Object> maps = new HashMap<String, Object>();

			for (int i = 0; i < stocklistframe.table.getRowCount(); i++) {

				maps.put("STOK KODU", stocklistframe.table.getModel().getValueAt(i, i).toString());
				maps.put("STOK ADI", stocklistframe.table.getModel().getValueAt(i, 1).toString());
				maps.put("STOK TİPi", stocklistframe.table.getModel().getValueAt(i, 2).toString());
				maps.put("BİRİMİ", stocklistframe.table.getModel().getValueAt(i, 3).toString());
				maps.put("BARKODU", stocklistframe.table.getModel().getValueAt(i, 4).toString());
				maps.put("KDV", stocklistframe.table.getModel().getValueAt(i, 5).toString());
				maps.put("AÇIKLAMA", stocklistframe.table.getModel().getValueAt(i, 6).toString());
				maps.put("OLUŞTURMA TARİHİ", stocklistframe.table.getModel().getValueAt(i, 7).toString());
				parameters.add(maps);
			}

			JRMapCollectionDataSource beanColDataSource = new JRMapCollectionDataSource(parameters);

			JasperPrint jp = JasperFillManager.fillReport(stringPath, maps, beanColDataSource);

			JFrame exportJasperPrint = new JFrame();
			exportJasperPrint.getContentPane().add(new JRViewer(jp));
			exportJasperPrint.setBounds(500, 500, 1500, 1500);
			exportJasperPrint.pack();
			exportJasperPrint.setVisible(true);
		} catch (JRException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
//		StockModel stokDao = new StockModel();
//
//		Connection con = stokDao.getConnection();
//
//		try {
//			JasperDesign jasperDesign = JRXmlLoader
//					.load("/jasper/report2.jasper");
//			
//			String query = "SELECT \r\n"
//					+ "    stockcard1.Id,\r\n"
//					+ "    stockcard1.stokAdi,\r\n"
//					+ "    stockcard1.stokKodu,\r\n"
//					+ "    stockcard1.stokTipiId,\r\n"
//					+ "    stockcard1.birimi,\r\n"
//					+ "    stockcard1.kdvTipiId,\r\n"
//					+ "    stockcard1.barkodu,\r\n"
//					+ "    stockcard1.olusturmaTarihi,\r\n"
//					+ "    stockcard1.aciklama,\r\n"
//					+ "    kdvtype.kdvKodu,\r\n"
//					+ "    kdvtype.kdvdAdi,\r\n"
//					+ "    kdvtype.kdvOrani,\r\n"
//					+ "    stocktype.stokTipKodu,\r\n"
//					+ "    stocktype.stokTipAdi,\r\n"
//					+ "    stocktype.stokTipaciklama\r\n"
//					+ "FROM\r\n"
//					+ "    stockcard1,\r\n"
//					+ "    kdvtype,\r\n"
//					+ "    stocktype\r\n"
//					+ "WHERE\r\n"
//					+ "    kdvtype.Id = stockcard1.kdvtipiId\r\n"
//					+ "        AND stocktype.Id = stockcard1.stoktipiId;";
//			
//			JRDesignQuery updateQuery = new JRDesignQuery();
//			updateQuery.setText(query);
//			jasperDesign.setQuery(updateQuery);
//			
//			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
//			
//			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null,con);
//			
//			JasperExportManager.exportReportToPdfFile(jasperPrint,"//Users//osmansimsek//Documents//report.pdf");
//			try {
//				Desktop.getDesktop().open(new File("//Users//osmansimsek//Documents//report.pdf"));
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			
//			//JasperViewer.viewReport(jasperPrint);
//			
//			
//			
//			JOptionPane.showMessageDialog(null, "Oluşturuldu");
//		} catch (JRException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}		
//		

		
	}

}

	
