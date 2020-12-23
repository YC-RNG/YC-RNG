package com.yc.C83S3pet.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.yc.C83S3pet.dao.BlogMapper;
import com.yc.C83S3pet.dao.CateMapper;


@Controller
public class HotblogAction {
	
	@Resource
	private BlogMapper bmapper;
	@Resource
	private CateMapper cmapper;

	@GetMapping("hotblog")
	public ModelAndView hotblog(Model m,ModelAndView mav) {	
		mav.addObject("hblist", bmapper.SelectByAll());
		mav.addObject("clist", cmapper.SelectbyAll());
		mav.setViewName("hotblog");	
		return mav;
	}
	
	@GetMapping("singleblog")
	public ModelAndView singleblog(int bid,Model m,ModelAndView mav) {	
		mav.addObject("blog", bmapper.SelectById(bid));
		mav.addObject("clist", cmapper.SelectbyAll());
		
		mav.setViewName("singleblog");	
		return mav;
	}
}
