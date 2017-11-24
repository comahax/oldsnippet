package com.gmcc.pboss.web.reward.setcard;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gmcc.pboss.business.reward.setcard.SetcardDBParam;
import com.gmcc.pboss.business.reward.setcard.SetcardVO;
import com.gmcc.pboss.business.reward.setcard.VSetcardDBParam;
import com.gmcc.pboss.business.reward.setcard.VSetcardVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.common.utils.tools.DateUtil;
import com.gmcc.pboss.control.reward.setcard.Setcard;
import com.gmcc.pboss.control.reward.setcard.SetcardBO;
import com.gmcc.pboss.control.reward.setcard.VSetcard;
import com.gmcc.pboss.control.reward.setcard.VSetcardBO;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>
 * Title: SetcardAction
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2010
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author lej
 * @version 1.0
 */
public class SetcardAction extends BaseAction {

	private static final long serialVersionUID = -6818370517519651343L;

	private final Logger log = LoggerFactory.getLogger(SetcardAction.class);
	
	private String dateformat1="yyyy-MM-dd";
	private String dateformat2="yyyyMMdd";

	public SetcardAction() {
		super();

		this.setForm(new SetcardForm());
		this.setParam(new SetcardDBParam());

		setClsVO(SetcardVO.class);
		this.pkNameArray = new String[] { "seq" };
		this.setClsControl(Setcard.class);
		this.setClsQueryParam(SetcardDBParam.class);
	}

	private void setErrorLog(String error) {
		log.error(error);
		addActionError(error);
	}

	public String doList() {
	
		User user = (User) getDBAccessUser();
		SetcardDBParam params = (SetcardDBParam) getParam();

	
		
		String actvday = params.get_se_actvday();
		if (StringUtils.isNotEmpty(actvday)) {
			String actvday1 = DateUtil.date2String(DateUtil.parseDate(actvday, dateformat1), dateformat2);
			params.set_se_actvday(actvday1);
		}

		try {

			Setcard setcard = (Setcard) BOFactory.build(SetcardBO.class, user);
			DataPackage dp = setcard.doQuery(params);
			setDp(dp);

		} catch (SQLException e) {
			setErrorLog("���ݿ����Ӵ��� \n" + e.getMessage());
		} catch (Exception e) {
			setErrorLog("�������� \n" + e.getMessage());
		}
		
		return "list";
	}

	/**
	 * ɾ��
	 */
	public String doDelete() {

		String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
		Setcard setcard = null;

		try {
			setcard = (Setcard) BOFactory.build(SetcardBO.class,
					getDBAccessUser());

		} catch (SQLException e) {
			setErrorLog("���ݿ����Ӵ��� \n" + e.getMessage());
			return doList();
		} catch (Exception e) {
			setErrorLog("�������� \n" + e.getMessage());
			return doList();
		}

		for (int i = 0; i < selectArray.length; i++) {
			String param = selectArray[i];

			if (StringUtils.isEmpty(param)) {
				continue;
			}

			try {
				setcard.doRemoveByPK(getSelectedPK(param));
			} catch (SQLException e) {
				setErrorLog("���ݿ����Ӵ��� \n" + e.getMessage());
			} catch (Exception e) {
				setErrorLog("�������� \n" + e.getMessage());
			}
		}

		return doList();
	}

	public String doSave() {
		User user = (User) getDBAccessUser();

		SetcardForm setcardForm = (SetcardForm) getForm();
		try {
			Setcard setcard = (Setcard) BOFactory.build(SetcardBO.class, user);
			
			//�������ڸ�ʽ
			String actvday = setcardForm.getActvday();
			if(StringUtils.isNotEmpty(actvday)){
				String actvday1 = DateUtil.date2String(DateUtil.parseDate(actvday, dateformat1), dateformat2);
				setcardForm.setActvday(actvday1);
			}

			if ("NEW".equals(CMD)) {				
				
				//��������ʱ��
				setcardForm.setIntime(DateUtil.getCurrentDate());

				SetcardVO setcardVO = new SetcardVO();
				BeanUtils.copyProperties(setcardVO, setcardForm);
				setcardVO = setcard.doCreate(setcardVO);
				
				//������ɺ󽫼��������������ڷ��Ӹ�ҳ��
				setcardVO.setActvday(actvday);
				BeanUtils.copyProperties(getForm(), setcardVO);

			} else if ("EDIT".equals(CMD)) {
				SetcardVO vo = setcard.doFindByPk(setcardForm.getSeq());
				setcardForm.setIntime(vo.getIntime());

				BeanUtils.copyProperties(vo, setcardForm);
				vo = setcard.doUpdate(vo);
				
				//�޸���ɺ󽫼��������������ڷ��Ӹ�ҳ��
				vo.setActvday(actvday);
				BeanUtils.copyProperties(getForm(), vo);
			}
		} catch (SQLException e) {
			setErrorLog("���ݿ����Ӵ��� \n" + e.getMessage());
		} catch (Exception e) {
			setErrorLog("�������� \n" + e.getMessage());
		}
		setActionMessage("�����ɹ�!");
		this.CMD=WEB_CMD_SAVE;
		return "content";
	}
	
