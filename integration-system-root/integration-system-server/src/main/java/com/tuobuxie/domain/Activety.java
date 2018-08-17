package com.tuobuxie.domain;

import java.io.Serializable;
import java.util.Date;

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
@ApiModel(value="活动")
public class Activety implements Serializable{

	private static final long serialVersionUID = 1L;
    @ApiModelProperty("活动id")
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
    @ApiModelProperty("活动名称")

	@Column(nullable = false)
	String activetyName;

    @ApiModelProperty("活动描述")

	String description;

    @Column(nullable = false)
	Date createTime;


}
