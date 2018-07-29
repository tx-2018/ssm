package com.fw.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fw.service.UserService;
  
  
@Controller  
@RequestMapping("/user")  
public class UserController {  
	
	@Resource
	private UserService userService;
	
      
    @RequestMapping(value="/test.do")  
    public String test(HttpServletRequest request,Model model) throws Exception{ 
    	System.out.println("--------------------");
    	userService.getUserById(1);
    	
        return "index";  
    }  
}  