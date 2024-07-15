package com.tm.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class IPurchaeImplService implements IPurcahseMgmtService {
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public String shoping(String[] items, float[] prices, String fromMail, String[] toMail) throws Exception {
		// write the business logic
		float billAmt=0.0f;
		for(float p:prices) {
			billAmt=billAmt+p;
		}
		
		String msg=Arrays.toString(items)+" Items are purchased with the prices"+Arrays.toString(prices)+" having billAmt "+billAmt;
		
		// send mail operations
		String statusMsg=sendMailWithAttacthment(msg, fromMail, toMail);
		
		return msg+"......."+statusMsg;
	}
	
	private String sendMailWithAttacthment(String msg, String fromMail, String[] toMail) throws Exception {
		
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message,true);
		helper.setFrom(fromMail);
		helper.setCc(toMail);
		helper.setSentDate(new Date());
		helper.setSubject("Open it to know it!");
		helper.setText(msg);
		helper.addAttachment("tam.jpg", new ClassPathResource("tam.jpg"));
		javaMailSender.send(message);
		return "mail has been send";
	}

}
