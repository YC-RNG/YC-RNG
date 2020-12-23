package yc.rng.pet.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import yc.rng.pet.bean.Pets;

@Repository
public class PetDao extends BaseDao{
	
	/**
	 * 展示首页商品
	 * @return
	 */
	public List<Pets> selectPetHot(){
		String sql = "select * from pets where pid limit 0,9";
		return jt.query(sql, petRowMapper);
	}
	
	
	
	
	/**
	 * rowMapper
	 */
	private RowMapper<Pets> petRowMapper = new RowMapper<Pets>() {

		@Override
		public Pets mapRow(ResultSet rs, int rowNum) throws SQLException {
			Pets pet = new Pets();
			pet.setPid(rs.getInt("pid"));
			pet.setPname(rs.getString("pname"));
			pet.setPrice(rs.getDouble("price"));
			pet.setState(rs.getInt("state"));
			pet.setImage(rs.getString("image"));
			pet.setPdesc(rs.getString("pdesc"));
			pet.setCid(rs.getInt("cid"));
			return pet;
		}};

}
