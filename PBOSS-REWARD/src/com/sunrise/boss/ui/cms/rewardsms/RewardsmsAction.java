/**
* auto-generated code
* Thu Jul 28 10:25:58 CST 2011
*/
package com.sunrise.boss.ui.cms.rewardsms;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.rewardsms.persistent.RewardsmsListVO;
import com.sunrise.boss.business.cms.rewardsms.persistent.RewardsmsVO;
import com.sunrise.boss.business.cms.smstmpl.persistent.SmstmplVO;
import com.sunrise.boss.business.cms.waitreq.persistent.WaitreqVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.cms.rewardsms.RewardsmsDelegate;
import com.sunrise.boss.delegate.cms.smstmpl.SmstmplDelegate;
import com.sunrise.boss.delegate.cms.waitreq.WaitreqDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: RewardsmsAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class RewardsmsAction extends BaseDelegateAction {
    public RewardsmsAction() {
            setVoClass(RewardsmsVO.class);
        // TODO: ������������������
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seq"; 
    }
    
	/**
	 * �½�
	 */
	protected ActionForward doNew(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		// ���÷ֹ�˾��Լ������
		request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
		return super.doNew(actionMapping, actionForm, request, response, user);
	}
	
	/**
	 * �༭
	 */
	protected ActionForward doEdit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		// ���÷ֹ�˾��Լ������
		request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
		return super.doEdit(actionMapping, actionForm, request, response, user);
	}
	
	/**
	 * ����
	 */
	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		RewardsmsForm form = (RewardsmsForm) actionForm;
		RewardsmsVO contentVO = new RewardsmsVO();
		setSaveVO(contentVO, form);

		RewardsmsDelegate delegate = new RewardsmsDelegate();

		try {
			String cmdState = form.getCmdState();
			if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {
				RewardsmsVO existObj = delegate.doFindByPk(contentVO.getSeq(),
						user);
				if (existObj != null) {
					org.apache.commons.beanutils.BeanUtils.copyProperties(existObj,
							contentVO);
					contentVO = existObj;
				}
				// ���ò�������Ϊ����
				contentVO.setOpertype("U");
				// ���ò�������Ϊ����
				contentVO.setOpertime(new Date());
				// ���ò�������Ϊ��¼����
				contentVO.setOpercode(user.getOpercode());
				contentVO = delegate.doUpdate(contentVO, user);
			} else {
				RewardsmsListVO listvo = new RewardsmsListVO();
				listvo.set_se_countyid(contentVO.getCountyid());
				listvo.set_se_calcmonth(contentVO.getCalcmonth());
				DataPackage dp = delegate.doQuery(listvo, user);
				if (contentVO.getCountyid() != null && dp != null && dp.getRowCount() != 0) {
					request.setAttribute(
							WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
							WebConstant.COMMAND_STRING_EDIT);
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"��ʾ���������Ѿ����ڡ�");
					request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
					return (actionMapping.findForward("content"));
				} else {
					// ���ò�������Ϊ����
					contentVO.setOpertype("I");
					// ���ò�������Ϊ����
					contentVO.setOpertime(new Date());
					// ���ò�������Ϊ��¼����
					contentVO.setOpercode(user.getOpercode());
					contentVO = delegate.doCreate1(contentVO, user);
				}
			}
			BeanUtils.copyProperties(actionForm, contentVO);
			((BaseActionForm) actionForm)
					.setCmdState(WebConstant.COMMAND_STRING_EDIT);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.toString());
		} catch (Exception e) {
			throw e;
		}

		request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
		return (actionMapping.findForward("content"));
	}
	
    /**
     * ���²��Է��Ͱ�ť����������ֻ��ŵ���Ϣ���뵽���Ŵ����ͱ�
     * @param actionMapping
     * @param actionForm
     * @param request
     * @param response
     * @param user
     * @return
     * @throws Exception
     */
    public ActionForward doSendtest(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception{
    	
//    	RewardsmsForm form = (RewardsmsForm)actionForm;  	
    	// ȡ�ö�������
    	Map<String, String> map = new HashMap<String, String>();
    	String content = doGenSMS("CH_INFOTOWAY", map, user);
    	
    	// ȡ�õ����ֻ���
    	String officetel = request.getParameter("no");//form.getOfficetel();
    	
    	// ������Ŵ����ͱ�
    	WaitreqDelegate wdelegate = new WaitreqDelegate();
    	WaitreqVO wvo = new WaitreqVO();
    	wvo.setSmstype(new Short("2"));
    	wvo.setAreacode(SessionFactoryRouter.conversionCityid(user.getCityid()));
    	wvo.setCreattime(new Date());
    	wvo.setDealtime(new Date());
    	wvo.setMessage(content);
    	wvo.setSendno("10086");
    	wvo.setRecno(officetel);
    	wvo.setDealcount(new Short("0"));
    	wvo.setIssuccess(new Short("0"));
    	wdelegate.doCreate(wvo, user);
    	
		return (actionMapping.findForward("list"));
    }
    
    /**
     * ����ģ��ӿ�
     */
	public static String doGenSMS(String sId, Map<String,String> keyAndValue, User user) throws Exception{

		SmstmplDelegate delegate = new SmstmplDelegate();
		SmstmplVO vo = delegate.doFindByPk(sId, user);
		//�ҵ���Ӧ����ģ��
		if(vo.getScontent() != null)
		{
			String content = vo.getScontent();
			
			//�滻����
			String key = new String();
			String value = new String();

			for(Iterator<String> iter = keyAndValue.keySet().iterator(); iter.hasNext();)
			{
				key = iter.next();
				value = keyAndValue.get(key);
				content = content.replaceAll("\\{" + key + "\\}", value);
			}
			return content;
		}
		else
		{
			return "";
		}
	}
}
