package com.example.test01.service;

import com.example.test01.domain.User;

public interface UserService {

	User findUserById(long id);
	User findUserByEmail(String email);

}
