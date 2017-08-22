package com.mr.bean;

import java.util.ArrayList;
import java.util.List;

public class Component {
	private String ID;
	private String IsContainer;
	private String Type;
	private String Name;
	private String Version;
	private String Description;
	private String Icon;

	private IOS ios;
	private Android android;
	private Html html;

	private List<Propertie> Properties;
	private List<Event> Events;
	private List<Methode> syncMethodes;
	private List<Methode> asyncMethodes;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getIsContainer() {
		return IsContainer;
	}

	public void setIsContainer(String isContainer) {
		IsContainer = isContainer;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getVersion() {
		return Version;
	}

	public void setVersion(String version) {
		Version = version;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getIcon() {
		return Icon;
	}

	public void setIcon(String icon) {
		Icon = icon;
	}

	public IOS getIos() {
		if (ios == null) {
			return new IOS(1, "7.0");
		}
		return ios;
	}

	public void setIos(IOS ios) {
		this.ios = ios;
	}

	public Android getAndroid() {
		if (android == null) {
			return new Android(1, "4.0");
		}
		return android;
	}

	public void setAndroid(Android android) {
		this.android = android;
	}

	public Html getHtml() {
		if (html == null) {
			return new Html(1, "5.0");
		}
		return html;
	}

	public void setHtml(Html html) {
		this.html = html;
	}

	public List<Propertie> getProperties() {
		if (Properties == null) {
			return new ArrayList<Propertie>();
		}
		return Properties;
	}

	public void setProperties(List<Propertie> properties) {
		Properties = properties;
	}

	public List<Event> getEvents() {
		if (Events == null) {
			return new ArrayList<Event>();
		}
		return Events;
	}

	public void setEvents(List<Event> events) {
		Events = events;
	}

	public List<Methode> getSyncMethodes() {
		if (syncMethodes == null) {
			return new ArrayList<Methode>();
		}
		return syncMethodes;
	}

	public void setSyncMethodes(List<Methode> syncMethodes) {
		this.syncMethodes = syncMethodes;
	}

	public List<Methode> getAsyncMethodes() {
		if (asyncMethodes == null) {
			return new ArrayList<Methode>();
		}
		return asyncMethodes;
	}

	public void setAsyncMethodes(List<Methode> asyncMethodes) {
		this.asyncMethodes = asyncMethodes;
	}

}
