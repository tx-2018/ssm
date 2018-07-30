package com.fw.controller;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fw.entity.BaseEmp;
import com.fw.service.BaseEmpService;
  
  
@Controller  
public class BaseEmpController {  
	
	@Autowired
	private BaseEmpService baseEmpService;
      
    @RequestMapping(value="/baseEmp/getById.do")  
    @ResponseBody
    public BaseEmp getById(Long id, HttpServletResponse response) throws Exception{ 
    	System.out.println("--------------------");
        return baseEmpService.getById(id);
    }  
}  