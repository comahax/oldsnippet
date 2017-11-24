/**
* auto-generated code
* Thu Jun 16 10:00:34 CST 2011
*/
package com.sunrise.boss.ui.cms.mendregister;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.mendregister.persistent.MendregisterListVO;
import com.sunrise.boss.business.cms.mendregister.persistent.MendregisterVO;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.cms.mendregister.MendregisterDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ChPwMendregisterAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class MendregisterAction extends BaseDelegateAction {
    public MendregisterAction() {
            setVoClass(MendregisterVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seqid"; 
    }
    
//    /**
//	 * 保存
//	 */
//	public ActionForward doSave(ActionMapping actionMapping,
//			ActionForm actionForm, HttpServletRequest request,
//			HttpServletResponse response, User user) throws Exception {
//		MendregisterVO mvo = new MendregisterVO();
//		setSaveVO(mvo, actionForm); // 在此格式化处理好 vo 以保存
//		MendregisterDelegate delegate = new MendregisterDelegate();
//		String cmdState = ((BaseActionForm) actionForm).getCmdState();
//		try {
//			delegate.doCreateWithCheck(mvo, user);
//			BeanUtils.copyProperties(actionForm, mvo); // 把更新后的值赋给form，用于web显示
//			((BaseActionForm) actionForm)
//					.setCmdState(WebConstant.COMMAND_STRING_EDIT);
//			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
//		} catch (BusinessException e) {
//			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
//					.toString());
//		} catch (Exception e) {
//			throw e;
//		}
//		return (actionMapping.findForward("content"));
//	}
	
    public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		return actionMapping.findForward("list");
	}

	/**
	 * 删除.
	 */
    public ActionForward doDelete(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
		try {
			MendregisterDelegate del = new MendregisterDelegate();
			for (int i = 0; i < selectArray.length; i++) {
				MendregisterVO vo = new MendregisterVO();
		        vo = del.doFindByPk(Long.valueOf(selectArray[i]), user);
		        if(vo.getSuccess()==2){
		        	del.doRemove(vo, user);
		        }else{
		        	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
						"只能删除待处理记录!");
		        	return (actionMapping.findForward("list"));
		        }
			}
		}catch(BusinessException e) {
        	 request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.toString());
        }catch(Exception e) {
        	throw e;
        } 
	    return doList(actionMapping, actionForm, request, response, user);
	}
}
