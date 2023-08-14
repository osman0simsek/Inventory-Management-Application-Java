package controllerButton;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

import view.StockListFrame;


public class StockListMenuMailCommand implements ICommand {
	
	private StockListFrame stocklistframe;
	
	
	
	public StockListMenuMailCommand(StockListFrame stokList) {
		super();
		this.stocklistframe = stokList;
	}



	@Override
	public void execute() {

		String from = "osman0simsek@yandex.com";
		String pass = "Osman.789789";
		String title = "Dosya";
		String file = "//Users//osmansimsek//Documents//report.pdf";
		String to = JOptionPane.showInputDialog("Mail Adresini Giriniz");
		
		
		Properties properties = System.getProperties();
		Session session;
		MimeMessage mesaj;
		//Message
		String host = "smtp.yandex.com";
		Integer port = 465;
		Properties properties1 = new Properties();
		properties1.put("mail.smtp.host", host);
		properties1.put("mail.smtp.ssl.enable", true);
		properties1.put("mail.smtp.port", port);
		properties1.put("mail.smtp.auth", "true");
		
		session = Session.getInstance(properties1,new Authenticator() {
			
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication(from, pass);
			}
			
		});
	
		
		
		mesaj = new MimeMessage(session);
		try {
			mesaj.setFrom(new InternetAddress(from));
			mesaj.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			mesaj.setText(file);
			mesaj.setSubject(title);
								
			BodyPart attachment = new MimeBodyPart();
			attachment.setDataHandler(new DataHandler (new FileDataSource(file)));
			attachment.setFileName("reports.pdf");
			
			
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(attachment);
			
			mesaj.setContent(multipart);

			Transport.send(mesaj);
			
			//JOptionPane.showMessageDialog(null, "Mail Gönderildi");
		} catch (AddressException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (MessagingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		
	}

}
