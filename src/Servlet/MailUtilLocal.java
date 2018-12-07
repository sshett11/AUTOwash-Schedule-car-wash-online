package Servlet;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtilLocal
{
  public MailUtilLocal() {}
  
  public static void sendMail(String to, String from, String subject, String body, boolean bodyIsHTML) throws MessagingException
  {
    Properties props = new Properties();
    props.put("mail.transport.protocol", "smtp");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.quitwait", "true");
    
    
    Session session = Session.getDefaultInstance(props);
    session.setDebug(true);
    

    Message message = new MimeMessage(session);
    message.setSubject(subject);
    if (bodyIsHTML) {
      message.setContent(body, "text/html");
    } else {
      message.setText(body);
    }
    Address fromAddress = new InternetAddress(from);
    Address toAddress = new InternetAddress(to);
    message.setFrom(fromAddress);
    message.setRecipient(Message.RecipientType.TO, toAddress);
    
    Transport transport = session.getTransport();
    transport.connect("", "");/* Enter "Emaild_Id" & "Password" */
    transport.sendMessage(message, message.getAllRecipients());
    transport.close();
  }
}
