package com.fw.entity;

import java.io.Serializable;

public class BaseEmp implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long empId;
	private String empName;
	private String loginName;
	private String pswd;

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

	@Override
	public String toString() {
		return "BaseEmp [empId=" + empId + ", empName=" + empName + ", loginName=" + loginName + ", pswd=" + pswd + "]";
	}

}