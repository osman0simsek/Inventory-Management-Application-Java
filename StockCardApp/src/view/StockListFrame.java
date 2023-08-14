package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.StockListFrameController;
import model.KdvTypeModel;
import model.StockCard;
import model.StockModel;
import model.StockTypeModel;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import java.awt.Font;
import javax.swing.JTextField;

public class StockListFrame extends JInternalFrame {
	
		StockModel stockmodel;
		public JTable table;
		public DefaultTableModel tablemodel;
		public JTextField txt_Search_Stock_Code;
		
		public JPopupMenu popup;
		public JMenuItem s1,s2,s3,s4;
	/**
	 * Create the frame.
	 */
	public StockListFrame() {
		setTitle("Stok Listesi");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(0, 350, 814, 406);
		getContentPane().setLayout(null);
		
		
		
		tablemodel = new DefaultTableModel();
		
		tablemodel.addColumn("id");
		tablemodel.addColumn("stokKodu");
		tablemodel.addColumn("stokAdi");
		tablemodel.addColumn("stokTipi");
		tablemodel.addColumn("birimi");
		tablemodel.addColumn("barkodu");
		tablemodel.addColumn("KdvTipi");
		tablemodel.addColumn("aciklama");
		tablemodel.addColumn("olusturmaTarihi");
		tablemodel.addColumn("kdvkodu");
		tablemodel.addColumn("kdvadi");
		tablemodel.addColumn("kdvorani");
		tablemodel.addColumn("tipkodu");
		tablemodel.addColumn("tipadi");
		tablemodel.addColumn("tipaciklama");
		
		stockmodel = new StockModel();
		for (StockCard stockCard : stockmodel.getAll()) {
			StockTypeModel stocktypemodel = new StockTypeModel();
			KdvTypeModel kdvtypemodel = new KdvTypeModel();
		    tablemodel.addRow(new Object[] {
		        stockCard.getId(),
		        stockCard.getStokKodu(),
		        stockCard.getStokAdi(),
		        stockCard.getStokTip(),
		        stockCard.getBirimi(),
		        stockCard.getBarkodu(),
		        stockCard.getKdvTipiId(),
		        stockCard.getAciklama(),
		        stockCard.getOlusturmaTarihi(),
		        kdvtypemodel.getKdvCode(),
		        kdvtypemodel.getKdvName(),
		        kdvtypemodel.getKdvRate(),
		        stocktypemodel.getStockTypeCode(),
		        stocktypemodel.getStockTypeName(),
		        stocktypemodel.getStockTypeExplanation(),
		    });
		}


		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 59, 778, 295);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lbl_Search_Stock_Code = new JLabel("STOK KODU İLE ARA");
		//lbl_Search_Stock_Code.setVisible(false);
		lbl_Search_Stock_Code.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lbl_Search_Stock_Code.setBounds(24, 6, 160, 25);
		getContentPane().add(lbl_Search_Stock_Code);
		
		//txt_Search_Stock_Code.setVisible(false);
		txt_Search_Stock_Code = new JTextField();
		txt_Search_Stock_Code.setColumns(10);
		txt_Search_Stock_Code.setBounds(6, 31, 194, 25);
		getContentPane().add(txt_Search_Stock_Code);
		
		table.setModel(tablemodel);
		
		popup = new JPopupMenu();
		s1 = new JMenuItem("Excel'e Aktar");
		popup.add(s1);
		s2 = new JMenuItem("PDF aktar");
		popup.add(s2);
		s3 = new JMenuItem("Mail olarak gönder");
		popup.add(s3);
		s4 = new JMenuItem("Stok kartında göster");
		popup.add(s4);


	}
}
