package yc.rng.pet.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Orderitem implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8") 
	private Integer itemid;
	private Integer count;
	private Double subtotal;
	private Integer pid;
	private Integer oid	;

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
		return "Orderitem [itemid=" + itemid + ", count=" + count + ", subtotal=" + subtotal + ", pid=" + pid + ", oid="
				+ oid + "]";
	}
	
	
}
