package javaBean;

import java.io.Serializable;

public class AppointmentBean implements Serializable {
	private int appointment;
	private int patient;
	private int doctor;
	private int status;
	private int role;
	private String name;
	private String date;
	private String time;
	private String comment;
	private String statusname;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAppointment() {
		return appointment;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public void setAppointment(int appointment) {
		this.appointment = appointment;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public void setStatusname(String statusname) {
		this.statusname = statusname;
	}
	public String getStatusname() {
		return statusname;
	}
	
}
