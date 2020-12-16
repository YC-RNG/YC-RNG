package com.yc.damai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yc.damai.bean.Product;

@Repository
public class ProductDao extends BaseDao{
	
	/**
	 * 查询热门商品
	 * @return
	 */
	public List<Product> selectHot(){
		String sql = "select * from product where is_hot=1 limit 0,10";
		return jt.query(sql, productRowMapper);
		
	}
	
	/**
	 * 查询最新商品
	 * @return
	 */
	public List<Product> selectNew(){
		String sql = "select * from product order by pdate desc limit 10";
		return jt.query(sql, productRowMapper);
	}
	
	/**
	 * 根据商品id查询商品
	 */
	public Product selectById(int id) {	
		String sql = "select * from product where pid=?";
		return jt.query(sql, rs->{//lamda 表达式
			//resultsetextrator  接口方法中，要求手动执行 结果集的next方法
			return rs.next() ? productRowMapper.mapRow(rs, -1) : null;
		}, id);
		
	}
	
	
	
	
	//创建 RowMapper
	private RowMapper<Product> productRowMapper = new RowMapper<Product>() {

		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product p = new Product();
			p.setPid(rs.getInt("pid"));
			p.setCsid(rs.getInt("Csid"));
			p.setImage(rs.getString("image"));
			p.setIsHot((rs.getInt("is_hot")));;
			p.setMarketPrice(rs.getDouble("market_price"));
			p.setShopPrice(rs.getDouble("shop_price"));
			p.setPdate(rs.getDate("pdate"));
			p.setPdesc(rs.getString("pdesc"));
			p.setPname(rs.getString("pname"));
			return p;
		}
		
	};

}
