package treeshopxml.Entities.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import treeshopxml.Entities.Roles;

public class RoleMapper implements RowMapper<Roles> {

	public Roles mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Roles roles = new Roles();
		roles.setId(rs.getString("idRole"));
		roles.setName(rs.getString("name"));
		return roles;
	}

}