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
public class ScoreUserTypeCount implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long Id;

	@Transient
	String userName;

	Long userId;

	Long typeId;

	@Transient
	String typeName;

	Long count;


	@Column(nullable = false)
	Date updateTime;


	public ScoreUserTypeCount(String userName, Long userId, Long typeId, String typeName, Long count) {

		this.userName = userName;
		this.userId = userId;
		this.typeId = typeId;
		this.typeName = typeName;
		this.count = count;
		this.updateTime = new Date();

	}


}
