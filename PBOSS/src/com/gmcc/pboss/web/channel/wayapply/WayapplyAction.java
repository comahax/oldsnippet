/**
 * auto-generated code
 * Wed Oct 28 16:03:21 CST 2009
 */
package com.gmcc.pboss.web.channel.wayapply;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.ajaxanywhere.AAUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.base.operrole.OperroleVO;
import com.gmcc.pboss.business.base.sysparam.SysparamVO;
import com.gmcc.pboss.business.channel.auditwork.AuditworkVO;
import com.gmcc.pboss.business.channel.bchcontact.BchcontactVO;
import com.gmcc.pboss.business.channel.cooperator.CooperatorVO;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.channel.flowname.FlownameVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountVO;
import com.gmcc.pboss.business.channel.wayapply.AGWayapplyVO;
import com.gmcc.pboss.business.channel.wayapply.WayapplyDBParam;
import com.gmcc.pboss.business.channel.wayapply.WayapplyVO;
import com.gmcc.pboss.business.channel.waycompact.WaycompactVO;
import com.gmcc.pboss.control.base.operrole.Operrole;
import com.gmcc.pboss.control.base.operrole.OperroleBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.auditwork.Auditwork;
import com.gmcc.pboss.control.channel.auditwork.AuditworkBO;
import com.gmcc.pboss.control.channel.bchcontact.Bchcontact;
import com.gmcc.pboss.control.channel.bchcontact.BchcontactBO;
import com.gmcc.pboss.control.channel.cooperator.Cooperator;
import com.gmcc.pboss.control.channel.cooperator.CooperatorBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.channel.wayaccount.Wayaccount;
import com.gmcc.pboss.control.channel.wayaccount.WayaccountBO;
import com.gmcc.pboss.control.channel.wayapply.Wayapply;
import com.gmcc.pboss.control.channel.wayapply.WayapplyBO;
import com.gmcc.pboss.control.channel.waycompact.Waycompact;
import com.gmcc.pboss.control.channel.waycompact.WaycompactBO;
import com.gmcc.pboss.web.base.operrole.OperroleWebParam;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>
 * Title: WayapplyAction
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
 * @author Jerimy
 * @version 1.0
 */
public class WayapplyAction extends BaseAction {
	private static final String SAVETYPE_SAVE = "SAVE";
	private static final String SAVETYPE_CANCEL = "CANCEL";
	private static final String SAVETYPE_PASS = "PASS";
	private String saveType;
	private String formType;// ��������ĸ�ҳ����� ���Ӵ����������ʱ��ADVINFO�� ����ͨ����رմ���
	private Long rvcobjid;// ���ն�����ʶ

	public Long getRvcobjid() {
		return rvcobjid;
	}

	public void setRvcobjid(Long rvcobjid) {
		this.rvcobjid = rvcobjid;
	}

