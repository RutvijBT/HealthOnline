package javaBean;

import java.util.Date;

public class HealthGuidelineBean {
private int healthguideline_id,doctorid,category_id;
private String guideline,category,doctor;
private Date date;
public void setHealthguideline_id(int healthguideline_id) {
	this.healthguideline_id = healthguideline_id;
}
public int getHealthguideline_id() {
	return healthguideline_id;
}
public void setDoctorid(int doctorid) {
	this.doctorid = doctorid;
}
public int getDoctorid() {
	return doctorid;
}
public void setDate(Date date) {
	this.date = date;
}
public Date getDate() {
	return date;
}
public void setGuideline(String guideline) {
	this.guideline = guideline;
}
public String getGuideline() {
	return guideline;
}
public void setCategory(String category) {
	this.category = category;
}
public String getCategory() {
	return category;
}
public void setCategory_id(int category_id) {
	this.category_id = category_id;
}
public int getCategory_id() {
	return category_id;
}
public void setDoctor(String doctor) {
	this.doctor = doctor;
}
public String getDoctor() {
	return doctor;
}

}
