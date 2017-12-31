package javaBean;

import java.io.Serializable;

public class MedicalHistoryBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String fileName;
	private String description;
	private String dateByPatient;
	private String dateOfUpload;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDateByPatient() {
		return dateByPatient;
	}
	public void setDateByPatient(String dateByPatient) {
		this.dateByPatient = dateByPatient;
	}
	public String getDateOfUpload() {
		return dateOfUpload;
	}
	public void setDateOfUpload(String dateOfUpload) {
		this.dateOfUpload = dateOfUpload;
	}
}
