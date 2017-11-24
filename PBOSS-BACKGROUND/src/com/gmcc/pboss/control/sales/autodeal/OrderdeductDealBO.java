package com.gmcc.pboss.control.sales.autodeal;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountDBParam;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountVO;
import com.gmcc.pboss.business.sales.bankdeduct.BankdeductDBParam;
import com.gmcc.pboss.business.sales.bankdeduct.BankdeductVO;
import com.gmcc.pboss.business.sales.bankshop.BankshopDBParam;
import com.gmcc.pboss.business.sales.bankshop.BankshopVO;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.wayaccount.Wayaccount;
import com.gmcc.pboss.control.channel.wayaccount.WayaccountBO;
import com.gmcc.pboss.control.sales.bankdeduct.Bankdeduct;
import com.gmcc.pboss.control.sales.bankdeduct.BankdeductBO;
import com.gmcc.pboss.control.sales.bankshop.Bankshop;
import com.gmcc.pboss.control.sales.bankshop.BankshopBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;





/**
 * <p>Title: OrderresdetBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class OrderdeductDealBO extends AbstractControlBean implements
			OrderDeal {
	public boolean doDeal(OrderVO orderVO, DBAccessUser user) throws Exception {
		Order order = (Order)BOFactory.build(OrderBO.class, user);
		
		//1)��黮�ۼ�¼�Ƿ����
		Bankdeduct bankdeduct = (Bankdeduct)BOFactory.build(BankdeductBO.class, user);
		BankdeductDBParam param = new BankdeductDBParam();
		param.set_se_orderid(orderVO.getOrderid());
		DataPackage dp = (DataPackage)bankdeduct.doQuery(param);
		//���ۼ�¼������
		if(dp.getDatas().size()>0)
		{
			orderVO.setMemo("���ۼ�¼�Ѵ���!");
			order.doUpdate(orderVO);
			return false;
		}
		
		//2)�˻����ϼ��
		Wayaccount wayaccount = (Wayaccount)BOFactory.build(WayaccountBO.class, user);
		WayaccountDBParam param2 = new WayaccountDBParam();
		param2.set_se_wayid(orderVO.getWayid());
		DataPackage dp2 = (DataPackage)wayaccount.doQuery(param2);
		//�˻����ϲ�����
		if(dp2.getRowCount()==0)
		{
			orderVO.setMemo("�������˻����ϲ�����");
			order.doUpdate(orderVO);
			return false;
		}
		
		WayaccountVO wayaccountVO = (WayaccountVO) ((List)dp2.getDatas()).get(0);
		//�ʺ����Ͳ�����
		if(wayaccountVO.getAccttype()==null)
		{
			orderVO.setMemo("�ʺ�����Ϊ��");
			order.doUpdate(orderVO);
			return false;
		}
		//�˺Ų�����
		if(StringUtils.isEmpty(wayaccountVO.getDeacctno()))
		{
			orderVO.setMemo("�����˺�Ϊ��");
			order.doUpdate(orderVO);
			return false;
		}
		//�˻����Ʋ�����
		if(StringUtils.isEmpty(wayaccountVO.getDeacctname()))
		{
			orderVO.setMemo("�ʺ�����Ϊ��");
			order.doUpdate(orderVO);
			return false;
		}
		
		//���๺���������б�ʶ������
		if(StringUtils.isEmpty(wayaccountVO.getDebankid())){
			orderVO.setMemo("���б�ʶΪ��");
			order.doUpdate(orderVO);
			return false;
		}
		
		String callnum = "";
		Employee employee = (Employee)BOFactory.build(EmployeeBO.class, user);
		EmployeeDBParam employeeparam = new EmployeeDBParam();
		employeeparam.set_ne_isnet("1");
		employeeparam.set_ne_empstatus("0");
		employeeparam.set_se_wayid(orderVO.getWayid());
		DataPackage empdp = employee.doQuery(employeeparam);
		if(empdp.getDatas().size()>0){
			EmployeeVO employeevo = (EmployeeVO)empdp.getDatas().get(0);
			callnum = employeevo.getOfficetel();
		}
		
		Bankshop bankshop = (Bankshop)BOFactory.build(BankshopBO.class, user);
		BankshopDBParam bankshopparam = new BankshopDBParam();
		bankshopparam.set_se_cityid(user.getCityid());
		bankshopparam.set_se_countyid(orderVO.getCountyid());
		DataPackage bankshopdp = (DataPackage)bankshop.doQuery(bankshopparam);
		if(bankshopdp.getRowCount()==0)
		{
			orderVO.setMemo("�޷���ȡ�����̻���Ϣ");
			order.doUpdate(orderVO);
			return false;
		}
		BankshopVO bankshopvo = (BankshopVO) ((List)bankshopdp.getDatas()).get(0);
		//3)�������ۼ�¼
		BankdeductVO bankdeductVO = new BankdeductVO();
		bankdeductVO.setOrderid(orderVO.getOrderid());
		bankdeductVO.setAccttype(wayaccountVO.getAccttype());
		bankdeductVO.setAcctnum(wayaccountVO.getDeacctno());
		bankdeductVO.setAcctname(wayaccountVO.getDeacctname());
		bankdeductVO.setDeductamt(orderVO.getRecamt());
		bankdeductVO.setState(OrderDealConstant.STATE_BANKDEDUCT_WAITPROC);
		Date now = new Date();
		bankdeductVO.setCreatdate(now);
		bankdeductVO.setStatechgtime(now);
		bankdeductVO.setShopnum(bankshopvo.getShopnum());
		bankdeductVO.setTerminalnum(bankshopvo.getTerminalnum());
		bankdeductVO.setCallnum(callnum);
		bankdeductVO.setBankid(wayaccountVO.getDebankid());
		bankdeductVO.setFormtype((short)0);
		bankdeduct.doCreate(bankdeductVO);
		
		//4)���¶�����Ϣ
		orderVO.setOrderstate(OrderDealConstant.STATE_ORDER_DEDUCTING);
		orderVO.setStatechgtime(now);
		order.doUpdate(orderVO);
		
		return true;
	}
}