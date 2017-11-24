/**
* auto-generated code
* Fri Jul 08 09:50:15 CST 2011
*/
package com.sunrise.boss.ui.cms.salereward;

import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.reward.rulerel.persistent.RulerelListVO;
import com.sunrise.boss.business.cms.reward.rulerel.persistent.RulerelVO;
import com.sunrise.boss.business.cms.reward.salecreditstd.persistent.SalecreditstdListVO;
import com.sunrise.boss.business.cms.salereward.persistent.SalerewardListVO;
import com.sunrise.boss.business.cms.salereward.persistent.SalerewardVO;
import com.sunrise.boss.business.cms.waystrarewardstd.persistent.WaystrarewardstdListVO;
import com.sunrise.boss.business.cms.waystrarewardstd.persistent.WaystrarewardstdVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.reward.rulerel.RulerelDelegate;
import com.sunrise.boss.delegate.cms.reward.salecreditstd.SalecreditstdDelegate;
import com.sunrise.boss.delegate.cms.salereward.SalerewardDelegate;
import com.sunrise.boss.delegate.cms.waystrarewardstd.WaystrarewardstdDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.cms.reward.credittotal.CredittotalForm;
import com.sunrise.boss.ui.cms.reward.salecreditstd.SalecreditstdForm;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: SalerewardAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class SalerewardAction extends BaseAction {
    public SalerewardAction() {
            setVoClass(SalerewardVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seq"; 
    }
    
    public ActionForward doList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception{		
    	SalerewardDelegate delegate=new SalerewardDelegate();
    	SalerewardListVO listVO=new SalerewardListVO();
    	listVO.set_ne_cityid(user.getCityid());
    	DataPackage dp=delegate.doQuery(listVO, user);
    	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		return (actionMapping.findForward("list"));
    }
    
 // 保存
	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		// 设定更新时间
		SalerewardForm form = (SalerewardForm)actionForm;
		form.setOpercode(user.getOpercode());
		form.setOpertime(new Date());
		// 设定地市
		String cmdState = form.getCmdState();
		if (WebConstant.COMMAND_STRING_NEW.equals(cmdState)) {
			
			form.setOpertype("I");
			
			form.setCityid(Short.valueOf(user.getCityid()));
			
			// 每个地市同个业务类型只能有一个
			SalerewardDelegate delegate = new SalerewardDelegate();
			SalerewardListVO listvo = new SalerewardListVO();
			listvo.set_ne_cityid(user.getCityid());
//			listvo.set_ne_rewardstd(form.getRewardstd().toString());
			listvo.set_ne_slv(form.getSlv().toString());
			DataPackage dp = delegate.doQuery(listvo, user);
			if (dp != null && dp.getDatas().size() > 0) {
				request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
           		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "同一个地市同一个星级，只能有一个酬金标准。"); 
           		return (actionMapping.findForward("content"));
			}
		}else{
			
			form.setOpertype("U");
			form.setCityid(Short.valueOf(user.getCityid()));
			
			// 每个地市同个业务类型只能有一个
			SalerewardDelegate delegate = new SalerewardDelegate();
			SalerewardListVO listvo = new SalerewardListVO();
			listvo.set_ne_cityid(user.getCityid());
			listvo.set_ne_rewardstd(form.getRewardstd().toString());
			listvo.set_ne_slv(form.getSlv().toString());
			DataPackage dp = delegate.doQuery(listvo, user);
			Iterator it = dp.getDatas().iterator();
			if(it.hasNext()){
				SalerewardVO salerewardVO=(SalerewardVO)it.next();
				if(!salerewardVO.getSeq().toString().equals(form.getSeq().toString())){
					request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
	           		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "同一个地市同一个星级，只能有一个酬金标准。"); 
	           		return (actionMapping.findForward("content"));
				}
			}
			
		}
		return super.doSave(actionMapping, actionForm, request, response, user);
		
	}
    
  //规则细项设置界面
    
    
    // 查询
   	public ActionForward doDetails(ActionMapping actionMapping,
   			ActionForm actionForm, HttpServletRequest request,
   			HttpServletResponse response, User user) throws Exception {
   		
//   		添加的部分
   		RulerelDelegate rulerelDelegate=new RulerelDelegate();
   		RulerelListVO rulerellistvo = new RulerelListVO();
   		rulerellistvo.set_se_ruleid("CARD_REWARD");
   		
   		DataPackage dp2= rulerelDelegate.doQueryByRuleid(rulerellistvo, user);
//   		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
   		Iterator it = dp2.getDatas().iterator();
   		while(it.hasNext()){
   			RulerelVO vo=(RulerelVO)(it.next());
   			rulerellistvo.set_se_ruleitemid(vo.getRuleitemid());
   			rulerellistvo.set_se_ruleid(vo.getRuleid());
   			rulerellistvo.set_se_cityid(user.getCityid());
   			DataPackage dp3=rulerelDelegate.doQuery(rulerellistvo, user);
   			Iterator itor = dp3.getDatas().iterator();
   			if (itor.hasNext()) {
//   				RulerelVO vo=(RulerelVO)(itor.next());
   				vo.setParamercityvalue(((RulerelVO)(itor.next())).getParamer());
   			}
   		}
   		request.setAttribute("dp2", dp2);
   		
   		return (actionMapping.findForward("listdetails"));
   	}
   	
   	public ActionForward doSave2(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
   		SalerewardForm form=(SalerewardForm)actionForm;
		String ruleitemids[] = getRuleitemids(form); // 界面已选的RULEITEMID
//		String paramervalues[] =getParamervalues(form); // 界面上的paramer
		RulerelDelegate rulerelDelegate = new RulerelDelegate();
		RulerelVO rulerelVO=null;
		try {
			for (int i = 0; i < ruleitemids.length; i++) {
				rulerelVO=new RulerelVO();
				rulerelVO.setRuleid("CARD_REWARD");
				rulerelVO.setRulemodeid(Long.parseLong("0"));
				rulerelVO.setCityid(user.getCityid());
				rulerelVO.setRuleitemid(ruleitemids[i]);
				
				//查询"999"的paramer ,有几个分隔符"|",输入的参数是否有同样的个数
				RulerelListVO rulerelListVO1=new RulerelListVO();
				rulerelListVO1.set_se_ruleid("CARD_REWARD");
				rulerelListVO1.set_se_cityid("999");
				rulerelListVO1.set_se_ruleitemid(ruleitemids[i]);
				DataPackage dp2=rulerelDelegate.doQuery(rulerelListVO1, user);
				String sp1="";
				try {
					sp1 = ((RulerelVO)dp2.getDatas().iterator().next()).getParamer();
				} catch (RuntimeException e) {
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "省公司没有此种类型的业务!");
					return doDetails(actionMapping,actionForm, request,response,user);
				}
				String sp2=form.getParamervalues()[i];
				if( StringUtils.splitPreserveAllTokens(sp1, "|").length!= StringUtils.splitPreserveAllTokens(sp2, "|").length||!("".equals(StringUtils.splitPreserveAllTokens(sp2, "|")[StringUtils.splitPreserveAllTokens(sp2, "|").length-1])) ){
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "第"+(i+1)+"条输入的参数值个数不一致,并且要以'|'分隔!");
					return doDetails(actionMapping,actionForm, request,response,user);
				}
				
				
				rulerelVO.setParamer(form.getParamervalues()[i]);
				
				//查询有没有,有就修改
				RulerelListVO rulerelListVO=new RulerelListVO();
				rulerelListVO.set_se_ruleid("CARD_REWARD");
				rulerelListVO.set_se_cityid(user.getCityid());
				rulerelListVO.set_ne_rulemodeid(Long.parseLong("0"));
				rulerelListVO.set_se_ruleitemid(ruleitemids[i]);
				DataPackage dp=rulerelDelegate.doQuery(rulerelListVO, user);
				Iterator itor = dp.getDatas().iterator();
				if (itor.hasNext()) {
					rulerelVO.setParamer(form.getParamervalues()[i]);
					rulerelDelegate.doUpdate2(rulerelVO, user);
				}else{
					rulerelDelegate.doCreate(rulerelVO, user);
				}
			}
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
		}
		
//		return (actionMapping.findForward("listdetails"));
		return doDetails(actionMapping,actionForm, request,response,user);
	}
   	
   	/**
	 * 只包含界面上选择的数据
	 * 
	 * @param form
	 * @return
	 */
	private String[] getRuleitemids(SalerewardForm form) {
		String[] ids = form.getRuleitemids();
		if (ids == null || ids.length == 0) {
			return new String[0];
		}
		String[] ruleitemids = new String[ids.length];
		for (int i = 0; i < ids.length; i++) {
			String id = ids[i];
			String tempid[] = id.split("\\|");
			ruleitemids[i] = tempid[0];
		}
		return ruleitemids;
	}
	/**
	 * 只包含界面上选择的数据
	 * 
	 * @param form
	 * @return
	 */
	private String[] getParamervalues(SalerewardForm form) {
		String[] ids = form.getParamervalues();
		if (ids == null || ids.length == 0) {
			return new String[0];
		}
		String[] paramervalues = new String[ids.length];
		for (int i = 0; i < ids.length; i++) {
			String id = ids[i];
			String tempid[] = id.split("\\|");
			paramervalues[i] = tempid[0];
		}
		return paramervalues;
	}
    
}
