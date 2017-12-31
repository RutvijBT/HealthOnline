package javaBean;

import java.io.Serializable;

public class UserPlanBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int plan_id,status_id,period_id;
	private String plan,period,status,role_name;
	private String duration;
	private int amount;
	private int role;
	
	public int getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	public int getStatus_id() {
		return status_id;
	}
	public void setPeriod_id(int period_id) {
		this.period_id = period_id;
	}
	public int getPeriod_id() {
		return period_id;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getPeriod() {
		return period;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	
}
