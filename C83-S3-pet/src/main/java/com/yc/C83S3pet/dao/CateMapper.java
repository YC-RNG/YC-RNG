package com.yc.C83S3pet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.yc.C83S3pet.bean.Category;
import com.yc.C83S3pet.bean.Pets;

public interface CateMapper {
	@Select("select * from category ")
	public List<Category> SelectbyAll();

}
