package treeshopxml.Entities.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import treeshopxml.Entities.Carts;

public class  CartMapper implements RowMapper<Carts> {

	public Carts mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Carts carts = new Carts();
		carts.setId(rs.getInt("id"));
		carts.setUser(rs.getString("user"));
		return carts;
	}

}
