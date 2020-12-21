package com.yc.C83S3pet.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.yc.C83S3pet.bean.Blog;
import com.yc.C83S3pet.dao.BlogMapper;


@Service
public class BlogBiz {
	@Resource
	private BlogMapper  bMapper;
	
	public int create(Blog b) {
		return bMapper.insert(b);
		
	}

}
