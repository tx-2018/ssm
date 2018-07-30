package com.fw.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.fw.entity.BaseEmp;
import com.fw.mapper.BaseEmpMapper;
import com.fw.service.BaseEmpService;

@Service("baseEmpService")
public class BaseEmpServiceImpl implements BaseEmpService{
	
	@Autowired
	private BaseEmpMapper baseEmpMapper;

	@Cacheable(value="user",key="'user'+#id.toString()")
	@Override
	public BaseEmp getById(Long id) throws Exception {
//		BaseEmp baseEmp = this.baseEmpMapper.getById(id);
		System.out.println("1----------------");
		BaseEmp baseEmp = new BaseEmp();
		baseEmp.setEmpId(1l);
		baseEmp.setEmpName("test");
		baseEmp.setCreateDate(new Date());
		return baseEmp;
	}

	@Override
	public List<BaseEmp> list(String empName) throws Exception {
		return baseEmpMapper.list(empName);
	}
	
	
}
