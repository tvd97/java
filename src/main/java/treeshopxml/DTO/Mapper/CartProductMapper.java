package treeshopxml.DTO.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import treeshopxml.DTO.CartProduct;

public class CartProductMapper implements RowMapper<CartProduct> {

	@Override
	public CartProduct mapRow(ResultSet rs, int rowNum) throws SQLException {
		CartProduct cartProduct= new CartProduct();
		cartProduct.setId(rs.getInt(1));
		cartProduct.setName(rs.getString(2));
		cartProduct.setPrice(rs.getFloat(3));
		cartProduct.setCount(rs.getInt(4));
		cartProduct.setTotal(rs.getFloat(5));
		cartProduct.setStatus(rs.getInt(6));
		cartProduct.setImg(rs.getString(7));
		cartProduct.setId_product(rs.getString(8));
		
		return cartProduct;
	}

}
