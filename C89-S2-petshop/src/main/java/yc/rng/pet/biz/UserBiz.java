package yc.rng.pet.biz;

import java.sql.SQLException;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;


import net.sf.jsqlparser.statement.select.Select;
import yc.rng.pet.bean.User;
import yc.rng.pet.dao.UserDao;
import yc.rng.pet.util.Utils;

@Service
public class UserBiz {
	
	@Resource
	private UserDao udao; 
	
	@Resource
	private MailBiz mbiz;
	
	/**
	 * 注册验证
	 * @param user
	 * @throws BizException
	 * @throws SQLException
	 */
	public void reg(User user) throws BizException, SQLException {
		// 字段验证
		
		Utils.checkNull(user.getAccount(), "账号不能为空");
		Utils.checkNull(user.getPassword(), "密码不能为空");
		Utils.checkNull(user.getUsername(), "昵称不能为空");
		Utils.checkNull(user.getPhone(), "电话号码不能为空");
		Utils.checkNull(user.getSex(), "性别不能为空");
		Utils.checkNull(user.getAddr(), "地址不能为空");
		Utils.checkNull(user.getEmail(), "邮箱不能为空");
		 
		// 同名验证
		User dbuser = udao.selectByAccount(user.getAccount());
		if(dbuser != null) {
			throw new BizException("该用户名已经被注册");
		}
		
		try {
			udao.insert(user);
		} catch (SQLException e) {
			throw new BizException("注册失败，请联系管理员",e);
		}
	}
	
	/**
	 * 登录验证
	 * @param account
	 * @param password
	 * @param vcode
	 * @param session
	 * @return
	 * @throws BizException
	 */
	public User login(int account,String password,String vcode,HttpSession session) throws BizException {
		// 字段验证
		Utils.checkNull(account, "请输入用户名");
		Utils.checkNull(password, "请输入密码");
		
		User user = new User();
		user = udao.selectByAccount(account);
		if(user == null) {
			throw new BizException("请检查账号是否正确");
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
	
	/**
	 * 发送验证码
	 * @param account
	 * @return
	 */
	public String sendVcode(int account) {
		User user = udao.selectByAccount(account);
		String vcode  = "" + System.currentTimeMillis();
		vcode = vcode.substring(vcode.length()-4);
		mbiz.sendSimpleMail(user.getEmail(), "密码重置验证码","请使用" +vcode+"验证码重置您的密码！");
		return vcode;
	}
	
	/**
	 * 重置密码
	 * @param account
	 * @param password
	 * @param vcode
	 * @param sessionVcode
	 * @return
	 * @throws BizException 
	 */
	public String resetPwd(int account ,String password ,String vcode ,String sessionVcode) throws BizException {
		// 字段验证
		Utils.checkNull(account, "请输入用户名");
		Utils.checkNull(password, "请输入新密码");
		
		if(vcode.equalsIgnoreCase(sessionVcode)) {
			udao.updatePwdByAccount(password, account);
			return "密码重置成功！";
		}else {
			return "密码重置失败！";
		}	
	}

}
