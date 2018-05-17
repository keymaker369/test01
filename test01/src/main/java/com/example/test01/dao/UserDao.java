package com.example.test01.dao;

import com.example.test01.domain.User;

public interface UserDao {

	User findById(long id);

	User findUserByEmail(String email);

}
