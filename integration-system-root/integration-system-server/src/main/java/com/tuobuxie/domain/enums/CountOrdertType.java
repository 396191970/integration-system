package com.tuobuxie.domain.enums;

public enum CountOrdertType {

	scoreCount("1"),
	joinCount("1"),
	cancelCount("1"),
	launchCount("1"),
	plainCount("1"),
	showCount("1"),
	writeCount("1"),
	moveThingsCount("1"),
	buyCount("1"),
	pictureCount("1");

	String name;
	String value;
	CountOrdertType(String value)
	{
		this.value= value;
	}
	CountOrdertType(String name,String value)
	{
		this.name= name;
		this.value= value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
