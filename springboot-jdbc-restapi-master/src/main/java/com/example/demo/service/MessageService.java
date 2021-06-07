package com.example.demo.service;

import com.example.demo.model.Message;
import com.example.demo.model.User;

import java.util.List;

public interface MessageService {
    List<Message> findAll();
    List<Message> findToFromMessage(Long id, String type);
    Message save(Message message);
    boolean delete(Long id);
}