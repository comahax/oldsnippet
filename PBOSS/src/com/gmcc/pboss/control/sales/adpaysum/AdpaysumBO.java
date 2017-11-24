/**
 * auto-generated code
 * Wed Apr 28 12:20:30 CST 2010
 */
package com.gmcc.pboss.control.sales.adpaysum;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.sunrise.jop.common.utils.lang.StringUtils;

import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountDBParam;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountVO;
import com.gmcc.pboss.business.sales.adpaydet.AdpaydetDBParam;
import com.gmcc.pboss.business.sales.adpaydet.AdpaydetVO;
import com.gmcc.pboss.business.sales.adpaysum.AdpaysumDAO;
import com.gmcc.pboss.business.sales.adpaysum.AdpaysumDBParam;
import com.gmcc.pboss.business.sales.adpaysum.AdpaysumVO;
import com.gmcc.pboss.business.sales.bankdeduct.BankdeductDBParam;
import com.gmcc.pboss.business.sales.bankdeduct.BankdeductVO;
import com.gmcc.pboss.business.sales.bankshop.BankshopDBParam;
import com.gmcc.pboss.business.sales.bankshop.BankshopVO;
import com.gmcc.pboss.business.sales.order.OrderDAO;
import com.gmcc.pboss.business.sales.order.OrderDBParam;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.orderproce.OrderproceDBParam;
import com.gmcc.pboss.business.sales.orderproce.OrderproceVO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.channel.wayaccount.Wayaccount;
import com.gmcc.pboss.control.channel.wayaccount.WayaccountBO;
import com.gmcc.pboss.control.sales.adpaydet.Adpaydet;
import com.gmcc.pboss.control.sales.adpaydet.AdpaydetBO;
import com.gmcc.pboss.control.sales.bankdeduct.Bankdeduct;
import com.gmcc.pboss.control.sales.bankdeduct.BankdeductBO;
import com.gmcc.pboss.control.sales.bankshop.Bankshop;
import com.gmcc.pboss.control.sales.bankshop.BankshopBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.orderproce.Orderproce;
import com.gmcc.pboss.control.sales.orderproce.OrderproceBO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: AdpaysumBO
 * </p>
 * ;
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
 * @author Yedaoe
 * @version 1.0
 */
public class AdpaysumBO extends AbstractControlBean implements Adpaysum {

