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
	
	// 上传公告LOGO图片参数
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

		// 以下几个方法是必须的
		this.setForm(new AdvinfoForm());

		AdvinfoWebParam param = new AdvinfoWebParam();
		param.set_orderby("advinfoid");
		param.set_desc("1");
		this.setParam(param);
		// 指定VO类
		setClsVO(AdvinfoVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[] { "advinfoid" };
		this.setClsControl(Advinfo.class);
		this.setClsQueryParam(AdvinfoDBParam.class);

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	/**
	 * 待办任务查询
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
	 * 公告管理查询
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
	 * 公共管理删除
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
				addActionError("无法获取选中项目！");
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
	 * 知识库或公告管理修改
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
		// 查找页面对象选择信息
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
		
		// 凡是有上传附件操作的Action方法，都应该在方法最前面首先获取ActionMessages，
		// 以判断是否有上传文件大小、类型不符合的信息
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
				this.setActionMessage("公告录入成功!");
			} else if (WEB_CMD_EDIT.equals(CMD)) {
				aiVo = aiBo.doAdvSave(avHelper, docs, docFileNames ,logo,logoFileName, delAffixs);
				this.setActionMessage("公告修改成功!");
			}

			// 获取接收对象信息
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
	 * 保存审批信息
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
			this.setActionMessage("公告审批成功!");
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
	 * 在线学习列表
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
	 * 在线学习删除
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doKrdelete() throws Exception {
		String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
		Advinfo aiBo = (Advinfo) BOFactory.build(AdvinfoBO.class,
				getDBAccessUser());
		if (selectArray == null) {
			addActionError("无法获取选中项目！");
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
	 * 在线问答列表
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
	 * 知识库录入
	 * 
	 * @return
	 * @throws Exception
	 */
	public String krsave() throws Exception {
		
		// 凡是有上传附件操作的Action方法，都应该在方法最前面首先获取ActionMessages，
		// 以判断是否有上传文件大小、类型不符合的信息
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
				this.setActionMessage("知识库录入成功!");
			} else if (WEB_CMD_EDIT.equals(CMD)) {
				aiBo.doKrSave(avHelper, docs, docFileNames, delAffixs, false);
				this.setActionMessage("知识库修改成功!");
			}
			return "returnEdit";
		} catch (Exception ex) {
			addActionMessage(ex.getMessage());
			return "returnEdit";
		}

	}

	// 公告查看
	public String doAdvreply() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String advinfoid = request.getParameter("param._ne_advinfoid");

		// 根据公告标识查询[公告信息表]获取公告相关信息
		Advinfo aiBo = (AdvinfoBO) BOFactory.build(AdvinfoBO.class,
				getDBAccessUser());
		AdvinfoVO aiVo = aiBo.doFindByPk(new Long(advinfoid));
		this.setForm(new AdvinfoForm());
		BeanUtils.copyProperties(getForm(), aiVo);

		// 根据公告标识查询[公告附件表CH_PW_ADVAFFIX]获取公告的附件信息
		Advaffix afBo = (AdvaffixBO) BOFactory.build(AdvaffixBO.class,
				getDBAccessUser());
		AdvaffixDBParam afParams = new AdvaffixDBParam();
		afParams.set_ne_advinfoid(advinfoid);
		DataPackage afDp = afBo.doQuery(afParams);
		setAfDp(afDp);

		// 根据公告标识查询[回复信息表CH_PW_REPLY]查询回复信息
		Reply reBo = (ReplyBO) BOFactory
				.build(ReplyBO.class, getDBAccessUser());
		ReplyDBParam reParams = new ReplyDBParam();
		reParams.set_ne_advinfoid(advinfoid);
		reParams.set_pageno(param.get_pageno());
		DataPackage dp = reBo.doQueryReplyInfo(reParams);
		setDp(dp);

		return "advReply";
	}

	// 公告审批
	public String advApproval() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String advinfoid = request.getParameter("param._ne_advinfoid");

		// 根据公告标识查询[公告信息表]获取公告相关信息
		Advinfo aiBo = (AdvinfoBO) BOFactory.build(AdvinfoBO.class,
				getDBAccessUser());
		AdvinfoVO aiVo = aiBo.doFindByPk(new Long(advinfoid));
		this.setForm(new AdvinfoForm());
		BeanUtils.copyProperties(getForm(), aiVo);

		// 根据公告标识查询[公告附件表CH_PW_ADVAFFIX]获取公告的附件信息
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

		// 根据公告标识查询[公告信息表]获取公告相关信息
		Advinfo aiBo = (AdvinfoBO) BOFactory.build(AdvinfoBO.class,
				getDBAccessUser());
		AdvinfoVO aiVo = aiBo.doFindByPk(new Long(advinfoid));
		this.setForm(new AdvinfoForm());
		BeanUtils.copyProperties(getForm(), aiVo);

		// 根据公告标识查询[公告附件表CH_PW_ADVAFFIX]获取公告的附件信息
		Advaffix afBo = (AdvaffixBO) BOFactory.build(AdvaffixBO.class,
				getDBAccessUser());
		AdvaffixDBParam afParams = new AdvaffixDBParam();
		afParams.set_ne_advinfoid(advinfoid);
		DataPackage afDp = afBo.doQuery(afParams);
		setAfDp(afDp);

		// 根据公告标识查询[回复信息表CH_PW_REPLY]查询回复信息
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
	 * 关闭提问
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doQaclose() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String advinfoid = request.getParameter("param._ne_advinfoid");

		// 根据公告标识查询[公告信息表]获取公告相关信息
		Advinfo aiBo = (AdvinfoBO) BOFactory.build(AdvinfoBO.class,
				getDBAccessUser());
		AdvinfoVO aiVo = aiBo.doFindByPk(new Long(advinfoid));
		aiVo.setState(new Short("4"));
		aiBo.doUpdate(aiVo);
		return "qareply";
	}
	
	/**下载文件不存在时跳转到的action请求*/
	private String downloadReturnActionName;
	/**下载文件不存在时跳转的action中的处理方法*/
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
	 * 附件下载
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