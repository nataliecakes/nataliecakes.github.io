

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class SenderEmails {
	 
	  public static boolean sendMyMessage(String name, String phone, String email, String cake, String fill, String messageUser) throws AddressException, MessagingException {

		  

	        final String from = "areserved65@gmail.com";
	        final String password = "cakesnatulya123321";
	        
	       
	          String to = "nastiagr1603@gmail.com"; 

	          Properties properties = System.getProperties();

	          properties.put("mail.smtp.auth", true);
	          properties.put("mail.smtp.starttls.enable", true);
	          properties.put("mail.smtp.host", "smtp.gmail.com");
	          properties.put("mail.smtp.port", "587");
	          
	         
	          properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");


	          properties.put("mail.user", from);
	          properties.put("mail.password", password);

	          Authenticator auth = new Authenticator()
	          {
	              public PasswordAuthentication getPasswordAuthentication()
	              {
	                  return new PasswordAuthentication(from, password);
	              }
	          };
	          Session session = Session.getInstance(properties, auth);

	          try
	          {
	             MimeMessage message = new MimeMessage(session);
	             
	             message.setFrom(new InternetAddress(from));

	             message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));

	             message.setSubject("Заказ на торт");	             

	             message.setText("Имя:"+name+
	            		 "\nТелефон:"+phone+
	            		 "\nАдрес электронной почты:"+email+
	            		 "\nТорт:"+cake+
	            		 "\nНачинка:"+fill
	            		 +"\nСообщение:"+messageUser);

	             Transport.send(message);
	             System.out.println("Sent message successfully....");
	             return true;
	          }
	          catch (SendFailedException mex)
	          {
	             mex.printStackTrace();
	             return false;
	          }

	  }
  

}
