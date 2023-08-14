package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JMenuBar menuBar;
	public JMenu menu, menu2;
	public JMenuItem m1, m2, m3, m4;
	
	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("Case Study 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 0, 800, 824);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		menu = new JMenu("Stok Menüsü");
		menuBar.add(menu);
		m1 = new JMenuItem("Stok Kartı");
	    menu.add(m1);
	    m2 = new JMenuItem("Stok Listesi");
	    menu.add(m2);
	    menu2 = new JMenu("Tip Menüsü");
	    menuBar.add(menu2);
	    m3 = new JMenuItem("Stok Tip Kartı");
	    menu2.add(m3);
	    m4 = new JMenuItem("KDV Tip Kartı");
	    menu2.add(m4);
		
	}
}
