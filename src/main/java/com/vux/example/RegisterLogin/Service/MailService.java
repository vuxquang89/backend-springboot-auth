package com.vux.example.RegisterLogin.Service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.vux.example.RegisterLogin.Entity.UserEntity;
import com.vux.example.RegisterLogin.Service.impl.MailServiceImpl;

@Service
public class MailService implements MailServiceImpl {
	
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public boolean sendEmail(String password, UserEntity user){
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		String mailSubject = "Thông tin mật khẩu mới";
//		String mailContent = "<p><b>Sender Name :</b>Support PKT SCTV</p>";
		String mailContent = "<p>Hi <b>"+ user.getFullname() +"</b>!<br></p>";
		mailContent += "<p>Mật khẩu mới của bạn là: <b>"+password+"</b></p>";
		
		try {
			helper.setFrom("application.cmart@gmail.com", "Support PKT SCTV");
			helper.setTo(user.getEmail());
			helper.setSubject(mailSubject);
			helper.setText(mailContent, true);
			mailSender.send(message);
			return true;
		} catch (UnsupportedEncodingException | MessagingException e) {
		
			System.out.println(e.toString());
			return false;
		}
	}

}
