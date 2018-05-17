package com.example.test01.domain;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import com.example.test01.controller.SqlTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@Table(name = "note")
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@Max(value = 50)
	private String title;
	
	@Max(value = 1000)
	private String note;
//	@JsonFormat(pattern = "yyyy-MM-dd")
//	@JsonDeserialize(using = SqlTimeDeserializer.class)
	@Column(name = "create_time")
	private Date createTime;
//	@JsonFormat(pattern = "yyyy-MM-dd")
//	@JsonDeserialize(using = SqlTimeDeserializer.class)
	@Column(name = "last_update_time")
	private Date lastUpadteTime;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastUpadteTime() {
		return lastUpadteTime;
	}

	public void setLastUpadteTime(Date lastUpadteTime) {
		this.lastUpadteTime = lastUpadteTime;
	}



}
