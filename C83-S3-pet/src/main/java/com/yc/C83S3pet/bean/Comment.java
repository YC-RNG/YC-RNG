package com.yc.C83S3pet.bean;

import java.sql.Timestamp;

public class Comment implements java.io.Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer bcid;
	private String bcname;
	private String bcdesc;
	private Timestamp createtime;
	private Integer bid;
	private String name;
	
	private Pets pets;
	private User user;
	
	
	public Pets getPets() {
		return pets;
	}
	public void setPets(Pets pets) {
		this.pets = pets;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getBcid() {
		return bcid;
	}
	public void setBcid(Integer bcid) {
		this.bcid = bcid;
	}
	public String getBcname() {
		return bcname;
	}
	public void setBcname(String bcname) {
		this.bcname = bcname;
	}
	public String getBcdesc() {
		return bcdesc;
	}
	public void setBcdesc(String bcdesc) {
		this.bcdesc = bcdesc;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Comment [bcid=" + bcid + ", bcname=" + bcname + ", bcdesc=" + bcdesc + ", createtime=" + createtime
				+ ", bid=" + bid + ", name=" + name + ", pets=" + pets + ", user=" + user + ", getPets()=" + getPets()
				+ ", getUser()=" + getUser() + ", getBcid()=" + getBcid() + ", getBcname()=" + getBcname()
				+ ", getBcdesc()=" + getBcdesc() + ", getCreatetime()=" + getCreatetime() + ", getBid()=" + getBid()
				+ ", getName()=" + getName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
}
