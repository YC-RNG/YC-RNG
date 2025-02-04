package yc.rng.pet.bean;

import java.util.Date;

public class Pets implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer pid;
	private String pname;
	private Double price;
	private String image;
	private String pdesc;
	private Integer state;
	private Integer cid;
	private Date createtime;
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "Pets [pid=" + pid + ", pname=" + pname + ", price=" + price + ", image=" + image + ", pdesc=" + pdesc
				+ ", state=" + state + ", cid=" + cid + ", createtime=" + createtime + "]";
	}
	
	
	

}
