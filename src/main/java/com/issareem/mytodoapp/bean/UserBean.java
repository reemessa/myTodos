package com.issareem.mytodoapp.bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.issareem.mytodoapp.dao.UserDAO;
import com.issareem.mytodoapp.entity.User;

/**
 * 
 * 
 * @author Reem Issa
 * @class_name UserBean.java
 * @class_description
 * @create_date Aug 27, 2023
 */
@Stateless
@LocalBean
public class UserBean {

	private UserDAO userDao;

	public void save(User user) {
		userDao.save(user);
	}

	public Boolean validate(String user, String password) {

		userDao = new UserDAO();
		return userDao.validateUser(user, password);

	}

}