	public WayapplyAction() {
		super();

		// ���¼��������Ǳ����
		this.setForm(new WayapplyForm());
		this.setParam(new WayapplyWebParam());

		// ָ��VO��
		setClsVO(WayapplyVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[] { "applyno" };
		this.setClsControl(Wayapply.class);
		this.setClsQueryParam(WayapplyDBParam.class);

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	/**
	 * ��дdoEdit����������SEQIDȡ��CH_PW_AUDITWORK���е�ֵ
	 */
	public String doEdit() throws Exception {
		String rescontent = null;
		try{
		WayapplyForm frm = (WayapplyForm) getForm();
		WayapplyVO vo = (WayapplyVO) findVOFromDB();
		// ���ݵ��� ��SeqID����ѯ������ (CH_PW_AUDITWORK)�Ĵ������ݣ����״̬������ѯ������ǵ������Ӧ�ֶ�
		Auditwork auditwork = (Auditwork) BOFactory.build(
				AuditworkBO.class, super.getDBAccessUser());
		AuditworkVO auditworkVO = auditwork.doFindByPk(frm.getSeqid());
		
		String worktype = auditworkVO == null ? null : auditworkVO.getWorktype();
		vo.setAuditstatus_work(auditworkVO.getAuditstatus());
		vo.setSeqid(frm.getSeqid());
		vo.setWorktype(worktype);
		WayapplyVO wayapplyVO = new WayapplyVO();
		if (!"1".equals(vo.getComefrom())) {//add by yangdaren
		if ("WAY_UPDATE_AUDIT".equals(worktype)
				|| "WAY_REMOVE_AUDIT".equals(worktype)) {
			/*  ��ѯ��½�Ĺ����Ƿ�������������ɫ����*/
			vo.setHasRight(doGetPurview());
			// ȡ������Ϣ
			Way way = (Way) BOFactory.build(WayBO.class, super
					.getDBAccessUser());
			WayVO wayVO = way.doFindByPk(vo.getWayid());
			BeanUtils.copyProperties(wayapplyVO, wayVO);
			// ȡ������ϵ����
			Bchcontact bchcontact = (BchcontactBO) BOFactory.build(
					BchcontactBO.class, super.getDBAccessUser());
			BchcontactVO bchcontactVO = bchcontact.doFindByPk(vo.getWayid());
			if (null != bchcontactVO)
				BeanUtils.copyProperties(wayapplyVO, bchcontactVO);
			// ��ͬЭ������
			Waycompact waycompact = (Waycompact) BOFactory.build(
					WaycompactBO.class, super.getDBAccessUser());
			WaycompactVO waycompactVO = waycompact.doFindByPk(vo.getWayid());
			if (null != waycompactVO)
				BeanUtils.copyProperties(wayapplyVO, waycompactVO);
			// ȡ�ʻ���Ϣ
			Wayaccount wayaccount = (WayaccountBO) BOFactory.build(
					WayaccountBO.class, super.getDBAccessUser());
			WayaccountVO wayaccountVO = new WayaccountVO();
			wayaccountVO.setAccid(new Integer(0));// �������ʻ���ACCIDΪ0
			wayaccountVO.setWayid(vo.getWayid());
			wayaccountVO = wayaccount.doFindByPk(wayaccountVO);
			if (null != wayaccountVO) {
				BeanUtils.copyProperties(wayapplyVO, wayaccountVO);
			}
			// ȡ�õ�������
			Employee employee = (EmployeeBO) BOFactory.build(EmployeeBO.class,
					super.getDBAccessUser());
			EmployeeDBParam employeeParam = new EmployeeDBParam();
			employeeParam.set_ne_isnet("1");// ����
			employeeParam.set_ne_empstatus("0");// �ڸ�
			employeeParam.set_se_wayid(vo.getWayid());
			DataPackage employeeDP = employee.doQuery(employeeParam);
			if (null != employeeDP && null != employeeDP.getDatas()
					&& !employeeDP.getDatas().isEmpty()) {
				EmployeeVO employeeVO = (EmployeeVO) employeeDP.getDatas()
						.iterator().next();
				wayapplyVO.setOfficetel(employeeVO.getOfficetel());
			}
			//ȡ��������Ϣ
			Cooperator cop = (Cooperator) BOFactory.build(CooperatorBO.class, super.getDBAccessUser());
			if(vo.getWayid()!=null)
			{
				CooperatorVO copVO=(CooperatorVO)cop.doFindByPk(vo.getWayid());
				if(copVO!=null)
				{
					BeanUtils.copyProperties(wayapplyVO, copVO);
				}
			}
			// ���ݵ��� ��SeqID����ѯ������ (CH_PW_AUDITWORK)�Ĵ������ݣ����״̬������ѯ������ǵ������Ӧ�ֶ�
//			Auditwork auditwork = (Auditwork) BOFactory.build(
//					AuditworkBO.class, super.getDBAccessUser());
//			AuditworkVO auditworkVO = auditwork.doFindByPk(vo.getSeqid());
//			if (null != auditworkVO) {
				// BeanUtils.copyProperties(wayapplyVO, auditworkVO);
				wayapplyVO.setContent(auditworkVO.getContent());
				wayapplyVO.setAuditstatus(auditworkVO.getAuditstatus());
//			}
		}
		}//add by yangdaren
		// ��������ID ��APPLYNO����ѯ����������Ϣ��(CH_PW_WAYAPPLY)������ѯ������ǵ������Ӧ�ֶΡ�
//		BeanUtils.copyProperties(wayapplyVO, vo);
		if(auditworkVO!=null && auditworkVO.getStepid()!=null)
		{
			vo.setLastStepid(auditworkVO.getStepid().substring(auditworkVO.getStepid().length()-1));
		}
		
		String stepid = auditworkVO == null ? null : auditworkVO.getStepid();
		//��½������Ȩ����������Ĭ��ֵ,����ԭ���̸�Ĭ��ֵ
		if (stepid != null ) {
			Wayapply wayapply = (Wayapply) BOFactory.build(WayapplyBO.class, getDBAccessUser());
			FlownameVO flowVO = (FlownameVO) wayapply.doGetstepvo(stepid);
			if (flowVO != null && !"-1".equals(flowVO.getNextstepid())) {
				FlownameVO nextVO = (FlownameVO) wayapply.doGetstepvo(flowVO
						.getNextstepid());
				if (nextVO != null && nextVO.getOprcode() != null) {
					if(!"1".equals(vo.getHasRight())){
					vo.setOprcode(nextVO.getOprcode());
					}
				}
			} else if (flowVO != null && "-1".equals(flowVO.getNextstepid())){
				vo.setOprcode("-1");
			}

		}
		com.sunrise.jop.common.utils.bean.BeanUtils.copyProperties(wayapplyVO, vo, false);
		
		setForm(wayapplyVO);
		// Auditwork auditwork = (Auditwork) BOFactory.build(AuditworkBO.class,
		// getDBAccessUser());
		this.CMD = WEB_CMD_EDIT;
		
		// ���Ȩ������
		Sysparam sysparam = (Sysparam)BOFactory.build(SysparamBO.class, getDBAccessUser());
		String paramvalue = sysparam.doFindByID(new Long("77"), "channel");
		// ���paramvalue�鵽��¼����ֵΪ1������Ҫ���µĹ̶�������ʾ����ID������
		AGWayapplyVO appvo = new AGWayapplyVO();
		if ("1".equals(paramvalue)) {
			if ("WAY_UPDATE_AUDIT".equals(worktype)
					|| "WAY_REMOVE_AUDIT".equals(worktype)) {
				Way way = (Way)BOFactory.build(WayBO.class, getDBAccessUser());
				WayapplyVO appvo1 = way.doGetsaleeidt(wayapplyVO.getWayid(),getDBAccessUser());
				appvo = comparevo(wayapplyVO,appvo1);
			}
		}
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().setAttribute("wayapp", appvo);
		
		// �ж���ʾ�����ĸ�ҳ��
		if ("1".equals(paramvalue)) {
			if ("1".equals(vo.getComefrom())) {
				if ("DIS".equals(vo.getWaysubtype())) {
					rescontent = "discontent";
				} else {
					rescontent = "salecontent";
				}
			} else {
				rescontent = WEB_RESULT_CONTENT;
			}
		} else {
			rescontent = WEB_RESULT_CONTENT;
		}
		}catch(Exception ex)
		{
			addActionError(ex.getMessage());
			return rescontent;
		}
		return rescontent;//WEB_RESULT_CONTENT;
	};
	
	/**
	 * �䶯�Ƚ�Ȼ�������
	 * @param srcvo
	 * @param desvo
	 * @return
	 * @throws Exception
	 */
	public AGWayapplyVO comparevo(WayapplyVO srcvo, WayapplyVO desvo) throws Exception {
		AGWayapplyVO applyvo = new AGWayapplyVO();
		// ���㷽��ı䶯
		if (strcompare(srcvo.getWayid(),desvo.getWayid())) {
			applyvo.setWayid("�б䶯");
		}
		if (strcompare(srcvo.getWayname(),desvo.getWayname())) {
			applyvo.setWayname("�б䶯");
		}
		if (strcompare(srcvo.getStarlevel(),desvo.getStarlevel())) {
			applyvo.setStarlevel("�б䶯");
		}
		if (strcompare(srcvo.getPt(),desvo.getPt())) {
			applyvo.setPt("�б䶯");
		}
		if (strcompare(srcvo.getWaymagcode(),desvo.getWaymagcode())) {
			applyvo.setWaymagcode("�б䶯");
		}
		if (strcompare(srcvo.getIsstraitprd(),desvo.getIsstraitprd())) {
			applyvo.setIsstraitprd("�б䶯");
		}
		if (strcompare(srcvo.getIsstraitprd(),desvo.getIsstraitprd())) {
			applyvo.setIsstraitprd("�б䶯");
		}
		if (strcompare(srcvo.getUpperwayid(),desvo.getUpperwayid())) {
			applyvo.setUpperwayid("�б䶯");
		}
		if (strcompare(srcvo.getAdacode(),desvo.getAdacode())) {
			applyvo.setAdacode("�б䶯");
		}
		if (strcompare(srcvo.getCatetype(),desvo.getCatetype())) {
			applyvo.setCatetype("�б䶯");
		}
		if (strcompare(srcvo.getWaysubtype(),desvo.getWaysubtype())) {
			applyvo.setWaysubtype("�б䶯");
		}
		if (strcompare(srcvo.getWaysubtype(),desvo.getWaysubtype())) {
			applyvo.setWaysubtype("�б䶯");
		}
		if (strcompare(srcvo.getFormtype(),desvo.getFormtype())) {
			applyvo.setFormtype("�б䶯");
		}
		if (strcompare(srcvo.getStarttime(),desvo.getStarttime())) {
			applyvo.setStarttime("�б䶯");
		}
		if (strcompare(srcvo.getCityid(),desvo.getCityid())) {
			applyvo.setCityid("�б䶯");
		}
		if (strcompare(srcvo.getCountyid(),desvo.getCountyid())) {
			applyvo.setCountyid("�б䶯");
		}
		if (strcompare(srcvo.getSvccode(),desvo.getSvccode())) {
			applyvo.setSvccode("�б䶯");
		}
		if (strcompare(srcvo.getMareacode(),desvo.getMareacode())) {
			applyvo.setMareacode("�б䶯");
		}
		if (strcompare(srcvo.getBchlevel(),desvo.getBchlevel())) {
			applyvo.setBchlevel("�б䶯");
		}
		if (strcompare(srcvo.getBuzarea(),desvo.getBuzarea())) {
			applyvo.setBuzarea("�б䶯");
		}
		if (strcompare(srcvo.getWaystate(),desvo.getWaystate())) {
			applyvo.setWaystate("�б䶯");
		}
		if (strcompare(srcvo.getLogiscode(),desvo.getLogiscode())) {
			applyvo.setLogiscode("�б䶯");
		}
		if (strcompare(srcvo.getAlarmbizamount(),desvo.getAlarmbizamount())) {
			applyvo.setAlarmbizamount("�б䶯");
		}
		if (strcompare(srcvo.getOfficetel(),desvo.getOfficetel())) {
			applyvo.setOfficetel("�б䶯");
		}
		if (strcompare(srcvo.getAddress(),desvo.getAddress())) {
			applyvo.setAddress("�б䶯");
		}
		if (strcompare(srcvo.getLatitude(),desvo.getLatitude())) {
			applyvo.setLatitude("�б䶯");
		}
		if (strcompare(srcvo.getLongtitude(),desvo.getLongtitude())) {
			applyvo.setLongtitude("�б䶯");
		}
		if (strcompare(srcvo.getAdtypecode(),desvo.getAdtypecode())) {
			applyvo.setAdtypecode("�б䶯");
		}
		if (strcompare(srcvo.getSignstatus(),desvo.getSignstatus())) {
			applyvo.setSignstatus("�б䶯");
		}
		if (strcompare(srcvo.getProvcode(),desvo.getProvcode())) {
			applyvo.setProvcode("�б䶯");
		}
		if (strcompare(srcvo.getChainhead(),desvo.getChainhead())) {
			applyvo.setChainhead("�б䶯");
		}
		if (strcompare(srcvo.getCusttype(),desvo.getCusttype())) {
			applyvo.setCusttype("�б䶯");
		}
		if (strcompare(srcvo.getBuztypecode(),desvo.getBuztypecode())) {
			applyvo.setBuztypecode("�б䶯");
		}
		if (strcompare(srcvo.getIstietong(),desvo.getIstietong())) {
			applyvo.setIstietong("�б䶯");
		}
		if (strcompare(srcvo.getConnecttype(),desvo.getConnecttype())) {
			applyvo.setConnecttype("�б䶯");
		}
		if (strcompare(srcvo.getSublayer(),desvo.getSublayer())) {
			applyvo.setSublayer("�б䶯");
		}
		if (strcompare(srcvo.getRegid(),desvo.getRegid())) {
			applyvo.setRegid("�б䶯");
		}
		if (strcompare(srcvo.getChecked(),desvo.getChecked())) {
			applyvo.setChecked("�б䶯");
		}
		if (strcompare(srcvo.getPrincipal(),desvo.getPrincipal())) {
			applyvo.setPrincipal("�б䶯");
		}
		if (strcompare(srcvo.getPrincipaltel(),desvo.getPrincipaltel())) {
			applyvo.setPrincipaltel("�б䶯");
		}
		if (strcompare(srcvo.getPrincipalphone(),desvo.getPrincipalphone())) {
			applyvo.setPrincipalphone("�б䶯");
		}
		if (strcompare(srcvo.getPrincipalemail(),desvo.getPrincipalemail())) {
			applyvo.setPrincipalemail("�б䶯");
		}
		if (strcompare(srcvo.getSmsmobileno(),desvo.getSmsmobileno())) {
			applyvo.setSmsmobileno("�б䶯");
		}
		if (strcompare(srcvo.getRecpers(),desvo.getRecpers())) {
			applyvo.setRecpers("�б䶯");
		}
		if (strcompare(srcvo.getRecconntel(),desvo.getRecconntel())) {
			applyvo.setRecconntel("�б䶯");
		}
		if (strcompare(srcvo.getReccertno(),desvo.getReccertno())) {
			applyvo.setReccertno("�б䶯");
		}
		if (strcompare(srcvo.getBailtype(),desvo.getBailtype())) {
			applyvo.setBailtype("�б䶯");
		}
		if (strcompare(srcvo.getServbound(),desvo.getServbound())) {
			applyvo.setServbound("�б䶯");
		}
		if (strcompare(srcvo.getSendaddr(),desvo.getSendaddr())) {
			applyvo.setSendaddr("�б䶯");
		}
		if (strcompare(srcvo.getAccttype(),desvo.getAccttype())) {
			applyvo.setAccttype("�б䶯");
		}
		if (strcompare(srcvo.getCompactno(),desvo.getCompactno())) {
			applyvo.setCompactno("�б䶯");
		}
		if (strcompare(srcvo.getIsb2m(),desvo.getIsb2m())) {
			applyvo.setIsb2m("�б䶯");
		}
		if (strcompare(srcvo.getCompactname(),desvo.getCompactname())) {
			applyvo.setCompactname("�б䶯");
		}
		if (strcompare(srcvo.getBegintime(),desvo.getBegintime())) {
			applyvo.setBegintime("�б䶯");
		}
		if (strcompare(srcvo.getEndtime(),desvo.getEndtime())) {
			applyvo.setEndtime("�б䶯");
		}
		if (strcompare(srcvo.getSigntime(),desvo.getSigntime())) {
			applyvo.setSigntime("�б䶯");
		}
		if (strcompare(srcvo.getCompacttype(),desvo.getCompacttype())) {
			applyvo.setCompacttype("�б䶯");
		}
		if (strcompare(srcvo.getLicenceno(),desvo.getLicenceno())) {
			applyvo.setLicenceno("�б䶯");
		}
		if (strcompare(srcvo.getBail(),desvo.getBail())) {
			applyvo.setBail("�б䶯");
		}
		if (strcompare(srcvo.getBaillwrlmt(),desvo.getBaillwrlmt())) {
			applyvo.setBaillwrlmt("�б䶯");
		}
		if (strcompare(srcvo.getLicvalidate(),desvo.getLicvalidate())) {
			applyvo.setLicvalidate("�б䶯");
		}
		if (strcompare(srcvo.getBailstatus(),desvo.getBailstatus())) {
			applyvo.setBailstatus("�б䶯");
		}
		if (strcompare(srcvo.getIsunpb(),desvo.getIsunpb())) {
			applyvo.setIsunpb("�б䶯");
		}
		if (strcompare(srcvo.getAcctno(),desvo.getAcctno())) {
			applyvo.setAcctno("�б䶯");
		}
		if (strcompare(srcvo.getAcctname(),desvo.getAcctname())) {
			applyvo.setAcctname("�б䶯");
		}
		if (strcompare(srcvo.getBankname(),desvo.getBankname())) {
			applyvo.setBankname("�б䶯");
		}
		if (strcompare(srcvo.getAcctfid(),desvo.getAcctfid())) {
			applyvo.setAcctfid("�б䶯");
		}
		if (strcompare(srcvo.getDebankid(),desvo.getDebankid())) {
			applyvo.setDebankid("�б䶯");
		}
		if (strcompare(srcvo.getDestate(),desvo.getDestate())) {
			applyvo.setDestate("�б䶯");
		}
		if (strcompare(srcvo.getDeacctno(),desvo.getDeacctno())) {
			applyvo.setDeacctno("�б䶯");
		}
		if (strcompare(srcvo.getDeacctname(),desvo.getDeacctname())) {
			applyvo.setDeacctname("�б䶯");
		}
		if (strcompare(srcvo.getDebankname(),desvo.getDebankname())) {
			applyvo.setDebankname("�б䶯");
		}
		if (strcompare(srcvo.getIntime(),desvo.getIntime())) {
			applyvo.setIntime("�б䶯");
		}
		if (strcompare(srcvo.getIsKzcz(),desvo.getIsKzcz())) {
			applyvo.setIskzcz("�б䶯");
		}
		if (strcompare(srcvo.getStarlev(),desvo.getStarlev())) {
			applyvo.setStarlev("�б䶯");
		}
		if (strcompare(srcvo.getUniquewayid(),desvo.getUniquewayid())) {
			applyvo.setUniquewayid("�б䶯");
		}
		if (strcompare(srcvo.getTown(),desvo.getTown())) {
			applyvo.setTown("�б䶯");
		}
		if (strcompare(srcvo.getProvtype(),desvo.getProvtype())) {
			applyvo.setProvtype("�б䶯");
		}
		if (strcompare(srcvo.getMobilemall(),desvo.getMobilemall())) {
			applyvo.setMobilemall("�б䶯");
		}
		if (strcompare(srcvo.getFrontarea(),desvo.getFrontarea())) {
			applyvo.setFrontarea("�б䶯");
		}
		if (strcompare(srcvo.getIspconntype(),desvo.getIspconntype())) {
			applyvo.setIspconntype("�б䶯");
		}
		
		// ������Ӫ�����̹���
		if (strcompare(srcvo.getMainlayer(),desvo.getMainlayer())) {
			applyvo.setMainlayer("�б䶯");
		}
		if (strcompare(srcvo.getBuzphoneno(),desvo.getBuzphoneno())) {
			applyvo.setBuzphoneno("�б䶯");
		}
		if (strcompare(srcvo.getCooperator(),desvo.getCooperator())) {
			applyvo.setCooperator("�б䶯");
		}
		if (strcompare(srcvo.getTaxtype(),desvo.getTaxtype())) {
			applyvo.setTaxtype("�б䶯");
		}
		if (strcompare(srcvo.getDistype(),desvo.getDistype())) {
			applyvo.setDistype("�б䶯");
		}
		if (strcompare(srcvo.getLinkman(),desvo.getLinkman())) {
			applyvo.setLinkman("�б䶯");
		}
		if (strcompare(srcvo.getLinkmantel(),desvo.getLinkmantel())) {
			applyvo.setLinkmantel("�б䶯");
		}
		if (strcompare(srcvo.getLinkmanemail(),desvo.getLinkmanemail())) {
			applyvo.setLinkmanemail("�б䶯");
		}
		if (strcompare(srcvo.getCompany(),desvo.getCompany())) {
			applyvo.setCompany("�б䶯");
		}
		if (strcompare(srcvo.getCoplevel(),desvo.getCoplevel())) {
			applyvo.setCoplevel("�б䶯");
		}
		if (strcompare(srcvo.getBusnum(),desvo.getBusnum())) {
			applyvo.setBusnum("�б䶯");
		}
		if (strcompare(srcvo.getCertitype(),desvo.getCertitype())) {
			applyvo.setCertitype("�б䶯");
		}
		if (strcompare(srcvo.getRegadress(),desvo.getRegadress())) {
			applyvo.setRegadress("�б䶯");
		}
		if (strcompare(srcvo.getRegcapital(),desvo.getRegcapital())) {
			applyvo.setRegcapital("�б䶯");
		}
		if (strcompare(srcvo.getCompanytype(),desvo.getCompanytype())) {
			applyvo.setCompanytype("�б䶯");
		}
		if (strcompare(srcvo.getBrole(),desvo.getBrole())) {
			applyvo.setBrole("�б䶯");
		}
		if (strcompare(srcvo.getCertinum(),desvo.getCertinum())) {
			applyvo.setCertinum("�б䶯");
		}
		if (strcompare(srcvo.getCopbound(),desvo.getCopbound())) {
			applyvo.setCopbound("�б䶯");
		}
		if (strcompare(srcvo.getRunareatype(),desvo.getRunareatype())) {
			applyvo.setRunareatype("�б䶯");
		}
		if (strcompare(srcvo.getCalcumode(),desvo.getCalcumode())) {
			applyvo.setCalcumode("�б䶯");
		}
		if (strcompare(srcvo.getUniformtime(),desvo.getUniformtime())) {
			applyvo.setUniformtime("�б䶯");
		}
		
		return applyvo;
	}
	
	public boolean strcompare(Object src, Object des) throws Exception {
		boolean flag = true;
		// ����ֵ��Ϊ��
		if (src == null && des == null) flag=false;
		
		// ��Ϊ�յ�ʱ������ֵ���
		if (src != null && des != null) {
			if (src.toString().equals(des.toString())) flag=false;
		}		
		return flag;
	}

	 /*  hasRight:0:����Ҫ����,��ԭ�߼�����   
	 *   hasRight:1:��Ҫ����,����ɫ����   
	 */
	public String doGetPurview() throws Exception {
		Sysparam sysparam = (SysparamBO) BOFactory.build(SysparamBO.class,
				super.getDBAccessUser());
		SysparamVO paramVO = new SysparamVO();
		paramVO.setSystemid(new Long("67"));
		paramVO.setParamtype("channel");
		paramVO = sysparam.doFindByPk(paramVO);
		if (paramVO != null && paramVO.getParamvalue() != null
				&& "1".equals(paramVO.getParamvalue())) {
			return "1";
		}
		return "0";
	}
	/**
	 * ���Ǳ��淽��
	 */
	public String doSave() throws Exception {
		WayapplyVO wayapplyVO = new WayapplyVO();
		WayapplyForm frm = (WayapplyForm) getForm();
		BeanUtils.copyProperties(wayapplyVO, frm);
		String returnMsg = "";
		if (WEB_CMD_NEW.equals(CMD)) {
			// �������������ṩ����
		} else {
			try {
				CMD = WEB_CMD_SAVE;
				Wayapply wayapply = (Wayapply) BOFactory.build(
						WayapplyBO.class, getDBAccessUser());
				Object vo = null;
				if (SAVETYPE_SAVE.equals(saveType)) {
					vo = wayapply.doSave(wayapplyVO);
					returnMsg = "����ɹ�";
				} else if (SAVETYPE_CANCEL.equals(saveType)) {
					if ("ADVINFO".equals(this.formType)) {// �Ӵ������������
						vo = wayapply.doCancel(wayapplyVO, true, rvcobjid);
					} else {
						vo = wayapply.doCancel(wayapplyVO, false, null);
					}
					returnMsg = "���������˻�";
				} else if (SAVETYPE_PASS.equals(saveType)) {
					if ("ADVINFO".equals(this.formType)) {// �Ӵ������������
						vo = wayapply.doPass(wayapplyVO, true, rvcobjid);
					} else {
						vo = wayapply.doPass(wayapplyVO, false, null);
					}
					returnMsg = "��������ͨ��";
				}
				BeanUtils.copyProperties(getForm(), vo);
				setActionMessage(returnMsg);
			} catch (Exception e) {
				e.printStackTrace();
				CMD = WEB_CMD_EDIT;
				super.addActionError(e.getMessage());
			}
		}
		// �ж���ʾ�ĸ�ҳ��
		String rescontent = null;
		if ("1".equals(wayapplyVO.getComefrom())) {
			if ("DIS".equals(wayapplyVO.getWaysubtype())) {
				rescontent = "discontent";
			} else {
				rescontent = "salecontent";
			}
		} else {
			rescontent = WEB_RESULT_CONTENT;
		}
		return rescontent;//WEB_RESULT_CONTENT;
	}

	public String doGetcountid() throws Exception {
		String rescontent = null;
		try{
		WayapplyForm form = (WayapplyForm) getForm();
		this.CMD = WEB_CMD_EDIT;
		if ("cityid".equals(form.getCmdvalue())) {
			form.setCountyid("");
			form.setSvccode("");
			form.setMareacode("");
			if (AAUtils.isAjaxRequest(getRequest())) {
				AAUtils.addZonesToRefresh(getRequest(), "getcountyid");
				AAUtils.addZonesToRefresh(getRequest(), "getsvccode");
				AAUtils.addZonesToRefresh(getRequest(), "getmareacode");
			}
		} else if ("citycompid".equals(form.getCmdvalue())) {
			if (AAUtils.isAjaxRequest(getRequest())) {
				AAUtils.addZonesToRefresh(getRequest(), "getsvccode");
				AAUtils.addZonesToRefresh(getRequest(), "getmareacode");
			}
			form.setSvccode("");
			form.setMareacode("");
		}else
		{
			if (AAUtils.isAjaxRequest(getRequest())) {
				AAUtils.addZonesToRefresh(getRequest(), "getmareacode");
			}
		}
		
		setForm(form);
		// �ж���ʾ�ĸ�ҳ��
		if ("1".equals(form.getComefrom())) {
			if ("DIS".equals(form.getWaysubtype())) {
				rescontent = "discontent";
			} else {
				rescontent = "salecontent";
			}
		} else {
			rescontent = WEB_RESULT_CONTENT;
		}
		}catch(Exception ex)
		{
			addActionError(ex.getMessage());
			return rescontent;//WEB_RESULT_CONTENT;
		}

		return rescontent;//WEB_RESULT_CONTENT;
	}

	public String getSaveType() {
		return saveType;
	}

	public void setSaveType(String saveType) {
		this.saveType = saveType;
	}

	public String getFormType() {
		return formType;
	}

	public void setFormType(String formType) {
		this.formType = formType;
	}
	public String  doCheckupperway() throws Exception {
		Way way = (Way) BOFactory.build(WayBO.class, getDBAccessUser());
		WayapplyForm form = (WayapplyForm) getForm();
		WayVO uppwayVO = way.doFindByPk(form.getUpperwayid());

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
			this.setCMD("EDIT");
		if(StringUtils.equals(uppwayVO.getWaytype(), "AG") && StringUtils.equals(uppwayVO.getWaysubtype(), "DIS"))
		{
			form.setChainhead(uppwayVO.getWayid());
		}
		else
		{
			form.setChainhead("");
		}
		
		// �ж���ʾ�ĸ�ҳ��
		String rescontent = null;
		if ("1".equals(form.getComefrom())) {
			if ("DIS".equals(form.getWaysubtype())) {
				rescontent = "discontent";
			} else {
				rescontent = "salecontent";
			}
		} else {
			rescontent = WEB_RESULT_CONTENT;
		}
		return rescontent;//"content";
	}

}