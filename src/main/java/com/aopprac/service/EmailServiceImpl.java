package com.aopprac.service;

import com.aopprac.model.MailFormat;
import com.aopprac.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    private String mailFrom;

    @Override
    public void sendSimpleMessage(MailFormat mailFormat) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(mailFormat.getToAddress());
        simpleMailMessage.setSubject(mailFormat.getSubject());
        simpleMailMessage.setText(mailFormat.getTextBody());
        simpleMailMessage.setFrom(mailFrom);
        try {
        emailSender.send(simpleMailMessage);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
