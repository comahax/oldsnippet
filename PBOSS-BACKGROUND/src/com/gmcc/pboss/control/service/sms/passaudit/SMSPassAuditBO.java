package com.gmcc.pboss.control.service.sms.passaudit;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.business.sales.audit.AuditVO;
import com.gmcc.pboss.business.sales.smsconfirm.SmsconfirmDBParam;
import com.gmcc.pboss.business.sales.smsconfirm.SmsconfirmVO;
import com.gmcc.pboss.control.sales.audit.Audit;
import com.gmcc.pboss.control.sales.audit.AuditBO;
import com.gmcc.pboss.control.sales.smsconfirm.Smsconfirm;
import com.gmcc.pboss.control.sales.smsconfirm.SmsconfirmBO;
import com.gmcc.pboss.control.service.sms.ServiceSmsBOHelper;
import com.gmcc.pboss.service.sms.exception.SMSException;
import com.gmcc.pboss.service.sms.result.PassAuditResult;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.common.utils.logging.LoggingConstant;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class SMSPassAuditBO extends AbstractControlBean implements
	SMSPassAudit {
	private static Logger logger = Logger.getLogger(SMSPassAuditBO.class);

	public String doPassAudit(String mobile, String streamNumber)
			throws Exception {
		// TODO Auto-generated method stub
		try {
			logger = ServiceSmsBOHelper.createChildLogger(user.getCityid()
					+ LoggingConstant.SMS_CITY_LOG_ROOT_NAME, this.getClass()
					.getSimpleName());
			// 1.��ȡ��������
			//String cityid = doGetBossArea(mobile);
			
			// 2.���¶���ȷ����Ϣ
			SmsconfirmVO scVO = updateMessage(mobile, streamNumber);
			
			// 3.���ͨ��
			doPass(scVO.getOrderid());
			// 4�� ���ض���Ӫҵ��:������ȡ��0����˵��ȡ���ɹ�����
			return doReturnSuccVal().toString();

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
	 * 2�� ���¶���ȷ����Ϣ
	 * �������ͣ����ȷ�ϣ����ֻ����롢��ˮ�š�״̬�����ظ�����֪ͨʱ�䣨���ڵ��ڵ�����ʱ������룩��ѯ��������ȷ�ϱ�FX_SW_SMSCONFIRM��������������򷵻أ�������ȡ��1����˵��ȡ����¼�����ڡ������������
	 * �����������ж�������ȡ֪ͨʱ�������һ�������·�������ȷ�ϱ��ظ�ʱ��ȡ��ǰʱ�䣬״̬�޸�Ϊ�ѻظ����ظ�������д�����ͨ������
	 * 
	 * @throws Exception
	 */
	public SmsconfirmVO updateMessage(String mobile, String streamNumber) throws Exception {
		Smsconfirm smsconfirm = (Smsconfirm) BOFactory.build(
				SmsconfirmBO.class, user);
		SmsconfirmDBParam param = new SmsconfirmDBParam();
		param.set_se_mobileno(mobile);
		param.set_se_stream(streamNumber);
		param.set_se_state("WAITREP");
		param.set_se_type("AUDITCON");
		param.set_dnl_sendtime(PublicUtils.formatUtilDate(new Date(),
			"yyyy-MM-dd")
			+ " 00:00:00");
		param.set_dnm_sendtime(PublicUtils.formatUtilDate(new Date(),
				"yyyy-MM-dd")
				+ " 23:59:59");
		// sendtime ֪ͨʱ��
		param.set_orderby("sendtime");
		param.setDataOnly(true);
		param.set_pagesize("0");
		param.set_desc("1");//����
		DataPackage dp = smsconfirm.doQuery(param);
		List list = dp.getDatas();
		if (list == null || list.size() == 0) {
			String message = "ȷ�ϼ�¼������";
			throw new SMSException(message, PassAuditResult.RET_TYPE_FAIL_1);
		} else {
			SmsconfirmVO scVO = (SmsconfirmVO) list.get(0); // ȡ֪ͨʱ�������һ��
			scVO.setReptime(new Date());
			scVO.setState("REPLIED");
			scVO.setRepdesc("���ͨ��");
			return smsconfirm.doUpdate(scVO);
		}

	}

	/**
	 * 3�� ���ͨ�� ���������ţ�ȡ�����������ֶΣ���ѯ����������˱�[FX_SW_AUDIT]������������򷵻أ�������ȡ��1����˵��ȡ ����˼�¼�����ڡ������������
			�ж����״̬�Ƿ�Ϊ��ͨ������������򷵻أ�������ȡ��2����˵�����Ѿ����ͨ���������ٴ���ˡ������������
			���¶�����˱�[FX_SW_AUDIT]��Ӧ��Ϣ�����ʱ��ȡ��ǰʱ�䣬������ȡ��ͨ���������״̬ȡ��ͨ��[1]������¼���������־��
	 * 
	 * @throws Exception
	 */
	public void doPass(String orderid) throws Exception {
		//���������ţ�ȡ�����������ֶΣ���ѯ����������˱�[FX_SW_AUDIT] FX_SW_SMSCONFIRM�е�orderid������˱��е�����ֶ�
		Audit audit = (Audit)BOFactory.build(AuditBO.class, user);
		AuditVO auditVO = new AuditVO();
		auditVO = audit.doFindByPk(Long.parseLong(orderid));
		if (auditVO == null) {
			throw new SMSException("��˼�¼������",PassAuditResult.RET_TYPE_FAIL_1);
		}
		// ���״̬
		if ("1".equals(auditVO.getState())) {
			throw new SMSException("�Ѿ����ͨ���������ٴ����",PassAuditResult.RET_TYPE_FAIL_2);
		}
		// ������˱�
		auditVO.setState("1");
		auditVO.setAudittime(new Date());
		auditVO.setOpinion("ͨ��");
		audit.doUpdate(auditVO);
	}

	private PassAuditResult doReturnSuccVal()
			throws Exception {
		PassAuditResult result = new PassAuditResult();
		result.setRet(PassAuditResult.RET_TYPE_SUCC_0);
		result.setMessage("�ɹ�");
		return result;
	}
}
