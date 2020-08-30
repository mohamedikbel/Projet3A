/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.sql.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;




import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author User
 */
public class EmailS {
    public void SendE(String a ,String N ,String P, int Nu  )
    {
        try{
            String host ="smtp.gmail.com" ;
            String user = "youssef.mhenni@esprit.tn";
            String pass = "youssef96287799momo";
            String to 
                     = a;
            String from = "youssef.mhenni@esprit.tn";
            String subject = "   --- CITE DE LA CULTURE  ---  DEMANDE  DE RECHERCHE VALIDER ";
            String messageText = "Bonjour Monsieur  :  " +N+" "+P+" \n votre demande  de recherche a été confirmée par l'l'administration  de la  cité de la culture. \n Le numéro de ta demande est  "+Nu+"\n" +
"nous vous informons qu'un rendez-vous a été pris demain à 9h pour nous donner plus d'informations sur l'avancement de vos recherches par le chef des recherches \n merci  \n" +"\n البريد الإلكتروني: contact.citeculture@mac.gov.tn\nلفاكس 70028312 \nلموزع المركزي لمدينة الثقافة 70028330 \n العنوان: شارع محمد الخامس ، تونس\n CITE DE LA CULTURE \n ";
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);
           
            msg.setText(messageText);

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
        }catch(Exception ex)
        {
            System.out.println(ex);
        }

    }
    
    
    
    /////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////
      public void SendER(String a ,String N ,String P )
    {
        try{
            String host ="smtp.gmail.com" ;
            String user = "youssef.mhenni@esprit.tn";
            String pass = "youssef96287799momo";
            String to 
                     = a;
            String from = "youssef.mhenni@esprit.tn";
            String subject = "   --- CITE DE LA CULTURE  ---  DEMANDE  DE RECHERCHE REFUSER ";
            String messageText = "Bonjour Monsieur  :  " +N+" "+P+" \n votre demande de recherche a été Refuser par l'administration de la cité de la culture . .\n \n" +
"Le résultat de cette refuse est prise par les membres responsables des recherches . .\n" +
"Tu peux nous envoient encore des demandes .\n" +
" \n merci\n "+" \nالبريد الإلكتروني: contact.citeculture@mac.gov.tn\nلفاكس 70028312 \nلموزع المركزي لمدينة الثقافة 70028330 \n العنوان: شارع محمد الخامس ، تونس\n CITE DE LA CULTURE \n ";
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);
           
            msg.setText(messageText);

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
        }catch(Exception ex)
        {
            System.out.println(ex);
        }

    }
    
    
    
    
    
}