package com.yc.C83S3pet.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yc.C83S3pet.dao.PetsMapper;

@Controller
public class ContactusAction {
	
	@GetMapping("contactus")
	public ModelAndView contactus(ModelAndView mav) {	
		mav.setViewName("contactus");	
		return mav;
	}

}
