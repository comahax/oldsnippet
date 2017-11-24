/**
 * auto-generated code
 * Tue Sep 29 10:11:13 CST 2009
 */
package com.gmcc.pboss.web.communication.advinfo;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.communication.advaffix.AdvaffixDBParam;
import com.gmcc.pboss.business.communication.advaffix.AdvaffixVO;
import com.gmcc.pboss.business.communication.advinfo.AdvinfoDBParam;
import com.gmcc.pboss.business.communication.advinfo.AdvinfoVO;
import com.gmcc.pboss.business.communication.advinfo.AdvinfoVOHelper;
import com.gmcc.pboss.business.communication.reply.ReplyDBParam;
import com.gmcc.pboss.control.communication.advaffix.Advaffix;
import com.gmcc.pboss.control.communication.advaffix.AdvaffixBO;
import com.gmcc.pboss.control.communication.advinfo.Advinfo;
import com.gmcc.pboss.control.communication.advinfo.AdvinfoBO;
import com.gmcc.pboss.control.communication.reply.Reply;
import com.gmcc.pboss.control.communication.reply.ReplyBO;
import com.gmcc.pboss.web.communication.advaffix.AdvaffixWebParam;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>
 * Title: AdvinfoAction
 * </p>;
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
 * @author
 * @version 1.0
 */
public class AdvinfoAction extends BaseAction {

	// parameters for upload file
	private File[] docs;

	private String[] docFileNames;

	private String[] docContentTypes;
	
	// �ϴ�����LOGOͼƬ����
	private File logo;
	private String logoFileName;
	private String logoContentType;
	

	// DataPackage for advAffix
	private DataPackage afDp;

	public File[] getDoc() {
		return this.docs;
	}

	public void setDoc(File[] doc) {
		this.docs = doc;
	}

	public String[] getDocFileName() {
		return this.docFileNames;
	}

	public void setDocFileName(String[] docFileName) {
		this.docFileNames = docFileName;
	}

	public String[] getDocContentType() {
		return this.docContentTypes;
	}

	public void setDocContentType(String[] docContentType) {
		this.docContentTypes = docContentType;
	}
	
	public File getLogo() {
		return logo;
	}

	public void setLogo(File logo) {
		this.logo = logo;
	}

	public String getLogoFileName() {
		return logoFileName;
	}

	public void setLogoFileName(String logoFileName) {
		this.logoFileName = logoFileName;
	}

	public String getLogoContentType() {
		return logoContentType;
	}

	public void setLogoContentType(String logoContentType) {
		this.logoContentType = logoContentType;
	}

	public DataPackage getAfDp() {
		return afDp;
	}

	public void setAfDp(DataPackage afDp) {
		this.afDp = afDp;
	}

