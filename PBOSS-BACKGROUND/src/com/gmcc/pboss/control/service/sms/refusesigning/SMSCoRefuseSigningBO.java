package com.gmcc.pboss.control.service.sms.refusesigning;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.business.base.sysparam.SysparamVO;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.smsconfirm.SmsconfirmDBParam;
import com.gmcc.pboss.business.sales.smsconfirm.SmsconfirmVO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.waitreq.Waitreq;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.smsconfirm.Smsconfirm;
import com.gmcc.pboss.control.sales.smsconfirm.SmsconfirmBO;
import com.gmcc.pboss.control.service.sms.ServiceSmsBOHelper;
import com.gmcc.pboss.service.sms.exception.SMSException;
import com.gmcc.pboss.service.sms.result.CoConfirmSigningResult;
import com.gmcc.pboss.service.sms.result.CoRefuseSigningResult;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.common.utils.logging.LoggingConstant;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class SMSCoRefuseSigningBO extends AbstractControlBean implements
		SMSCoRefuseSigning {

	private static Logger logger = Logger.getLogger(SMSCoRefuseSigningBO.class);
	
	public String doResult(String mobile, String streamNumber) throws Exception {
		// TODO Auto-generated method stub
		String orderid = "";
		try{
			logger = ServiceSmsBOHelper.createChildLogger(user.getCityid()+LoggingConstant.SMS_CITY_LOG_ROOT_NAME, this.getClass().getSimpleName());
			SmsconfirmVO scVO = this.updateSMSConfirmInfo(mobile, streamNumber);
			orderid = scVO.getOrderid();
			this.refuseSigningCheckIn(scVO.getOrderid());
			//���ö��ŷ��ͷ���
			this.sendMes(mobile,"����["+orderid+"]�ܾ�ǩ�ճɹ�");
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
		//scParam.set_dnl_sendtime(PublicUtils.formatUtilDate(new Date(), "yyyy-MM-dd")+" 00:00:00");
		scParam.set_orderby("sendtime"); // ��֪ͨʱ����������
		scParam.setDataOnly(true);
		scParam.set_pagesize("0");
		DataPackage dp = scBO.doQuery(scParam);
		List list = dp.getDatas();
		if(list == null || list.size() <= 0) {
			throw new SMSException("ȷ�ϼ�¼["+streamNumber+"]������",CoRefuseSigningResult.RET_TYPE_FAIL_1);
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
				throw new SMSException("����["+scVO.getOrderid()+"]ǩ�ճ�ʱ",CoRefuseSigningResult.RET_TYPE_FAIL_4);
			}
			scVO.setReptime(new Date());
			scVO.setState("REPLIED");
			scVO.setRepdesc("�ܾ�ǩ��");
			return scBO.doUpdate(scVO);
		}
	}
	
	/**
	 * �ܾ�ǩ�յǼ�
	 * @param orderid
	 * @throws Exception
	 */
	private void refuseSigningCheckIn(String orderid) throws Exception{
		
		Order orderBO = (Order)BOFactory.build(OrderBO.class, user);
		OrderVO orderVO = orderBO.doFindByPk(orderid);
		if(orderVO == null) 
			throw new SMSException("����["+orderid+"]��Ϣ������",CoRefuseSigningResult.RET_TYPE_FAIL_2);
		if(!"WAITSIGN".equals(orderVO.getSignstate()))
			throw new SMSException("����["+orderid+"]ǩ��״̬����",CoRefuseSigningResult.RET_TYPE_FAIL_3);
		orderVO.setSignstate("REFUSE");
		orderBO.doUpdate(orderVO);
	}
	
	private CoRefuseSigningResult doReturnSuccVal() throws Exception {
		CoRefuseSigningResult result = new CoRefuseSigningResult();
		result.setRet(CoRefuseSigningResult.RET_TYPE_SUCC_0);
		result.setMessage("�ɹ�");
		return result;
	}
	
	//����ʧ�ܶ���
	public void sendMes(String mobile,String contentcode) throws Exception {
		
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
		if(contentcode != null && !contentcode.equals("") && val != null && !val.equals("") && mobile != null && !mobile.equals("")){
			Waitreq  waitreqBO=(Waitreq)BOFactory.build(WaitreqBO.class,user);
			waitreqBO.doInsert3(new Short("3"), contentcode, val, mobile,new Date(System.currentTimeMillis()));			
		}
	
	}
	
}
