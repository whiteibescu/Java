package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> findAllBy(Long level) {
        if (level != null) {
            return userMapper.selectUsersByLevel(level);
        } else {
            return userMapper.selectAllUsers();
        }
    }

    @Override
    public User findById(Long id) {
        return userMapper.selectUser(id);
    }

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            Long selectedUserId = userMapper.insertUser(user);
            return userMapper.selectUser(selectedUserId);
        } else {
            Long updatedUserId = userMapper.updateUser(user);
            return userMapper.selectUser(updatedUserId);
        }
    }

    @Override
    public boolean delete(Long id) {
        return userMapper.deleteUser(id);
    }
}
