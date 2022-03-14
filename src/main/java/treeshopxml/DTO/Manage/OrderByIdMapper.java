package treeshopxml.DTO.Manage;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class OrderByIdMapper implements RowMapper<OrderById>{
	@Override
	public OrderById mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderById orderById= new OrderById();
		orderById.setId(rs.getInt(1));
		orderById.setOrder(rs.getInt(2));
		orderById.setName(rs.getString(3));
		orderById.setCount(rs.getInt(4));
		orderById.setTotal(rs.getFloat(5));
		return orderById;
	}

}
