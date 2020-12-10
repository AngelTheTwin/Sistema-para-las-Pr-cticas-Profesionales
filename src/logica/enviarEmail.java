/*
 * Copyright (C) {2020}
 * All rights reserved
 * Developed for {Universidad Veracruzana}
 *
 * @ author: Daniel García Morales
 * @ version: 2.0
 * Esta clase contiene los métodos necesarios para enviar un correo electronico
 */
package logica;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/*
 * @exception MessagingException | UnsupportedEncodingException
 * Method to send an email with the exception found
 */
public class enviarEmail{
        
    public static void enviarEmail(String mensaje, String destinatario){
    String remitente = "correo@correo";
    String contraseñaRemitente = "contraseña";

    Properties properties = new Properties();
    properties.put("mail.smtp.host", "smtp.gmail.com");
    properties.put("mail.smtp.starttls.enable", "true");
    properties.put("mail.smtp.port", "587");
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.user", remitente);
    properties.put("mail.password", contraseñaRemitente);

    Session session = Session.getInstance(properties, null);

    try {
        MimeMessage mimeMessage = new MimeMessage(session);
        mimeMessage.setFrom(new InternetAddress(remitente, "Universidad Veracruzana"));

        InternetAddress[] internetAddresses = {new InternetAddress(destinatario)};
        mimeMessage.setRecipients(Message.RecipientType.TO,internetAddresses);
        mimeMessage.setSubject("Sistema de Gestión de Practicas Profesionales");

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setText("Contraseña: " + mensaje);

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        mimeMessage.setContent(multipart);

        Transport transport = session.getTransport("smtp");
        transport.connect(remitente, contraseñaRemitente);
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        transport.close();
    }catch (MessagingException ex) {
        System.out.println(ex.toString());
    }catch (UnsupportedEncodingException ex) {
        System.out.println(ex.toString());
        }
    }
}
