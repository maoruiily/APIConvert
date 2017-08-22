package com.mr.bean;

public class IOS {

	private int Support = 1;
	private String MinVersion = "7.0";

	public IOS() {

	}

	public IOS(int support, String minVersion) {
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
