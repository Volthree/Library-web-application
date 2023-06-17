package application.library.dao;

import application.library.models.Human;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HumanMapper implements RowMapper<Human> {
    @Override
    public Human mapRow(ResultSet rs, int rowNum) throws SQLException {
        Human human = new Human();
        human.setName(rs.getString("name"));
        human.setBirthday(rs.getInt("birthday"));
        human.setId(rs.getInt("id"));
        return human;
    }
}
