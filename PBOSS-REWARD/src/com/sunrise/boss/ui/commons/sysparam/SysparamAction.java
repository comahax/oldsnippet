/**
* auto-generated code
* Fri Aug 11 16:47:18 CST 2006
*/
package com.sunrise.boss.ui.commons.sysparam;


import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.ui.base.BaseManageAction;

/**
 * <p>Title: SysparamAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author xqy
 * @version 1.0
 */
public class SysparamAction extends BaseManageAction {
	
	public SysparamAction() {
        this.voClass = SysparamVO.class;
        this.pkNameArray=new String[]{"systemid","paramtype"};
    }
//    /**
//     * 保存
//     */
//    protected ActionForward doSave(ActionMapping actionMapping,
//                                   ActionForm actionForm,
//                                   HttpServletRequest request,
//                                   HttpServletResponse response, User user) throws
//            Exception {
//
//        SysparamVO contentVO = (SysparamVO)voClass.newInstance();
////        BeanUtils.copyProperties(contentVO, actionForm);
//
//        setSaveVO(contentVO, actionForm); //在此格式化处理好 vo 以保存
//
//        SysparamDelegate delegate = new SysparamDelegate();
//        String cmdState = ((BaseActionForm)actionForm).getCmdState();
//        if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {
//            delegate.doUpdate(contentVO, user);
//        } else {
//            delegate.doCreate(contentVO, user);
//        }
//        BeanUtils.copyProperties(actionForm, contentVO); //把更新后的值赋给form，用于web显示
////        request.setAttribute(WebConstant.PAGE_ATTRIBUTE_ISEDIT, WebConstant.STRING_TRUE); //可编辑标记
//        ((BaseActionForm)actionForm).setCmdState(WebConstant.COMMAND_STRING_EDIT);
//        request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
//        return (actionMapping.findForward("content"));
//    }	
//    
//    /**
//     * 删除
//     */
//    protected ActionForward doDelete(ActionMapping actionMapping,
//                                     ActionForm actionForm,
//                                     HttpServletRequest request,
//                                     HttpServletResponse response, User user) throws
//            Exception {
//        String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
//        SysparamDelegate delegate = new SysparamDelegate();
//        for (int i = 0; i < selectArray.length; i++) {
//            	SysparamVO vo = delegate.doFindByPk((selectArray[i]), user);
//                delegate.doRemove(vo, user);
//        }
//
//        return doList(actionMapping, actionForm, request, response, user);
//    }    
}