	public AdpaysumVO doCreate(AdpaysumVO vo) throws Exception {
		try {
			AdpaysumDAO dao = (AdpaysumDAO) DAOFactory.build(AdpaysumDAO.class,
					user);
			// TODO set the pk */
			return (AdpaysumVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(AdpaysumVO vo) throws Exception {
		try {
			AdpaysumDAO dao = (AdpaysumDAO) DAOFactory.build(AdpaysumDAO.class,
					user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			AdpaysumDAO dao = (AdpaysumDAO) DAOFactory.build(AdpaysumDAO.class,
					user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public AdpaysumVO doUpdate(AdpaysumVO vo) throws Exception {
		try {
			AdpaysumDAO dao = (AdpaysumDAO) DAOFactory.build(AdpaysumDAO.class,
					user);
			return (AdpaysumVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public AdpaysumVO doFindByPk(Serializable pk) throws Exception {
		AdpaysumDAO dao = (AdpaysumDAO) DAOFactory.build(AdpaysumDAO.class,
				user);
		return (AdpaysumVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(AdpaysumDBParam params) throws Exception {
		AdpaysumDAO dao = (AdpaysumDAO) DAOFactory.build(AdpaysumDAO.class,
				user);
		return dao.query(params);
	}

	// 执行确认
	public void doConfirm(String sumid) throws Exception {
		try {
			Adpaysum adpaysum = (Adpaysum) BOFactory.build(AdpaysumBO.class,
					user);
			Adpaydet adpaydet = (Adpaydet) BOFactory.build(AdpaydetBO.class,
					user);
			Order order = (Order) BOFactory.build(OrderBO.class, user);
			Orderproce orderproce = (Orderproce) BOFactory.build(
					OrderproceBO.class, user);
			DataPackage dp = new DataPackage();
			AdpaydetDBParam param = new AdpaydetDBParam();
			AdpaysumVO adpaysumvo = new AdpaysumVO();
			OrderproceDBParam opparam = new OrderproceDBParam();
			param.set_ne_sumid(sumid);
			dp = adpaydet.doQuery(param);
			if (null != dp && dp.getRowCount() > 0) {
				List<AdpaydetVO> adpaydetList = dp.getDatas();
				for (AdpaydetVO adpaydetvo : adpaydetList) {
					String orderid = adpaydetvo.getOrderid();
					OrderVO ordervo = order.doFindByPk(orderid);
					if (null == ordervo) {
						throw new Exception("获取订单[" + orderid + "]数据失败.");
					} else {
						opparam.set_ne_flowid(ordervo.getFlowid().toString());
						opparam.set_se_outstate("CHARGED");
						DataPackage dp2 = orderproce.doQuery(opparam);
						if (null == dp2 || dp2.getRowCount() < 1) {
							throw new Exception("获取订单[" + orderid
									+ "]流程步骤数据失败.");
						} else {
							OrderproceVO opvo = (OrderproceVO) dp2.getDatas()
									.get(0);

							if (!opvo.getInstate().equals(
									ordervo.getOrderstate())) {
								throw new Exception("订单[" + orderid + "]状态错误.");
							} else {
								ordervo.setActamt(ordervo.getRecamt());
								ordervo.setOrderstate("CHARGED");
								ordervo.setStatechgtime(new Date());
								ordervo.setPaytime(new Date());
								order.doUpdate(ordervo);
								order.doNextProcess(orderid);
							}
						}
					}
				}
			}
			adpaysumvo = adpaysum.doFindByPk(new Long(sumid));
			// 修改汇总表状态为“已确认”
			adpaysumvo.setState("CONFIRMED");
			adpaysumvo.setConfirmcode(user.getOprcode());
			adpaysumvo.setConfirmtime(new Date());
			adpaysum.doUpdate(adpaysumvo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doPay(String sumid) throws Exception {
		try {
			if(StringUtils.isEmpty(sumid)){
				throw new Exception("传入参数汇总单号为空");
			}
			// 1)获取订单信息--根据汇总单号查询垫资订单明细表 (FX_SW_ADPAYDET)获取订单信息
			
			// 2)检查划扣记录是否存在:不存在进入下一步；存在，返回错误信息“划扣记录已存在”				
			Bankdeduct bankdeduct = (Bankdeduct) BOFactory.build(BankdeductBO.class, user);
			BankdeductDBParam bankdeductDBParam = new BankdeductDBParam();
			bankdeductDBParam.set_se_orderid(sumid);
			//bankdeductDBParam.setQueryAll(true);
			bankdeductDBParam.set_pagesize("0");
			bankdeductDBParam.setDataOnly(true);
			DataPackage dpBankdeduct = bankdeduct.doQuery(bankdeductDBParam);
			if (null != dpBankdeduct && dpBankdeduct.getDatas().size() > 0) {
				throw new Exception("汇总单号[" + sumid + "]划扣记录已存在");
			}
			
			AdpaysumVO adpaysumVO = this.doFindByPk(new Long(sumid));
			if(adpaysumVO==null){
				throw new Exception("传入参数汇总单号有误，垫资汇总单记录不存在");
			}
			// 3)获取账户资料
			String wayid = adpaysumVO.getDiscomcode();// 配送商编码
			Wayaccount wayaccount = (Wayaccount) BOFactory.build(WayaccountBO.class, user);
			WayaccountDBParam wayaccountDBParam = new WayaccountDBParam();
			wayaccountDBParam.set_se_wayid(wayid);
			//wayaccountDBParam.setQueryAll(true);
			wayaccountDBParam.set_pagesize("0");
			wayaccountDBParam.setDataOnly(true);
			DataPackage dpWayaccount = wayaccount.doQuery(wayaccountDBParam);
			if (null == dpWayaccount || dpWayaccount.getDatas().size() < 1) {
				throw new Exception("[" + wayid + "]合作商账户资料不存在");
			}
			WayaccountVO wayaccountVO = (WayaccountVO) dpWayaccount.getDatas().get(0);
			if (null == wayaccountVO.getAccttype()) {
				throw new Exception("[" + wayid + "]合作商账户资料帐号类型为空");
			}
			if (StringUtils.isEmpty(wayaccountVO.getDeacctno())) {
				throw new Exception("[" + wayid + "]合作商账户资料银行账号为空");
			}
			if (StringUtils.isEmpty(wayaccountVO.getDeacctname())) {
				throw new Exception("[" + wayid + "]合作商账户资料帐号名称为空");
			}
			if (StringUtils.isEmpty(wayaccountVO.getDebankid())) {
				throw new Exception("[" + wayid + "]合作商账户资料银行标识为空");
			}
			
			// 4)获取银行商户信息
			Way way = (Way) BOFactory.build(WayBO.class, user);
			WayVO wayVO = way.doFindByPk(wayid);
			if (wayVO == null) {
				throw new Exception("配送商[" + wayid + "]渠道信息不存在");
			}
			Bankshop bankshop = (Bankshop) BOFactory.build(BankshopBO.class,user);
			BankshopDBParam bankshopDBParam = new BankshopDBParam();
			if(StringUtils.isEmpty(wayVO.getCountyid())){
				throw new Exception("配送商[" + wayid + "]分公司信息为空");
			}
			bankshopDBParam.set_se_countyid(wayVO.getCountyid());
			bankshopDBParam.set_se_cityid(user.getCityid());
			//bankshopDBParam.setQueryAll(true);
			bankshopDBParam.set_pagesize("0");
			bankshopDBParam.setDataOnly(true);
			DataPackage dpBankshop = bankshop.doQuery(bankshopDBParam);
			if (dpBankshop == null || dpBankshop.getDatas().size() < 1) {
				throw new Exception("[市公司"+user.getCityid()+",分公司"+ wayVO.getCountyid() + "]银行商户信息");
			}
			BankshopVO bankshopVO = (BankshopVO) dpBankshop.getDatas().get(0);
			
			// 5)获取手机号码
			String officetel = "";
			Employee employee = (Employee) BOFactory.build(EmployeeBO.class,user);
			EmployeeDBParam employeeDBParam = new EmployeeDBParam();
			employeeDBParam.set_se_wayid(adpaysumVO.getDiscomcode());// 配送商编码
			employeeDBParam.set_ne_empstatus("0");
			employeeDBParam.set_ne_isnet("3");
			//employeeDBParam.setQueryAll(true);
			employeeDBParam.set_pagesize("0");
			employeeDBParam.setDataOnly(true);
			DataPackage dpEmployee = employee.doQuery(employeeDBParam);
			if (null != dpEmployee && dpEmployee.getDatas().size() > 0) {
				EmployeeVO employeevo = (EmployeeVO) dpEmployee.getDatas().get(0);
				officetel = employeevo.getOfficetel();
			}
			
			// 6)新增划扣记录
			BankdeductVO bankdeductvo = new BankdeductVO();
			bankdeductvo.setOrderid(adpaysumVO.getSumid().toString());
			bankdeductvo.setBankid(wayaccountVO.getDebankid());
			bankdeductvo.setAcctnum(wayaccountVO.getDeacctno());
			bankdeductvo.setAccttype(wayaccountVO.getAccttype());
			bankdeductvo.setAcctname(wayaccountVO.getDeacctname());
			bankdeductvo.setDeductamt(adpaysumVO.getRecamt());
			bankdeductvo.setState("WAITPROC");
			bankdeductvo.setCreatdate(new Date());
			bankdeductvo.setStatechgtime(new Date());
			bankdeductvo.setCallnum(officetel);
			bankdeductvo.setShopnum(bankshopVO.getShopnum());
			bankdeductvo.setTerminalnum(bankshopVO.getTerminalnum());
			bankdeductvo.setFormtype((short)1);
			bankdeduct.doCreate(bankdeductvo);
			//更新垫资订单汇总表 (FX_SW_ADPAYSUM)表信息，支付人为当前操作人；支付时间为当前时间；
			//支付方式为银行划扣；已付金额为应收金额；支付状态为已支付
			adpaysumVO.setPaymentcode(user.getOprcode());
			adpaysumVO.setPaymenttime(new Date());
			adpaysumVO.setPaymentmode("BANK");
			adpaysumVO.setPrepaidlamt(adpaysumVO.getRecamt());
//			adpaysumVO.setState("PAYMENT");
			adpaysumVO.setState("WAITPAYMENT");
			
			
			this.doUpdate(adpaysumVO);
		} catch (Exception e) {
			throw new JOPException(e);
		}
	}
}
