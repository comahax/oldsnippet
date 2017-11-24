/**
 * auto-generated code
 * Thu Dec 11 16:31:58 CST 2008
 */
package com.sunrise.boss.ui.zifee.yxplansynlog;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.zifee.commons.BatchProcess;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanVO;
import com.sunrise.boss.business.zifee.yxplansynlog.persistent.YxplansynlogVO;
import com.sunrise.boss.delegate.zifee.yxplan.YxPlanDelegate;
import com.sunrise.boss.delegate.zifee.yxplansynlog.YxplansynlogDelegate;
/**
 * <p>
 * Title: YxplansynlogAction
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author Jerimy
 * @version 1.0
 */
public class YxplansynlogAction extends BaseDelegateAction {
	public YxplansynlogAction() {
		// ���¼��������Ǳ����
		// ָ��VO��
		setVoClass(YxplansynlogVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[1];
		pkNameArray[0] = "logid";
	}

	/**
	 * �ϴ�����������Ӫ�������ļ�
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @author added by yijianrong
	 */
	public ActionForward doUpload(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		YxplansynlogForm form = (YxplansynlogForm) actionForm;
		FormFile inputFile = form.getInputFile();
		if (inputFile == null) {
			request
					.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"�ϴ��ļ�����Ϊ��");
			return (actionMapping.findForward("batch"));
		}

		int sum = 0;
		int success = 0;
		int failure = 0;
		String elements = null;
		String restr = null;
		Iterator iterator = BatchProcess.getData(inputFile);
		StringBuffer result = new StringBuffer("");
		StringBuffer tmp = new StringBuffer("");
		YxPlanDelegate delegate = new YxPlanDelegate();

		while (iterator.hasNext()) {
			elements = (String) iterator.next();
			// ����ִ��Ϸ���
			String regex = "^\\d{14}$";
			// ������Ϊ0��ʾ���ͨ��
			if (elements != null && elements.matches(regex)) {
				try {
					YxPlanVO vo = delegate.doFindByPk(
							new Long(elements.trim()), user);
					if (vo != null) {
						new YxplansynlogDelegate().doCopysyn(elements, user);
					} else {
						restr = "��" + String.valueOf(sum + 1) + "��Ӫ���������󲻴���"
								+ elements;
					}
				} catch (Exception ex) {
					restr = "��" + String.valueOf(sum + 1) + "�в������ݿ�ʧ��! ";
				}

				if (restr == null) {
					success++;
				} else {
					tmp.append("��").append(sum + 1).append("�м�¼���ʱ���ִ���\r\n");
					tmp.append("ԭ��").append(restr).append("\r\n\r\n");
					failure++;
				}
			} else {
				tmp.append("��").append(sum + 1).append("��,Ӫ������ID���ִ���,����Ϊ���֣�\r\n");
				tmp.append("ԭ��").append("Ӫ������ID" + elements)
						.append("\r\n\r\n");
				failure++;
			}
			sum++;
		}

		result.append("�ܹ�").append(sum).append("����¼���ɹ�").append(success)
				.append("��,ʧ��").append(failure).append("��.\r\n\r\n");
		result.append(tmp.toString());
		form.setReInfo(result.toString());
		return (actionMapping.findForward("success"));
	}
}
