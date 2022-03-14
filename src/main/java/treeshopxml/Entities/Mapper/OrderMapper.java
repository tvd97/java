package treeshopxml.Entities.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import treeshopxml.Entities.Orders;

public class OrderMapper implements RowMapper<Orders> {

	public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Orders orders = new Orders();
		orders.setId(rs.getInt(1));
		orders.setName(rs.getString(2));
		orders.setDate(rs.getString(3));
		orders.setPhone(rs.getString(6));
		orders.setAddr(rs.getString(5));
		orders.setStatus(rs.getInt(4));
		orders.setNote(rs.getString(7));
		orders.setUser(rs.getString(8));
		orders.setPayments(rs.getInt(9));
		return orders;
	}
}
