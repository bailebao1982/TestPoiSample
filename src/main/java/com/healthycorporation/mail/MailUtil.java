/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.healthycorporation.mail;

//import org.apache.log4j.Logger;
import org.apache.commons.mail.HtmlEmail; 
import org.apache.commons.mail.EmailException; 
/**
 *
 * @author wewezhu
 */
public class MailUtil {
   // protected final Logger logger = Logger.getLogger(getClass());
    
    public boolean send(Mail mail) {
        HtmlEmail email = new HtmlEmail(); 
        
        try {
            email.setHostName(mail.getHost()); 
            email.setCharset(Mail.ENCODEING);
            email.addTo(mail.getReceiver());
            email.setFrom(mail.getSender(), mail.getName()); 
            email.setAuthentication(mail.getUsername(), mail.getPassword());
            email.setSubject(mail.getSubject());
            email.setMsg(mail.getMessage());
            email.send(); 
            
          //  if (logger.isDebugEnabled()) {  
          //       logger.debug(mail.getSender() + " 发送邮件到 " + mail.getReceiver());
           // }
            return true;
            
        }catch (EmailException e) { 
            e.printStackTrace();
            //logger.info(mail.getSender() + " 发送邮件到 " + mail.getReceiver() + " 失败");
            return false; 
            
        }
    }
    
}
