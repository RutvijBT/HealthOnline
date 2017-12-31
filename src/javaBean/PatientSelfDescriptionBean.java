package javaBean;

import java.io.Serializable;

public class PatientSelfDescriptionBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int user;
	private String description;
	private String date;
	
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