	public String doEdit() throws Exception{
		BaseVO vo = findVOFromDB();
		BaseVO form =getForm(); 
		
		BeanUtils.copyProperties(form, vo);	
		
		SetcardVO svo = (SetcardVO)form;
		String actvday = svo.getActvday();
		if(StringUtils.isNotEmpty(actvday)){
			String actvday1 = DateUtil.date2String(DateUtil.parseDate(actvday, dateformat1), dateformat2);
			svo.setActvday(actvday1);
		}
		setForm(svo);
		this.CMD = WEB_CMD_EDIT;
		return WEB_RESULT_CONTENT;
	}
	
	public String doExportExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�׿������������ݹ���");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export.appendHeadLine(new String[] { "����ʱ��", format.format(new Date()) });
		export.addOutputProperty("wayid", "��������");
		export.addOutputProperty("actvday", "��������");
		export.addOutputProperty("mobile", "����");
		export.addOutputProperty("cityname", "����");
		export.addOutputProperty("waytypename", "��������");
		export.addOutputProperty("intime", "���ʱ��",export.DATE,"yyyy-MM-dd hh:mm:ss");
		export.addOutputProperty("filename", "�ļ���");
		export.addOutputProperty("comname", "Ʒ��");

		// ����VO��
		export.voClassArray = new Class[] { VSetcardVO.class };

		// ���ò�ѯ����
		export.queryMethodName = "doExportList";
		SetcardDBParam params = (SetcardDBParam) getParam();
		
		VSetcardDBParam vparams = new VSetcardDBParam();
		
		String wayid = params.get_se_wayid();
		if(StringUtils.isNotEmpty(wayid)){
			vparams.set_se_wayid(wayid);
		}
		String actvday = params.get_se_actvday();
		if(StringUtils.isNotEmpty(actvday)){
			String actvday1 = DateUtil.date2String(DateUtil.parseDate(actvday, dateformat1), dateformat2);
			vparams.set_se_actvday(actvday1);
		}
		String waytype = params.get_se_waytype();
		if(StringUtils.isNotEmpty(waytype)){
			vparams.set_se_waytype(waytype);
		}
		
		String mobile = params.get_se_mobile();
		if(StringUtils.isNotEmpty(mobile)){
			vparams.set_se_mobile(mobile);
		}
		
		String dnl_intime = params.get_dnl_intime();
		if(StringUtils.isNotEmpty(dnl_intime)){
			vparams.set_dnl_intime(dnl_intime);
		}
		
		String dnm_intime = params.get_dnm_intime();
		if(StringUtils.isNotEmpty(dnm_intime)){
			vparams.set_dnm_intime(dnm_intime);
		}
		
		String filename = params.get_sk_filename();
		if(StringUtils.isNotEmpty(filename)){
			vparams.set_sk_filename(filename);
		}

		vparams.setQueryAll(true);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);

		return super.doExcel();
	}
	
	public String doExportList() {

		User user = (User) getDBAccessUser();
		SetcardDBParam params = (SetcardDBParam) getParam();
		
		VSetcardDBParam vparams = new VSetcardDBParam();
		
		String wayid = params.get_se_wayid();
		if(StringUtils.isNotEmpty(wayid)){
			vparams.set_se_wayid(wayid);
		}
		String actvday = params.get_se_actvday();
		if(StringUtils.isNotEmpty(actvday)){
			String actvday1 = DateUtil.date2String(DateUtil.parseDate(actvday, dateformat1), dateformat2);
			vparams.set_se_actvday(actvday1);
		}
		String waytype = params.get_se_waytype();
		if(StringUtils.isNotEmpty(waytype)){
			vparams.set_se_waytype(waytype);
		}
		
		String mobile = params.get_se_mobile();
		if(StringUtils.isNotEmpty(mobile)){
			vparams.set_se_mobile(mobile);
		}
		
		String dnl_intime = params.get_dnl_intime();
		if(StringUtils.isNotEmpty(dnl_intime)){
			vparams.set_dnl_intime(dnl_intime);
		}
		
		String dnm_intime = params.get_dnm_intime();
		if(StringUtils.isNotEmpty(dnm_intime)){
			vparams.set_dnm_intime(dnm_intime);
		}
		
		String filename = params.get_sk_filename();
		if(StringUtils.isNotEmpty(filename)){
			vparams.set_sk_filename(filename);
		}

		try {

			VSetcard vsetcard = (VSetcard) BOFactory.build(VSetcardBO.class, user);
			DataPackage dp = vsetcard.doQueryBySql(vparams);
			setDp(dp);
		} catch (SQLException e) {
			setErrorLog("���ݿ����Ӵ��� \n" + e.getMessage());
		} catch (Exception e) {
			setErrorLog("�������� \n" + e.getMessage());
		}
		
		return "list";
}
}