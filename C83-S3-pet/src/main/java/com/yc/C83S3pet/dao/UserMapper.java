package com.yc.C83S3pet.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.yc.C83S3pet.bean.User;



public interface UserMapper {
	@Insert("insert into user values (null,#{username},#{account},#{password},#{phone},#{sex},#{state},now(),#{addr})")
	public int insert(User user);
	
	@Select("select * from user where account=#{account} and password=#{password}")
	public User selectByLogin(User user);
	
	@Select("select count(*) from user where account=#{account}")
	public int countByAccount(String account);
}
