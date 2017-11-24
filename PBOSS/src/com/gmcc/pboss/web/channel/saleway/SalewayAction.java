package com.gmcc.pboss.web.channel.saleway;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.channel.bchcontact.BchcontactVO;
import com.gmcc.pboss.business.channel.changelog.ChangelogDBParam;
import com.gmcc.pboss.business.channel.changelog.ChangelogVO;
import com.gmcc.pboss.business.channel.cooperator.CooperatorVO;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.channel.flowname.FlownameVO;
import com.gmcc.pboss.business.channel.way.AGWayVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountDBParam;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountVO;
import com.gmcc.pboss.business.channel.wayapply.WayapplyVO;
import com.gmcc.pboss.business.channel.waybusicircle.WaybusicircleDBParam;
import com.gmcc.pboss.business.channel.waybusicircle.WaybusicircleVO;
import com.gmcc.pboss.business.channel.waycompact.WaycompactVO;
import com.gmcc.pboss.business.channel.wayprovince.WayprovinceVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.common.ftp.FtpAccess;
import com.gmcc.pboss.common.ftp.FtpBusUtils;
import com.gmcc.pboss.common.ftp.FtpInfo;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.bchcontact.Bchcontact;
import com.gmcc.pboss.control.channel.bchcontact.BchcontactBO;
import com.gmcc.pboss.control.channel.changelog.Changelog;
import com.gmcc.pboss.control.channel.changelog.ChangelogBO;
import com.gmcc.pboss.control.channel.cooperator.Cooperator;
import com.gmcc.pboss.control.channel.cooperator.CooperatorBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.flowname.Flowname;
import com.gmcc.pboss.control.channel.flowname.FlownameBO;
import com.gmcc.pboss.control.channel.way.AGWay;
import com.gmcc.pboss.control.channel.way.AGWayBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.channel.wayaccount.Wayaccount;
import com.gmcc.pboss.control.channel.wayaccount.WayaccountBO;
import com.gmcc.pboss.control.channel.wayapply.Wayapply;
import com.gmcc.pboss.control.channel.wayapply.WayapplyBO;
import com.gmcc.pboss.control.channel.waybusicircle.Waybusicircle;
import com.gmcc.pboss.control.channel.waybusicircle.WaybusicircleBO;
import com.gmcc.pboss.control.channel.waycompact.Waycompact;
import com.gmcc.pboss.control.channel.waycompact.WaycompactBO;
import com.gmcc.pboss.control.channel.wayprovince.Wayprovince;
import com.gmcc.pboss.control.channel.wayprovince.WayprovinceBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.InterfaceUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.filter.PermissionChecker;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

public class SalewayAction extends BaseAction {
	private String remotepath = "saleway";
	private File compactDoc; // �ı�
	private String compactDocFileName;
	private String compactDocType;

	private File licenceDoc; // ��ͬ
	private String licenceDocFileName;
	private String licenceDocType;
	private String CH_PW_STARLEVEL = "CH_PW_STARLEVEL";//�Ǽ��޸�Ȩ������
	public String hasFlag;// �ж��Ǽ��Ƿ���޸�
	
	public String param75;//�Ƿ���д�˳�ԭ���ж�
	
	public String memo;//�˳�ԭ��
	
	private String flag;// �����ж��Ƿ���Ҫ��������
	
	private String has3Gright;//3G��2Gҳ����ʾ����
	
	/**��������ʱ�Ŀ�ѡ�����ֶ�*/
	private String[][] optionFields = new String[][]{
			{"wayid","��������"},{"wayname","��������"},{"waysubtype","�����������"},{"upperwayid","�ϼ���������"},{"upperwayid","�ϼ���������"},
			{"starlevel","�Ǽ�"},{"pt","������"},{"waystate","״̬"},{"cityid","���й�˾"},{"countyid","�ֹ�˾"},
			{"svccode","������������"},{"mareacode","΢����"},{"isstraitprd","�Ƿ�ֱ��"},{"adtypecode","��������"},
			{"adacode","��������"},{"formtype","ҵ̬����"},{"starttime","������ʼʱ��"},{"buzarea","Ӫҵ���"},
			{"logiscode","����������"},{"waymagcode","��������������Ա����"},{"bchlevel","�ּ�"},{"officetel","���������"},
			{"alarmbizamount","ҵ��Ԥ����"},{"address","��ϸ��ַ"},{"latitude","����γ��"},{"longtitude","������"},{"checked","�Ƿ���Ȩ"},
			{"principal","ҵ������"},{"principaltel","ҵ���绰"},{"principalphone","ҵ���̶��绰"},{"principalemail","ҵ����������"},
			{"sendaddr","�ͻ���ַ"},{"recpers","�ջ���ϵ��"},{"recconntel","�ջ���ϵ����"},{"reccertno","�ջ���֤������"},
			{"compacttype","ǩԼ����"},{"compactno","��ͬ����"},{"compactname","��ͬЭ������"},{"signtime","ǩ���ͬʱ��"},
			{"begintime","��ͬЭ����Чʱ��"},{"cmpendtime","��ͬ������"},{"licenceno","Ӫҵִ�ձ��"},{"licvalidate","Ӫҵִ����Ч��"},
			{"bail","��֤����"},{"bailstatus","��֤��Ѻ��״̬"},{"baillwrlmt","��֤������"},{"bankname","���֧����������"},
			{"acctno","���֧�������˺�"},{"acctname","���֧���ʺ�����"},{"acctfid","���������֤����"},{"signstatus","ǩԼ״̬"},
			{"bailtype","��֤�𽻸���ʽ"},{"servbound","��Ӫ��Χ"},{"provcode","ȫʡ����"},{"deacctno","���๺�����������ʺ�"},
			{"deacctname","���๺�������˺�����"},{"debankname","���๺�����ۿ�������"},{"chainhead","�����̱���"},{"isb2m","�Ƿ����B2Mģʽ"},
			{"accttype","�˺�����"},{"debankid","���๺���������б�ʶ"},{"destate","���๺����������״̬"},{"custtype","��������"},{"starlev","�Ǽ��ֲ�"},
			{"istop","�Ƿ�TOP����"},{"buztypecode","��Ȧ����"},
			{"rewardkind","�����������"},{"buscno","������Ȧ����"},{"wayattr","����������������"},{"waymod","������������ϵ��"},
			{"creditlevel","���õȼ�"},{"taxcertificate","˰������"}
			
	};
	public File getCompactDoc() {
		return compactDoc;
	}
	public void setCompactDoc(File compactDoc) {
		this.compactDoc = compactDoc;
	}
	public String getCompactDocFileName() {
		return compactDocFileName;
	}
	public void setCompactDocFileName(String compactDocFileName) {
		this.compactDocFileName = compactDocFileName;
	}
	public String getCompactDocType() {
		return compactDocType;
	}
	public void setCompactDocType(String compactDocType) {
		this.compactDocType = compactDocType;
	}
	public File getLicenceDoc() {
		return licenceDoc;
	}
	public void setLicenceDoc(File licenceDoc) {
		this.licenceDoc = licenceDoc;
	}
	public String getLicenceDocFileName() {
		return licenceDocFileName;
	}
	public void setLicenceDocFileName(String licenceDocFileName) {
		this.licenceDocFileName = licenceDocFileName;
	}
	public String getLicenceDocType() {
		return licenceDocType;
	}
	public void setLicenceDocType(String licenceDocType) {
		this.licenceDocType = licenceDocType;
	}
	public SalewayAction() {
		super();
		this.setForm(new SalewayForm());
		this.setParam(new WayDBParam());
		setClsVO(AGWayVO.class);
		this.pkNameArray = new String[] { "wayid" };
		this.setClsQueryParam(WayDBParam.class) ;
	}

