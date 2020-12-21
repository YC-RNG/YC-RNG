package com.yc.C83S3pet.web;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.yc.C83S3pet.bean.Blog;
import com.yc.C83S3pet.biz.BlogBiz;
import com.yc.C83S3pet.dao.BlogMapper;
import com.yc.C83S3pet.dao.PetsMapper;
import com.yc.C83S3pet.util.Utils;


@RestController
public class MyblogAction {
	@Resource
	private BlogBiz bbiz;

	@Resource
	private BlogMapper bpper;

	@GetMapping("myblog")
	public ModelAndView myblog(ModelAndView mav) {
		mav.setViewName("myblog");
		return mav;
	}
	
	@PostMapping("hotblog")
	public ModelAndView addblog(@Valid Blog b, Errors errors, ModelAndView mav) {
		// ModelAndView = Model + View
		if (errors.hasErrors()) {
			mav.addObject("errors", Utils.asMap(errors));
			mav.addObject("blog", b);
			mav.setViewName("myblog");
		} else {
			// 作者的名字写入文章实体 ==> loginUser
			b.setUid("1");;
			bbiz.create(b);
			// a.id ==> 有值 ==> 数据库的自增列 ==> MyBatis ==> @Options
			mav.setViewName("redirect:hotblog"); // 未完待续 ..
																	// 展示新添加的文章
		}
		return mav;
	}
}
