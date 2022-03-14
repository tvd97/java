package treeshopxml.Entities.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import treeshopxml.Entities.Accounts;

public class AccountMapper implements RowMapper<Accounts> {

	public Accounts mapRow(ResultSet rs, int rowNum) throws SQLException {
		Accounts accounts = new Accounts();		
		accounts.setUsername(rs.getString(1));
		accounts.setPassword(rs.getString(2));
		accounts.setStatus(rs.getInt(3));
		accounts.setName(rs.getString(4));
		return accounts;
	}

}
