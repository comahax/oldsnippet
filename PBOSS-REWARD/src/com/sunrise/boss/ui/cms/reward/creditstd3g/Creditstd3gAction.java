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
        // TODO: ������������������
           this.pkNameArray = new String[2]; 
           pkNameArray[0] = "cityid"; 
           pkNameArray[1] = "wayattr"; 
    }
    
    /**
	 * ��ѯ ��Ȧ�ŵ겹�������������
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
	 * ��ѯ ��Ȧ�ŵ겹������׼չ��
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
	 * ��ѯ ��Ȧ�ŵ겹������׼����
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
	 * ����
	 */
	public ActionForward doSave(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		Creditstd3gVO contentVO = (Creditstd3gVO)voClass.newInstance();
		setSaveVO(contentVO, actionForm); // �ڴ˸�ʽ������� vo �Ա���

		Creditstd3gDelegate delegate = new Creditstd3gDelegate();
		String cmdState = ((BaseActionForm) actionForm).getCmdState();
		if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {// ����
			delegate.doUpdate(contentVO, user);
			BeanUtils.copyProperties(actionForm, contentVO); // �Ѹ��º��ֵ����form������web��ʾ
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
		} else {// ����
			Object vo = null;
			if (pkNameArray.length == 1) { // ��һ����
				Object pk = PropertyUtils.getNestedProperty(contentVO, pkNameArray[0]);
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
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
			} else {
				request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "�����ظ�");
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
				throw new Exception("��������"+pk+"�޷��鵽����");
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
			throw new Exception("����׼���ܳ���ʡ��˾���ó������");
		}
		Creditstd3gVO vo = new Creditstd3gVO();
		BeanUtils.copyProperties(vo, vvo);
		Creditstd3gDelegate delegate = new Creditstd3gDelegate();
		delegate.doUpdate(vo, user);
		BeanUtils.copyProperties(actionForm, vo);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
		
		return (actionMapping.findForward("contentstdset"));
	}
	
	/**
	 * �Ƹ���Ȧ�ŵ겹������׼����
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
				throw new Exception("��������"+pk+"�޷��鵽����");
			}
		}catch(Exception ex){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
		}
		return actionMapping.findForward("contentyf");
	}
	
	/**
	 * �Ƹ���Ȧ�ŵ겹������׼����
	 */
	public ActionForward doSaveyf(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try{
			VCreditstd3gVO vvo = new VCreditstd3gVO();
			this.setSaveVO(vvo, actionForm);
			double rewardstd = vvo.getZyrewardstd() + vvo.getJfrewardstd();
			if(rewardstd > vvo.getRewardstdup()){
				throw new Exception("רӪ��������׼�����ֽ�������׼֮�Ͳ��ܳ���ʡ��˾���ó������");
			}
			vvo.setRewardstd(rewardstd);
			Creditstd3gVO vo = new Creditstd3gVO();
			BeanUtils.copyProperties(vo, vvo);
			Creditstd3gDelegate delegate = new Creditstd3gDelegate();
			delegate.doUpdate(vo, user);
			BeanUtils.copyProperties(actionForm, vo);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
		}catch(Exception ex){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
		}
		return actionMapping.findForward("contentyf");
	}
}
