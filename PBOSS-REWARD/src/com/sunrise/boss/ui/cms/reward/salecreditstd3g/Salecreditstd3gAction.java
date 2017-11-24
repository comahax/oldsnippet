/**
* auto-generated code
* Tue Dec 11 09:30:18 CST 2012
*/
package com.sunrise.boss.ui.cms.reward.salecreditstd3g;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.reward.salecreditstd3g.persistent.Salecreditstd3gListVO;
import com.sunrise.boss.business.cms.reward.salecreditstd3g.persistent.Salecreditstd3gVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.reward.salecreditstd3g.Salecreditstd3gDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: Salecreditstd3gAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class Salecreditstd3gAction extends BaseAction {
    public Salecreditstd3gAction() {
            setVoClass(Salecreditstd3gVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[2]; 
           pkNameArray[0] = "busitype"; 
           pkNameArray[1] = "cityid"; 
    }
    
    /**
	 * 查询
	 */
	public ActionForward doList(ActionMapping actionMapping, ActionForm actionForm, 
		   HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		try{
			Page.setPageSize(request, (BaseActionForm) actionForm);
			Salecreditstd3gForm form = (Salecreditstd3gForm) actionForm;
			form.set_ne_cityid(user.getCityid());
			// BeanUtils.copyProperties(listVO, actionForm);
			Salecreditstd3gListVO listVO = new Salecreditstd3gListVO();
			setListVO(listVO, form); // 设置好listVO，作Ordinary为查询条件

			Salecreditstd3gDelegate delegate = new Salecreditstd3gDelegate();		
			DataPackage dp = delegate.doQuery(listVO, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		}catch(Exception ex){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
		}
		
		return (actionMapping.findForward("list"));
	}
	
	/**
	 * 保存
	 */
	public ActionForward doSave(ActionMapping actionMapping, ActionForm actionForm,
		   HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		Salecreditstd3gForm form = (Salecreditstd3gForm)actionForm;
		if(form.getCityid()==null || form.getCityid()==0){//地市不能为空
			form.setCityid(Short.parseShort(user.getCityid()));
		}
		Salecreditstd3gVO contentVO = new Salecreditstd3gVO();
		setSaveVO(contentVO, form); // 在此格式化处理好 vo 以保存

		Salecreditstd3gDelegate delegate = new Salecreditstd3gDelegate();
		String cmdState = ((BaseActionForm) actionForm).getCmdState();
		if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {// 更新
			delegate.doUpdate(contentVO, user);
			BeanUtils.copyProperties(actionForm, contentVO); // 把更新后的值赋给form，用于web显示
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
		} else {// 新增
			Object vo = null;			
			Salecreditstd3gVO pkVO = new Salecreditstd3gVO();
			BeanUtils.copyProperties(pkVO, contentVO);
			vo = delegate.doFindByPk((Serializable) pkVO, user);
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
	
	/**
	 * 删除
	 */
	protected ActionForward doDelete(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
		Salecreditstd3gDelegate delegate = new Salecreditstd3gDelegate();
		for (int i = 0; i < selectArray.length; i++) {
			// 复合主键
			delegate.doRemoveByPk(getDeletePkVO(selectArray[i]), user);
		}
		return doList(actionMapping, actionForm, request, response, user);
	}
}
