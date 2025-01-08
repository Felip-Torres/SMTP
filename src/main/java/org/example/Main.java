package org.example;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        // Configuración de las propiedades de la conexión SMTP
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); // Servidor SMTP (Gmail en este caso)
        props.put("mail.smtp.port", "587"); // Puerto para TLS
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // Habilitar TLS

        // Autenticación
        String username = "ftr1500@gmail.com"; // Cambiar por tu correo
        String password = "ijwr olik trso vcrh"; // Cambiar por tu contraseña o contraseña de aplicación

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Crear el mensaje de correo
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("ftr1500@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("ftr1500@gmail.com")
            );
            message.setSubject("Prueba de SMTP con Java");
            message.setText("¡Hola! Este correo fue enviado desde un programa Java utilizando Jakarta Mail.");

            // Enviar el mensaje
            Transport.send(message);

            System.out.println("Correo enviado con éxito.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
