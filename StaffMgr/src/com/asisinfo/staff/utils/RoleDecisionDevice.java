package com.asisinfo.staff.utils;

import javax.servlet.http.HttpSession;

import org.jfree.util.Log;

import com.asisinfo.staff.WebConstant;
import com.asisinfo.staff.bean.EmployeesNumber;


/**
 * 角色判决器
 * @author LHC
 *
 */
public class RoleDecisionDevice {
	
	/**
	 * cityadmin:员工归属管理员
	 * gdadmin：全省管理员
	 * staff：一般职员
	 */
	public enum Role {
		cityadmin,gdadmin,staff
	}

	
	/**
	 * 获取当前登录用户的角色
	 * @return 枚举类型的角色
	 */
	public static Role getLoginUserRole(){
		try {
			HttpSession session = RequestHolder.getHttpServletRequest().getSession();
			String loginperm = (String) session.getAttribute("loginperm");
			if ("cityadmin".equals(loginperm)) {
				return Role.cityadmin;
			}else if ("gdadmin".equals(loginperm)) {
				return Role.gdadmin;
			}else if ("staff".equals(loginperm)) {
				return Role.staff;
			}
		} catch (Exception e) {
			Log.info("check permit error:"+ e.getMessage());
		}
		return Role.staff;
	}
	/**
	 * 获取当前登录用户
	 * @return
	 */
	public static EmployeesNumber getLoginUser(){
		HttpSession session = RequestHolder.getHttpServletRequest().getSession();
		EmployeesNumber emp = (EmployeesNumber)session.getAttribute(WebConstant.USER_IN_SESSION);
		return emp;
	}
}
