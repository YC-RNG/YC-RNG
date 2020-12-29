package yc.rng.pet.bean;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Orders implements java.io.Serializable { 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Integer oid;
	private Double total;
	private Date createtime;
	private String addr;
	private String phone;
	private Integer uid;
	
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", total=" + total + ", createtime=" + createtime + ", addr=" + addr + ", phone="
				+ phone + ", uid=" + uid + "]";
	}
	
	
	
	
}
