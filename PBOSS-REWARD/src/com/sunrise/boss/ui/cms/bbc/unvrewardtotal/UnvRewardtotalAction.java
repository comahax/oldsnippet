/**
* auto-generated code
* Wed Sep 02 10:14:50 CST 2009
*/
package com.sunrise.boss.ui.cms.bbc.unvrewardtotal;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.bbc.unvrewardtotal.persistent.UnvRewardtotalListVO;
import com.sunrise.boss.business.cms.bbc.unvrewardtotal.persistent.UnvRewardtotalVO;
import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.bbc.unvrewardtotal.UnvRewardtotalDelegate;
import com.sunrise.boss.delegate.cms.reward.rewardconf.RewardconfDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: UnvRewardtotalAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class UnvRewardtotalAction extends BaseDelegateAction {
	
    public UnvRewardtotalAction() {
            setVoClass(UnvRewardtotalVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "totalid"; 
    }
    
    public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	SimpleDateFormat format=new SimpleDateFormat("yyyyMM");
    	
    	Calendar ca = Calendar.getInstance(Locale.CHINA);
    	ca.add(Calendar.MONTH, -1);
    	((UnvRewardtotalForm)actionForm).set_se_rewardmonth(format.format(ca.getTime()));
    	return doList(actionMapping, actionForm, request, response, user);
    }
    
    /**
     * 判断工号是否有全省审核权限
     * @param actionMapping
     * @param actionForm
     * @param request
     * @param response
     * @param user
     * @return
     * @throws Exception
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
    
    /**
     * 显示已出账确认的批次号对应的明细记录
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
    	if(!this.doCheckRewardMonth(actionMapping, actionForm, request, response, user)){
    		UnvRewardtotalForm form = (UnvRewardtotalForm) actionForm;
    		Page.setPageSize(request, form);
    		RewardconfDelegate delegate = new RewardconfDelegate();
    		UnvRewardtotalDelegate recorddelegate = new UnvRewardtotalDelegate();
    		UnvRewardtotalListVO listvo = new UnvRewardtotalListVO();
    		this.setListVO(listvo, form);
    		List list = delegate.doCheckRewardconf(form.get_se_rewardmonth(),
    				"UNPB", user);
    		List listAll = delegate.doCheckUnRewardconf(form.get_se_rewardmonth(),
    				"UNPB", user);
    		if (listAll.size() > list.size() && list.size()!=0 && listAll.size()!=0) {
    			listvo.set_sin_batchno(list);
        		DataPackage dp = recorddelegate.doQuery(listvo, user);
        		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
        		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "当前结算月[" + form.get_se_rewardmonth() + "]酬金仍有部分批次未出账确认,未出账确认的批次记录不能查询!");
    		}else if(listAll.size()==list.size()&& list.size()!=0 && listAll.size()!=0){
    			listvo.set_sin_batchno(list);
        		DataPackage dp = recorddelegate.doQuery(listvo, user);
        		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
    		}else if(list.size()==0){
    			DataPackage dp = new DataPackage();
    			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
    			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "当前结算月["
    					+ form.get_se_rewardmonth() + "]酬金批次并无出账确认!");
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
		export.setFileName("全员代理酬金计算结果总表查询");
		export.addOutputProperty("totalid");
		export.addOutputProperty("wayid");
		export.addOutputProperty("wayid", CommonExportBean.CODE2NAME,
				"#WAY");
		export.addOutputProperty("rewardtype", CommonExportBean.CODE2NAME,
				"#CH_BBCREWARDTYPE");
		export.addOutputProperty("rewardmonth");
		export.addOutputProperty("paymoney");
		export.addOutputProperty("batchno");

		export.voClassArray = new Class[] { UnvRewardtotalVO.class };
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(
				fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain");
		export.writeTxtTitle(response.getOutputStream(), new String[] {
			"酬金总表标识","代理商编码","代理商名称","酬金类型","结算月份","酬金总额","批次号"});
		
		BaseActionForm baseActionForm = (BaseActionForm) actionForm;
		baseActionForm.set_orderby("totalid");
		
    	if(!this.doCheckRewardMonth(actionMapping, actionForm, request, response, user)){
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
