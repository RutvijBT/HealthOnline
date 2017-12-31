package javaBean;

import java.io.Serializable;
import java.util.Date;

public class PrescriptionBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private int patient;
	private int doctor;
	private String name;
	private String sympton;
	private String diagnosis,comment;
	private String date;
	private String medicine;
	private String dosage;
	private Date dat;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPatient() {
		return patient;
	}
	public void setPatient(int patient) {
		this.patient = patient;
	}
	public int getDoctor() {
		return doctor;
	}
	public void setDoctor(int doctor) {
		this.doctor = doctor;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSympton() {
		return sympton;
	}
	public void setSympton(String sympton) {
		this.sympton = sympton;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMedicine() {
		return medicine;
	}
	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public Date getDat() {
		return dat;
	}
	public void setDat(Date dat) {
		this.dat = dat;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getComment() {
		return comment;
	}
	
	
}
