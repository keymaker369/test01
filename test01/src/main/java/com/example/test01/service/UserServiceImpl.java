package com.example.test01.service;

import org.springframework.stereotype.Service;

import com.example.test01.dao.UserDao;
import com.example.test01.domain.User;

@Service
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	@Override
	public User findNoteById(long id) {
		return userDao.findById(id);
	}

}
