package com.gmcc.pboss.control.service.sms.cancelbook;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.smsconfirm.SmsconfirmDBParam;
import com.gmcc.pboss.business.sales.smsconfirm.SmsconfirmVO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.smsconfirm.Smsconfirm;
import com.gmcc.pboss.control.sales.smsconfirm.SmsconfirmBO;
import com.gmcc.pboss.control.service.sms.ServiceSmsBOHelper;
import com.gmcc.pboss.service.sms.exception.SMSException;
import com.gmcc.pboss.service.sms.result.CancelBookResult;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.common.utils.logging.LoggingConstant;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class SMSCancelBookBO extends AbstractControlBean implements
		SMSCancelBook {
	private static Logger logger = Logger.getLogger(SMSCancelBookBO.class);
	private static String TITLE_COLUMNSIZE = "������"
			+ SMSProtocol.WORD_SLIT_SYMBOL + "�ͻ�����"
			+ SMSProtocol.WORD_END_SYMBOL + "20" + SMSProtocol.WORD_SLIT_SYMBOL
			+ "30";

	public String doCancelBook(String mobile, String streamNumber)
			throws Exception {
		// TODO Auto-generated method stub
		try {
			logger = ServiceSmsBOHelper.createChildLogger(user.getCityid()
					+ LoggingConstant.SMS_CITY_LOG_ROOT_NAME, this.getClass()
					.getSimpleName());
			// 1.��ȡ��������,�Ѿ��������������õ�

			// 2.��ȡ�û�����
			String employeename = doGetUserName(mobile);
			// 3.���¶���ȷ����Ϣ
			SmsconfirmVO scVO = updateMessage(mobile, streamNumber,
					employeename);
			// 4��ʱ���
			doTimeout(scVO.getSendtime(), employeename);
			// 5����ȷ��
			doConfim(scVO.getOrderid(), employeename);
			// 6�� ���ض���Ӫҵ��:������ȡ��0����˵��ȡ���ɹ�����
			return doReturnSuccVal(scVO.getOrderid(), employeename).toString();

		} catch (SMSException e) {
			// SMSException ����Ҫ�ع�����
			logger.info(e.getMessage());
			return ((SMSException) e).getErrCode()+ SMSProtocol.WORD_SLIT_SYMBOL+ ((SMSException) e).getMessage()+ SMSProtocol.WORD_END_SYMBOL;
		} catch (Exception e) {
			LoggerUtils.error(e, logger);
			throw e;
		}

	}

	/*
	 * 1�� ��ȡ����������� ���ݺ����ѯ�Ŷα�(IM_PR_NOSECT)��ȡ���б�ʶ����ѯSQL�������£� select BOSSAREA from
	 * IM_PR_NOSECT where '13800138000' between beginno and endno;
	 * ����������򷵻أ�������ȡ��1����˵��ȡ����ȡ�����������ʧ�ܡ������������գ��ͻ�����Ĭ��ȡ���ͻ�����������ڶ���������ȡ��һ����������������ֶΣ���BOSSAREA��������ĸ��д���硰GZ����������ȷ�����п�ʹ�á�
	 */
	public String doGetBossArea(String mobile) throws Exception {
		return ServiceSmsBOHelper.getMobileArea(mobile, user);
	}

	/**
	 * 2�� ��ȡ�ͻ�����
	 * ��ѯ������Ա������Ϣ��(CH_PW_EMPLOYEE)��ƥ�乫������루OFFICETEL�������ֻ����롢�ù�״̬Ϊ�ڸڣ���EMPSTATUS=0�����Ƿ�Ϊ�����ֶ�Ϊ�ǣ���ISNET=1����
	 * �ͻ�����ȡ�����ֶΣ���������ݻ�����Ϊ�գ���Ĭ��ȡ���ͻ�����
	 * 
	 * @param mobile
	 * @return
	 * @throws Exception
	 */
	public String doGetUserName(String mobile) throws Exception {
		String name = "";
		Employee employee = (Employee) BOFactory.build(EmployeeBO.class, user);
		EmployeeDBParam params = new EmployeeDBParam();
		params.set_ne_empstatus("0");
		params.set_se_officetel(mobile);
		params.set_ne_isnet("1");
		DataPackage dp = employee.doQuery(params);
		List list = dp.getDatas();
		if (list.size() > 0) {
			EmployeeVO customer = (EmployeeVO) list.get(0);
			if (!StringUtils.isEmpty(customer.getEmployeename())) {
				name = customer.getEmployeename();
			}
		} else {
			name = "�ͻ�";
		}
		return name;
	}

	/**
	 * 3�� ���¶���ȷ����Ϣ
	 * �������ͣ���������ȷ�ϣ����ֻ����롢��ˮ�š�״̬�����ظ�����֪ͨʱ�䣨���ڵ��ڵ�����ʱ������룩��ѯ��������ȷ�ϱ�FX_SW_SMSCONFIRM��������������򷵻أ�������ȡ��1����˵��ȡ����¼�����ڡ�����д�����ţ����գ��Ϳͻ����ƣ����������
	 * �����������ж�������ȡ֪ͨʱ�������һ�������·�������ȷ�ϱ��ظ�ʱ��ȡ��ǰʱ�䣬״̬�޸�Ϊ�ѻظ����ظ�������д��������������
	 * 
	 * @throws Exception
	 */
	public SmsconfirmVO updateMessage(String mobile, String streamNumber,
			String employeename) throws Exception {
		Smsconfirm smsconfirm = (Smsconfirm) BOFactory.build(
				SmsconfirmBO.class, user);
		SmsconfirmDBParam param = new SmsconfirmDBParam();
		param.set_se_mobileno(mobile);
		param.set_se_stream(streamNumber);
		// //״̬���ظ� �Ƕ���?
		param.set_se_state("WAITREP");
		// //����(��������ȷ��)?
		param.set_se_type("ORDERCON");
		param.set_dnl_sendtime(PublicUtils.formatUtilDate(new Date(),
				"yyyy-MM-dd")
				+ " 00:00:00");
		// sendtime ֪ͨʱ��
		param.set_orderby("sendtime");
		param.setDataOnly(true);
		param.set_pagesize("0");
		DataPackage dp = smsconfirm.doQuery(param);
		List list = dp.getDatas();
		if (list == null || list.size() == 0) {
			String message = "��¼������" + SMSProtocol.WORD_END_SYMBOL
					+ TITLE_COLUMNSIZE + SMSProtocol.WORD_END_SYMBOL+SMSProtocol.WORD_SLIT_SYMBOL+ employeename;
			throw new SMSException(message, CancelBookResult.RET_TYPE_FAIL_1);
		} else {
			SmsconfirmVO scVO = (SmsconfirmVO) list.get(0); // ȡ֪ͨʱ�������һ��
			scVO.setReptime(new Date());
			scVO.setState("REPLIED");
			scVO.setRepdesc("��������");
			return smsconfirm.doUpdate(scVO);
		}

	}

	/**
	 * 4�� ��ʱ���
	 * ��ȡ��ʱ����������ѯϵͳ�������ñ�IB_GL_SYSPARAM����ƥ���������Ϊ��pboss_fx����������ʶΪ��41������������ݻ����ֵ�Ǵ��������������ʱ������Ĭ��ȡֵΪ20��
	 * �ж� ��ǰʱ��-֪ͨʱ�� �Ƿ���ڳ�ʱ�������������ʱ�򷵻أ�������ȡ��2����˵��ȡ��ȷ�ϳ�ʱ������д�����ţ����գ��Ϳͻ����ƣ����������
	 * 
	 * @throws Exception 
	 */
	public void doTimeout(Date sendtime, String employeename) throws Exception {
		boolean isTimeOut;
		Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class, user);
		String paramvalue = sysparam.doFindByID("41", "pboss_fx");
		long now = System.currentTimeMillis();
		long past = sendtime.getTime();
		if (paramvalue != null) {
			isTimeOut = now - past
					- (Double.parseDouble(paramvalue) * 1000 * 60) > 0;
		} else {
			isTimeOut = now - past - (Double.parseDouble("20") * 1000 * 60) > 0;
		}
		if (isTimeOut) {
			throw new SMSException("ȷ�ϳ�ʱ" + SMSProtocol.WORD_END_SYMBOL
					+TITLE_COLUMNSIZE+ SMSProtocol.WORD_END_SYMBOL+  SMSProtocol.WORD_SLIT_SYMBOL+ employeename,
					CancelBookResult.RET_TYPE_FAIL_2);
		}
	}

	/**
	 * 5�� ����ȷ�� ���ݶ�����Ų�ѯ����������������򷵻أ�������ȡ��3����˵��ȡ��������Ϣ�����ڡ� ����д�����ţ����գ��Ϳͻ����ƣ����������
	 * ��鶩��״̬�Ƿ�Ϊ����ȷ�ϡ�����������򷵻أ�������ȡ��4����˵��ȡ������״̬���󡱣���д�����źͿͻ����ƣ����������
	 * �޸ġ�����״̬��Ϊ���ϡ���״̬���ʱ�䡱Ϊ��ǰʱ�䡢����ע��Ϊ�������������Ƿ�ȷ�ϡ�Ϊ0���񣩡�
	 * 
	 * @throws Exception
	 */
	public void doConfim(String orderid, String employeename) throws Exception {
		Order order = (Order) BOFactory.build(OrderBO.class, user);
		OrderVO orderVO = new OrderVO();
		orderVO.setOrderid(orderid);
		orderVO = order.doFindByPk(orderid);
		if (orderVO == null) {
			throw new SMSException("������Ϣ������" + SMSProtocol.WORD_END_SYMBOL
					 + TITLE_COLUMNSIZE+ SMSProtocol.WORD_END_SYMBOL+SMSProtocol.WORD_SLIT_SYMBOL+employeename,
					CancelBookResult.RET_TYPE_FAIL_3);
		}
		// $FX_ORDERFSTATE ����״̬
		if (!"WAITCON".equals(orderVO.getOrderstate())) {
			throw new SMSException("����״̬����" + SMSProtocol.WORD_END_SYMBOL
					 +TITLE_COLUMNSIZE+ SMSProtocol.WORD_END_SYMBOL+SMSProtocol.WORD_SLIT_SYMBOL+ employeename,
					CancelBookResult.RET_TYPE_FAIL_4);
		}
		// ��������
		orderVO.setOrderstate("CANCEL");
		orderVO.setStatechgtime(new Date());
		orderVO.setMemo("��������");
		orderVO.setConfirmflag(new Integer("0"));
		order.doUpdate(orderVO);
	}

	private CancelBookResult doReturnSuccVal(String orderid, String customName)
			throws Exception {
		CancelBookResult result = new CancelBookResult();
		List<String> list = new ArrayList<String>();
		StringBuffer datas = new StringBuffer();
		datas.append(orderid);
		if (customName != null)
			datas.append(SMSProtocol.WORD_SLIT_SYMBOL).append(customName);
		list.add(datas.toString());
		result.setRet(CancelBookResult.RET_TYPE_SUCC_0);
		result.setMessage("�ɹ�");
		result.setDatas(list);
		return result;
	}
}
