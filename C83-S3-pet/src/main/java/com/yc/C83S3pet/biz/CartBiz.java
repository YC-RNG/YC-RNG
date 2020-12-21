package com.yc.C83S3pet.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.C83S3pet.bean.Cart;
import com.yc.C83S3pet.dao.CartMapper;



@Service
public class CartBiz {
	@Resource
	private CartMapper  cMapper;
	
	public void add(Cart c) {
		// 可以忽略字段验证
				// 同名验证
				if (cMapper.update(c)==0) {
					cMapper.update(c);
				}
				cMapper.insert(c);
		
	}

}
