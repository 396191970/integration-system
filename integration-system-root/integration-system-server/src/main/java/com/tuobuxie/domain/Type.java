package com.tuobuxie.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Data
@ApiModel(value="类型")
public class Type implements Serializable{

	private static final long serialVersionUID = 1L;
    @ApiModelProperty("类型id")
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long typeId;
    @ApiModelProperty("类型名称")

	@Column(nullable = false)
	String typeName;
    @ApiModelProperty("积分值")

	@Column(nullable = false)
	int score;
    @ApiModelProperty("类型描述")

	String description;

	@Override
	public String toString() {
		return "Type [typeId=" + typeId + ", typeName=" + typeName + ", score=" + score + ", description=" + description
				+ "]";
	}


}
