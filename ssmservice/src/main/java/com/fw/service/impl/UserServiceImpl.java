package com.fw.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fw.service.UserService;
import com.ssm.entity.User;
import com.ssm.mapper.UserMapper;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserMapper userMapper;

	@Override
	public User getUserById(Integer id) throws Exception {
		System.out.println("--------------------");
		return this.userMapper.getUserById(id);
	}
	
	
}
