package com.gmcc.pboss.control.service.sms.disformfinishenrol;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.base.MdbgBase;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.resource.nosect.NosectDBParam;
import com.gmcc.pboss.business.resource.nosect.NosectVO;
import com.gmcc.pboss.business.sales.disform.DisformDBParam;
import com.gmcc.pboss.business.sales.disform.DisformVO;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.smsconfirm.SmsconfirmVO;
import com.gmcc.pboss.control.base.smstmpl.Smstmpl;
import com.gmcc.pboss.control.base.smstmpl.SmstmplBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.waitreq.Waitreq;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.resource.nosect.Nosect;
import com.gmcc.pboss.control.resource.nosect.NosectBO;
import com.gmcc.pboss.control.sales.disform.Disform;
import com.gmcc.pboss.control.sales.disform.DisformBO;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.smsconfirm.Smsconfirm;
import com.gmcc.pboss.control.sales.smsconfirm.SmsconfirmBO;
import com.gmcc.pboss.control.service.sms.ServiceSmsBOHelper;
import com.gmcc.pboss.control.service.sms.orderquery.SMSOrderQueryBO;
import com.gmcc.pboss.service.sms.exception.SMSException;
import com.gmcc.pboss.service.sms.result.DisformFinishenrolResult;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.logging.LoggingConstant;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.infrastructure.db.hibernate3.SessionFactoryContextHolder;

public class SMSDisformFinishenrolBO extends AbstractControlBean implements SMSDisformFinishenrol{
	private static Logger logger = Logger.getLogger(SMSDisformFinishenrolBO.class);
	
	
	public String doResult(String mobile, String orderID) throws Exception {
		// TODO Auto-generated method stub
		try{
			logger = ServiceSmsBOHelper.createChildLogger(user.getCityid()
					+ LoggingConstant.SMS_CITY_LOG_ROOT_NAME, this.getClass()
					.getSimpleName());
//			2	��ȡ��������Ϣ(����ID)
			String wayid = this.doGetWayId(mobile);
//			3.�޸����͵�
			DisformVO disformVO = this.doUpdatDisForm(orderID, wayid);
//			4.�ǼǶ���ȷ�ϼ�¼
			this.doSmsConfirm(orderID, disformVO.getRecetel());
//			 5��	֪ͨ������ǩ��
			this.doAskSign(disformVO.getRecetel(), disformVO.getRecename(), orderID);
			
			DisformFinishenrolResult result = new DisformFinishenrolResult();
			List<String> list = new ArrayList<String>();
			list.add(orderID);
			result.setRet(DisformFinishenrolResult.RET_TYPE_SUCC_0);
			result.setMessage("�ɹ�");
			result.setDatas(list);
			return result.toString();
		}catch(SMSException e){
			LoggerUtils.error(e, logger);
			throw e;
		}catch(Exception e){
			LoggerUtils.error(e, logger);
			throw e;
		}
	}

	
	/*
	 *1 . ��ȡ�����������
	 * ����������򷵻أ�������ȡ��1����˵��ȡ����ȡ�����������ʧ�ܡ���
	 * ������ڶ���������ȡ��һ����������������ֶ�
	 * ����BOSSAREA��������ĸ��д���硰GZ����������ȷ�����п�ʹ�á�
	 */
	public String doGetBossArea(String mobile) throws Exception{
		Nosect nosect = (Nosect)BOFactory.build(NosectBO.class, user);
		NosectDBParam nosectDBParam = new NosectDBParam();
		nosectDBParam.setDataOnly(true);
		nosectDBParam.set_snm_beginno(mobile);
		nosectDBParam.set_snl_endno(mobile);
		DataPackage nosectDp = nosect.doQuery(nosectDBParam);
		if(nosectDp.getDatas().size() == 0){
			throw new SMSException("��ȡ�����������ʧ��",DisformFinishenrolResult.RET_TYPE_FAIL_1);
		}
		NosectVO nosectVO = (NosectVO)nosectDp.getDatas().get(0);
		return nosectVO.getBossarea();
	}
	
