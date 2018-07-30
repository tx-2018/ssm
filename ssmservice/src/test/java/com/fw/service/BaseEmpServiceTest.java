package com.fw.service;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fw.BaseJunit4Test;


public class BaseEmpServiceTest extends BaseJunit4Test {
    
    @Autowired
    private BaseEmpService baseEmpService;
    
    @Test   
    public void getById() {
        try {
        	baseEmpService.getById(4l);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @Test   
    public void list() {
        try {
			System.out.println(baseEmpService.list("11"));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
}