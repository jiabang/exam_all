package com.exam.entity;

public class userEntity extends idEntity {
	private String name ;
	private String pass;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "userEntity [name=" + name + ", pass=" + pass + ", id=" + id + "]";
	}
	
	

}
