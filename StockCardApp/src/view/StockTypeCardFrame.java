package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StockTypeCardFrame extends JInternalFrame {

	public JTextField txt_New_Stock_Type;
	public JTextField txt_New_Stock_Name;
	public JTextArea txt_Stock_Explanation;
	public JButton btn_Stock_Type_Save;
	public JButton btn_Stock_Type_Delete;
	public JButton btn_Stock_Type_Update;
	
	public JButton btn_First;
	public JButton btn_Next;
	public JButton btn_Previous;
	public JButton btn_Last;
	private JLabel lbl_id;


	public JLabel getLbl_id() {
		return lbl_id;
	}


	public void setLbl_id(JLabel lbl_id) {
		this.lbl_id = lbl_id;
	}


	/**
	 * Create the frame.
	 */
	public StockTypeCardFrame() {
		setTitle("Stok Tip Kartı");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(1000, 400, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kodu");
		lblNewLabel.setBounds(6, 17, 61, 16);
		getContentPane().add(lblNewLabel);
		
		txt_New_Stock_Type = new JTextField();
		txt_New_Stock_Type.setColumns(10);
		txt_New_Stock_Type.setBounds(79, 12, 130, 26);
		getContentPane().add(txt_New_Stock_Type);
		
		JLabel lblAd = new JLabel("Adı");
		lblAd.setBounds(6, 79, 61, 16);
		getContentPane().add(lblAd);
		
		txt_New_Stock_Name = new JTextField();
		txt_New_Stock_Name.setColumns(10);
		txt_New_Stock_Name.setBounds(79, 74, 130, 26);
		getContentPane().add(txt_New_Stock_Name);
		
		JLabel lblNewLabel_2 = new JLabel("Açıklama");
		lblNewLabel_2.setBounds(6, 149, 61, 16);
		getContentPane().add(lblNewLabel_2);
		
		txt_Stock_Explanation = new JTextArea();
		txt_Stock_Explanation.setBounds(79, 149, 130, 16);
		getContentPane().add(txt_Stock_Explanation);
		
		btn_Stock_Type_Save = new JButton("Kaydet");
		btn_Stock_Type_Save.setBounds(280, 46, 117, 29);
		getContentPane().add(btn_Stock_Type_Save);
		
		lbl_id = new JLabel("");
		lbl_id.setBounds(0, 232, 61, 16);
		getContentPane().add(lbl_id);
		
		btn_Stock_Type_Delete = new JButton("Sil");
		btn_Stock_Type_Delete.setBounds(280, 100, 117, 29);
		getContentPane().add(btn_Stock_Type_Delete);
		
		btn_Stock_Type_Update = new JButton("Güncelle");
		btn_Stock_Type_Update.setBounds(280, 144, 117, 29);
		getContentPane().add(btn_Stock_Type_Update);
		
		btn_First = new JButton();
		btn_First.setBorderPainted(false);
		btn_First.setIcon(new ImageIcon("/Users/osmansimsek/Downloads/button_blue_first1.png"));
		btn_First.setBounds(105, 208, 40, 40);
		getContentPane().add(btn_First);
		validate();
		
		btn_Next = new JButton();
		btn_Next.setBorderPainted(false);
		btn_Next.setIcon(new ImageIcon("/Users/osmansimsek/Downloads/button_blue_next.png"));
		btn_Next.setBounds(225, 208, 42, 40);
		getContentPane().add(btn_Next);
		
		btn_Previous = new JButton();
		btn_Previous.setBorderPainted(false);
		btn_Previous.setIcon(new ImageIcon("/Users/osmansimsek/Downloads/button_blue_previous.png"));
		btn_Previous.setBounds(157, 208, 42, 40);
		getContentPane().add(btn_Previous);
		
		btn_Last = new JButton();
		btn_Last.setBorderPainted(false);
		btn_Last.setIcon(new ImageIcon("/Users/osmansimsek/Downloads/button_blue_last1.png"));
		btn_Last.setBounds(279, 208, 40, 40);
		getContentPane().add(btn_Last);

	}
}
