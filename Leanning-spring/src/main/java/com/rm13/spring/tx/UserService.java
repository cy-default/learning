package com.rm13.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("txUserService")
public class UserService {
	
	@Autowired
	private UserDao userDao;

	@Transactional(rollbackFor = Exception.class)
	public void insertUser(){
		userDao.insert();
		//otherDao.other();xxx
		System.out.println("≤Â»ÎÕÍ≥…...");
		int i = 10/0;
	}

}
