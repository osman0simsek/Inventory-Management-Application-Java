package view;

import java.awt.EventQueue;
import java.sql.ResultSet;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
 
public class KdvTypeCardFrame extends JInternalFrame {
	private JTextField txt_kdv_code;
	private JTextField txt_kdv_name;
	private JTextArea txt_kdv_rate;
	private JButton btn_kdv_save;
	private JButton btn_kdv_delete;
	private JButton btn_kdv_update;
	
	public JButton btn_First;
	public JButton btn_Next;
	public JButton btn_Previous;
	public JButton btn_Last;
	
	private JLabel lbl_id;
	private ResultSet rs;
	

	
	public JLabel getLbl_id() {
		return lbl_id;
	}



	public void setLbl_id(JLabel lbl_id) {
		this.lbl_id = lbl_id;
	}



	public JTextField getTxt_kdv_code() {
		return txt_kdv_code;
	}



	public void setTxt_kdv_code(JTextField txt_kdv_code) {
		this.txt_kdv_code = txt_kdv_code;
	}



	public JTextField getTxt_kdv_name() {
		return txt_kdv_name;
	}



	public void setTxt_kdv_name(JTextField txt_kdv_name) {
		this.txt_kdv_name = txt_kdv_name;
	}



	public JTextArea getTxt_kdv_rate() {
		return txt_kdv_rate;
	}



	public void setTxt_kdv_rate(JTextArea txt_kdv_rate) {
		this.txt_kdv_rate = txt_kdv_rate;
	}



	public JButton getBtn_kdv_save() {
		return btn_kdv_save;
	}



	public void setBtn_kdv_save(JButton btn_kdv_save) {
		this.btn_kdv_save = btn_kdv_save;
	}



	public JButton getBtn_kdv_delete() {
		return btn_kdv_delete;
	}



	public void setBtn_kdv_delete(JButton btn_kdv_delete) {
		this.btn_kdv_delete = btn_kdv_delete;
	}



	public JButton getBtn_kdv_update() {
		return btn_kdv_update;
	}



	public void setBtn_kdv_update(JButton btn_kdv_update) {
		this.btn_kdv_update = btn_kdv_update;
	}



	/**
	 * Create the frame.
	 */
	public KdvTypeCardFrame() {
		setTitle("KDV Tip Kartı");
		setIconifiable(true);
		setClosable(true);
		setBounds(1000, 0, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lbl_kdv_code = new JLabel("Kodu");
		lbl_kdv_code.setBounds(6, 17, 61, 16);
		getContentPane().add(lbl_kdv_code);
		
		JLabel lbl_kdv_name = new JLabel("Adı");
		lbl_kdv_name.setBounds(6, 79, 61, 16);
		getContentPane().add(lbl_kdv_name);
		
		JLabel lbl_kdv_rate = new JLabel("Oranı");
		lbl_kdv_rate.setBounds(6, 149, 61, 16);
		getContentPane().add(lbl_kdv_rate);
		
		txt_kdv_code = new JTextField();
		txt_kdv_code.setColumns(10);
		txt_kdv_code.setBounds(79, 12, 130, 26);
		getContentPane().add(txt_kdv_code);
		
		txt_kdv_name = new JTextField();
		txt_kdv_name.setColumns(10);
		txt_kdv_name.setBounds(79, 74, 130, 26);
		getContentPane().add(txt_kdv_name);
		
		txt_kdv_rate = new JTextArea();
		txt_kdv_rate.setBounds(79, 149, 130, 16);
		getContentPane().add(txt_kdv_rate);
		
		btn_kdv_save = new JButton("Kaydet");
		btn_kdv_save.setBounds(278, 17, 117, 29);
		getContentPane().add(btn_kdv_save);
		
		btn_kdv_delete = new JButton("Sil");
		btn_kdv_delete.setBounds(278, 74, 117, 29);
		getContentPane().add(btn_kdv_delete);
		
		btn_kdv_update = new JButton("Güncelle");
		btn_kdv_update.setBounds(278, 130, 117, 29);
		getContentPane().add(btn_kdv_update);
		
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
		
		lbl_id = new JLabel("");
		lbl_id.setBounds(6, 232, 61, 16);
		getContentPane().add(lbl_id);

	}
}
