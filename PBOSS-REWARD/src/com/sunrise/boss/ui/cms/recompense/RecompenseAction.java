/**
* auto-generated code
* Tue Sep 19 21:22:32 CST 2006
*/
package com.sunrise.boss.ui.cms.recompense;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import com.sunrise.boss.business.cms.recompense.persistent.RecompenseVO;
import com.sunrise.boss.common.utils.bean.BeanUtils;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;

import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: RecompenseAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RecompenseAction extends BaseDelegateAction {
    public RecompenseAction() {
           //���¼��������Ǳ���� 
           //ָ��VO�� 
            setVoClass(RecompenseVO.class);
            //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ����� 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "recid"; 
    }
    /**
	 * ����
	 */
	protected ActionForward doSave(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		
		
	 
		RecompenseVO contentVO = new RecompenseVO();
	
      
//       SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//����ʱ���ʽ 
       
       RecompenseForm form = (RecompenseForm) actionForm;    

       setSaveVO(contentVO, actionForm); //�ڴ˸�ʽ������� vo �Ա���
   //   contentVO.setIntime(PublicUtils.UtilStrToDate(form.getIntime())); 
      contentVO.setBossarea(user.getCityid());
       Object pk = contentVO.getRecid();
       Object delegate = getDelegate();
       String methodName = "doFindByPk";      
       Object existObj = null;
       if(pk!=null) {
    	   existObj =  invokeDelegateMethod(delegate,methodName,new Object[]{pk, user});  
    	   if(existObj!=null) {
    		   BeanUtils.copyProperties(existObj, contentVO);
        	   contentVO = (RecompenseVO)existObj;
    	   }   
       }
       
       String cmdState = ((BaseActionForm)actionForm).getCmdState();
       if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {
    	   
    	   methodName = "doUpdate";
    	   contentVO = (RecompenseVO)invokeDelegateMethod(delegate,methodName,new Object[]{contentVO, user});
          
       } else {
    	   if(existObj!=null) {
    		    request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
           		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "�����ظ�"); 
           		return (actionMapping.findForward("content"));
    	   }else {
    		   methodName = "doCreate";
        	   contentVO =(RecompenseVO) invokeDelegateMethod(delegate,methodName,new Object[]{contentVO, user});  
    	   }
       }
       BeanUtils.copyProperties(form, contentVO); //�Ѹ��º��ֵ����form������web��ʾ       
  //     form.setIntime(df.format(contentVO.getIntime()));
       form.setCmdState(WebConstant.COMMAND_STRING_EDIT);
       request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
       return (actionMapping.findForward("content"));
	}
}
