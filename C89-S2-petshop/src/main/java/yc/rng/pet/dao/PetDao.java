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
	public List<Pets> selectPetHot2(){
		String sql = "select * from pets where pid limit 0,3";
		return jt.query(sql, petRowMapper);
	}
	
	public List<Pets> selectPetNew(){
		String sql = "select * from pets order by createtime desc limit 3";
		return jt.query(sql, petRowMapper);
	}
	
	
	/**
	 * 根据id查询商品
	 * @param id
	 * @return
	 */
	public Pets selectById(int pid) {
		String sql = "select * from pets where pid=?";
		return jt.query(sql, rs->{//lamda 表达式
			//resultsetextrator  接口方法中，要求手动执行 结果集的next方法
			return rs.next() ? petRowMapper.mapRow(rs, -1) : null;
		}, pid);
	}
	
	/**
	 * 分类查询
	 * @param cid
	 * @return
	 */
	public List<Pets> selectByCid(int cid) {
		String sql = "select * from pets where cid=?";
		return jt.query(sql, petRowMapper,cid);
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
