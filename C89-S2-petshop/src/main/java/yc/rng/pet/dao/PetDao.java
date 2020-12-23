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
	 * 查询热卖
	 * @return
	 */
	public List<Pets> selectPetHot(){
		
		return jt.query(sql, rowMapper);
	}
	
	private RowMapper<Pets> petRowMapper = new RowMapper<Pets>() {

		@Override
		public Pets mapRow(ResultSet rs, int rowNum) throws SQLException {
			Pets pet = new Pets();
			pet.set
			return null;
		}};

}
