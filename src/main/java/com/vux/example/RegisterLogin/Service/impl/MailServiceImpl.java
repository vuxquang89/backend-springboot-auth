package com.vux.example.RegisterLogin.Service.impl;

import com.vux.example.RegisterLogin.Entity.UserEntity;

public interface MailServiceImpl {

	public boolean sendEmail(String password, UserEntity user);
}
