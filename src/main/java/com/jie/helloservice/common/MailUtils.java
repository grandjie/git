package com.jie.helloservice.common;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class MailUtils {
    // 发送给谁，谁发送的，主题，邮件内容，发送的QQ（不包含@qq.com）,QQ邮箱授权码
//    public static void sendMailByQQ(String to, String from, String subject, String text, String user, String auth) {
//        boolean debug = false;
//
//        // create some properties and get the default Session
//        Properties props = new Properties();
//        props.put("mail.smtp.host", "smtp.qq.com");
//        props.put("mail.debug", debug);
//        props.put("mail.smtp.auth", true);
//        props.put("mail.smtp.port", "587");
//
//        Session session = Session.getInstance(props, null);
//        session.setDebug(debug);
//
//        try {
//            // create a message
//            MimeMessage msg = new MimeMessage(session);
//            msg.setFrom(new InternetAddress(from));
//            InternetAddress[] address = { new InternetAddress(to) };
//            /**
//             * 第一个参数： RecipientType.TO 代表收件人 RecipientType.CC 抄送
//             * RecipientType.BCC 暗送
//             * 比如A要给B发邮件，但是A觉得有必要给要让C也看看其内容，就在给B发邮件时，将邮件内容抄送给C，那么C也能看到其内容了，
//             * 但是B也能知道A给C抄送过该封邮件，而如果是暗送(密送)给C的话，那么B就不知道A给C发送过该封邮件。 第二个参数
//             * 收件人的地址，或者是一个Address[]，用来装抄送或者暗送人的名单。或者用来群发。可以是相同邮箱服务器的，也可以是不同的
//             *
//             */
//            msg.setRecipients(Message.RecipientType.TO, address);
//            msg.setSubject(subject);
//            msg.setSentDate(new Date());
//            // If the desired charset is known, you can use
//            // setText(text, charset)
//            msg.setText(text);
//
//            Transport.send(msg, user, auth);
//        } catch (Exception mex) {
//            mex.printStackTrace();
//        }
//    }
}
