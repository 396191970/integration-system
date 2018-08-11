package com.tuobuxie.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ScoreChangeList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long Id;

	@Column(nullable = false)
	String userName;

	private Long typeId;

	String typeName;

	int score;

	@Column(nullable = false)
	Date createTime;

	@Column(nullable = false)
	String activityName;

	@Column(nullable = false)
	Long activityId;

	String remark;


	@Column(nullable = false)
	Date updateTime;

}
