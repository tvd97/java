package treeshopxml.DTO.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RoleAccMappper implements RowMapper<RoleAccount> {

	@Override
	public RoleAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
		RoleAccount account = new RoleAccount();
		account.setUsername(rs.getString(0));
		account.setPassword(rs.getString(1));
		account.setRole(rs.getString(2));
		return account;
	}

}
