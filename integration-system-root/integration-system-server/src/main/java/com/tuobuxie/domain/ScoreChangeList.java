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
public class ScoreChangeList implements Serializable {
	private static final long serialVersionUID = 1L;


	public ScoreChangeList(ScoreChangeList scoreChangeList, String userName,  String typeName, String activityName) {
		this.id = scoreChangeList.getId();
		this.userName = userName;
		this.userId = scoreChangeList.getUserId();
		this.typeId = scoreChangeList.getTypeId();
		this.typeName = typeName;
		this.score = scoreChangeList.getScore();
		this.createTime = scoreChangeList.getCreateTime();
		this.activityName = activityName;
		this.activityId = scoreChangeList.getActivityId();
		this.remark = scoreChangeList.getRemark();
		this.updateTime = scoreChangeList.getUpdateTime();
	}


	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	Long id;

	@Transient
	String userName;

	Long userId;

	private Long typeId;

	@Transient
	String typeName;

	Long score;

	@Column(nullable = false)
	Date createTime;

	@Transient
	String activityName;

	@Column(nullable = false)
	Long activityId;

	String remark;


	@Column(nullable = false)
	Date updateTime;

}
