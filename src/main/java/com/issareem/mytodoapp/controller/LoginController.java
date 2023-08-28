package com.issareem.mytodoapp.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.issareem.mytodoapp.bean.UserBean;
import com.issareem.mytodoapp.util.MessageUtils;
import com.issareem.mytodoapp.util.SessionUtils;
import com.issareem.mytodoapp.util.UserUtil;

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
public class LoginController implements Serializable {

	@EJB
	private UserBean userBean;

	private static final long serialVersionUID = 1L;

	private UserUtil loggedInUser;

	@PostConstruct
	public void init() {
		loggedInUser = new UserUtil();
		userBean = new UserBean();
	}

	public String validateUsernamePassword() {

		boolean valid = true ; //userBean.validate(loggedInUser.getUserName(), loggedInUser.getPassword());
		if (valid) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", loggedInUser.getUserName());
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

	public UserUtil getLoggedInUser() {
		return loggedInUser;
	}

	public com.issareem.mytodoapp.bean.UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(com.issareem.mytodoapp.bean.UserBean userBean) {
		this.userBean = userBean;
	}

}
