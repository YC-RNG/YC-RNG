package com.yc.C83S3pet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.yc.C83S3pet.bean.Pets;

public interface PetsMapper {
	@Select("select * from pets order by pid limit 0,8")
	public List<Pets> SelectByPart();
	
	@Select("select * from pets")
	public List<Pets> SelectByAll();
	
	@Select("select * from pets where pid=#{pid}")
	public Pets SelectById(int pid);
	
	@Select("select * from pets where cid=#{cid}")
	public List<Pets> SelectByCid(int cid);
	
	@Select("select * from pets where pname=#(pname)")
	public List<Pets> SelectByPname(String pname);
	
}
