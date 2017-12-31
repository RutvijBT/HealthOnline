package javaBean;

import java.io.Serializable;

public class AnswerBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int question_id;
	private int doctor;
	private String answer;
	private String date;
	private String name;
	private int answer_id;
	private int user_id;
	private int like;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(int answer_id) {
		this.answer_id = answer_id;
	}
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public int getDoctor() {
		return doctor;
	}
	public void setDoctor(int doctor) {
		this.doctor = doctor;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	
}
