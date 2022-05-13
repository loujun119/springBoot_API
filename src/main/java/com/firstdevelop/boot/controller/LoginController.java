package com.firstdevelop.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstdevelop.boot.model.Account;
import com.firstdevelop.boot.model.LoginInfo;
import com.firstdevelop.boot.service.LoginService;

//@CrossOrigin(origins="http://localhost:3000/")
@RestController
@RequestMapping("/api/login")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@PostMapping
	private ResponseEntity<String> index(@RequestBody LoginInfo loginInfo){
		String loginResult = loginService.login(loginInfo);
		if (loginResult == "notFond") {
			return new ResponseEntity<String>("notFond", HttpStatus.NOT_FOUND);
		} else if (loginResult == "failed password") {
			return new ResponseEntity<String>("bad password", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Login OK", HttpStatus.OK);
	}
	
	@PostMapping("/addNew")
	private ResponseEntity<String> addNew(@RequestBody Account account){
		try {
			loginService.addNewAccount(account);
		} catch (Exception e) {
			return new ResponseEntity<String>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>("Add New Account OK", HttpStatus.OK);
	}

}
