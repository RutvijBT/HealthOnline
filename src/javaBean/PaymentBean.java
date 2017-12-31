package javaBean;

import java.io.Serializable;

public class PaymentBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int userid,status;
	private String name,plan,duration;
	private float amount;
	private String date;
	private String transactionid;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getStatus() {
		return status;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getPlan() {
		return plan;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getDuration() {
		return duration;
	}
	
	
}
