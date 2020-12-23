package com.yc.C83S3pet.bean;

import java.sql.Timestamp;

import javax.validation.constraints.NotEmpty;

public class Blog implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   
	private Integer bid;
	@NotEmpty
	private String bname;
	private String image;
	@NotEmpty
	private String title;
	@NotEmpty
	private String bdesc;
	private Timestamp createtime;
	private Integer commentcount;
	private String uid;
	
	public Integer getCommentcount() {
		return commentcount;
	}
	public void setCommentcount(Integer commentcount) {
		this.commentcount = commentcount;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBdesc() {
		return bdesc;
	}
	public void setBdesc(String bdesc) {
		this.bdesc = bdesc;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "Blog [bid=" + bid + ", bname=" + bname + ", image=" + image + ", title=" + title + ", bdesc=" + bdesc
				+ ", createtime=" + createtime + ", commentcount=" + commentcount + ", uid=" + uid
				+ ", getCommentcount()=" + getCommentcount() + ", getBid()=" + getBid() + ", getBname()=" + getBname()
				+ ", getImage()=" + getImage() + ", getTitle()=" + getTitle() + ", getBdesc()=" + getBdesc()
				+ ", getCreatetime()=" + getCreatetime() + ", getUid()=" + getUid() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
