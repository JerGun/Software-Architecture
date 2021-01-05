package com.sa.dao;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;

@Entity (name="forum")
public class Forum {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name="id")
	private Integer forumId;
	
	@Column (name="detail")
	private String forumDetail;
	
	@Column (name="author")
	private String forumAuthor;
	
	@Column (name="love")
	private Integer forumLove;
	
	@CreatedDate
	@Column (name="post_date", insertable = false, updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private LocalDateTime forumPostDate;

	public Integer getForumId() {
		return forumId;
	}

	public void setForumId(Integer forumId) {
		this.forumId = forumId;
	}

	public String getForumDetail() {
		return forumDetail;
	}

	public void setForumDetail(String forumDetail) {
		this.forumDetail = forumDetail;
	}

	public String getForumAuthor() {
		return forumAuthor;
	}

	public void setForumAuthor(String forumAuthor) {
		this.forumAuthor = forumAuthor;
	}

	public Integer getForumLove() {
		return forumLove;
	}

	public void setForumLove(Integer forumLove) {
		this.forumLove = forumLove;
	}

	public LocalDateTime getForumPostDate() {
		return forumPostDate;
	}

	public void setForumPostDate(LocalDateTime forumPostDate) {
		this.forumPostDate = forumPostDate;
	}
}
