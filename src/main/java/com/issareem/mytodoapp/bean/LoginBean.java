package com.issareem.mytodoapp.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;


import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.issareem.mytodoapp.dao.LoginDAO;
import com.issareem.mytodoapp.util.MessageUtils;
import com.issareem.mytodoapp.util.SessionUtils;

/**
 * 
 * 
 * @author Reem Issa
 * @class_name LoginBean.java
 * @class_description
 * @create_date Aug 27, 2023
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1094801825228386363L;

	private String password;
	private String msg;
	private String user;

	public String validateUsernamePassword() {
		boolean valid = LoginDAO.validate(user, password);
		if (valid) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", user);
			return "welcome";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					MessageUtils.getMessage("incorrectUserOrPassword"), null));
			return "login";
		}
	}

	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
