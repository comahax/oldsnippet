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
	private String formType;// 表请求从哪个页面进来 当从待办任务过来时（ADVINFO） 审批通过后关闭待办
	private Long rvcobjid;// 接收对象表标识

	public Long getRvcobjid() {
		return rvcobjid;
	}

	public void setRvcobjid(Long rvcobjid) {
		this.rvcobjid = rvcobjid;
	}

	public WayapplyAction() {
		super();

		// 以下几个方法是必须的
		this.setForm(new WayapplyForm());
		this.setParam(new WayapplyWebParam());

		// 指定VO类
		setClsVO(WayapplyVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[] { "applyno" };
		this.setClsControl(Wayapply.class);
		this.setClsQueryParam(WayapplyDBParam.class);

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	/**
	 * 重写doEdit方法，根据SEQID取得CH_PW_AUDITWORK表中的值
	 */
	public String doEdit() throws Exception {
		String rescontent = null;
		try{
		WayapplyForm frm = (WayapplyForm) getForm();
		WayapplyVO vo = (WayapplyVO) findVOFromDB();
		// 根据单号 （SeqID）查询工单表 (CH_PW_AUDITWORK)的处理内容，审核状态。将查询结果覆盖到界面对应字段
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
			/*  查询登陆的工号是否有网点审批角色控制*/
			vo.setHasRight(doGetPurview());
			// 取渠道信息
			Way way = (Way) BOFactory.build(WayBO.class, super
					.getDBAccessUser());
			WayVO wayVO = way.doFindByPk(vo.getWayid());
			BeanUtils.copyProperties(wayapplyVO, wayVO);
			// 取网点联系资料
			Bchcontact bchcontact = (BchcontactBO) BOFactory.build(
					BchcontactBO.class, super.getDBAccessUser());
			BchcontactVO bchcontactVO = bchcontact.doFindByPk(vo.getWayid());
			if (null != bchcontactVO)
				BeanUtils.copyProperties(wayapplyVO, bchcontactVO);
			// 合同协议资料
			Waycompact waycompact = (Waycompact) BOFactory.build(
					WaycompactBO.class, super.getDBAccessUser());
			WaycompactVO waycompactVO = waycompact.doFindByPk(vo.getWayid());
			if (null != waycompactVO)
				BeanUtils.copyProperties(wayapplyVO, waycompactVO);
			// 取帐户信息
			Wayaccount wayaccount = (WayaccountBO) BOFactory.build(
					WayaccountBO.class, super.getDBAccessUser());
			WayaccountVO wayaccountVO = new WayaccountVO();
			wayaccountVO.setAccid(new Integer(0));// 新增单帐户的ACCID为0
			wayaccountVO.setWayid(vo.getWayid());
			wayaccountVO = wayaccount.doFindByPk(wayaccountVO);
			if (null != wayaccountVO) {
				BeanUtils.copyProperties(wayapplyVO, wayaccountVO);
			}
			// 取得店主号码
			Employee employee = (EmployeeBO) BOFactory.build(EmployeeBO.class,
					super.getDBAccessUser());
			EmployeeDBParam employeeParam = new EmployeeDBParam();
			employeeParam.set_ne_isnet("1");// 店主
			employeeParam.set_ne_empstatus("0");// 在岗
			employeeParam.set_se_wayid(vo.getWayid());
			DataPackage employeeDP = employee.doQuery(employeeParam);
			if (null != employeeDP && null != employeeDP.getDatas()
					&& !employeeDP.getDatas().isEmpty()) {
				EmployeeVO employeeVO = (EmployeeVO) employeeDP.getDatas()
						.iterator().next();
				wayapplyVO.setOfficetel(employeeVO.getOfficetel());
			}
			//取合作商信息
			Cooperator cop = (Cooperator) BOFactory.build(CooperatorBO.class, super.getDBAccessUser());
			if(vo.getWayid()!=null)
			{
				CooperatorVO copVO=(CooperatorVO)cop.doFindByPk(vo.getWayid());
				if(copVO!=null)
				{
					BeanUtils.copyProperties(wayapplyVO, copVO);
				}
			}
			// 根据单号 （SeqID）查询工单表 (CH_PW_AUDITWORK)的处理内容，审核状态。将查询结果覆盖到界面对应字段
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
		// 根据申请ID （APPLYNO）查询网点申请信息表(CH_PW_WAYAPPLY)，将查询结果覆盖到界面对应字段。
//		BeanUtils.copyProperties(wayapplyVO, vo);
		if(auditworkVO!=null && auditworkVO.getStepid()!=null)
		{
			vo.setLastStepid(auditworkVO.getStepid().substring(auditworkVO.getStepid().length()-1));
		}
		
		String stepid = auditworkVO == null ? null : auditworkVO.getStepid();
		//登陆工号有权限审批不给默认值,否则按原流程给默认值
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
		
		// 检查权限令牌
		Sysparam sysparam = (Sysparam)BOFactory.build(SysparamBO.class, getDBAccessUser());
		String paramvalue = sysparam.doFindByID(new Long("77"), "channel");
		// 如果paramvalue查到记录并且值为1，则需要用新的固定参数显示步骤ID下拉框
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
		
		// 判断显示的是哪个页面
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
	 * 变动比较然后做标记
	 * @param srcvo
	 * @param desvo
	 * @return
	 * @throws Exception
	 */
	public AGWayapplyVO comparevo(WayapplyVO srcvo, WayapplyVO desvo) throws Exception {
		AGWayapplyVO applyvo = new AGWayapplyVO();
		// 网点方面的变动
		if (strcompare(srcvo.getWayid(),desvo.getWayid())) {
			applyvo.setWayid("有变动");
		}
		if (strcompare(srcvo.getWayname(),desvo.getWayname())) {
			applyvo.setWayname("有变动");
		}
		if (strcompare(srcvo.getStarlevel(),desvo.getStarlevel())) {
			applyvo.setStarlevel("有变动");
		}
		if (strcompare(srcvo.getPt(),desvo.getPt())) {
			applyvo.setPt("有变动");
		}
		if (strcompare(srcvo.getWaymagcode(),desvo.getWaymagcode())) {
			applyvo.setWaymagcode("有变动");
		}
		if (strcompare(srcvo.getIsstraitprd(),desvo.getIsstraitprd())) {
			applyvo.setIsstraitprd("有变动");
		}
		if (strcompare(srcvo.getIsstraitprd(),desvo.getIsstraitprd())) {
			applyvo.setIsstraitprd("有变动");
		}
		if (strcompare(srcvo.getUpperwayid(),desvo.getUpperwayid())) {
			applyvo.setUpperwayid("有变动");
		}
		if (strcompare(srcvo.getAdacode(),desvo.getAdacode())) {
			applyvo.setAdacode("有变动");
		}
		if (strcompare(srcvo.getCatetype(),desvo.getCatetype())) {
			applyvo.setCatetype("有变动");
		}
		if (strcompare(srcvo.getWaysubtype(),desvo.getWaysubtype())) {
			applyvo.setWaysubtype("有变动");
		}
		if (strcompare(srcvo.getWaysubtype(),desvo.getWaysubtype())) {
			applyvo.setWaysubtype("有变动");
		}
		if (strcompare(srcvo.getFormtype(),desvo.getFormtype())) {
			applyvo.setFormtype("有变动");
		}
		if (strcompare(srcvo.getStarttime(),desvo.getStarttime())) {
			applyvo.setStarttime("有变动");
		}
		if (strcompare(srcvo.getCityid(),desvo.getCityid())) {
			applyvo.setCityid("有变动");
		}
		if (strcompare(srcvo.getCountyid(),desvo.getCountyid())) {
			applyvo.setCountyid("有变动");
		}
		if (strcompare(srcvo.getSvccode(),desvo.getSvccode())) {
			applyvo.setSvccode("有变动");
		}
		if (strcompare(srcvo.getMareacode(),desvo.getMareacode())) {
			applyvo.setMareacode("有变动");
		}
		if (strcompare(srcvo.getBchlevel(),desvo.getBchlevel())) {
			applyvo.setBchlevel("有变动");
		}
		if (strcompare(srcvo.getBuzarea(),desvo.getBuzarea())) {
			applyvo.setBuzarea("有变动");
		}
		if (strcompare(srcvo.getWaystate(),desvo.getWaystate())) {
			applyvo.setWaystate("有变动");
		}
		if (strcompare(srcvo.getLogiscode(),desvo.getLogiscode())) {
			applyvo.setLogiscode("有变动");
		}
		if (strcompare(srcvo.getAlarmbizamount(),desvo.getAlarmbizamount())) {
			applyvo.setAlarmbizamount("有变动");
		}
		if (strcompare(srcvo.getOfficetel(),desvo.getOfficetel())) {
			applyvo.setOfficetel("有变动");
		}
		if (strcompare(srcvo.getAddress(),desvo.getAddress())) {
			applyvo.setAddress("有变动");
		}
		if (strcompare(srcvo.getLatitude(),desvo.getLatitude())) {
			applyvo.setLatitude("有变动");
		}
		if (strcompare(srcvo.getLongtitude(),desvo.getLongtitude())) {
			applyvo.setLongtitude("有变动");
		}
		if (strcompare(srcvo.getAdtypecode(),desvo.getAdtypecode())) {
			applyvo.setAdtypecode("有变动");
		}
		if (strcompare(srcvo.getSignstatus(),desvo.getSignstatus())) {
			applyvo.setSignstatus("有变动");
		}
		if (strcompare(srcvo.getProvcode(),desvo.getProvcode())) {
			applyvo.setProvcode("有变动");
		}
		if (strcompare(srcvo.getChainhead(),desvo.getChainhead())) {
			applyvo.setChainhead("有变动");
		}
		if (strcompare(srcvo.getCusttype(),desvo.getCusttype())) {
			applyvo.setCusttype("有变动");
		}
		if (strcompare(srcvo.getBuztypecode(),desvo.getBuztypecode())) {
			applyvo.setBuztypecode("有变动");
		}
		if (strcompare(srcvo.getIstietong(),desvo.getIstietong())) {
			applyvo.setIstietong("有变动");
		}
		if (strcompare(srcvo.getConnecttype(),desvo.getConnecttype())) {
			applyvo.setConnecttype("有变动");
		}
		if (strcompare(srcvo.getSublayer(),desvo.getSublayer())) {
			applyvo.setSublayer("有变动");
		}
		if (strcompare(srcvo.getRegid(),desvo.getRegid())) {
			applyvo.setRegid("有变动");
		}
		if (strcompare(srcvo.getChecked(),desvo.getChecked())) {
			applyvo.setChecked("有变动");
		}
		if (strcompare(srcvo.getPrincipal(),desvo.getPrincipal())) {
			applyvo.setPrincipal("有变动");
		}
		if (strcompare(srcvo.getPrincipaltel(),desvo.getPrincipaltel())) {
			applyvo.setPrincipaltel("有变动");
		}
		if (strcompare(srcvo.getPrincipalphone(),desvo.getPrincipalphone())) {
			applyvo.setPrincipalphone("有变动");
		}
		if (strcompare(srcvo.getPrincipalemail(),desvo.getPrincipalemail())) {
			applyvo.setPrincipalemail("有变动");
		}
		if (strcompare(srcvo.getSmsmobileno(),desvo.getSmsmobileno())) {
			applyvo.setSmsmobileno("有变动");
		}
		if (strcompare(srcvo.getRecpers(),desvo.getRecpers())) {
			applyvo.setRecpers("有变动");
		}
		if (strcompare(srcvo.getRecconntel(),desvo.getRecconntel())) {
			applyvo.setRecconntel("有变动");
		}
		if (strcompare(srcvo.getReccertno(),desvo.getReccertno())) {
			applyvo.setReccertno("有变动");
		}
		if (strcompare(srcvo.getBailtype(),desvo.getBailtype())) {
			applyvo.setBailtype("有变动");
		}
		if (strcompare(srcvo.getServbound(),desvo.getServbound())) {
			applyvo.setServbound("有变动");
		}
		if (strcompare(srcvo.getSendaddr(),desvo.getSendaddr())) {
			applyvo.setSendaddr("有变动");
		}
		if (strcompare(srcvo.getAccttype(),desvo.getAccttype())) {
			applyvo.setAccttype("有变动");
		}
		if (strcompare(srcvo.getCompactno(),desvo.getCompactno())) {
			applyvo.setCompactno("有变动");
		}
		if (strcompare(srcvo.getIsb2m(),desvo.getIsb2m())) {
			applyvo.setIsb2m("有变动");
		}
		if (strcompare(srcvo.getCompactname(),desvo.getCompactname())) {
			applyvo.setCompactname("有变动");
		}
		if (strcompare(srcvo.getBegintime(),desvo.getBegintime())) {
			applyvo.setBegintime("有变动");
		}
		if (strcompare(srcvo.getEndtime(),desvo.getEndtime())) {
			applyvo.setEndtime("有变动");
		}
		if (strcompare(srcvo.getSigntime(),desvo.getSigntime())) {
			applyvo.setSigntime("有变动");
		}
		if (strcompare(srcvo.getCompacttype(),desvo.getCompacttype())) {
			applyvo.setCompacttype("有变动");
		}
		if (strcompare(srcvo.getLicenceno(),desvo.getLicenceno())) {
			applyvo.setLicenceno("有变动");
		}
		if (strcompare(srcvo.getBail(),desvo.getBail())) {
			applyvo.setBail("有变动");
		}
		if (strcompare(srcvo.getBaillwrlmt(),desvo.getBaillwrlmt())) {
			applyvo.setBaillwrlmt("有变动");
		}
		if (strcompare(srcvo.getLicvalidate(),desvo.getLicvalidate())) {
			applyvo.setLicvalidate("有变动");
		}
		if (strcompare(srcvo.getBailstatus(),desvo.getBailstatus())) {
			applyvo.setBailstatus("有变动");
		}
		if (strcompare(srcvo.getIsunpb(),desvo.getIsunpb())) {
			applyvo.setIsunpb("有变动");
		}
		if (strcompare(srcvo.getAcctno(),desvo.getAcctno())) {
			applyvo.setAcctno("有变动");
		}
		if (strcompare(srcvo.getAcctname(),desvo.getAcctname())) {
			applyvo.setAcctname("有变动");
		}
		if (strcompare(srcvo.getBankname(),desvo.getBankname())) {
			applyvo.setBankname("有变动");
		}
		if (strcompare(srcvo.getAcctfid(),desvo.getAcctfid())) {
			applyvo.setAcctfid("有变动");
		}
		if (strcompare(srcvo.getDebankid(),desvo.getDebankid())) {
			applyvo.setDebankid("有变动");
		}
		if (strcompare(srcvo.getDestate(),desvo.getDestate())) {
			applyvo.setDestate("有变动");
		}
		if (strcompare(srcvo.getDeacctno(),desvo.getDeacctno())) {
			applyvo.setDeacctno("有变动");
		}
		if (strcompare(srcvo.getDeacctname(),desvo.getDeacctname())) {
			applyvo.setDeacctname("有变动");
		}
		if (strcompare(srcvo.getDebankname(),desvo.getDebankname())) {
			applyvo.setDebankname("有变动");
		}
		if (strcompare(srcvo.getIntime(),desvo.getIntime())) {
			applyvo.setIntime("有变动");
		}
		if (strcompare(srcvo.getIsKzcz(),desvo.getIsKzcz())) {
			applyvo.setIskzcz("有变动");
		}
		if (strcompare(srcvo.getStarlev(),desvo.getStarlev())) {
			applyvo.setStarlev("有变动");
		}
		if (strcompare(srcvo.getUniquewayid(),desvo.getUniquewayid())) {
			applyvo.setUniquewayid("有变动");
		}
		if (strcompare(srcvo.getTown(),desvo.getTown())) {
			applyvo.setTown("有变动");
		}
		if (strcompare(srcvo.getProvtype(),desvo.getProvtype())) {
			applyvo.setProvtype("有变动");
		}
		if (strcompare(srcvo.getMobilemall(),desvo.getMobilemall())) {
			applyvo.setMobilemall("有变动");
		}
		if (strcompare(srcvo.getFrontarea(),desvo.getFrontarea())) {
			applyvo.setFrontarea("有变动");
		}
		if (strcompare(srcvo.getIspconntype(),desvo.getIspconntype())) {
			applyvo.setIspconntype("有变动");
		}
		
		// 连锁经营合作商管理
		if (strcompare(srcvo.getMainlayer(),desvo.getMainlayer())) {
			applyvo.setMainlayer("有变动");
		}
		if (strcompare(srcvo.getBuzphoneno(),desvo.getBuzphoneno())) {
			applyvo.setBuzphoneno("有变动");
		}
		if (strcompare(srcvo.getCooperator(),desvo.getCooperator())) {
			applyvo.setCooperator("有变动");
		}
		if (strcompare(srcvo.getTaxtype(),desvo.getTaxtype())) {
			applyvo.setTaxtype("有变动");
		}
		if (strcompare(srcvo.getDistype(),desvo.getDistype())) {
			applyvo.setDistype("有变动");
		}
		if (strcompare(srcvo.getLinkman(),desvo.getLinkman())) {
			applyvo.setLinkman("有变动");
		}
		if (strcompare(srcvo.getLinkmantel(),desvo.getLinkmantel())) {
			applyvo.setLinkmantel("有变动");
		}
		if (strcompare(srcvo.getLinkmanemail(),desvo.getLinkmanemail())) {
			applyvo.setLinkmanemail("有变动");
		}
		if (strcompare(srcvo.getCompany(),desvo.getCompany())) {
			applyvo.setCompany("有变动");
		}
		if (strcompare(srcvo.getCoplevel(),desvo.getCoplevel())) {
			applyvo.setCoplevel("有变动");
		}
		if (strcompare(srcvo.getBusnum(),desvo.getBusnum())) {
			applyvo.setBusnum("有变动");
		}
		if (strcompare(srcvo.getCertitype(),desvo.getCertitype())) {
			applyvo.setCertitype("有变动");
		}
		if (strcompare(srcvo.getRegadress(),desvo.getRegadress())) {
			applyvo.setRegadress("有变动");
		}
		if (strcompare(srcvo.getRegcapital(),desvo.getRegcapital())) {
			applyvo.setRegcapital("有变动");
		}
		if (strcompare(srcvo.getCompanytype(),desvo.getCompanytype())) {
			applyvo.setCompanytype("有变动");
		}
		if (strcompare(srcvo.getBrole(),desvo.getBrole())) {
			applyvo.setBrole("有变动");
		}
		if (strcompare(srcvo.getCertinum(),desvo.getCertinum())) {
			applyvo.setCertinum("有变动");
		}
		if (strcompare(srcvo.getCopbound(),desvo.getCopbound())) {
			applyvo.setCopbound("有变动");
		}
		if (strcompare(srcvo.getRunareatype(),desvo.getRunareatype())) {
			applyvo.setRunareatype("有变动");
		}
		if (strcompare(srcvo.getCalcumode(),desvo.getCalcumode())) {
			applyvo.setCalcumode("有变动");
		}
		if (strcompare(srcvo.getUniformtime(),desvo.getUniformtime())) {
			applyvo.setUniformtime("有变动");
		}
		
		return applyvo;
	}
	
	public boolean strcompare(Object src, Object des) throws Exception {
		boolean flag = true;
		// 两个值都为空
		if (src == null && des == null) flag=false;
		
		// 不为空的时候两个值相等
		if (src != null && des != null) {
			if (src.toString().equals(des.toString())) flag=false;
		}		
		return flag;
	}

	 /*  hasRight:0:不需要控制,按原逻辑审批   
	 *   hasRight:1:需要控制,按角色审批   
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
	 * 覆盖保存方法
	 */
	public String doSave() throws Exception {
		WayapplyVO wayapplyVO = new WayapplyVO();
		WayapplyForm frm = (WayapplyForm) getForm();
		BeanUtils.copyProperties(wayapplyVO, frm);
		String returnMsg = "";
		if (WEB_CMD_NEW.equals(CMD)) {
			// 网点审批管理不提供新增
		} else {
			try {
				CMD = WEB_CMD_SAVE;
				Wayapply wayapply = (Wayapply) BOFactory.build(
						WayapplyBO.class, getDBAccessUser());
				Object vo = null;
				if (SAVETYPE_SAVE.equals(saveType)) {
					vo = wayapply.doSave(wayapplyVO);
					returnMsg = "保存成功";
				} else if (SAVETYPE_CANCEL.equals(saveType)) {
					if ("ADVINFO".equals(this.formType)) {// 从待办任务过来的
						vo = wayapply.doCancel(wayapplyVO, true, rvcobjid);
					} else {
						vo = wayapply.doCancel(wayapplyVO, false, null);
					}
					returnMsg = "审批单已退回";
				} else if (SAVETYPE_PASS.equals(saveType)) {
					if ("ADVINFO".equals(this.formType)) {// 从待办任务过来的
						vo = wayapply.doPass(wayapplyVO, true, rvcobjid);
					} else {
						vo = wayapply.doPass(wayapplyVO, false, null);
					}
					returnMsg = "审批单已通过";
				}
				BeanUtils.copyProperties(getForm(), vo);
				setActionMessage(returnMsg);
			} catch (Exception e) {
				e.printStackTrace();
				CMD = WEB_CMD_EDIT;
				super.addActionError(e.getMessage());
			}
		}
		// 判断显示哪个页面
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
		// 判断显示哪个页面
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

		// 社会网点的上级渠道必须是合作商，移动部门/科室或服务厅下添加社会网点
		if ("DIS".equals(uppwayVO.getWaysubtype())
				|| "GMPT".equals(uppwayVO.getWaysubtype())
				|| "G100".equals(uppwayVO.getWaysubtype())) {
			form.setCityid(uppwayVO.getCityid());
			form.setCountyid(uppwayVO.getCountyid());
			form.setSvccode(uppwayVO.getSvccode());
			form.setMareacode(uppwayVO.getMareacode());
		} else {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"录入的上级渠道只能是连锁经营合作商，移动部门/科室或服务厅");
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
		
		// 判断显示哪个页面
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