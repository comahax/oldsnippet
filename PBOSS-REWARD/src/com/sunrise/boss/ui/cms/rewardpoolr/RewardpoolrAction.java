/**
 * auto-generated code
 * Fri Feb 01 18:16:01 CST 2008
 */
package com.sunrise.boss.ui.cms.rewardpoolr;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.operation.persistent.OperationVO;
import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightListVO;
import com.sunrise.boss.business.cms.reward.rewardpoolyw.persistent.RewardpoolywListVO;
import com.sunrise.boss.business.cms.reward.rewardpoolyw.persistent.RewardpoolywVO;
import com.sunrise.boss.business.cms.rewardpoolr.persistent.RewardpoolrListVO;
import com.sunrise.boss.business.cms.rewardpoolr.persistent.RewardpoolrVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.admin.acl.ACLDelegate;
import com.sunrise.boss.delegate.cms.operation.OperationDelegate;
import com.sunrise.boss.delegate.cms.provincialright.ProvincialrightDelegate;
import com.sunrise.boss.delegate.cms.reward.rewardpoolyw.RewardpoolywDelegate;
import com.sunrise.boss.delegate.cms.rewardpoolr.RewardpoolrDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: RewardpoolrAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RewardpoolrAction extends BaseDelegateAction {
	public RewardpoolrAction() {
		//以下几个方法是必须的 
		//指定VO类 
		setVoClass(RewardpoolrVO.class);
		//指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称 
		this.pkNameArray = new String[2];
		pkNameArray[0] = "region";
		pkNameArray[1] = "rewardtype";
	}

	public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		RewardpoolrForm rewardpoolrForm = (RewardpoolrForm) actionForm;
		
		ProvincialrightListVO rightvo = new ProvincialrightListVO();
		rightvo.set_se_rightid("CH_PW_REWARD_PROVINCIAL");
		rightvo.set_se_proopr(user.getOpercode());
		ProvincialrightDelegate delegate = new ProvincialrightDelegate();
		DataPackage dp = delegate.doQuery(rightvo, user);
		
		ACLDelegate aclDelegate = new ACLDelegate();		
		if(aclDelegate.checkPermission(user.getOpercode(), "CH_PW_REWARD")||aclDelegate.checkPermission(user.getOpercode(), "CH_PW_REWARD_PROVINCIAL")){
			request.setAttribute("showCityList", "1");
		}else if(dp.getRowCount()>0){
			request.setAttribute("showCityList", "1");
		}else{
			request.setAttribute("showCityList", "0");
			rewardpoolrForm.set_se_region(user.getCityid());
			
		}
		return actionMapping.findForward("list");
	}

	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		//	    Page.setPageSize(request, (BaseActionForm) actionForm);                     
