package yc.rng.pet.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.websocket.EncodeException;

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
	 
	@RequestMapping("getLoginedUser")
	public User getLoginedUser(String username,HttpSession session) {
		User user = (User) session.getAttribute("loginedUser");
		return user;
	}
	
	@RequestMapping("login")
	public Result login(int account,String password,HttpSession session,String vcode) throws IOException, EncodeException {
		User user;
		try {
			user = udao.login(account,password,vcode,session);
			session.setAttribute("loginedUser", user);
			return new Result(1, "登录成功");
		} catch (BizException e) {
			e.printStackTrace();
			return  new Result(0, e.getMessage());
		}
		
	}
	
	@RequestMapping("sendVcode")
	public String sendVcode(int account ,HttpSession session) {
		String vcode = ubiz.sendVcode(account);
		session.setAttribute("vcode", vcode);
		return "验证码发送成功！";
	}

	@RequestMapping("resetPwd")
	public String resetPwd(int account,String password,String vcode,HttpSession session) throws BizException {
		return ubiz.resetPwd(account, password, vcode, (String)session.getAttribute("vcode"));
	}
}
