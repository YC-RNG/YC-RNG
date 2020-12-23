package com.yc.C83S3pet.web;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.yc.C83S3pet.bean.Comment;
import com.yc.C83S3pet.bean.Result;
import com.yc.C83S3pet.bean.User;
import com.yc.C83S3pet.biz.CommentBiz;
import com.yc.C83S3pet.dao.CommentMapper;


@RestController
public class CommentAction {

 	@Resource
	private CommentMapper cMapper;

 	@Resource
	private CommentBiz cBiz;

 	@PostMapping("comment")
	public Result comment(Comment comm) {
		comm.setBcname("八戒");
		cBiz.create(comm);
		return new Result(1, "回复成功", comm);
	}


 	@GetMapping("queryComm")
	public Result comment(int bid) {
		return new Result(1, "查询回复成功", cMapper.selectByBlog(bid));
	}

 }
