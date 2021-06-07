package com.example.demo.service;

import com.example.demo.mapper.MessageMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Message;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageMapper messageMapper;
    private UserMapper userMapper;

    MessageServiceImpl(MessageMapper messageMapper, UserMapper userMapper) {
        this.messageMapper = messageMapper;
        this.userMapper = userMapper;
    }

    @Override
    public List<Message> findAll() {
        return messageMapper.selectAllMessages();
    }

    @Override
    public List<Message> findToFromMessage(Long id, String type) {
        return messageMapper.selectFromToMessage(id, type);
    }

    @Override
    public Message save(Message message) {
        User fromUser = userMapper.selectUser(message.getFromId());
        User toUser = userMapper.selectUser(message.getToId());
        message.setFrom(fromUser.getName());
        message.setTo(toUser.getName());

        if (message.getId() == null) {
            Long selectedMessageId = messageMapper.insertMessage(message);
            return messageMapper.selectMessage(selectedMessageId);
        } else {
            Long updatedMessageId = messageMapper.updateMessage(message);
            return messageMapper.selectMessage(updatedMessageId);
        }
    }

    @Override
    public boolean delete(Long id) {
        return messageMapper.deleteMessage(id);
    }
}
