package com.issareem.mytodoapp.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.issareem.mytodoapp.entity.User;

/**
 * 
 * 
 * @author Reem Issa
 * @class_name LoginDAO.java
 * @class_description
 * @create_date Aug 27, 2023
 */
@LocalBean
@Stateless
public class UserDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void save(User user) {
		entityManager.persist(user);
	}

	public User findById(Long userId) {
		return entityManager.find(User.class, userId);
	}

	public User findByUserName(String userName) {
		TypedQuery<User> query = entityManager.createNamedQuery("User.findByUserName", User.class);
		query.setParameter("userName", userName);
		return query.getSingleResult();
	}

	public Boolean validateUser(String userName, String password) {
		TypedQuery<Long> query = entityManager.createNamedQuery("User.validateUser", Long.class);
		query.setParameter("userName", userName);
		query.setParameter("password", password);

		return query.getSingleResult() > 0;
	}
}