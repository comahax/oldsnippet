package com.sunrise.boss.ui.example.login;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.admin.logincase.persistent.*;
import com.sunrise.boss.common.utils.bean.*;
import com.sunrise.boss.delegate.admin.logincase.*;
import com.sunrise.boss.ui.admin.logincase.*;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

public class LoginAction extends Action {

	private static final String MODULE = "module"; // 分区模块

	private static final String OPERCODE = "opercode"; //操作员工号

	private static final String WAYID = "wayid"; //操作元所属渠道

	private static final String CITYID = "cityid"; //操作员所属区域的市标识

	private static final String PROVINCE_FLAG_HW = "999"; // 华为省工号标识
	
	private static final String PROVINCE_FLAG_CX = "100"; // 从兴省工号标识
	
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// 获取参数
		String opercode = request.getParameter(OPERCODE);
		String wayid = request.getParameter(WAYID);
		String cityid = request.getParameter(CITYID);
		String module = request.getParameter(MODULE);
		if (opercode == null || cityid == null || wayid == null) {
			return actionMapping.findForward("error");
		}
		opercode = opercode.trim();
		wayid = wayid.trim();
		cityid = cityid.trim();

		// 设置user
		User user = new User();
		user.setOpercode(opercode);
		user.setWayid(wayid);
		user.setCityid(cityid);
		if (PROVINCE_FLAG_HW.equals(cityid) || PROVINCE_FLAG_CX.equals(cityid)) {
			user.setProvinceUser(true);
		}
		user.setLogintime(new Date());
		request.getSession().setAttribute(WebConstant.SESSION_ATTRIBUTE_USER,user);

		// 添加登录用例
		try {
			LogincaseDelegate delegate = new LogincaseDelegate();
			LogincaseVO logincaseVO = new LogincaseVO();

			logincaseVO.setOperid(opercode);
			logincaseVO.setCityid(wayid);
			logincaseVO.setWayid(cityid);
			if (module != null)
				logincaseVO.setModule(module);

			if (delegate.doFindByPk(logincaseVO, user) == null) {
				delegate.doCreate(logincaseVO, user);
			}
		} catch (Exception ex) {
			// 添加用例出错时忽略
		}
		return actionMapping.findForward("success");
	}
}
