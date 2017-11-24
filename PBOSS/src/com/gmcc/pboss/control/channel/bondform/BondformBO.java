/**
 * auto-generated code
 * Thu Dec 29 08:58:06 CST 2011
 */
package com.gmcc.pboss.control.channel.bondform;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.gmcc.pboss.business.channel.bondaudit.BondauditVO;
import com.gmcc.pboss.business.channel.bondform.BondformDAO;
import com.gmcc.pboss.business.channel.bondform.BondformDBParam;
import com.gmcc.pboss.business.channel.bondform.BondformVO;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.channel.waitreq.WaitreqVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountDBParam;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountVO;
import com.gmcc.pboss.business.sales.bankdeduct.BankdeductVO;
import com.gmcc.pboss.business.sales.bankshop.BankshopDBParam;
import com.gmcc.pboss.business.sales.bankshop.BankshopVO;
import com.gmcc.pboss.control.base.smstmpl.Smstmpl;
import com.gmcc.pboss.control.base.smstmpl.SmstmplBO;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.bondaudit.BondauditBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.channel.wayaccount.Wayaccount;
import com.gmcc.pboss.control.channel.wayaccount.WayaccountBO;
import com.gmcc.pboss.control.sales.bankdeduct.Bankdeduct;
import com.gmcc.pboss.control.sales.bankdeduct.BankdeductBO;
import com.gmcc.pboss.control.sales.bankshop.Bankshop;
import com.gmcc.pboss.control.sales.bankshop.BankshopBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

