package per.mnxc.email.utils;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @BelongsProject: email-server
 * @BelongsPackage: per.mnxc.email.utils
 * @Author: jiangao
 * @CreateTime: 2024-02-27  16:19
 * @Description: 邮箱发送工具类
 * @Version: 1.0
 */
@Component
public class SendEmailUtil {
    @Resource
    private JavaMailSender javaMailSender;
    private final String  TEXT="sdfadfgdfasddggga";
    public void sendSimpleEmail(String to, String subject, String content) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        // 设置发件人
        mailMessage.setFrom("2113168433@qq.com");
        // 设置邮件主题
        mailMessage.setSubject(subject);
        // 邮件内容
        mailMessage.setText(content);
        // 收件人
        mailMessage.setTo(to);
        // 发送邮件
        javaMailSender.send(mailMessage);
    }
    
    public void sendSimpleEmail(String to, String subject, String content, String filePath) throws MessagingException {
        //创建复杂邮件对象
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        //发送复杂邮件的工具类
        //true - 能够添加附件
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true,"utf-8");
        helper.setFrom("2113168433@qq.com");
        helper.setSubject(subject);
        //true - 复杂邮件能够再内容中编写html标签 - 会解析
        helper.setText(TEXT+"<h1>祝您六一快乐啊!!!</h1><img src='图片地址(此图片不存在)http://dfs.java.zt.com/group1/M00/00/B9/rBE3kWD_fEuALou2AAB4rV4bI7c231.jpg' ><a href='http://localhost:8080/birthday'>点击该链接查看贺卡</a>",true);
        //添加附件图片名字+地址格式如下
        helper.addAttachment("p7.jpg",new File("C:\\Users\\Pictures\\photos\\p7.jpg"));
        helper.addAttachment("g1.gif", new File("C:\\Users\\Pictures\\g1.gif"));
        helper.setTo(to);
        javaMailSender.send(mimeMessage);
    }
}
