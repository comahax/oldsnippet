/**
 * auto-generated code
 * Sun Feb 1 10:32:23 CST 2009
 */
package com.sunrise.boss.ui.cms.cityrewardad;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.cityrewardad.persistent.CityrewardadVO;

/**
 * <p>Title: CityrewardadAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Li Zhaoliang
 * @version 1.0
 */
public class CityrewardadAction extends BaseDelegateAction {
	public CityrewardadAction() {
		//���¼��������Ǳ���� 
		//ָ��VO�� 
		setVoClass(CityrewardadVO.class);
		//ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ����� 
		this.pkNameArray = new String[4];
		pkNameArray[0] = "cityid";
		pkNameArray[1] = "wayid";
		pkNameArray[2] = "rewardtype";
		pkNameArray[3] = "paymonth";
	}
	
	/**
	 * ���ж���������ݵ����ѯ
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CityrewardadForm form = (CityrewardadForm) actionForm;
		//Ĭ�ϵ���Ϊ��ǰ��½����
		if (form.get_se_cityid() == null) {
			form.set_se_cityid(user.getCityid());
			//form.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
		}
		//Ĭ�Ϸ����·ݽ������򣨷����·�����ķŶ��У�
		if (StringUtils.isBlank(form.get_orderby())) {
			form.set_orderby("paymonth");
			form.set_desc("1");
		}
		return super.doList(actionMapping, actionForm, request, response, user);

	}
}