/**
 * <p>Title: BondformBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public class BondformBO extends AbstractControlBean implements
		Bondform {

	public BondformVO doCreate(BondformVO vo) throws Exception {
		try {
			BondformDAO dao = (BondformDAO) DAOFactory.build(BondformDAO.class, user);
			// TODO set the pk */
			return (BondformVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(BondformVO vo) throws Exception {
		try {
			BondformDAO dao = (BondformDAO) DAOFactory.build(BondformDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			BondformDAO dao = (BondformDAO) DAOFactory.build(BondformDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BondformVO doUpdate(BondformVO vo) throws Exception {
		try {
			BondformDAO dao = (BondformDAO) DAOFactory.build(BondformDAO.class,user);
			return (BondformVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BondformVO doFindByPk(Serializable pk) throws Exception {
		BondformDAO dao = (BondformDAO) DAOFactory.build(BondformDAO.class,user);
		return (BondformVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(BondformDBParam params)
			throws Exception {
		BondformDAO dao = (BondformDAO) DAOFactory.build(BondformDAO.class,user);
		return dao.query(params);
	}
	
	
	//提交审核
	public String doSubmitboss(String formid,String boss,User user) throws Exception {		
		BondauditBO bondauditBO = (BondauditBO) BOFactory.build(BondauditBO.class,user);
		BondauditVO bondauditVO = new BondauditVO();
		BondformVO bondformVO = new BondformVO();
		// 在审核工号列表弹出框中选择审核工号，并确定。
		// 此时在“保证金审核表[FX_SW_BONDAUDIT]”表中新增一条保证金待审核记录，
		// 其中“序号[SEQID]”为当前日期+库表序列，
		//“提交人[PRESENTER]”为当前提交工号，
		// “提交时间[SMSNTIME]”为当前系统时间，
		//“审核人[AUDITOR]”为列表中选定的审核人工号，
		//“状态[STATE]”为“待审核[0]”，
		//“保证金申请单编号”为当前提交申请单号。
		//申请单类型为该单的申请类型。
		
		bondformVO = this.doFindByPk(Long.parseLong(formid));
		
		
		String seq = "";
		Date date = new Date(System.currentTimeMillis());
		
		 Calendar cal = Calendar.getInstance();
		 String day = cal.get(Calendar.DATE)+"";
		 String month = (cal.get(Calendar.MONTH) + 1)+"";
		 String year = cal.get(Calendar.YEAR)+"";
		 if(day.toString().length()==1){
			 day="0"+day;
		 }
		 
		 if(month.toString().length()==1){
			 month="0"+month;
		 }
		 
		 seq =  year+month+day+bondauditBO.doQuerySeq();
		 bondauditVO.setSeqid(Long.parseLong(seq));
		 bondauditVO.setPresenter(user.getOprcode());
		 bondauditVO.setSmsntime(date);
		 bondauditVO.setAuditor(boss);
		 bondauditVO.setState("0");
		 bondauditVO.setFormid(bondformVO.getFormid());
		 bondauditVO.setBondtype(bondformVO.getBondtype());
			
		 bondauditBO.doCreate(bondauditVO);
		 
		 
		// 更新保证金申请单表状态为“待审核“
			//最后返回页面成功信息“提交操作成功”。
		 bondformVO.setState(Short.parseShort("1"));
		 this.doUpdate(bondformVO);
		return null;
	}
	
	
	//短信发送
	public String doSendinfor(String formid,User user) throws Exception {
//		1.新增数据到短信待发送表(CH_SMS_WAITREQ)，
//		2字段取值如下：
//		//3短信类型取3；
//		//4发送号码：查询系统参数配置表（IB_GL_SYSPARAM），匹配参数类型为“pboss_fx”，参数标识为“42”，发送号码取参数值。
//		//5接收号码：取渠道的公务机号码；
//		//6短信内容：调用商品订购短信公用方法（保证金上缴确认）获取。
//		//7客户名称取渠道名称，如果该字段为空则默认取“客户”；
//		8日期取当前时间；
//		//9金额为上缴金额；
//		//10上缴单号取申请单号；
//		//11地市公司为渠道所属地市公司。
//		
//		说明：如果发送号码、接收号码或短信内容任一个为空，不发送短信通知。
//		返回页面错误信息“发送号码/接收号码/短信内容为空！”；
//		发送短信成功后，更新保证金申请单表状态为“待确认”，状态为“确认未通过”时不更新。
//		最后返回页面成功信息“发送确认短信成功”。	
		
		WaitreqVO waitreqVO = new WaitreqVO();
		
		
		//保证金申请单
		BondformVO bondformVO = new BondformVO();
		bondformVO = this.doFindByPk(Long.parseLong(formid));
		
		//查询公务机号码
		EmployeeBO employeeBO = (EmployeeBO) BOFactory.build(EmployeeBO.class,user);
		EmployeeDBParam employeeDBParam = new EmployeeDBParam();
		employeeDBParam.set_se_wayid(bondformVO.getWayid());		
		employeeDBParam.set_se_empstatus(Short.parseShort("0"));
		
		DataPackage dp = employeeBO.doQuery(employeeDBParam);
		
		if(dp.getDatas()!=null && dp.getDatas().size()>0){
			EmployeeVO employeeVO = (EmployeeVO)dp.getDatas().get(0);
			waitreqVO.setRecno(employeeVO.getOfficetel());
			
		}
		
		
		//查询渠道信息
		Way way = (Way) BOFactory.build(WayBO.class,user);
		WayVO vo=way.doFindByPk(bondformVO.getWayid());
		
		
		
		//发送号码
		SysparamBO sysparamBO = (SysparamBO) BOFactory.build(SysparamBO.class,user);
		String sysstr = sysparamBO.doFindByID(42L, "pboss_fx");  
		
		
		//CUSTNAME-客户名称,AMT-金额，FORMID-上缴单号，CITYNAME-地市公司
		Date date = new Date(System.currentTimeMillis());
		
		
		Map<String,String> map = new HashMap<String,String>();
		if(vo.getWayname()!=null && !vo.getWayname().equals("")){
			map.put("CUSTNAME", vo.getWayname());
		}else{
			map.put("CUSTNAME", "客户");
		}
		
		map.put("AMT", bondformVO.getPayamt()+"");
		map.put("FORMID", bondformVO.getFormid()+"");
		map.put("CITYNAME", ""+Code2NameUtils.code2Name("CITYNAME", user.getCityid(), user.getCityid()));	
		Smstmpl smstmplBO = (SmstmplBO)BOFactory.build(SmstmplBO.class,user);
		String smsContent = smstmplBO.doGenSMS("FX_BOND_PAYCONFIR", map);
		
		
		
		waitreqVO.setSendno(sysstr);
		waitreqVO.setSmstype(Short.parseShort("3"));
		waitreqVO.setMessage(smsContent);

		WaitreqBO waitreqBO = (WaitreqBO)BOFactory.build(WaitreqBO.class,user);
		
		//插入短信待发送表
		if(waitreqVO.getRecno()==null || waitreqVO.getRecno().equals("") || waitreqVO.getSendno()==null || waitreqVO.getSendno().equals("") || waitreqVO.getMessage()==null || waitreqVO.getMessage().equals("")){
			 throw new Exception("发送号码/接收号码/短信内容为空！");			
		}else{		
		waitreqBO.doInsert3(waitreqVO.getSmstype(), waitreqVO.getMessage(), waitreqVO.getSendno(), waitreqVO.getRecno(), date);
		}
		
		
		
//		发送短信成功后，更新保证金申请单表状态为“待确认”，状态为“确认未通过”时不更新。
		if(bondformVO.getState()!=5){
			 bondformVO.setState(Short.parseShort("4"));
			 this.doUpdate(bondformVO);
		}
				
		return null;
	}

	
	//划扣
	public String doMvaccount(String formid, User user) throws Exception {

		//银行划扣记录检查
		Bankdeduct bankdeduct = (Bankdeduct)BOFactory.build(BankdeductBO.class, user);
		
		
		//保证金申请单
		BondformVO bondformVO = new BondformVO();
		bondformVO = this.doFindByPk(Long.parseLong(formid));
		
		Date date = new Date(System.currentTimeMillis());
		
//		获取账户资料
//		根据配送商编码查询渠道帐户资料(CH_PW_WAYACCOUNT)，如果无数据，则返回页面信息为“账户资料不存在”；如果有多条数据，以第一条数据为准。
//		判断帐号类型是否为空，如果为空，则返回页面信息为“帐号类型为空”；
//		判断卡类购销划扣银行账号是否为空，如果为空，则返回页面信息为“银行账号为空”，；
//		判断卡类购销划扣帐号名称是否为空，如果为空，则返回页面信息为“帐号名称为空”；
//		判断卡类购销划扣银行标识是否为空，如果为空，则返回页面信息为“银行标识为空”。
		
		//检查账户资料
		String bankid;//银行代码
		String acctnum;//银行账号
		Short accttype;//帐号类型
		String acctname;//账户名称
		Wayaccount wayaccount = (Wayaccount)BOFactory.build(WayaccountBO.class, user);
		WayaccountDBParam wparam = new WayaccountDBParam();
		wparam.set_se_wayid(bondformVO.getWayid());
		DataPackage dp2 = wayaccount.doQuery(wparam);
		if(null!=dp2&&dp2.getDatas().size()>0){
			WayaccountVO wayaccountvo = (WayaccountVO)dp2.getDatas().iterator().next();
			if(StringUtils.isBlank(wayaccountvo.getAccttype().toString()))
				throw new Exception("合作商["+bondformVO.getWayid()+"]帐号类型为空");
			accttype = wayaccountvo.getAccttype();
			if(StringUtils.isBlank(wayaccountvo.getDeacctno()))
				throw new Exception("合作商["+bondformVO.getWayid()+"]银行账号为空");
			acctnum = wayaccountvo.getDeacctno();
			if(StringUtils.isBlank(wayaccountvo.getDeacctname()))
				throw new Exception("合作商["+bondformVO.getWayid()+"]帐号名称为空");
			acctname = wayaccountvo.getDeacctname();
			if(StringUtils.isBlank(wayaccountvo.getDebankid()))
				throw new Exception("合作商["+bondformVO.getWayid()+"]银行标识为空");
			bankid = wayaccountvo.getDebankid();
		}else{
			throw new Exception("合作商["+bondformVO.getWayid()+"]账户资料不存在");
		}
		
		
		
		
		//获取银行商户信息
		String shopnum;//商户号
		String terminalnum;//终端号
		Bankshop bankshop = (Bankshop)BOFactory.build(BankshopBO.class, user);
		BankshopDBParam bparam = new BankshopDBParam();
		bparam.set_se_cityid(user.getCityid());
		bparam.set_se_countyid(bondformVO.getCountyid());
		DataPackage dp3 = bankshop.doQuery(bparam);
		if(null!=dp3&&dp3.getDatas().size()>0){
			BankshopVO bankshopvo = (BankshopVO)dp3.getDatas().iterator().next();
			shopnum = bankshopvo.getShopnum();
			terminalnum = bankshopvo.getTerminalnum();
		}else{
			throw new Exception("无法获取合作商["+bondformVO.getWayid()+"]对应的银行商户信息");
		}
		
		
		
		//获取手机号码
		String officetel = "";//手机号码
		Employee employee = (Employee)BOFactory.build(EmployeeBO.class, user);
		EmployeeDBParam eparam = new EmployeeDBParam();
		eparam.set_se_wayid(bondformVO.getWayid());
		eparam.set_ne_empstatus("0");
		
		if(bondformVO.getBoneobjtype()==0){
			eparam.set_ne_isnet("3");
			
		}else{
			eparam.set_ne_isnet("1");
		}
		DataPackage dp4 = employee.doQuery(eparam);
		if(null!=dp4&&dp4.getDatas().size()>0){
			EmployeeVO employeevo = (EmployeeVO)dp4.getDatas().iterator().next();
			officetel = employeevo.getOfficetel();
		}
		
//		划扣记录号取序列，
//		关联订单号留空，
//		银行代码取账户资料表中的卡类购销划扣银行标识[DEBANKID]，
//		银行账号取账户资料表中的卡类购销划扣银行账号，
//		帐号类型取账户资料表中的账号类型，
//		账户名称取账户资料表中的卡类购销划扣帐号名称，
//		划扣金额取上缴金额，
//		处理状态取待处理，
//		创建时间和状态变更时间取当前时间，
//		通知号码取已获取的手机号码，
//		商户号和终端号取已获取的商户信息。
		
		//新增划扣记录
		BankdeductVO bankdeductvo = new BankdeductVO();
		bankdeductvo.setOrderid(formid);
		bankdeductvo.setBankid(bankid);
		bankdeductvo.setAcctnum(acctnum);
		bankdeductvo.setAccttype(accttype);
		bankdeductvo.setAcctname(acctname);
		bankdeductvo.setDeductamt(bondformVO.getPayamt());
		bankdeductvo.setState("WAITPROC");
		bankdeductvo.setCreatdate(date);
		bankdeductvo.setStatechgtime(date);
		bankdeductvo.setCallnum(officetel);
		bankdeductvo.setShopnum(shopnum);
		bankdeductvo.setTerminalnum(terminalnum);
		bankdeductvo.setFormtype((short)2);
		bankdeduct.doCreate(bankdeductvo);
		
		
//		更新保证金申请单管理表(FX_SW_BONDFORM)的状态为待支付。
		 bondformVO.setState(Short.parseShort("7"));
		 this.doUpdate(bondformVO);
		
		return null;
	}
	
	
	
}
