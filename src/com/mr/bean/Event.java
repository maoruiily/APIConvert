package com.mr.bean;

public class Event {

	private String ID;
	private String Description;
	private String ReturnType;
	private String ReturnDesc;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getReturnType() {
		if (ReturnType == null || "".equals(ReturnType)) {
			return "无";
		}

		if ("Bool".equalsIgnoreCase(ReturnType)) {
			return "boolean";
		}
		if ("Node".equalsIgnoreCase(ReturnType)) {
			return "object";
		}
		if ("Number".equalsIgnoreCase(ReturnType)) {
			return "number";
		}
		if ("String".equalsIgnoreCase(ReturnType)) {
			return "string";
		}
		return ReturnType;
	}

	public void setReturnType(String returnType) {
		ReturnType = returnType;
	}

	public String getReturnDesc() {
		return ReturnDesc;
	}

	public void setReturnDesc(String returnDesc) {
		ReturnDesc = returnDesc;
	}

}
