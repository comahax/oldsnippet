package com.sunrise.boss.ui.zifee.yxplansplitscale;

import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.zifee.yxplansplitscale.persistent.YxPlanSplitScaleVO;
import com.sunrise.boss.business.zifee.yxplantype.persistent.YxPlanTypeListVO;
import com.sunrise.boss.business.zifee.yxplantype.persistent.YxPlanTypeVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.delegate.zifee.yxplansplitscale.YxPlanSplitScaleDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
//import com.sunrise.boss.ui.resmanage.com.Escape;
import com.sunrise.boss.ui.resmanage.comrescard.Escape;

public class YxPlanSplitScaleAction extends BaseAction{
	public YxPlanSplitScaleAction() {
        this.voClass = YxPlanSplitScaleVO.class;
        // TODO: ������������������
        this.pkNameArray = new String[4];
        pkNameArray[0] = "yxplanid";
        pkNameArray[1] = "yxplantypeid";
        pkNameArray[2] = "yxplankindid";
        pkNameArray[3] = "yxplanitemid";
    }
	
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		User user = getUser(request);
		String command = getCommandString(request);
		try {
			if (command.equals("LOWGRD")) {
				return doLowGrd(actionMapping, actionForm, request, response,
						user);
			} else {
				return super.execute(actionMapping, actionForm, request,
						response);
			}
		} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex
					.getMessage());
			ex.printStackTrace();
			return (actionMapping.findForward("error"));
		}

	}
    /**
     * ����
     */
    protected ActionForward doSave(ActionMapping actionMapping,
                                   ActionForm actionForm,
                                   HttpServletRequest request,
                                   HttpServletResponse response, User user) throws
            Exception {

    	YxPlanSplitScaleVO contentVO = (YxPlanSplitScaleVO)voClass.newInstance();
//        BeanUtils.copyProperties(contentVO, actionForm);

        setSaveVO(contentVO, actionForm); //�ڴ˸�ʽ������� vo �Ա���

        YxPlanSplitScaleDelegate delegate = new YxPlanSplitScaleDelegate();
        String cmdState = ((BaseActionForm)actionForm).getCmdState();
        if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {//����
            delegate.doUpdate(contentVO, user);
            BeanUtils.copyProperties(actionForm, contentVO); //�Ѹ��º��ֵ����form������web��ʾ
            request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");  
        } else {//����
        	Object vo = null;
        	if(pkNameArray.length==1){ //��һ����
        		Object pk = BeanUtils.getProperty(contentVO, pkNameArray[0]);
        		if(pk!=null){
        			vo = delegate.doFindByPk((Serializable) pk, user);
        		}
        	}else{//��������
        		Object pkVO = voClass.newInstance();
        		BeanUtils.copyProperties(pkVO, contentVO);
        		vo = delegate.doFindByPk((Serializable) pkVO, user);	
        	}
            if(vo==null){
            	delegate.doCreate(contentVO, user);	
            	BeanUtils.copyProperties(actionForm, contentVO); //�Ѹ��º��ֵ����form������web��ʾ
                request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");    	
            }else{
            	request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
            	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ʧ��,�Ѵ�����ͬ��Ӫ��������ʶ,���˷���һ��ʶ,�������Ͷ���ʶ,��Ŀ��ʶ"); 
            }    
        }
        return (actionMapping.findForward("content"));
    }
    
    /**
     * ɾ��
     */
    protected ActionForward doDelete(ActionMapping actionMapping,
                                     ActionForm actionForm,
                                     HttpServletRequest request,
                                     HttpServletResponse response, User user) throws
            Exception {
        String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
        YxPlanSplitScaleDelegate delegate = new YxPlanSplitScaleDelegate();
        for (int i = 0; i < selectArray.length; i++) {
            if (selectArray[0].indexOf('|') == -1) { //��һ����
                delegate.doRemoveByPK(getDeletePK(selectArray[i]), user);
            } else { //��������
                delegate.doRemoveByVO((YxPlanSplitScaleVO)getDeletePkVO(selectArray[i]), user);
            }
        }

        return doList(actionMapping, actionForm, request, response, user);
    }
    
    public ActionForward doLowGrd(ActionMapping actionMapping,
            ActionForm actionForm,
            HttpServletRequest request,
            HttpServletResponse response, User user) throws
            Exception {
		PrintWriter out = response.getWriter();
		StringBuffer outstring = new StringBuffer("<select name='yxplantypeid'>");
		try {
			response.setContentType("text/html;charset=GBK");
			String rsncode =request.getParameter("rsncode");
			CommonDelegate delegate = new CommonDelegate(YxPlanTypeVO.class);
			YxPlanTypeListVO listVO = new YxPlanTypeListVO();
			listVO.set_ne_yxplankindid(rsncode);
					
			DataPackage dp = delegate.doQuery(listVO, user);
				if (dp != null && dp.getRowCount() >0) {
					for(Iterator it=dp.getDatas().iterator();it.hasNext();) {
						outstring.append("<option value='");
						YxPlanTypeVO disVO = (YxPlanTypeVO)it.next();
						outstring.append(disVO.getYxplantypeid().toString());
						outstring.append("'>");
						outstring.append(disVO.getYxplantypename());
						outstring.append("</option>");
					}
				}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		outstring.append("</select>");
//		response.setCharacterEncoding("UTF-8");
		out.print(Escape.escape(outstring.toString()));

		return null;	
	}
    protected void onDuplicatePk(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) {
    	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "�Ѵ�����ͬ��Ӫ��������ʶ,���˷���һ��ʶ,�������Ͷ���ʶ,��Ŀ��ʶ"); 
    }
}
