package com.example.test01.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.example.test01.domain.User;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User findById(long id) {
		return entityManager.find(User.class, new Long(id));
	}

	@Override
	public User findUserByEmail(String email) {
		return (User)entityManager.createQuery("Select u from User u where u.email = :email ")
				.setParameter("email", email).getSingleResult();
	}

}
