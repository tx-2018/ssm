package com.fw.service;

import com.ssm.entity.User;

public interface UserService {
	
	public User getUserById(Integer id) throws Exception;
}
