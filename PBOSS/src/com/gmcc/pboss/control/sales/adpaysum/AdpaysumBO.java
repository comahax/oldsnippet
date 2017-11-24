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

	// ִ��ȷ��
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
						throw new Exception("��ȡ����[" + orderid + "]����ʧ��.");
					} else {
						opparam.set_ne_flowid(ordervo.getFlowid().toString());
						opparam.set_se_outstate("CHARGED");
						DataPackage dp2 = orderproce.doQuery(opparam);
						if (null == dp2 || dp2.getRowCount() < 1) {
							throw new Exception("��ȡ����[" + orderid
									+ "]���̲�������ʧ��.");
						} else {
							OrderproceVO opvo = (OrderproceVO) dp2.getDatas()
									.get(0);

							if (!opvo.getInstate().equals(
									ordervo.getOrderstate())) {
								throw new Exception("����[" + orderid + "]״̬����.");
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
			// �޸Ļ��ܱ�״̬Ϊ����ȷ�ϡ�
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
				throw new Exception("����������ܵ���Ϊ��");
			}
			// 1)��ȡ������Ϣ--���ݻ��ܵ��Ų�ѯ���ʶ�����ϸ�� (FX_SW_ADPAYDET)��ȡ������Ϣ
			
			// 2)��黮�ۼ�¼�Ƿ����:�����ڽ�����һ�������ڣ����ش�����Ϣ�����ۼ�¼�Ѵ��ڡ�				
			Bankdeduct bankdeduct = (Bankdeduct) BOFactory.build(BankdeductBO.class, user);
			BankdeductDBParam bankdeductDBParam = new BankdeductDBParam();
			bankdeductDBParam.set_se_orderid(sumid);
			//bankdeductDBParam.setQueryAll(true);
			bankdeductDBParam.set_pagesize("0");
			bankdeductDBParam.setDataOnly(true);
			DataPackage dpBankdeduct = bankdeduct.doQuery(bankdeductDBParam);
			if (null != dpBankdeduct && dpBankdeduct.getDatas().size() > 0) {
				throw new Exception("���ܵ���[" + sumid + "]���ۼ�¼�Ѵ���");
			}
			
			AdpaysumVO adpaysumVO = this.doFindByPk(new Long(sumid));
			if(adpaysumVO==null){
				throw new Exception("����������ܵ������󣬵��ʻ��ܵ���¼������");
			}
			// 3)��ȡ�˻�����
			String wayid = adpaysumVO.getDiscomcode();// �����̱���
			Wayaccount wayaccount = (Wayaccount) BOFactory.build(WayaccountBO.class, user);
			WayaccountDBParam wayaccountDBParam = new WayaccountDBParam();
			wayaccountDBParam.set_se_wayid(wayid);
			//wayaccountDBParam.setQueryAll(true);
			wayaccountDBParam.set_pagesize("0");
			wayaccountDBParam.setDataOnly(true);
			DataPackage dpWayaccount = wayaccount.doQuery(wayaccountDBParam);
			if (null == dpWayaccount || dpWayaccount.getDatas().size() < 1) {
				throw new Exception("[" + wayid + "]�������˻����ϲ�����");
			}
			WayaccountVO wayaccountVO = (WayaccountVO) dpWayaccount.getDatas().get(0);
			if (null == wayaccountVO.getAccttype()) {
				throw new Exception("[" + wayid + "]�������˻������ʺ�����Ϊ��");
			}
			if (StringUtils.isEmpty(wayaccountVO.getDeacctno())) {
				throw new Exception("[" + wayid + "]�������˻����������˺�Ϊ��");
			}
			if (StringUtils.isEmpty(wayaccountVO.getDeacctname())) {
				throw new Exception("[" + wayid + "]�������˻������ʺ�����Ϊ��");
			}
			if (StringUtils.isEmpty(wayaccountVO.getDebankid())) {
				throw new Exception("[" + wayid + "]�������˻��������б�ʶΪ��");
			}
			
			// 4)��ȡ�����̻���Ϣ
			Way way = (Way) BOFactory.build(WayBO.class, user);
			WayVO wayVO = way.doFindByPk(wayid);
			if (wayVO == null) {
				throw new Exception("������[" + wayid + "]������Ϣ������");
			}
			Bankshop bankshop = (Bankshop) BOFactory.build(BankshopBO.class,user);
			BankshopDBParam bankshopDBParam = new BankshopDBParam();
			if(StringUtils.isEmpty(wayVO.getCountyid())){
				throw new Exception("������[" + wayid + "]�ֹ�˾��ϢΪ��");
			}
			bankshopDBParam.set_se_countyid(wayVO.getCountyid());
			bankshopDBParam.set_se_cityid(user.getCityid());
			//bankshopDBParam.setQueryAll(true);
			bankshopDBParam.set_pagesize("0");
			bankshopDBParam.setDataOnly(true);
			DataPackage dpBankshop = bankshop.doQuery(bankshopDBParam);
			if (dpBankshop == null || dpBankshop.getDatas().size() < 1) {
				throw new Exception("[�й�˾"+user.getCityid()+",�ֹ�˾"+ wayVO.getCountyid() + "]�����̻���Ϣ");
			}
			BankshopVO bankshopVO = (BankshopVO) dpBankshop.getDatas().get(0);
			
			// 5)��ȡ�ֻ�����
			String officetel = "";
			Employee employee = (Employee) BOFactory.build(EmployeeBO.class,user);
			EmployeeDBParam employeeDBParam = new EmployeeDBParam();
			employeeDBParam.set_se_wayid(adpaysumVO.getDiscomcode());// �����̱���
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
			
			// 6)�������ۼ�¼
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
			//���µ��ʶ������ܱ� (FX_SW_ADPAYSUM)����Ϣ��֧����Ϊ��ǰ�����ˣ�֧��ʱ��Ϊ��ǰʱ�䣻
			//֧����ʽΪ���л��ۣ��Ѹ����ΪӦ�ս�֧��״̬Ϊ��֧��
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