	public AdvinfoAction() {
		super();

		// ���¼��������Ǳ����
		this.setForm(new AdvinfoForm());

		AdvinfoWebParam param = new AdvinfoWebParam();
		param.set_orderby("advinfoid");
		param.set_desc("1");
		this.setParam(param);
		// ָ��VO��
		setClsVO(AdvinfoVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[] { "advinfoid" };
		this.setClsControl(Advinfo.class);
		this.setClsQueryParam(AdvinfoDBParam.class);

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	/**
	 * ���������ѯ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doList() throws Exception {
		AdvinfoWebParam params = (AdvinfoWebParam) getParam();
		Advinfo aiBo = (Advinfo) BOFactory.build(AdvinfoBO.class,
				getDBAccessUser());
		User user = (User) getDBAccessUser();
		params
				.setSelectFieldsString("advinfoid,rvcobjid,title,content,type,releasetime,plantime,enddate,desttype,smsnotify, ndapproval, oprcode, state, url");
		DataPackage dp = aiBo.doPendTaskQuery(params, user.getOprcode());
		if (dp != null && dp.getDatas().size() > 0) {
			setDp(dp);
		} else {

		}
		return "list";
	}

	/**
	 * ��������ѯ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doAdvlist() throws Exception {
		try {
			AdvinfoDBParam params = (AdvinfoDBParam) getParam();
			List types = new ArrayList();
			types.add(1);
			types.add(6);
			params.set_nin_type(types);
			super.doList();
			return "advlist";
		} catch (Exception ex) {
			ex.printStackTrace();
			super.addActionError(ex.getMessage());
		}
		return "advlist";
	}

	/**
	 * ��������ɾ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doAdvdelete() throws Exception {
		try{
			Advinfo aiBo = (AdvinfoBO) BOFactory.build(AdvinfoBO.class,
					getDBAccessUser());
			String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
			if (selectArray == null) {
				addActionError("�޷���ȡѡ����Ŀ��");
				return "list";
			}
			aiBo.doRemoveAdvByIds(selectArray);			
		}catch(Exception e){
			this.addActionMessage(e.getMessage());
		}
		return doAdvlist();
	}

	public String doNew() throws Exception {
		super.doNew();
		AdvinfoForm form = (AdvinfoForm) getForm();
		form.setCurrentdate(new Date());
		return WEB_RESULT_CONTENT;
	};

	/**
	 * ֪ʶ��򹫸�����޸�
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doKrOrAdvedit() throws Exception {
		HttpServletRequest request = getRequest();
		Advaffix afBo = (AdvaffixBO) BOFactory.build(AdvaffixBO.class,
				getDBAccessUser());
		AdvaffixWebParam params = new AdvaffixWebParam();
		if (!StringUtils.isEmpty(request.getParameter("param._pk"))) {
			params.set_ne_advinfoid(request.getParameter("param._pk"));
			this.CMD = WEB_CMD_EDIT;
		} else {
			Long advinfoid = (Long) request.getAttribute("advinfoid");
			if (advinfoid != null) {
				params.set_ne_advinfoid(advinfoid.toString());
				getParam().set_pk(advinfoid.toString());
				this.CMD = WEB_CMD_SAVE;
			}
		}
		params.set_pagesize("0");
		DataPackage dp = afBo.doQuery(params);
		setDp(dp);

		super.doEdit();
		AdvinfoForm form = (AdvinfoForm) getForm();
		// ����ҳ�����ѡ����Ϣ
		if (form.getDesttype() == 4 || form.getDesttype() == 5) {
			Advinfo aiBo = (AdvinfoBO) BOFactory.build(AdvinfoBO.class,
					getDBAccessUser());
			String objinfo = aiBo.doGetObjinfo(form.getAdvinfoid(), String
					.valueOf(form.getDesttype()));
			form.setObjinfo(objinfo);

		}
		form.setCurrentdate(new Date());
		setForm(form);
		return WEB_RESULT_CONTENT;
	}

	public String doAdvsave() throws Exception {
		
		// �������ϴ�����������Action��������Ӧ���ڷ�����ǰ�����Ȼ�ȡActionMessages��
		// ���ж��Ƿ����ϴ��ļ���С�����Ͳ����ϵ���Ϣ
		Collection<String> actionMessages = this.getActionMessages();
		if(actionMessages != null && actionMessages.size() > 0) {
			Advaffix advaffix = (AdvaffixBO) BOFactory.build(AdvaffixBO.class, getDBAccessUser());
			Collection<String> actionMessagesTrans = advaffix.doGetTooLargerMsg(actionMessages);
			this.setActionMessages(actionMessagesTrans);
			if (WEB_CMD_NEW.equals(CMD)) {
				return WEB_RESULT_CONTENT;
			}else if (WEB_CMD_EDIT.equals(CMD)) {
				return doKrOrAdvedit();
			}
		}
		Advinfo aiBo = (AdvinfoBO) BOFactory.build(AdvinfoBO.class,
				getDBAccessUser());
		AdvinfoForm form = (AdvinfoForm) getForm();
		AdvinfoVOHelper avHelper = new AdvinfoVOHelper();
		BeanUtils.copyProperties(avHelper, form);
		HttpServletRequest request = getRequest();
		String delAffixs = request.getParameter("delaffixs");

		AdvinfoVO aiVo = new AdvinfoVO();
		try {
			if (WEB_CMD_NEW.equals(CMD)) {
				aiVo = aiBo.doAdvSave(avHelper, docs, docFileNames, logo, logoFileName, null);
				this.CMD = WEB_CMD_SAVE;
				request.setAttribute("advinfoid", aiVo.getAdvinfoid());
				this.setActionMessage("����¼��ɹ�!");
			} else if (WEB_CMD_EDIT.equals(CMD)) {
				aiVo = aiBo.doAdvSave(avHelper, docs, docFileNames ,logo,logoFileName, delAffixs);
				this.setActionMessage("�����޸ĳɹ�!");
			}

			// ��ȡ���ն�����Ϣ
			String objinfo = aiBo.doGetObjinfo(aiVo.getAdvinfoid(), String
					.valueOf(form.getDesttype()));
			form.setObjinfo(objinfo);
			return "returnEdit";
		} catch (Exception ex) {
			addActionMessage(ex.getMessage());
			return "returnEdit";
		}
	}

	/**
	 * ����������Ϣ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doApprovalSave() throws Exception {
		Advinfo aiBo = (AdvinfoBO) BOFactory.build(AdvinfoBO.class,
				getDBAccessUser());
		AdvinfoForm form = (AdvinfoForm) getForm();
		AdvinfoVOHelper avHelper = new AdvinfoVOHelper();
		BeanUtils.copyProperties(avHelper, form);
		try {
			aiBo.doApprovalSave(avHelper);
			this.setActionMessage("���������ɹ�!");
			AdvinfoWebParam param = new AdvinfoWebParam();
			param.set_orderby("advinfoid");
			param.set_desc("1");
			this.setParam(param);
			return doAdvlist();
		} catch (Exception ex) {
			addActionError(ex.getMessage());
			return "advApproval";
		}
	}

	/**
	 * ����ѧϰ�б�
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doKrlist() throws Exception {
		AdvinfoWebParam params = (AdvinfoWebParam) getParam();
		params.set_ne_type("4");
		super.doList();
		return "krlist";
	}

	/**
	 * ����ѧϰɾ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doKrdelete() throws Exception {
		String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
		Advinfo aiBo = (Advinfo) BOFactory.build(AdvinfoBO.class,
				getDBAccessUser());
		if (selectArray == null) {
			addActionError("�޷���ȡѡ����Ŀ��");
			return "krlist";
		}
		try {
			for (int i = 0; i < selectArray.length; i++) {
				aiBo.doRemoveKrByAdvinfoid(Long.valueOf(selectArray[i]));
			}
		} catch (Exception ex) {
			addActionError(ex.getMessage());
		}
		return doKrlist();
	}

	/**
	 * �����ʴ��б�
	 * 
	 * @return
	 * @throws Exception
	 */
	public String qalist() throws Exception {
		AdvinfoWebParam params = (AdvinfoWebParam) getParam();
		try {

			Advinfo aiBo = (Advinfo) BOFactory.build(AdvinfoBO.class,
					getDBAccessUser());
			DataPackage dp = aiBo.doQAOnlineQuery(params);
			setDp(dp);
		} catch (Exception ex) {
			ex.printStackTrace();
			setActionMessage(ex.getMessage());
		}
		return "qalist";
	}

	/**
	 * ֪ʶ��¼��
	 * 
	 * @return
	 * @throws Exception
	 */
	public String krsave() throws Exception {
		
		// �������ϴ�����������Action��������Ӧ���ڷ�����ǰ�����Ȼ�ȡActionMessages��
		// ���ж��Ƿ����ϴ��ļ���С�����Ͳ����ϵ���Ϣ
		Collection<String> actionMessages = this.getActionMessages();
		if(actionMessages != null && actionMessages.size() > 0) {
			Advaffix advaffix = (AdvaffixBO) BOFactory.build(AdvaffixBO.class, getDBAccessUser());
			Collection<String> actionMessagesTrans = advaffix.doGetTooLargerMsg(actionMessages);
			this.setActionMessages(actionMessagesTrans);
			if (WEB_CMD_NEW.equals(CMD)) {
				return WEB_RESULT_CONTENT;
			}else if (WEB_CMD_EDIT.equals(CMD)) {
				return doKrOrAdvedit();
			}
		}
		
		AdvinfoBO aiBo = (AdvinfoBO) BOFactory.build(AdvinfoBO.class,
				getDBAccessUser());
		AdvinfoForm aiForm = (AdvinfoForm) getForm();
		AdvinfoVOHelper avHelper = new AdvinfoVOHelper();
		BeanUtils.copyProperties(avHelper, aiForm);
		HttpServletRequest request = getRequest();
		String delAffixs = request.getParameter("delaffixs");
		try {
			if (WEB_CMD_NEW.equals(CMD)) {
				AdvinfoVO aiVo = aiBo.doKrSave(avHelper, docs, docFileNames,
						delAffixs, true);
				this.CMD = WEB_CMD_SAVE;
				request.setAttribute("advinfoid", aiVo.getAdvinfoid());
				this.setActionMessage("֪ʶ��¼��ɹ�!");
			} else if (WEB_CMD_EDIT.equals(CMD)) {
				aiBo.doKrSave(avHelper, docs, docFileNames, delAffixs, false);
				this.setActionMessage("֪ʶ���޸ĳɹ�!");
			}
			return "returnEdit";
		} catch (Exception ex) {
			addActionMessage(ex.getMessage());
			return "returnEdit";
		}

	}

	// ����鿴
	public String doAdvreply() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String advinfoid = request.getParameter("param._ne_advinfoid");

		// ���ݹ����ʶ��ѯ[������Ϣ��]��ȡ���������Ϣ
		Advinfo aiBo = (AdvinfoBO) BOFactory.build(AdvinfoBO.class,
				getDBAccessUser());
		AdvinfoVO aiVo = aiBo.doFindByPk(new Long(advinfoid));
		this.setForm(new AdvinfoForm());
		BeanUtils.copyProperties(getForm(), aiVo);

		// ���ݹ����ʶ��ѯ[���渽����CH_PW_ADVAFFIX]��ȡ����ĸ�����Ϣ
		Advaffix afBo = (AdvaffixBO) BOFactory.build(AdvaffixBO.class,
				getDBAccessUser());
		AdvaffixDBParam afParams = new AdvaffixDBParam();
		afParams.set_ne_advinfoid(advinfoid);
		DataPackage afDp = afBo.doQuery(afParams);
		setAfDp(afDp);

		// ���ݹ����ʶ��ѯ[�ظ���Ϣ��CH_PW_REPLY]��ѯ�ظ���Ϣ
		Reply reBo = (ReplyBO) BOFactory
				.build(ReplyBO.class, getDBAccessUser());
		ReplyDBParam reParams = new ReplyDBParam();
		reParams.set_ne_advinfoid(advinfoid);
		reParams.set_pageno(param.get_pageno());
		DataPackage dp = reBo.doQueryReplyInfo(reParams);
		setDp(dp);

		return "advReply";
	}

	// ��������
	public String advApproval() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String advinfoid = request.getParameter("param._ne_advinfoid");

		// ���ݹ����ʶ��ѯ[������Ϣ��]��ȡ���������Ϣ
		Advinfo aiBo = (AdvinfoBO) BOFactory.build(AdvinfoBO.class,
				getDBAccessUser());
		AdvinfoVO aiVo = aiBo.doFindByPk(new Long(advinfoid));
		this.setForm(new AdvinfoForm());
		BeanUtils.copyProperties(getForm(), aiVo);

		// ���ݹ����ʶ��ѯ[���渽����CH_PW_ADVAFFIX]��ȡ����ĸ�����Ϣ
		Advaffix afBo = (AdvaffixBO) BOFactory.build(AdvaffixBO.class,
				getDBAccessUser());
		AdvaffixDBParam afParams = new AdvaffixDBParam();
		afParams.set_ne_advinfoid(advinfoid);
		DataPackage afDp = afBo.doQuery(afParams);
		setAfDp(afDp);

		return "advApproval";
	}

