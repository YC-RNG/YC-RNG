package yc.rng.pet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import yc.rng.pet.bean.Orderitem;
import yc.rng.pet.bean.Orders;



@Repository
public class OrderDao extends BaseDao{
	
	/**
	 * 插入订单
	 * @param orders
	 * @return 
	 */
	public int insert(Orders orders) {
		String sql = "insert into orders values(null,?,now(),?,?,?)";
		KeyHolder kh = new GeneratedKeyHolder();
		jt.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql, new String[] {"oid"});
				ps.setObject(1, orders.getTotal());
				ps.setObject(2, orders.getAddr());
				ps.setObject(3, orders.getPhone());
				ps.setObject(4, orders.getUid());
				return ps;
			}	
		},kh);
		return kh.getKey().intValue();

	}
	
	/**
	 * 新增订单明细
	 * @param orders
	 */
	public void insertItems(Orders orders) {
		String sql = "INSERT INTO orderitem SELECT\n" +
				"	NULL,\n" +
				"	a.count,\n" +
				"	a.count * b.price,\n" +
				"	a.pid,\n" +
				"	?\n" +
				"FROM\n" +
				"	cart a\n" +
				"JOIN pets b ON a.pid = b.pid\n" +
				"WHERE\n" +
				"	a.uid = ?";
		jt.update(sql, orders.getOid(), orders.getUid());
	}
	
	
	/**
	 * 根据uid查询订单
	 * @param uid
	 * @return
	 */
	public List<?> selectOrders(Integer uid) {
		return jt.queryForList("select * from orders a "
				+ "left join orderitem b on a.oid=b.oid"
				+ " left join pets c on b.pid=c.pid "
				+ "where a.uid=?", uid);
	}
	
	 
	
	
	private RowMapper<Orderitem> orderitemRowMapper = new RowMapper<Orderitem>() {

		@Override
		public Orderitem mapRow(ResultSet rs, int rowNum) throws SQLException {
			Orderitem  orderitem = new Orderitem();
			orderitem.setItemid(rs.getInt("itemid"));
			orderitem.setCount(rs.getInt("count"));
			orderitem.setSubtotal(rs.getDouble("subtotal"));
			orderitem.setPid(rs.getInt("pid"));
			orderitem.setOid(rs.getInt("oid"));
			return orderitem;
		}};
	
	
	/*private RowMapper<Orders> ordersRowMapper = new RowMapper<Orders>() {

		@Override
		public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
			Orders orders = new Orders();
			orders.setOid(rs.getInt("oid"));
			orders.setTotal(rs.getDouble("total"));
			orders.setCreatetime(rs.getDate("createtime"));
			orders.setAddr(rs.getString("addr"));
			orders.setPhone(rs.getString("phone"));
			orders.setUid(rs.getInt("uid"));
			return orders;
		}}; */


	public List<Orderitem> selectByOid(Integer oid) {
		String sql = "select * from orderitem where oid=?";
		return  jt.query(sql,orderitemRowMapper, oid);
	}

	
}
