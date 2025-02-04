package yc.rng.pet.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import yc.rng.pet.bean.Cart;


@Repository
public class CartDao extends BaseDao{
	
	/**
	 * 查询购物车
	 * @param uid
	 * @return
	 * @throws SQLException
	 */
	public List<?> queryCart(Integer uid) throws SQLException {
		String sql = "select pets.*,cart.* from cart,pets" + "where cart.pid=pets.pid and cart.uid=?";
		List<?> list = null;
		// list = jt.query(sql, uid);
		System.out.println("list==" + list);
		return list;
	}

	/**
	 * 添加购物车
	 * @param pid
	 * @param count
	 * @param uid
	 * @throws SQLException
	 */
	public void addCart(String pid, String count, Integer uid) throws SQLException {
		
		String sql = "update cart set count=count+? where uid=? and pid=?";
		if (jt.update(sql, count, uid, pid) == 0) {
			sql = "insert into cart values(null,?,?,?)";
			jt.update(sql, uid, pid, count);
		}
	}
	
	/**
	 * 清空购物车
	 * @param iUid
	 * @throws SQLException
	 */
	public void clearCart(int uid) throws SQLException {
		String sql = "delete from cart where uid = ?";
		jt.update(sql, uid);
	}

	public void deleteCart(int pid) {
		String sql = "delete from cart where pid=?";
		jt.update(sql, pid);
	}
	
	public void insert(int uid, int pid, int count) {
		jt.update("insert into cart values(null,?,?,?)", uid, pid, count);
	}
	
	public List<Map<String,Object>> selectCart(Integer uid) {
		return jt.queryForList("select * from cart a"
				+ " left join user b on a.uid=b.uid"
				+ " left join pets c on a.pid=c.pid"
				+ " where a.uid=?", uid);
	}
	
	/**
	 * cartRowMapper
	 */
	private RowMapper<Cart> cartRowMapper = new RowMapper<Cart>() {

		@Override
		public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
			Cart cart = new Cart();
			cart.setCiid(rs.getInt("ciid"));
			cart.setUid(rs.getInt("uid"));
			cart.setPid(rs.getInt("pid"));
			cart.setCount(rs.getInt("count"));
			return cart;
		}
	};

	public Double selectTotalByUid(Integer uid) {
		String sql = "SELECT\n" + "	sum(count * b.price)\n" + "FROM\n" + "	cart a\n"
				+ "JOIN pets b ON a.pid = b.pid\n" + "WHERE\n" + "	uid = ?";
		return jt.queryForObject(sql, Double.class, uid);
	}

	/**
	 * 根据用户id 删除购物车
	 * 
	 * @param uid
	 */
	public void deleteByUid(Integer uid) {
		jt.update("delete from cart where uid=?", uid);
	}
}