	public String doList() throws Exception {
		try {
			HttpServletRequest request = getRequest();
			User user = (User) request.getSession().getAttribute(
					WebConstant.SESSION_ATTRIBUTE_USER);
			Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,user);
			//1:�˳�ʱ��Ҫ��дԭ�� 0:������д�˳�ԭ�� ��:������д�˳�ԭ��
			param75 = sysparamBO.doFindByID("75", "channel");			
			request.getSession().setAttribute("param75",param75);//���������õ�
			
			// ���Ȩ������
			String paramvalue = sysparamBO.doFindByID(new Long("77"), "channel");
			// ���paramvalue�鵽��¼����ֵΪ1������Ҫ���µĹ̶�������ʾ����ID������
			if ("1".equals(paramvalue)) {
				this.setFlag("yes");
			}
			
			WayDBParam param = (WayDBParam)getParam();
			if (param.get_se_rewardkind() != null && param.get_ne_starlevel() != null) {
				if (param.get_se_rewardkind().equals("1")
						&& !param.get_ne_starlevel().equals("")
						&& !param.get_ne_starlevel().equals("7")) {
					super.addActionError("�����������ѡ��Ϊ3Gʱ����ʱ���Ǽ�ֻ��ѡ��3G����ר���Ǽ�");
					return ("list");
				} else if (param.get_se_rewardkind().equals("0")
						&& param.get_ne_starlevel().equals("7")) {
					super.addActionError("�����������ѡ��Ϊ2Gʱ����ʱ���Ǽ�����ѡ��3G����ר���Ǽ�");
					return ("list");
				} else if (param.get_se_rewardkind().equals("2")
						&& !param.get_ne_starlevel().equals("")
						&& !param.get_ne_starlevel().equals("8")) {
					super.addActionError("�����������ѡ��Ϊ������������ʱ���Ǽ�ֻ��ѡ�� 8 �������������Ǽ�");
					return ("list");
				}else if (param.get_se_rewardkind().equals("3")
						&& !param.get_ne_starlevel().equals("")
						&& !param.get_ne_starlevel().equals("9")) {
					super.addActionError("�����������ѡ��Ϊ4G����ʱ���Ǽ�ֻ��ѡ�� 9 ��4G����ר���Ǽ���");
					return ("list");
				}
				
				if (param.get_se_rewardkind().equals("0") && param.get_ne_starlevel().equals("")) {
					param.set_sql_starlevel("starlevel != 7 and STARLEVEL != 8 and STARLEVEL != 9 or starlevel is null");
				} else if (param.get_se_rewardkind().equals("1")) {
					param.set_ne_starlevel("7");
				}else if (param.get_se_rewardkind().equals("2")) {
					param.set_ne_starlevel("8");
				}else if (param.get_se_rewardkind().equals("3")) {
					param.set_ne_starlevel("9");
				}
			}
			
			//param.set_pagesize("20");
			Way way = (Way) BOFactory.build(WayBO.class, getDBAccessUser());
			DataPackage dp=null;
			if(param.get_se_officetel()==null || "".equals(param.get_se_officetel())){
			 dp = way.doQuerysaleway(param, user);
			}else
			{
				dp = way.doQuerysalewayWithOfficetel(param, user);
			}
			setDp(dp);
		} catch (Exception e) {
			e.printStackTrace();
			setActionMessage(e.getMessage());
		}
		return "list";
	}
	
	public String doQueryWayAndSubwayDetailInfo() throws Exception {
		try {
			HttpServletRequest request = getRequest();
			User user = (User) request.getSession().getAttribute(
					WebConstant.SESSION_ATTRIBUTE_USER);
			WayDBParam wayParam = (WayDBParam)getParam();
			WayaccountDBParam param = new WayaccountDBParam();
			BeanUtils.copyProperties(param, wayParam);
			param.set_pagesize(wayParam.get_pagesize());
			param.set_pageno(wayParam.get_pageno());
			Wayaccount waBo = (Wayaccount) BOFactory.build(WayaccountBO.class, getDBAccessUser());
			DataPackage dp = waBo.doQueryWayAndSubwayDetailInfo(param, user.getWayid());
			setDp(dp);
		} catch (Exception e) {
			e.printStackTrace();
			setActionMessage(e.getMessage());
		}
		return "list";
	}
	
	public String doDownload() throws Exception{
			try {
				HttpServletRequest request=ServletActionContext.getRequest();
				
				String url = request.getParameter("file");
				FtpAccess ftpAccess = new FtpAccess(FtpInfo.getInstance());
				String localPath =ServletActionContext.getServletContext().getRealPath("/") ;//FtpBusUtils.getDownloadRealPath(ServletActionContext.getServletContext());
				String file = ftpAccess.downloadFile(localPath, url);
				if (file == null) {
					throw new Exception("����ʧ�ܣ�");
				}
				request.setAttribute("filename", FtpBusUtils.getFilenameFromPath(url));
			} catch (Exception ex) {
				ex.printStackTrace();
				super.addActionError(ex.getMessage());
			}
			return "download";
	}
	public String doSave() throws Exception {
		HttpServletRequest request=ServletActionContext.getRequest();
		SalewayForm form = (SalewayForm) getForm();
		DBAccessUser user = this.getDBAccessUser();
		Way wayBO = (Way)BOFactory.build(WayBO.class, user);
		WayDBParam wayDBParam=new WayDBParam();
		wayDBParam.getQueryConditions().put("_sne_wayid", form.getWayid());
		wayDBParam.set_se_latitude(form.getLatitude());
		wayDBParam.set_se_longtitude(form.getLongtitude());
		if(wayBO.doQuery(wayDBParam).getDatas().size()>0){
			super.addActionError("����"+form.getLatitude()+",γ��"+form.getLongtitude()+"���Ѿ�����.������ȷʵͬһ��γ��,�����޸�С������6λ��ʾ����");
			return "content";
		}
		
		/*
		 * dengxingxin add
		 * ����ϵͳ�������Ƿ���д�˳�ԭ���жϡ����жϣ��Ƿ�����
		 * �����䶯��¼�� (ch_pw_changelog)��¼
		 */
		Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,getDBAccessUser());
		//1:�˳�ʱ��Ҫ��дԭ�� 0:������д�˳�ԭ�� ��:������д�˳�ԭ��
		param75 = sysparamBO.doFindByID("75", "channel");
		if("1".equals(param75)){
			Short waystate = form.getWaystate();
			if (waystate == Short.parseShort("1")) {
				
			} else {
				if(memo == null || "".equals(memo)){					
					super.addActionError("��ע����Ϊ�գ�����д");
					return ("content");
				}else{
					Changelog changelogBO = (ChangelogBO)BOFactory.build(ChangelogBO.class, getDBAccessUser());
					ChangelogVO clVO = new ChangelogVO();
					clVO.setOptime(new Date());//����ʱ��
					clVO.setOprcode(getDBAccessUser().getOprcode());//����Ա����
					clVO.setOprtype("update");//��������
					clVO.setWayid(form.getWayid());//��������
					clVO.setChangetype(Short.parseShort("2"));//�䶯����
					if ("EDIT".equals(CMD)) {
						clVO.setOldvalue(""+wayBO.doFindByPk(form.getWayid()).getWaystate());//�䶯ǰֵ
					} else {
						clVO.setOldvalue("");
					}
					clVO.setNowvalue(""+form.getWaystate());//�䶯��ֵ
					clVO.setMemo(memo);//��ע
										
					changelogBO.doCreate(clVO);
				}
			}
		}
				
		/*
		 * dengxingxin add
		 */
		try {
			String uwi = form.getUniquewayid() == null ? "" : form.getUniquewayid();
			String wi = form.getWayid() == null ? "" : form.getWayid();
			WayprovinceVO wpVO = new WayprovinceVO();
			BeanUtils.copyProperties(wpVO, form);
			
			Wayprovince wayprovince = (Wayprovince) BOFactory.build(WayprovinceBO.class, user);			
			List wList = wayprovince.doQueryWpByWayid(wpVO.getWayid());
			List uList = wayprovince.doQueryWpByUniquewayid(wpVO.getUniquewayid());
						
			if(wList != null && !"".equals(wList) && wList.size()>0){
				//����
				if(uList != null && !"".equals(uList) && uList.size()>0){
					//����ȫ��ͳһ��������
					WayprovinceVO wVO1 = (WayprovinceVO)uList.get(0);
					if(wi.equals(wVO1.getWayid())){
						//��ͬwayid��¼���ܸ���
						WayprovinceVO wVO = (WayprovinceVO)wList.get(0);
						BeanUtils.copyProperties(wVO, wpVO);
						wayprovince.doUpdate(wVO);
					}else{
						super.addActionError(wVO1.getWayid() + "  �Ѿ�����ȫ��ͳһ�������룺" + wVO1.getUniquewayid() + "");
						return "content";
					}
				}else{
					//û�С�ȫ��ͳһ�������롱������ֱ�Ӹ���
					WayprovinceVO wVO = (WayprovinceVO)wList.get(0);
					BeanUtils.copyProperties(wVO, wpVO);
					wayprovince.doUpdate(wVO);
				}				
			}else{
				//����
				if(uList != null && !"".equals(uList) && uList.size()>0){
					//����ȫ��ͳһ��������
					WayprovinceVO wVO1 = (WayprovinceVO)uList.get(0);
					super.addActionError(wVO1.getWayid() + "  �Ѿ�����ȫ��ͳһ�������룺" + wVO1.getUniquewayid() + "");
					return "content";
				}else{
					//û�С�ȫ��ͳһ�������롱������ֱ������
					wayprovince.doCreate(wpVO);
				}
				
			}
		} catch (Exception e) {
			super.addActionError(e.getMessage());
			return ("content");
		}
						
		try {
			if ((getCompactDocFileName()!=null && !"".equals(this.getCompactDocFileName()))
					|| (getLicenceDocFileName()!=null &&!"".equals(this.getLicenceDocFileName()))) {
				FtpInfo ftpInfo = FtpInfo.getInstance();
				FtpAccess ftp = new FtpAccess(ftpInfo);
				if (getCompactDocFileName()!=null && !"".equals(this.getCompactDocFileName())) {
					String compact = ftp.uploadFile(this.compactDoc,
							remotepath, true);
					form.setCompactpath(compact);
				}
				if (getLicenceDocFileName()!=null && !"".equals(this.getLicenceDocFileName())) {
					String licence = ftp.uploadFile(this.licenceDoc,
							remotepath, true);
					form.setLicencepath(licence);
				}
			}
		} catch (Exception e) {
			super.addActionError(e.getMessage());
			return ("content");
		}
		
		/*
		 * dengxingxin add
		 * ����״̬   �ϼ�����״̬�ֶ�����Ϊ��0:��ͣӪҵ��-1:�ѹصꡯʱ��Ҫ��������������Ϊ��Ӧ״̬��
		 */
		User wuser = (User) request.getSession().getAttribute(
				WebConstant.SESSION_ATTRIBUTE_USER);
		Way way = (Way) BOFactory.build(WayBO.class, getDBAccessUser());
		DataPackage dp=null;
		WayDBParam wparams = new WayDBParam();
		wparams.set_se_wayid(form.getWayid());
		wparams.setDataOnly(true);
		wparams.set_pagesize("0");
		dp = way.doQuerySubSaleway(wparams, wuser);
		if(dp != null && !"".equals(dp)
				&& dp.getDatas() != null && !"".equals(dp.getDatas())
				&& dp.getDatas().size() > 0){
			Way wwayBO = (WayBO) BOFactory.build(WayBO.class, user);
			for(int k=0 ; k<dp.getDatas().size() ; k++){
				WayVO wayVO = (WayVO)dp.getDatas().get(k);
				if(form.getWaystate() == 0 || form.getWaystate() == -1){
					if(!form.getWayid().equals(wayVO.getWayid())){//�������Լ��Ÿ���
						wayVO.setWaystate(form.getWaystate());
						wwayBO.doUpdateNotCon(wayVO);
					}
				}else{
					
				}
			}
		}
				
		int cando = -1;
		try {
			AGWay agway = (AGWay)BOFactory.build(AGWayBO.class, user);
			AGWayVO wayVO = new AGWayVO();
			BeanUtils.copyProperties(wayVO, form);
			wayVO.setBuzphoneno(form.getSmsmobileno());
			// ��ͨ��������
			wayVO.setWaytype("AG");
			String upperwayid = form.getUpperwayid();
			WayVO upperVO = agway.doFindByPk(upperwayid, user);
			if (!"DIS".equals(upperVO.getWaysubtype())
					&& !"GMPT".equals(upperVO.getWaysubtype())
					&& !"G100".equals(upperVO.getWaysubtype())
					&& !"D4S".equals(upperVO.getWaysubtype())
					&& !"D5S".equals(upperVO.getWaysubtype())
					&& !"D6S".equals(upperVO.getWaysubtype())

			) {
				throw new Exception("¼����ϼ�����ֻ����������Ӫ�����̣��ƶ�����/���һ������");
			}
			if (StringUtils.equals(wayVO.getWaytype(), "AG")
					&& StringUtils.equals(wayVO.getWaysubtype(), "DIS")) {
				form.setChainhead(wayVO.getWayid());
			}
			if ("EDIT".equals(CMD)) {
				if ("1".equals(form.getSendFlag())){
					wayVO.setSendFlag(form.getSendFlag());
					wayVO.setSmsMsg(form.getSmsMsg());
				}
				User users = (User) getDBAccessUser();
				//this.checkUpdateStartLevel(wayVO,users);
				//ȡ�������Ǽ��޸Ŀ�ʼ����ʱ��
				wayVO.setStarttime(form.getStarttime());
				cando = agway.doUpdate(wayVO, user);
//				if (!StringUtils.isEmpty(form.getOldValueStr())){
//					form.setOldValueStr(null);
//				}
			} else {
				WayVO tempVO = agway.doFindByPk(form.getWayid(), user);
				if (tempVO != null) {
					// form.setCmdState(WebConstant.COMMAND_STRING_EDIT);
					super.addActionError("��ͬ��¼�Ѵ���");
					return ("content");
				} else { 
//					this.checkAddStartLevel(wayVO);
					//ȡ�������Ǽ��޸Ŀ�ʼ����ʱ��
					wayVO.setStarttime(form.getStarttime());
					cando = agway.doCreate(wayVO, user);
					//request.setAttribute("newSVWayPk", wayVO.getWayid());
				}
			}
			BeanUtils.copyProperties(form, wayVO);
			wayVO.setBuzphoneno(form.getSmsmobileno());
			if("1".equals(wayVO.getRewardkind())){
				has3Gright = "false";
			}else if("3".equals(wayVO.getRewardkind())){
				has3Gright = "false";
			}else{
				has3Gright = "true";
			}
			if (cando == 0) {
				super.addActionMessage("����ɹ�");
			} else {
				super.addActionMessage("�����ɹ�");
			}			
			this.setCMD(WEB_CMD_SAVE);
		} catch (Exception e) {
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return ("content");
	}
	
	/**
	 * �����ύ����
	 */
	public String doAgapply() throws Exception {
		SalewayForm form = (SalewayForm) getForm();
		DBAccessUser user = this.getDBAccessUser();
		Way wayBO = (Way)BOFactory.build(WayBO.class, user);
		WayDBParam wayDBParam=new WayDBParam();
		wayDBParam.getQueryConditions().put("_sne_wayid", form.getWayid());
		wayDBParam.set_se_latitude(form.getLatitude());
		wayDBParam.set_se_longtitude(form.getLongtitude());
		if(wayBO.doQuery(wayDBParam).getDatas().size()>0){
			super.addActionError("����"+form.getLatitude()+",γ��"+form.getLongtitude()+"���Ѿ�����.������ȷʵͬһ��γ��,�����޸�С������6λ��ʾ����");
			this.setFlag("yes");
			return "content";
		}
		
		// ����������
		WayapplyVO applyvo = new WayapplyVO();
		
		AGWay delegate = (AGWay)BOFactory.build(AGWayBO.class, getDBAccessUser());
		WayVO oldVO = delegate.doFindByPk(form.getWayid(), getDBAccessUser());
		
		// ��ѯ��һ���������Ƿ����
		Flowname flowname = (Flowname)BOFactory.build(FlownameBO.class, getDBAccessUser());
		String pk = null;
		if (oldVO == null) {
			pk = "WAY_ADD_AUDIT1";
		} else {
			pk = "WAY_UPDATE_AUDIT1";
		}
		FlownameVO flvo = flowname.doFindByPk(pk);
		if (flvo == null || (flvo.getOprcode() == null || "".equals(flvo.getOprcode().trim()))) {
			super.addActionError("��һ��������û�ж��壡");
			this.setFlag("yes");
			return "content";
		}
		String oprcode = flvo.getOprcode();
		
		// ���ȫ��ͳһ����
		try {
			String uwi = form.getUniquewayid() == null ? "" : form.getUniquewayid();
			String wi = form.getWayid() == null ? "" : form.getWayid();
			WayprovinceVO wpVO = new WayprovinceVO();
			BeanUtils.copyProperties(wpVO, form);
			
			Wayprovince wayprovince = (Wayprovince) BOFactory.build(WayprovinceBO.class, user);			
			List wList = wayprovince.doQueryWpByWayid(wpVO.getWayid());
			List uList = wayprovince.doQueryWpByUniquewayid(wpVO.getUniquewayid());
						
			if(wList != null && !"".equals(wList) && wList.size()>0){
				//����
				if(uList != null && !"".equals(uList) && uList.size()>0){
					//����ȫ��ͳһ��������
					WayprovinceVO wVO1 = (WayprovinceVO)uList.get(0);
					if(!wi.equals(wVO1.getWayid())){
						super.addActionError(wVO1.getWayid() + "  �Ѿ�����ȫ��ͳһ�������룺" + wVO1.getUniquewayid() + "");
						this.setFlag("yes");
						return "content";
					}
				}				
			}else{
				//����
				if(uList != null && !"".equals(uList) && uList.size()>0){
					//����ȫ��ͳһ��������
					WayprovinceVO wVO1 = (WayprovinceVO)uList.get(0);
					super.addActionError(wVO1.getWayid() + "  �Ѿ�����ȫ��ͳһ�������룺" + wVO1.getUniquewayid() + "");
					this.setFlag("yes");
					return "content";
				}				
			}
		} catch (Exception e) {
			super.addActionError(e.getMessage());
			this.setFlag("yes");
			return ("content");
		}
		
		// �ϴ�ftp���ļ�
		try {
			if ((getCompactDocFileName()!=null && !"".equals(this.getCompactDocFileName()))
					|| (getLicenceDocFileName()!=null &&!"".equals(this.getLicenceDocFileName()))) {
				FtpInfo ftpInfo = FtpInfo.getInstance();
				FtpAccess ftp = new FtpAccess(ftpInfo);
				if (getCompactDocFileName()!=null && !"".equals(this.getCompactDocFileName())) {
					String compact = ftp.uploadFile(this.compactDoc,
							remotepath, true);
					form.setCompactpath(compact);
				}
				if (getLicenceDocFileName()!=null && !"".equals(this.getLicenceDocFileName())) {
					String licence = ftp.uploadFile(this.licenceDoc,
							remotepath, true);
					form.setLicencepath(licence);
				}
			}
		} catch (Exception e) {
			super.addActionError(e.getMessage());
			this.setFlag("yes");
			return ("content");
		}
		
		try {
			AGWay agway = (AGWay)BOFactory.build(AGWayBO.class, user);
			AGWayVO wayVO = new AGWayVO();
			BeanUtils.copyProperties(wayVO, form);
			wayVO.setBuzphoneno(form.getSmsmobileno());
			// ��ͨ��������
			wayVO.setWaytype("AG");
			String upperwayid = form.getUpperwayid();
			WayVO upperVO = agway.doFindByPk(upperwayid, user);
			if (!"DIS".equals(upperVO.getWaysubtype())
					&& !"GMPT".equals(upperVO.getWaysubtype())
					&& !"G100".equals(upperVO.getWaysubtype())
					&& !"D4S".equals(upperVO.getWaysubtype())
					&& !"D5S".equals(upperVO.getWaysubtype())
					&& !"D6S".equals(upperVO.getWaysubtype())

			) {
				throw new Exception("¼����ϼ�����ֻ����������Ӫ�����̣��ƶ�����/���һ������");
			}
			if (StringUtils.equals(wayVO.getWaytype(), "AG")
					&& StringUtils.equals(wayVO.getWaysubtype(), "DIS")) {
				form.setChainhead(wayVO.getWayid());
			}
			if ("EDIT".equals(CMD)) {
				if ("1".equals(form.getSendFlag())){
					wayVO.setSendFlag(form.getSendFlag());
					wayVO.setSmsMsg(form.getSmsMsg());
				}
				User users = (User) getDBAccessUser();
				//this.checkUpdateStartLevel(wayVO,users);
				//ȡ�������Ǽ��޸Ŀ�ʼ����ʱ��
				wayVO.setStarttime(form.getStarttime());
				
			} else {
				WayVO tempVO = agway.doFindByPk(form.getWayid(), user);
				if (tempVO != null) {
					super.addActionError("��ͬ��¼�Ѵ���");
					this.setFlag("yes");
					return ("content");
				} else {					
//					this.checkAddStartLevel(wayVO);
					//ȡ�������Ǽ��޸Ŀ�ʼ����ʱ��
					wayVO.setStarttime(form.getStarttime());
				}
			}
			BeanUtils.copyProperties(form, wayVO);
			wayVO.setBuzphoneno(form.getSmsmobileno());
			
			// ���ݸ��Ƶ�������
			Wayapply apply = (Wayapply)BOFactory.build(WayapplyBO.class,getDBAccessUser());
			BeanUtils.copyProperties(applyvo, form);
			applyvo.setEndtime(form.getCmpendtime());
			if (oldVO == null) {
				apply.doWayapply(oprcode, applyvo, getDBAccessUser(), "add");	
			} else {
				apply.doWayapply(oprcode, applyvo, getDBAccessUser(), "update");	
			}
			this.setFlag("yes");
			super.addActionMessage("�ύ����ɹ���");
			
			this.setCMD(WEB_CMD_SAVE);
		} catch (Exception e) {
			e.printStackTrace();
			this.setFlag("yes");
			super.addActionError(e.getMessage());
		}
				
		return "content";
	}
	
	/**
	 * �������������߼�ɾ����waystate 0 �ѹرգ�
	 */
	public String doDelete() throws Exception {
		try {
			String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
			if(selectArray == null) {
				addActionError("�޷���ȡѡ����Ŀ��");
				return "list";
			}
			AGWay agway = (AGWay)BOFactory.build(AGWayBO.class, getDBAccessUser());
			for (int i = 0; i < selectArray.length; i++) {
				WayVO wayVO = agway.doFindByPk(selectArray[i], getDBAccessUser());
				agway.doDelete(wayVO, getDBAccessUser());
			}
		} catch (Exception e) {
			e.printStackTrace();
			setActionMessage(e.getMessage());
		}
		return doList();
	}
	
	// ���������˳�
	public String doAgdeleteapply() throws Exception{
		try{
			String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
			if(selectArray == null) {
				addActionError("�޷���ȡѡ����Ŀ��");
				return "list";
			}
			Flowname flowname = (Flowname)BOFactory.build(FlownameBO.class, getDBAccessUser());
			FlownameVO flvo = flowname.doFindByPk("WAY_REMOVE_AUDIT1");
			if (flvo == null || (flvo.getOprcode() == null || "".equals(flvo.getOprcode().trim()))) {
				super.addActionError("��һ��������û�ж��壡");
				return "list";
			}
			String oprcode = flvo.getOprcode();
			
			Way way = (Way)BOFactory.build(WayBO.class, getDBAccessUser());
			Wayapply apply = (Wayapply)BOFactory.build(WayapplyBO.class,getDBAccessUser());
			WayapplyVO vo = null;
			for (int i = 0; i < selectArray.length; i++) {
				vo = way.doGetsaleeidt(selectArray[i],getDBAccessUser());
				apply.doWayapply(oprcode, vo, getDBAccessUser(), "remove");
			}
			super.addActionMessage("�����˳�����ɹ���");
		}catch(Exception e){
			super.addActionError(e.getMessage());
		}
		return this.doList();
	}
	
	/**
	 * �������������߼�ɾ����waystate 0 �ѹرգ�
	 */
	public String doDeleteByMemo() throws Exception {
		try {
			String[] selectArray = (String[])this.getRequest().getSession().getAttribute("selectArray");
			//String memo = this.getRequest().getParameter("memo");
			
			if(selectArray == null) {
				addActionError("�޷���ȡѡ����Ŀ��");
				return "toDelete";
			}
			Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,getDBAccessUser());
			//1:�˳�ʱ��Ҫ��дԭ�� 0:������д�˳�ԭ�� ��:������д�˳�ԭ��
			param75 = sysparamBO.doFindByID("75", "channel");
			Date now = new Date();
			AGWay agway = (AGWay)BOFactory.build(AGWayBO.class, getDBAccessUser());
			Changelog changelogBO = (ChangelogBO)BOFactory.build(ChangelogBO.class, getDBAccessUser());
			for (int i = 0; i < selectArray.length; i++) {
				WayVO wayVO = agway.doFindByPk(selectArray[i], getDBAccessUser());
				
				ChangelogVO clVO = new ChangelogVO();
				clVO.setOptime(now);//����ʱ��
				clVO.setOprcode(getDBAccessUser().getOprcode());//����Ա����
				clVO.setOprtype("update");//��������
				clVO.setWayid(selectArray[i]);//��������
				clVO.setChangetype(Short.parseShort("2"));//�䶯����
				clVO.setOldvalue(""+wayVO.getWaystate());//�䶯ǰֵ 
				clVO.setNowvalue("0");//�䶯��ֵ
				clVO.setMemo(memo);//��ע 
			 
				agway.doDelete(wayVO, getDBAccessUser()); 
				changelogBO.doCreate(clVO);
			}
			this.getRequest().getSession().setAttribute("selectArray", null);
		} catch (Exception e) {
			this.getRequest().getSession().setAttribute("selectArray", null);
			e.printStackTrace();
			setActionMessage(e.getMessage());
		}
		return doList();
	}
	
	/**
	 * ��д�˳�ԭ��
	 * @return
	 * @throws Exception
	 */
	public String doToDelete() throws Exception {
		String wayids = this.getRequest().getParameter("wayids");
		wayids=wayids.substring(1);
		String[] selectArray = wayids.split("\\|");
		
		this.getRequest().getSession().setAttribute("selectArray", selectArray);
		return "toDelete";
	}
	
	/**
	 * ������������Ϣ����ͨ��Ϣ���˻���Ϣ����ͬ��Ϣ���޸�
	 */
	public String doEdit() throws Exception {
		try {
			HttpServletRequest request = getRequest();
			String wayid = request.getParameter("param._pk");
			SalewayForm form = (SalewayForm) getForm();
			
			//���á��Ƿ���Ȩ���㡿Ϊ��ɫ�����޸ģ������������޸�
			if(form.getChecked() == null || "".equals(form.getChecked()))
				form.setChecked("N");
			
			WayDBParam param = (WayDBParam)getParam();
			DBAccessUser user = getDBAccessUser();
			
			Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,getDBAccessUser());
			//1:�˳�ʱ��Ҫ��дԭ�� 0:������д�˳�ԭ�� ��:������д�˳�ԭ��
			param75 = sysparamBO.doFindByID("75", "channel");
			request.setAttribute("request", param75); 
			// ���Ȩ������
			String paramvalue1 = sysparamBO.doFindByID(new Long("77"), "channel");
			// ���paramvalue�鵽��¼����ֵΪ1������Ҫ���µĹ̶�������ʾ����ID������
			if ("1".equals(paramvalue1)) {
				this.setFlag("yes");
			}
			Wayprovince wayprovince = (Wayprovince) BOFactory.build(WayprovinceBO.class, user);
			List wList = wayprovince.doQueryWpByWayid(wayid);
			if(wList != null && !"".equals(wList) && wList.size()>0){
				WayprovinceVO wVO = (WayprovinceVO)wList.get(0);
				BeanUtils.copyProperties(form, wVO);				
			} 
			
			// String canEditMainLayer = "Y";
			Date starttime=null;
			if (wayid == null || "".equals(wayid)) {
				has3Gright = "true";
				if (param.get_se_upperwayid() == null
						|| "".equals(param.get_se_upperwayid())) {
//					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
//							"CMS-11002:����ָ���ϼ����ϼ�����");
//					return "list";
					addActionMessage("����ָ���ϼ����ϼ�����");
					return this.doList();
					
				}
				Way way = (Way)BOFactory.build(WayBO.class, user);
				WayVO wayVO = way.doFindByPk(param.get_se_upperwayid());
				/*
				 * if("ET".equals(wayVO.getWaytype())){ canEditMainLayer = "Y";
				 * }else if("AG".equals(wayVO.getWaytype())){ canEditMainLayer =
				 * "N"; }
				 */
				
				if(wayVO == null) {
					super.addActionMessage("����ѡ��һ���ϼ�������ֻ����������Ӫ�����̣��ƶ�����/���һ������������������");
					return this.doList();
				}
				// ֻ�������������̻������������������
				if ("DIS".equals(wayVO.getWaysubtype())
						|| "GMPT".equals(wayVO.getWaysubtype())
						|| "G100".equals(wayVO.getWaysubtype())
						|| "D4S".equals(wayVO.getWaysubtype())
						|| "D5S".equals(wayVO.getWaysubtype())
						|| "D6S".equals(wayVO.getWaysubtype())) {
					form.setUpperwayid(wayVO.getWayid());
					form.setCityid(wayVO.getCityid());
					form.setCountyid(wayVO.getCountyid());
					form.setSvccode(wayVO.getSvccode());
					form.setMareacode(wayVO.getMareacode());
					form.setCenterid(wayVO.getCenterid());
					form.setWaylevel(wayVO.getWaylevel());
				} else {
					super.addActionMessage("����ѡ��һ���ϼ�������ֻ����������Ӫ�����̣��ƶ�����/���һ������������������");
					form.setUpperwayid("");
					form.setCityid("");
					form.setCountyid("");
					form.setSvccode("");
					form.setMareacode("");
					form.setCenterid("");
				}
				if (StringUtils.equals(wayVO.getWaytype(), "AG")
						&& StringUtils.equals(wayVO.getWaysubtype(), "DIS")) {
					form.setChainhead(wayVO.getWayid());
				}
				this.setCMD("NEW");
			} else {
				//��ѯ������������͡�
				Waybusicircle waybusicircleBO = (WaybusicircleBO)BOFactory.build(WaybusicircleBO.class,getDBAccessUser());
				WaybusicircleDBParam waybusicircleDBParam = new WaybusicircleDBParam();
				waybusicircleDBParam.set_se_wayid(form.getWayid());
				DataPackage WaybusicircleDP = waybusicircleBO.doQuery(waybusicircleDBParam);
				if(WaybusicircleDP != null && !"".equals(WaybusicircleDP)
						&& WaybusicircleDP.getDatas() != null && !"".equals(WaybusicircleDP.getDatas())
						&& WaybusicircleDP.getDatas().size() > 0){//����
					WaybusicircleVO wbVO = (WaybusicircleVO)WaybusicircleDP.getDatas().get(0);
					
					form.setRewardkind(""+wbVO.getRewardkind());
					form.setBuscno(wbVO.getBuscno());
					form.setWayattr(wbVO.getWayattr());
					if(wbVO.getWaymod() != null && !"".equals(wbVO.getWaymod()))
						form.setWaymod(""+wbVO.getWaymod());
				}
				if("0".equals(form.getRewardkind())){
					has3Gright = "true";
				}else if("2".equals(form.getRewardkind())){
					has3Gright = "true";
				}else{
					has3Gright = "false";
				}
				
				//��ѯ֮ǰ���µı�ע				
				Changelog changelogBO = (ChangelogBO)BOFactory.build(ChangelogBO.class, getDBAccessUser());
				ChangelogDBParam changelogDBParam = new ChangelogDBParam();
				changelogDBParam.set_se_wayid(param.get_pk());
				changelogDBParam.set_ne_changetype("2");
				changelogDBParam.set_orderby("optime");
				changelogDBParam.set_desc("1");
				DataPackage clDp= changelogBO.doQuery(changelogDBParam);
				if(clDp.getRowCount()>0){
					ChangelogVO changelogVO = (ChangelogVO)clDp.getDatas().get(0);
					memo = changelogVO.getMemo();
				}
				Way way = (Way)BOFactory.build(WayBO.class, user);
				Bchcontact bchcontact = (Bchcontact)BOFactory.build(BchcontactBO.class, user);
				Waycompact waycompact = (Waycompact)BOFactory.build(WaycompactBO.class, user);
				Wayaccount wayaccount = (Wayaccount)BOFactory.build(WayaccountBO.class, user);
				Cooperator cooperator =(Cooperator)BOFactory.build(CooperatorBO.class, user);
				Employee employee = (Employee)BOFactory.build(EmployeeBO.class, user);

				WayVO wayVO = way.doFindByPk(wayid);
				if(wayVO!=null)
				{
					starttime=wayVO.getStarttime();
				}
				/*
				 * if("DIS".equals(upperVO.getWaysubtype())){ canEditMainLayer =
				 * "N"; }else{ canEditMainLayer = "Y"; }
				 */
				BchcontactVO bchcontactVO = bchcontact.doFindByPk(
						wayid);
				WaycompactVO waycompactVO = waycompact.doFindByPk(
						wayid);
				WayaccountVO wayaccountVO = new WayaccountVO();
				wayaccountVO.setWayid(wayid);
				wayaccountVO.setAccid(new Integer(0));
				wayaccountVO = wayaccount
						.doFindByPk(wayaccountVO);
				CooperatorVO cooperatorVO = cooperator.doFindByPk(
						wayid);
				EmployeeDBParam listVO = new EmployeeDBParam();
				listVO.set_se_wayid(wayid);
				listVO.set_ne_isnet("1");
				listVO.set_ne_empstatus("0");
				Iterator iterator = employee.doQuery(listVO)
						.getDatas().iterator();
				if (iterator.hasNext()) {
					form.setOfficetel(((EmployeeVO) iterator.next())
							.getOfficetel());
				}

//				AuditUtils utils = new AuditUtils();
//				String[] waypk = { "wayid" };
//				wayVO = (WayVO) utils.doGetAuditvalue(wayVO, "CH_PW_WAY",
//						"CH_PW_SALEWAY", waypk, user);
//
//				bchcontactVO = (BchcontactVO) utils.doGetAuditvalue(
//						bchcontactVO, "CH_PW_BCHCONTACT", "CH_PW_SALEWAY",
//						waypk, user);
//
//				waycompactVO = (WaycompactVO) utils.doGetAuditvalue(
//						waycompactVO, "CH_PW_WAYCOMPACT", "CH_PW_SALEWAY",
//						waypk, user);
//				wayaccountVO = (WayaccountVO) utils.doGetAuditvalue(
//						wayaccountVO, "CH_PW_WAYACCOUNT", "CH_PW_SALEWAY",
//						waypk, user);

				if (bchcontactVO != null) {
					BeanUtils.copyProperties(form, bchcontactVO);
					form.setAddress(null);// ���������addressΪ׼.
				}
				//���á��Ƿ���Ȩ���㡿�����û�ԭ����ֵ
				form.setChecked(null);
				BeanUtils.copyProperties(form, wayVO);
				if (waycompactVO != null) {
					BeanUtils.copyProperties(form, waycompactVO);
					form.setCmpendtime(waycompactVO.getEndtime());
				}
				if (wayaccountVO != null) {
					BeanUtils.copyProperties(form, wayaccountVO);
				}
				if (cooperatorVO != null) {
					cooperatorVO.setCityid(form.getCityid());
					cooperatorVO.setCountyid(form.getCountyid());
					cooperatorVO.setSvccode(form.getSvccode());
					cooperatorVO.setMareacode(form.getMareacode());
					BeanUtils.copyProperties(form, cooperatorVO);
				}
				form.setStarttime(starttime);
				form.setOldstate(wayVO.getWaystate());
				this.setCMD("EDIT");
				// ���Ȩ������
				Sysparam sysparam = (Sysparam)BOFactory.build(SysparamBO.class, user);
				String paramvalue = sysparam.doFindByID(new Long("72"), "channel");
				// ���paramvalue�鵽��¼����ֵΪ1������ΪҪ���Ȩ������
				if ("1".equals(paramvalue)) {
					boolean hasPermission = false;
					PermissionChecker checker = (PermissionChecker) InterfaceUtils.getInstance().createImplObject(PermissionChecker.class);
					hasPermission = checker.checkPermission( user.getOprcode() , CH_PW_STARLEVEL);
					if (!hasPermission) {
						this.setHasFlag("false");
					}
				}
			}
			if(form.getWaymod() == null || "".equals(form.getWaymod())){
				form.setWaymod("1");
			}
			if(form.getBuscno() == null || "".equals(form.getBuscno())){
				form.setBuscno("0000");
			}
			if(form.getCreditlevel() == null || "".equals(form.getCreditlevel())){
				form.setCreditlevel("0");
			}
		} catch (Exception e) {
			setActionMessage(e.getMessage());
		}
		return "content";
	}
	
	//��ͨ����
	public String doSetservice() throws Exception {
		try {
			AGWay delegate = (AGWay)BOFactory.build(AGWayBO.class, getDBAccessUser());
			HttpServletRequest request = getRequest();
			String wayid = request.getParameter("wayid");
			delegate.doSetservice(wayid, getDBAccessUser());
			super.addActionMessage("������Ϣ����ͨ��Ҫһ��ʱ�䣬���Ժ�鿴�Ƿ�ͨ�ɹ�");
		} catch (Exception e) {
			setActionMessage(e.getMessage());
		}
		return this.doList();
	}
	
	//����TXT
	public String doExportTxt(){
		try{
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			super.getParam().setQueryAll(true);
			export.setFileName("���������Ϣ����");
			String selectedFields = getRequest().getParameter("selectedFields");
			// sfArray���� ��ÿ����ѡ�ֶ���optionFields��һάԪ�ص��±�ֵ
			String[] sfArray = selectedFields.split(",");
			// titleArray ��ѡ�ֶ���������
			String[] titleArray = new String[sfArray.length];
			for(int i = 0;i < sfArray.length;i++) {
				int k = Integer.parseInt(sfArray[i]);
				if(k == (int)(15+1) || k==(int)((36+1)+1) || k==(int)((37+1)+1) || k==(int)((38+1)+1) || k==(int)((40+1)+1)){
					export.addOutputProperty(optionFields[k][0],optionFields[k][1],CommonExportBean.DATE,"yyyy-MM-dd");
					titleArray[i] = optionFields[k][1];
				}else if(k==(int)4){
					export.addOutputProperty(optionFields[k][0],optionFields[k][1],CommonExportBean.CODE2NAME,"#WAY");
					titleArray[i] = optionFields[k][1];
				}else if(k==(int)71){
					export.addOutputProperty(optionFields[k][0],optionFields[k][1],CommonExportBean.CODE2NAME,"$CH_TAXCERTIFICATE");
					titleArray[i] = optionFields[k][1];
				}
				else{
					export.addOutputProperty(optionFields[k][0],optionFields[k][1]);
					titleArray[i] = optionFields[k][1];
				}
			}
//			for(int i = 0;i < sfArray.length;i++) {
//				int k = Integer.parseInt(sfArray[i]);
//				if(k == (int)15 || k==(int)(36+1) || k==(int)(37+1) || k==(int)(38+1) || k==(int)(40+1)){
//					export.addOutputProperty(optionFields[k][0],optionFields[k][1],CommonExportBean.DATE,"yyyy-MM-dd");
//					titleArray[i] = optionFields[k][1];
//				}else
//				{
//					export.addOutputProperty(optionFields[k][0],optionFields[k][1]);
//					titleArray[i] = optionFields[k][1];
//				}
//			}
			
			/*export.addOutputProperty("wayid", "��������");
			export.addOutputProperty("wayname", "��������");
			export.addOutputProperty("officetel", "�ɼ�ƽ̨�����ֻ���");
			export.addOutputProperty("isopen", "��ͨ��־",export.CODE2NAME,"$CH_ISOPEN");
			export.addOutputProperty("waysubtype", "����������� ",export.CODE2NAME,"WAYSUBTYPE");
			export.addOutputProperty("upperwayid", "�ϼ�����",export.CODE2NAME,"#WAY");
			export.addOutputProperty("latitude", "����γ��");
			export.addOutputProperty("longtitude", "������");
			export.addOutputProperty("starlevel", "�Ǽ�",export.CODE2NAME,"$CH_STARLEVEL");
			export.addOutputProperty("pt", "������",export.CODE2NAME,"$CH_PT");
			export.addOutputProperty("isstraitprd", "�Ƿ�ֱ��",export.CODE2NAME,"$CH_STRAITPRD");
			export.addOutputProperty("catetype", "��������",export.CODE2NAME,"$CH_CATETYPE");
			export.addOutputProperty("cityid", "���й�˾",export.CODE2NAME,"#CITYCOMPANY");
			export.addOutputProperty("countyid", "�ֹ�˾",export.CODE2NAME,"#CNTYCOMPANY");
			export.addOutputProperty("svccode", "������������",export.CODE2NAME,"#CH_SERVCENT");
			export.addOutputProperty("mareacode", "΢����",export.CODE2NAME,"#CH_MICROAREA");
			export.addOutputProperty("adtypecode", "��������",export.CODE2NAME,"$CH_ADTYPE");
			export.addOutputProperty("adacode", "��������",export.CODE2NAME,"#CH_ADIMAREA");
			export.addOutputProperty("formtype", "ҵ̬����",export.CODE2NAME,"$CH_FORMTYPE");
			export.addOutputProperty("starttime", "������ʼʱ��",export.DATE,"yyyy-MM-dd");
			export.addOutputProperty("logiscode", "����������");
			export.addOutputProperty("waymagcode", "��������������Ա����");
			export.addOutputProperty("bchlevel", "�ּ�",export.CODE2NAME,"$CH_BCHLEVEL");
			export.addOutputProperty("waystate", "����״̬",export.CODE2NAME,"$CH_VALIDFLAG");
			export.addOutputProperty("address", "��ϸ��ַ");*/
			
			export.voClassArray = new Class[] {AGWayVO.class};
			prepareResponse(export.getFileName());
			export.queryMethodName = "doQueryWayAndSubwayDetailInfo";

			export.writeTxtTitle(getResponse().getOutputStream(), titleArray);
			super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return null;
	}
	
	//exportExcel
	//����Excel
	public String doExportExcel(){
		try{
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			super.getParam().setQueryAll(true);
			export.setFileName("���������Ϣ����");
			String selectedFields = getRequest().getParameter("selectedFields");
			// sfArray���� ��ÿ����ѡ�ֶ���optionFields��һάԪ�ص��±�ֵ
			String[] sfArray = selectedFields.split(",");
			// titleArray ��ѡ�ֶ���������
			String[] titleArray = new String[sfArray.length];
			for(int i = 0;i < sfArray.length;i++) {
				int k = Integer.parseInt(sfArray[i]);
				if(k == (int)(15+1) || k==(int)((36+1)+1) || k==(int)((37+1)+1) || k==(int)((38+1)+1) || k==(int)((40+1)+1)){
					export.addOutputProperty(optionFields[k][0],optionFields[k][1],CommonExportBean.DATE,"yyyy-MM-dd");
					titleArray[i] = optionFields[k][1];
				}else if(k==(int)4){
					export.addOutputProperty(optionFields[k][0],optionFields[k][1],CommonExportBean.CODE2NAME,"#WAY");
					titleArray[i] = optionFields[k][1];
				}else if(k==(int)71){
					export.addOutputProperty(optionFields[k][0],optionFields[k][1],CommonExportBean.CODE2NAME,"$CH_TAXCERTIFICATE");
					titleArray[i] = optionFields[k][1];
				}
				else{
					export.addOutputProperty(optionFields[k][0],optionFields[k][1]);
					titleArray[i] = optionFields[k][1];
				}
			}
//			for(int i = 0;i < sfArray.length;i++) {
//				int k = Integer.parseInt(sfArray[i]);
//				if(k == (int)15 || k==(int)(36+1) || k==(int)(37+1) || k==(int)(38+1) || k==(int)(40+1)){
//					export.addOutputProperty(optionFields[k][0],optionFields[k][1],CommonExportBean.DATE,"yyyy-MM-dd");
//					titleArray[i] = optionFields[k][1];
//				}else
//				{
//					export.addOutputProperty(optionFields[k][0],optionFields[k][1]);
//					titleArray[i] = optionFields[k][1];
//				}
//			}
			
			export.voClassArray = new Class[] {AGWayVO.class};
			//prepareResponse(export.getFileName());
			export.queryMethodName = "doQueryWayAndSubwayDetailInfo";
			
//			export.writeTxtTitle(getResponse().getOutputStream(), titleArray);
//			export.writeExcelEndLine(getResponse().getOutputStream(), titleArray);
			
			//export.wri
			this.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
			super.doExcel();
			
			///super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return null;
	}
	
	
	public String  doCheckupperway() throws Exception {
		Way way = (Way) BOFactory.build(WayBO.class, getDBAccessUser());
		SalewayForm form = (SalewayForm) getForm();
		WayVO uppwayVO = way.doFindByPk(form.getUpperwayid());
		if(uppwayVO==null)
		{
			throw new Exception("��ѡ������PBOSSϵͳû���ҵ�!");
		}
		
		//���á��Ƿ���Ȩ���㡿�����û�ԭ����ֵ
		WayVO wayVO = way.doFindByPk(form.getWayid());
		if(wayVO!=null)
		{
			form.setChecked(wayVO.getChecked());
		}else{//�������ɷ�
			form.setChecked("N");
		}
		
		// ���������ϼ����������Ǻ����̣��ƶ�����/���һ������������������
		if ("DIS".equals(uppwayVO.getWaysubtype())
				|| "GMPT".equals(uppwayVO.getWaysubtype())
				|| "G100".equals(uppwayVO.getWaysubtype())) {
			form.setCityid(uppwayVO.getCityid());
			form.setCountyid(uppwayVO.getCountyid());
			form.setSvccode(uppwayVO.getSvccode());
			form.setMareacode(uppwayVO.getMareacode());
		} else {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"¼����ϼ�����ֻ����������Ӫ�����̣��ƶ�����/���һ������");
			form.setUpperwayid("");
			form.setCityid("");
			form.setCountyid("");
			form.setSvccode("");
			form.setMareacode("");
		}
		if (form.getWayid()==null || way.doFindByPk(form.getWayid())==null) {
			this.setCMD("NEW");
		} else {
			this.setCMD("EDIT");
		}
		if(StringUtils.equals(uppwayVO.getWaytype(), "AG") && StringUtils.equals(uppwayVO.getWaysubtype(), "DIS"))
		{
			form.setChainhead(uppwayVO.getWayid());
		}
		else
		{
			form.setChainhead("");
		}
		return "content";
	}
	public String getHasFlag() {
		return hasFlag;
	}
	public void setHasFlag(String hasFlag) {
		this.hasFlag = hasFlag;
	}
	//�޸ĵ��Ǽ��޸����ж�
	public void checkUpdateStartLevel(AGWayVO wayVO,User user) throws Exception
	{
		if(wayVO != null)
		{
			String wayid = wayVO.getWayid();
			//User user = (User) getDBAccessUser();
			AGWayBO wayBO = (AGWayBO)BOFactory.build(AGWayBO.class, user);
			WayVO wayvo = wayBO.doFindByPk(wayid, user);
			
			Long starLevel=wayVO.getStarlevel();
			Long beforeStarLevel = wayvo.getStarlevel();
			
			if(starLevel != null && beforeStarLevel != null) {
				if(beforeStarLevel == 1 || beforeStarLevel == 2){					
					if(starLevel>=3){
						wayVO.setStarttime(new Date());
					}					
				}
				if(beforeStarLevel >= 3){
					if(starLevel == 1 || starLevel == 2){
						wayVO.setStarttime(null);
					}
				}
			}
		}
	}
	
	
	//�������Ǽ��޸����ж�
	public void checkAddStartLevel(AGWayVO wayVO) throws Exception
	{
		if(wayVO != null)
		{
			Long starLevel=wayVO.getStarlevel();
			if(starLevel >= 3){
				wayVO.setStarttime(new Date());
			}
			if(starLevel == 1 || starLevel == 2){
				wayVO.setStarttime(null);
			}	
		}
	}
	public String getParam75() {
		return param75;
	}
	public void setParam75(String param75) {
		this.param75 = param75;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getHas3Gright() {
		return has3Gright;
	}
	public void setHas3Gright(String has3Gright) {
		this.has3Gright = has3Gright;
	}
}
