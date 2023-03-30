package com.sustech.service.impl;

import com.sustech.entity.User;
import com.sustech.mapper.UserMapper;
import com.sustech.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.security.GeneralSecurityException;
import java.util.Properties;
import java.util.Random;

/**
 * <p>
 *
 * </p>
 *
 * @author ${author}
 * @since 2023-03-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public boolean sendNotification(String email) {
        String mess = "Some notification";
        return sendEmail(email, mess);
    }

    @Override
    public String sendVerification(String email) {
        Random random = new Random();
        int num = random.nextInt(1000000);
        String ver = String.valueOf(num);
        String mess = "本次验证码为：" + ver;
        sendEmail(email, mess);
        return ver;
    }

    @Override
    public boolean sendEmail(String email, String text) {
//        String from = "457894974@qq.com";
//        String host = "smtp.qq.com";
//
//        Properties properties = System.getProperties();
//        properties.setProperty("mail.smtp.host", host);
//        properties.put("mail.smtp.auth", "true");
//        MailSSLSocketFactory sf = null;
//        try {
//            sf = new MailSSLSocketFactory();
//        } catch (GeneralSecurityException e) {
//            e.printStackTrace();
//        }
//        assert sf != null;
//        sf.setTrustAllHosts(true);
//        properties.put("mail.smtp.ssl.enable", "true");
//        properties.put("mail.smtp.ssl.socketFactory", sf);
//        Session session = Session.getDefaultInstance(properties, new Authenticator() {
//            @Override
//            public PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication("457894974@qq.com", "qvsbwuuaunohbiib"); //发件人邮件用户名、密码
//            }
//        });
//
//        try {
//            MimeMessage message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(from));
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
//
//            message.setSubject("SUSTech Store");
//            message.setText(text);
//
//            Transport.send(message);
//            System.out.println("Sent message successfully....");
//            return true;
//
//        } catch (MessagingException mex) {
//            mex.printStackTrace();
//        }


        return false;
    }

}
