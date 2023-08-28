package com.issareem.mytodoapp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.issareem.mytodoapp.enums.TodoPriorityEnum;
import com.issareem.mytodoapp.enums.TodoStatusEnum;

/**
 * 
 * 
 * @author Reem Issa
 * @class_name Todo.java
 * @class_description
 * @create_date Aug 27, 2023
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "Todo.findByUser", query = "SELECT u FROM Todo u WHERE u.user = :user") })
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "creation_date")
	@Temporal(TemporalType.DATE)
	private Date creationDate;

	@Column(name = "deadline")
	@Temporal(TemporalType.DATE)
	private Date deadline;

	@ManyToOne
	@JoinColumn(name = "id_user_fk", referencedColumnName = "ID")
	private User user;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "update_date")
	private Date updateDate;

	private TodoStatusEnum status;

	private TodoPriorityEnum priority;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public TodoStatusEnum getStatus() {
		return status;
	}

	public void setStatus(TodoStatusEnum status) {
		this.status = status;
	}

	public TodoPriorityEnum getPriority() {
		return priority;
	}

	public void setPriority(TodoPriorityEnum priority) {
		this.priority = priority;
	}
}
