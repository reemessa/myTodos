package com.issareem.mytodoapp.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.issareem.mytodoapp.dao.TodoDAO;
import com.issareem.mytodoapp.entity.Todo;
import com.issareem.mytodoapp.entity.User;

/**
 * 
 * 
 * @author Reem Issa
 * @class_name TodoBean.java
 * @class_description
 * @create_date Aug 27, 2023
 */
@Stateless
@LocalBean
public class TodoBean {

	@EJB
	private TodoDAO todoDao;

	public void save(Todo todo) {
		todoDao.save(todo);
	}

	public void update(Todo todo) {
		todoDao.update(todo);
	}

	public void delete(Todo todo) {
		todoDao.delete(todo);
	}

	public List<Todo> findByUser(User user) {
		return todoDao.findByUser(user);
	}

}
