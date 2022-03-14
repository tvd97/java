package treeshopxml.Entities.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import treeshopxml.Entities.Feedbacks;

public class FeedbackMapper implements RowMapper<Feedbacks> {
	public Feedbacks mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Feedbacks feedbacks = new Feedbacks();
		feedbacks.setContent(rs.getString("content"));
		feedbacks.setId(rs.getInt("id"));
		feedbacks.setIdFarm(rs.getInt("idFarm"));
		feedbacks.setImg(rs.getString("image"));
		feedbacks.setMoreImg(rs.getString("moreImg"));
		return feedbacks;
	}
}