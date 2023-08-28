package com.issareem.mytodoapp.enums;

/**
 * 
 * 
 * @author Reem Issa
 * @class_name TodoStatusEnum.java
 * @class_description
 * @create_date Aug 27, 2023
 */
public enum TodoStatusEnum {

	PENDING("Pending", "لم يبدأ بها بعد"), IN_PROCESS("In process", "قيد العمل"), DONE("Done", "تمت");

	private String value;

	private String arValue;

	TodoStatusEnum(String value, String arValue) {
		this.value = value;
		this.arValue = arValue;
	}

	public String getValue() {
		return value;
	}

	public String getArValue() {
		return arValue;
	}

}
