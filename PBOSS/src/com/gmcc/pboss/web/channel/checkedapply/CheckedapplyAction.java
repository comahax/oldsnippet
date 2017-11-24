/**
 * auto-generated code
 * Sat Jun 09 10:21:12 CST 2012
 */
 package com.gmcc.pboss.web.channel.checkedapply;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.gmcc.pboss.business.channel.checkedapply.CheckedapplyDBParam;
import com.gmcc.pboss.business.channel.checkedapply.CheckedapplyVO;
import com.gmcc.pboss.business.channel.checkedapplydetail.CheckedapplydetailDBParam;
import com.gmcc.pboss.business.channel.checkedapplydetail.CheckedapplydetailVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.common.ftp.FtpAccess;
import com.gmcc.pboss.common.ftp.FtpBusUtils;
import com.gmcc.pboss.common.ftp.FtpInfo;
import com.gmcc.pboss.control.base.operright.Operright;
import com.gmcc.pboss.control.base.operright.OperrightBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.checkedapply.Checkedapply;
import com.gmcc.pboss.control.channel.checkedapply.CheckedapplyBO;
import com.gmcc.pboss.control.channel.checkedapplydetail.Checkedapplydetail;
import com.gmcc.pboss.control.channel.checkedapplydetail.CheckedapplydetailBO;
import com.gmcc.pboss.control.channel.nosect.Nosect;
import com.gmcc.pboss.control.channel.nosect.NosectBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;
 

