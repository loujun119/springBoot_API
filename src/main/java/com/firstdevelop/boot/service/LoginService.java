package com.firstdevelop.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstdevelop.boot.mapper.AccountMapper;
import com.firstdevelop.boot.model.LoginInfo;
import com.firstdevelop.boot.model.Account;

@Service
public class LoginService {

	@Autowired
	private AccountMapper accountMapper;
	
	public String login(LoginInfo loginInfo) {
		String loginResult = "";
		Account userAccount = accountMapper.getAccountByName(loginInfo.getUsername());
		if (userAccount == null) {
			loginResult = "notFond";
		} else if (!loginInfo.getPassword().equals(userAccount.getPassword())) {
			loginResult = "failed password";
		} else {
			loginResult = "OK";
		}
		return loginResult;
	};
	
	public void addNewAccount(Account account) {
		accountMapper.addNewAccount(account);
	};

}
