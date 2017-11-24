/**
 * auto-generated code
 * Tue Sep 29 10:11:13 CST 2009
 */
 package com.gmcc.pboss.web.communication.questionnaire;

import java.io.File;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.communication.advaffix.AdvaffixVO;
import com.gmcc.pboss.business.communication.questionnaire.QuestionnaireConstant;
import com.gmcc.pboss.business.communication.questionnaire.QuestionnaireDBParam;
import com.gmcc.pboss.business.communication.questionnaire.QuestionnaireVO;
import com.gmcc.pboss.business.communication.questionnaire.QuestionnaireVOHelper;
import com.gmcc.pboss.control.communication.advaffix.Advaffix;
import com.gmcc.pboss.control.communication.advaffix.AdvaffixBO;
import com.gmcc.pboss.control.communication.questionnaire.Questionnaire;
import com.gmcc.pboss.control.communication.questionnaire.QuestionnaireBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: AdvinfoAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class QuestionnaireAction extends BaseAction{
	private String WEB_RESULT_VIEW = "view";
	private File[] docs;
	private String[] docFileNames;
	private String[] docContentTypes;
	
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
	
	public QuestionnaireAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new QuestionnaireForm());
		QuestionnaireWebParam param = new QuestionnaireWebParam();
		param.set_orderby("advinfoid");
		param.set_desc("1");
		param.set_ne_type(String.valueOf(QuestionnaireConstant.TYPE_QUESTIONNAIRE));
		this.setParam(param);

        //指定VO类
        setClsVO(QuestionnaireVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"advinfoid"};
		this.setClsControl(Questionnaire.class);
		this.setClsQueryParam(QuestionnaireDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	public String doNew() throws Exception{
		super.doNew();
		QuestionnaireForm form= (QuestionnaireForm) getForm();
		form.setCurrentdate(new Date());
		return WEB_RESULT_CONTENT;
	};	
	
	public String doEdit() throws Exception{
		super.doEdit();
		QuestionnaireVO questionnaireVO = (QuestionnaireVO) getForm();
		QuestionnaireForm form= new QuestionnaireForm();
		BeanUtils.copyProperties(form, questionnaireVO);
		
		Questionnaire questionnaire = (Questionnaire)BOFactory.build(QuestionnaireBO.class, getDBAccessUser());
		//获取接收对象信息
		String objinfo = questionnaire.doGetObjinfo(form.getAdvinfoid(), String.valueOf(form.getDesttype()));
		//获取附件列表信息
		List<AdvaffixVO> advaffixList = questionnaire.doGetAdvaffixByAdvinfoid(form.getAdvinfoid());
		
		form.setObjinfo(objinfo);
		form.setAdvaffixList(advaffixList);
		form.setCurrentdate(new Date());
		setForm(form);
		return WEB_RESULT_CONTENT;
	}
	
	public String doSave() throws Exception{
		try{
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
					return doEdit();
				}
			}
			
			QuestionnaireForm form= (QuestionnaireForm) getForm();
			Questionnaire questionnaire = (Questionnaire)BOFactory.build(QuestionnaireBO.class, getDBAccessUser());
			QuestionnaireVOHelper helper = new QuestionnaireVOHelper();
			BeanUtils.copyProperties(helper, form);
			
			Boolean createFlag = false;
			
			if(null!=CMD && CMD.equals(WEB_CMD_NEW))
			{
				createFlag = true;
			}
			Long advinfoid = questionnaire.doQueSave(helper,docs,docFileNames,createFlag);
			
			//获取接收对象信息
			String objinfo = questionnaire.doGetObjinfo(advinfoid, String.valueOf(form.getDesttype()));
			//获取附件列表信息
			List<AdvaffixVO> advaffixList = questionnaire.doGetAdvaffixByAdvinfoid(advinfoid);
			
			form.setAdvinfoid(advinfoid);
			form.setObjinfo(objinfo);
			form.setAdvaffixList(advaffixList);
			
			setActionMessage("保存成功!");
			setCMD(WEB_CMD_SAVE);
		}catch(Exception e){
			this.addActionMessage(e.getMessage());
		}		
		
		return WEB_RESULT_CONTENT;
	}
	
	public String doDelete() throws Exception{
		try{
			DBQueryParam dbparam = getParam();
			Questionnaire questionnaire = (Questionnaire)BOFactory.build(QuestionnaireBO.class, getDBAccessUser());
			questionnaire.doQueDelete(dbparam);
		}catch(Exception e){
			this.addActionMessage(e.getMessage());
		}
		return doList();
	}
	
	public String doView() throws Exception{
		super.doEdit();
		QuestionnaireForm form = (QuestionnaireForm)getForm();
		//获取附件列表
		Long advinfoid = form.getAdvinfoid();
		Questionnaire questionnaire = (Questionnaire)BOFactory.build(QuestionnaireBO.class, getDBAccessUser());
		List<AdvaffixVO> advaffixList = questionnaire.doGetAdvaffixByAdvinfoid(advinfoid);
		form.setAdvaffixList(advaffixList);
		
		//获取回复信息列表
		DataPackage dp = questionnaire.doGetReplyByAdvinfoid(advinfoid);
		setDp(dp);
		return WEB_RESULT_VIEW;
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
	
	/**
	 * 附件下载
	 */
	public String doAffixDownloadByPath() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String downloadFilePath = request.getParameter("filePath");
		Advaffix afBo = (Advaffix)BOFactory.build(AdvaffixBO.class, getDBAccessUser());
		if(!StringUtils.isEmpty(downloadFilePath)) {
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
}