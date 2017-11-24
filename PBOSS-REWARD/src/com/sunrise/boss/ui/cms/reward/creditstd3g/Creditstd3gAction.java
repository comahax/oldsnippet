/**
* auto-generated code
* Sat Dec 08 10:23:53 CST 2012
*/
package com.sunrise.boss.ui.cms.reward.creditstd3g;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.reward.creditstd3g.persistent.Creditstd3gListVO;
import com.sunrise.boss.business.cms.reward.creditstd3g.persistent.Creditstd3gVO;
import com.sunrise.boss.business.cms.reward.creditstd3g.persistent.VCreditstd3gVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.reward.creditstd3g.Creditstd3gDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: Creditstd3gAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class Creditstd3gAction extends BaseAction {	
    public Creditstd3gAction() {
            setVoClass(Creditstd3gVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[2]; 
           pkNameArray[0] = "cityid"; 
           pkNameArray[1] = "wayattr"; 
    }
    
    /**
	 * 查询 商圈门店补贴酬金上限设置
	 */
	public ActionForward doList(ActionMapping actionMapping, ActionForm actionForm, 
			HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		Page.setPageSize(request, (BaseActionForm) actionForm);
		try{
			Creditstd3gForm form = (Creditstd3gForm)actionForm;
			Creditstd3gListVO listvo = new Creditstd3gListVO();
			//BeanUtils.copyProperties(listvo, form);
			setListVO(listvo, form);
			listvo.set_sql_cityid("cityid in (0,1,2)");
			
			Creditstd3gDelegate delegate = new Creditstd3gDelegate();
			DataPackage dp = delegate.doQuery(listvo, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		}catch(Exception ex){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
		}		
		return (actionMapping.findForward("list"));
	}
	
	/**
	 * 查询 商圈门店补贴酬金标准展现
	 */
	public ActionForward doListstdview(ActionMapping actionMapping, ActionForm actionForm, 
			HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		Page.setPageSize(request, (BaseActionForm) actionForm);
		try{
			Creditstd3gForm form = (Creditstd3gForm)actionForm;
			Creditstd3gListVO listvo = new Creditstd3gListVO();
			//BeanUtils.copyProperties(listvo, form);
			setListVO(listvo, form);
			listvo.set_sql_cityid("cityid not in (0,1,2)");
			
			Creditstd3gDelegate delegate = new Creditstd3gDelegate();
			DataPackage dp = delegate.doQuery(listvo, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		}catch(Exception ex){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
		}		
		return (actionMapping.findForward("liststdview"));
	}
	
	/**
	 * 查询 商圈门店补贴酬金标准设置
	 */
	public ActionForward doListstdset(ActionMapping actionMapping, ActionForm actionForm, 
			HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		Page.setPageSize(request, (BaseActionForm) actionForm);
		try{
			Creditstd3gForm form = (Creditstd3gForm)actionForm;
			Creditstd3gListVO listvo = new Creditstd3gListVO();
			//BeanUtils.copyProperties(listvo, form);
			setListVO(listvo, form);
						
			Creditstd3gDelegate delegate = new Creditstd3gDelegate();
			DataPackage dp = delegate.doQuerystdset(listvo, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		}catch(Exception ex){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
		}		
		return (actionMapping.findForward("liststdset"));
	}
    
    /**
	 * 保存
	 */
	public ActionForward doSave(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		Creditstd3gVO contentVO = (Creditstd3gVO)voClass.newInstance();
		setSaveVO(contentVO, actionForm); // 在此格式化处理好 vo 以保存

		Creditstd3gDelegate delegate = new Creditstd3gDelegate();
		String cmdState = ((BaseActionForm) actionForm).getCmdState();
		if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {// 更新
			delegate.doUpdate(contentVO, user);
			BeanUtils.copyProperties(actionForm, contentVO); // 把更新后的值赋给form，用于web显示
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
		} else {// 新增
			Object vo = null;
			if (pkNameArray.length == 1) { // 单一主键
				Object pk = PropertyUtils.getNestedProperty(contentVO, pkNameArray[0]);
				// Object pk = BeanUtils.getProperty(contentVO, pkNameArray[0]);
				// 这里返回的是String类型
				if (pk != null) {
					vo = delegate.doFindByPk((Serializable) pk, user);
				}
			} else {// 复合主建
				Object pkVO = voClass.newInstance();
				BeanUtils.copyProperties(pkVO, contentVO);
				vo = delegate.doFindByPk((Serializable) pkVO, user);
			}
			if (vo == null) {
				delegate.doCreate(contentVO, user);
				BeanUtils.copyProperties(actionForm, contentVO); // 把更新后的值赋给form，用于web显示
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
			} else {
				request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "主键重复");
				onDuplicatePk(actionMapping, actionForm, request, response, user);
			}
		}
		return (actionMapping.findForward("content"));
	}
	
	public ActionForward doEditstdset(ActionMapping actionMapping, ActionForm actionForm, 
			HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		try{
			String pk = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
			String[] pkValueArray = pk.split("\\|");
			Creditstd3gDelegate delegate = new Creditstd3gDelegate();
			Creditstd3gListVO listvo = new Creditstd3gListVO();
			listvo.set_ne_cityid(pkValueArray[0]);
			listvo.set_se_wayattr(pkValueArray[1]);
			DataPackage dp = delegate.doQuerystdset(listvo, user);
			if(dp!=null && dp.getDatas()!=null && dp.getDatas().size()>0){
				VCreditstd3gVO vvo = (VCreditstd3gVO)dp.getDatas().iterator().next();
				BeanUtils.copyProperties(actionForm, vvo);
			}else{
				throw new Exception("根据主键"+pk+"无法查到数据");
			}
		}catch(Exception ex){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
		}
		return (actionMapping.findForward("contentstdset"));
	}
	
	public ActionForward doSavestdset(ActionMapping actionMapping, ActionForm actionForm, 
			HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		VCreditstd3gVO vvo = new VCreditstd3gVO();
		this.setSaveVO(vvo, actionForm);
		if(vvo.getRewardstd() > vvo.getRewardstdup()){
			throw new Exception("酬金标准不能超过省公司设置酬金上限");
		}
		Creditstd3gVO vo = new Creditstd3gVO();
		BeanUtils.copyProperties(vo, vvo);
		Creditstd3gDelegate delegate = new Creditstd3gDelegate();
		delegate.doUpdate(vo, user);
		BeanUtils.copyProperties(actionForm, vo);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
		
		return (actionMapping.findForward("contentstdset"));
	}
	
	/**
	 * 云浮商圈门店补贴酬金标准设置
	 */
	public ActionForward doListyf(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		Creditstd3gForm form = (Creditstd3gForm) actionForm;
		Creditstd3gListVO listvo = new Creditstd3gListVO();
		setListVO(listvo, form);
		listvo.set_ne_cityid(user.getCityid());
		Creditstd3gDelegate delegate = new Creditstd3gDelegate();
		DataPackage dp = delegate.doQuerystdset(listvo, user);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		return actionMapping.findForward("listyf");
	}
	
	public ActionForward doEdityf(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try{
			String pk = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
			String[] pkValueArray = pk.split("\\|");
			Creditstd3gDelegate delegate = new Creditstd3gDelegate();
			Creditstd3gListVO listvo = new Creditstd3gListVO();
			listvo.set_ne_cityid(pkValueArray[0]);
			listvo.set_se_wayattr(pkValueArray[1]);
			DataPackage dp = delegate.doQuerystdset(listvo, user);
			if(dp!=null && dp.getDatas()!=null && dp.getDatas().size()>0){
				VCreditstd3gVO vvo = (VCreditstd3gVO)dp.getDatas().iterator().next();
				BeanUtils.copyProperties(actionForm, vvo);
			}else{
				throw new Exception("根据主键"+pk+"无法查到数据");
			}
		}catch(Exception ex){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
		}
		return actionMapping.findForward("contentyf");
	}
	
	/**
	 * 云浮商圈门店补贴酬金标准设置
	 */
	public ActionForward doSaveyf(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try{
			VCreditstd3gVO vvo = new VCreditstd3gVO();
			this.setSaveVO(vvo, actionForm);
			double rewardstd = vvo.getZyrewardstd() + vvo.getJfrewardstd();
			if(rewardstd > vvo.getRewardstdup()){
				throw new Exception("专营奖励酬金标准、积分奖励酬金标准之和不能超过省公司设置酬金上限");
			}
			vvo.setRewardstd(rewardstd);
			Creditstd3gVO vo = new Creditstd3gVO();
			BeanUtils.copyProperties(vo, vvo);
			Creditstd3gDelegate delegate = new Creditstd3gDelegate();
			delegate.doUpdate(vo, user);
			BeanUtils.copyProperties(actionForm, vo);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
		}catch(Exception ex){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
		}
		return actionMapping.findForward("contentyf");
	}
}
