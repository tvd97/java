package treeshopxml.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import treeshopxml.Entities.Rates;
import treeshopxml.Entities.Mapper.RateMapper;

@Repository
public class RateDAO {
@Autowired
private JdbcTemplate _jdbcTemplate;
	public List<Rates> getRateProduct(String id)
	{
		List<Rates> list= new ArrayList<Rates>();
		String query= "SELECT * FROM rates WHERE rates.seedling='"+id+"'";
		list=_jdbcTemplate.query(query, new RateMapper());
		return list;
	}
}
