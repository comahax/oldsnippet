/**
* auto-generated code
* Mon Dec 08 10:50:04 CST 2008
*/
package com.sunrise.boss.ui.cms.bbc.bbcrewardtotal;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.bbc.bbcrewardtotal.persistent.BbcRewardtotalListVO;
import com.sunrise.boss.business.cms.bbc.bbcrewardtotal.persistent.BbcRewardtotalVO;
import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.bbc.bbcrewardtotal.BbcRewardtotalDelegate;
import com.sunrise.boss.delegate.cms.reward.rewardconf.RewardconfDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: WayintegraltransruleAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: SUNRISE Tech Ltd.</p>
 * @author Zhang Fengchao
 * @version 1.0
 */
public class BbcRewardtotalAction extends BaseDelegateAction {
    public BbcRewardtotalAction() {
           //���¼��������Ǳ���� 
           //ָ��VO�� 
            setVoClass(BbcRewardtotalVO.class);
            //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ����� 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "totalid"; 
    }
    
    public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	SimpleDateFormat format=new SimpleDateFormat("yyyyMM");
    	
    	Calendar ca = Calendar.getInstance(Locale.CHINA);
    	ca.add(Calendar.MONTH, -1);
    	((BbcRewardtotalForm)actionForm).set_se_rewardmonth(format.format(ca.getTime()));
    	return doList(actionMapping, actionForm, request, response, user);
    }
    
    /**
	 * ���ӶԲ�ѯ������"������"�Ƿ��ѳ���ȷ���ж�,����ActionForword��Ҫ��������ж�
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @���� CR_AA200902251_574398 
	 */
	public boolean doCheckRewardMonth(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		ProvincialrightVO rightvo = new ProvincialrightVO();
		rightvo.setProopr(user.getOpercode());
		rightvo.setRightid("CH_B2M_REWARDCONF");
		CommonDelegate delegate = new CommonDelegate(ProvincialrightVO.class);
		rightvo = (ProvincialrightVO) delegate.doFindByPk(rightvo, user);
		if(rightvo == null){
			return false;
		}else{
			return true;
		}
	}
    
    public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	SimpleDateFormat format=new SimpleDateFormat("yyyyMM");
//    	�����������·ݲ���Ϊ�յ�����.by Jerimy && Liminghao
//    	if (((BbcRewardtotalForm)actionForm).get_se_rewardmonth()==null || "".equals(((BbcRewardtotalForm)actionForm).get_se_rewardmonth())) {
//    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "�����·ݲ���Ϊ��!");
//    		Calendar ca = Calendar.getInstance(Locale.CHINA);
//        	ca.add(Calendar.MONTH, -1);
//    		((BbcRewardtotalForm)actionForm).set_se_rewardmonth(format.format(ca.getTime()));
//			return actionMapping.findForward("list");
//    	}
    	
    	if(!this.doCheckRewardMonth(actionMapping, actionForm, request, response, user)){
    		BbcRewardtotalForm form = (BbcRewardtotalForm) actionForm;
    		RewardconfDelegate delegate = new RewardconfDelegate();
    		BbcRewardtotalDelegate totaldelegate = new BbcRewardtotalDelegate();
    		BbcRewardtotalListVO listvo = new BbcRewardtotalListVO();
    		this.setListVO(listvo, form);
    		List list = delegate.doCheckRewardconf(form.get_se_rewardmonth(),
    				"B2M", user);
    		List listAll = delegate.doCheckUnRewardconf(form.get_se_rewardmonth(),
    				"B2M", user);
    		if (listAll.size() > list.size() && list.size()!=0 && listAll.size()!=0) {
    			listvo.set_sin_batchno(list);
    			listvo.set_sql_ossrc(form.get_sql_ossrc());
        		DataPackage dp = totaldelegate.doQuery(listvo, user);
        		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
        		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "��ǰ������[" + form.get_se_rewardmonth() + "]������в�������δ����ȷ��,δ����ȷ�ϵ����μ�¼���ܲ�ѯ!");
    		}else if(listAll.size()==list.size()&& list.size()!=0 && listAll.size()!=0){
    			listvo.set_sin_batchno(list);
    			listvo.set_sql_ossrc(form.get_sql_ossrc());
        		DataPackage dp = totaldelegate.doQuery(listvo, user);
        		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
    		}else if(list.size()==0){
    			DataPackage dp = new DataPackage();
    			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
    			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "��ǰ������["
    					+ form.get_se_rewardmonth() + "]������β��޳���ȷ��!");
    			return actionMapping.findForward("list");
    		}
    		return actionMapping.findForward("list");
		}else{
			return super.doList(actionMapping, actionForm, request, response, user);
		}
    	
    }
    
    public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	
    	CommonExportBean export = new CommonExportBean(user);
		export.setFileName("B2M��վ���������ܱ��ѯ");
		export.addOutputProperty("totalid");
		export.addOutputProperty("wayid");
		export.addOutputProperty("wayname");
		export.addOutputProperty("countycompname");
		export.addOutputProperty("starlevel", CommonExportBean.CODE2NAME,
				"#CH_STARLEVEL");
		export.addOutputProperty("rewardtype", CommonExportBean.CODE2NAME,
				"#CH_BBCREWARDTYPE");
		export.addOutputProperty("rewardmonth");
		export.addOutputProperty("paymoney");
		export.addOutputProperty("ossrc", CommonExportBean.CODE2NAME,
				"#CH_BBC_OSSRC");
		export.addOutputProperty("batchno");

		export.voClassArray = new Class[] { BbcRewardtotalVO.class };
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(
				fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain");
		export.writeTxtTitle(response.getOutputStream(), new String[] {
				"����ܱ��ʶ", "������ʶ","��������","�ֹ�˾����","�����Ǽ�",
				"�������", "�����·�", "����ܶ�","ҵ��ƽ̨��Դ","���κ�" });
    	
		BaseActionForm baseActionForm = (BaseActionForm) actionForm;
		baseActionForm.set_orderby("totalid");
		
    	if (!this.doCheckRewardMonth(actionMapping, actionForm, request,
				response, user)) {
			this.doList(actionMapping, actionForm, request, response, user);
			super.ExportQuery(actionMapping, actionForm, request, response,
					user, export);
		} else {
			super.ExportQuery(actionMapping, actionForm, request, response,
					user, export);
		}
		return actionMapping.findForward(null);
	}
}
