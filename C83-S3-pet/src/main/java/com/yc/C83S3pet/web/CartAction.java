package com.yc.C83S3pet.web;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;





@Controller
public class CartAction {
	
	
	@GetMapping("cart")
	public ModelAndView cart(Model m,ModelAndView mav) {	
		mav.setViewName("cart");	
		return mav;
	}
	
}