//		try {
//			RewardpoolrDelegate delegate = new RewardpoolrDelegate();
//			Page.setPageSize(request, (BaseActionForm) actionForm);
//			RewardpoolrListVO listVO = new RewardpoolrListVO();
//			setListVO(listVO, actionForm); //设置好listVO，作为查询条件
//
//			DataPackage pack = (DataPackage) delegate.doQuery(listVO, user);
//			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
//		} catch (BusinessException e) {
//			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
//					.getMessage());
//		} catch (Exception e) {
//			throw e;
//		}
//		return (actionMapping.findForward("list"));
		RewardpoolrForm rewardpoolrForm = (RewardpoolrForm) actionForm;
		ACLDelegate aclDelegate = new ACLDelegate();		
		if(aclDelegate.checkPermission(user.getOpercode(), "CH_PW_REWARD")||aclDelegate.checkPermission(user.getOpercode(), "CH_PW_REWARD_PROVINCIAL")){
			request.setAttribute("showCityList", "1");
		}else{
			request.setAttribute("showCityList", "0");
			rewardpoolrForm.set_se_region(user.getCityid());
		}
		return super.doList(actionMapping, actionForm, request, response, user);
	}
	
	public ActionForward doNew(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		RewardpoolrForm rewardpoolrForm = (RewardpoolrForm) actionForm;
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		rewardpoolrForm.setStartdate(new Date());
		rewardpoolrForm.setStopdate(sf.parse("2099-12-31 23:59:59"));
		rewardpoolrForm.setProportion("4|3|3|");
		rewardpoolrForm.setCycle("1|4|7|");
		ACLDelegate aclDelegate = new ACLDelegate();		
		if(aclDelegate.checkPermission(user.getOpercode(), "CH_PW_REWARD")||aclDelegate.checkPermission(user.getOpercode(), "CH_PW_REWARD_PROVINCIAL")){
			request.setAttribute("showCityList", "1");
		}else{
			request.setAttribute("showCityList", "0");
			rewardpoolrForm.setRegion(user.getCityid());
		}
		return super.doNew(actionMapping, actionForm, request, response, user);
	}

	// 新增
	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		String cmdState = ((BaseActionForm) actionForm).getCmdState();
		RewardpoolrDelegate delegate = new RewardpoolrDelegate();
		
		try {
			RewardpoolrForm rewardpoolrForm = (RewardpoolrForm) actionForm;
			String inputrewardbuss=rewardpoolrForm.getInputrewardbuss();
			String beforinputrewardbuss=rewardpoolrForm.getBeforinputrewardbuss();
			//String slv = rewardpoolrForm.getSlv();
			String slv = "111111";
			RewardpoolrVO rewardpoolrVO = new RewardpoolrVO();
			RewardpoolrListVO rewardpoolrListVO = new RewardpoolrListVO();
			DataPackage list;
			com.sunrise.boss.common.utils.bean.BeanUtils.copyProperties(rewardpoolrVO, actionForm);
			rewardpoolrVO.setSlv(slv);
			ACLDelegate aclDelegate = new ACLDelegate();
			if(aclDelegate.checkPermission(user.getOpercode(), "CH_PW_REWARD")||aclDelegate.checkPermission(user.getOpercode(), "CH_PW_REWARD_PROVINCIAL")){
				request.setAttribute("showCityList", "1");
			}else{
				request.setAttribute("showCityList", "0");
			}
			if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {
				delegate.doUpdate(rewardpoolrVO, user);
				if(inputrewardbuss!=null && !inputrewardbuss.equals("") && !beforinputrewardbuss.equals(inputrewardbuss)){
					RewardpoolywDelegate rewardpoolywDelegate=new RewardpoolywDelegate();
					RewardpoolywListVO listvo=new RewardpoolywListVO();
					//BeanUtils.copyProperties(listvo, actionForm);
					listvo.set_ne_rewardtype(rewardpoolrForm.getRewardtype().toString());
					listvo.set_se_region(rewardpoolrForm.getRegion());
					listvo.set_pagesize("0");
					List rewardpoolyws=(List)rewardpoolywDelegate.doQuery(listvo,user).getDatas();
					for(Iterator it=rewardpoolyws.iterator();it.hasNext();){
						RewardpoolywVO rewardpoolyw=(RewardpoolywVO)it.next();
						rewardpoolywDelegate.doRemove(rewardpoolyw,user);
					}
					
					String[] opnids=inputrewardbuss.split("\\;");
					for(int i=0;i<opnids.length;i++){
						RewardpoolywVO rewardpoolyw=new RewardpoolywVO();
						rewardpoolyw.setOpnid(opnids[i].substring(0,opnids[i].indexOf("-")));
						rewardpoolyw.setRegion(rewardpoolrForm.getRegion());
						rewardpoolyw.setRewardtype(rewardpoolrForm.getRewardtype());
						rewardpoolywDelegate.doCreate(rewardpoolyw,user);
					}
				}
				BeanUtils.copyProperties(actionForm, rewardpoolrVO); // 把更新后的值赋给form，用于web显示
				request
						.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
								"保存成功");
			} else {

				rewardpoolrListVO.set_ne_rewardtype(rewardpoolrVO
						.getRewardtype().toString());
				rewardpoolrListVO.set_se_region(rewardpoolrVO.getRegion());
				list = delegate.doQuery(rewardpoolrListVO, user);
				if (list.getDatas().size() < 1) {
					delegate.doCreate(rewardpoolrVO, user);
					BeanUtils.copyProperties(actionForm, rewardpoolrVO); // 把更新后的值赋给form，用于web显示
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
					if(inputrewardbuss!=null && !inputrewardbuss.equals("")){
						RewardpoolywDelegate rewardpoolywDelegate=new RewardpoolywDelegate();
						RewardpoolywListVO listvo=new RewardpoolywListVO();
						//BeanUtils.copyProperties(listvo, actionForm);
						listvo.set_ne_rewardtype(rewardpoolrForm.getRewardtype().toString());
						listvo.set_se_region(rewardpoolrForm.getRegion());
						listvo.set_pagesize("0");
						String[] opnids=inputrewardbuss.split("\\;");
						for(int i=0;i<opnids.length;i++){
							listvo.set_se_opnid(opnids[i].substring(0,opnids[i].indexOf("-")));
							List rewardpoolyws=(List)rewardpoolywDelegate.doQuery(listvo,user).getDatas();
							if(rewardpoolyws.isEmpty()){
								RewardpoolywVO rewardpoolyw=new RewardpoolywVO();
								rewardpoolyw.setOpnid(opnids[i].substring(0,opnids[i].indexOf("-")));
								rewardpoolyw.setRegion(rewardpoolrForm.getRegion());
								rewardpoolyw.setRewardtype(rewardpoolrForm.getRewardtype());
								rewardpoolywDelegate.doCreate(rewardpoolyw,user);
							}
						}
					}
				} else {
					request.setAttribute( WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "含有相同酬金类型和市公司的记录已经存在, 请输入其它信息");
					onDuplicatePk(actionMapping, actionForm, request, response, user);

				}
			}
		} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex
					.getMessage());
		}
		return (actionMapping.findForward("content"));
	}
	
	public ActionForward doDelete(ActionMapping actionMapping, ActionForm actionForm,
				HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		String[] selectArray = ((RewardpoolrForm) actionForm).get_selectitem();
		try {
			   
			   for (int i = 0; i < selectArray.length; i++) {
				   String[] tempStr=selectArray[i].split("\\|");
				   RewardpoolywDelegate rewardpoolywDelegate=new RewardpoolywDelegate();
					RewardpoolywListVO listvo=new RewardpoolywListVO();
					listvo.set_ne_rewardtype(tempStr[1]);
					listvo.set_se_region(tempStr[0]);
					listvo.set_pagesize("0");
					List rewardpoolyws=(List)rewardpoolywDelegate.doQuery(listvo,user).getDatas();
					for(Iterator it=rewardpoolyws.iterator();it.hasNext();){
						RewardpoolywVO rewardpoolyw=(RewardpoolywVO)it.next();
						rewardpoolywDelegate.doRemove(rewardpoolyw,user);
					}
			   }
		}catch(BusinessException e) {
        	 request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.toString());
        }catch(Exception e) {
        	throw e;
        } 
		return super.doDelete(actionMapping,actionForm,request,response,user);
	}
	/**
	 * 编辑
	 */
	protected ActionForward doEdit(ActionMapping actionMapping, ActionForm actionForm, 
			HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		super.doEdit(actionMapping,actionForm,request,response,user);
		RewardpoolrForm rewardpoolrForm = (RewardpoolrForm) actionForm;
		RewardpoolywDelegate rewardpoolywDelegate=new RewardpoolywDelegate();
		OperationDelegate operationDelegate=new OperationDelegate();
		RewardpoolywListVO listvo=new RewardpoolywListVO();
		listvo.set_ne_rewardtype(rewardpoolrForm.getRewardtype().toString());
		listvo.set_se_region(rewardpoolrForm.getRegion());
		listvo.set_pagesize("0");
		List rewardpoolyws=(List)rewardpoolywDelegate.doQuery(listvo,user).getDatas();
		String inputrewardbuss="";
		for(Iterator it=rewardpoolyws.iterator();it.hasNext();){
			RewardpoolywVO rewardpoolyw=(RewardpoolywVO)it.next();
			inputrewardbuss=inputrewardbuss+rewardpoolyw.getOpnid();
			OperationVO operation=operationDelegate.doFindByPk(rewardpoolyw.getOpnid(),user);
			inputrewardbuss=inputrewardbuss+"-"+operation.getName()+";";
		}
		rewardpoolrForm.setInputrewardbuss(inputrewardbuss);
		rewardpoolrForm.setBeforinputrewardbuss(inputrewardbuss);
		return (actionMapping.findForward("content"));
	}
}
