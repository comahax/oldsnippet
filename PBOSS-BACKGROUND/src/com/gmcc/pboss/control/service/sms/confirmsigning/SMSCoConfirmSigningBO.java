package com.gmcc.pboss.control.service.sms.confirmsigning;

import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.business.base.sysparam.SysparamVO;
import com.gmcc.pboss.business.sales.disform.DisformDBParam;
import com.gmcc.pboss.business.sales.disform.DisformVO;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.smsconfirm.SmsconfirmDBParam;
import com.gmcc.pboss.business.sales.smsconfirm.SmsconfirmVO;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantVO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.waitreq.Waitreq;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.sales.disform.Disform;
import com.gmcc.pboss.control.sales.disform.DisformBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.smsconfirm.Smsconfirm;
import com.gmcc.pboss.control.sales.smsconfirm.SmsconfirmBO;
import com.gmcc.pboss.control.sales.wayassistant.WayassistantBO;
import com.gmcc.pboss.control.service.sms.ServiceSmsBOHelper;
import com.gmcc.pboss.service.sms.exception.SMSException;
import com.gmcc.pboss.service.sms.result.CoConfirmSigningResult;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.logging.LoggingConstant;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class SMSCoConfirmSigningBO extends AbstractControlBean implements
		SMSCoConfirmSigning {
	private static Logger logger = Logger.getLogger(SMSCoConfirmSigningBO.class);

	public String doResult(String mobile, String streamNumber) throws Exception {
		// TODO Auto-generated method stub
		String orderid = "";
		try {
			logger = ServiceSmsBOHelper.createChildLogger(user.getCityid()
					+ LoggingConstant.SMS_CITY_LOG_ROOT_NAME, this.getClass()
					.getSimpleName());
			SmsconfirmVO scVO = this.updateSMSConfirmInfo(mobile, streamNumber);
			orderid = scVO.getOrderid();
			this.signingConfirm(scVO.getOrderid(), mobile);
			this.noteLogsSms(scVO.getOrderid());
			this.confirmOrder(scVO.getOrderid());
			//���ö��ŷ��ͷ���
			this.sendMes(mobile,"����["+orderid+"]ǩ�ճɹ�");
			
			return this.doReturnSuccVal().toString();
		}catch(SMSException e) {
			// SMSException ����Ҫ�ع�����
			logger.info(e.getMessage());
			//���ö��ŷ��ͷ���
			this.sendMes(mobile,e.getMessage());
			
			return ((SMSException)e).getErrCode() + SMSProtocol.WORD_SLIT_SYMBOL + ((SMSException)e).getMessage() + SMSProtocol.WORD_END_SYMBOL;
		}catch(Exception e) {
			LoggerUtils.error(e, logger);
			throw new SMSException("ʧ��",CoConfirmSigningResult.RET_TYPE_FAIL_111);
		}
	}
	
	/**
	 * ���¶���ȷ����Ϣ
	 * @param mobile
	 * @param streamNumber
	 * @return ֪ͨʱ��
	 * @throws Exception
	 */
	private SmsconfirmVO updateSMSConfirmInfo(String mobile, String streamNumber) throws Exception {
		
		Smsconfirm scBO = (Smsconfirm)BOFactory.build(SmsconfirmBO.class,user);
		SmsconfirmDBParam scParam = new SmsconfirmDBParam();
		scParam.set_se_type("PARSIGN");
		scParam.set_se_mobileno(mobile);
		scParam.set_se_stream(streamNumber);
		scParam.set_se_state("WAITREP");
//		scParam.set_dnl_sendtime(PublicUtils.formatUtilDate(new Date(), "yyyy-MM-dd")+" 00:00:00");
		scParam.set_orderby("sendtime"); // ��֪ͨʱ����������
		scParam.setDataOnly(true);
		scParam.set_pagesize("0");
		DataPackage dp = scBO.doQuery(scParam);
		List list = dp.getDatas();
		if(list == null || list.size() <= 0) {
			throw new SMSException("ȷ�ϼ�¼["+streamNumber+"]������",CoConfirmSigningResult.RET_TYPE_FAIL_1);
		}else {
			SmsconfirmVO scVO = (SmsconfirmVO)list.get(0); // ȡ֪ͨʱ�������һ��
			
//			ǩ����Ч��������ѯϵͳ�������ñ�ƥ���������Ϊ��pboss_fx����������ʶΪ��81������������ݻ����ֵ��1-30����������Ĭ��ȡֵΪ1��
			Sysparam sybo = (Sysparam) BOFactory.build(SysparamBO.class,user);
			SysparamVO sysvo = new SysparamVO();
			sysvo.setSystemid(new Long("81"));
			sysvo.setParamtype("pboss_fx");
			SysparamVO newsysvo = sybo.doFindByPk(sysvo);
			String val = "";
			int days ;
			if (newsysvo == null) {
				days = 1;
			}else{
				try{
					val = newsysvo.getParamvalue();
					days = Integer.parseInt(val);
					if(days > 30 || days < 1){
						days = 1;
					}
				}catch(Exception e){
					days = 1;
				}
				
			}
			
//			�жϵ�ǰ����-֪ͨʱ������ �Ƿ����ǩ����Ч���������������Ч������������ȡ��5����˵��ȡ������[XXX]ǩ�ճ�ʱ�����������
			long da = (new Date(System.currentTimeMillis()).getTime()-scVO.getSendtime().getTime())/(1000 * 60 * 60 * 24);

			if(da > days){
				throw new SMSException("����["+scVO.getOrderid()+"]ǩ�ճ�ʱ",CoConfirmSigningResult.RET_TYPE_FAIL_5);
			}
			
			scVO.setReptime(new Date());
			scVO.setState("REPLIED");
			scVO.setRepdesc("ȷ��ǩ��");
			return scBO.doUpdate(scVO);
		}
	}
	
	/**
	 * ǩ��ȷ��
	 * @param orderid
	 * @throws Exception
	 */
	private void signingConfirm(String orderid, String mobile) throws Exception {
		
		Order orderBO = (Order)BOFactory.build(OrderBO.class, user);
		OrderVO orderVO = orderBO.doFindByPk(orderid);
		if(orderVO == null) 
			throw new SMSException("����["+orderid+"]��Ϣ������",CoConfirmSigningResult.RET_TYPE_FAIL_2);
		if("SIGNED".equals(orderVO.getSignstate())) 
			throw new SMSException("����["+orderid+"]��ǩ�գ������ظ�ȷ��",CoConfirmSigningResult.RET_TYPE_FAIL_3);
		if(!"WAITSIGN".equals(orderVO.getSignstate()))
			throw new SMSException("����["+orderid+"]ǩ��״̬����",CoConfirmSigningResult.RET_TYPE_FAIL_4);
		orderVO.setSignstate("SIGNED");
		orderVO.setSigntime(new Date());
		orderVO.setSigntype("SMS");
		orderVO.setSmssignno(mobile);
		
		orderBO.doUpdate(orderVO);
		
		// ��������Ϊ"pboss_fx"��������ʶΪ"84"���������ֵΪ1ʱ�ж��Ƿ�ɷ��𶩹�
		this.doUpdateWayassistant(orderVO);
	}
	
	/**
	 * �������֪ͨ������
	 * @param orderid
	 * @throws Exception
	 */
	private void noteLogsSms(String orderid) throws Exception {
		
		// ��ѯϵͳ�������ñ�IB_GL_SYSPARAM��ƥ���������Ϊ��pboss_fx����������ʶΪ��76��
		Sysparam sybo = (Sysparam) BOFactory.build(SysparamBO.class,user);
		SysparamVO sysvo = new SysparamVO();
		sysvo.setSystemid(new Long("76"));
		sysvo.setParamtype("pboss_fx");
		SysparamVO newsysvo = sybo.doFindByPk(sysvo);		
		// ϵͳ���������˲�����ֵΪ1��ʱ���������֪ͨ������
		if (newsysvo !=null && "1".equals(newsysvo.getParamvalue())) {
				
			// ȡ������Ϣ
			Disform disbo = (Disform)BOFactory.build(DisformBO.class,user);
			DisformDBParam disparam = new DisformDBParam();
			disparam.set_se_orderid(orderid);
			DataPackage dp = disbo.doQuery(disparam);
			List list = dp.getDatas();
			if(list == null || list.size() <= 0) {
			} else {
				DisformVO disvo = (DisformVO)list.get(0); //ȡ��һ������
				disbo.doComfirmSignMsg(disvo); // ����ǰ̨������ȷ�Ϲ�ͨ����
			}
		}		
	}
	
	/**
	 * ǩ�պ��Զ�����
	 * @param orderid
	 * @throws Exception
	 */
	private void confirmOrder (String orderid) throws Exception {
		// ��ѯϵͳ�������ñ�IB_GL_SYSPARAM��ƥ���������Ϊ��pboss_fx����������ʶΪ��76��
		Sysparam sybo = (Sysparam) BOFactory.build(SysparamBO.class,user);
		SysparamVO sysvo = new SysparamVO();
		sysvo.setSystemid(new Long("77"));
		sysvo.setParamtype("pboss_fx");
		SysparamVO newsysvo = sybo.doFindByPk(sysvo);
		
		// ����ֵΪ1ʱ����¶�����Ķ���״̬Ϊ����ǩ�ա���Ȼ����á�������һ�������÷�����
		if (newsysvo!=null && "1".equals(newsysvo.getParamvalue())) {
			Order bo = (Order)BOFactory.build(OrderBO.class, user);
			OrderVO vo = bo.doFindByPk(orderid);
			// ����ǩ�պ��Զ����˹�ͨ����
			Disform disbo = (Disform)BOFactory.build(DisformBO.class,user);
			disbo.doUpdateOrderState(vo);
		}		
	}
	
	private CoConfirmSigningResult doReturnSuccVal() throws Exception {
		CoConfirmSigningResult result = new CoConfirmSigningResult();
		result.setRet(CoConfirmSigningResult.RET_TYPE_SUCC_0);
		result.setMessage("�ɹ�");
		return result;
	}
	
	//����ʧ�ܶ���
	public void sendMes(String mobile,String content) throws Exception {
		
		
//		�������ݵ����Ŵ����ͱ�(CH_SMS_WAITREQ)���ֶ�ȡֵ���£�
//		��������ȡ3��
//		���ͺ��룺��ѯϵͳ�������ñ�IB_GL_SYSPARAM����ƥ���������Ϊ��pboss_fx����������ʶΪ��42�������ͺ���ȡ����ֵ��
		Sysparam sybo = (Sysparam) BOFactory.build(SysparamBO.class,user);
		SysparamVO sysvo = new SysparamVO();
		sysvo.setSystemid(new Long("42"));
		sysvo.setParamtype("pboss_fx");
		SysparamVO newsysvo = sybo.doFindByPk(sysvo);
		String val = "";
		if (newsysvo!=null) {
			val = newsysvo.getParamvalue();
		}
		
//		���պ��룺�ֻ����������
//		�������ݣ�ȡ���淵�ص�˵����
		if(content != null && !content.equals("") && val != null && !val.equals("") && mobile != null && !mobile.equals("")){
		Waitreq  waitreqBO=(Waitreq)BOFactory.build(WaitreqBO.class,user);
		
		waitreqBO.doInsert3(new Short("3"), content, val, mobile,new Date(System.currentTimeMillis()));
		}
		
	}

	/**
	 * ��ѯϵͳ�������ñ�(IB_GL_SYSPARAM)��ƥ���������Ϊ"pboss_fx"��������ʶΪ"84"��
	 * �������ֵΪ1ʱ����ݶ������ȡ�ö�����(fx_sw_order)�е�������
	 * �������������ѯ��Ʒ����������Ϣ�� (FX_RU_WAYASSISTANT)��
	 * �ж��Ƿ�ɷ��𶩹�ֵ�Ƿ�Ϊ"1"����Ϊ"1"���޸ĳ�1
	 */
    public void doUpdateWayassistant(OrderVO ordervo) throws Exception {
		Sysparam sysparamBO = (SysparamBO) BOFactory.build(SysparamBO.class, user);
		String sysvalue = sysparamBO.doFindByID(new Long("84"), "pboss_fx");
		if (sysvalue != null && "1".equals(sysvalue)) {
			WayassistantBO assistantbo = (WayassistantBO) BOFactory.build(WayassistantBO.class, user);
			WayassistantVO assistantvo = assistantbo.doFindByPk(ordervo.getWayid());
			if (assistantvo.getCanorder() != 1) {
				assistantvo.setCanorder(new Short("1"));
				assistantbo.doUpdate(assistantvo);
			}
		}
	}
}
