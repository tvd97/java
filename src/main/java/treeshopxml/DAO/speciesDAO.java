package treeshopxml.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import treeshopxml.Entities.Species;
import treeshopxml.Entities.Mapper.SpeciesMapper;

@Repository
public class speciesDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<Species> getListSpecies() {
		List<Species> list = new ArrayList<Species>();
		String query = "SELECT * FROM species";
		list = jdbcTemplate.query(query, new SpeciesMapper());
		return list;
	}
}
