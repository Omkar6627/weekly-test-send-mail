package org.omkar;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class customauthentication extends Authenticator {

   protected PasswordAuthentication getPasswordAuthentication(){
       return new PasswordAuthentication(Mailmetadata.myemail,Mailmetadata.mypass);


    }
}
