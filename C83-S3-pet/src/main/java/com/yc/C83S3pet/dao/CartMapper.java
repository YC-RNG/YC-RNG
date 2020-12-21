package com.yc.C83S3pet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yc.C83S3pet.bean.Cart;
import com.yc.C83S3pet.bean.Category;




public interface CartMapper {
	
	@Insert("insert into cart value(null,#{uid},#{pid},1)")
	@Options(useGeneratedKeys=true,keyColumn="id",keyProperty="id")
	public int insert( Cart c);
	
	@Update("update cart set count=count+1 where uid=#{uid} and pid=#{pid}")
	@Options(useGeneratedKeys=true,keyColumn="id",keyProperty="id")
	public int update( Cart c);
}
