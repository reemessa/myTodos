package com.issareem.mytodoapp.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.issareem.mytodoapp.entity.Todo;
import com.issareem.mytodoapp.entity.User;

/**
 * 
 * 
 * @author Reem Issa
 * @class_name TodoDAO.java
 * @class_description
 * @create_date Aug 27, 2023
 */
@Stateless
@LocalBean
public class TodoDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void save(Todo todo) {
		entityManager.persist(todo);
	}

	public void update(Todo todo) {
		entityManager.persist(todo);
	}

	public void delete(Todo todo) {
		entityManager.remove(todo);
	}

	public List<Todo> findByUser(User user) {
		TypedQuery<Todo> query = entityManager.createNamedQuery("Todo.findByUser", Todo.class);
		query.setParameter("user", user);
		return query.getResultList();
	}
}
