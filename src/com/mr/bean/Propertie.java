package com.mr.bean;

public class Propertie {

	private String ID;
	private String Name;
	private String Type;
	private String DefaultValue;
	private String EditType; // 1：可以编辑 ， 0 ：设计器只读
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

	public String getEditType() {
		return EditType;
	}

	public void setEditType(String editType) {
		EditType = editType;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

}
