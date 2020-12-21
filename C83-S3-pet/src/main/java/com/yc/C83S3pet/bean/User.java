package com.yc.C83S3pet.bean;

import java.sql.Timestamp;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer uid;
	@NotEmpty(message="昵称不能为空!")
	@Length(min=4,max=20,message="昵称必须是4~20位")
	private String username;
	@NotEmpty(message="账号不能为空!")
	private String account;
	@NotEmpty(message="密码不能为空!")
	@Length(min=4,max=20,message="密码必须是4~20位")
	private String password;
	@NotEmpty(message="电话不能为空!")
	private String phone;
	private String sex;
	private Integer state;
	private Timestamp createtime;
	@NotEmpty(message="地址不能为空!")
	private String addr;
	
	
	public Integer getUid() {
		return uid;
	}


	public void setUid(Integer uid) {
		this.uid = uid;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public Integer getState() {
		return state;
	}


	public void setState(Integer state) {
		this.state = state;
	}


	public Timestamp getCreatetime() {
		return createtime;
	}


	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}


	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}


	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", account=" + account + ", password=" + password
				+ ", phone=" + phone + ", sex=" + sex + ", state=" + state + ", createtime=" + createtime + ", addr="
				+ addr + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	
}