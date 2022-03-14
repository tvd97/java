package treeshopxml.Entities.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import treeshopxml.Entities.Farms;

public class FarmMapper implements RowMapper<Farms> {
	public Farms mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Farms farms = new Farms();
		farms.setId(rs.getInt(1));
		farms.setName(rs.getString(2));
		farms.setPhone(rs.getString(3));
		farms.setAddress(rs.getString(4));
		farms.setIdUser(rs.getString(5));
		farms.setMetaName(rs.getString(6));
		farms.setLogo(rs.getString(7));
		return farms;
	}
}
