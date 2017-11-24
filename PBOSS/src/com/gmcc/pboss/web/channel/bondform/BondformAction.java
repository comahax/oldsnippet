/**
 * auto-generated code
 * Thu Dec 29 08:58:06 CST 2011
 */
package com.gmcc.pboss.web.channel.bondform;

import java.io.File;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.apache.commons.beanutils.PropertyUtils;

import com.gmcc.pboss.business.channel.bondaudit.BondauditVO;
import com.gmcc.pboss.business.channel.bondform.BondformVO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.gmcc.pboss.business.channel.bondform.BondformDBParam;
import com.gmcc.pboss.common.ftp.FtpAccess;
import com.gmcc.pboss.common.ftp.FtpInfo;
import com.gmcc.pboss.control.channel.bank.BankBO;
import com.gmcc.pboss.control.channel.bondaudit.BondauditBO;
import com.gmcc.pboss.control.channel.bondform.Bondform;
import com.gmcc.pboss.control.channel.bondform.BondformBO;

/**
 * <p>
 * Title: BondformAction
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
 * @author limin
 * @version 1.0
 */
public class BondformAction extends BaseAction {

	// private String remotepath = "saleway";
	// private File compactDoc; // �ı�
	// private String compactDocFileName;
	// private String compactDocType;
	//
	// private File licenceDoc; // ��ͬ
	// private String licenceDocFileName;
	// private String licenceDocType;
	// private String CH_PW_STARLEVEL = "CH_PW_STARLEVEL";//�Ǽ��޸�Ȩ������
	// public String hasFlag;// �ж��Ǽ��Ƿ���޸�
	//	
	// public String param75;//�Ƿ���д�˳�ԭ���ж�
	//	
	// public String memo;//�˳�ԭ��
	//	
	// private String flag;// �����ж��Ƿ���Ҫ��������

	private String remotepath = "saleway";

	// �վ��ļ�
	private File filepath;
	private String filepathFileName;
	private String filepathType;

	// ֧Ʊ�ļ�
	private File payfilepath;
	private String payfilepathFileName;
	private String payfilepathType;

	public String getRemotepath() {
		return remotepath;
	}

	public void setRemotepath(String remotepath) {
		this.remotepath = remotepath;
	}

	public BondformAction() {
		super();

		// ���¼��������Ǳ����
		this.setForm(new BondformForm());
		this.setParam(new BondformDBParam());

		// ָ��VO��
		setClsVO(BondformVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[] { "formid" };
		this.setClsControl(Bondform.class);
		this.setClsQueryParam(BondformDBParam.class);

	}

	@Override
	public String doSave() throws Exception {

		try {
			// ״̬Ϊδ�ύ��
			// ����ʱ��Ϊ��ǰϵͳʱ�䡣
			// �����ֶ�����
			BondformForm bondformForm = (BondformForm) this.getForm();
			bondformForm.setState(Short.parseShort("0"));
			bondformForm.setCreatetime(new Date());

			BondformVO bondformVO = new BondformVO();
			BondformBO bo = (BondformBO) BOFactory.build(BondformBO.class,
					getDBAccessUser());

			if ((this.getFilepathFileName() != null && !"".equals(this
					.getFilepathFileName()))
					|| (this.getPayfilepathFileName() != null && !"".equals(this
							.getPayfilepathFileName()))) {
				FtpInfo ftpInfo = FtpInfo.getInstance();
				FtpAccess ftp = new FtpAccess(ftpInfo);
				if (getFilepathFileName() != null
						&& !"".equals(this.getFilepathFileName())) {
					String compact = ftp
							.uploadFile(this.filepath, remotepath, true);
					bondformForm.setFilepath(compact);
				}
				if (getPayfilepathFileName() != null
						&& !"".equals(this.getPayfilepathFileName())) {
					String compact1 = ftp.uploadFile(this.payfilepath, remotepath,
							true);
					bondformForm.setPayfilepath(compact1);
				}
			}
			BeanUtils.copyProperties(bondformVO, bondformForm);
			if (WEB_CMD_NEW.equals(CMD)) {
				CMD = WEB_CMD_SAVE;			
				bo.doCreate(bondformVO);
			} else {
				CMD = WEB_CMD_SAVE;
				bo.doUpdate(bondformVO);
			}
			this.addActionError("����ɹ�!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			this.addActionError("����ʧ��!"+e.getMessage());
			e.printStackTrace();
		}
		return WEB_RESULT_CONTENT;
	}

	
	@Override
	public String doNew() throws Exception {
		BondformForm bondformForm = (BondformForm) this.getForm();
		bondformForm.setBoneobjtype(Short.parseShort("0"));
		setForm(bondformForm);		
		return super.doNew();
	}

	//�ύ
	public String doSubmitboss() throws Exception {

		String formid = this.getRequest().getParameter("formid");
		String boss = this.getRequest().getParameter("boss");
		
		 boss = boss.split(",")[0];
		
		BondformBO bondformBO = (BondformBO) BOFactory.build(BondformBO.class,getDBAccessUser());
		 
		 try {
			bondformBO.doSubmitboss(formid, boss, (User)this.getDBAccessUser());			
			this.addActionError("�ύ�����ɹ�!");
		} catch (Exception e) {
			this.addActionError("�ύ����ʧ��!");
			e.printStackTrace();
		}
		return this.doList();
	}

	//���ŷ���
	public String doSendinfor() throws Exception {
		String formid = this.getRequest().getParameter("formid");
		
		try {
			BondformBO bondformBO = (BondformBO) BOFactory.build(BondformBO.class,getDBAccessUser());
			bondformBO.doSendinfor(formid, (User)this.getDBAccessUser());
			this.addActionError("ȷ�϶��ŷ��ͳɹ�!");
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			e.printStackTrace();
		}
		
		return this.doList();
	}
	
	//����
	public String doMvaccount() throws Exception{
		String formid = this.getRequest().getParameter("formid");
		
		try {
			BondformBO bondformBO = (BondformBO) BOFactory.build(BondformBO.class,getDBAccessUser());
			bondformBO.doMvaccount(formid, (User)this.getDBAccessUser());
			this.addActionError("֧�������ɹ�!");
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			e.printStackTrace();
		}
		return this.doList();
	}
	
	
	
	public File getFilepath() {
		return filepath;
	}

	public void setFilepath(File filepath) {
		this.filepath = filepath;
	}

	public String getFilepathFileName() {
		return filepathFileName;
	}

	public void setFilepathFileName(String filepathFileName) {
		this.filepathFileName = filepathFileName;
	}

	public String getFilepathType() {
		return filepathType;
	}

	public void setFilepathType(String filepathType) {
		this.filepathType = filepathType;
	}

	public File getPayfilepath() {
		return payfilepath;
	}

	public void setPayfilepath(File payfilepath) {
		this.payfilepath = payfilepath;
	}

	public String getPayfilepathFileName() {
		return payfilepathFileName;
	}

	public void setPayfilepathFileName(String payfilepathFileName) {
		this.payfilepathFileName = payfilepathFileName;
	}

	public String getPayfilepathType() {
		return payfilepathType;
	}

	public void setPayfilepathType(String payfilepathType) {
		this.payfilepathType = payfilepathType;
	}

}