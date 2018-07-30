package com.fw.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.fw.entity.BaseEmp;

@Mapper
public interface BaseEmpMapper {

	@Select("SELECT empId,empName,loginName,pswd FROM base_emp WHERE empId=#{id}") 
	public BaseEmp getById(Long id) throws Exception;
	
	public List<BaseEmp> list(String empName) throws Exception;
	
}