	public String doQareply() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String advinfoid = request.getParameter("param._ne_advinfoid");

		// ���ݹ����ʶ��ѯ[������Ϣ��]��ȡ���������Ϣ
		Advinfo aiBo = (AdvinfoBO) BOFactory.build(AdvinfoBO.class,
				getDBAccessUser());
		AdvinfoVO aiVo = aiBo.doFindByPk(new Long(advinfoid));
		this.setForm(new AdvinfoForm());
		BeanUtils.copyProperties(getForm(), aiVo);

		// ���ݹ����ʶ��ѯ[���渽����CH_PW_ADVAFFIX]��ȡ����ĸ�����Ϣ
		Advaffix afBo = (AdvaffixBO) BOFactory.build(AdvaffixBO.class,
				getDBAccessUser());
		AdvaffixDBParam afParams = new AdvaffixDBParam();
		afParams.set_ne_advinfoid(advinfoid);
		DataPackage afDp = afBo.doQuery(afParams);
		setAfDp(afDp);

		// ���ݹ����ʶ��ѯ[�ظ���Ϣ��CH_PW_REPLY]��ѯ�ظ���Ϣ
		Reply reBo = (ReplyBO) BOFactory
				.build(ReplyBO.class, getDBAccessUser());
		ReplyDBParam reParams = new ReplyDBParam();
		reParams.set_ne_advinfoid(advinfoid);
		reParams.set_pageno(param.get_pageno());
		DataPackage dp = reBo.doQueryReplyInfo(reParams);
		setDp(dp);

