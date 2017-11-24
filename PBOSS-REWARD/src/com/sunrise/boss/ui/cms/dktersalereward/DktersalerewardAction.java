/**
* auto-generated code
* Fri May 03 16:45:00 CST 2013
*/
package com.sunrise.boss.ui.cms.dktersalereward;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.sunrise.boss.business.cms.dktersalereward.persistent.DktersalerewardListVO;
import com.sunrise.boss.business.cms.dktersalereward.persistent.DktersalerewardVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.dktersalereward.DktersalerewardDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: DktersalerewardAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class DktersalerewardAction extends BaseAction {
    public DktersalerewardAction() {
            setVoClass(DktersalerewardVO.class);
        // TODO: ������������������
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "recid"; 
    }

    /**
	 * �����µ��ն����۳����ϸ
	 */
	@Override
	protected ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		DktersalerewardForm form = (DktersalerewardForm) actionForm;
		if (form.isQuery()) {
			form.set_ne_cityid(user.getCityid());
			DktersalerewardListVO listVO = new DktersalerewardListVO();
			BeanUtils.copyProperties(listVO, form);
			DktersalerewardDelegate delegate = new DktersalerewardDelegate();
			DataPackage dp = delegate.doQuery(listVO, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		}
    	return actionMapping.findForward("list");
	}

	/**
	 * �����µ��ն����۳����ϸ��ѯ����
	 */
	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�����µ��ն����۳����ϸ");
		export.appendHeadLine(new String[] { "��������:", user.getOpercode() });
		export.appendHeadLine(new String[] { "����ʱ��:", format.format(new Date()) });
		export.addOutputProperty("ecpoperator", "ECP����");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("salesuc", "���۳ɹ���(T-1����)");
		export.addOutputProperty("examinesuc", "���˳ɹ���(T-4����)");
		export.addOutputProperty("foundreward", "�������");
		export.addOutputProperty("examinereward", "���˳��");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		export.voClassArray = new Class[] {voClass};
		export.queryMethodName = "doList";
		if (export.headtitle == null) {
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);
    	return null;
	}

	/**
	 * �����µ��ն����۳��ͳ��
	 */
	public ActionForward doRewardtotal(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		DktersalerewardForm form = (DktersalerewardForm) actionForm;
		if (form.isQuery()) {
			DktersalerewardListVO listVO = new DktersalerewardListVO();
			BeanUtils.copyProperties(listVO, form);
			DktersalerewardDelegate delegate = new DktersalerewardDelegate();
			DataPackage dp = delegate.doQueryRewardTotal(listVO, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		}
		return actionMapping.findForward("rewardtotal");
	}

	/**
	 * �����µ��ն����۳��ͳ�Ʋ�ѯ����
	 */
	public ActionForward doExcelrewardtotal(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�����µ��ն����۳��ͳ��");
		export.appendHeadLine(new String[] { "��������:", user.getOpercode() });
		export.appendHeadLine(new String[] { "����ʱ��:", format.format(new Date()) });
		export.addOutputProperty("cityid", "����", CommonExportBean.CODE2NAME, "#CITYCOMPANY_AREA");
		export.addOutputProperty("salesuc", "���۳ɹ���(T-1����)");
		export.addOutputProperty("examinesuc", "���˳ɹ���(T-4����)");
		export.addOutputProperty("foundreward", "�������");
		export.addOutputProperty("examinereward", "���˳��");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		export.voClassArray = new Class[] {voClass};
		export.queryMethodName = "doRewardtotal";
		if (export.headtitle == null) {
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);
    	return null;
	}

	public ActionForward doImport(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		return actionMapping.findForward("import");
	}
}
