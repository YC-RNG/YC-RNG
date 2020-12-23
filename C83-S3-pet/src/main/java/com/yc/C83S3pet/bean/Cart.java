package com.yc.C83S3pet.bean;

public class Cart implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer cartid;
	private Integer uid;
	private Integer pid;
	private Integer count;
	public Integer getCartid() {
		return cartid;
	}
	public void setCartid(Integer cartid) {
		this.cartid = cartid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "cart [cartid=" + cartid + ", uid=" + uid + ", pid=" + pid + ", count=" + count + ", getCartid()="
				+ getCartid() + ", getUid()=" + getUid() + ", getPid()=" + getPid() + ", getCount()=" + getCount()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	

}
