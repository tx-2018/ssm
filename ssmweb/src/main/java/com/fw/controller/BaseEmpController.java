package com.fw.controller;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fw.entity.BaseEmp;
import com.fw.service.BaseEmpService;
  
  
@Controller  
public class BaseEmpController {  
	
	private Logger logger = LoggerFactory.getLogger(BaseEmpController.class);
	
	@Autowired
	private BaseEmpService baseEmpService;
    
    @RequestMapping(value="/baseEmp/getById.do")  
    @ResponseBody
    public BaseEmp getById(Long id, HttpServletResponse response) throws Exception{ 
    	logger.info("查询员工");
        return baseEmpService.getById(id);
    }  
    
    @RequestMapping(value="/baseEmp/list.do")  
    @ResponseBody
    public String list( @Valid BaseEmp baseEmp, HttpServletResponse response) throws Exception{ 
    	logger.info("查询员工列表");
        return "1";
    }  
}  