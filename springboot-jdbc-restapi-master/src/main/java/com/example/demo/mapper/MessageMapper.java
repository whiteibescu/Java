package com.example.demo.mapper;

import com.example.demo.model.Message;
import com.example.demo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository
public class MessageMapper {

    private JdbcTemplate jdbcTemplate;

    MessageMapper(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Message> selectAllMessages() {
        String sql = "select * from message";
        return jdbcTemplate.query(sql, (resultSet, i) -> setMessageFromResultSet(resultSet));
    }

    public Message selectMessage(Long id) {
        String sql = "select * from message where id=?";
        return jdbcTemplate.queryForObject(sql, (resultSet, i) -> setMessageFromResultSet(resultSet), id);
    }

    public List<Message> selectFromToMessage(Long id, String type) {
        String sql = "";
        if ("from".equals(type)) {
            sql = "select * from message where fromId=?";
        } else if ("to".equals(type)) {
            sql = "select * from message where toId=?";
        } else {
            throw new IllegalArgumentException("from 또는 to만 가능합니다.");
        }
        return jdbcTemplate.query(sql, (resultSet, i) -> setMessageFromResultSet(resultSet), id);
    }

    public Long insertMessage(Message message) {
        String sql = "insert into message(`message`, `fromId`, `from`, `toId`, `to`) values(?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, message.getMessage());
            ps.setLong(2, message.getFromId());
            ps.setString(3, message.getFrom());
            ps.setLong(4, message.getToId());
            ps.setString(5, message.getTo());
            return ps;
        }, keyHolder);

        return (Long) keyHolder.getKey();
    }

    public Long updateMessage(Message message) {
        String sql = "update message set message=?, fromId=?, `from`=?, toId=?, `to`=? where id=?";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, message.getMessage());
            ps.setLong(2, message.getFromId());
            ps.setString(3, message.getFrom());
            ps.setLong(4, message.getToId());
            ps.setString(5, message.getTo());
            ps.setLong(6, message.getId());
            return ps;
        }, keyHolder);

        return (Long) keyHolder.getKey();
    }

    public boolean deleteMessage(Long id) {
        String sql = "delete from message where id=?";
        return jdbcTemplate.update(sql, id) == 1;
    }

    private Message setMessageFromResultSet(ResultSet rs) throws SQLException {
        return new Message(
                rs.getLong("id"),
                rs.getString("message"),
                rs.getLong("fromId"),
                rs.getString("from"),
                rs.getLong("toId"),
                rs.getString("to")
        );
    }
}
