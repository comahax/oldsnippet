/**
 * auto-generated code
 * Tue Aug 24 11:24:17 CST 2010
 */
package com.gmcc.pboss.control.sales.bankdeduct;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountDBParam;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountVO;
import com.gmcc.pboss.business.sales.bankdeduct.BankdeductDAO;
import com.gmcc.pboss.business.sales.bankdeduct.BankdeductDBParam;
import com.gmcc.pboss.business.sales.bankdeduct.BankdeductVO;
import com.gmcc.pboss.business.sales.bankrecord.BankrecordDBParam;
import com.gmcc.pboss.business.sales.bankshop.BankshopDBParam;
import com.gmcc.pboss.business.sales.bankshop.BankshopVO;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.wayaccount.Wayaccount;
import com.gmcc.pboss.control.channel.wayaccount.WayaccountBO;
import com.gmcc.pboss.control.sales.bankshop.Bankshop;
import com.gmcc.pboss.control.sales.bankshop.BankshopBO;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: BankdeductBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class BankdeductBO extends AbstractControlBean implements
		Bankdeduct {

	public BankdeductVO doCreate(BankdeductVO vo) throws Exception {
		try {
			BankdeductDAO dao = (BankdeductDAO) DAOFactory.build(BankdeductDAO.class, user);
			// TODO set the pk */
			return (BankdeductVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(BankdeductVO vo) throws Exception {
		try {
			BankdeductDAO dao = (BankdeductDAO) DAOFactory.build(BankdeductDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			BankdeductDAO dao = (BankdeductDAO) DAOFactory.build(BankdeductDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BankdeductVO doUpdate(BankdeductVO vo) throws Exception {
		try {
			BankdeductDAO dao = (BankdeductDAO) DAOFactory.build(BankdeductDAO.class,user);
			return (BankdeductVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BankdeductVO doFindByPk(Serializable pk) throws Exception {
		BankdeductDAO dao = (BankdeductDAO) DAOFactory.build(BankdeductDAO.class,user);
		return (BankdeductVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(BankdeductDBParam params)
			throws Exception {
		BankdeductDAO dao = (BankdeductDAO) DAOFactory.build(BankdeductDAO.class,user);
		return dao.query(params);
	}
	
	//触发划扣
	public void doDeduct(OrderVO vo) throws Exception {
		try {
			//银行划扣记录检查
			Bankdeduct bankdeduct = (Bankdeduct)BOFactory.build(BankdeductBO.class, user);
			BankdeductDBParam param = new BankdeductDBParam();
			param.set_se_orderid(vo.getOrderid());
			DataPackage dp1 = bankdeduct.doQuery(param);
			if(null!=dp1&&dp1.getDatas().size()>0){
				List<BankdeductVO> blist = dp1.getDatas();
				for(BankdeductVO bankdeductvo : blist){
					if(!bankdeductvo.getState().equals("PROCOVER") && !bankdeductvo.getState().equals("CANCEL")){
						throw new Exception("订单["+vo.getOrderid()+"]存在未完成的划扣记录，请检查。");
					}
					if("00".equals(bankdeductvo.getRespcode())){
						throw new Exception("订单["+vo.getOrderid()+"]存在划扣成功记录，不允许重复划扣，请检查。");
					}
				}
			}
			//检查账户资料
			String bankid;//银行代码
			String acctnum;//银行账号
			Short accttype;//帐号类型
			String acctname;//账户名称
			Wayaccount wayaccount = (Wayaccount)BOFactory.build(WayaccountBO.class, user);
			WayaccountDBParam wparam = new WayaccountDBParam();
			wparam.set_se_wayid(vo.getWayid());
			DataPackage dp2 = wayaccount.doQuery(wparam);
			if(null!=dp2&&dp2.getDatas().size()>0){
				WayaccountVO wayaccountvo = (WayaccountVO)dp2.getDatas().iterator().next();
				if(StringUtils.isBlank(wayaccountvo.getAccttype().toString()))
					throw new Exception("合作商["+vo.getWayid()+"]帐号类型为空");
				accttype = wayaccountvo.getAccttype();
				if(StringUtils.isBlank(wayaccountvo.getDeacctno()))
					throw new Exception("合作商["+vo.getWayid()+"]银行账号为空");
				acctnum = wayaccountvo.getDeacctno();
				if(StringUtils.isBlank(wayaccountvo.getDeacctname()))
					throw new Exception("合作商["+vo.getWayid()+"]帐号名称为空");
				acctname = wayaccountvo.getDeacctname();
				if(StringUtils.isBlank(wayaccountvo.getDebankid()))
					throw new Exception("合作商["+vo.getWayid()+"]银行标识为空");
				bankid = wayaccountvo.getDebankid();
			}else{
				throw new Exception("合作商["+vo.getWayid()+"]账户资料不存在");
			}
			//获取银行商户信息
			String shopnum;//商户号
			String terminalnum;//终端号
			Bankshop bankshop = (Bankshop)BOFactory.build(BankshopBO.class, user);
			BankshopDBParam bparam = new BankshopDBParam();
			bparam.set_se_cityid(user.getCityid());
			bparam.set_se_countyid(vo.getCountyid());
			DataPackage dp3 = bankshop.doQuery(bparam);
			if(null!=dp3&&dp3.getDatas().size()>0){
				BankshopVO bankshopvo = (BankshopVO)dp3.getDatas().iterator().next();
				shopnum = bankshopvo.getShopnum();
				terminalnum = bankshopvo.getTerminalnum();
			}else{
				throw new Exception("无法获取合作商["+vo.getWayid()+"]对应的银行商户信息");
			}
			//获取手机号码
			String officetel = "";//手机号码
			Employee employee = (Employee)BOFactory.build(EmployeeBO.class, user);
			EmployeeDBParam eparam = new EmployeeDBParam();
			eparam.set_se_wayid(vo.getWayid());
			eparam.set_ne_empstatus("0");
			eparam.set_ne_isnet("1");
			DataPackage dp4 = employee.doQuery(eparam);
			if(null!=dp4&&dp4.getDatas().size()>0){
				EmployeeVO employeevo = (EmployeeVO)dp4.getDatas().iterator().next();
				officetel = employeevo.getOfficetel();
			}
			//新增划扣记录
			BankdeductVO bankdeductvo = new BankdeductVO();
			bankdeductvo.setOrderid(vo.getOrderid());
			bankdeductvo.setBankid(bankid);
			bankdeductvo.setAcctnum(acctnum);
			bankdeductvo.setAccttype(accttype);
			bankdeductvo.setAcctname(acctname);
			bankdeductvo.setDeductamt(vo.getRecamt());
			bankdeductvo.setState("WAITPROC");
			bankdeductvo.setCreatdate(new Date());
			bankdeductvo.setStatechgtime(new Date());
			bankdeductvo.setCallnum(officetel);
			bankdeductvo.setShopnum(shopnum);
			bankdeductvo.setTerminalnum(terminalnum);
			bankdeduct.doCreate(bankdeductvo);
		} catch (Exception ex) {
			throw new JOPException(ex.getMessage());
		}
	}
	
	public DataPackage doDeduct(BankdeductDBParam params) throws Exception {
		BankdeductDAO dao = (BankdeductDAO) DAOFactory.build(BankdeductDAO.class, user);
		return dao.doDeduct(params);
	}
}
