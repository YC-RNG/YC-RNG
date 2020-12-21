package com.yc.C83S3pet.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yc.C83S3pet.dao.PetsMapper;


@Controller
public class IndexAction {
	@Resource
	private PetsMapper pmapper;
	
	@GetMapping("/")
	public String index(Model m) {
		m.addAttribute("plist", pmapper.SelectByPart());		
		return "index";
	}

}
