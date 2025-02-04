package com.yc.C83S3pet.bean;

public class Orderitem implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 
	private Integer itemid;
	private Integer count;
	private Double subtotal;
	private Integer pid;
	private Integer oid;
	public Integer getItemid() {
		return itemid;
	}
	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	@Override
	public String toString() {
		return "orderitem [itemid=" + itemid + ", count=" + count + ", subtotal=" + subtotal + ", pid=" + pid + ", oid="
				+ oid + ", getItemid()=" + getItemid() + ", getCount()=" + getCount() + ", getSubtotal()="
				+ getSubtotal() + ", getPid()=" + getPid() + ", getOid()=" + getOid() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
