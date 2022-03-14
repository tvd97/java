package treeshopxml.Entities.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import treeshopxml.Entities.Rates;

public class RateMapper implements RowMapper<Rates> {
	public Rates mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Rates rates = new Rates();
		rates.setContent(rs.getString("content"));
		rates.setDate(rs.getString("date"));
		rates.setIdSeedling(rs.getString("seedling"));
		rates.setId(rs.getInt("id"));
		rates.setRate(rs.getFloat("rate"));
		rates.setName(rs.getString("name"));
		return rates;
	}
}