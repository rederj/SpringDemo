package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	@Transactional(readOnly = true)
	public User getUser(int id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Transactional(readOnly = false)
	public int updateByPrimaryKey(User user) {
		return userMapper.updateByPrimaryKey(user);
	}
}