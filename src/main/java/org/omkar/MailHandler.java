package org.omkar;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailHandler {

    void sendmail(){
        Properties sysproperties = System.getProperties();

        System.out.print(sysproperties);

        sysproperties.put(Mailmetadata.contact,Mailmetadata.Hostserver);

        sysproperties.put(Mailmetadata.setport,Mailmetadata.port);

        sysproperties.put(Mailmetadata.sslproperty,"true");

        sysproperties.put(Mailmetadata.authperm,"true");


        customauthentication  mailauth = new customauthentication();
        Session  mailsession= null;
        mailsession = mailsession.getInstance(sysproperties,mailauth);



        try
        {
            // MimeMessage object.
            MimeMessage message = new MimeMessage(mailsession);


            message.setFrom(Mailmetadata.myemail);


            message.setRecipient(Message.RecipientType.TO,new InternetAddress(Mailmetadata.recp));


            message.setSubject("my mail");


            message.setText("test");


            Transport.send(message);
            System.out.println("Mail successfully sent");
        }
        catch (MessagingException mex)
        {
            mex.printStackTrace();
        }


    }
}
