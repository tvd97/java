package treeshopxml.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import treeshopxml.Entities.Farms;
import treeshopxml.Entities.Mapper.FarmMapper;


@Repository
public class FarmDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<Farms> getAllFarm() {
		// TODO Auto-generated method stub
		List<Farms> list= new ArrayList<Farms>();
		String query= "SELECT *FROM farms";
		list=jdbcTemplate.query(query, new FarmMapper());
		return list;
	}
	
}
