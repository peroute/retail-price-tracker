import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;

public class emailSender {

    public static void sendEmail(Item item){
        Session currentsession = createSession();
        try {
            Message message = new MimeMessage(currentsession);
            message.setFrom(new InternetAddress("pricetracker123456@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(item.getEmail())
            );
            message.setSubject("Product reached target price!");
            message.setText("Congratulations! One of the products you’re watching has reached your target price of " + item.getTargetPrice()
                    +

                    "\nCheck it out now before it sells out: " +
                    item.getUrl()
                    + "\nHappy shopping! \nPriceTracker ");

            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    private static Session createSession(){
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
