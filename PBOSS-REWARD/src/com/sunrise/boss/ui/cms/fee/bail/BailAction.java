/**
* auto-generated code
* Fri Dec 08 17:16:19 CST 2006
*/
package com.sunrise.boss.ui.cms.fee.bail;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.ClassUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.admin.operator.persistent.OperatorVO;
import com.sunrise.boss.business.cms.fee.bail.persistent.BailVO;
import com.sunrise.boss.delegate.cms.fee.bail.BailDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: BailAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public class BailAction extends BaseDelegateAction {
    public BailAction() {
        this.voClass = BailVO.class;
        // TODO: ������������������
        this.pkNameArray=new String[1];
        pkNameArray[0] = "seq"; 
    }
    
    public ActionForward doNew(ActionMapping actionMapping,ActionForm actionForm,HttpServletRequest request,HttpServletResponse response, User user) throws Exception {
    	BailForm form = (BailForm)actionForm;
    	form.setWayid(user.getWayid());
    	form.setRecvoprcode(user.getOpercode());
    	form.setGivetimestr(new SimpleDateFormat( "yyyy-MM-dd" ).format( new Date()));
    	form.setRecvtimestr(new SimpleDateFormat( "yyyy-MM-dd" ).format( new Date()));
    	return super.doNew(actionMapping,actionForm,request,response, user);
    }
    
    public void getContentVO(HttpServletRequest request, User user,
			ActionForm actionForm) throws Exception {
    	String pk = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
		if (pk == null)
			throw new NullPointerException("pk is required.");
		Object contentVO = getContentVO(request, user);
		if (contentVO == null)
			throw new NullPointerException("VO not found, pk " + pk + " of "
					+ ClassUtils.getShortClassName(actionForm.getClass()));
		BeanUtils.copyProperties(actionForm, contentVO);
		Double moneyAmt = ((BailVO)contentVO).getMoney();
		BailForm form = (BailForm)actionForm;
		form.setMoney(new java.text.DecimalFormat("0.00").format(moneyAmt));
	}
    
    /**
	 * ����
	 */
    public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	 	
    	OperatorVO operatorVO = new OperatorVO(); 	
        BailVO bailVO = new BailVO();
        BeanUtils.copyProperties(bailVO, actionForm);
    	BailDelegate bailDelegate = new BailDelegate();
        operatorVO = bailDelegate.doOperatorFindByPk(bailVO.getRecvoprcode(), user);
        
    	if(operatorVO == null) {//У���շ�Ա�����Ƿ����
        	request
		      .setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
				   "�շ�Ա���Ų�����");
    	}else {
		Object contentVO = voClass.newInstance();
		setSaveVO(contentVO, actionForm); // �ڴ˸�ʽ������� vo �Ա���
		//actionForm
		CommonDelegate delegate = new CommonDelegate(voClass);
		String cmdState = ((BaseActionForm) actionForm).getCmdState();
		if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {// ����
			delegate.doUpdate(contentVO, user);
			BeanUtils.copyProperties(actionForm, contentVO); // �Ѹ��º��ֵ����form������web��ʾ
			Double moneyAmt = ((BailVO)contentVO).getMoney();
			BailForm form = (BailForm)actionForm;
			form.setMoney(new java.text.DecimalFormat("0.00").format(moneyAmt));
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
		} else {// ����
			Object vo = null;
			if (pkNameArray.length == 1) { // ��һ����
				Object pk = PropertyUtils.getNestedProperty(contentVO,
						pkNameArray[0]);
				// Object pk = BeanUtils.getProperty(contentVO, pkNameArray[0]);
				// ���ﷵ�ص���String����
				if (pk != null) {
					vo = delegate.doFindByPk((Serializable) pk, user);
				}
			} else {// ��������
				Object pkVO = voClass.newInstance();
				BeanUtils.copyProperties(pkVO, contentVO);
				vo = delegate.doFindByPk((Serializable) pkVO, user);
			}
			if (vo == null) {
				delegate.doCreate(contentVO, user);
				BeanUtils.copyProperties(actionForm, contentVO); // �Ѹ��º��ֵ����form������web��ʾ
				Double moneyAmt = ((BailVO)contentVO).getMoney();
				BailForm form = (BailForm)actionForm;
				form.setMoney(new java.text.DecimalFormat("0.00").format(moneyAmt));
				
				request
						.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
								"����ɹ�");
			} else {
				request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
						WebConstant.COMMAND_STRING_EDIT);
				request
						.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
								"�����ظ�");
				onDuplicatePk(actionMapping, actionForm, request, response,
						user);
			}
		}
     }	
		return (actionMapping.findForward("content"));			
    }
}