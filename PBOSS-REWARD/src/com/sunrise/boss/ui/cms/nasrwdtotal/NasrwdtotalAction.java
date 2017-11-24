/**
 * auto-generated code
 * Mon Jun 29 11:25:27 CST 2009
 */
package com.sunrise.boss.ui.cms.nasrwdtotal;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.nasrwdtotal.persistent.NasrwdtotalListVO;
import com.sunrise.boss.business.cms.nasrwdtotal.persistent.NasrwdtotalVO;
import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightVO;
import com.sunrise.boss.business.cms.reward.rewardconf.persistent.RewardconfVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.nasrwdtotal.NasrwdtotalDelegate;
import com.sunrise.boss.delegate.cms.reward.rewardconf.RewardconfDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: NasrwdtotalAction
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Jerimy
 * @version 1.0
 */
public class NasrwdtotalAction extends BaseAction {
	public NasrwdtotalAction() {
		this.voClass = NasrwdtotalVO.class;
		// TODO: ������������������
		this.pkNameArray = new String[] { null };
	}

	/**
	 * �鿴��Ϣ
	 */
	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		SimpleDateFormat format1=new SimpleDateFormat("yyyyMM");
		if (((NasrwdtotalForm)actionForm).get_se_rewardmonth()==null || "".equals(((NasrwdtotalForm)actionForm).get_se_rewardmonth())) {
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "�����·ݲ���Ϊ��!");
    		Calendar ca = Calendar.getInstance(Locale.CHINA);
        	ca.add(Calendar.MONTH, -1);
    		((NasrwdtotalForm)actionForm).set_se_rewardmonth(format1.format(ca.getTime()));
			return actionMapping.findForward("list");
    	}
		if (!this.doCheckRewardMonth(actionMapping, actionForm, request,
				response, user)) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"��ǰ����·ݳ��δ����ȷ�ϻ��ʡ������ȷ�ϲ������ţ��ݲ��ܲ�ѯ(����)!");
			return actionMapping.findForward("list");
		}
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("B2M���˳�������");
		export.appendHeadLine(new String[] { "��������:", user.getOpercode() });
		export
				.appendHeadLine(new String[] { "����ʱ��",
						format.format(new Date()) });
		export.addOutputProperty("totalid", "����ܱ��ʶ");
		export.addOutputProperty("wayid", "��������");
		export.addOutputProperty("wayid", "��������", CommonExportBean.CODE2NAME,
				"#BBCWAY");
		export.addOutputProperty("rewardtype", "�������",
				CommonExportBean.CODE2NAME, "#CH_BBCREWARDTYPE");
		export.addOutputProperty("rewardmonth", "�����·�");
		export.addOutputProperty("paymoney", "����ܶ�");
		export.voClassArray = new Class[] { NasrwdtotalVO.class };
		
		response.setCharacterEncoding("GBK");
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(
				fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain;charset=gbk");
		export.writeTxtTitle(response.getOutputStream(), new String[] {
				"����ܱ��ʶ", "������ʶ", "��������", "�������", "�����·�", "����ܶ�" });
		super.ExportQuery(actionMapping, actionForm, request, response, user,
				export);
		return actionMapping.findForward(null);
	}

	/**
	 * ���ӶԲ�ѯ������"������"�Ƿ��ѳ���ȷ���ж�,����ActionForword��Ҫ��������ж�
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @���� CR_AA200901091_551119
	 */
	public boolean doCheckRewardMonth(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		NasrwdtotalForm form = (NasrwdtotalForm) actionForm;
		RewardconfVO confvo = new RewardconfVO();
		confvo.setRewardkind("B2M");
		confvo.setRewardmonth(form.get_se_rewardmonth().trim());
		confvo.setCityid(user.getCityid());
		RewardconfDelegate confdelegate = new RewardconfDelegate();
		confvo = confdelegate.doFindByPk(confvo, user);
		if (confvo != null) {
			if (confvo.getState().shortValue() == 1) {
				return true;
			}
		}
		ProvincialrightVO rightvo = new ProvincialrightVO();
		rightvo.setProopr(user.getOpercode());
		rightvo.setRightid("CH_B2M_REWARDCONF");
		CommonDelegate delegate = new CommonDelegate(ProvincialrightVO.class);
		rightvo = (ProvincialrightVO) delegate.doFindByPk(rightvo, user);
		if (rightvo == null) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * ��ѯ
	 */
	protected ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		SimpleDateFormat format=new SimpleDateFormat("yyyyMM");
		if (((NasrwdtotalForm)actionForm).get_se_rewardmonth()==null || "".equals(((NasrwdtotalForm)actionForm).get_se_rewardmonth())) {
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "�����·ݲ���Ϊ��!");
    		Calendar ca = Calendar.getInstance(Locale.CHINA);
        	ca.add(Calendar.MONTH, -1);
    		((NasrwdtotalForm)actionForm).set_se_rewardmonth(format.format(ca.getTime()));
			return actionMapping.findForward("list");
    	}
		
		if (!this.doCheckRewardMonth(actionMapping, actionForm, request,
				response, user)) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"��ǰ����·ݳ��δ����ȷ�ϻ��ʡ������ȷ�ϲ������ţ��ݲ��ܲ�ѯ(����)!");
			return actionMapping.findForward("list");
		}
		Page.setPageSize(request, (BaseActionForm) actionForm);
		NasrwdtotalListVO listVO = new NasrwdtotalListVO();
		// BeanUtils.copyProperties(listVO, actionForm);
		setListVO(listVO, actionForm); // ���ú�listVO����OrdinaryΪ��ѯ����
		NasrwdtotalDelegate delegate = new NasrwdtotalDelegate();
		DataPackage dp = delegate.doQuery(listVO, user);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		return (actionMapping.findForward("list"));
	}
	  public ActionForward doShow(ActionMapping actionMapping,
				ActionForm actionForm, HttpServletRequest request,
				HttpServletResponse response, User user) throws Exception {
	    	SimpleDateFormat format=new SimpleDateFormat("yyyyMM");
	    	
	    	Calendar ca = Calendar.getInstance(Locale.CHINA);
	    	ca.add(Calendar.MONTH, -1);
	    	((NasrwdtotalForm)actionForm).set_se_rewardmonth(format.format(ca.getTime()));
	    	return doList(actionMapping, actionForm, request, response, user);
	    }
}
