/**
 * auto-generated code
 * Mon Jan 04 14:36:52 CST 2010
 */
package com.sunrise.boss.ui.cms.bbc.mmopn;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.bbc.mmopn.persistent.MmopnListVO;
import com.sunrise.boss.business.cms.bbc.mmopn.persistent.MmopnVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.bbc.mmopn.MmopnDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: MmopnAction
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Jerimyy
 * @version 1.0
 */
public class MmopnAction extends BaseDelegateAction {
	public MmopnAction() {
		setVoClass(MmopnVO.class);
		// TODO: ������������������
		this.pkNameArray = new String[1];
		pkNameArray[0] = "opnid";
	}

	/**
	 * ����
	 */
	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
			boolean isMusic=isMusic(request);
		try {
			MmopnVO contentVO = new MmopnVO();
			setSaveVO(contentVO, actionForm); // �ڴ˸�ʽ������� vo �Ա���
			MmopnDelegate delegate = new MmopnDelegate();
			if(isMusic){
				delegate.doCreatemusic(contentVO, user);
			}else
			{
				delegate.doCreate(contentVO, user);
			}
		} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex
					.getMessage());
			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
					"EDIT");
			if(isMusic)
			{
				return (actionMapping.findForward("contentmusic"));	
			}
			else
			{
				return (actionMapping.findForward("content"));	
			}
			
		}
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
		if(isMusic)
		{
			return (actionMapping.findForward("contentmusic"));	
		}
		else
		{
			return (actionMapping.findForward("content"));	
		}
		
	}

	/**            
	 * ����ΪEXCEL��ʽ��
	 */
	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		boolean isMusic=isMusic(request);
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if(isMusic){
			export.setFileName("�������ֹ���");
		}else
		{
			export.setFileName("MMҵ�����");
		}
		export.appendHeadLine(new String[] { "��������:", user.getOpercode() });
		export
				.appendHeadLine(new String[] { "����ʱ��",
						format.format(new Date()) });
		export.addOutputProperty("opnid", "ҵ�����");
		export.addOutputProperty("name", "ҵ������");
		export.addOutputProperty("entid", "��ҵ����");
		export.addOutputProperty("busiid", "�Ʒ�ҵ�����");
		if(!isMusic){
			export.addOutputProperty("acctype", "�Ƴ귽ʽ",CommonExportBean.CODE2NAME,"$CH_ACCTYPE");
		}
		export.addOutputProperty("rewardstd", "����׼",CommonExportBean.NUMBER,"0.0000");
		export.addOutputProperty("state", "��Ч״̬",CommonExportBean.CODE2NAME,"$CH_VALIDFLAG");
		if(!isMusic){
			export.addOutputProperty("ossrc", "����ƽ̨",CommonExportBean.CODE2NAME,"$CH_MMOSSRC");
		}
		export.addOutputProperty("shortopn", "����");
		export.addOutputProperty("wapurl", "WAPӦ��URL");
		export.addOutputProperty("memo", "ҵ����");
		if(!isMusic){
			export.addOutputProperty("opnmon", "ҵ���ʷ�");
		}
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super
				.doExcel(actionMapping, actionForm, request, response, user);
	}
	
	/**
	 * ɾ��
	 */
	public ActionForward doDelete(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
		MmopnDelegate delegate = new MmopnDelegate();
		for (int i = 0; i < selectArray.length; i++) {
			if (selectArray[0].indexOf('|') == -1) { // ��һ����
				MmopnVO vo=delegate.doFindByPk(getDeletePK(selectArray[i]), user);
				delegate.doRemove(vo, user);
			} 
		}
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
		return doList(actionMapping, actionForm, request, response, user);
	}
	
	/**
	 * ��ѯ
	 */
	public ActionForward doList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		//MMOPN or  MUSIC
		boolean flag=isMusic(request);
		Page.setPageSize(request, (BaseActionForm) actionForm);
		Object listVO = getListVO();
		BaseActionForm baseForm = (BaseActionForm) actionForm;
		// BeanUtils.copyProperties(listVO, actionForm);
		
		setListVO(listVO, actionForm); // ���ú�listVO����OrdinaryΪ��ѯ����
		MmopnListVO listParam=(MmopnListVO)listVO;
		//MMOPN ҵ���� ����ҵ��ҵ����뷶Χ��ͬ
		if(flag)
		{
			listParam.set_snl_opnid("050200001");
			listParam.set_snm_opnid("050202000");
		}
		else
		{
			listParam.set_snl_opnid("050100001");
			listParam.set_snm_opnid("050109999");
		}
		CommonDelegate delegate = new CommonDelegate(voClass);
		boolean isDisplayCount = true;
		if (baseForm.get_displaycount() != null && (baseForm.get_displaycount().equalsIgnoreCase("no") || baseForm.get_displaycount().equalsIgnoreCase("false"))) {
			isDisplayCount = false;
		}
		DataPackage dp = delegate.doQuery(listVO, user, isDisplayCount);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		if(flag){
			return (actionMapping.findForward("listmusic"));
		}else
		{
			return (actionMapping.findForward("list"));
		}
	}
	/**
	 * �½�
	 */
	public ActionForward doNew(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		//MMOPN or  MUSIC
		
		// �½�ʱ����form��Ĭ��ֵ
		setNewForm(actionForm);
		String command = getCommandString(request);
		((BaseActionForm) actionForm).setCmdState(command);
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
		if(isMusic(request)){
			return (actionMapping.findForward("contentmusic"));
		}else
		{
		return (actionMapping.findForward("content"));
		}
	}

	/**
	 * �༭
	 */
	public ActionForward doEdit(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		getContentVO(request, user, actionForm);
		String command = getCommandString(request);
		((BaseActionForm) actionForm).setCmdState(command);
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
		if(isMusic(request))
		{
			return (actionMapping.findForward("contentmusic"));
		}else
		{
			return (actionMapping.findForward("content"));
		}
	}
	private boolean isMusic(HttpServletRequest request) throws Exception{
		boolean isMusic=false;
		isMusic="TRUE".equals(request.getParameter("MUSIC"));
		return isMusic;
	}
}
