package yc.rng.pet.biz;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import yc.rng.pet.bean.User;
import yc.rng.pet.dao.UserDao;
import yc.rng.pet.util.Utils;

@Service
public class UserBiz {
	
	@Resource
	private UserDao udao; 
	
	public void reg(User user) throws BizException, SQLException {
		// 字段验证
		
		Utils.checkNull(user.getUsername(), "昵称不能为空");
		Utils.checkNull(user.getPassword(), "密码不能为空");
		Utils.checkNull(user.getAccount(), "账号不能为空");
		Utils.checkNull(user.getPhone(), "电话号码不能为空");
		Utils.checkNull(user.getSex(), "性别不能为空");
		Utils.checkNull(user.getAddr(), "地址不能为空");
		// 同名验证
		User dbuser = udao.selectByAccount(user.getAccount());
		if(dbuser != null ) {
			throw new BizException("该用户名已经被注册");
		}
		
		try {
			udao.insert(user);
		} catch (SQLException e) {
			throw new BizException("注册失败，请联系管理员",e);
		}
	}

}
