package treeshopxml.DTO.Manage;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ManageMapper implements RowMapper<ProductManage>{

	@Override
	public ProductManage mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductManage manage= new ProductManage();
		manage.setId(rs.getString(1));
		manage.setName(rs.getString(2));
		manage.setSpecies(rs.getString(3));
		manage.setPrice(rs.getFloat(4));
		manage.setMetaname(rs.getString(5));
		manage.setViews(rs.getString(6));
		manage.setPromoPrice(rs.getFloat(7));
		manage.setImg(rs.getString(8));
		manage.setMoreImg(rs.getString(9));
		manage.setDate(rs.getDate(10));
		manage.setCharactic(rs.getString(11));
		manage.setCare(rs.getString(12));
		return manage;
	}

}
