package main.Mailer;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Mailer {
    private final String botAddress = "botgmail";
    private final String botPassword = "password";
    private final String devAddress = "devgmail";
    private Properties properties;
    private Session session;
    public Mailer() {
        this.loadProperties();
        this.createSession();
    }

    private void loadProperties() {
        this.properties = new Properties();
        try (InputStream input = Mailer.class.getClassLoader().getResourceAsStream("./main/Mailer/config.properties")) {
            if (input == null) {
                System.out.println("Error! Unable to find config.properties");
                return;
            }
            properties.load(input);
        }
        catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    private void createSession() {
        this.session = Session.getInstance(this.properties,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(botAddress, botPassword);
                    }
                });
    }

    public void sendMessage(String subject, String messageText, File attachment) throws MessagingException, IOException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(botAddress));
        message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse(devAddress)
        );

        message.setSubject("BOT: " + subject);
        message.setContent(this.createMail(messageText, attachment));
        Transport.send(message);
    }

    private Multipart createMail(String messageText, File attachment) throws MessagingException, IOException {
        Multipart multipart = new MimeMultipart();
        BodyPart textBody = new MimeBodyPart();
        textBody.setText(messageText);
        multipart.addBodyPart(textBody);

        if (attachment != null) {
            MimeBodyPart attachmentBody = new MimeBodyPart();
            attachmentBody.attachFile(attachment);
            multipart.addBodyPart(attachmentBody);
        }

        return multipart;
    }
}
