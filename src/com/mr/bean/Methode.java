package com.mr.bean;

import java.util.ArrayList;
import java.util.List;

public class Methode {

	private String ID;
	private String Name;
	private String Description;
	private String ReturnType;
	private String ReturnDesc;
	private List<Para> Paras;

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
		if (ReturnDesc == null || "".equals(ReturnDesc)) {
			return "无";
		}
		return ReturnDesc;
	}

	public void setReturnDesc(String returnDesc) {
		ReturnDesc = returnDesc;
	}

	public List<Para> getParas() {
		if (Paras == null) {
			return new ArrayList<Para>();
		}
		return Paras;
	}

	public void setParas(List<Para> paras) {
		Paras = paras;
	}

}
