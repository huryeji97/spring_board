package edu.spring.ex02.domain;

import java.util.Date;

public class BoardVO {
	private int boardSeq;
	private String title;
	private String content;
	private String userId;
	private Date regDate;
	
	public BoardVO() { }
	
	
	public BoardVO(int boardSeq, String title, String content, String userId, Date regDate) {
		super();
		this.boardSeq = boardSeq;
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.regDate = regDate;
	}

	// getter setter
	public int getBoardSeq() {
		return boardSeq;
	}

	public void setBoardSeq(int boardSeq) {
		this.boardSeq = boardSeq;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	// toString()
	@Override
	public String toString() {
		return "BoardVO [boardSeq=" + boardSeq + ", title=" + title + ", content=" + content + ", userId=" + userId
				+ ", regDate=" + regDate + "]";
	}
	
}
