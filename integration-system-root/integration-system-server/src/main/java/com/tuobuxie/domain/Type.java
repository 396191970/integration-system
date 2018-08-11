package com.tuobuxie.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Type implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long typeId;

	@Column(nullable = false)
	String typeName;

	@Column(nullable = false)
	int score;

	String description;

	@Override
	public String toString() {
		return "Type [typeId=" + typeId + ", typeName=" + typeName + ", score=" + score + ", description=" + description
				+ "]";
	}


}
