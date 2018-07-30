package com.fw.service;

import java.util.List;

import com.fw.entity.BaseEmp;

public interface BaseEmpService {
	
	public BaseEmp getById(Long id) throws Exception;
	
	public List<BaseEmp> list(String empName) throws Exception;
}
