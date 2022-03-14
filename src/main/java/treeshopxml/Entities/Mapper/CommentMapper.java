package treeshopxml.Entities.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import treeshopxml.Entities.Comments;

public class CommentMapper implements RowMapper<Comments> {
	public Comments mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Comments comments = new Comments();
		comments.setContent(rs.getString(4));
		comments.setId(rs.getInt(1));
		comments.setSeedling(rs.getString(2));
		comments.setName(rs.getString(3));
		return comments;
	}
}