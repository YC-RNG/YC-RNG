package yc.rng.pet.web;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yc.rng.pet.bean.Result;
import yc.rng.pet.bean.User;
import yc.rng.pet.biz.BizException;
import yc.rng.pet.biz.UserBiz;
import yc.rng.pet.dao.UserDao;

@RestController
public class UserAction {
	
	@Resource
	public UserDao udao;
	
	@Resource
	public UserBiz ubiz;
	
	@RequestMapping("reg")
	public Result reg(User user,String vcode,HttpSession session) throws SQLException {
		try {
			udao.reg(user);
			return new Result(1, "注册成功");
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(0, e.getMessage());
		} 
	}
	

}
