package treeshopxml.Entities.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import treeshopxml.Entities.Infomations;

public class InfomationMapper implements RowMapper<Infomations> {

	public Infomations mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Infomations infomations = new Infomations();
		infomations.setId(rs.getString("id"));
		infomations.setFistName(rs.getString("fistname"));
		infomations.setLastName(rs.getString("lastname"));
		infomations.setAddress(rs.getString("address"));
		infomations.setPhone(rs.getString("phone"));
		infomations.setEmail(rs.getString("email"));
		infomations.setUsername(rs.getString("username"));

		return infomations;
	}

}