package com.yc.damai.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.damai.bean.Product;
import com.yc.damai.dao.ProductDao;

@RestController
public class ProductAction {
	
	@Resource
	private ProductDao pdao;
	
	/**
	 * 查询热门商品
	 * @return
	 */
	@RequestMapping(path="product.s",params="op=queryHot")
	public List<?> queryHot(){
		return pdao.selectHot();
	}
	
	@RequestMapping(path="product.s",params="op=queryNew")
	public List<?> queryNew(){
		return pdao.selectNew();
	}
	
	/**
	 * 根据商品id查询商品
	 * @param id
	 * @return
	 */
	@RequestMapping("queryProduct")
	public Product queryById(int id) {
		return pdao.selectById(id);
	}

}
