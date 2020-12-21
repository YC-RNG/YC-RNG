package com.yc.C83S3pet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.yc.C83S3pet.bean.Comment;


public interface CommentMapper {
	@Insert("insert into comment values(null,#{bid},#{bcdesc},#{bcname},now(),#{name})")
	public int insert(Comment comm);
	@Select("select * from comment where bid=#{bid}")
	public List<Comment>selectByBlog(int bid);

}
