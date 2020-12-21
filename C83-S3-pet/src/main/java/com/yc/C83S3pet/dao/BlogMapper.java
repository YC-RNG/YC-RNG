package com.yc.C83S3pet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.yc.C83S3pet.bean.Blog;
import com.yc.C83S3pet.bean.Pets;

public interface BlogMapper {
	@Select("select * from Blog")
	public List<Blog> SelectByAll();
	

	@Select("select * from blog where bid=#{bid}")
	public Blog SelectById(int bid);
	
	@Insert("insert into blog value(#{bid},#{bname},null,#{title},#{bdesc},now(),#{uid},#{commentcount})")
	@Options(useGeneratedKeys=true,keyColumn="bid",keyProperty="bid")
	public int insert(Blog b);
	
	
}
