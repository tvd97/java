package treeshopxml.DTO.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import treeshopxml.DTO.products;

public class productMapper implements RowMapper<products>{

	@Override
	public products mapRow(ResultSet rs, int rowNum) throws SQLException {
		products products= new  products();
		products.setId(rs.getString(1));
		products.setName(rs.getString(2));
		products.setNameSpecies(rs.getString(3));
		products.setNameFarm(rs.getString(4));
		products.setPrice(rs.getFloat(5));
		products.setMetaName(rs.getString(6));
		products.setViewCount(rs.getInt(7));
		products.setPromtionPrice(rs.getFloat(8));
		products.setImg(rs.getString(9));
		products.setMoreImg(rs.getString(10));
		products.setDateCreate(rs.getDate(11));
		products.setCharacteristic(rs.getString(12));
		products.setRate(rs.getDouble(13));
		return products;
	}

}
