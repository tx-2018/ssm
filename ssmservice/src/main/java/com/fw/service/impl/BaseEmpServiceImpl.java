package com.fw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fw.entity.BaseEmp;
import com.fw.mapper.BaseEmpMapper;
import com.fw.service.BaseEmpService;

@Service("baseEmpService")
public class BaseEmpServiceImpl implements BaseEmpService{
	
	@Autowired
	private BaseEmpMapper baseEmpMapper;

	@Override
	public BaseEmp getById(Long id) throws Exception {
		return this.baseEmpMapper.getById(id);
	}
	
	
}
