package com.issareem.mytodoapp.enums;

/**
 * 
 * 
 * @author Reem Issa
 * @class_name TodoPriorityEnum.java
 * @class_description
 * @create_date Aug 27, 2023
 */
public enum TodoPriorityEnum {

	LOW("low"), NORMAL("normal"), HIGH("high");

	private String value;

	TodoPriorityEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
