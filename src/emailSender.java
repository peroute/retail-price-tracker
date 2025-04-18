import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;


public class emailSender {
    public static void main(String[] args) {

        sendEmail("work.harder.than.u.think@gmail.com","pricetracker123456@gmail.com");
    }
    public static void sendEmail(String emailAdress, String from){
        Session currentsession = createSession();
        try {
            Message message = new MimeMessage(currentsession);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(emailAdress)
            );
            message.setSubject("JavaMail Test");
            message.setText("Hello! This is a test email sent using JavaMail.");

            Transport.send(message);
            System.out.println("Email sent!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    public static Session createSession(){
        final String username = "pricetracker123456@gmail.com";
        final String password = "jber croa slkl eozd";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        return session;

    }

}
