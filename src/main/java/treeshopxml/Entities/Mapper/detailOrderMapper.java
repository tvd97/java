package treeshopxml.Entities.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import treeshopxml.Entities.detailOrders;

public class detailOrderMapper implements RowMapper<detailOrders> {
	public detailOrders mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		detailOrders orders = new detailOrders();
		orders.setCount(rs.getInt(4));
		orders.setId(rs.getInt(1));
		orders.setOrder(rs.getInt(2));
		orders.setSeedling(rs.getString(3));
		orders.setTotalPrice(rs.getFloat(5));
		return orders;
	}
}