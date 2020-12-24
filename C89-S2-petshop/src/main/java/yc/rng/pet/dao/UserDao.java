package yc.rng.pet.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.Resource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



import yc.rng.pet.bean.User;
import yc.rng.pet.biz.BizException;
import yc.rng.pet.biz.UserBiz;

@Repository
public class UserDao extends BaseDao{
	
	@Resource
	private UserBiz ubiz;
	
	/**
	 * 插入用户
	 * @param user
	 * @throws SQLException
	 */
	public void insert(User user) throws SQLException {
		String sql = "insert into user values(null,?,?,?,?,?,?,1,null)";
		jt.update(sql,
				user.getUsername(),user.getAccount(),
				user.getPassword(),user.getPhone(),
				user.getSex(),user.getAddr(),user.getState(),user.getCreatetime());
	}
	
	/**
	 * 通过account查询用户
	 * @param user
	 * @throws SQLException
	 */
	public User selectByAccount(String account) {
		String sql = "select * from user where account=?";
		return jt.query(sql, rs->{
			return rs.next() ? userRowMapper.mapRow(rs, -1) : null;
		}, account);
		
	}
	
	public void reg(User user) throws BizException, SQLException {
		ubiz.reg(user);
	}
	
	
	
	/**
	 * userRowMapper
	 */
	private RowMapper<User> userRowMapper = new RowMapper<User>() {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setUid(rs.getInt("uid"));
			user.setAccount(rs.getString("account"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setPhone(rs.getString("phone"));
			user.setSex(rs.getString("sex"));
			user.setAddr(rs.getString("addr"));
			user.setState(rs.getInt("state"));
			user.setCreatetime(rs.getTimestamp("createtime"));
			return null;
		}
		
	};
	
	

}
