package treeshopxml.DTO.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import treeshopxml.DTO.farms;

public class farmMapper implements RowMapper<farms> {

	@Override
	public farms mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		farms farm = new farms();
		farm.setId(rs.getInt(1));
		farm.setName(rs.getString(2));
		farm.setPhone(rs.getString(3));
		farm.setAddress(rs.getString(4));
		farm.setLogo(rs.getString(5));
		farm.setMetaname(rs.getString(6));
		farm.setFistname(rs.getString(7));
		farm.setLastname(rs.getString(8));
		return farm;
	}

}
