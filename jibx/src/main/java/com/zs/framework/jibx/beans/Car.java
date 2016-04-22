package com.zs.framework.jibx.beans;

public class Car {
	
	private long id;
	private String carname;
	//private Enum color;
	private boolean isPass;
	private Double amount;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCarname() {
		return carname;
	}
	public void setCarname(String carname) {
		this.carname = carname;
	}
	/*public Enum getColor() {
		return color;
	}
	public void setColor(Enum color) {
		this.color = color;
	}*/
	public boolean isPass() {
		return isPass;
	}
	public void setPass(boolean isPass) {
		this.isPass = isPass;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
