package com.mr.bean;

public class Html {

	private int Support = 1;
	private String MinVersion = "5.0";

	public Html() {
	}

	public Html(int support, String minVersion) {
		super();
		Support = support;
		MinVersion = minVersion;
	}

	public int getSupport() {
		return Support;
	}

	public void setSupport(int support) {
		Support = support;
	}

	public String getMinVersion() {
		return MinVersion;
	}

	public void setMinVersion(String minVersion) {
		MinVersion = minVersion;
	}

}
