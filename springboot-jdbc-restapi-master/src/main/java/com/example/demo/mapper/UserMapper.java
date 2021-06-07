package com.example.demo.mapper;

import com.example.demo.model.User;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class UserMapper {

    private JdbcTemplate jdbcTemplate;

    UserMapper(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> selectAllUsers() {
        String sql = "select * from user";
        return jdbcTemplate.query(sql, (resultSet, i) -> setUserFromResultSet(resultSet));
    }

    public User selectUser(Long id) {
        String sql = "select * from user where id=?";
        return jdbcTemplate.queryForObject(sql, (resultSet, i) -> setUserFromResultSet(resultSet), id);
    }

    public List<User> selectUsersByLevel(Long level) {
        String sql = "select * from user where level=?";
        return jdbcTemplate.query(sql, (resultSet, i) -> setUserFromResultSet(resultSet), level);
    }

    public Long insertUser(User user) {
        String sql = "insert into user(`name`, `level`) values(?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getName());
            ps.setLong(2, user.getLevel());
            return ps;
        }, keyHolder);

        return (Long) keyHolder.getKey();
    }

    public Long updateUser(User user) {
        String sql = "update user set name=?, level=? where id=?";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getName());
            ps.setLong(2, user.getLevel());
            ps.setLong(3, user.getId());
            return ps;
        }, keyHolder);

        return (Long) keyHolder.getKey();
    }

    public boolean deleteUser(Long id) {
        String sql = "delete from user where id=?";
        return jdbcTemplate.update(sql, id) == 1;
    }

    private User setUserFromResultSet(ResultSet rs) throws SQLException {
        return new User(rs.getLong("id"), rs.getString("name"), rs.getLong("level"));
    }
}
