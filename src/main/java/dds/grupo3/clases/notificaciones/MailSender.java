package dds.grupo3.clases.notificaciones;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

  public class MailSender {
    public static void sendMail(String recipient, String texto) throws MessagingException {
      Properties prop = new Properties();
      prop.put("mail.smtp.auth", true);
      prop.put("mail.smtp.starttls.enable", "true");
      prop.put("mail.smtp.host", "smtp.gmail.com");
      prop.put("mail.smtp.port", "587");

      String myAccount = "mihuellaapp2022@gmail.com";
      String password = "zxcnzdxudkgljanm";

      Session session = Session.getInstance(prop, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication(myAccount, password);
        }
      });
      Message message = prepareMessage(session,myAccount,recipient,texto);
      Transport.send(message);
    }

    private static Message prepareMessage(Session session, String myAccount,String recipient,String texto) {
      try {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(myAccount));
        message.setRecipients(
            Message.RecipientType.TO, InternetAddress.parse(recipient));
        message.setSubject("Notificacion Mi Huella App");
        message.setText(texto);
        return message;
      }
      catch (Exception exception){
        Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE,null,exception);
      }
      return null;
    }

  }
