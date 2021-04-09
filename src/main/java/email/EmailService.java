package email;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import io.jsonwebtoken.io.IOException;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;

    public void sendEmailEtudiant(EmailModel user) throws MessagingException, IOException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        Map<String, Object> props = new HashMap<String, Object>();
        props.put("message", user.getMessage());
 
        Context context = new Context();
        context.setVariables(props);
        String html = templateEngine.process("etudiant", context);
        helper.setTo(user.getDestinataire());
        helper.setSubject(user.getObjet());
        helper.setText(html, true);

        emailSender.send(message);
    }
    
    public void sendEmailAgent(EmailModel user) throws MessagingException, IOException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        Map<String, Object> props = new HashMap<String, Object>();
        props.put("message", user.getMessage());
        props.put("email", user.getDestinataire());
        props.put("password", user.getPassword());
 
        Context context = new Context();
        context.setVariables(props);
        String html = templateEngine.process("agent", context);
        helper.setTo(user.getDestinataire());
        helper.setSubject(user.getObjet());
        helper.setText(html, true);

        emailSender.send(message);
    }
    
    public void sendEmailForLivre(EmailModel user) throws MessagingException, IOException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        Map<String, Object> props = new HashMap<String, Object>();
        props.put("message", user.getMessage());
        props.put("numero", user.getNumero());
 
        Context context = new Context();
        context.setVariables(props);
        String html = templateEngine.process("livre", context);
        helper.setTo(user.getDestinataire());
        helper.setSubject(user.getObjet());
        helper.setText(html, true);

        emailSender.send(message);
    }

}