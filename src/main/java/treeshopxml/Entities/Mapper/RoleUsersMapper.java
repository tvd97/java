package treeshopxml.Entities.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import treeshopxml.Entities.RoleUsers;

public class RoleUsersMapper implements RowMapper<RoleUsers> {

	public RoleUsers mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		RoleUsers roleUsers = new RoleUsers();
		roleUsers.setId(rs.getInt("id"));
		roleUsers.setRole(rs.getString("role"));
		roleUsers.setUser(rs.getString("username"));
		return roleUsers;
	}

}