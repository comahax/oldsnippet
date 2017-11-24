/**
* auto-generated code
* Wed May 18 10:32:19 CST 2011
*/
package com.sunrise.boss.ui.cms.reward.salecreditstd;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.reward.ruleitem.persistent.RuleitemListVO;
import com.sunrise.boss.business.cms.reward.ruleitem.persistent.RuleitemVO;
import com.sunrise.boss.business.cms.reward.rulerel.persistent.RulerelListVO;
import com.sunrise.boss.business.cms.reward.rulerel.persistent.RulerelVO;
import com.sunrise.boss.business.cms.reward.salecreditstd.persistent.SalecreditstdListVO;
import com.sunrise.boss.business.cms.reward.salecreditstd.persistent.SalecreditstdVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.reward.rule.RuleDelegate;
import com.sunrise.boss.delegate.cms.reward.ruleitem.RuleitemDelegate;
import com.sunrise.boss.delegate.cms.reward.rulerel.RulerelDelegate;
import com.sunrise.boss.delegate.cms.reward.salecreditstd.SalecreditstdDelegate;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.cms.reward.rulerel.RulerelForm;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: SalecreditstdAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class SalecreditstdAction extends BaseDelegateAction {
    public SalecreditstdAction() {
            setVoClass(SalecreditstdVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seq"; 
    }
    
    // 查询
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// 设定查询地市
		SalecreditstdForm form = (SalecreditstdForm)actionForm;
		form.set_ne_cityid(user.getCityid());
		
//		添加的部分
//		RulerelDelegate rulerelDelegate=new RulerelDelegate();
//		RulerelListVO rulerellistvo = new RulerelListVO();
//		DataPackage dp2= rulerelDelegate.doQuery4(rulerellistvo, user);
////		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
//		Iterator it = dp2.getDatas().iterator();
//		while(it.hasNext()){
//			RulerelVO vo=(RulerelVO)(it.next());
//			rulerellistvo.set_se_ruleitemid(vo.getRuleitemid());
//			rulerellistvo.set_se_ruleid(vo.getRuleid());
//			rulerellistvo.set_se_cityid(user.getCityid());
//			DataPackage dp3=rulerelDelegate.doQuery(rulerellistvo, user);
//			Iterator itor = dp3.getDatas().iterator();
//			if (itor.hasNext()) {
////				RulerelVO vo=(RulerelVO)(itor.next());
//				vo.setParamercityvalue(((RulerelVO)(itor.next())).getParamer());
//			}
//		}
//		request.setAttribute("dp2", dp2);
		
		return super.doList(actionMapping, actionForm, request, response, user);
	}
	
	public ActionForward doDetails(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		List ruleitemlist=new ArrayList();
		
//		添加的部分
		RulerelDelegate rulerelDelegate=new RulerelDelegate();
		RulerelListVO rulerellistvo = new RulerelListVO();
		rulerellistvo.set_pagesize("");
		DataPackage dp2= rulerelDelegate.doQuery4(rulerellistvo, user);
//		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		Iterator it = dp2.getDatas().iterator();
		while(it.hasNext()){
			RulerelVO vo=(RulerelVO)(it.next());
			
			ruleitemlist.add(vo.getRuleitemid());
			
			rulerellistvo.set_se_ruleitemid(vo.getRuleitemid());
			rulerellistvo.set_se_ruleid(vo.getRuleid());
			rulerellistvo.set_se_cityid(user.getCityid());
			DataPackage dp3=rulerelDelegate.doQuery(rulerellistvo, user);
			Iterator itor = dp3.getDatas().iterator();
			if (itor.hasNext()) {
//				RulerelVO vo=(RulerelVO)(itor.next());
//				vo.setParamercityvalue(((RulerelVO)(itor.next())).getParamer());
				String vvv = ((RulerelVO)(itor.next())).getParamer();
				if(!"".equals(vvv)&&null!=vvv){
					
//					System.out.println("======rr===="+vvv.trim()+"GGG");
					vo.setParamercityvalue(vvv.trim());
				}
				vo.setIsSelected(new Short("1"));
			}
		}
		Set ruleitemsetnew=new HashSet();
		for(int i=0;i<ruleitemlist.size();i++){
			Set set =new HashSet();
			RuleitemDelegate delegate =new RuleitemDelegate();
			RuleitemListVO listVO=new RuleitemListVO();
			listVO.set_pagesize("");
			listVO.set_se_ruleitemid((String)ruleitemlist.get(i));
			DataPackage ruleitemdp=delegate.doQuery(listVO, user);
			Iterator it1 = ruleitemdp.getDatas().iterator();
			if(it1.hasNext()){
				String vvv = ((RuleitemVO)(it1.next())).getVcityid();
				if(!"".equals(vvv)&&null!=vvv){
					String[] vcityid=vvv.trim().split("\\|");
					for(int j=0;j<vcityid.length;j++){
						set.add(vcityid[j]);
					}
				}
			}
			if(set.contains("999")||set.contains(user.getCityid())){
				ruleitemsetnew.add(ruleitemlist.get(i));
			}
			
		}
		DataPackage newdp=new DataPackage();
		
		Collection datas=new ArrayList();
		Iterator it3 = dp2.getDatas().iterator();
		while(it3.hasNext()){
			RulerelVO vo=(RulerelVO)(it3.next());
			if(ruleitemsetnew.contains(vo.getRuleitemid())){
				datas.add(vo);
			}
		}
		newdp.setDatas(datas);
		
		request.setAttribute("dp2", newdp);
		
		return (actionMapping.findForward("listdetails"));
		
	}
	
	// 保存
	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// 设定更新时间
		SalecreditstdForm form = (SalecreditstdForm)actionForm;
		form.setUpdatetime(new Date());
		// 设定地市
		String cmdState = form.getCmdState();
		if (WebConstant.COMMAND_STRING_NEW.equals(cmdState)) {
			form.setCityid(Short.valueOf(user.getCityid()));
			
			// 每个地市同个业务类型只能有一个
			SalecreditstdDelegate delegate = new SalecreditstdDelegate();
			SalecreditstdListVO listvo = new SalecreditstdListVO();
			listvo.set_ne_cityid(user.getCityid());
			listvo.set_ne_busitype(form.getBusitype().toString());
			DataPackage dp = delegate.doQuery(listvo, user);
			if (dp != null && dp.getDatas().size() > 0) {
				request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
           		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "每个地市同个业务类型，只能有一个积分标准。"); 
           		return (actionMapping.findForward("content"));
			}
		}
		return super.doSave(actionMapping, actionForm, request, response, user);
	}
	
	public ActionForward doSave2(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		SalecreditstdForm form=(SalecreditstdForm)actionForm;
		String a=request.getParameter("a");
		String[] idAndValue=a.split(",");
		
		List list=new ArrayList();
		for(int i=0;i<idAndValue.length;i++){
			if(!"".equals(idAndValue[i]))
				list.add(idAndValue[i]);
				
		}
			
//		String ruleitemids[] = getRuleitemids(form); // 界面已选的RULEITEMID
//		String paramervalues[] =getParamervalues(form); // 界面上的paramer
		RulerelDelegate rulerelDelegate = new RulerelDelegate();
		
		try {
			
			for (int i = 0; i <list.size(); i++) {
				
				//查询"999"的paramer ,有几个分隔符"|",输入的参数是否有同样的个数
				RulerelListVO rulerelListVO1=new RulerelListVO();
				rulerelListVO1.set_pagesize("");
				rulerelListVO1.set_se_ruleid("SALEPOINT");
				rulerelListVO1.set_se_cityid("999");
				String[] ss=list.get(i).toString().split(";");
				rulerelListVO1.set_se_ruleitemid(ss[0]);
				DataPackage dp2=rulerelDelegate.doQuery(rulerelListVO1,user);
				String sp1=((RulerelVO)dp2.getDatas().iterator().next()).getParamer();
				//如果没有填写值,ss的长度就是1,必须报错
				if(ss.length==1){
					throw new Exception( ss[0] + "的参数值没有填写!");
				}else{
					//说明这条规则没有参数就不用插入参数的值在对应的地市的规则中
					if(sp1!=null){
						String sp2=ss[1];
						int length1=StringUtils.splitPreserveAllTokens(sp1, "|").length;
						int length2=StringUtils.splitPreserveAllTokens(sp2, "|").length;
						if( length1!=length2|| !("".equals(StringUtils.splitPreserveAllTokens(sp2.trim(), "|")[length2-1]))  ){
////					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "输入的参数值个数不一致,并且要以'|'分隔和结尾!");
							throw new Exception( ss[0] + "输入的参数值个数不一致,并且要以'|'分隔和结尾!");
							
						}
					}
				}
			}
			
		rulerelDelegate.doSave(list,"SALEPOINT", user);
		
//		RulerelVO rulerelVO=null;
//		RulerelListVO rulerelListVO=null;
//		try {
////			for (int i = 0; i < ruleitemids.length; i++) {
//			for (int i = 0; i < idAndValue.length; i++) {
//				rulerelVO=new RulerelVO();
//				rulerelVO.setRuleid("SALEPOINT");
//				rulerelVO.setRulemodeid(Long.parseLong("0"));
//				rulerelVO.setCityid(user.getCityid());
//				rulerelVO.setRuleitemid(ruleitemids[i]);
//				//查询"999"的paramer ,有几个分隔符"|",输入的参数是否有同样的个数
//				rulerelListVO=new RulerelListVO();
//				rulerelListVO.set_se_ruleid("SALEPOINT");
//				rulerelListVO.set_se_cityid("999");
//				rulerelListVO.set_se_ruleitemid(ruleitemids[i]);
//				DataPackage dp2=rulerelDelegate.doQuery(rulerelListVO, user);
//				String sp1=((RulerelVO)dp2.getDatas().iterator().next()).getParamer();
//				//说明这条规则没有参数就不用插入参数的值在对应的地市的规则中
//				if(sp1!=null){
//					String sp2=form.getParamervalues()[i];
//					int length1=StringUtils.splitPreserveAllTokens(sp1, "|").length;
//					int length2=StringUtils.splitPreserveAllTokens(sp2, "|").length;
//					if( length1!=length2|| !("".equals(StringUtils.splitPreserveAllTokens(sp2, "|")[length2-1]))  ){
//						request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "输入的参数值个数不一致,并且要以'|'分隔和结尾!");
////					return (actionMapping.findForward("listdetails"));
//						return doDetails(actionMapping,actionForm, request,response,user);
//					}
//					rulerelVO.setParamer(form.getParamervalues()[i]);
//				}
//				
//				
//				//查询有没有,有就修改
//				rulerelListVO=new RulerelListVO();
//				rulerelListVO.set_se_ruleid("SALEPOINT");
//				rulerelListVO.set_se_cityid(user.getCityid());
//				rulerelListVO.set_ne_rulemodeid(Long.parseLong("0"));
//				rulerelListVO.set_se_ruleitemid(ruleitemids[i]);
//				DataPackage dp=rulerelDelegate.doQuery(rulerelListVO, user);
//				Iterator itor = dp.getDatas().iterator();
//				if (itor.hasNext()) {
//					rulerelVO.setParamer(form.getParamervalues()[i]);
//					((RulerelVO)dp2.getDatas().iterator().next()).getParamer();
//					rulerelVO.setIsdefault(((RulerelVO)dp.getDatas().iterator().next()).getIsdefault());
//					rulerelVO.setState(((RulerelVO)dp.getDatas().iterator().next()).getState());
//					rulerelDelegate.doUpdate2(rulerelVO, user);
//				}else{
//					rulerelDelegate.doCreate(rulerelVO, user);
//				}
//			}
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
		}
		
//		return (actionMapping.findForward("list"));
		return doDetails(actionMapping,actionForm, request,response,user);
//		return (actionMapping.findForward("listdetails"));
	}
	
	/**
	 * 只包含界面上选择的数据
	 * 
	 * @param form
	 * @return
	 */
	private String[] getRuleitemids(SalecreditstdForm form) {
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
	private String[] getParamervalues(SalecreditstdForm form) {
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
