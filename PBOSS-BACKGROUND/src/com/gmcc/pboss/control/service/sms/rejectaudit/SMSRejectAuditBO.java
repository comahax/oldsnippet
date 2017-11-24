package com.gmcc.pboss.control.service.sms.rejectaudit;

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
import com.gmcc.pboss.service.sms.result.RejectAuditResult;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.common.utils.logging.LoggingConstant;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class SMSRejectAuditBO extends AbstractControlBean implements
		SMSRejectAudit {
	private static Logger logger = Logger.getLogger(SMSRejectAuditBO.class);

	public String doRejectAudit(String mobile, String streamNumber)
			throws Exception {
		// TODO Auto-generated method stub
		try {
			logger = ServiceSmsBOHelper.createChildLogger(user.getCityid()
					+ LoggingConstant.SMS_CITY_LOG_ROOT_NAME, this.getClass()
					.getSimpleName());
			// 1.获取归属地市
			//String cityid = doGetBossArea(mobile);
			
			// 2.更新短信确认信息
			SmsconfirmVO scVO = updateMessage(mobile, streamNumber);
			
			// 3.审核不通过
			doReject(scVO.getOrderid());
			// 4、 返回短信营业厅:返回码取“0”，说明取“成功”。
			return doReturnSuccVal().toString();

		} catch (SMSException e) {
			// SMSException 不需要回滚事务
			logger.info(e.getMessage());
			return ((SMSException) e).getErrCode()+ SMSProtocol.WORD_SLIT_SYMBOL+ ((SMSException) e).getMessage()+ SMSProtocol.WORD_END_SYMBOL;
		} catch (Exception e) {
			LoggerUtils.error(e, logger);
			throw e;
		}

	}

	/*
	 * 1、 获取号码归属地市 根据号码查询号段表(IM_PR_NOSECT)获取地市标识，查询SQL大致如下： select BOSSAREA from
	 * IM_PR_NOSECT where '13800138000' between beginno and endno;
	 * 如果无数据则返回，返回码取“1”，说明取“获取号码归属地市失败”，订单号留空，客户名称默认取“客户”；如果存在多条数据则取第一条。保存归属地市字段（即BOSSAREA，地市字母缩写，如“GZ”），后续确定地市库使用。
	 */
	public String doGetBossArea(String mobile) throws Exception {
		return ServiceSmsBOHelper.getMobileArea(mobile, user);
	}


	/**
	 * 2、 更新短信确认信息
	 * 根据类型（审核确认）、手机号码、流水号、状态（待回复）、通知时间（大于等于当天零时零分零秒）查询分销短信确认表（FX_SW_SMSCONFIRM），如果无数据则返回，返回码取“1”，说明取“记录不存在”；否则继续。
	 * 如果结果数据有多条，则取通知时间最晚的一条，更新分销短信确认表，回复时间取当前时间，状态修改为已回复，回复描述填写“审核通过”。
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
		// sendtime 通知时间
		param.set_orderby("sendtime");
		param.setDataOnly(true);
		param.set_pagesize("0");
		param.set_desc("1");//降序
		DataPackage dp = smsconfirm.doQuery(param);
		List list = dp.getDatas();
		if (list == null || list.size() == 0) {
			String message = "确认记录不存在";
			throw new SMSException(message, RejectAuditResult.RET_TYPE_FAIL_1);
		} else {
			SmsconfirmVO scVO = (SmsconfirmVO) list.get(0); // 取通知时间最晚的一条
			scVO.setReptime(new Date());
			scVO.setState("REPLIED");
			scVO.setRepdesc("审核不通过");
			return smsconfirm.doUpdate(scVO);
		}

	}

	/**
	 * 3、 审核不通过 根据审核序号（取关联订单号字段）查询订单订单审核表[FX_SW_AUDIT]，如果无数据则返回，返回码取“1”，说明取 “审核记录不存在”；否则继续；
			判断审核状态是否为“通过”，如果是则返回，返回码取“2”，说明“已经审核通过，不能再次审核”；否则继续；
			判断审核状态是否为“未通过”，如果是则返回，返回码取“3”，说明“已经审核不通过，请勿重复执行”；否则继续；
			更新订单审核表[FX_SW_AUDIT]对应信息，审核时间取当前时间，审核意见取“通过”，审核状态取“通过[1]”。记录订单审核日志。
	 * 
	 * @throws Exception
	 */
	public void doReject(String orderid) throws Exception {
		//根据审核序号（取关联订单号字段）查询订单订单审核表[FX_SW_AUDIT] FX_SW_SMSCONFIRM中的orderid即是审核表中的序号字段
		Audit audit = (Audit)BOFactory.build(AuditBO.class, user);
		AuditVO auditVO = new AuditVO();
		auditVO = audit.doFindByPk(Long.parseLong(orderid));
		if (auditVO == null) {
			throw new SMSException("审核记录不存在",PassAuditResult.RET_TYPE_FAIL_1);
		}
		// 审核状态
		if ("1".equals(auditVO.getState())) {
			throw new SMSException("已经审核通过，不能再次审核",RejectAuditResult.RET_TYPE_FAIL_2);
		}
		if ("2".equals(auditVO.getState())) {
			throw new SMSException("已经审核不通过，请勿重复执行",RejectAuditResult.RET_TYPE_FAIL_3);
		}
		// 更新审核表
		auditVO.setState("2");
		auditVO.setAudittime(new Date());
		auditVO.setOpinion("不通过");
		audit.doUpdate(auditVO);
	}

	private RejectAuditResult doReturnSuccVal()
			throws Exception {
		RejectAuditResult result = new RejectAuditResult();
		result.setRet(RejectAuditResult.RET_TYPE_SUCC_0);
		result.setMessage("成功");
		return result;
	}
}
