package com.aopprac.aspects;

import com.aopprac.model.MailFormat;
import com.aopprac.model.UserDto;
import com.aopprac.service.EmailService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SendMailAspect {
    @Autowired
    private EmailService emailService;

    public void sendMail(String sendingAddress) {
        MailFormat mailFormat = new MailFormat();
        mailFormat.setToAddress(sendingAddress);
        mailFormat.setSubject("This is a test mail part 3");
        mailFormat.setTextBody("hi, test message");
        emailService.sendSimpleMessage(mailFormat);
    }

    @After(value = "execution(* com.aopprac.service.UserService.saveUser(..)) && args(user) ")
    public void sendMailAfterSignUp(JoinPoint joinPoint, UserDto user) {
        System.out.println(joinPoint.getSignature());
        System.out.println(user.getEmail());
        sendMail(user.getEmail());

    }
}
