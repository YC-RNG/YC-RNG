package yc.rng.pet.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import yc.rng.pet.bean.Category;
@Repository
public class CategoryDao extends BaseDao{
	
	public List<Category> queryCategory(){
		String sql = "select * from category";
		return jt.query(sql,categoryRowMapper);
	}
	
	
	
	
	/**
	 * catagoryRowMapper
	 */
	private RowMapper<Category> categoryRowMapper = new RowMapper<Category>() {

		@Override
		public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
			Category c = new Category();
			c.setCid(rs.getInt("cid"));
			c.setCname(rs.getString("cname"));
			return c;
		}
		
	};

}
