package com.yc.C83S3pet.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.C83S3pet.bean.Comment;
import com.yc.C83S3pet.dao.CommentMapper;



@Service
public class CommentBiz {
	@Resource
	private CommentMapper cMapper;
	public Comment create(Comment comm) {
		cMapper.insert(comm);
		return comm;
	}
}
