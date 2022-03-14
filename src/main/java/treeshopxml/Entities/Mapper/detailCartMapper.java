package treeshopxml.Entities.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import treeshopxml.Entities.detailCarts;

public class detailCartMapper implements RowMapper<detailCarts> {
	public detailCarts mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		detailCarts carts = new detailCarts();
		carts.setCount(rs.getInt("count"));
		carts.setId(rs.getInt("id"));
		carts.setCart(rs.getInt("cart"));
		carts.setSeedling(rs.getString("seedling"));
		carts.setStatus(rs.getInt("status"));

		return carts;
	}
}