/**
 * <p>Title: CheckedapplyAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CheckedapplyAction extends BaseAction{
	
	private String remotepath = "checkedapply";
	//excel�ļ�
	private File appathDoc;
	private String appathDocFileName;
	private String appathDocType;
	//ppt�ļ�
	private File pptpathDoc;
	private String pptpathDocFileName;
	private String pptpathDocType;
	// ӵ�зֹ�˾����
	private boolean CH_CHECKED_COUNTY;
	// ӵ���й�˾��������
	private boolean CH_CHECKED_MIDCITY;
	// ϵͳ��������Ȩ���㼸���������
	private boolean paramvalue;
	
	public boolean isCH_CHECKED_COUNTY() {
		return CH_CHECKED_COUNTY;
	}

	public void setCH_CHECKED_COUNTY(boolean ch_checked_county) {
		CH_CHECKED_COUNTY = ch_checked_county;
	}

	public CheckedapplyAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new CheckedapplyForm());
		this.setParam(new CheckedapplyDBParam());

        //ָ��VO��
        setClsVO(CheckedapplyVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"applyno"};
		this.setClsControl(Checkedapply.class);
		this.setClsQueryParam(CheckedapplyDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	/**
	 * 1���ж��й�˾�Ƿ�������ϵͳ��������Ȩ���㼸��������̡�(systemid=83, paramtype=��channel��)����ֵΪ1
	 * 2���жϵ�ǰ��¼�û��Ƿ�ӵ�зֹ�˾����
	 * 3���жϵ�ǰ��¼�û��Ƿ�ӵ���й�˾��������
	 * @throws Exception
	 */
	private void getSysParme() throws Exception {
		Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class, getDBAccessUser());
		String value = sysparam.doFindByID("83", "channel");
		if (value != null && value.equals("1")) {
			paramvalue = true;
		}
		
		Operright operright = (Operright) BOFactory.build(OperrightBO.class, DBAccessUser.getInnerUser());
		boolean ch_checked_county = operright.doCheckPermission(getDBAccessUser().getOprcode(), "CH_CHECKED_COUNTY");
		setCH_CHECKED_COUNTY(ch_checked_county);
		
		boolean ch_checked_midcity = operright.doCheckPermission(getDBAccessUser().getOprcode(), "CH_CHECKED_MIDCITY");
		this.setCH_CHECKED_MIDCITY(ch_checked_midcity);
	}
	
	//��ѯ��Ȩ�����������Ϣ
	public String doList() throws Exception {
		CheckedapplyDBParam params = (CheckedapplyDBParam) getParam();
		if(flag){    //���뿪ʼʱ��Ĭ��Ϊ���µ�һ��ĵ�������
			Date mdate = new Date();
			SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-");
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
			String stockdate = myformat.format(mdate)+"01 00:00:00";
			String currdate = format.format(mdate)+" 23:59:59";
			params.set_dnl_aptime(stockdate);
			params.set_dnm_aptime(currdate);
		}
		
		/*
		 * �ж��й�˾�Ƿ�������ϵͳ��������Ȩ���㼸��������̡�����ֵΪ1
		 * �жϵ�ǰ��¼�û��Ƿ�ӵ�зֹ�˾����
		 * �жϵ�ǰ��¼�û��Ƿ�ӵ���й�˾��������
		 */
		getSysParme();
		/*
		 * ӵ�зֹ�˾���ơ�CH_CHECKED_COUNTY����ѯSTATUSΪ 2 �� 3 ������
		 * ӵ���й�˾�������ơ�CH_CHECKED_MIDCITY����ѯSTATUSΪ 1 �� 2 ������
		 */
		if (paramvalue && CH_CHECKED_COUNTY) {
			params.set_sql_or("status = 2 or status = 3");
		} else if (paramvalue && CH_CHECKED_MIDCITY) {
			params.set_sql_or("status = 0 or status = 1");
		}
		params.set_se_oprcode(getDBAccessUser().getOprcode());
		params.set_orderby("applyno");
		params.set_desc("1");
		return super.doList();
	}
	
	/**
	 * ������������ҳ��
	 */
	public String doBatch() throws Exception {
		CheckedapplyDBParam params = (CheckedapplyDBParam) getParam(); 
		HttpServletRequest request = getRequest();
		request.getSession().setAttribute("checkparam", params);

		return "batchapply";
	}
	
	/**
	 * ����������ҳ�淵��
	 * @return
	 * @throws Exception
	 */
	public String doRetrunfrombatch() throws Exception {
		//ȡ�õ���ҳ�淵�ص�ʱ��Ĳ���ֵ
		HttpServletRequest request = getRequest();
		CheckedapplyDBParam batchparams = (CheckedapplyDBParam)request.getSession().getAttribute("checkparam");
		String applyno = batchparams.getApplyeno();
		CheckedapplyDBParam params = (CheckedapplyDBParam) getParam();
		
		// ���÷���ҳ��
		String result = "";
		if (applyno == null || "".equals(applyno)) {
			BeanUtils.copyProperties(params, batchparams);
			result = this.doNew();
		} else {
			BeanUtils.copyProperties(params, batchparams);
			result = this.doApplydeatilinfo();
		}
		return result;
	}
	/**
	 *��ϸ����ҳ���б��ҳ
	 */
	  public String doSplitPage() throws Exception{
		//ȡ�õ���ҳ�淵�ص�ʱ��Ĳ���ֵ
			HttpServletRequest request = getRequest();
			String applyno = request.getParameter("param.applyeno"); 
			if (applyno == null || "".equals(applyno)) { 
				this.doNew();
			} else { 
				 this.doApplydeatilinfo();
			}
			//this.setDp(dp);
		  return "editlist";
	  }
	
	
	//������ʼ����Ȩ�����������Ϣ����
	public String doNew() throws Exception{
		/*
		 * �ж��й�˾�Ƿ�������ϵͳ��������Ȩ���㼸��������̡�����ֵΪ1
		 * �жϵ�ǰ��¼�û��Ƿ�ӵ�зֹ�˾����
		 * �жϵ�ǰ��¼�û��Ƿ�ӵ���й�˾��������
		 */
		getSysParme();
		
		HttpServletRequest request = getRequest(); 
	    CheckedapplyDBParam params = (CheckedapplyDBParam) getParam(); 
	    // ��������ʱ��
	    if (null==params.getAptime())
	    	params.setAptime(new Date());
	    // �����������
	    if (null==params.getCityid())
	    	params.setCityid(getDBAccessUser().getCityid());
	    // ���������˹���
	    if (null==params.getOprcode())
	    	params.setOprcode(getDBAccessUser().getOprcode());
		request.getSession().setAttribute("NewParms",params) ;
		CheckedapplydetailDBParam param = new CheckedapplydetailDBParam(); 
		param.set_pageno(params.get_pageno());
		param.set_pagesize(params.get_pagesize());
		param.set_se_oprcode(getDBAccessUser().getOprcode()); 
		param.set_se_applyno(params.getApplyeno());
		//������������
		param.set_se_applytype(params.getApplytype());
		
		DataPackage dp = null;
		Checkedapplydetail checkedapplydetailBO = (Checkedapplydetail) BOFactory.build(CheckedapplydetailBO.class, getDBAccessUser());
		if (paramvalue && CH_CHECKED_COUNTY) {
			dp = checkedapplydetailBO.doQueryInfoForInsert_COUNTY(param);
		} else if (paramvalue && CH_CHECKED_MIDCITY) {
			dp = checkedapplydetailBO.doQueryInfoForInsert_MIDCITY(param);
		} else {
			dp = checkedapplydetailBO.doQueryInfoForInsert(param);
		}
		
        this.setDp(dp);
		return "editlist"; 
	}
	//�༭��ʼ����Ȩ�����������Ϣ����
	public String doApplydeatilinfo() throws Exception{ 
		 HttpServletRequest request = getRequest(); 
		 Checkedapply checkedapply = (Checkedapply)BOFactory.build(CheckedapplyBO.class,getDBAccessUser());
		 CheckedapplyDBParam params = (CheckedapplyDBParam) getParam();
		 
		 //�������뵥��
		 String applyno = "";
		 if (request.getParameter("param._pk")!=null)
			 applyno = request.getParameter("param._pk");
		 if ("".equals(applyno))
			 applyno = params.getApplyeno();
		 CheckedapplyVO checkedapplyVO = checkedapply.doFindByPk(Long.parseLong(applyno));
		 CheckedapplyForm form = new CheckedapplyForm();
		 BeanUtils.copyProperties(form, checkedapplyVO);
		
		 //����ҳ����ֵ
		 BeanUtils.copyProperties(params, checkedapplyVO);
		 //������뵥��Ϊ��
		 if (params.getApplyeno()==null)
			 params.setApplyeno(checkedapplyVO.getApplyno().toString());
		 this.setForm(form);
		 CheckedapplydetailDBParam param = new CheckedapplydetailDBParam(); 
		 param.set_pageno(params.get_pageno()); 
	    // param.set_pagesize(params.get_pagesize());
		 param.set_pagesize("0");
		 param.set_se_applyno(checkedapplyVO.getApplyno().toString()); 
		 param.set_se_applytype(params.getApplytype());
		 Checkedapplydetail checkedapplydetailBO = (Checkedapplydetail) BOFactory.build(CheckedapplydetailBO.class, getDBAccessUser()); 
		 DataPackage dp = checkedapplydetailBO.doQueryInfoForUpdate(param);  
         this.setDp(dp);
         //���µ�ʱ���������Ͳ��ɱ�
         this.setADDUP("1");
		return "editlist";
	}
	
	//������Ȩ�����������Ϣ
	public String doSave()throws Exception{
		String savecmd = "0";
	   try {
		HttpServletRequest request = getRequest(); 
		CheckedapplyDBParam params = (CheckedapplyDBParam) getParam();

		// ����ֻ��Ÿ���������ͬһ������
		Nosect control = (Nosect) BOFactory.build(NosectBO.class, getDBAccessUser());
		String cityid = control.doQueryCityID(params.getMobileno());
		if (!getDBAccessUser().getCityid().equals(cityid)) {
			throw new Exception("�ֻ�������������: "+cityid+" ���¼�����������в�һ��");
		}
		Checkedapply checkedapply = (Checkedapply)BOFactory.build(CheckedapplyBO.class,getDBAccessUser());
		CheckedapplyVO checkedapplyVO = new CheckedapplyVO();
		BeanUtils.copyProperties(checkedapplyVO, params);

			if ((null != getAppathDocFileName() && !"".equals(this
					.getAppathDocFileName()))
					|| (null != getPptpathDocFileName() && !"".equals(this
							.getPptpathDocFileName()))) {
				FtpInfo ftpInfo = FtpInfo.getInstance();
				FtpAccess ftp = new FtpAccess(ftpInfo);
				if (null != getAppathDocFileName()
						&& !"".equals(this.getAppathDocFileName())) {
					// �ϴ����ļ��ñ����ļ�����
					String filename =changeFilename(getAppathDocFileName(),"Y");
					String appath = ftp.uploadFile(this.appathDoc, remotepath,
							true, filename);
					checkedapplyVO.setAppath(appath);
					params.setAppath(appath);
				}
				if (getPptpathDocFileName() != null
						&& !"".equals(this.getPptpathDocFileName())) {
					// �ϴ����ļ��ñ����ļ�����
					String filename =changeFilename(getPptpathDocFileName(),"N");
					String pptpath = ftp.uploadFile(this.pptpathDoc,
							remotepath, true, filename);
					checkedapplyVO.setPptpath(pptpath);
					params.setPptpath(pptpath);
				}
			}
			
			/*
			 * �ж��й�˾�Ƿ�������ϵͳ��������Ȩ���㼸��������̡�����ֵΪ1
			 * �жϵ�ǰ��¼�û��Ƿ�ӵ�зֹ�˾����
			 * �жϵ�ǰ��¼�û��Ƿ�ӵ���й�˾��������
			 */
			getSysParme();
			if (paramvalue && CH_CHECKED_COUNTY) {
				//������ϵͳ��������Ȩ���㼸��������̡�ֵΪ1������ӵ�зֹ�˾����
				checkedapplyVO.setStatus("2");
			} else if (paramvalue && CH_CHECKED_MIDCITY) {
				//������ϵͳ��������Ȩ���㼸��������̡�ֵΪ1������ӵ���й�˾��������
				checkedapplyVO.setStatus("0");
			} else {
				checkedapplyVO.setStatus("0");
			}
			
			if(null==params.getApplyeno() || "".equals(params.getApplyeno())){
			      //����
				CheckedapplyVO chvo = null;
				if (paramvalue) {
					chvo = checkedapply.doAddCheckedapply(checkedapplyVO, CH_CHECKED_COUNTY, CH_CHECKED_MIDCITY);
				} else {
					chvo = checkedapply.doAddCheckedapply(checkedapplyVO);
				}
				
				if (chvo.getApplyno()!=null) {
					params.setApplyeno(chvo.getApplyno().toString());
				}				
			    this.doNew();
			    this.setCMDFLAG("1");
			    setActionMessage("����ɹ�");
			}else{
			      //����
				savecmd = "1";
				// ���µ�ʱ�����»�ȡ��������
				String applytype = request.getParameter("applytype");
				checkedapplyVO.setApplytype(applytype);
				checkedapplyVO.setApplyno(Long.parseLong(params.getApplyeno()));
			    checkedapply.doUpdateCheckedapply(checkedapplyVO);
			    this.doApplydeatilinfo();
			    this.setCMDFLAG("1");
			    setActionMessage("����ɹ�");
			}
			
	} catch (Exception e) { 
		if ("0".equals(savecmd)) {
			this.doNew();
		} else {
			this.doApplydeatilinfo();
		}		
		setActionMessage(e.getMessage());
	}
		return "editlist"; 
	}
	
	//ɾ����Ȩ����������ϸ��
	public String doDelete() throws Exception{
		String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
		Checkedapplydetail checkedapplydetailBO = (Checkedapplydetail) BOFactory.build(CheckedapplydetailBO.class, getDBAccessUser()); 
		for(int i=0;i<selectArray.length;i++){
			checkedapplydetailBO.doRemoveByPK(Long.parseLong(selectArray[i]));
		}
		CheckedapplyDBParam params = (CheckedapplyDBParam) getParam();
		if(null==params.getApplyeno() || "".equals(params.getApplyeno())){
			this.doNew();
		} else {
			this.doApplydeatilinfo();
		}		
		return "editlist";
	}
	
	//�����ļ��ϴ�
	public String doDownload() throws Exception{
			try {
				HttpServletRequest request=ServletActionContext.getRequest(); 
				String url = request.getParameter("file");
				// �ļ�����������ת��
				String result = new String(url.getBytes("iso-8859-1"), "gb2312");
				url = result;
				FtpAccess ftpAccess = new FtpAccess(FtpInfo.getInstance());
				String localPath =ServletActionContext.getServletContext().getRealPath("/") ;
				System.out.println("----->localPath��" + localPath + "\n" + "----->url��" + url);
				//localPath="D:\\yl\\123";
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
	
	//ѡ����������
	public String doChooseapplyway()throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest(); 
		String applytype = request.getParameter("applytype");
		String applyeno = request.getParameter("applyeno");
		Checkedapplydetail ckdetail = (Checkedapplydetail)BOFactory.build(CheckedapplydetailBO.class, getDBAccessUser());
		CheckedapplyDBParam ckparams = (CheckedapplyDBParam) getParam();
		// �������뵥��
		if (ckparams.getApplyeno()==null)
		ckparams.setApplyeno(applyeno);
		
		WayDBParam params = new WayDBParam();
		params.set_pageno(ckparams.get_pageno());//����ҳ�뷭ҳ��
		params.set_pagesize(ckparams.get_pagesize());
		params.set_se_cityid(getDBAccessUser().getCityid());
		DataPackage dp = null; 
		if (applytype.equals("1")){  //��������Ϊ�˳�
			dp= ckdetail.doQueryWayinfoForExitway(params);
			this.setDp(dp);
		 return "applyexit";
		}else{                     //��������Ϊ׼��
			dp = ckdetail.doQueryWayinfoForapplyway(params);
			this.setDp(dp);
		 return "applyenter";
		} 
	}
	
	//��������Ϊ�˳�
	public String doQueryWayinfoForExitway()throws Exception{
		
		Checkedapplydetail ckdetail = (Checkedapplydetail)BOFactory.build(CheckedapplydetailBO.class, getDBAccessUser());
		WayDBParam params = new WayDBParam();
		CheckedapplyDBParam ckparams = (CheckedapplyDBParam) getParam();
		params.set_se_wayid(ckparams.get_sk_wayid());
		params.set_sk_wayname(ckparams.get_sk_wayname());
		params.set_pageno(ckparams.get_pageno());//����ҳ�뷭ҳ��
		params.set_pagesize(ckparams.get_pagesize());
		
		params.set_se_cityid(getDBAccessUser().getCityid());
		DataPackage dp = null; 
		dp= ckdetail.doQueryWayinfoForExitway(params);
		this.setDp(dp);
		
		return "applyexit";
	}
	
	//��������Ϊ׼��
	public String doQueryWayinfoForapplyway()throws Exception{
		
		Checkedapplydetail ckdetail = (Checkedapplydetail)BOFactory.build(CheckedapplydetailBO.class, getDBAccessUser());
		WayDBParam params = new WayDBParam();
		CheckedapplyDBParam ckparams = (CheckedapplyDBParam) getParam();
		params.set_se_wayid(ckparams.get_sk_wayid());
		params.set_sk_wayname(ckparams.get_sk_wayname());
		params.set_pageno(ckparams.get_pageno());//����ҳ�뷭ҳ��
		params.set_pagesize(ckparams.get_pagesize());
		
		params.set_se_cityid(getDBAccessUser().getCityid());
		DataPackage dp = null; 
		dp= ckdetail.doQueryWayinfoForapplyway(params);
		this.setDp(dp);
		
		return "applyenter";
	}
	
	public String doCheckchained(){
		try{
			String result = "";
			//ȡ�ù�ѡ������
			String select = ((CheckedapplyDBParam) getParam()).getSelectw();
			String[] selectArray = select.split("\\|");
			String chktype = ((CheckedapplyDBParam) getParam()).getChktype();
			
			Way way = (Way) BOFactory.build(WayBO.class, getDBAccessUser());
			if (("1").equals(chktype)){
					for (int i = 0; i < selectArray.length; i++) {
						WayVO wayVO = way.doFindByPk(selectArray[i]);
						if (wayVO == null || null == wayVO.getChainhead()|| "".equals(wayVO.getChainhead())) {
							result = "����" + selectArray[i]+ "������������û�����ã��뵽���������Ϣ����ҳ�����á�";
							break;
						}
					}					
			}
 
			super.getResponse().getWriter().write(result);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	//������Ȩ������ϸ��Ϣ
	public String doSavedetail()throws Exception{
		 try {
			Checkedapplydetail checkedapplydetailBO = (Checkedapplydetail) BOFactory.build(CheckedapplydetailBO.class, getDBAccessUser());
			String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
			// ȡ�ÿ��˷�ʽ
			String chktype = ((CheckedapplyDBParam) getParam()).getChktype();
			// ������������
			String chgtype = ((CheckedapplyDBParam) getParam()).getChgtype();
			HttpServletRequest request=ServletActionContext.getRequest(); 
			// ȡ����������
			String applytype = request.getParameter("applytype");
			// ���뵥��
			String applyno = ((CheckedapplyDBParam) getParam()).getApplyeno();
			Way way = (Way) BOFactory.build(WayBO.class, getDBAccessUser());
			CheckedapplydetailVO vo = new CheckedapplydetailVO();
			
			getSysParme();
			if (paramvalue && CH_CHECKED_COUNTY) {
				vo.setIsflag(Short.parseShort("0"));
			} else if (paramvalue && CH_CHECKED_MIDCITY) {
				vo.setIsflag(Short.parseShort("1"));
			}

			vo.setChktype(chktype);//���ÿ��˷�ʽ
			//������������Ϊǰһ��ҳ��ѡ�����������
			vo.setApplytype(applytype);
			
			for (int i = 0; i < selectArray.length; i++) {
				WayVO wayVO = way.doFindByPk(selectArray[i]);
				WayDBParam wayDBParam = new WayDBParam();
				wayDBParam.set_se_wayid(selectArray[i]);
				DataPackage dp1 = way.doQueryWaytype(wayDBParam);
				 if(("1").equals(wayVO.getIstop())){
					 vo.setWtype("1");
				 }else if(null != dp1 && dp1.getDatas().size()>0){
//					 WayVO wayvo1 = (WayVO)dp1.getDatas().get(0);
//					 if (("2").equals(wayvo1.getIstietong())){
					 vo.setWtype("2");
//					 }else{
//						 vo.setWtype("3");
//					 }
				 } else {
					 vo.setWtype("3");
				 }
				 // ���뵥��
				 if (!"".equals(applyno) && applyno != null) {
					 vo.setApplyno(Long.parseLong(applyno));
				 }
				 //����������Ϊ��ǰ��¼�˹���
				 vo.setOprcode(getDBAccessUser().getOprcode());
				 // �����������Ϊ��ǰ��¼����
				 vo.setCityid(getDBAccessUser().getCityid());
				 //������������Ϊ��ѡ����������
				 vo.setWayid(selectArray[i]);
				 //������������Ϊҳ��ѡ��ĵ�������
				 vo.setChgtype(chgtype);
				 checkedapplydetailBO.doCreate(vo); 
			}
			
		} catch (Exception e) {
			String result = this.doChooseapplyway();
			setActionMessage(e.getMessage());
			return result;
		}
		String result = this.doChooseapplyway();
		this.setCMDFLAG("1");
		setActionMessage("����ɹ�");
		return result;
	}
	
	//�����������Ͳ�ѯ���������
	public String doQueryByapplytype() throws Exception{
		HttpServletRequest request = getRequest(); 
		CheckedapplyDBParam params = (CheckedapplyDBParam) getParam(); 
		CheckedapplyDBParam checkedapplyDBParam = (CheckedapplyDBParam)request.getSession().getAttribute("NewParms");
		Checkedapplydetail checkedapplydetailBO = (Checkedapplydetail) BOFactory.build(CheckedapplydetailBO.class, getDBAccessUser());
		CheckedapplydetailDBParam param = new CheckedapplydetailDBParam();   
		String applytype = request.getParameter("applytype");
		param.set_se_oprcode(getDBAccessUser().getOprcode()); 
		param.set_se_applyno(checkedapplyDBParam.get_ne_applyno());
		param.set_se_applytype(applytype);
	    params.setCityid(checkedapplyDBParam.getCityid());
	    params.setOprcode(checkedapplyDBParam.getOprcode());
	    params.setApplytype(applytype);
	    params.setAptime(checkedapplyDBParam.getAptime());
	    
	    /*
		 * �ж��й�˾�Ƿ�������ϵͳ��������Ȩ���㼸��������̡�����ֵΪ1
		 * �жϵ�ǰ��¼�û��Ƿ�ӵ�зֹ�˾����
		 * �жϵ�ǰ��¼�û��Ƿ�ӵ���й�˾��������
		 */
		getSysParme();
	    DataPackage dp = null;
	    if (paramvalue && CH_CHECKED_COUNTY) {
			dp = checkedapplydetailBO.doQueryInfoForInsert_COUNTY(param);
		} else if (paramvalue && CH_CHECKED_MIDCITY) {
			dp = checkedapplydetailBO.doQueryInfoForInsert_MIDCITY(param);
		} else {
			dp = checkedapplydetailBO.doQueryInfoForInsert(param);
		}
        this.setDp(dp); 
		return "editlist"; 
	}
	
    /**
     * ���ļ�������ΪӢ�ĵ��ļ���
     * @param filename ԭ�ļ�����
     * @param type �ļ�����
     * @return ���ļ�����
     */
    public String changeFilename(String filename, String type){
        if (filename == null || filename.equals("")) return filename;
        int pos = filename.indexOf(".");
        if (pos < 0) return filename;
        else{
            // ���ϴ��ļ�Ϊ������ļ�ʱ
            if ("Y".equals(type)) {
            	return "APPFILE"  + filename.substring(pos);
            	
            	// ���ϴ��ļ�ΪPPT�ļ�ʱ
            } else {
            	return "PPTFILE"  + filename.substring(pos);
            }           
        }
    }	
	
	//����״̬���Ʊ�ʶ
	private String CMDFLAG;
	//����/������ʶ
	private String ADDUP;
	
	private boolean flag=true;

	public boolean getFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getAppathDocFileName() {
		return appathDocFileName;
	}
	public void setAppathDocFileName(String appathDocFileName) {
		this.appathDocFileName = appathDocFileName;
	}
	public String getAppathDocType() {
		return appathDocType;
	}
	public void setAppathDocType(String appathDocType) {
		this.appathDocType = appathDocType;
	}
	public String getPptpathDocFileName() {
		return pptpathDocFileName;
	}
	public void setPptpathDocFileName(String pptpathDocFileName) {
		this.pptpathDocFileName = pptpathDocFileName;
	}
	public String getPptpathDocType() {
		return pptpathDocType;
	}
	public void setPptpathDocType(String pptpathDocType) {
		this.pptpathDocType = pptpathDocType;
	}

	public String getCMDFLAG() {
		return CMDFLAG;
	}

	public void setCMDFLAG(String cmdflag) {
		CMDFLAG = cmdflag;
	}

	public String getADDUP() {
		return ADDUP;
	}

	public void setADDUP(String addup) {
		ADDUP = addup;
	}

	public File getAppathDoc() {
		return appathDoc;
	}

	public void setAppathDoc(File appathDoc) {
		this.appathDoc = appathDoc;
	}

	public File getPptpathDoc() {
		return pptpathDoc;
	}

	public void setPptpathDoc(File pptpathDoc) {
		this.pptpathDoc = pptpathDoc;
	}

	public boolean isCH_CHECKED_MIDCITY() {
		return CH_CHECKED_MIDCITY;
	}

	public void setCH_CHECKED_MIDCITY(boolean ch_checked_midcity) {
		CH_CHECKED_MIDCITY = ch_checked_midcity;
	}

	public boolean isParamvalue() {
		return paramvalue;
	}

	public void setParamvalue(boolean paramvalue) {
		this.paramvalue = paramvalue;
	}
}