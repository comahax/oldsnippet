/**
* auto-generated code
* Tue May 17 18:38:00 CST 2011
*/
package com.sunrise.boss.ui.cms.reward.credittotal;

import java.text.SimpleDateFormat;
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

import com.sunrise.boss.business.cms.reward.credittotal.persistent.CredittotalListVO;
import com.sunrise.boss.business.cms.reward.credittotal.persistent.CredittotalVO;
import com.sunrise.boss.business.cms.reward.registersimvw.persistent.RegistersimvwListVO;
import com.sunrise.boss.business.cms.reward.ruleitem.persistent.RuleitemListVO;
import com.sunrise.boss.business.cms.reward.ruleitem.persistent.RuleitemVO;
import com.sunrise.boss.business.cms.reward.rulerel.persistent.RulerelListVO;
import com.sunrise.boss.business.cms.reward.rulerel.persistent.RulerelVO;
import com.sunrise.boss.business.cms.rewardasse.persistent.RewardasseListVO;
import com.sunrise.boss.business.cms.rewardasse.persistent.RewardasseVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.reward.credittotal.CredittotalDelegate;
import com.sunrise.boss.delegate.cms.reward.registersimvw.RegistersimvwDelegate;
import com.sunrise.boss.delegate.cms.reward.ruleitem.RuleitemDelegate;
import com.sunrise.boss.delegate.cms.reward.rulerel.RulerelDelegate;
import com.sunrise.boss.delegate.cms.rewardasse.RewardasseDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.cms.reward.registersimvw.RegistersimvwForm;
import com.sunrise.boss.ui.cms.reward.salecreditstd.SalecreditstdForm;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: CredittotalAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class CredittotalAction extends BaseAction {
    public CredittotalAction() {
            setVoClass(CredittotalVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seq"; 
    }
    
    //规则细项设置界面
    
    
 // 查询
	public ActionForward doDetails(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		List ruleitemlist=new ArrayList();
		
//		添加的部分
		RulerelDelegate rulerelDelegate=new RulerelDelegate();
		RulerelListVO rulerellistvo = new RulerelListVO();
		//load出所有的数据
		rulerellistvo.set_pagesize("");
		DataPackage dp2= rulerelDelegate.doQuery5(rulerellistvo, user);
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
//				if("".equals(((RulerelVO)(itor.next())).getParamer().trim()||)
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
    
	
	public ActionForward doSave2(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CredittotalForm form=(CredittotalForm)actionForm;
		
		String a=request.getParameter("a");
		String[] idAndValue=a.split(",");
		
		List list=new ArrayList();
		for(int i=0;i<idAndValue.length;i++){
			if(!"".equals(idAndValue[i]))
				list.add(idAndValue[i]);
				
		}
		
		RulerelDelegate rulerelDelegate = new RulerelDelegate();
		try {
			
			for (int i = 0; i <list.size(); i++) {
				
				//查询"999"的paramer ,有几个分隔符"|",输入的参数是否有同样的个数
				RulerelListVO rulerelListVO1=new RulerelListVO();
				rulerelListVO1.set_pagesize("");
				rulerelListVO1.set_se_ruleid("ASSESSPOINT");
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
						String sp21=ss[1];
						String sp2=ss[1].trim();
						int length1=StringUtils.splitPreserveAllTokens(sp1, "|").length;
						int length2=StringUtils.splitPreserveAllTokens(sp2, "|").length;
						if( length1!=length2|| !("".equals(StringUtils.splitPreserveAllTokens(sp2.trim(), "|")[length2-1]))  ){
////					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "输入的参数值个数不一致,并且要以'|'分隔和结尾!");
							throw new Exception( ss[0] + "输入的参数值个数不一致,并且要以'|'分隔和结尾!");
							
						}
					}
				}
			}
			
			
		rulerelDelegate.doSave(list,"ASSESSPOINT", user);
		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
		}
		
		return doDetails(actionMapping,actionForm, request,response,user);
	}
		
//		String ruleitemids[] = getRuleitemids(form); // 界面已选的RULEITEMID
////		String paramervalues[] =getParamervalues(form); // 界面上的paramer
//		RulerelDelegate rulerelDelegate = new RulerelDelegate();
//		RulerelVO rulerelVO=null;
//		try {
//			for (int i = 0; i < ruleitemids.length; i++) {
//				rulerelVO=new RulerelVO();
//				rulerelVO.setRuleid("ASSESSPOINT");
//				rulerelVO.setRulemodeid(Long.parseLong("0"));
//				rulerelVO.setCityid(user.getCityid());
//				rulerelVO.setRuleitemid(ruleitemids[i]);
//				
//				//查询"999"的paramer ,有几个分隔符"|",输入的参数是否有同样的个数
//				RulerelListVO rulerelListVO1=new RulerelListVO();
//				rulerelListVO1.set_se_ruleid("ASSESSPOINT");
//				rulerelListVO1.set_se_cityid("999");
//				rulerelListVO1.set_se_ruleitemid(ruleitemids[i]);
//				DataPackage dp2=rulerelDelegate.doQuery(rulerelListVO1, user);
//				String sp1="";
//				try {
//					sp1 = ((RulerelVO)dp2.getDatas().iterator().next()).getParamer();
//				} catch (RuntimeException e) {
//					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "省公司没有此种类型的业务!");
//					return doDetails(actionMapping,actionForm, request,response,user);
//				}
//				String sp2=form.getParamervalues()[i];
//				if( StringUtils.splitPreserveAllTokens(sp1, "|").length!= StringUtils.splitPreserveAllTokens(sp2, "|").length||!("".equals(StringUtils.splitPreserveAllTokens(sp2, "|")[StringUtils.splitPreserveAllTokens(sp2, "|").length-1])) ){
//					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "要修改的第"+(i+1)+"条输入的参数值个数不一致,并且要以'|'分隔和结尾!");
//					return doDetails(actionMapping,actionForm, request,response,user);
//				}
//				
//				
//				rulerelVO.setParamer(form.getParamervalues()[i]);
//				
//				//查询有没有,有就修改
//				RulerelListVO rulerelListVO=new RulerelListVO();
//				rulerelListVO.set_se_ruleid("ASSESSPOINT");
//				rulerelListVO.set_se_cityid(user.getCityid());
//				rulerelListVO.set_ne_rulemodeid(Long.parseLong("0"));
//				rulerelListVO.set_se_ruleitemid(ruleitemids[i]);
//				DataPackage dp=rulerelDelegate.doQuery(rulerelListVO, user);
//				Iterator itor = dp.getDatas().iterator();
//				if (itor.hasNext()) {
//					rulerelVO.setParamer(form.getParamervalues()[i]);
//					rulerelVO.setIsdefault(((RulerelVO)dp.getDatas().iterator().next()).getIsdefault());
//					rulerelVO.setState(((RulerelVO)dp.getDatas().iterator().next()).getState());
//					rulerelDelegate.doUpdate2(rulerelVO, user);
//				}else{
//					rulerelDelegate.doCreate(rulerelVO, user);
//				}
//			}
//			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
//		} catch (Exception e) {
//			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
//		}
//		
////		return (actionMapping.findForward("listdetails"));
//		return doDetails(actionMapping,actionForm, request,response,user);
//	}
//	
	/**
	 * 只包含界面上选择的数据
	 * 
	 * @param form
	 * @return
	 */
	private String[] getRuleitemids(CredittotalForm form) {
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
	private String[] getParamervalues(CredittotalForm form) {
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
	
	
	 /**
	 * 导出Excel文件
	 */
	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("月度考核分数汇总查询");
		export.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		export.appendHeadLine(new String[] { "导出时间:",format.format(new Date()) });
		export.addOutputProperty("wayid", "网点编码");
		export.addOutputProperty("adtypecode", "城乡标识",export.CODE2NAME, "$CH_COUNTYCOMPTYPE");
		//星级
		export.addOutputProperty("cardsale", "套卡销售量");
		export.addOutputProperty("salelev", "套卡销售达标数");
		export.addOutputProperty("creditlev", "销售积分达标数");
		export.addOutputProperty("creditaccount", "积分值");
		export.addOutputProperty("issalelev", "是否达到销售积分套卡标准");
		export.addOutputProperty("iscreditlev", "是否达到销售积分标准");
		export.addOutputProperty("manageassess", "经营考核积分");
		export.addOutputProperty("assess", "考核积分");
					
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		// 设置取出所有查询到的数据
		CredittotalForm form = (CredittotalForm)actionForm;
		CredittotalListVO credittotalListVO = new CredittotalListVO();
		setListVO(credittotalListVO,form);
		
		// 超过Excel 2003允许导出最大行数65536给出提示信息
		DataPackage dp = null;
		CredittotalDelegate  credittotalDelegate= new CredittotalDelegate();
		dp = credittotalDelegate.doQuery(credittotalListVO,user);
		if (dp.getDatas().size() > 65536) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "记录数超过Excel允许的最大行数，请转为文本方式导出!");
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
			return actionMapping.findForward("list");
		}
		export.voClassArray = new Class[] { voClass };
		export.queryMethodName = "doList";
		if (export.headtitle == null) {
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);
		
		return actionMapping.findForward(null);
	}
	
	/**
	 * 导出Excel文件
	 */
	public ActionForward doSyn(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		CredittotalForm form=(CredittotalForm)actionForm;
		
		CredittotalDelegate credittotalDelegate=new CredittotalDelegate();
		CredittotalListVO credittotalListVO =new CredittotalListVO();
		credittotalListVO.set_se_calcmonth(form.getRewardmonth());
		DataPackage dataPackage=credittotalDelegate.doQuery(credittotalListVO, user);
		Iterator iter = dataPackage.getDatas().iterator();
		try {
			while(iter.hasNext()){
				CredittotalVO credittotalVO=(CredittotalVO)(iter.next());
				RewardasseDelegate rewardasseDelegate=new RewardasseDelegate();
				RewardasseListVO rewardasseListVO=new RewardasseListVO();
				rewardasseListVO.set_se_wayid(credittotalVO.getWayid());
				rewardasseListVO.set_se_assemonth(form.getRewardmonth());
				rewardasseListVO.set_ne_rewardtype(form.getRewardtype());
				DataPackage dp=rewardasseDelegate.doQuery(rewardasseListVO, user);
				Iterator itor = dp.getDatas().iterator();
				if(itor.hasNext()){
					RewardasseVO rewardasseVO=(RewardasseVO)(itor.next());
					rewardasseVO.setAssegrade(Float.parseFloat(credittotalVO.getAssegrade().toString()));
					rewardasseDelegate.doUpdate(rewardasseVO, user);
				}else{
					RewardasseVO rewardasseVO=new RewardasseVO();
					rewardasseVO.setAssegrade(Float.parseFloat(credittotalVO.getAssegrade().toString()));
					rewardasseVO.setWayid(credittotalVO.getWayid());
					rewardasseVO.setAssemonth(credittotalVO.getCalcmonth());
					rewardasseVO.setRewardtype(Integer.parseInt(form.getRewardtype()));
					rewardasseDelegate.doCreate(rewardasseVO, user);
				}
			}
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "同步成功");
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
		}
		
//		RewardasseDelegate rewardasseDelegate=new RewardasseDelegate();
//		RewardasseListVO rewardasseListVO=new RewardasseListVO();
//		rewardasseListVO.set_ne_rewardtype(form.getRewardtype());
//		rewardasseListVO.set_se_assemonth(form.getRewardmonth());
////		rewardasseListVO.set_ne_rewardtype("0");
////		rewardasseListVO.set_se_assemonth("201002");
//		DataPackage dp=rewardasseDelegate.doQuery4Syn(rewardasseListVO, user);
//		Iterator itor = dp.getDatas().iterator();
//		try {
//			while(itor.hasNext()){
//				RewardasseVO rewardasseVO=(RewardasseVO)(itor.next());
////				if(rewardasseVO.getAssemonth()!=form.getRewardmonth()){
////					rewardasseDelegate.doCreate(vo, user)
////				}
//				rewardasseDelegate.doUpdate(rewardasseVO, user);
////			rewardasseVO.setAssemonth(assemonth)
//				
//			}
//			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "同步成功");
//		} catch (RuntimeException e) {
//			// TODO Auto-generated catch block
//			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
//		}
		
		return (actionMapping.findForward("list"));
	}
}
