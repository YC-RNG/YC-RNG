package com.yc.damai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.yc.damai.bean.User;
import com.yc.damai.biz.BizException;
import com.yc.damai.biz.UserBiz;

@Repository
public class UserDao extends BaseDao{
	
	@Resource
	private UserBiz ubiz;
	
	/**
	 * 插入用户
	 * @param user
	 */
	public void insert(User user) {
		String sql="insert into user values(null,?,?,?,?,?,?,?,?,1)";
		jt.update(sql,
				user.getUsername(),user.getPassword(),
				user.getName(),user.getEmail(),user.getPhone(),
				user.getSex(),user.getAddr());
	}
	
	/**
	 * 根据用户名查用户
	 * @param name
	 * @return
	 * @throws SQLException 
	 */
	public User selectByName(String username) {
		String sql = "select * from user where username=?";
		return jt.query(sql, rs->{
			return rs.next() ? userRowMapper.mapRow(rs, -1) : null;
		}, username);
	}
	
	public User login(String username, String password, String vcode,HttpSession session) throws BizException {
		return ubiz.login(username, password,vcode,session);
	}
	
	public void register(User user) throws BizException, SQLException {
		ubiz.register(user);
	}
	
	
	
	/**
	 * 创建userRowMapper
	 */
	private RowMapper<User> userRowMapper = new RowMapper<User>() {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User u = new User();
			u.setUid(rs.getInt("uid"));
			u.setUsername(rs.getString("username"));
			u.setPassword(rs.getString("password"));
			u.setName(rs.getString("name"));
			u.setEmail(rs.getString("email"));
			u.setPhone(rs.getString("phone"));
			u.setSex(rs.getString("sex"));
			u.setState(rs.getInt("state"));
			u.setCode(rs.getString("code"));
			u.setAddr(rs.getString("addr"));
			return u;
		}
	};
	
	
}
