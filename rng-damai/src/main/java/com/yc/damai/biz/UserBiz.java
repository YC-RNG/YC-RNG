package com.yc.damai.biz;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import com.yc.damai.dao.UserDao;
import com.yc.damai.bean.User;
import com.yc.damai.util.Utils;

@Service
public class UserBiz {
	
	@Resource
	private UserDao udao;
	
	@Resource
	private MailBiz mbiz;
	
	public String sendVcode(String name) {
		User user = udao.selectByName(name);
		// 生成随机验证码
		String vcode = "" + System.currentTimeMillis();
		vcode = vcode.substring(vcode.length()-4);
		mbiz.sendSimpleMail(user.getEmail(), "密码重置验证码","请使用"+vcode+"验证码来重置密码");
		return vcode;
	}

	public void register(User user) throws BizException, SQLException {
		// 字段验证
		
		Utils.checkNull(user.getUsername(), "用户名不能为空");
		Utils.checkNull(user.getPassword(), "密码不能为空");
		Utils.checkNull(user.getEmail(), "邮箱不能为空");
		Utils.checkNull(user.getPhone(), "电话号码不能为空");
		Utils.checkNull(user.getName(), "昵称不能为空");
		// 同名验证
		User dbuser = udao.selectByName(user.getUsername());
		if(dbuser != null ) {
			throw new BizException("该用户名已经被注册");
		}
		
		udao.insert(user);
	}
	
	public User login(String username,String password,String vcode,HttpSession session) throws BizException {
		// 字段验证
		Utils.checkNull(username, "请输入用户名");
		Utils.checkNull(password, "请输入密码");
		
		User user = new User();
		user = udao.selectByName(username);
		if(user == null) {
			throw new BizException("请检查用户名是否正确");
		}
	
		if( !user.getPassword().equals(password)  ) {
			throw new BizException("密码错误");
		}
		@SuppressWarnings("null")
		String svcode = (String) session.getAttribute("vcode");
		if(!vcode.equalsIgnoreCase(svcode)) {
			throw new BizException("验证码错误");
		}
		return user;
	}
	
}
