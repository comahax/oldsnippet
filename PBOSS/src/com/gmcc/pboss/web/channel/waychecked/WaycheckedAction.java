/**
 * auto-generated code
 * Sat Jun 09 10:21:12 CST 2012
 */
 package com.gmcc.pboss.web.channel.waychecked;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.base.operator.OperatorDBParam;
import com.gmcc.pboss.business.base.operator.OperatorVO;
import com.gmcc.pboss.business.channel.checkedapply.CheckedapplyDBParam;
import com.gmcc.pboss.business.channel.checkedapply.CheckedapplyVO;
import com.gmcc.pboss.business.channel.checkedapplydetail.CheckedapplydetailDBParam;
import com.gmcc.pboss.business.channel.checkedapplydetail.CheckedapplydetailVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.common.ftp.FtpAccess;
import com.gmcc.pboss.common.ftp.FtpBusUtils;
import com.gmcc.pboss.common.ftp.FtpInfo;
import com.gmcc.pboss.control.base.operator.Operator;
import com.gmcc.pboss.control.base.operator.OperatorBO;
import com.gmcc.pboss.control.base.operright.Operright;
import com.gmcc.pboss.control.base.operright.OperrightBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.checkedapply.Checkedapply;
import com.gmcc.pboss.control.channel.checkedapply.CheckedapplyBO;
import com.gmcc.pboss.control.channel.checkedapplydetail.Checkedapplydetail;
import com.gmcc.pboss.control.channel.checkedapplydetail.CheckedapplydetailBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: CheckedapplyAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author  limin add 2012/6/13 
 * @version 1.0
 */
public class WaycheckedAction extends BaseAction{
	
	private static final Long APPSTATUS_SYSID = 83L;
	private static final String APPSTATUS_SYSTYPE = "channel";
	//�й�˾�������ơ�CH_CHECKED_MIDCITY��
	private static final String CH_CHECKED_MIDCITY ="CH_CHECKED_MIDCITY";
	
