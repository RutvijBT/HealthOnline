package javaBean;

import java.io.Serializable;

public class AdminInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String news,reported_ans,que;
	private int newsId,ans_id;

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public String getNews() {
		return news;
	}

	public void setNews(String news) {
		this.news = news;
	}

	public void setReported_ans(String reported_ans) {
		this.reported_ans = reported_ans;
	}

	public String getReported_ans() {
		return reported_ans;
	}

	public void setQue(String que) {
		this.que = que;
	}

	public String getQue() {
		return que;
	}

	public void setAns_id(int ans_id) {
		this.ans_id = ans_id;
	}

	public int getAns_id() {
		return ans_id;
	}
	
	
}
