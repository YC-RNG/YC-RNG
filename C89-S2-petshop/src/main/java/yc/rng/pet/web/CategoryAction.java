package yc.rng.pet.web;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yc.rng.pet.bean.Category;
import yc.rng.pet.dao.CategoryDao;

@RestController
public class CategoryAction {
	
	@Resource
	private CategoryDao cdao;
	
	@RequestMapping("queryCategory")
	public List<Category> queryCategory(){
		return cdao.queryCategory();
	}
	
	@RequestMapping("quertAll")
	public Map<String, Object> queryAll() throws SQLException {
		Map<String,Object> data = new HashMap<>();
		data.put("clist",cdao.queryCategory());
		return data;
	}

}
