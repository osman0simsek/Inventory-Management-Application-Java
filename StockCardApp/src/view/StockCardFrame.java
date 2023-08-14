package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import model.StockModel;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class StockCardFrame extends JInternalFrame {
	public JDialog d;
	
	public JLabel lbl_Stock_Code;
	public JLabel lbl_Stock_Name;
	private JLabel lbl_id;
	
	public JTextField txt_Stock_Code;
	public JTextField txt_Stock_Name;
	public JTextField txt_Barcode;
	public JTextField txt_Explanation;
	public JTextField txt_Search_Stock_Code;
	public JFormattedTextField FtxtF_Create_Date;
	
	public JButton btn_Save;
	public JButton btn_Update;
	public JButton btn_Delete;
	public JButton btn_Copy;
	public JButton btn_List;
	public JButton btn_First;
	public JButton btn_Next;
	public JButton btn_Previous;
	public JButton btn_Last;
	
	public JComboBox cbox_StockType;
	public JComboBox cbox_Unit;
	public JComboBox cbox_KDV;
	
	public JLabel getLbl_id() {
		return lbl_id;
	}

	public void setLbl_id(JLabel lbl_id) {
		this.lbl_id = lbl_id;
	}


	/**
	 * Create the frame.
	 */
	public StockCardFrame() {
		setTitle("Stok Kartı");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(0, 0, 724, 350);
		getContentPane().setLayout(null);
		
		lbl_Stock_Code = new JLabel("STOK KODU");
		lbl_Stock_Code.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lbl_Stock_Code.setBounds(40, 6, 100, 25);
		getContentPane().add(lbl_Stock_Code);
		
		txt_Stock_Code = new JTextField();
		txt_Stock_Code.setColumns(10);
		txt_Stock_Code.setBounds(6, 34, 160, 25);
		getContentPane().add(txt_Stock_Code);
		
		lbl_Stock_Name = new JLabel("STOK ADI");
		lbl_Stock_Name.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lbl_Stock_Name.setBounds(244, 6, 84, 25);
		getContentPane().add(lbl_Stock_Name);
		
		txt_Stock_Name = new JTextField();
		txt_Stock_Name.setColumns(10);
		txt_Stock_Name.setBounds(197, 34, 160, 25);
		getContentPane().add(txt_Stock_Name);
		
		JLabel lbl_Stock_Type = new JLabel("STOK TİPİ");
		lbl_Stock_Type.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lbl_Stock_Type.setBounds(416, 6, 84, 25);
		getContentPane().add(lbl_Stock_Type);
		
		cbox_StockType = new JComboBox();
		cbox_StockType.setBounds(397, 36, 125, 25);
		getContentPane().add(cbox_StockType);
		cbox_StockType.setModel(new DefaultComboBoxModel(new StockModel().stocktype().toArray()));
		
		JLabel lbl_Unit = new JLabel("BİRİMİ");
		lbl_Unit.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lbl_Unit.setBounds(581, 6, 57, 25);
		getContentPane().add(lbl_Unit);
		
		cbox_Unit = new JComboBox();
		cbox_Unit.setBounds(543, 34, 140, 25);
		getContentPane().add(cbox_Unit);
		 cbox_Unit.setModel(new DefaultComboBoxModel(new String[] {"Adet", "Kilogram", "Metre"}));
		
		JLabel lbl_Barcode = new JLabel("BARKODU");
		lbl_Barcode.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lbl_Barcode.setBounds(56, 71, 84, 25);
		getContentPane().add(lbl_Barcode);
		
		txt_Barcode = new JTextField();
		txt_Barcode.setColumns(10);
		txt_Barcode.setBounds(6, 99, 160, 25);
		getContentPane().add(txt_Barcode);
		
		JLabel lbl_KDV = new JLabel("KDV TİPİ");
		lbl_KDV.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lbl_KDV.setBounds(207, 71, 79, 25);
		getContentPane().add(lbl_KDV);
		
		cbox_KDV = new JComboBox();
		cbox_KDV.setBounds(190, 101, 116, 25);
		getContentPane().add(cbox_KDV);
	    cbox_KDV.setModel(new DefaultComboBoxModel(new StockModel().kdvtype().toArray()));
		
		JLabel lbl_Explanation = new JLabel("AÇIKLAMA");
		lbl_Explanation.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lbl_Explanation.setBounds(360, 73, 100, 25);
		getContentPane().add(lbl_Explanation);
		
		txt_Explanation = new JTextField();
		txt_Explanation.setColumns(10);
		txt_Explanation.setBounds(318, 99, 160, 25);
		getContentPane().add(txt_Explanation);
		
		JLabel lbl_Create_Date = new JLabel("OLUŞTURMA TARİHİ");
		lbl_Create_Date.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lbl_Create_Date.setBounds(510, 73, 173, 25);
		getContentPane().add(lbl_Create_Date);
		
		FtxtF_Create_Date = new JFormattedTextField();
		FtxtF_Create_Date.setBounds(492, 99, 202, 25);
		getContentPane().add(FtxtF_Create_Date);
		
		btn_Save = new JButton("KAYDET");
		btn_Save.setBounds(178, 155, 160, 40);
		getContentPane().add(btn_Save);
		
		btn_Copy = new JButton("KOPYALA");
		btn_Copy.setBounds(360, 155, 160, 40);
		getContentPane().add(btn_Copy);
		
		btn_List = new JButton("LİSTELE");
		btn_List.setBounds(6, 155, 161, 40);
		getContentPane().add(btn_List);
		
		btn_Update = new JButton("GÜNCELLE");
		btn_Update.setBounds(533, 155, 161, 40);
		getContentPane().add(btn_Update);
		
		btn_Delete = new JButton("SİL");
		btn_Delete.setForeground(Color.RED);
		btn_Delete.setBounds(610, 196, 84, 40);
		getContentPane().add(btn_Delete);
		
		
		btn_First = new JButton();
		btn_First.setBorderPainted(false);
		btn_First.setIcon(new ImageIcon("/Users/osmansimsek/Downloads/button_blue_first1.png"));
		btn_First.setBounds(155, 246, 40, 40);
		getContentPane().add(btn_First);
		validate();
		
		btn_Next = new JButton();
		btn_Next.setBorderPainted(false);
		btn_Next.setIcon(new ImageIcon("/Users/osmansimsek/Downloads/button_blue_next.png"));
		btn_Next.setBounds(360, 246, 42, 40);
		getContentPane().add(btn_Next);
		
		btn_Previous = new JButton();
		btn_Previous.setBorderPainted(false);
		btn_Previous.setIcon(new ImageIcon("/Users/osmansimsek/Downloads/button_blue_previous.png"));
		btn_Previous.setBounds(264, 246, 42, 40);
		getContentPane().add(btn_Previous);
		
		btn_Last = new JButton();
		btn_Last.setBorderPainted(false);
		btn_Last.setIcon(new ImageIcon("/Users/osmansimsek/Downloads/button_blue_last1.png"));
		btn_Last.setBounds(460, 246, 40, 40);
		getContentPane().add(btn_Last);
		
		lbl_id = new JLabel("");
		lbl_id.setBounds(0, 282, 61, 16);
		getContentPane().add(lbl_id);
		


	}
}
