package com.zs.framework.jibx.beans;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Account {
	
	private long id;
	private String name;
	private int age;
	private List<String> skills;
	
	//private Map<String,Object> prop = new HashMap<String,Object>();
	
	private Date birthday;
	
	private Car car;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
}
