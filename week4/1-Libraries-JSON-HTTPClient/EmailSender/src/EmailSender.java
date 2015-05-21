import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class EmailSender {
    public static void main(String[] arguments) throws EmailException {
        
          EmailAttachment attachment = new EmailAttachment();
          
          attachment.setPath("azbW3zq_460sa_v1.gif");
          attachment.setDisposition(EmailAttachment.ATTACHMENT);
          attachment.setDescription("Suarez Bites...!");
          attachment.setName("Valery");

          MultiPartEmail email = new MultiPartEmail();
          
          email.setHostName("smtp.gmail.com");
          email.setSmtpPort(465);
          email.setAuthenticator(new DefaultAuthenticator("valerymaznev@gmail.com", "password"));
          email.setSSLOnConnect(true);
          email.setDebug(true);
          email.addTo("valerymaznev@gmail.com", "Valery");
          email.setFrom("valerymaznev@gmail.com", "Me");
          email.setSubject("Suarez Bites...!");
          email.setMsg("Here Is The Picture You Wanted...!");

          email.attach(attachment);
          
          email.send();
          
          System.out.println("Email Send Successfully...!");

    }
          
}
