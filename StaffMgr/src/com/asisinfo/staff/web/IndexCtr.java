package com.asisinfo.staff.web;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.asisinfo.common.utils.RequestUtils;
import com.asisinfo.common.web.BaseController;
import com.asisinfo.common.web.ResultMap;
import com.asisinfo.staff.WebConstant;
import com.asisinfo.staff.bean.EmployeesNumber;
import com.asisinfo.staff.service.EmployeesService;


public class IndexCtr extends BaseController {
	
	
	private EmployeesService employeesService;
	
	public String index(HttpServletRequest request,
			HttpServletResponse response){
		return "index";
	}
	
	public ResultMap logout(HttpServletRequest request,
			HttpServletResponse response){
		HttpSession session = request.getSession();
		session.invalidate();
		return ResultMap.defaultResultMap();
	}

	
	public ResultMap login(HttpServletRequest request,
			HttpServletResponse response){
		ResultMap result = ResultMap.defaultResultMap();
		//登录员工账号
		String svrnum = RequestUtils.getStringParam(request, "svrnum", "");
		EmployeesNumber loginauth=employeesService.login(svrnum);
		if(loginauth == null){
			result.fails("登陆员工不存在");
			return result;
		}
			String loginperm = employeesService.getPermit(loginauth.getStaffid());
			
	        String names=loginauth.getStaffname();
	        String staffattr=loginauth.getStaffattr();
	        request.getSession().setAttribute("attr", staffattr);
	        
		request.getSession().setAttribute(WebConstant.USER_IN_SESSION, loginauth);
		request.getSession().setAttribute("loginperm", loginperm);
		String url=request.getRequestURI().toString();
		request.getSession().setAttribute("url", url);
		request.getSession().setAttribute("names", names);
		return result;
	}

	public EmployeesService getEmployeesService() {
		return employeesService;
	}

	public void setEmployeesService(EmployeesService employeesService) {
		this.employeesService = employeesService;
	}
	
	

}