package com.firstdevelop.boot.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.firstdevelop.boot.model.Account;

@Mapper
public interface AccountMapper {
	
	public Account getAccountByName(String name);
	
	public void addNewAccount(Account account);

}
