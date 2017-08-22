package com.mr.bean;

public class Para {

	private String ID;
	private String Name;
	private String Type;
	private String Required; // 1：必填 ， 0 ：不必填
	private String DefaultValue;
	private String Description;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getType() {
		if ("Bool".equalsIgnoreCase(Type)) {
			return "boolean";
		}
		if ("Node".equalsIgnoreCase(Type)) {
			return "object";
		}
		if ("Number".equalsIgnoreCase(Type)) {
			return "number";
		}
		if ("String".equalsIgnoreCase(Type)) {
			return "string";
		}
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getDefaultValue() {
		return DefaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		DefaultValue = defaultValue;
	}

	public String getRequired() {
		if ("0".equals(Required)) {
			return "否";
		}
		if ("1".equals(Required)) {
			return "是";
		}
		return Required;
	}

	public void setRequired(String required) {
		Required = required;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

}