	/*
	 * 2	��ȡ��������Ϣ(����ID)
	 * ��ѯ������Ա������Ϣ��(CH_PW_EMPLOYEE)��ƥ�乫������루OFFICETEL�����ں��롢
	 * �ù�״̬����0����EMPSTATUS=0�����Ƿ�Ϊ�����ֶ�Ϊ���ͣ���ISNET=3��������������򷵻أ�������ȡ��1����˵��ȡ������δ�Ǽǡ���
	 * ������ڶ���������ȡ��һ������¼�������롣
	 */
	public String doGetWayId(String mobile) throws Exception{
		Employee employee = (Employee)BOFactory.build(EmployeeBO.class, user);
		EmployeeDBParam employeeDBParam = new EmployeeDBParam();
		employeeDBParam.setDataOnly(true);
		employeeDBParam.set_se_officetel(mobile);
		employeeDBParam.set_ne_empstatus("0");
		employeeDBParam.set_ne_isnet("3");//�Ƿ�Ϊ�����ֶ�Ϊ���ͣ���ISNET=3��added by yde
		DataPackage dp = employee.doQuery(employeeDBParam);
		if(dp.getDatas().size() == 0){
			throw new SMSException("����δ�Ǽ�",DisformFinishenrolResult.RET_TYPE_FAIL_1);
		}
		EmployeeVO vo = (EmployeeVO)dp.getDatas().get(0);
		return vo.getWayid();
	}
	
	/*
	 * 3.�޸����͵�
	 * �������͵�
	 */
	public DisformVO doUpdatDisForm(String orderID,String wayid) throws Exception{
//		���ݶ�����š������̱��루���������룩��ѯ���͵���FX_SW_DISFORM)����
//		����������򷵻أ�������ȡ��2����˵��ȡ�����͵���Ϣ�����ڡ������������
//		������͵����ݴ���һ����¼�򷵻أ�������ȡ��3����˵��ȡ�����͵���Ϣ���󡱣����������
		Disform disformBO = (DisformBO) BOFactory.build(DisformBO.class,user);
		DisformDBParam disformParam = new DisformDBParam();
		disformParam.setDataOnly(true);
		disformParam.set_se_discomcode(wayid);
		disformParam.set_se_orderid(orderID);
		DataPackage dp = disformBO.doQuery(disformParam);
		if( null == dp || null == dp.getDatas() ||dp.getDatas().size() < 1)
			throw new SMSException("���͵���Ϣ������",DisformFinishenrolResult.RET_TYPE_FAIL_2);
		if(dp.getDatas().size()>1)
			throw new SMSException("���͵���Ϣ����",DisformFinishenrolResult.RET_TYPE_FAIL_3);
		
//		�ж����͵�״̬�Ƿ�Ϊ��������ɡ���������򷵻أ�������ȡ��5����
//		˵��ȡ�����͵�����ɵǼǣ������ظ��Ǽǡ��������������
		DisformVO disformVO = (DisformVO)dp.getDatas().get(0);
		if("DISOVER".equals(disformVO.getDisstate()))
			throw new SMSException("���͵�����ɵǼǣ������ظ��Ǽ�",DisformFinishenrolResult.RET_TYPE_FAIL_5);
//		�ж����͵�״̬�Ƿ�Ϊ�������͡��������С�����������򷵻أ�
//		������ȡ��4����˵��ȡ������״̬���󡱣����������
//		�����͵�״̬�޸�Ϊ��������ɡ���
		if("WAITDIS".equals(disformVO.getDisstate()) || "DISING".equals(disformVO.getDisstate())){
			disformVO.setDisstate("DISOVER");
			disformBO.doUpdate(disformVO);
			OrderBO orderbo = (OrderBO)BOFactory.build(OrderBO.class,user);
			OrderVO ordervo = orderbo.doFindByPk(orderID);
			if(ordervo != null){
				ordervo.setDisovertime(new Date());
				orderbo.doUpdate(ordervo);
			}
		}else{
			throw new SMSException("����״̬����",DisformFinishenrolResult.RET_TYPE_FAIL_4);
		}
		return disformVO;
	}

