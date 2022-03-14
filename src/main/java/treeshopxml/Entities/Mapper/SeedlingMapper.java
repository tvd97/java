package treeshopxml.Entities.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import treeshopxml.Entities.Seedlings;

public class SeedlingMapper implements RowMapper<Seedlings> {
	public Seedlings mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Seedlings seedlings = new Seedlings();
		seedlings.setDate(rs.getString(11));
		seedlings.setId(rs.getNString(1));
		seedlings.setFarm(rs.getInt(4));
		seedlings.setSpecies(rs.getString(3));
		seedlings.setImg(rs.getString("img"));
		seedlings.setMetaName(rs.getString(6));
		seedlings.setMoreImg(rs.getString(10));
		seedlings.setName(rs.getString(2));
		seedlings.setPrice(rs.getFloat(5));
		seedlings.setPromtionPrice(rs.getFloat(8));
		seedlings.setViewCount(rs.getInt(7));
		seedlings.setCharacteristic(rs.getString(12));
		seedlings.setCare(rs.getString(13));

		return seedlings;
	}
}