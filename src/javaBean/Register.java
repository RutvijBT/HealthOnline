package javaBean;

import java.io.Serializable;

public class Register implements Serializable {
	
	private static final long serialVersionUID = 3006787373635248162L;
	private int id,did,role,userid;
	private String name,notification;
	private String address;
	private String city;
	private String state;
	private String mobile;
	private String email;
	private String gender;
	private String bdate,regDate;
	private String bloodGroup;
	private String password;
	private String category,catname;
	private String certificateNumber;
	private String certificateFile;
	private String authority;
	private String degree;
	private String RegPlanName;
	private String RegPlanDuration;
	private String RegPlanAmount;
	private String schedule,RegExpDate;
	public String getRegPlanName() {
		return RegPlanName;
	}
	public void setRegPlanName(String regPlanName) {
		RegPlanName = regPlanName;
	}
	public String getRegPlanDuration() {
		return RegPlanDuration;
	}
	public void setRegPlanDuration(String regPlanDuration) {
		RegPlanDuration = regPlanDuration;
	}
	public String getRegPlanAmount() {
		return RegPlanAmount;
	}
	public void setRegPlanAmount(String regPlanAmount) {
		RegPlanAmount = regPlanAmount;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getCertificateNumber() {
		return certificateNumber;
	}
	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}
	public String getCertificateFile() {
		return certificateFile;
	}
	public void setCertificateFile(String certificateFile) {
		this.certificateFile = certificateFile;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public void setCatname(String catname) {
		this.catname = catname;
	}
	public String getCatname() {
		return catname;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getDegree() {
		return degree;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public int getDid() {
		return did;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public int getRole() {
		return role;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setNotification(String notification) {
		this.notification = notification;
	}
	public String getNotification() {
		return notification;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getUserid() {
		return userid;
	}
	public void setRegExpDate(String regExpDate) {
		RegExpDate = regExpDate;
	}
	public String getRegExpDate() {
		return RegExpDate;
	}
}
