package com.gmcc.pboss.control.service.sms.secconfirm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.orderproce.OrderproceDBParam;
import com.gmcc.pboss.business.sales.orderproce.OrderproceVO;
import com.gmcc.pboss.business.sales.smsconfirm.SmsconfirmDBParam;
import com.gmcc.pboss.business.sales.smsconfirm.SmsconfirmVO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.orderproce.Orderproce;
import com.gmcc.pboss.control.sales.orderproce.OrderproceBO;
import com.gmcc.pboss.control.sales.smsconfirm.Smsconfirm;
import com.gmcc.pboss.control.sales.smsconfirm.SmsconfirmBO;
import com.gmcc.pboss.control.service.sms.ServiceSmsBOHelper;
import com.gmcc.pboss.service.sms.exception.SMSException;
import com.gmcc.pboss.service.sms.result.SMSResult;
import com.gmcc.pboss.service.sms.result.SecondConfirmResult;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.common.utils.logging.LoggingConstant;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class SMSComOrderSecondConfirmBO extends AbstractControlBean implements
		SMSComOrderSecondConfirm {
	
	private static Logger logger = Logger.getLogger(SMSComOrderSecondConfirmBO.class);
	private static String TITLE_COLUMNSIZE = "������"
			+ SMSProtocol.WORD_SLIT_SYMBOL + "�ͻ�����"
			+ SMSProtocol.WORD_END_SYMBOL + "20" + SMSProtocol.WORD_SLIT_SYMBOL
			+ "30";
	
	public String doResult(String mobile, String streamNumber) throws Exception {
		
		try {
			logger = ServiceSmsBOHelper.createChildLogger(user.getCityid()
					+ LoggingConstant.SMS_CITY_LOG_ROOT_NAME, this.getClass()
					.getSimpleName());
			String customerName = this.getCustomerName(mobile);
			SmsconfirmVO scVO = this.updateMSConfirmInfo(mobile, streamNumber, customerName);
			this.checkOvertime(scVO.getSendtime(), customerName);
			this.orderConfirm(scVO.getOrderid(), customerName);
			this.nextProcess(scVO.getOrderid());
			return this.doReturnSuccVal(scVO.getOrderid(),customerName).toString();
			
		}catch(SMSException e) {
			// SMSException ����Ҫ�ع�����
			logger.info(e.getMessage());
			return ((SMSException)e).getErrCode() + SMSProtocol.WORD_SLIT_SYMBOL + ((SMSException)e).getMessage() + SMSProtocol.WORD_END_SYMBOL;
		}
		catch(Exception e) {
			LoggerUtils.error(e, logger);
			throw e;
		}
	}
	
	
	private String getCustomerName(String mobile) throws Exception {
		Employee eBO = (Employee)BOFactory.build(EmployeeBO.class, user);
		EmployeeDBParam eParam = new EmployeeDBParam();
		eParam.set_se_officetel(mobile);
		eParam.set_ne_empstatus("0");
		eParam.set_ne_isnet("1");
		eParam.setDataOnly(true);
		DataPackage edp = eBO.doQuery(eParam);
		List<EmployeeVO> elist = edp.getDatas();
		String cutomerName = "�ͻ�";
		if(elist.size() > 0) {
			EmployeeVO empVO = elist.get(0);
			if(!StringUtils.isEmpty(empVO.getEmployeename())) {
				cutomerName = empVO.getEmployeename();
			}
		}
		return cutomerName;
	}
	/**
	 * ���¶���ȷ����Ϣ
	 * @param mobile
	 * @param streamNumber
	 * @param customerName �ͻ�����
	 * @return ֪ͨʱ��
	 * @throws Exception
	 */
	private SmsconfirmVO updateMSConfirmInfo(String mobile, String streamNumber, String customerName) throws Exception {
		
		Smsconfirm scBO = (Smsconfirm)BOFactory.build(SmsconfirmBO.class,user, BOFactory.PROPAGATION_REQUIRES_NEW);
		SmsconfirmDBParam scParam = new SmsconfirmDBParam();
		scParam.set_se_type("ORDERCON");
		scParam.set_se_mobileno(mobile);
		scParam.set_se_stream(streamNumber);
		scParam.set_se_state("WAITREP");
		scParam.set_dnl_sendtime(PublicUtils.formatUtilDate(new Date(), "yyyy-MM-dd")+" 00:00:00");
		scParam.set_orderby("sendtime"); // ��֪ͨʱ����������
		scParam.setDataOnly(true);
		scParam.set_pagesize("0");
		DataPackage dp = scBO.doQuery(scParam);
		List list = dp.getDatas();
		if(list == null || list.size() <= 0) {
			String message = "ȷ�ϼ�¼������" + SMSProtocol.WORD_END_SYMBOL
			+ TITLE_COLUMNSIZE + SMSProtocol.WORD_END_SYMBOL
			+ SMSProtocol.WORD_SLIT_SYMBOL + customerName;
			throw new SMSException(message,SecondConfirmResult.RET_TYPE_FAIL_1);
		}else {
			SmsconfirmVO scVO = (SmsconfirmVO)list.get(0); // ȡ֪ͨʱ�������һ��
			scVO.setReptime(new Date());
			scVO.setState("REPLIED");
			scVO.setRepdesc("ȷ�϶���");
			return scBO.doUpdate(scVO);
		}
	
	}
	/**
	 * ��ʱ���
	 * @param sendtime ֪ͨʱ��
	 * @throws Exception
	 */
	private void checkOvertime(Date sendtime, String customerName) throws Exception {
		Sysparam spBO = (Sysparam)BOFactory.build(SysparamBO.class, user);
		String overtimeValue = spBO.doFindByID(41L, "pboss_fx");
		if(overtimeValue == null || "".equals(overtimeValue) 
				|| Integer.parseInt(overtimeValue) <= 0) {
			overtimeValue = "20";
		}
		double interval = PublicUtils.compareMinute(sendtime, new Date());
		if(interval > Double.parseDouble(overtimeValue)) {
			String message = "ȷ�ϳ�ʱ" + SMSProtocol.WORD_END_SYMBOL
			+ TITLE_COLUMNSIZE + SMSProtocol.WORD_END_SYMBOL
			+ SMSProtocol.WORD_SLIT_SYMBOL + customerName;
			throw new SMSException(message,SecondConfirmResult.RET_TYPE_FAIL_2);
		}
	}
	/**
	 * ����ȷ��
	 * @param orderid
	 * @throws Exception
	 */
	private void orderConfirm(String orderid, String customerName) throws Exception {
		Order orderBO = (Order)BOFactory.build(OrderBO.class, user);
		OrderVO orderVO = orderBO.doFindByPk(orderid);
		if(orderVO == null) {
			String message = "������Ϣ������" + SMSProtocol.WORD_END_SYMBOL
			+ TITLE_COLUMNSIZE + SMSProtocol.WORD_END_SYMBOL
			+ SMSProtocol.WORD_SLIT_SYMBOL + customerName;
			throw new SMSException(message,SecondConfirmResult.RET_TYPE_FAIL_3);
		}
		
		if(!"WAITCON".equals(orderVO.getOrderstate())) {
			String message = "����״̬����" + SMSProtocol.WORD_END_SYMBOL
			+ TITLE_COLUMNSIZE + SMSProtocol.WORD_END_SYMBOL + orderVO.getOrderid()
			+ SMSProtocol.WORD_SLIT_SYMBOL + customerName;
			throw new SMSException(message,SecondConfirmResult.RET_TYPE_FAIL_4);
		}
		
		Orderproce opBO = (Orderproce)BOFactory.build(OrderproceBO.class, user);
		OrderproceDBParam opParam = new OrderproceDBParam();
		opParam.set_ne_flowid(orderVO.getFlowid().toString());
		opParam.set_se_instate("WAITCON");
		opParam.setDataOnly(true);
		opParam.set_pagesize("0");
		DataPackage dp = opBO.doQuery(opParam);
		List list = dp.getDatas();
		if(list == null || list.size() <= 0) {
			String message = "�������̴���" + SMSProtocol.WORD_END_SYMBOL
			+ TITLE_COLUMNSIZE + SMSProtocol.WORD_END_SYMBOL + orderVO.getOrderid()
			+ SMSProtocol.WORD_SLIT_SYMBOL + customerName;
			throw new SMSException(message,SecondConfirmResult.RET_TYPE_FAIL_4);
		}
		
		OrderproceVO opVO = (OrderproceVO)list.get(0);
		orderVO.setOrderstate(opVO.getOutstate());
		orderVO.setConfirmflag(1);//���Ƿ�ȷ���޸�Ϊ1���ǣ�
		orderVO.setStatechgtime(new Date());//��״̬���ʱ���޸�Ϊ��ǰʱ�� by yde
		orderBO.doUpdate(orderVO);
		
	}
	/**
	 * ���ö�����һ������
	 * @param orderid
	 * @throws Exception
	 */
	private void nextProcess(String orderid) throws Exception {
		
		Order orderBO = (Order)BOFactory.build(OrderBO.class, user);
		orderBO.doNextProcess(orderid);
	}
	
	private SecondConfirmResult doReturnSuccVal(String orderid, String customName) throws Exception {
		SecondConfirmResult result = new SecondConfirmResult();
		List<String> list = new ArrayList<String>();
		StringBuffer datas = new StringBuffer();
		datas.append(orderid);
		if(customName != null)
			datas.append(SMSProtocol.WORD_SLIT_SYMBOL).append(customName);
		list.add(datas.toString());
		result.setRet(SecondConfirmResult.RET_TYPE_SUCC_0);
		result.setMessage("�ɹ�");
		result.setDatas(list);
		return result;
	}

}
