package com.tuobuxie.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.Transient;

import lombok.Data;

@Entity
@Data
public class ScoreUserCount implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long Id;

	@Transient
	String userName;

	Long userId;

	Long sum;

	@Column(nullable = false)
	Date updateTime;

	public ScoreUserCount( String userName, Long userId, Long sum) {
		this.userName = userName;
		this.userId = userId;
		this.sum = sum;
		this.updateTime = new Date();
	}



}
