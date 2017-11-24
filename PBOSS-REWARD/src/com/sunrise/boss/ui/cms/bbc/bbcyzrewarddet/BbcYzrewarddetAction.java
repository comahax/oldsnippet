/**
* auto-generated code
* Mon Nov 16 17:27:59 CST 2009
*/
package com.sunrise.boss.ui.cms.bbc.bbcyzrewarddet;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.bbc.bbcyzrewarddet.persistent.BbcYzrewarddetListVO;
import com.sunrise.boss.business.cms.bbc.bbcyzrewarddet.persistent.BbcYzrewarddetVO;
import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.bbc.bbcyzrewarddet.BbcYzrewarddetDelegate;
import com.sunrise.boss.delegate.cms.reward.rewardconf.RewardconfDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: BbcYzrewarddetAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class BbcYzrewarddetAction extends BaseDelegateAction {
    public BbcYzrewarddetAction() {
            setVoClass(BbcYzrewarddetVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[5]; 
           pkNameArray[0] = "batchno"; 
           pkNameArray[1] = "cityid"; 
           pkNameArray[2] = "rptmon"; 
           pkNameArray[3] = "tztype"; 
           pkNameArray[4] = "wayid"; 
    }
    
    public boolean doCheckRewardMonth(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

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
    
    public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");

		Calendar ca = Calendar.getInstance(Locale.CHINA);
		ca.add(Calendar.MONTH, -1);
		((BbcYzrewarddetForm) actionForm).set_ne_rptmon(format.format(ca
				.getTime()));
		return doList(actionMapping, actionForm, request, response, user);
	}
    
    public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	if (!this.doCheckRewardMonth(actionMapping, actionForm, request,
				response, user)) {
    		BbcYzrewarddetForm form = (BbcYzrewarddetForm) actionForm;
    		RewardconfDelegate delegate = new RewardconfDelegate();
    		BbcYzrewarddetDelegate totaldelegate = new BbcYzrewarddetDelegate();
    		BbcYzrewarddetListVO listvo = new BbcYzrewarddetListVO();
    		this.setListVO(listvo, form);
    		List list = delegate.doCheckRewardconf(form.get_ne_rptmon(),
    				"B2M", user);
    		List listAll = delegate.doCheckUnRewardconf(form.get_ne_rptmon(),
    				"B2M", user);
    		if (listAll.size() > list.size() && list.size()!=0 && listAll.size()!=0) {
    			listvo.set_sin_batchno(list);
    			listvo.set_sql_tztype(form.get_sql_tztype());
        		DataPackage dp = totaldelegate.doQuery(listvo, user);
        		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
        		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "当前结算月[" + form.get_ne_rptmon() + "]酬金仍有部分批次未出账确认,未出账确认的批次记录不能查询!");
    		}else if(listAll.size()==list.size()&& list.size()!=0 && listAll.size()!=0){
    			listvo.set_sin_batchno(list);
    			listvo.set_sql_tztype(form.get_sql_tztype());
        		DataPackage dp = totaldelegate.doQuery(listvo, user);
        		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
    		}else if(list.size()==0){
    			DataPackage dp = new DataPackage();
    			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
    			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "当前结算月["
    					+ form.get_ne_rptmon() + "]酬金批次并无出账确认!");
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
		export.setFileName("优质网站酬金明细查询");
		export.addOutputProperty("rptmon");
		export.addOutputProperty("wayid");
		export.addOutputProperty("wayid", CommonExportBean.CODE2NAME,
				"#BBCWAY");
		export.addOutputProperty("tztype", CommonExportBean.CODE2NAME,
				"#CH_BBC_OSSRC");
		export.addOutputProperty("cityid", CommonExportBean.CODE2NAME,
				"#CITYCOMPANY");
		export.addOutputProperty("num");
		export.addOutputProperty("yzreward");
		export.addOutputProperty("adjreward");
		export.addOutputProperty("batchno");
		export.voClassArray = new Class[] { BbcYzrewarddetVO.class };
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(
				fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain");
		export.writeTxtTitle(response.getOutputStream(), new String[] {
				"统计时间", "网站标识", "网站名称", "网站拓展商类型", "市公司", "业务量", "优质网站酬金",
				"酬金调整项", "批次号" });
		

		if (!this.doCheckRewardMonth(actionMapping, actionForm, request,
				response, user)) {
			this.doList(actionMapping, actionForm, request, response, user);
			super.ExportQuery(actionMapping, actionForm, request, response, user,
					export);
		}else{
			super.ExportQuery(actionMapping, actionForm, request, response, user,
					export);
		}
		return actionMapping.findForward(null);
    }
}
