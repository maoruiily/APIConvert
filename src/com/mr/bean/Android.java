package com.mr.bean;

public class Android {

	private int Support = 1;
	private String MinVersion = "4.0";

	public Android() {
	}

	public Android(int support, String minVersion) {
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
