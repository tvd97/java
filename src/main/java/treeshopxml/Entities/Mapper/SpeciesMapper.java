package treeshopxml.Entities.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import treeshopxml.Entities.Species;

public class SpeciesMapper implements RowMapper<Species> {
	public Species mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Species species = new Species();
		species.setId(rs.getString("id"));
		species.setName(rs.getNString("name"));
		species.setMetaName(rs.getString("metaName"));
		return species;
	}
}