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
public class ScoreStatistics  implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long Id;

	@Column(nullable = false)
	String userName;

	@Column(nullable = false)
	Long userId;

	int scoreCount;

	int joinCount;
	int cancelCount;
	int launchCount;
	int plainCount;
	int showCount;
	int writeCount;
	int moveThingsCount;
	int buyCount;
	int pictureCount;

	@Column(nullable = false)
	Date updateTime;

}