		return "qareply";
	}

	/**
	 * �ر�����
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doQaclose() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String advinfoid = request.getParameter("param._ne_advinfoid");

		// ���ݹ����ʶ��ѯ[������Ϣ��]��ȡ���������Ϣ
		Advinfo aiBo = (AdvinfoBO) BOFactory.build(AdvinfoBO.class,
				getDBAccessUser());
		AdvinfoVO aiVo = aiBo.doFindByPk(new Long(advinfoid));
		aiVo.setState(new Short("4"));
		aiBo.doUpdate(aiVo);
		return "qareply";
	}
	
	/**�����ļ�������ʱ��ת����action����*/
	private String downloadReturnActionName;
	/**�����ļ�������ʱ��ת��action�еĴ�����*/
	private String downloadReturnMethod;
	
	public String getDownloadReturnActionName() {
		return downloadReturnActionName;
	}

	public void setDownloadReturnActionName(String downloadReturnActionName) {
		this.downloadReturnActionName = downloadReturnActionName;
	}

	public String getDownloadReturnMethod() {
		return downloadReturnMethod;
	}

	public void setDownloadReturnMethod(String downloadReturnMethod) {
		this.downloadReturnMethod = downloadReturnMethod;
	}

	/**
	 * ��������
	 */
	public String doAffixDownload() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String affixid = request.getParameter("affixid");
		Advaffix afBo = (Advaffix)BOFactory.build(AdvaffixBO.class, getDBAccessUser());
		AdvaffixVO afVo = afBo.doFindByPk(new Long(affixid));
		if(afVo != null) {
			String downloadFilePath = afVo.getAffixpath();
			if(downloadFilePath!=null && !"".equals(downloadFilePath)){
				try {
					afBo.doDownloadAffixs(downloadFilePath, this.getResponse());
					return null;
				}catch(Exception ex) {
					addActionMessage(ex.getMessage());
					return INPUT;
				}
			}
			return INPUT;
		}
		return INPUT;
	}

}