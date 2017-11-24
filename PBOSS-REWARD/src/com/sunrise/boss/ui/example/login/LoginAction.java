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

	private static final String MODULE = "module"; // ����ģ��

	private static final String OPERCODE = "opercode"; //����Ա����

	private static final String WAYID = "wayid"; //����Ԫ��������

	private static final String CITYID = "cityid"; //����Ա����������б�ʶ

	private static final String PROVINCE_FLAG_HW = "999"; // ��Ϊʡ���ű�ʶ
	
	private static final String PROVINCE_FLAG_CX = "100"; // ����ʡ���ű�ʶ
	
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// ��ȡ����
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

		// ����user
		User user = new User();
		user.setOpercode(opercode);
		user.setWayid(wayid);
		user.setCityid(cityid);
		if (PROVINCE_FLAG_HW.equals(cityid) || PROVINCE_FLAG_CX.equals(cityid)) {
			user.setProvinceUser(true);
		}
		user.setLogintime(new Date());
		request.getSession().setAttribute(WebConstant.SESSION_ATTRIBUTE_USER,user);

		// ��ӵ�¼����
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
			// �����������ʱ����
		}
		return actionMapping.findForward("success");
	}
}