	/*
	 * 4��	�ǼǶ���ȷ�ϼ�¼
	 */
	public void doSmsConfirm(String orderID,String recPhone) throws Exception {
//		�������ݵ���������ȷ�ϱ�FX_SW_SMSCONFIRM�������ȡ������У�����ȡ������ǩ��
//		��ȷ����ˮ��ȡ����ĩβ4λ���ֻ�����ȡ���͵��е��ջ��˵绰������������ȡ������ţ�
//		״̬ȡ���ظ���֪ͨʱ��ȡ��ǰʱ�䣬�ظ�ʱ��ͻظ��������ա�
		String subOrderID = orderID.substring(orderID.length()-4);
		Smsconfirm smsconfirmBO = (SmsconfirmBO) BOFactory.build(SmsconfirmBO.class,user);
		SmsconfirmVO vo = new SmsconfirmVO();
		vo.setOrderid(orderID);
		vo.setStream(subOrderID);
		vo.setType("PARSIGN");
		vo.setMobileno(recPhone);
		vo.setState("WAITREP");
		vo.setSendtime(new Date());
		smsconfirmBO.doCreate(vo);
	}
	
	
	/*
	 * 5��	֪ͨ������ǩ��
	 * �������ݵ����Ŵ����ͱ�(CH_SMS_WAITREQ)���ֶ�ȡֵ���£���������ȡ3��
		���ͺ��룺��ѯϵͳ�������ñ�IB_GL_SYSPARAM����ƥ���������Ϊ��pboss_fx����
		������ʶΪ��42�������ͺ���ȡ����ֵ�����պ��룺ȡ���͵��е��ջ��˵绰��
		�������ݣ�������Ʒ�������Ź��÷�����������ǩ��ȷ�ϣ���ȡ���ͻ�����ȡ���͵��е��ջ�������
		��������ݻ�����Ϊ�գ���Ĭ��ȡ���ͻ���������ȡ��ǰʱ�䣻
		ȷ����ˮ��ȡ����ĩβ��λ��
		˵����������ͺ��롢���պ�������������һ��Ϊ�գ��ɲ����Ͷ���֪ͨ��
	 */
	public void doAskSign(String recPhone,String recUser,String orderID) throws Exception{
		if(null == recPhone || recPhone.trim().length() == 0)
			return;
		String subOrderID = orderID.substring(orderID.length()-4);
		Sysparam SysparamBO = (SysparamBO) BOFactory.build(SysparamBO.class,user);
		String sendPhone = SysparamBO.doFindByID("42", "pboss_fx");
		if( null == sendPhone || sendPhone.trim().length() == 0)
			return;
		String smsContent = "";
		if(null == recUser || recUser.trim().length() == 0)
			recUser = "�ͻ�";
		
//		�𾴵�{CUSTNAME}��{YEAR}��{MONTH}��{DAY}�����͵����ʣ������ţ�{ ORDERID }��
//		�Ƿ��յ����ظ�"Q{STREAM}"ȷ��ǩ�գ��ظ�"N{STREAM}"�ܾ�ǩ�ա��㶫�ƶ���
		Calendar calendar = Calendar.getInstance();		
		Map<String,String> map = new HashMap<String,String>();
		map.put("CUSTNAME", recUser);
		map.put("YEAR", ""+calendar.get(Calendar.YEAR));
		map.put("MONTH", calendar.get(Calendar.MONTH)+1+"");
		map.put("DAY", ""+calendar.get(Calendar.DAY_OF_MONTH));
		map.put("ORDERID", orderID);
		map.put("STREAM", subOrderID);
		Smstmpl smstmplBO = (SmstmplBO)BOFactory.build(SmstmplBO.class,user);
		smsContent = smstmplBO.doGenSMS("FX_ORDER_PARSIGNCON", map);
		if( null == smsContent || "".equals(smsContent.trim()))
			return ;
		Waitreq  waitreqBO = (WaitreqBO) BOFactory.build(WaitreqBO.class,user);
		waitreqBO.doInsert2(new Short("3"), smsContent, sendPhone,recPhone);

	}
	
}