	public WaycheckedAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new WaycheckedForm());
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
	
	public String doShow() throws Exception {
		WaycheckedForm waycheckedForm = (WaycheckedForm)this.getForm();
		Sysparam sysBO = (Sysparam)BOFactory.build(SysparamBO.class, this.getDBAccessUser());
		String sysvalue = sysBO.doFindByID(APPSTATUS_SYSID, APPSTATUS_SYSTYPE);
		if(sysvalue!=null && "1".equals(sysvalue.trim())){
			//��ϵͳ����Ϊ��systemid=83, paramtype=��channel��)����ֵΪ1ʱ������״̬�̶������á�CH_APPSTATUS_GZ��
			waycheckedForm.setAPPSTATUS_MULTI(true);
		}else{
			waycheckedForm.setAPPSTATUS_MULTI(false);
		}
		
		//ӵ���й�˾���ơ�CH_CHECKED_CITY��
		Operright operright = (Operright) BOFactory.build(OperrightBO.class, DBAccessUser.getInnerUser());
		boolean CH_CHECKED_CITY = operright.doCheckPermission(this.getDBAccessUser().getOprcode(), "CH_CHECKED_CITY");
		waycheckedForm.setCH_CHECKED_CITY(CH_CHECKED_CITY);	
		//ӵ���й�˾�������ơ�CH_CHECKED_MIDCITY��
		boolean hasCH_CHECKED_MIDCITY = operright.doCheckPermission(this.getDBAccessUser().getOprcode(), CH_CHECKED_MIDCITY);
		waycheckedForm.setHasCH_CHECKED_MIDCITY(hasCH_CHECKED_MIDCITY);
		
		return "list";
	}
	
	public String doList() throws Exception {
		CheckedapplyDBParam params = (CheckedapplyDBParam) getParam(); 
		WaycheckedForm waycheckedForm = (WaycheckedForm)this.getForm();		
		Operright operright = (Operright) BOFactory.build(OperrightBO.class, DBAccessUser.getInnerUser());
		//ӵ���й�˾���ơ�CH_CHECKED_CITY��
		boolean CH_CHECKED_CITY = operright.doCheckPermission(this.getDBAccessUser().getOprcode(), "CH_CHECKED_CITY");
		waycheckedForm.setCH_CHECKED_CITY(CH_CHECKED_CITY);	
		//ӵ���й�˾�������ơ�CH_CHECKED_MIDCITY��
		boolean hasCH_CHECKED_MIDCITY = operright.doCheckPermission(this.getDBAccessUser().getOprcode(), CH_CHECKED_MIDCITY);
		waycheckedForm.setHasCH_CHECKED_MIDCITY(hasCH_CHECKED_MIDCITY);
		
		params.set_orderby("applyno");
		params.set_desc("1");
		Checkedapply checkedapplyBO = (Checkedapply) BOFactory.build(CheckedapplyBO.class, getDBAccessUser());
		DataPackage dp = new DataPackage();
		CheckedapplyDBParam paramCA = new CheckedapplyDBParam();
		paramCA.set_ne_applyno(params.get_ne_applyno());
		paramCA.set_se_applytype(params.get_se_applytype());		
		paramCA.set_se_cityid(this.getDBAccessUser().getCityid());//��¼���Ž��ܴ�����������������		
		paramCA.set_se_oprcode(params.get_se_oprcode());
		paramCA.set_dnl_aptime(params.get_dnl_aptime());
		paramCA.set_dnm_aptime(params.get_dnm_aptime());
		paramCA.set_se_status(params.get_se_status());
		
		Sysparam sysBO = (Sysparam)BOFactory.build(SysparamBO.class, this.getDBAccessUser());
		String sysvalue = sysBO.doFindByID(APPSTATUS_SYSID, APPSTATUS_SYSTYPE);
		if(sysvalue!=null && "1".equals(sysvalue.trim())){
			//��ϵͳ����Ϊ��systemid=83, paramtype=��channel��)����ֵΪ1ʱ������״̬�̶������á�CH_APPSTATUS_GZ��
			waycheckedForm.setAPPSTATUS_MULTI(true);
			if(CH_CHECKED_CITY){
				paramCA.set_sql_status(" status=0 or status=1 ");
			}else if(hasCH_CHECKED_MIDCITY){
				paramCA.set_sql_status(" status=2 or status=3 ");
				//paramCA.set_se_oprcode2(this.getDBAccessUser().getOprcode());
				paramCA.set_sql_oprcode2("oprcode2='"+this.getDBAccessUser().getOprcode()+"' or oprcode2 is null");
			}
		}else{
			waycheckedForm.setAPPSTATUS_MULTI(false);
		}	
		
		if(CH_CHECKED_CITY || (waycheckedForm.isAPPSTATUS_MULTI() && hasCH_CHECKED_MIDCITY)){//�����������Ȩ�ޣ����ܲ�ѯ
			//dp = checkedapplyBO.doQueryByNamedSqlQuery("queryCheckedapplyCity", paramCA);
			dp = checkedapplyBO.doQuery(paramCA);
		}

		this.setDp(dp);
		return "list";
	}
	
	public String doNew() throws Exception{ 
		WaycheckedForm form = new WaycheckedForm(); 
		form.setCityid(getDBAccessUser().getCityid()); 
		form.setOprcode(getDBAccessUser().getOprcode());  
	    form.setAptime(new Date()); 
		form.setApplytype("0"); 
		this.setForm(form);
		return WEB_RESULT_CONTENT; 
	}
	
	@Override
	public String doEdit() throws Exception {
		CheckedapplyDBParam checkedapplyDBParam = (CheckedapplyDBParam) getParam();
		CheckedapplydetailDBParam checkedapplydetailDBParam = new CheckedapplydetailDBParam();
		Checkedapplydetail checkedapplydetailBO = (Checkedapplydetail) BOFactory.build(CheckedapplydetailBO.class, getDBAccessUser());
		checkedapplydetailDBParam.set_ne_applyno(checkedapplyDBParam.get_pk()+"");
		checkedapplydetailDBParam.set_pagesize("0");
		DataPackage temPackage = checkedapplydetailBO.doQuery(checkedapplydetailDBParam);
		
		Way waybo = (Way) BOFactory.build(WayBO.class, getDBAccessUser());
		if(temPackage != null && temPackage.getDatas() != null && temPackage.getDatas().size() >0){
			for(Iterator<CheckedapplydetailVO> it = temPackage.getDatas().iterator();it.hasNext();){
				CheckedapplydetailVO  checkedapplydetailVO = it.next();
				WayVO wayvo = waybo.doFindByPk(checkedapplydetailVO.getWayid());
				checkedapplydetailVO.setAddress(wayvo.getAddress());
				checkedapplydetailVO.setWayname(wayvo.getWayname());
				checkedapplydetailVO.setBuztypecode(wayvo.getBuztypecode());
				checkedapplydetailVO.setStarlevel(wayvo.getStarlevel());
				checkedapplydetailVO.setChainhead(wayvo.getChainhead());
			}	
		}
		BaseVO vo = findVOFromDB();
		BaseVO form = getForm(); 
		BeanUtils.copyProperties(form, vo);
		
		Operator operatorBO = (Operator) BOFactory.build(OperatorBO.class, getDBAccessUser());
		OperatorDBParam operatorDBParam = new OperatorDBParam();
		operatorDBParam.set_se_operid(((CheckedapplyVO)vo).getOprcode());
		DataPackage tmpDP = operatorBO.doQuery(operatorDBParam);
		if(tmpDP != null && tmpDP.getDatas() != null && tmpDP.getDatas().size() >0){
			OperatorVO operatoreVO = (OperatorVO)tmpDP.getDatas().get(0);
			((WaycheckedForm)form).setOprname(operatoreVO.getOpername());
		}
		
		//������״̬Ϊ1������ˣ���3���й�˾�ѳ��󣩸�ѡ���ύ��ť�����á�
		//��֮����״̬Ϊ0������ˣ���2�����й�˾���󣩸�ѡ���ύ��ť���á�
		String status = ((WaycheckedForm)form).getStatus();
		if("0".equals(status) || "2".equals(status)){
			((WaycheckedForm)form).setCbFlag(true);//����
		}else{
			((WaycheckedForm)form).setCbFlag(false);
		}
		
		Sysparam sysBO = (Sysparam)BOFactory.build(SysparamBO.class, this.getDBAccessUser());
		String sysvalue = sysBO.doFindByID(APPSTATUS_SYSID, APPSTATUS_SYSTYPE);
		if(sysvalue!=null && "1".equals(sysvalue.trim())){
			//��ϵͳ����Ϊ��systemid=83, paramtype=��channel��)����ֵΪ1ʱ������״̬�̶������á�CH_APPSTATUS_GZ��
			((WaycheckedForm)form).setAPPSTATUS_MULTI(true);
		}else{
			((WaycheckedForm)form).setAPPSTATUS_MULTI(false);
		}
		
		setForm(form);
		setDp(temPackage);
		this.CMD = WEB_CMD_EDIT;
		return WEB_RESULT_CONTENT;
	}
	
	//�����Ƿ�����й�˾���Ȩ��
	private boolean hasCityPermit() throws Exception{
		Operright operright = (Operright) BOFactory.build(OperrightBO.class, DBAccessUser.getInnerUser());
		//ӵ���й�˾���ơ�CH_CHECKED_CITY��
		boolean CH_CHECKED_CITY = operright.doCheckPermission(this.getDBAccessUser().getOprcode(), "CH_CHECKED_CITY");
		return CH_CHECKED_CITY;
	}
	
	//�����Ƿ���ڳ����˲��������ҵ�ǰ���ž��г���Ȩ��
	private boolean hasMidcityPermit() throws Exception{
		Operright operright = (Operright) BOFactory.build(OperrightBO.class, DBAccessUser.getInnerUser());
		//���й�˾������ϵͳ��������Ȩ���㼸���������(systemid=83, paramtype=��channel��)����ֵΪ1ʱ�������м������
		Sysparam sysBO = (Sysparam)BOFactory.build(SysparamBO.class, this.getDBAccessUser());
		String sysvalue = sysBO.doFindByID(APPSTATUS_SYSID, APPSTATUS_SYSTYPE);
		boolean hasMid = false;//�����Ƿ����м������
		boolean hasCH_CHECKED_MIDCITY = false;//�Ƿ�����м����Ȩ��
		if(sysvalue!=null && "1".equals(sysvalue)){//�����м������
			hasMid = true;
			//ӵ���й�˾�������ơ�CH_CHECKED_MIDCITY��
			hasCH_CHECKED_MIDCITY = operright.doCheckPermission(this.getDBAccessUser().getOprcode(), CH_CHECKED_MIDCITY);
		}			
		return (hasMid && hasCH_CHECKED_MIDCITY);
	}
	
	//�й�˾����׼�����봦���߼�
	private void doEnterCityPermit(CheckedapplyVO checkedapplyVO,Checkedapply checkedapplyBO,Checkedapplydetail checkedapplydetailBO,
			Way waybo,WaycheckedForm form,Map<String, String> seqMap,DataPackage temPackage)throws Exception{
		// ������Ȩ��������������״̬Ϊ1(�����)
		checkedapplyVO.setStatus("1");
		checkedapplyVO.setChkmemo(form.getChkmemo());
		checkedapplyBO.doUpdate(checkedapplyVO);
		// ������ϸ�б����������������Ӧ�������Ƿ���Ȩ���㣨checked��ΪY
		for (Iterator<CheckedapplydetailVO> it = temPackage.getDatas().iterator(); it.hasNext();) {
			CheckedapplydetailVO checkedapplydetailVO = it.next();
			if (seqMap.containsKey(""+ checkedapplydetailVO.getSeq())) {// ѡ��
				String wayid = checkedapplydetailVO.getWayid();
				WayVO wayvo = waybo.doFindByPk(wayid);
				wayvo.setChecked("Y");
				waybo.doUpdateNotCon(wayvo);
				
				checkedapplydetailVO.setWaystatus(Short.parseShort("0"));
			}else {
				checkedapplydetailVO.setWaystatus(Short.parseShort("1"));
			}						
			checkedapplydetailVO.setOprtime(new Date());
			checkedapplydetailBO.doUpdate(checkedapplydetailVO);
		}	
	}
	//����������׼�����봦���߼�
	private void doEnterMidPermit(CheckedapplyVO checkedapplyVO,Checkedapply checkedapplyBO,Checkedapplydetail checkedapplydetailBO,
			WaycheckedForm form,Map<String, String> seqMap,DataPackage temPackage) throws Exception{
		//���������˳�����[channel:83]ϵͳ�������ҵ�ǰ���ž��г�������Ȩ��CH_CHECKED_MIDCITY
		//������Ȩ��������������״̬Ϊ3(�й�˾�ѳ���)
		checkedapplyVO.setStatus("3");
		checkedapplyVO.setChkmemo(form.getChkmemo());
		checkedapplyBO.doUpdate(checkedapplyVO);
		// ������ϸ�б�
		for (Iterator<CheckedapplydetailVO> it = temPackage.getDatas().iterator(); it.hasNext();) {
			CheckedapplydetailVO checkedapplydetailVO = it.next();
			if (seqMap.containsKey(""+ checkedapplydetailVO.getSeq())) {// ѡ��							
				checkedapplydetailVO.setWaystatus(Short.parseShort("2"));//�������״̬Ϊ2���й�˾����ͨ����
			}else {
				checkedapplydetailVO.setWaystatus(Short.parseShort("3"));//�������״̬Ϊ3���й�˾����ͨ����
			}						
			checkedapplydetailVO.setOprtime(new Date());
			checkedapplydetailBO.doUpdate(checkedapplydetailVO);
		}
	
	}
	//�й�˾�����˳����봦���߼�
	private void doResignCityPermit(CheckedapplyVO checkedapplyVO,Checkedapply checkedapplyBO,Checkedapplydetail checkedapplydetailBO,
			Way waybo,WaycheckedForm form,Map<String, String> seqMap,DataPackage temPackage)throws Exception{
		//CH_CHECKED_CITY
		// ������Ȩ��������������״̬Ϊ1(�����)
		checkedapplyVO.setStatus("1");
		checkedapplyVO.setChkmemo(form.getChkmemo());
		checkedapplyBO.doUpdate(checkedapplyVO);
		// ������ϸ�б�
		if (temPackage != null && temPackage.getDatas() != null	&& temPackage.getDatas().size() > 0) {
			for (Iterator<CheckedapplydetailVO> it = temPackage.getDatas().iterator(); it.hasNext();) {
				CheckedapplydetailVO checkedapplydetailVO = it.next();
				if (seqMap.containsKey(""+ checkedapplydetailVO.getSeq())) {// ѡ��
					String chgtype = checkedapplydetailVO.getChgtype();// ��������
					// �������� 0 �˳�����  �������� 1 �ӻ��˳�
					if ("0".equals(chgtype)) {
						// ������ϸ�б����������������Ӧ�������Ƿ���Ȩ���㣨checked��ΪN
						String wayid = checkedapplydetailVO.getWayid();
						WayVO wayvo = waybo.doFindByPk(wayid);
						wayvo.setChecked("N");
						waybo.doUpdateNotCon(wayvo);
					}
					// ����CH_PW_CHECKEDAPPLYDETAIL����Ȩ����������ϸ���в���ʱ��Ϊ��ǰ����ʱ�䡢�������״̬Ϊ0���й�˾���ͨ����
					checkedapplydetailVO.setWaystatus(Short.parseShort("0"));
				} else {// δѡ��
					checkedapplydetailVO.setWaystatus(Short.parseShort("1"));
				}
				checkedapplydetailVO.setOprtime(new Date());
				checkedapplydetailBO.doUpdate(checkedapplydetailVO);
			}
		}	
	}
	//�����������˳����봦���߼�
	private void doResignMidPermit(CheckedapplyVO checkedapplyVO,Checkedapply checkedapplyBO,Checkedapplydetail checkedapplydetailBO,
			WaycheckedForm form,Map<String, String> seqMap,DataPackage temPackage)throws Exception{
		//���������˳�����[channel:83]ϵͳ�������ҵ�ǰ���ž��г�������Ȩ��CH_CHECKED_MIDCITY
		// ������Ȩ��������������״̬Ϊ3(�й�˾�ѳ���)
		checkedapplyVO.setStatus("3");
		checkedapplyVO.setChkmemo(form.getChkmemo());
		checkedapplyBO.doUpdate(checkedapplyVO);
		// ������ϸ�б�
		if (temPackage != null && temPackage.getDatas() != null	&& temPackage.getDatas().size() > 0) {
			for (Iterator<CheckedapplydetailVO> it = temPackage.getDatas().iterator(); it.hasNext();) {
				CheckedapplydetailVO checkedapplydetailVO = it.next();
				if (seqMap.containsKey(""+ checkedapplydetailVO.getSeq())) {// ѡ��					
					checkedapplydetailVO.setWaystatus(Short.parseShort("2"));//�������״̬Ϊ2���й�˾ ����ͨ����
				} else {// δѡ��								
					checkedapplydetailVO.setWaystatus(Short.parseShort("3"));//�������״̬Ϊ3���й�˾����ͨ����
				}
				checkedapplydetailVO.setOprtime(new Date());
				checkedapplydetailBO.doUpdate(checkedapplydetailVO);
			}
		}	
	}
	
	public String doSave() throws Exception {
		try {
			Checkedapplydetail checkedapplydetailBO = (Checkedapplydetail) BOFactory.build(CheckedapplydetailBO.class, getDBAccessUser());
			Way waybo = (Way) BOFactory.build(WayBO.class, getDBAccessUser());
			Checkedapply checkedapplyBO = (Checkedapply) BOFactory.build(CheckedapplyBO.class, getDBAccessUser());

			WaycheckedForm form = (WaycheckedForm) getForm();
			String status = form.getStatus();
			Long applyno = form.getApplyno();
			String applytype = form.getApplytype();
			
			// ѡ�еļ�¼����¼seq
			DBQueryParam dbParam = this.getParam();
			String seqs[] = dbParam.get_selectitem();			
			Map<String, String> seqMap = new HashMap<String, String>();
			if (seqs != null && !"".equals(seqs) && seqs.length > 0) {
				for (int i = 0; i < seqs.length; i++) {
					if (!seqMap.containsKey(seqs[i])) {
						seqMap.put(seqs[i], seqs[i]);
					}
				}
			}		
			
			CheckedapplydetailDBParam checkedapplydetailDBParam = new CheckedapplydetailDBParam();
			checkedapplydetailDBParam.set_ne_applyno(applyno + "");
			checkedapplydetailDBParam.set_pagesize("0");
			DataPackage temPackage = checkedapplydetailBO.doQuery(checkedapplydetailDBParam);

			CheckedapplyVO checkedapplyVO = checkedapplyBO.doFindByPk(applyno);
			if (status == null || "".equals(status)) {
				// ҳ�浥ѡ��ťΪ������ʱ��������action����Ҫ����ȡ
				status = checkedapplyVO.getStatus();
			}

			checkedapplyVO.setOprcode2(this.getDBAccessUser().getOprcode());

			if (applytype != null && "0".equals(applytype)) {
				// ��ѡ�����ͨ��(Ĭ��ͨ��)������������Ϊ׼�������ʱ��
				// applytype=0��׼������  applytype=1���˳�����
				if (this.hasCityPermit()) {//CH_CHECKED_CITY
					this.doEnterCityPermit(checkedapplyVO, checkedapplyBO, checkedapplydetailBO, waybo, form, seqMap, temPackage);
				}
				if(this.hasMidcityPermit()){//���������˳�����[channel:83]ϵͳ�������ҵ�ǰ���ž��г�������Ȩ��CH_CHECKED_MIDCITY
					this.doEnterMidPermit(checkedapplyVO, checkedapplyBO, checkedapplydetailBO, form, seqMap, temPackage);
				}
			} else if (applytype != null && "1".equals(applytype)) {
				// ��ѡ�����ͨ��(Ĭ��ͨ��)������������Ϊ�˳������ʱ��
				// applytype=0��׼������   applytype=1���˳�����
				if (this.hasCityPermit()) {//CH_CHECKED_CITY
					this.doResignCityPermit(checkedapplyVO, checkedapplyBO, checkedapplydetailBO, waybo, form, seqMap, temPackage);
				}
				if(this.hasMidcityPermit()){//���������˳�����[channel:83]ϵͳ�������ҵ�ǰ���ž��г�������Ȩ��CH_CHECKED_MIDCITY
					this.doResignMidPermit(checkedapplyVO, checkedapplyBO, checkedapplydetailBO, form, seqMap, temPackage);
				}
			}
			
			//�������������ϸ��Ϣ
			for(Iterator<CheckedapplydetailVO> ite = temPackage.getDatas().iterator();ite.hasNext();){
				CheckedapplydetailVO  checkedapplydetailVO = ite.next();
				WayVO wayvo = waybo.doFindByPk(checkedapplydetailVO.getWayid());
				checkedapplydetailVO.setAddress(wayvo.getAddress());
				checkedapplydetailVO.setWayname(wayvo.getWayname());
				checkedapplydetailVO.setBuztypecode(wayvo.getBuztypecode());
				checkedapplydetailVO.setStarlevel(wayvo.getStarlevel());
				checkedapplydetailVO.setChainhead(wayvo.getChainhead());
			}

			this.setCMD(WEB_CMD_SAVE);
			this.getParam().set_pk(applyno + "");
			BaseVO vo = findVOFromDB();
			BeanUtils.copyProperties(form, vo);
			setForm(form);
			setDp(temPackage);
			this.setActionMessage("�����ɹ�!");
		} catch (Exception e) {
			this.setCMD(WEB_CMD_EDIT);
			setActionMessage(e.getMessage());
		}
		return WEB_RESULT_CONTENT;
	}
	
	
	public String doDownload() throws Exception{
		try {
			HttpServletRequest request=ServletActionContext.getRequest(); 
			String url = request.getParameter("file");
			FtpAccess ftpAccess = new FtpAccess(FtpInfo.getInstance());
			String localPath =ServletActionContext.getServletContext().getRealPath("/") ;
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
	
}