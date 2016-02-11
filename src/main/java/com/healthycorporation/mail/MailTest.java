/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.healthycorporation.mail;

import java.util.Properties;
import javax.mail.Session;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;



/**
 *
 * @author wewezhu
 */
public class MailTest {
    
    public static void main(String[] args){
        SimpleEmail email = new SimpleEmail();
  //      MultiPartEmail email = new MultiPartEmail();
  //      HtmlEmail email = new HtmlEmail();
       /** Mail mail = new Mail(); 
        mail.setHost("smtp-mail.outlook.com");
        mail.setSender("healthyCorporation@outlook.com");
        mail.setReceiver("1284819@qq.com"); 
        mail.setUsername("HealthyCorporation");
        mail.setPassword("zhuwei8231");
        mail.setSubject("aaaaaaaaa"); 
        mail.setMessage("bbbbbbbbbbbbbbbbb");
        new MailUtil().send(mail); **/
        
        //email.setHostName("smtp.office365.com");
        //email.setHostName("smtp.outlook.com");
        
        
        //email.setSSLOnConnect(true);
        //email.setSslSmtpPort("587");
        //email.setSmtpPort(587);
        //email.setSSLCheckServerIdentity(true);
        //email.setStartTLSEnabled(true);
       
        javax.mail.Authenticator authenticator = new org.apache.commons.mail.DefaultAuthenticator("bailebao1982@126.com","zhuwei");
      
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.126.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "25"); 
        //props.put("mail.smtp.starttls.enable","true");
        
        Session session = Session.getDefaultInstance(props, authenticator); 
        email.setMailSession(session);
        //email.setAuthentication("healthyCorporation@outlook.com", "zhuwei8231");
        email.setCharset("UTF-8");
        try {
           email.setFrom("bailebao1982@126.com");
           email.addTo("1284819@qq.com");
           email.setSubject("测试邮件");
           email.setMsg("测试邮件测试邮件测试邮件");
           email.send();
           System.out.println("发送成功");
        }catch (EmailException e) { 
            e.printStackTrace(); 
        }
        
        
    }
}
