package com.issareem.mytodoapp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import com.issareem.mytodoapp.bean.TodoBean;
import com.issareem.mytodoapp.entity.Todo;
import com.issareem.mytodoapp.entity.User;

/**
 * 
 * 
 * @author Reem Issa
 * @class_name TodosController.java
 * @class_description
 * @create_date Aug 27, 2023
 */
@ManagedBean(name = "todosController")
@ViewScoped
public class TodosController {

	private List<Todo> todoList;

	@EJB
	private TodoBean todoBean;

	@PostConstruct
	public void init() {

		fillTodoListWithTestData();

		// User user = new User();
		// todoList = todoBean.findByUser(user);

	}

	public void fillTodoListWithTestData() {
		
		User user = new User();
		user.setId(1l);
		user.setUserName("reissa");
		user.setFullName("Reem Issa");
		
		
		User user2 = new User();
		user2.setId(2l);
		user2.setUserName("bnasser");
		user2.setFullName("Bader Nasser");

		todoList = new ArrayList<Todo>();

		Todo todo1 = new Todo();
		todo1.setName("Sample Todo 1");
		todo1.setDescription("This is the description for sample todo 1.");
		todo1.setCreationDate(new Date());
		todo1.setDeadline(new Date(System.currentTimeMillis() + 86400000)); 
		todo1.setUser(user2);

		Todo todo2 = new Todo();
		todo2.setName("Sample Todo 2");
		todo2.setDescription("This is the description for sample todo 2.");
		todo2.setCreationDate(new Date());
		todo2.setDeadline(new Date(System.currentTimeMillis() + 2 * 86400000)); 
		todo2.setUser(user);

		todoList.add(todo1);
		todoList.add(todo2);
	}

	public void onRowEdit(RowEditEvent<Todo> event) {
		FacesMessage msg = new FacesMessage("Product Edited", String.valueOf(event.getObject().getId()));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent<Todo> event) {
		FacesMessage msg = new FacesMessage("Edit Cancelled", String.valueOf(event.getObject().getId()));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public List<Todo> getTodoList() {
		return todoList;
	}

	public void setTodoList(List<Todo> todoList) {
		this.todoList = todoList;
	}
}
