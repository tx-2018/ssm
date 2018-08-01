package com.fw.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class BaseEmp implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long empId;
	@NotNull
	private String empName;
	private String loginName;
	private String pswd;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	//@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date createDate;

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "BaseEmp [empId=" + empId + ", empName=" + empName + ", loginName=" + loginName + ", pswd=" + pswd + "]";
	}

}