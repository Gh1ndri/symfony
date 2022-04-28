/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

//import java.util.Properties;
//import javax.mail.Session;
//import javax.mail.Authenticator;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
import javax.mail.internet.*; 
import java.util.Properties;  
import javax.mail.*; 
/**
 *
 * @author leith
 */
public class JavaMail {
    
//    public static void sendMail(String email) throws Exception{
//        Properties p= new Properties();
//        p.put("mail.smtp.auth", "true");
//        p.put("mail.smtp.starttls.enable", "true");
//        p.put("mail.smtp.host", "smtp.gmail.com");
//        p.put("mail.smtp.port", "547");
//        
//        String accountEmail ="leithhamza.ghandri@esprit.tn";
//        String passwd ="211JMT2082";
//        Session session = Session.getInstance(p, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication(){
//                return new PasswordAuthentication(accountEmail,passwd);
//            }
//        });
//        Message message = prepareMessage(session,accountEmail,email); 
//        Transport.send(message);
//    }
//    
//    private static Message prepareMessage(Session session, String myAccount, String recepient){
//        try{
//            Message message =new MimeMessage(session);
//            message.setFrom(new InternetAddress(myAccount));
//            message.setRecipient(Message.RecipientType.TO,new InternetAddress(recepient));
//            message.setSubject("test");
//            message.setText("hello");
//        return message;
//        }catch(Exception ex){
//            System.out.print(ex);
//        }                                
//        return null;
//    } 
    
    public static void send(String from,String pwd,String to,String sub,String msg){
    //Propriétés
    Properties p = new Properties();
    p.put("mail.smtp.host", "smtp.gmail.com");
    p.put("mail.smtp.socketFactory.port", "465");
    p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    p.put("mail.smtp.auth", "true");
    p.put("mail.smtp.port", "465");
    //Session
    Session s = Session.getDefaultInstance(p,
      new javax.mail.Authenticator() {
      protected PasswordAuthentication getPasswordAuthentication() {
         return new PasswordAuthentication(from, pwd);
      }
    });
    //composer le message
    try {
      MimeMessage m = new MimeMessage(s);
      m.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
      m.setSubject(sub);
      m.setText(msg);
      //envoyer le message
      Transport.send(m);
      System.out.println("Message envoyé avec succès");
    } catch (MessagingException e) {
      e.printStackTrace();
    }
  }
}
