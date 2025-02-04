package com.yc.C83S3pet.web;

import javax.annotation.Resource;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.yc.C83S3pet.biz.CartBiz;
import com.yc.C83S3pet.dao.CateMapper;
import com.yc.C83S3pet.dao.PetsMapper;


@Controller
public class ShopAction {
	@Resource
	private PetsMapper pmapper;
	@Resource
	private CateMapper cmapper;
	@Resource
	private CartBiz cbiz;
	
	@GetMapping("shop")
	public ModelAndView shop(Model m, String name,@RequestParam(defaultValue="1")int page,ModelAndView mav) {
		PageHelper.startPage(page, 9);
		mav.addObject("shop", pmapper.SelectByAll());
		mav.addObject("clist", cmapper.SelectbyAll());
		mav.addObject("plist", pmapper.SelectByPart());	
		mav.setViewName("shop");	
		return mav;
	}
	
	@GetMapping("cateshop")
	public ModelAndView shop(int cid,Model m,ModelAndView mav) {
		mav.addObject("shoplist", pmapper.SelectByCid(cid));
		mav.addObject("clist", cmapper.SelectbyAll());
		mav.addObject("plist", pmapper.SelectByPart());
		mav.setViewName("cateshop");	
		return mav;
	}

	@GetMapping("detail")
	public ModelAndView datail(int  pid,Model m,ModelAndView mav) {
		mav.addObject("detail", pmapper.SelectById(pid));
		mav.addObject("clist", cmapper.SelectbyAll());
		mav.addObject("plist", pmapper.SelectByPart());
		mav.setViewName("detail");	
		return mav;
	}
	
	/*
	 * @PostMapping("cart.do") public String addcart(@Valid Cart c, Errors
	 * errors,Model m){ cbiz.add(c); //return "index"; 这个是请求转发方式跳转到index
	 * //使用响应重定向方式跳转 return "redirect:/"; }
	 */

	@GetMapping("aboutus")
	public ModelAndView aboutus(ModelAndView mav) {
		mav.setViewName("aboutus");	
		return mav;
	}
	
	@GetMapping("gallery")
	public ModelAndView gallery(ModelAndView mav) {
		mav.setViewName("gallery");	
		return mav;
	}
	
	@GetMapping("services")
	public ModelAndView services(ModelAndView mav) {	
		mav.setViewName("services");	
		return mav;
	}

}
